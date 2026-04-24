# BÀI TẬP KIỂM TRA THỰC HÀNH
**Dành cho:** Nhóm 35 — Kotlin Jetpack Compose  
**Tham chiếu:** Chương 11 — Khó khăn 5: Xử lý lỗi mạng và hiển thị thông báo (UiState Sealed Class)

---

## 1. ĐỀ BÀI

**Mục tiêu:** Kiểm tra kỹ năng thiết kế `sealed class` để quản lý trạng thái UI, và refactor ViewModel dùng nhiều biến rời rạc sang `StateFlow<UiState<T>>`.

**Yêu cầu:** `HomeViewModel` dưới đây dùng 3 biến `StateFlow` rời rạc để quản lý trạng thái, dẫn đến trạng thái không nhất quán. Hãy refactor sang `sealed class UiState`.

---

## 2. DỮ LIỆU ĐẦU VÀO (INPUT) — Code bị lỗi

```kotlin
// HomeViewModel.kt — BỊ LỖI: 3 biến rời rạc
class HomeViewModel : ViewModel() {
    var isLoading = MutableStateFlow(false)       // ← 3 biến độc lập
    var books     = MutableStateFlow<List<Book>>(emptyList())
    var errorMsg  = MutableStateFlow<String?>(null)

    fun loadBooks() {
        isLoading.value = true
        viewModelScope.launch {
            try {
                val result = repository.getBooks()
                books.value = result
                // ❌ Quên set isLoading = false → UI loading mãi mãi
            } catch (e: Exception) {
                errorMsg.value = e.message
                // ❌ isLoading vẫn = true + errorMsg != null → trạng thái mâu thuẫn
            }
        }
    }
}

// HomeScreen.kt — phải check nhiều state cùng lúc, dễ thiếu case
val isLoading by viewModel.isLoading.collectAsState()
val books     by viewModel.books.collectAsState()
val errorMsg  by viewModel.errorMsg.collectAsState()

if (isLoading) { CircularProgressIndicator() }      // Có thể đồng thời
else if (errorMsg != null) { Text(errorMsg!!) }     // với books != empty
else { LazyColumn { items(books) { BookItem(it) } } }
```

---

## 3. YÊU CẦU KẾT QUẢ (OUTPUT)

**a.** Viết `sealed class UiState<out T>` với 3 trạng thái: `Loading`, `Success(data: T)`, `Error(message: String)`.

**b.** Refactor `ViewModel`: dùng `StateFlow<UiState<List<Book>>>` thay vì 3 biến rời rạc.

**c.** Sửa `Screen`: dùng `when(uiState)` → hiển thị đúng `Loading` / danh sách / thông báo lỗi.

**d.** **Giải thích:** Tại sao `sealed class` đảm bảo "exhaustive" và loại trừ được trạng thái mâu thuẫn?

---

## 4. GỢI Ý GIẢI THÍCH CHO THẦY

**Vấn đề với biến rời rạc:**  
- 3 biến độc lập → có thể cùng lúc `isLoading=true` VÀ `errorMsg!=null` → UI không biết hiển thị gì
- Dễ quên reset state → memory leak hoặc UI bị stuck ở loading

**Sealed class giải quyết:**
- Tại mọi thời điểm, state chỉ có thể là 1 trong 3 trạng thái → **mutual exclusive**
- `when(uiState)` bắt buộc xử lý **tất cả** cases (exhaustive) → compiler báo lỗi nếu thiếu
- `out T` (covariance) → `UiState<Book>` có thể coi là `UiState<Any>` → tái sử dụng cho mọi loại data

---

## 📦 HƯỚNG DẪN KÉO THẢ

> ✅ **Project hiện tại ĐÃ CÓ** `UiState.kt` và `CategoryViewModel` dùng đúng pattern này.  
> **Không cần kéo thả gì.**

**Chỉ cần mở các file sau và giải thích với thầy:**

| File trong project | Điểm cần chỉ |
|--------------------|-------------|
| `ui/state/UiState.kt` | `sealed class UiState<out T>` với 3 states |
| `viewmodel/CategoryViewModel.kt` | `StateFlow<UiState<List<Book>>>`, `viewModelScope.launch`, `.onSuccess/.onFailure` |
| `ui/screens/CategoryDetailScreen.kt` | `when(uiState)` → Loading/Success/Error handling |

**Nếu thầy yêu cầu viết từ đầu:**  
Xem `_broken/HomeViewModel_broken.kt` để lấy code có vấn đề làm INPUT, rồi code lại UiState.

---

## 📁 Nội dung folder này

```
05_uistate_explain/
├── NOTES.md                          ← File này
└── _broken/
    └── HomeViewModel_broken.kt       ← Code 3 biến rời rạc BỊ LỖI (INPUT cho đề)
```

