package com.example.bookstore.data.dto.response

// ══════════════════════════════════════════════════════════════════
// ĐÂY LÀ CODE BỊ LỖI — DÙNG LÀM INPUT CHO ĐỀ THI
// KHÔNG copy file này vào project!
// ══════════════════════════════════════════════════════════════════
//
// BUG: userId luôn null sau khi đăng nhập
// NGUYÊN NHÂN: Thiếu @SerializedName("id")
//   Backend JSON: { "accessToken": "...", "id": 42, "username": "..." }
//   Gson tìm field "userId" trong JSON → không có → null
//
// CHUỖI LỖI:
//   userId = null → loadProfile(null) → không gọi API → AccountScreen trống
//                                                      → CheckoutScreen form trống
//
// CÁCH FIX: Thêm @SerializedName("id") vào field userId
// ══════════════════════════════════════════════════════════════════

import com.google.gson.annotations.SerializedName

// ❌ Code BỊ LỖI — thiếu annotation
data class JwtResponse(
    @SerializedName("accessToken") val token: String,  // đúng
    val tokenType: String? = null,
    val userId: Long? = null,           // ❌ THIẾU @SerializedName("id")
                                        // Gson tìm "userId" trong JSON → null
    val username: String? = null
)

// ══════════════════════════════════════════════════════════════════
// CODE ĐÚNG (đã có trong project):
//
// data class JwtResponse(
//     @SerializedName("accessToken") val token: String,
//     val tokenType: String? = null,
//     @SerializedName("id") val userId: Long? = null,   ← thêm annotation
//     val username: String? = null
// )
// ══════════════════════════════════════════════════════════════════

