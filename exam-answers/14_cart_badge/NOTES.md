# BÀI TẬP KIỂM TRA THỰC HÀNH
**Dành cho:** Nhóm 35 — Kotlin Jetpack Compose  
**Tham chiếu:** Chương 11 — Khó khăn 3: Quản lý trạng thái giỏ hàng với StateFlow  
**Loại:** 🟦 Pattern B — Mở rộng UI (thêm tính năng vào component đang có)

---

## 1. ĐỀ BÀI

**Mục tiêu:** Kiểm tra kỹ năng kết nối ViewModel state với UI component — thêm Badge số lượng vào icon Giỏ hàng trong Bottom Navigation Bar, tự động cập nhật theo CartViewModel.

**Yêu cầu:** Ứng dụng hiện không hiển thị số lượng sản phẩm trong giỏ hàng trên bottom navigation. Hãy thêm badge đỏ hiển thị tổng số lượng item vào icon Giỏ hàng.

---

## 2. DỮ LIỆU ĐẦU VÀO (INPUT) — Code hiện tại chưa có badge

```kotlin
// AppBottomNavigation.kt — icon hiện tại không có badge
NavigationBarItem(
    icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
    // ← Tất cả icon đều render giống nhau, không có badge
    ...
)

// MainScreen.kt — AppBottomNavigation không nhận cartCount
Scaffold(
    bottomBar = {
        if (showBottomBar) AppBottomNavigation(navController = navController)
        // ← Không truyền thông tin cart vào
    }
)
```

---

## 3. YÊU CẦU KẾT QUẢ (OUTPUT)

**a.** Sửa `AppBottomNavigation`: thêm param `cartCount: Int = 0`, dùng `BadgedBox` cho icon Cart khi `cartCount > 0`.

**b.** Sửa `MainScreen`: lấy `cartViewModel.cartItems.size`, truyền vào `AppBottomNavigation(cartCount = ...)`.

**c.** **Demo:** Thêm sách vào giỏ → badge số đỏ xuất hiện trên icon giỏ hàng → tăng/giảm → badge cập nhật ngay.

**d.** **Giải thích:** Tại sao badge tự cập nhật mà không cần làm gì thêm? (Compose reactive recomposition với `mutableStateListOf`)

---

## 4. GỢI Ý GIẢI THÍCH CHO THẦY

**Tại sao badge tự cập nhật:**
```kotlin
// CartViewModel dùng mutableStateListOf — đây là Compose State
val cartItems = mutableStateListOf<CartItem>()

// Khi cartItems thay đổi → Compose tự recompose tất cả Composable đang đọc cartItems.size
// Không cần collect() hay observe() thủ công
val cartCount = cartViewModel.cartItems.size  // ← đọc trực tiếp = tự subscribe
```

**BadgedBox — Material3 API:**
```kotlin
BadgedBox(
    badge = { Badge { Text(cartCount.toString()) } }
) {
    Icon(item.icon, contentDescription = item.title)
}
// Badge: vòng tròn đỏ nhỏ góc trên phải của icon — Material3 chuẩn
```

---

## 📦 HƯỚNG DẪN KÉO THẢ

**Kéo thư mục `app/` vào thư mục `BookStore/` — chọn Replace khi được hỏi.**

| File | Loại | Giải quyết yêu cầu |
|------|------|-------------------|
| `ui/components/AppBottomNavigation.kt` | 🔄 REPLACE | Yêu cầu **(a)** — thêm `cartCount` param + BadgedBox |
| `ui/screens/MainScreen.kt` | 🔄 REPLACE | Yêu cầu **(b)** — truyền `cartItems.size` |

> ⚠️ `MainScreen.kt` là file lớn (249 dòng). REPLACE sẽ xóa toàn bộ nội dung cũ.  
> ⚠️ Nếu đã apply **Package 02 (Wishlist)** trước → ĐỪNG REPLACE `MainScreen.kt`, chỉ cần sửa tay:
> - Dòng bottomBar: `AppBottomNavigation(navController, cartViewModel.cartItems.size)`
> ⚠️ Sau khi kéo thả → Build → Rebuild Project → Run.

---

## 📁 Nội dung folder này

```
14_cart_badge/
├── NOTES.md
└── app/src/main/java/com/example/bookstore/
    ├── ui/components/
    │   └── AppBottomNavigation.kt    ← REPLACE (thêm BadgedBox cho Cart icon)
    └── ui/screens/
        └── MainScreen.kt             ← REPLACE (truyền cartItems.size)
```

