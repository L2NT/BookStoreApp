# BÀI TẬP KIỂM TRA THỰC HÀNH
**Dành cho:** Nhóm 35 — Kotlin Jetpack Compose  
**Tham chiếu:** Chương 12 — Mục 12.1.1: Chức năng yêu thích sách (Wishlist)

---

## 1. ĐỀ BÀI

**Mục tiêu:** Kiểm tra kỹ năng tạo ViewModel mới với StateFlow, thêm màn hình mới vào Navigation Graph, và chia sẻ ViewModel state giữa nhiều màn hình.

**Yêu cầu:** Báo cáo đề xuất tính năng Wishlist. Hãy implement tính năng này vào ứng dụng BookStore hiện tại.

---

## 2. DỮ LIỆU ĐẦU VÀO (INPUT) — Hiện trạng

```kotlin
// BookDetailScreen.kt — nút ❤️ chưa tồn tại
// AccountScreen.kt — không có mục "Sách yêu thích"
// MainScreen.kt — không có route "wishlist"
// WishlistViewModel.kt — file chưa tồn tại
// WishlistScreen.kt — file chưa tồn tại
```

---

## 3. YÊU CẦU KẾT QUẢ (OUTPUT)

**a.** Tạo `WishlistViewModel`: `StateFlow<List<Book>>`, hàm `toggle(book)` thêm/xóa khỏi wishlist, hàm `isWishlisted(bookId)` kiểm tra.

**b.** Tạo `WishlistScreen`: dùng `LazyColumn` hiển thị danh sách sách yêu thích, nút xóa từng item.

**c.** Sửa `BookDetailScreen`: thêm nút ❤️ trên TopAppBar — icon đổi giữa `FavoriteBorder` / `Favorite` tùy trạng thái.

**d.** Sửa `MainScreen`: thêm route `"wishlist"` trong `account_graph`, hoist `WishlistViewModel`.

**e.** Sửa `AccountScreen`: thêm mục "Sách yêu thích" → navigate đến `"wishlist"`.

**f.** **Demo:** vào chi tiết sách → bấm ❤️ → vào Account → Sách yêu thích → thấy sách đã lưu → bấm xóa → biến mất.

**g.** **Giải thích:** Tại sao WishlistViewModel phải được hoist tại `MainScreen` thay vì dùng `hiltViewModel()` riêng trong từng screen?

---

## 4. GỢI Ý GIẢI THÍCH CHO THẦY

- **ViewModel hoisting**: nếu mỗi screen dùng `hiltViewModel()` riêng trong NavBackStackEntry scope → mỗi màn hình có instance khác nhau → data không đồng bộ. Hoist tại `MainScreen` → 1 instance duy nhất chia sẻ cho tất cả.
- **StateFlow + collectAsState**: khi wishlist thay đổi → icon ❤️ tự recompose ngay, WishlistScreen tự cập nhật → reactive UI.
- **toggle()**: dùng `any { it.id == book.id }` để check → nếu có thì filter ra (xóa), nếu chưa có thì `+ book` (thêm) — functional style của Kotlin.

---

## 📦 HƯỚNG DẪN KÉO THẢ

**Kéo thư mục `app/` vào thư mục `BookStore/` — chọn Replace khi được hỏi.**

| File | Loại | Giải quyết yêu cầu |
|------|------|-------------------|
| `viewmodel/WishlistViewModel.kt` | ✅ DROP-IN (file mới) | Yêu cầu **(a)** |
| `ui/screens/WishlistScreen.kt` | ✅ DROP-IN (file mới) | Yêu cầu **(b)** |
| `ui/screens/MainScreen.kt` | 🔄 REPLACE | Yêu cầu **(d)** — thêm WishlistViewModel + route |
| `ui/screens/AccountScreen.kt` | 🔄 REPLACE | Yêu cầu **(e)** — thêm menu item |
| `ui/screens/BookDetailScreen.kt` | 🔄 REPLACE | Yêu cầu **(c)** — thêm nút ❤️ |
| `ui/components/DetailTopBar.kt` | 🔄 REPLACE | Hỗ trợ **(c)** — thêm param `extraActions` |

> ⚠️ **Sau khi kéo thả → Build → Rebuild Project → Run.**  
> ⚠️ `MainScreen.kt` là file lớn — REPLACE sẽ xóa toàn bộ nội dung cũ, thay bằng file đã thêm Wishlist.

