# 5.3. Đồ án — Áp dụng Kotlin Nâng cao vào ứng dụng bán sách

## 5.3.1. Tổng quan

Đồ án "Ứng dụng bán sách" (BookStore) vận dụng toàn diện các tính năng Kotlin nâng cao đã được nghiên cứu ở mục 5.1 và 5.2 để xây dựng hai tầng cốt lõi trong kiến trúc MVVM:

- **Tầng Data** (`data/repo/`, `data/dto/`): xử lý API, ánh xạ DTO → Domain  
- **Tầng ViewModel** (`viewmodel/`): điều phối trạng thái UI và gọi Coroutines  
- **Tầng UI** (`ui/screens/`): phản ánh trạng thái qua `when` expression

| Kỹ thuật | Vị trí áp dụng | Mục đích |
|---|---|---|
| Sealed Class `UiState` | `UiState.kt`, `CategoryViewModel`, `CategoryDetailScreen` | Quản lý 3 trạng thái Loading / Success / Error |
| Null Safety | `BookRepository.toDomainModel()` | Chuyển đổi DTO → Book an toàn |
| Extension Functions | `Extensions.kt` | Định dạng tiền tệ, giá trị mặc định, giá hiển thị |
| Higher-Order Functions | `CategoryDetailScreen`, `CartViewModel` | Lọc và sắp xếp danh sách |
| Coroutines | `BookDetailViewModel`, `CategoryViewModel`, `CheckoutViewModel` | Gọi API bất đồng bộ không chặn Main Thread |

---

## 5.3.2. Sealed Class quản lý trạng thái giao diện

### Định nghĩa `UiState`

File `ui/state/UiState.kt` định nghĩa Sealed Class tổng quát dùng chung cho mọi màn hình:

```kotlin
sealed class UiState<out T> {

    /** Trạng thái đang tải dữ liệu */
    data object Loading : UiState<Nothing>()

    /** Trạng thái tải thành công — chứa dữ liệu kiểu T */
    data class Success<T>(val data: T) : UiState<T>()

    /** Trạng thái lỗi — chứa thông báo lỗi */
    data class Error(val message: String) : UiState<Nothing>()
}
```

**Giải thích:**

- `sealed class` giới hạn tập con: trình biên dịch biết chính xác tất cả các trạng thái có thể xảy ra, bắt buộc `when` phải xử lý đủ cả ba nhánh — không bỏ sót.
- `out T` (Covariance): cho phép `UiState<List<Book>>` được coi là `UiState<Any>`, giúp tái sử dụng cho mọi loại dữ liệu (sách, đơn hàng, người dùng) mà không cần tạo Sealed Class riêng biệt.
- `data object Loading` (Kotlin 1.9+): là singleton, không chứa dữ liệu — dùng `data object` thay `object` để hỗ trợ `equals/toString`.
- `UiState<Nothing>` cho Loading và Error: `Nothing` là kiểu con của mọi kiểu — giúp hai trạng thái này tương thích với mọi `UiState<T>`.

### Áp dụng trong `CategoryViewModel`

File `viewmodel/CategoryViewModel.kt` dùng `UiState` kết hợp với Coroutines và StateFlow:

```kotlin
@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val repository: BookRepository
) : ViewModel() {

    // Trạng thái UI khởi tạo là Loading
    private val _uiState = MutableStateFlow<UiState<List<Book>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<Book>>> = _uiState.asStateFlow()

    fun loadBooks(query: String) {
        if (query == currentQuery && _uiState.value is UiState.Success) return
        currentQuery = query

        viewModelScope.launch {
            _uiState.value = UiState.Loading

            repository.getBooksResult(query)
                .onSuccess { books ->
                    _uiState.value = UiState.Success(books)
                }
                .onFailure { error ->
                    // Elvis operator (?:) — Null Safety
                    _uiState.value = UiState.Error(error.message ?: "Lỗi không xác định")
                }
        }
    }
}
```

**Giải thích:**

- `MutableStateFlow<UiState<List<Book>>>(UiState.Loading)`: khởi tạo trạng thái ban đầu là Loading.
- `asStateFlow()`: chuyển sang `StateFlow` chỉ đọc — UI không thể thay đổi trực tiếp, chỉ ViewModel mới cập nhật được.
- `repository.getBooksResult()` trả về `Result<List<Book>>` — `.onSuccess` / `.onFailure` là Higher-Order Function của Kotlin standard library, xử lý kết quả an toàn không cần try-catch.

### Áp dụng trong `CategoryDetailScreen` — `when` exhaustive

File `ui/screens/CategoryDetailScreen.kt` sử dụng `when` để phản ánh trạng thái ra UI:

```kotlin
// Collect StateFlow từ ViewModel
val uiState by viewModel.uiState.collectAsStateWithLifecycle()

when (val state = uiState) {

    is UiState.Loading -> {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator(color = AppColors.PrimaryBlue)
        }
    }

    is UiState.Error -> {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Không tải được sách")
            Text(state.message, color = Color.Gray)       // truy cập .message của Error
            Button(onClick = { viewModel.loadBooks(category.queryKeyword) }) {
                Text("Thử lại")
            }
        }
    }

    is UiState.Success -> {
        // state.data là List<Book> — truy cập .data của Success
        val books = state.data
        LazyVerticalGrid(...) {
            items(books) { book -> BookCard(book = book, ...) }
        }
    }
}
```

**Giải thích:** `when (val state = uiState)` là **exhaustive when expression** — Sealed Class đảm bảo trình biên dịch báo lỗi nếu thiếu nhánh. Việc khai báo `val state = uiState` trong `when` cho phép smart cast: trong nhánh `is UiState.Success`, biến `state` được tự động ép kiểu sang `UiState.Success<List<Book>>` nên có thể truy cập `state.data` trực tiếp.

_Hình 5.X. Màn hình danh mục — ba trạng thái Loading / Error / Success_

---

## 5.3.3. Null Safety trong xử lý dữ liệu API

Dữ liệu từ Google Books API có nhiều trường tùy chọn (có thể `null`). Hàm `toDomainModel()` trong `BookRepository` ánh xạ DTO → `Book` an toàn nhờ Null Safety:

```kotlin
private fun BookItem.toDomainModel(): Book {
    val bookPrice = this.saleInfo?.retailPrice?.amount
        ?: this.saleInfo?.listPrice?.amount
        ?: 0.0
    return Book(
        id       = this.id,
        title    = this.volumeInfo?.title ?: "Chưa rõ tên sách",
        author   = this.volumeInfo?.authors?.firstOrNull() ?: "Khuyết danh",
        imageUrl = this.volumeInfo?.imageLinks?.thumbnailUrl
                       ?.replace("http:", "https:") ?: "",
        describe = this.volumeInfo?.description
                       ?.replace(Regex("<.*?>"), "") ?: "Đang cập nhật mô tả...",
        price    = bookPrice
    )
}
```

**Giải thích từng toán tử:**

| Toán tử | Dòng | Ý nghĩa |
|---|---|---|
| `?.` (Safe Call) | `this.saleInfo?.retailPrice?.amount` | Nếu `saleInfo` là `null`, toàn bộ chuỗi trả về `null` thay vì NullPointerException |
| `?:` (Elvis) | `?: this.saleInfo?.listPrice?.amount ?: 0.0` | Fallback theo chuỗi: retailPrice → listPrice → 0.0 |
| `?.firstOrNull()` | `authors?.firstOrNull()` | Lấy tác giả đầu tiên nếu danh sách không rỗng, trả `null` nếu trống |
| `?.replace(...)` | `thumbnailUrl?.replace(...)` | Chỉ thay thế chuỗi khi URL không null |
| `?: ""` | Cuối dòng `imageUrl` | Trả về chuỗi rỗng nếu không có URL |

Hàm `getBooksResult()` trong cùng file áp dụng thêm toán tử Elvis ở tầng xử lý HTTP:

```kotlin
suspend fun getBooksResult(query: String): Result<List<Book>> {
    return try {
        val response = api.searchBooks(query)
        if (response.isSuccessful) {
            val items = response.body()?.items ?: emptyList()   // Safe Call + Elvis
            Result.success(items.map { it.toDomainModel() })
        } else {
            Result.failure(Exception("Không tải được sách (HTTP ${response.code()})"))
        }
    } catch (e: Exception) {
        Result.failure(Exception("Lỗi kết nối: ${e.message ?: "Không xác định"}"))
    }
}
```

**`response.body()?.items ?: emptyList()`**: chuỗi hai toán tử — `body()` có thể trả `null` (HTTP body rỗng), `items` cũng có thể `null` (API không có kết quả); Elvis `?:` đảm bảo không bao giờ bị `NullPointerException` hay `IndexOutOfBoundsException` khi duyệt danh sách.

---

## 5.3.4. Extension Functions

File `utils/Extensions.kt` định nghĩa ba Extension Function mở rộng kiểu có sẵn mà không cần kế thừa:

### `Double.toVnd()` — Định dạng tiền tệ VND

```kotlin
fun Double.toVnd(): String {
    val fmt = NumberFormat.getNumberInstance(Locale.forLanguageTag("vi-VN"))
    fmt.maximumFractionDigits = 0
    return "${fmt.format(this.toLong())}đ"
}

// Sử dụng: gọi như phương thức gốc của Double
val gia = 88_000.0
Text(text = gia.toVnd())   // Hiển thị: "88.000đ"
```

**Giải thích:** `fun Double.toVnd()` khai báo `this` là một `Double` — hàm hoạt động như phương thức của `Double` dù được định nghĩa bên ngoài lớp. `Locale.forLanguageTag("vi-VN")` định dạng số theo chuẩn Việt Nam: dấu chấm phân cách hàng nghìn.

### `String?.orDefault()` — Kết hợp Null Safety và Extension Function

```kotlin
fun String?.orDefault(default: String = "Chưa có thông tin"): String =
    this?.ifBlank { default } ?: default

// Sử dụng
val description: String? = null
Text(text = description.orDefault())          // "Chưa có thông tin"
Text(text = "   ".orDefault("Không rõ"))      // "Không rõ" (chuỗi blank)
Text(text = "Lập trình Kotlin".orDefault())   // "Lập trình Kotlin"
```

**Giải thích:** Khai báo trên `String?` (nullable String) — hàm có thể gọi trên cả giá trị `null` mà không gây lỗi. `this?.ifBlank { default }` trả `null` nếu `this` là `null`, hoặc trả `default` nếu `this` chỉ chứa khoảng trắng; toán tử Elvis `?:` xử lý trường hợp `null` còn lại.

### `Book.displayPrice()` — Chuẩn hóa giá hiển thị

```kotlin
fun Book.displayPrice(): Double =
    if (price >= 1_000.0) price          // Giá hợp lệ (đã là VND)
    else 50_000.0 + (id.hashCode().absoluteValue % 20) * 10_000.0  // Mock VND

// Sử dụng trong CategoryDetailScreen
val sorted = state.data.sortedBy { it.displayPrice() }
Text(text = book.displayPrice().toVnd())   // "88.000đ"
```

**Giải thích:** Google Books API trả về giá USD (ví dụ: `1.71`) hoặc `0.0` khi không có giá. `displayPrice()` chuẩn hóa về khoảng giá VND hợp lệ (50.000đ – 240.000đ) dựa trên hash của `id` — đảm bảo mỗi cuốn sách luôn hiển thị cùng một giá, nhất quán giữa các lần tải. Extension Function cho phép gọi `book.displayPrice()` tự nhiên như thuộc tính của `Book`.

---

## 5.3.5. Higher-Order Functions trong xử lý danh sách

### Sắp xếp và lọc trong `CategoryDetailScreen`

Sau khi `UiState.Success` được nhận, danh sách sách được xử lý qua Higher-Order Functions trước khi hiển thị:

```kotlin
is UiState.Success -> {
    // Bước 1: Sắp xếp theo tiêu chí người dùng chọn
    val sorted: List<Book> = when (sortOption) {
        "Giá tăng dần"  -> state.data.sortedBy           { it.displayPrice() }
        "Giá giảm dần"  -> state.data.sortedByDescending { it.displayPrice() }
        "Tên A-Z"       -> state.data.sortedBy           { it.title }
        else            -> state.data
    }

    // Bước 2: Lọc theo khoảng giá người dùng chọn
    val books: List<Book> = when (selectedPriceRange) {
        "Dưới 100k"  -> sorted.filter { it.displayPrice() < 100_000 }
        "100k–200k"  -> sorted.filter { it.displayPrice() in 100_000.0..200_000.0 }
        "Trên 200k"  -> sorted.filter { it.displayPrice() > 200_000 }
        else         -> sorted
    }
}
```

**Giải thích:**

| Hàm | Kiểu lambda | Ý nghĩa |
|---|---|---|
| `sortedBy { it.displayPrice() }` | `(Book) -> Comparable<*>` | Sắp xếp tăng dần theo giá hiển thị |
| `sortedByDescending { it.displayPrice() }` | `(Book) -> Comparable<*>` | Sắp xếp giảm dần |
| `sortedBy { it.title }` | `(Book) -> String` | Sắp xếp A-Z theo tên |
| `filter { it.displayPrice() < 100_000 }` | `(Book) -> Boolean` | Lọc sách dưới 100k |
| `filter { it.displayPrice() in 100_000.0..200_000.0 }` | `(Book) -> Boolean` | Lọc khoảng 100k–200k dùng `in` range |

Các hàm này là Higher-Order Function — nhận lambda `{ it.displayPrice() }` làm tham số, không thay đổi danh sách gốc (immutable), luôn trả về danh sách mới.

### Higher-Order Functions trong `CartViewModel`

```kotlin
val subtotal: Double get() = cartItems.sumOf { it.book.price * it.quantity }

fun removeItem(bookId: String) {
    cartItems.removeAll { it.book.id == bookId }
}

fun addBook(book: Book, quantity: Int = 1) {
    val index = cartItems.indexOfFirst { it.book.id == book.id }
    if (index >= 0) {
        cartItems[index] = cartItems[index].copy(quantity = cartItems[index].quantity + quantity)
    } else {
        cartItems.add(CartItem(book, quantity))
    }
}
```

**Giải thích:**

- `sumOf { it.book.price * it.quantity }`: tính tổng tiền giỏ hàng — Higher-Order Function nhận lambda tính giá trị mỗi phần tử rồi cộng dồn.
- `removeAll { it.book.id == bookId }`: xóa tất cả phần tử thỏa điều kiện — lambda trả về `Boolean`.
- `indexOfFirst { it.book.id == book.id }`: tìm vị trí phần tử đầu tiên thỏa điều kiện — trả `-1` nếu không tìm thấy (thay cho vòng lặp thủ công).

_Hình 5.X. Màn hình giỏ hàng — Tổng tiền tính bằng `sumOf`, xóa sản phẩm bằng `removeAll`_

---

## 5.3.6. Coroutines trong kiến trúc đồ án

### `BookDetailViewModel` — Tải chi tiết sách

```kotlin
@HiltViewModel
class BookDetailViewModel @Inject constructor(
    private val repository: BookRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var book by mutableStateOf<Book?>(null)
        private set
    var isLoading by mutableStateOf(false)
        private set

    init {
        val bookId = savedStateHandle.get<String>("bookId")
        if (bookId != null) {
            fetchBookDetail(bookId)
        }
    }

    private fun fetchBookDetail(id: String) {
        viewModelScope.launch {          // Khởi động Coroutine gắn với ViewModel
            isLoading = true
            book = repository.getBookById(id)   // suspend function — tạm dừng, không chặn thread
            isLoading = false
        }
    }
}
```

**Giải thích:**

- `viewModelScope.launch`: khởi động Coroutine trong scope của ViewModel — khi ViewModel bị hủy (người dùng rời màn hình), Coroutine tự động bị hủy, tránh memory leak.
- `repository.getBookById(id)` là `suspend fun`: Coroutine tạm dừng tại đây chờ kết quả từ API (I/O), không chặn Main Thread. Giao diện vẫn phản hồi mượt mà trong lúc chờ.
- `isLoading = true/false`: cập nhật trạng thái trực tiếp trên Main Thread (Dispatcher mặc định của `viewModelScope` là `Dispatchers.Main`).

### `CategoryViewModel` — Tải danh sách sách với UiState

```kotlin
fun loadBooks(query: String) {
    viewModelScope.launch {
        _uiState.value = UiState.Loading       // Cập nhật UI ngay lập tức

        repository.getBooksResult(query)        // suspend: chờ API không chặn thread
            .onSuccess { books ->
                _uiState.value = UiState.Success(books)
            }
            .onFailure { error ->
                _uiState.value = UiState.Error(error.message ?: "Lỗi không xác định")
            }
    }
}
```

### `CheckoutViewModel` — Đặt hàng và tích hợp MoMo

```kotlin
fun placeOrder(cartItems: List<CartItem>, ...) {
    viewModelScope.launch {
        isLoading = true
        errorMessage = null

        val userId = tokenManager.userId.first()   // suspend: đọc từ DataStore Flow

        val request = OrderRequest(
            userId = userId ?: 0L,
            items  = cartItems.map { item ->       // Higher-Order Function: map
                OrderItemRequest(
                    bookId    = item.book.id,
                    quantity  = item.quantity,
                    price     = item.book.price,
                    bookTitle = item.book.title,
                    imgUrl    = null
                )
            }
        )

        val result = orderRepository.createOrder(request)   // suspend: gọi backend API
        isLoading = false

        result.onSuccess { paymentResponse ->
            createdOrderId = paymentResponse.orderId
            if (paymentMethod == "MOMO") {
                pendingPayUrl   = paymentResponse.payUrl       // URL MoMo thanh toán
                pendingDeeplink = paymentResponse.deeplink     // Deep link mở app MoMo
            } else {
                orderSuccess = true   // COD — hiện dialog thành công
            }
        }
        result.onFailure { errorMessage = it.message }
    }
}
```

**Giải thích flow Coroutines trong CheckoutViewModel:**

1. `viewModelScope.launch` — bắt đầu Coroutine trên Main Thread.
2. `tokenManager.userId.first()` — `suspend fun` đọc bất đồng bộ từ DataStore (bộ nhớ cục bộ).
3. `cartItems.map { ... }` — Higher-Order Function đồng bộ, chuyển danh sách `CartItem` → `OrderItemRequest`.
4. `orderRepository.createOrder(request)` — `suspend fun` gọi backend API (Retrofit), tạm dừng Coroutine chờ phản hồi HTTP.
5. Sau khi có kết quả, Coroutine tiếp tục trên Main Thread, cập nhật state → Compose tự recompose.

---

## 5.3.7. Kết quả đạt được

| Kỹ thuật | Vấn đề giải quyết | Kết quả thực tế |
|---|---|---|
| **Null Safety** | Dữ liệu API có thể thiếu trường | Không có `NullPointerException` trong toàn bộ tầng data |
| **Sealed Class `UiState`** | Giao diện cần phản ánh đúng mọi trạng thái | `when` exhaustive: Loading / Success / Error được xử lý đầy đủ |
| **Extension Functions** | Định dạng tiền tệ, giá trị mặc định | API ngôn ngữ tự nhiên: `price.toVnd()`, `text.orDefault()` |
| **Higher-Order Functions** | Lọc và sắp xếp danh sách sách | Code ngắn gọn, không có vòng lặp thủ công |
| **Coroutines** | Gọi API có thể mất vài giây | App không bao giờ đóng băng, tự hủy khi rời màn hình |

Việc kết hợp năm kỹ thuật này tạo ra kiến trúc nhất quán: dữ liệu từ Google Books API và backend được ánh xạ an toàn (Null Safety) → xử lý bất đồng bộ (Coroutines) → phát trạng thái (StateFlow + UiState Sealed Class) → UI phản ánh trực quan (Jetpack Compose `when` expression) → danh sách được lọc/sắp xếp (Higher-Order Functions) trước khi hiển thị ra màn hình.

