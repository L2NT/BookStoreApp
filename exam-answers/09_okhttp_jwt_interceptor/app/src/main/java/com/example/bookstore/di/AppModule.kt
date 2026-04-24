package com.example.bookstore.di

import android.content.Context
import com.example.bookstore.data.api.ApiService
import com.example.bookstore.data.api.AuthInterceptor
import com.example.bookstore.data.api.GoogleBooksApiService
import com.example.bookstore.data.local.TokenManager
import com.example.bookstore.data.repo.BookRepository
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // Tồn tại xuyên suốt vòng đời app
object AppModule {

    // URL production / local — đổi USE_LOCAL = false khi deploy
    private const val PRODUCTION_URL = "https://bookstore-backend-production-4b7e.up.railway.app/"
    private const val LOCAL_URL      = "http://192.168.1.4:8081/"
    private const val USE_LOCAL      = true
    private val BASE_URL = if (USE_LOCAL) LOCAL_URL else PRODUCTION_URL

    // 1. Phân phát Két sắt Token
    @Provides
    @Singleton
    fun provideTokenManager(@ApplicationContext context: Context): TokenManager {
        return TokenManager(context)
    }

    // 2. Phân phát AuthInterceptor — nhận TokenManager qua Hilt
    //    [THÊM MỚI — Ch.11 KK4] đọc token từ TokenManager, gắn vào mỗi request
    @Provides
    @Singleton
    fun provideAuthInterceptor(tokenManager: TokenManager): AuthInterceptor {
        return AuthInterceptor(tokenManager)
    }

    // 3. Phân phát OkHttpClient có AuthInterceptor
    //    Hilt tự động inject AuthInterceptor từ bước 2
    //    Auth đứng trước LoggingInterceptor → header được gắn trước khi log
    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)      // ← Auth đứng trước → header được thêm trước khi log
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    // 4. Phân phát ApiService dùng OkHttpClient có auth
    //    Hilt tự inject OkHttpClient từ bước 3
    //    Thay thế RetrofitClient.instance — không còn hardcode OkHttpClient nữa
    @Provides
    @Singleton
    fun provideApiService(okHttpClient: OkHttpClient): ApiService {
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)                 // ← OkHttpClient có AuthInterceptor
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService::class.java)
    }

    // 5. Phân phát ống nước Google
    @Provides
    @Singleton
    fun provideGoogleBooksApi(): GoogleBooksApiService {
        val apiKey = "AIzaSyCB6PVlT939N3rD-La0y52Y0bEYydSeF0o"
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original = chain.request()
                val url = original.url.newBuilder()
                    .addQueryParameter("key", apiKey)
                    .build()
                chain.proceed(original.newBuilder().url(url).build())
            }
            .build()
        return Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/books/v1/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GoogleBooksApiService::class.java)
    }

    // 6. Phân phát Repository (Tự động lấy cái API ở trên bơm vào)
    @Provides
    @Singleton
    fun provideBookRepository(api: GoogleBooksApiService): BookRepository {
        return BookRepository(api)
    }
}

