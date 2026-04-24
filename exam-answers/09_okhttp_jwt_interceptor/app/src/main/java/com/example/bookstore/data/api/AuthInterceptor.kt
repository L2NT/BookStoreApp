package com.example.bookstore.data.api

import com.example.bookstore.data.local.TokenManager
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

/**
 * AuthInterceptor — Tự động thêm JWT token vào header mọi request API.
 *
 * Implement okhttp3.Interceptor: mọi request đi qua OkHttpClient
 * đều chạy qua chain này → thêm "Authorization: Bearer <token>" một lần duy nhất
 * thay vì thêm thủ công trong từng Repository function.
 *
 * DRY Principle: Don't Repeat Yourself — viết 1 lần, áp dụng cho tất cả API calls.
 *
 * Ref: Khó khăn 2 — Chương 11 Báo cáo
 */
class AuthInterceptor(private val tokenManager: TokenManager) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        // Đọc token từ DataStore (runBlocking vì Interceptor chạy trên background thread)
        val token = runBlocking { tokenManager.token.firstOrNull() }

        val request = if (!token.isNullOrBlank()) {
            // Thêm header Authorization vào request gốc
            chain.request()
                .newBuilder()
                .header("Authorization", "Bearer $token")
                .build()
        } else {
            // Chưa đăng nhập → gửi request không có auth (endpoint public vẫn hoạt động)
            chain.request()
        }

        return chain.proceed(request)
    }
}

