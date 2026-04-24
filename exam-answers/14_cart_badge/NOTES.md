# 14 — CART BADGE (GIỎ HÀNG COUNTER)
**Tham chiếu:** Chương 11 — Khó khăn 3  
**Loại:** BadgedBox + mutableStateListOf reactive state

---

## ĐỀ GỐC

### Input — Code hiện tại (không có badge):
```kotlin
// AppBottomNavigation.kt — tất cả icon render giống nhau
NavigationBarItem(
    icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
    // ← không có badge, cart trông như các tab khác
    ...
)

// MainScreen.kt — không truyền cartCount
if (showBottomBar) AppBottomNavigation(navController = navController)
// ← thiếu cartCount
```

### Output — Kết quả cần đạt:
- Icon Giỏ hàng có **chấm đỏ với số** khi có item trong giỏ
- Thêm sách → badge hiện ngay, số tăng lên
- Xóa sách → badge giảm, về 0 → badge biến mất
- Hơn 99 item → hiện `"99+"`

### File path các file thực hiện:
```
app/src/main/java/com/example/bookstore/
├── ui/components/AppBottomNavigation.kt    ← SỬA (thêm cartCount + BadgedBox)
└── ui/screens/MainScreen.kt               ← SỬA (truyền cartItems.size)
```

### Cần thêm/sửa gì ở từng file:

**AppBottomNavigation.kt** ← SỬA:
```kotlin
// TRƯỚC — không có param cartCount:
fun AppBottomNavigation(navController: NavController)

// SAU — thêm cartCount:
fun AppBottomNavigation(navController: NavController, cartCount: Int = 0) {
    // ...
    NavigationBarItem(
        icon = {
            // Chỉ tab Cart mới có badge, các tab khác giữ nguyên
            if (item == BottomNavItem.Cart && cartCount > 0) {
                BadgedBox(badge = {
                    Badge { Text(if (cartCount > 99) "99+" else cartCount.toString()) }
                }) {
                    Icon(imageVector = item.icon, contentDescription = item.title)
                }
            } else {
                Icon(imageVector = item.icon, contentDescription = item.title)
            }
        },
        ...
    )
}
```

**MainScreen.kt** ← SỬA dòng bottomBar:
```kotlin
// TRƯỚC:
AppBottomNavigation(navController = navController)

// SAU:
AppBottomNavigation(navController = navController, cartCount = cartViewModel.cartItems.size)
```

---

## ĐỀ BIẾN THỂ — Các dạng thầy có thể ra

---

### Đề 2: Badge không hiển thị số — chỉ chấm tròn đỏ

**Input:** Badge hiện số lượng item  
**Output:** Chỉ hiện chấm tròn đỏ nhỏ (không có số) khi giỏ không rỗng

**Cách sửa AppBottomNavigation:**
```kotlin
// Badge() không có content → chỉ là chấm đỏ
BadgedBox(badge = { if (cartCount > 0) Badge() }) {
    Icon(imageVector = item.icon, contentDescription = item.title)
}
```

---

### Đề 3: Badge trên tab Account (thông báo mới)

**Input:** Chỉ Cart có badge  
**Output:** Account tab cũng có badge đỏ khi có đơn hàng mới (PENDING)

**Cách sửa AppBottomNavigation — thêm param:**
```kotlin
fun AppBottomNavigation(
    navController: NavController,
    cartCount: Int = 0,
    pendingOrderCount: Int = 0   // ← thêm param mới
) {
    // ...
    icon = {
        when {
            item == BottomNavItem.Cart && cartCount > 0 ->
                BadgedBox(badge = { Badge { Text(if (cartCount > 99) "99+" else "$cartCount") } }) {
                    Icon(item.icon, item.title)
                }
            item == BottomNavItem.Account && pendingOrderCount > 0 ->
                BadgedBox(badge = { Badge() }) {   // chỉ chấm, không số
                    Icon(item.icon, item.title)
                }
            else -> Icon(item.icon, item.title)
        }
    }
}
// MainScreen truyền thêm:
AppBottomNavigation(
    navController      = navController,
    cartCount          = cartViewModel.cartItems.size,
    pendingOrderCount  = accountViewModel.orderHistory.count { it.status == "PENDING" }
)
```

---

### Đề 4: Badge màu xanh thay vì đỏ

**Input:** Badge màu đỏ mặc định của Material3  
**Output:** Badge màu xanh lá `#4CAF50`

**Cách sửa:**
```kotlin
Badge(
    containerColor = Color(0xFF4CAF50),   // ← đổi màu nền badge
    contentColor   = Color.White
) {
    Text(if (cartCount > 99) "99+" else cartCount.toString())
}
```

---

### Đề 5: Badge ẩn/hiện với animation

**Input:** Badge xuất hiện/biến mất ngay tức thì  
**Output:** Badge fade in khi xuất hiện, fade out khi biến mất

**Cách sửa:**
```kotlin
AnimatedVisibility(
    visible = cartCount > 0,
    enter = fadeIn() + scaleIn(),
    exit  = fadeOut() + scaleOut()
) {
    BadgedBox(badge = {
        Badge { Text(if (cartCount > 99) "99+" else "$cartCount") }
    }) {
        Icon(item.icon, item.title)
    }
}
// Nếu cartCount = 0 → chỉ Icon không có BadgedBox
if (cartCount == 0) Icon(item.icon, item.title)
```

---

### Đề 6: Hiển thị tổng số lượng (quantity) thay vì số loại sách

**Input:** `cartItems.size` = số loại sách (3 loại = badge "3")  
**Output:** Badge hiện tổng số cuốn sách (mỗi loại có thể có qty > 1, ví dụ 3 loại × qty → "7")

**Cách sửa MainScreen:**
```kotlin
// TRƯỚC — đếm số loại:
cartCount = cartViewModel.cartItems.size       // 3 loại → badge "3"

// SAU — đếm tổng số cuốn:
cartCount = cartViewModel.cartItems.sumOf { it.quantity }   // qty: 2+3+2 = 7 → badge "7"
```

---

### Giải thích kỹ thuật cốt lõi

**Tại sao badge tự cập nhật không cần collect/observe:**
```kotlin
// CartViewModel:
val cartItems = mutableStateListOf<CartItem>()
//              ↑ mutableStateListOf = Compose State thuần túy
//               Khi thêm/xóa item → Compose mark tất cả Composable đọc cartItems là "dirty"
//               → Recompose ngay lập tức ở frame tiếp theo

// MainScreen đọc:
cartCount = cartViewModel.cartItems.size
//          ↑ Đây là "read" trong Compose scope → tự động subscribe
//           Không cần .collect() hay .observe()

// SO SÁNH với StateFlow (WishlistViewModel):
wishlistViewModel.wishlist.collectAsStateWithLifecycle()   // ← bắt buộc phải collect
```

**BadgedBox — cấu trúc:**
```
BadgedBox(
    badge = { Badge { Text("3") } }   ← badge slot: nội dung badge (tròn đỏ)
) {
    Icon(...)                          ← content slot: icon bên dưới badge
}
Badge đặt tự động ở góc trên phải của content — không cần tính toán offset thủ công
```
