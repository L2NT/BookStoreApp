package com.example.bookstore.di

// ══════════════════════════════════════════════════════════════════
// ĐÂY LÀ CODE BỊ LỖI — DÙNG LÀM INPUT CHO ĐỀ THI
// KHÔNG copy file này vào project!
// ══════════════════════════════════════════════════════════════════
//
// VẤN ĐỀ 1: Thiếu @Singleton → mỗi lần inject tạo instance mới
// VẤN ĐỀ 2: Thiếu provideBookRepository() → compile error vì Hilt
//            không biết cách tạo BookRepository
// VẤN ĐỀ 3: ViewModel không có @HiltViewModel + @Inject constructor
// ══════════════════════════════════════════════════════════════════

import android.content.Context
import com.example.bookstore.data.api.ApiService
import com.example.bookstore.data.api.RetrofitClient
import com.example.bookstore.data.local.TokenManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // ❌ BUG 1: Thiếu @Singleton → mỗi inject tạo TokenManager mới
    // Hệ quả: 2 ViewModel inject TokenManager → 2 instance khác nhau
    // → lưu token ở instance A, đọc từ instance B → null
    @Provides
    fun provideTokenManager(@ApplicationContext context: Context): TokenManager {
        return TokenManager(context)
    }

    // ❌ BUG 2: Thiếu @Provides cho GoogleBooksApiService
    // → Hilt không biết inject gì vào BookRepository constructor
    // → Compile error: "cannot be provided without an @Provides-annotated method"

    // ❌ BUG 3: Thiếu hoàn toàn provideBookRepository()
    // → CategoryViewModel @Inject constructor(repository: BookRepository) → error

    // ❌ BUG 4: ApiService được provide nhưng không có @Singleton
    @Provides
    fun provideApiService(): ApiService {
        return RetrofitClient.instance.create(ApiService::class.java)
        // Không có @Singleton → mỗi lần inject tạo Retrofit instance mới → lãng phí
    }
}

// ══════════════════════════════════════════════════════════════════
// NGOÀI RA — ViewModel bị lỗi:
//
// ❌ Thiếu @HiltViewModel và @Inject
// class CategoryViewModel(
//     private val repository: BookRepository  // Hilt không biết inject cái này
// ) : ViewModel()
//
// CODE ĐÚNG:
// @HiltViewModel
// class CategoryViewModel @Inject constructor(
//     private val repository: BookRepository   // Hilt tự inject từ AppModule
// ) : ViewModel()
//
// ❌ Trong Composable — tự tạo ViewModel thủ công
// val viewModel = remember { CategoryViewModel(BookRepository(api)) }
//
// CODE ĐÚNG:
// val viewModel: CategoryViewModel = hiltViewModel()
// ══════════════════════════════════════════════════════════════════

// CODE ĐÚNG — AppModule hoàn chỉnh — Xem di/AppModule.kt trong project:
//
// @Provides @Singleton fun provideTokenManager(...): TokenManager
// @Provides @Singleton fun provideGoogleBooksApi(): GoogleBooksApiService
// @Provides @Singleton fun provideBookRepository(api: GoogleBooksApiService): BookRepository
// @Provides @Singleton fun provideApiService(): ApiService

