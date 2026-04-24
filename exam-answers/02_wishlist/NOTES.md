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

## 4. TRƯỜNG HỢP INPUT / OUTPUT

### WishlistViewModel.toggle():

| Trạng thái trước | Input | Kết quả |
|---|---|---|
| `wishlist = []` | `toggle(bookA)` | `wishlist = [bookA]` |
| `wishlist = [bookA]` | `toggle(bookA)` | `wishlist = []` *(xóa)* |
| `wishlist = [bookA]` | `toggle(bookB)` | `wishlist = [bookA, bookB]` |
| `wishlist = [bookA, bookB]` | `toggle(bookA)` | `wishlist = [bookB]` *(xóa bookA)* |

### Icon ❤️ trong BookDetailScreen:

| `isWishlisted` | Icon hiển thị | Màu |
|---|---|---|
| `false` | `FavoriteBorder` (❤️ rỗng) | Trắng |
| `true` | `Favorite` (❤️ đầy) | `Color.Red` |

### WishlistScreen:

| Trạng thái wishlist | UI hiển thị |
|---|---|
| `wishlist.isEmpty()` | "❤️ Chưa có sách yêu thích" + hướng dẫn |
| `wishlist = [bookA, bookB]` | LazyColumn 2 item, mỗi item có nút 🗑️ xóa |

### Các variant thầy có thể yêu cầu:

**Thêm hàm `addAll(books: List<Book>)` để import danh sách:**
```kotlin
fun addAll(books: List<Book>) {
    val current = _wishlist.value
    val newBooks = books.filter { book -> current.none { it.id == book.id } }
    _wishlist.value = current + newBooks
}
```

**Sắp xếp wishlist theo thứ tự thêm vào (mới nhất đầu tiên):**
```kotlin
fun toggle(book: Book) {
    val current = _wishlist.value
    _wishlist.value = if (current.any { it.id == book.id }) {
        current.filter { it.id != book.id }
    } else {
        listOf(book) + current   // ← thêm vào ĐẦU thay vì cuối
    }
}
```

**WishlistScreen có nút "Thêm vào giỏ hàng" từ wishlist:**
```kotlin
@Composable
fun WishlistScreen(
    navController: NavController,
    wishlistViewModel: WishlistViewModel,
    cartViewModel: CartViewModel    // ← thêm param
) {
    // ...
    WishlistItem(
        book     = book,
        onRemove = { wishlistViewModel.remove(book.id) },
        onAddToCart = { cartViewModel.addBook(book, 1) }  // ← nút mới
    )
}
```

**Hiển thị số lượng sách yêu thích trên AccountScreen:**
```kotlin
// Trong AccountMenuItem hoặc menu label
Text("Sách yêu thích (${wishlistViewModel.wishlist.value.size})")
```

---

## 5. GỢI Ý GIẢI THÍCH CHO THẦY

**ViewModel hoisting:**
- Nếu mỗi screen dùng `hiltViewModel()` riêng trong NavBackStackEntry scope → mỗi màn hình có instance khác nhau → data không đồng bộ
- Hoist tại `MainScreen` → 1 instance duy nhất chia sẻ cho tất cả → bấm ❤️ ở BookDetail → WishlistScreen cập nhật ngay

**So sánh CartViewModel vs WishlistViewModel:**
```kotlin
// CartViewModel dùng mutableStateListOf — Compose State
val cartItems = mutableStateListOf<CartItem>()
// Đọc: cartViewModel.cartItems.size — tự recompose

// WishlistViewModel dùng MutableStateFlow — Kotlin Flow
val wishlist: StateFlow<List<Book>> = _wishlist.asStateFlow()
// Đọc: wishlistViewModel.wishlist.collectAsStateWithLifecycle()
// → Phải collect, nhưng lifecycle-aware (pause khi app background)
```

**toggle() — functional style:**
```kotlin
fun toggle(book: Book) {
    val current = _wishlist.value
    _wishlist.value = if (current.any { it.id == book.id }) {
        current.filter { it.id != book.id }   // Xóa: tạo List mới không có book
    } else {
        current + book                          // Thêm: tạo List mới có thêm book
    }
}
// Không mutate list trực tiếp (immutable style) → StateFlow emit value mới → UI recompose
```

**extraActions trong DetailTopBar:**
```kotlin
// DetailTopBar nhận optional lambda để render thêm action icons
extraActions: (@Composable RowScope.() -> Unit)? = null

// Khi gọi từ BookDetailScreen:
extraActions = {
    IconButton(onClick = { book?.let { wishlistViewModel.toggle(it) } }) {
        Icon(
            imageVector = if (isWishlisted) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
            tint        = if (isWishlisted) Color.Red else Color.White
        )
    }
}
// Nếu không truyền extraActions → DetailTopBar bỏ qua (null check), không ảnh hưởng màn hình khác
```

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
