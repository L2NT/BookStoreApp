# 3.3. Đồ án — Áp dụng kiến thức ngôn ngữ Kotlin cơ bản vào ứng dụng bán sách

## 3.3.1. Tổng quan

Đồ án "Ứng dụng bán sách" đã vận dụng trực tiếp các khái niệm ngôn ngữ cơ bản của Kotlin vào xây dựng **tầng Model** và **tầng ViewModel** — hai lớp nền tảng của kiến trúc MVVM. Cụ thể:

- **Data Class** → định nghĩa toàn bộ thực thể dữ liệu: sách, giỏ hàng, người dùng, danh mục.
- **Default & Named Parameters** → khởi tạo đối tượng linh hoạt, tránh overload hàm.
- **Computed Property (`get()`)** → tính tổng tiền tự động, đảm bảo nhất quán dữ liệu.
- **Collections API (`sumOf`, `indexOfFirst`, `copy`, `removeAll`)** → thao tác danh sách giỏ hàng ngắn gọn.
- **Biểu thức `when`** → phân loại mã giảm giá và trạng thái đơn hàng.

---

## 3.3.2. Định nghĩa các Data Class trong đồ án

Toàn bộ dữ liệu của ứng dụng được biểu diễn thông qua các Data Class rõ ràng, nhất quán. Mỗi lớp đại diện cho một thực thể nghiệp vụ trong hệ thống.

> **[Hình X.X. Cấu trúc thư mục `data/model/` chứa các Data Class trong đồ án]**

---

### Model `Book` — Thực thể sách

**File:** `app/src/main/java/com/example/bookstore/data/model/Book.kt`

```kotlin
data class Book(
    val id: String,
    val title: String,
    val describe: String,
    val author: String,
    val imageUrl: String,
    val price: Double = 0.0   // Default parameter — giá mặc định khi API không trả về
)
```

**Giải thích:** `Book` là model trung tâm của ứng dụng, xuất hiện ở mọi màn hình: trang chủ, danh mục, chi tiết sách, giỏ hàng và đơn hàng. Tham số mặc định `price = 0.0` cho phép tạo đối tượng `Book` linh hoạt kể cả khi Google Books API không cung cấp thông tin giá — không cần tạo constructor overload như trong Java.

---

### Model `CartItem` — Thực thể giỏ hàng

**File:** `app/src/main/java/com/example/bookstore/data/model/CartItem.kt`

```kotlin
data class CartItem(
    val book: Book,
    val quantity: Int
)
```

**Giải thích:** `CartItem` lưu trữ một cuốn sách cùng số lượng tương ứng trong giỏ hàng. Việc dùng `data class` giúp tận dụng hàm `copy()` để cập nhật số lượng một cách an toàn mà không làm thay đổi đối tượng gốc (immutability).

---

### Model `User` — Thực thể người dùng

**File:** `app/src/main/java/com/example/bookstore/data/model/User.kt`

```kotlin
data class User(
    val id: Int,
    val username: String,
    val email: String,
    val fullName: String,
    val phoneNumber: String,
    val address: String
)
```

**Giải thích:** `User` chứa thông tin tài khoản người dùng, được dùng trong màn hình thông tin tài khoản và màn hình thanh toán để tự động điền thông tin người nhận hàng.

---

### Model `Category` — Danh mục sách với `companion object`

**File:** `app/src/main/java/com/example/bookstore/data/model/Category.kt`

```kotlin
data class Category(
    val name: String,           // Tên hiển thị trên UI (tiếng Việt)
    val queryKeyword: String,   // Từ khóa tìm kiếm Google Books API (tiếng Anh)
    val bookCount: Int = 568    // Default parameter — số sách hiển thị tĩnh
) {
    companion object {
        val all: List<Category> = listOf(
            Category("Văn học",    "subject:fiction literature"),
            Category("Kinh tế",    "subject:economics business"),
            Category("Tâm lý học", "subject:psychology self-help"),
            Category("Thiếu nhi",  "subject:children juvenile"),
            Category("Giáo khoa",  "subject:textbook education"),
            Category("Lịch sử",    "subject:history"),
            // ... 6 danh mục khác
        )
    }
}
```

**Giải thích:**
- **Default parameter** `bookCount = 568` cho phép tạo `Category` không cần truyền số lượng sách — tất cả 12 danh mục đều dùng giá trị mặc định này.
- **`companion object`** chứa danh sách 12 danh mục cố định, truy cập trực tiếp qua `Category.all` mà không cần tạo instance — tương đương `static` trong Java nhưng cú pháp rõ ràng hơn.
- `queryKeyword` và `name` được tách biệt: `name` hiển thị tiếng Việt trên UI, còn `queryKeyword` là từ khóa tiếng Anh gửi lên Google Books API.

---

### Data Transfer Objects (DTOs) — Nhóm Data Class lồng nhau

**File:** `app/src/main/java/com/example/bookstore/data/dto/GoogleBookDto.kt`

```kotlin
// Phản hồi tổng thể từ Google Books API
data class GoogleBookResponse(
    val items: List<BookItem>? = emptyList()
)

// Mỗi cuốn sách trong phản hồi
data class BookItem(
    val id: String,
    val volumeInfo: VolumeInfo?,   // Nullable — có thể không có thông tin sách
    val saleInfo: SaleInfo?        // Nullable — có thể không có thông tin giá
)

// Thông tin chi tiết sách
data class VolumeInfo(
    val title: String?,
    val authors: List<String>?,    // Danh sách tác giả
    val description: String?,
    val imageLinks: ImageLinks?
)

// Thông tin giá bán
data class SaleInfo(
    val retailPrice: Price?,       // Giá bán lẻ (sau chiết khấu)
    val listPrice: Price?,         // Giá niêm yết
    val saleability: String?       // "FOR_SALE" | "NOT_FOR_SALE" | "FREE"
)

data class Price(
    val amount: Double?,           // Số tiền
    val currencyCode: String?      // Đơn vị: "VND", "USD", ...
)
```

**Giải thích:** Nhóm DTO phản ánh cấu trúc JSON phân cấp của Google Books API. Tất cả các field đều là **Nullable** vì API không đảm bảo trả về đầy đủ thông tin. Việc tổ chức thành nhiều Data Class lồng nhau (`BookItem` → `VolumeInfo`, `SaleInfo` → `Price`) giúp ánh xạ dữ liệu chính xác và dễ debug nhờ `toString()` tự sinh.

---

## 3.3.3. Hàm với Default & Named Parameters

**File:** `app/src/main/java/com/example/bookstore/viewmodel/CartViewModel.kt`

```kotlin
// Default Parameter: quantity = 1 khi không truyền (thêm 1 cuốn)
fun addBook(book: Book, quantity: Int = 1) {
    val index = cartItems.indexOfFirst { it.book.id == book.id }
    if (index >= 0) {
        // Named Parameter: copy() với tên tham số rõ ràng
        cartItems[index] = cartItems[index].copy(
            quantity = cartItems[index].quantity + quantity
        )
    } else {
        cartItems.add(CartItem(book, quantity))
    }
}
```

**Giải thích:**
- **Default parameter** `quantity: Int = 1` cho phép gọi `addBook(book)` khi thêm 1 cuốn từ danh sách, hoặc `addBook(book, 2)` khi thêm nhiều hơn. Không cần tạo hai hàm overload riêng biệt.
- **Named parameter** `copy(quantity = ...)` làm rõ thuộc tính nào đang được thay đổi, đặc biệt hữu ích khi Data Class có nhiều trường cùng kiểu.
- Hàm kiểm tra sách đã có trong giỏ chưa trước khi thêm (`indexOfFirst`) — nếu có thì cộng dồn số lượng thay vì thêm bản ghi trùng.

---

## 3.3.4. Computed Property và Collections API

**File:** `app/src/main/java/com/example/bookstore/viewmodel/CartViewModel.kt`

### Computed Property — Tính tổng tiền tự động

```kotlin
// Tổng tiền hàng — tính lại mỗi khi đọc, không lưu trữ trực tiếp
val subtotal: Double get() = cartItems.sumOf { it.book.price * it.quantity }

// Tổng thanh toán = hàng + phí vận chuyển - giảm giá
val total: Double get() = subtotal + shippingFee - discountAmount
```

**Giải thích:** `subtotal` và `total` là **computed property** (thuộc tính tính toán) — được tính lại mỗi lần được truy cập thay vì lưu sẵn giá trị. Điều này đảm bảo tổng tiền luôn phản ánh chính xác trạng thái hiện tại của giỏ hàng sau mỗi lần thêm, bớt sách, hoặc áp mã giảm giá — không cần gọi hàm cập nhật thủ công.

> **[Hình X.X. Màn hình giỏ hàng hiển thị subtotal và total được tính tự động từ computed property]**

### Collections API — Thao tác danh sách giỏ hàng

```kotlin
// sumOf{} — tính tổng theo biểu thức lambda
val subtotal = cartItems.sumOf { it.book.price * it.quantity }

// indexOfFirst{} — tìm chỉ số phần tử đầu tiên thỏa điều kiện
val index = cartItems.indexOfFirst { it.book.id == book.id }

// copy() — cập nhật Data Class bất biến, tạo bản sao với trường mới
cartItems[index] = cartItems[index].copy(quantity = cartItems[index].quantity + 1)

// removeAll{} — xóa tất cả phần tử thỏa điều kiện
cartItems.removeAll { it.book.id == bookId }
```

**Giải thích:** Thay vì dùng vòng lặp `for` tường minh, Collections API của Kotlin giúp code ngắn gọn và biểu đạt rõ ý định hơn. Đặc biệt, `copy()` của Data Class đảm bảo tính bất biến — tạo đối tượng mới với giá trị thay đổi thay vì sửa trực tiếp trên đối tượng gốc, phù hợp với nguyên tắc lập trình hàm.

---

## 3.3.5. Biểu thức `when` trong xử lý nghiệp vụ

### Phân loại mã giảm giá

**File:** `app/src/main/java/com/example/bookstore/viewmodel/CartViewModel.kt`

```kotlin
fun applyDiscount() {
    discountAmount = when (discountCode.trim().uppercase()) {
        "SALE10"   -> subtotal * 0.10    // Giảm 10% tổng đơn hàng
        "GIAM17"   -> 17_000.0           // Giảm cố định 17.000đ
        "FREESHIP" -> shippingFee        // Miễn phí vận chuyển
        else -> {
            discountError = "Mã giảm giá không hợp lệ"
            0.0
        }
    }
}
```

**Giải thích:** `when` ở đây đóng vai trò **biểu thức** (expression) — kết quả được gán trực tiếp vào `discountAmount` mà không cần biến trung gian. Nhánh `else` bắt mọi mã không hợp lệ, cập nhật thông báo lỗi và trả về 0 — đảm bảo giỏ hàng không bị trừ tiền khi mã sai.

---

### Phân loại trạng thái đơn hàng

**File:** `app/src/main/java/com/example/bookstore/ui/screens/OrderHistoryScreen.kt`

```kotlin
// Hàm biểu thức đơn + when: ánh xạ status → nhãn hiển thị + màu sắc + icon
private fun getStatusInfo(status: String): StatusInfo = when (status.uppercase()) {
    "PENDING"                 -> StatusInfo("Chờ xác nhận",   Color(0xFFFF9800), Icons.Outlined.HourglassEmpty)
    "PROCESSING", "CONFIRMED" -> StatusInfo("Đang xử lý",     Color(0xFF2196F3), Icons.Outlined.Inventory2)
    "SHIPPED", "SHIPPING"     -> StatusInfo("Đang giao hàng", Color(0xFF9C27B0), Icons.Outlined.LocalShipping)
    "DELIVERED"               -> StatusInfo("Đã giao hàng",   Color(0xFF4CAF50), Icons.Outlined.CheckCircle)
    "CANCELLED"               -> StatusInfo("Đã hủy",         Color(0xFFF44336), Icons.Outlined.Cancel)
    else                      -> StatusInfo(status,            Color.Gray,        Icons.Outlined.HourglassEmpty)
}
```

**Giải thích:** Ví dụ này kết hợp nhiều tính năng ngôn ngữ:
- **Hàm biểu thức đơn** (`= when {...}`) — thân hàm chỉ là một biểu thức `when`, không cần dấu `{}` và `return`.
- **`when` với nhiều giá trị trên một nhánh** (`"PROCESSING", "CONFIRMED"`) — gộp hai trạng thái có cùng cách hiển thị vào một nhánh, điều `switch` trong Java không hỗ trợ trực tiếp.
- `StatusInfo` cũng là một `data class` nhỏ — phản ánh cách dùng Data Class để nhóm nhiều giá trị có liên quan thành một kiểu dữ liệu có ý nghĩa.

---

## 3.3.6. Kết quả đạt được

Việc áp dụng các khái niệm ngôn ngữ Kotlin cơ bản vào đồ án mang lại những kết quả cụ thể và đo lường được:

| Khái niệm | Áp dụng thực tế | Lợi ích |
|---|---|---|
| **Data Class** | `Book`, `CartItem`, `User`, `Category`, 5 DTO classes | Tự sinh `equals()`, `copy()`, `toString()` — giảm boilerplate so với Java |
| **Default Parameter** | `price = 0.0` (Book), `bookCount = 568` (Category), `quantity = 1` (addBook) | Tạo đối tượng linh hoạt, không cần overload hàm |
| **Named Parameter** | `copy(quantity = ...)` trong CartViewModel | Code tự mô tả ý định, tránh nhầm thứ tự tham số |
| **Computed Property** | `subtotal`, `total` trong CartViewModel | Tổng tiền đồng bộ tự động, không cần cập nhật thủ công |
| **Collections API** | `sumOf`, `indexOfFirst`, `copy`, `removeAll` | Thao tác danh sách ngắn gọn, biểu đạt rõ ý định |
| **`when` expression** | `applyDiscount()`, `getStatusInfo()` | Phân loại đa trường hợp an toàn, gộp nhiều case gọn |
| **`companion object`** | `Category.all` | Truy cập danh sách danh mục toàn cục không cần tạo instance |

