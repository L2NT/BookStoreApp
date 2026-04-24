# 02 — WISHLIST (YÊU THÍCH SÁCH)
**Tham chiếu:** Chương 12 — Mục 12.1.1  
**Loại:** ViewModel hoisting + StateFlow + Navigation

---

## ĐỀ GỐC

### Input — Code hiện tại (bị thiếu):
```kotlin
// BookDetailScreen.kt — KHÔNG có nút ❤️
DetailTopBar(onBackClick, onHomeClick, ...)   // ← không có extraActions

// AccountScreen.kt — Menu list KHÔNG có mục Wishlist
AccountMenuItem(icon = Icons.Outlined.LocationOn, label = "Địa chỉ", ...)
AccountMenuItem(icon = Icons.Outlined.Settings,   label = "Cài đặt", ...)

// MainScreen.kt — account_graph KHÔNG có route "wishlist"
composable("order_history") { ... }
composable("contact") { ... }
// ← thiếu composable("wishlist") { ... }
```

### Output — Kết quả cần đạt:
- Trang chi tiết sách có nút **❤️ (FavoriteBorder)** trên TopBar
- Bấm ❤️ → icon đổi thành **❤️ đỏ (Favorite đầy)**, bấm lại → trở về rỗng
- AccountScreen có mục **"Sách yêu thích"** trong menu
- Vào "Sách yêu thích" → thấy danh sách các sách đã bấm ❤️
- Xóa → biến mất khỏi danh sách

### File path các file thực hiện:
```
app/src/main/java/com/example/bookstore/
├── viewmodel/WishlistViewModel.kt          ← TẠO MỚI
├── ui/screens/WishlistScreen.kt            ← TẠO MỚI
├── ui/screens/BookDetailScreen.kt          ← SỬA (thêm wishlistViewModel param + extraActions)
├── ui/screens/AccountScreen.kt             ← SỬA (thêm menu item "Sách yêu thích")
├── ui/screens/MainScreen.kt               ← SỬA (hoist WishlistViewModel + thêm route)
└── ui/components/DetailTopBar.kt          ← SỬA (thêm extraActions param)
```

### Cần thêm/sửa gì ở từng file:

**WishlistViewModel.kt** ← TẠO MỚI:
```kotlin
@HiltViewModel
class WishlistViewModel @Inject constructor() : ViewModel() {
    private val _wishlist = MutableStateFlow<List<Book>>(emptyList())
    val wishlist: StateFlow<List<Book>> = _wishlist.asStateFlow()

    fun toggle(book: Book) {
        _wishlist.value = if (_wishlist.value.any { it.id == book.id })
            _wishlist.value.filter { it.id != book.id }   // xóa
        else _wishlist.value + book                        // thêm
    }

    fun remove(bookId: String) {
        _wishlist.value = _wishlist.value.filter { it.id != bookId }
    }
}
```

**DetailTopBar.kt** ← thêm param `extraActions`:
```kotlin
// TRƯỚC:
fun DetailTopBar(onBackClick, onHomeClick, onCartClick, onAccountClick, onCategoryClick, onSearchSubmit)

// SAU — thêm 1 param cuối:
fun DetailTopBar(
    ...,
    extraActions: (@Composable RowScope.() -> Unit)? = null   // ← nullable, mặc định null
) {
    // Trong actions block, trước icon Search:
    extraActions?.invoke(this)   // ← nếu null thì bỏ qua
    IconButton(onClick = { isSearchActive = true }) { Icon(Icons.Default.Search, ...) }
}
```

**BookDetailScreen.kt** ← thêm wishlistViewModel + nút ❤️:
```kotlin
// Thêm param:
fun BookDetailScreen(..., wishlistViewModel: WishlistViewModel, ...)

// Thêm state:
val wishlist by wishlistViewModel.wishlist.collectAsStateWithLifecycle()
val isWishlisted = book?.let { wishlist.any { w -> w.id == it.id } } ?: false

// Truyền extraActions vào DetailTopBar:
DetailTopBar(
    ...,
    extraActions = {
        IconButton(onClick = { book?.let { wishlistViewModel.toggle(it) } }) {
            Icon(
                imageVector = if (isWishlisted) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                tint        = if (isWishlisted) Color.Red else Color.White
            )
        }
    }
)
```

**AccountScreen.kt** ← thêm menu item:
```kotlin
// Thêm trước "Địa chỉ":
AccountMenuItem(
    icon    = Icons.Outlined.Favorite,
    label   = "Sách yêu thích",
    onClick = { navController.navigate("wishlist") }
)
HorizontalDivider(...)
```

**MainScreen.kt** ← hoist ViewModel + thêm route:
```kotlin
// Thêm ViewModel:
val wishlistViewModel: WishlistViewModel = hiltViewModel()

// Truyền vào BookDetailScreen:
BookDetailScreen(..., wishlistViewModel = wishlistViewModel, ...)

// Thêm route trong account_graph:
composable("wishlist") {
    WishlistScreen(navController = navController, wishlistViewModel = wishlistViewModel)
}
```

---

## ĐỀ BIẾN THỂ — Các dạng thầy có thể ra

---

### Đề 2: Thêm nút "Thêm vào giỏ" trực tiếp từ WishlistScreen

**Input:** WishlistScreen chỉ có nút 🗑️ Xóa, không có nút thêm vào giỏ

**Output:** Mỗi item trong Wishlist có thêm nút **"Thêm vào giỏ"** bên cạnh nút xóa

**Cách sửa WishlistScreen:**
```kotlin
// Thêm param cartViewModel:
fun WishlistScreen(
    navController: NavController,
    wishlistViewModel: WishlistViewModel,
    cartViewModel: CartViewModel        // ← thêm
)

// Trong WishlistItem, thêm nút:
IconButton(onClick = { cartViewModel.addBook(book, 1) }) {
    Icon(Icons.Default.ShoppingCart, contentDescription = "Thêm vào giỏ", tint = AppColors.PrimaryBlue)
}

// MainScreen — truyền thêm cartViewModel:
WishlistScreen(navController, wishlistViewModel, cartViewModel)
```

---

### Đề 3: Hiển thị số lượng sách yêu thích trên menu AccountScreen

**Input:** Menu item "Sách yêu thích" không hiện số lượng

**Output:** Hiện `"Sách yêu thích (3)"` khi có 3 sách trong wishlist

**Cách sửa AccountScreen:**
```kotlin
// Thêm param wishlistViewModel:
fun AccountScreen(navController, viewModel, loginViewModel,
    wishlistViewModel: WishlistViewModel = hiltViewModel())

// Collect count:
val wishlistCount by wishlistViewModel.wishlist.collectAsStateWithLifecycle()

// Đổi label:
AccountMenuItem(
    icon    = Icons.Outlined.Favorite,
    label   = if (wishlistCount.isEmpty()) "Sách yêu thích"
              else "Sách yêu thích (${wishlistCount.size})",
    onClick = { navController.navigate("wishlist") }
)
```

---

### Đề 4: Wishlist mới nhất hiện đầu tiên (thêm vào đầu danh sách)

**Input:** `toggle()` thêm sách vào CUỐI list (`current + book`)

**Output:** Sách mới bấm ❤️ xuất hiện ở đầu WishlistScreen

**Cách sửa WishlistViewModel.toggle():**
```kotlin
_wishlist.value = if (_wishlist.value.any { it.id == book.id })
    _wishlist.value.filter { it.id != book.id }
else listOf(book) + _wishlist.value     // ← đảo: đặt book lên ĐẦU
```

---

### Đề 5: Giới hạn tối đa 5 sách trong wishlist

**Input:** toggle() thêm không giới hạn

**Output:** Khi đã có 5 sách, bấm ❤️ thêm sách mới → hiện Snackbar "Wishlist đã đầy (tối đa 5 sách)"

**Cách sửa:** Trả về Boolean từ toggle() để biết có thêm được không:
```kotlin
fun toggle(book: Book): Boolean {
    val current = _wishlist.value
    return if (current.any { it.id == book.id }) {
        _wishlist.value = current.filter { it.id != book.id }
        true
    } else if (current.size >= 5) {
        false   // ← từ chối thêm
    } else {
        _wishlist.value = current + book
        true
    }
}

// BookDetailScreen gọi:
val added = wishlistViewModel.toggle(it)
if (!added) snackbarHostState.showSnackbar("Wishlist đã đầy (tối đa 5 sách)")
```

---

### Đề 6: Nút "Xóa tất cả" trong WishlistScreen

**Input:** Chỉ xóa từng item

**Output:** Có nút "Xóa tất cả" ở TopBar hoặc cuối danh sách

**Cách sửa WishlistViewModel:**
```kotlin
fun clearAll() { _wishlist.value = emptyList() }
```
**Cách sửa WishlistScreen TopBar:**
```kotlin
actions = {
    if (wishlist.isNotEmpty()) {
        IconButton(onClick = { wishlistViewModel.clearAll() }) {
            Icon(Icons.Default.DeleteSweep, contentDescription = "Xóa tất cả", tint = Color.White)
        }
    }
}
```

---

### Giải thích kỹ thuật cốt lõi

**Tại sao phải hoist WishlistViewModel ở MainScreen:**
```
Nếu BookDetailScreen dùng hiltViewModel() riêng:
  BookDetailScreen → WishlistViewModel (instance A)
  WishlistScreen   → WishlistViewModel (instance B)  ← KHÁC instance!
  → Bấm ❤️ ở Detail → instance A có sách
  → WishlistScreen collect instance B → RỖNG
  → Bug: wishlist không đồng bộ

Hoist tại MainScreen:
  val wishlistViewModel = hiltViewModel()  ← 1 instance duy nhất
  BookDetailScreen(wishlistViewModel = wishlistViewModel)
  WishlistScreen(wishlistViewModel = wishlistViewModel)
  → Cùng instance → đồng bộ hoàn toàn ✓
```

**collectAsStateWithLifecycle vs collectAsState:**
```kotlin
// collectAsState — không lifecycle-aware
val list by vm.flow.collectAsState()  // ← vẫn collect khi app vào background → lãng phí

// collectAsStateWithLifecycle — dừng khi app background, tiếp tục khi foreground
val list by vm.flow.collectAsStateWithLifecycle()  // ← best practice
```
