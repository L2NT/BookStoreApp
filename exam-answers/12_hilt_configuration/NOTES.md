# BÀI TẬP KIỂM TRA THỰC HÀNH
**Dành cho:** Nhóm 35 — Kotlin Jetpack Compose  
**Tham chiếu:** Chương 11 — Khó khăn 4: Cấu hình Hilt cho nhiều module và ViewModel

---

## 1. ĐỀ BÀI

**Mục tiêu:** Kiểm tra kỹ năng cấu hình Hilt Dependency Injection: tạo `@Module`, dùng `@Provides`, `@Singleton`, `@HiltViewModel`, và tích hợp với Jetpack Compose qua `hiltViewModel()`.

**Yêu cầu:** `AppModule.kt` dưới đây thiếu một số `@Provides` method và cấu hình sai scope. Hãy xác định và sửa lại để toàn bộ dependency graph hoạt động đúng.

---

## 2. DỮ LIỆU ĐẦU VÀO (INPUT) — Code bị lỗi

```kotlin
// AppModule.kt — BỊ LỖI
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // ❌ Thiếu @Singleton → mỗi lần inject tạo instance mới
    @Provides
    fun provideTokenManager(@ApplicationContext context: Context): TokenManager {
        return TokenManager(context)
    }

    // ❌ Thiếu hoàn toàn provideBookRepository()
    // → Hilt không biết cách tạo BookRepository → compile error
}

// BookRepository.kt — BỊ LỖI
// ❌ Không có @Inject constructor → Hilt không biết inject cái gì
class BookRepository(private val api: GoogleBooksApiService) { ... }

// HomeViewModel.kt — BỊ LỖI
// ❌ Thiếu @HiltViewModel và @Inject constructor
class HomeViewModel(private val repository: BookRepository) : ViewModel() { ... }

// HomeScreen.kt — BỊ LỖI
@Composable
fun HomeScreen() {
    // ❌ Không dùng hiltViewModel() → tự tạo ViewModel thủ công
    val viewModel = remember { HomeViewModel(BookRepository(...)) }
}
```

---

## 3. YÊU CẦU KẾT QUẢ (OUTPUT)

**a.** Thêm `@Singleton` cho các `@Provides` method quan trọng — giải thích sự khác biệt với không có `@Singleton`.

**b.** Thêm `provideBookRepository()` vào `AppModule` — inject `GoogleBooksApiService` qua parameter.

**c.** Sửa `ViewModel`: thêm `@HiltViewModel` + `@Inject constructor` — Hilt tự inject `BookRepository`.

**d.** Sửa `Screen`: dùng `hiltViewModel()` thay vì `remember { ... }`.

**e.** Giải thích: sự khác biệt giữa `@Singleton`, `@ActivityRetainedScoped`, `@ViewModelScoped`?

---

## 4. GỢI Ý GIẢI THÍCH CHO THẦY

**@Singleton vs không có:**
```kotlin
// Không có @Singleton → mỗi inject = 1 instance mới
@Provides
fun provideTokenManager(...): TokenManager = TokenManager(context)
// → Nếu 2 nơi inject TokenManager → 2 instance khác nhau → state không đồng bộ

// Có @Singleton → toàn app dùng chung 1 instance
@Provides @Singleton
fun provideTokenManager(...): TokenManager = TokenManager(context)
```

**Dependency graph:**
```
AppModule.provideTokenManager()           → TokenManager (@Singleton)
AppModule.provideGoogleBooksApi()         → GoogleBooksApiService (@Singleton)
AppModule.provideBookRepository(api)      → BookRepository (@Singleton)  ← inject api tự động
AppModule.provideApiService()             → ApiService (@Singleton)

@HiltViewModel CategoryViewModel(@Inject repository) ← Hilt inject BookRepository tự động
@AndroidEntryPoint MainActivity           ← Hilt inject vào Activity
```

**hiltViewModel() vs viewModel():**
- `hiltViewModel()` → Compose tự lấy từ Hilt container, đúng scope
- `remember { ViewModel(...) }` → tự tạo, không được Hilt quản lý, không share được

---

## 📦 HƯỚNG DẪN KÉO THẢ

> ✅ **Project hiện tại ĐÃ ĐÚNG** — `AppModule.kt`, `@HiltViewModel`, `@Inject` đã được cấu hình đầy đủ.  
> **Không cần kéo thả gì.**

**Chỉ cần mở các file sau và giải thích với thầy:**

| File trong project | Điểm cần chỉ |
|--------------------|-------------|
| `di/AppModule.kt` | `@Module`, `@InstallIn`, `@Provides`, `@Singleton` — 6 hàm provide |
| `viewmodel/CategoryViewModel.kt` | `@HiltViewModel class CategoryViewModel @Inject constructor(...)` |
| `BookstoreApplication.kt` | `@HiltAndroidApp` — kích hoạt Hilt cho toàn app |
| `MainActivity.kt` | `@AndroidEntryPoint` — Hilt inject vào Activity |

**File code lỗi tham chiếu:** `_broken/AppModule_broken.kt`

---

## 📁 Nội dung folder này

```
12_hilt_configuration/
├── NOTES.md
└── _broken/
    └── AppModule_broken.kt    ← Module thiếu @Singleton + @Provides (INPUT)
```

