# BÀI TẬP KIỂM TRA THỰC HÀNH
**Dành cho:** Nhóm 35 — Kotlin Jetpack Compose  
**Tham chiếu:** Chương 11 — Khó khăn 2: Quản lý token JWT và tự động thêm vào header

---

## 1. ĐỀ BÀI

**Mục tiêu:** Kiểm tra kỹ năng thiết kế OkHttp Interceptor để tự động đính kèm JWT token vào mọi request API, và cấu hình Hilt dependency injection cho OkHttpClient.

**Yêu cầu:** Hiện tại `AppModule.kt` cung cấp `ApiService` với `OkHttpClient` không có auth header. Mọi request đến endpoint yêu cầu xác thực (`/api/orders`, `/api/users`) đều bị từ chối `401 Unauthorized`. Hãy tạo `AuthInterceptor` và tích hợp vào Hilt module.

---

## 2. DỮ LIỆU ĐẦU VÀO (INPUT) — Code hiện tại bị thiếu

```kotlin
// AppModule.kt — BỊ THIẾU: OkHttpClient không có auth interceptor
@Provides @Singleton
fun provideApiService(): ApiService {
    return RetrofitClient.instance.create(ApiService::class.java)
    // ❌ RetrofitClient.okHttpClient chỉ có LoggingInterceptor
    // ❌ Không có header "Authorization: Bearer <token>"
    // → /api/orders → 401 Unauthorized
}

// Không có AuthInterceptor.kt
// TokenManager đã được provide nhưng không được dùng ở đâu
```

---

## 3. YÊU CẦU KẾT QUẢ (OUTPUT)

**a.** Tạo `AuthInterceptor.kt`: implement `okhttp3.Interceptor`, đọc token từ `TokenManager`, thêm header `Authorization: Bearer <token>` vào mọi request.

**b.** Sửa `AppModule.kt`: thêm `provideOkHttpClient()` inject `TokenManager` + `AuthInterceptor` → `provideApiService()` dùng OkHttpClient có auth.

**c.** Demo: đăng nhập → gọi API đơn hàng → không còn lỗi 401.

**d.** Giải thích: tại sao dùng `Interceptor` thay vì thêm header thủ công trong từng hàm repository?

---

## 4. GỢI Ý GIẢI THÍCH CHO THẦY

**OkHttp Interceptor:**
- Mọi request đi qua `OkHttpClient` đều chạy qua chain của Interceptors trước khi gửi đi
- `AuthInterceptor` được thêm vào chain → tự động thêm header cho TẤT CẢ request
- Không cần sửa từng hàm API → DRY principle (Don't Repeat Yourself)

**Tại sao dùng Interceptor:**
```
Repository → Retrofit → OkHttpClient → [AuthInterceptor → thêm header] → Server
                                         ↑ chỉ viết 1 lần, áp dụng cho tất cả
```

**runBlocking trong Interceptor:**
- OkHttp Interceptor chạy trên background thread → có thể dùng `runBlocking` để đọc từ DataStore
- `tokenManager.token.firstOrNull()` → lấy token hiện tại

---

## 📦 HƯỚNG DẪN KÉO THẢ

**⚠️ Package này cần KÉO THẢ — code chưa có trong project.**

**Kéo thư mục `app/` vào thư mục `BookStore/` — chọn Replace khi được hỏi.**

| File | Loại | Giải quyết yêu cầu |
|------|------|-------------------|
| `data/api/AuthInterceptor.kt` | ✅ DROP-IN (file mới) | Yêu cầu **(a)** — OkHttp Interceptor |
| `di/AppModule.kt` | 🔄 REPLACE | Yêu cầu **(b)** — inject AuthInterceptor vào OkHttpClient |

> ⚠️ Sau khi kéo thả → Build → Rebuild → Run.  
> Cần backend đang chạy để demo 401 → 200.

---

## 📁 Nội dung folder này

```
09_okhttp_jwt_interceptor/
├── NOTES.md
└── app/src/main/java/com/example/bookstore/
    ├── data/api/AuthInterceptor.kt    ← DROP-IN (file mới)
    └── di/AppModule.kt                ← REPLACE (thêm provideOkHttpClient)
```

