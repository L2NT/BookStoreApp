# BÀI TẬP KIỂM TRA THỰC HÀNH
**Dành cho:** Nhóm 35 — Kotlin Jetpack Compose  
**Tham chiếu:** Chương 11 — Bug: `userId` luôn null sau đăng nhập (JwtResponse.kt)

---

## 1. ĐỀ BÀI

**Mục tiêu:** Kiểm tra kỹ năng làm việc với Gson `@SerializedName` annotation và hiểu cách mapping JSON → Kotlin data class.

**Yêu cầu:** Sau khi đăng nhập thành công, `AccountScreen` và `CheckoutScreen` đều trống (không có thông tin). Debug và tìm ra nguyên nhân trong `JwtResponse.kt`, sau đó fix lại.

---

## 2. DỮ LIỆU ĐẦU VÀO (INPUT) — Code bị lỗi

```kotlin
// JwtResponse.kt — BỊ LỖI
data class JwtResponse(
    @SerializedName("accessToken") val token: String,
    val tokenType: String? = null,
    val userId: Long? = null,       // ❌ THIẾU @SerializedName("id")
    val username: String? = null
)

// Backend Spring Boot trả về JSON:
// {
//   "accessToken": "eyJhbGci...",
//   "id": 42,                      ← tên field là "id" (không phải "userId")
//   "username": "user@example.com"
// }
// → Gson dùng tên field Kotlin "userId" để map → không tìm thấy "userId" trong JSON
// → userId = null → loadProfile() nhận userId=null → không gọi API → AccountScreen trống
```

---

## 3. YÊU CẦU KẾT QUẢ (OUTPUT)

**a.** Xác định: tại sao `userId` luôn là `null` dù backend đã trả đúng?

**b.** Fix `JwtResponse.kt`: thêm `@SerializedName("id")` vào field `userId`.

**c.** Demo: đăng nhập → vào Account → thấy tên, email đầy đủ (trước fix: trống hoàn toàn).

**d.** Giải thích: cơ chế mapping JSON → Kotlin class của Gson, khi nào cần `@SerializedName`?

---

## 4. GỢI Ý GIẢI THÍCH CHO THẦY

**Cơ chế Gson mapping:**
- Mặc định, Gson dùng **tên field Kotlin** (sau khi compile thành Java field name) để tìm trong JSON
- `val userId` → Gson tìm key `"userId"` trong JSON → không có → `null`
- Backend Spring Boot dùng `id` (kiểu trường entity JPA thường là `id`) → JSON có `"id": 42`

**@SerializedName giải quyết:**
- `@SerializedName("id") val userId: Long?` → Gson mapping `"id"` từ JSON → field `userId` trong Kotlin
- Giúp tách biệt naming convention JSON (backend) và Kotlin (frontend)

**Chuỗi lỗi:**
```
userId = null
  → loadProfile(userId) không gọi vì null check
    → userProfile = null
      → AccountScreen hiển thị trống
        → CheckoutScreen không pre-fill form
```

---

## 📦 HƯỚNG DẪN KÉO THẢ

> ✅ **Project hiện tại ĐÃ ĐƯỢC FIX** — `JwtResponse.kt` đã có `@SerializedName("id")`.  
> **Không cần kéo thả gì.**

**Chỉ cần mở file và giải thích với thầy:**

| File trong project | Điểm cần chỉ |
|--------------------|-------------|
| `data/dto/response/JwtResponse.kt` | Line 8: `@SerializedName("id") val userId: Long?` |

**File code lỗi tham chiếu:** `_broken/JwtResponse_broken.kt`

---

## 📁 Nội dung folder này

```
07_jwt_serialized_name/
├── NOTES.md
└── _broken/
    └── JwtResponse_broken.kt    ← DTO thiếu @SerializedName (INPUT cho đề)
```

