# BÀI TẬP KIỂM TRA THỰC HÀNH
**Dành cho:** Nhóm 35 — Kotlin Jetpack Compose  
**Tham chiếu:** Chương 11 — Khó khăn 3: Quản lý trạng thái giỏ hàng và chia sẻ giữa nhiều màn hình

---

## 1. ĐỀ BÀI

**Mục tiêu:** Kiểm tra kỹ năng thiết kế ViewModel với `StateFlow` để chia sẻ trạng thái giữa nhiều Composable, và kỹ thuật "ViewModel hoisting" trong Jetpack Compose.

**Yêu cầu:** Đoạn code dưới đây có vấn đề: giỏ hàng được tạo mới trong mỗi màn hình → data không đồng bộ. Hãy refactor để `CartViewModel` được chia sẻ đúng cách giữa `HomeScreen`, `BookDetailScreen` và `CartScreen`.

---

## 2. DỮ LIỆU ĐẦU VÀO (INPUT) — Code bị lỗi

```kotlin
// BỊ LỖI: Mỗi màn hình tự lấy CartViewModel riêng → 3 instance khác nhau
@Composable
fun HomeScreen() {
    val cartViewModel: CartViewModel = hiltViewModel()  // ← Instance #1
    // Thêm sách vào instance #1
}

@Composable
fun BookDetailScreen() {
    val cartViewModel: CartViewModel = hiltViewModel()  // ← Instance #2 (khác #1!)
    // Thêm sách vào instance #2 → CartScreen không thấy
}

@Composable
fun CartScreen() {
    val cartViewModel: CartViewModel = hiltViewModel()  // ← Instance #3 (lại khác!)
    // cartItems luôn rỗng vì đây là instance mới
}
```

**Vấn đề:** Thêm sách ở `HomeScreen` → vào `CartScreen` → giỏ trống!

---

## 3. YÊU CẦU KẾT QUẢ (OUTPUT)

**a.** Giải thích: tại sao `hiltViewModel()` trong mỗi NavBackStackEntry lại tạo ra instance khác nhau?

**b.** Hoist `CartViewModel` tại `MainScreen` (level cao nhất trong NavHost) và truyền xuống từng màn hình qua parameter.

**c.** Demo: thêm sách từ `HomeScreen` → vào `CartScreen` → số lượng đúng.

**d.** Giải thích: tại sao `mutableStateListOf<CartItem>()` lại phù hợp hơn `StateFlow<List<CartItem>>` trong trường hợp giỏ hàng của project?

---

## 4. GỢI Ý GIẢI THÍCH CHO THẦY

**Tại sao hiltViewModel() tạo instance khác nhau:**
- `hiltViewModel()` bên trong một `composable { }` block trong NavHost → scoped đến `NavBackStackEntry` đó
- Mỗi màn hình có `NavBackStackEntry` riêng → mỗi màn hình có ViewModel riêng → state không chia sẻ

**Giải pháp: ViewModel Hoisting tại MainScreen:**
```kotlin
@Composable
fun MainScreen() {
    val cartViewModel: CartViewModel = hiltViewModel()  // ← 1 instance duy nhất
    // Truyền vào mọi composable cần dùng
}
```

**`mutableStateListOf` vs `StateFlow<List>`:**
- `mutableStateListOf` là Compose-native → các Composable tự recompose khi list thay đổi
- `StateFlow<List>` cần thêm `collectAsState()` → code dài hơn
- Cả hai đều reactive, nhưng `mutableStateListOf` ngắn gọn hơn cho trường hợp list đơn giản

> ⚠️ **Lưu ý discrepancy với báo cáo:** Báo cáo đề cập `StateFlow + Room Database` nhưng implementation thực tế dùng `mutableStateListOf` (in-memory). Lý do: đơn giản hóa cho demo, không cần persist qua relaunch.

---

## 📦 HƯỚNG DẪN KÉO THẢ

> ✅ **Project hiện tại ĐÃ ĐÚNG** — `CartViewModel` được hoist tại `MainScreen` và truyền vào tất cả màn hình.  
> **Không cần kéo thả gì.**

**Chỉ cần mở các file sau và giải thích với thầy:**

| File trong project | Điểm cần chỉ |
|--------------------|-------------|
| `ui/screens/MainScreen.kt` | Line 33: `val cartViewModel: CartViewModel = hiltViewModel()` — hoist tại MainScreen |
| `ui/screens/MainScreen.kt` | Truyền `cartViewModel = cartViewModel` vào `HomeScreen(...)`, `BookDetailScreen(...)`, `CartScreen(...)` |
| `viewmodel/CartViewModel.kt` | `mutableStateListOf<CartItem>()` — Compose state reactive |

**File code lỗi tham chiếu:** `_broken/CartViewModel_broken.kt`

---

## ⚠️ Lưu ý quan trọng khi thầy hỏi về StateFlow + Room

Báo cáo (Khó khăn 3) đề cập giải pháp dùng **StateFlow + Room Database**. Nếu thầy hỏi tại sao không dùng Room:

> *"Chúng em đã nghiên cứu giải pháp StateFlow + Room để persist giỏ hàng qua relaunch như đề xuất trong báo cáo. Tuy nhiên do thời gian hạn chế, chúng em đã implement phiên bản đơn giản hơn với `mutableStateListOf` — giữ nguyên tính reactive nhưng chỉ lưu in-memory. Hướng phát triển tiếp theo là migrate sang Room như đã đề xuất trong Chương 12 (giỏ hàng đa thiết bị)."*

---

## 📁 Nội dung folder này

```
11_cart_state_management/
├── NOTES.md
└── _broken/
    └── CartViewModel_broken.kt    ← Version 3 instance riêng biệt (INPUT)
```

