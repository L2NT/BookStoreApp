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

## 4. TRƯỜNG HỢP INPUT / OUTPUT

| `cartCount` | Hiển thị badge | Nội dung badge |
|---|---|---|
| `0` | Không hiện badge | *(không có gì)* |
| `1` | 🔴 Badge đỏ | `"1"` |
| `5` | 🔴 Badge đỏ | `"5"` |
| `99` | 🔴 Badge đỏ | `"99"` |
| `100` | 🔴 Badge đỏ | `"99+"` *(overflow)* |
| `999` | 🔴 Badge đỏ | `"99+"` *(overflow)* |

### Các variant thầy có thể yêu cầu:

**Hiển thị trên nhiều tab cùng lúc (vd: Account cũng có badge thông báo):**
```kotlin
@Composable
fun AppBottomNavigation(
    navController: NavController,
    cartCount: Int = 0,
    notificationCount: Int = 0   // Badge mới cho Account tab
) {
    // ...
    if (item == BottomNavItem.Cart && cartCount > 0) {
        BadgedBox(badge = { Badge { Text(...) } }) { Icon(...) }
    } else if (item == BottomNavItem.Account && notificationCount > 0) {
        BadgedBox(badge = { Badge { Text(...) } }) { Icon(...) }
    } else {
        Icon(...)
    }
}
```

**Badge không có số (chỉ chấm đỏ):**
```kotlin
BadgedBox(badge = { Badge() /* không có content → chỉ chấm đỏ */ }) {
    Icon(...)
}
```

**Thay màu badge:**
```kotlin
Badge(
    containerColor = Color(0xFFFF5722),   // Cam thay vì đỏ
    contentColor   = Color.White
) { Text(cartCount.toString()) }
```

---

## 5. GỢI Ý GIẢI THÍCH CHO THẦY

**Tại sao badge tự cập nhật:**
```kotlin
// CartViewModel dùng mutableStateListOf — đây là Compose State
val cartItems = mutableStateListOf<CartItem>()

// Khi cartItems thay đổi → Compose tự recompose tất cả Composable đang đọc cartItems.size
// Không cần collect() hay observe() thủ công
val cartCount = cartViewModel.cartItems.size  // ← đọc trực tiếp = tự subscribe
```

**So sánh với StateFlow (WishlistViewModel):**
```kotlin
// mutableStateListOf → Compose State, đọc trực tiếp .size
cartViewModel.cartItems.size           // ← đủ, không cần collect

// MutableStateFlow → Flow, phải collect
wishlistViewModel.wishlist.collectAsStateWithLifecycle()  // ← bắt buộc
```

**BadgedBox — Material3 API:**
```kotlin
BadgedBox(
    badge = { Badge { Text(if (cartCount > 99) "99+" else cartCount.toString()) } }
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
