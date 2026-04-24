# 📚 EXAM ANSWERS — Hệ thống đáp án kiểm tra thực hành
**Nhóm 35 — Kotlin Jetpack Compose**

---

## 🗺️ Flow Tổng Quát Hệ Thống

```
┌─────────────────────────────────────────────────────────────────┐
│                     GIÁO VIÊN RA ĐỀ                             │
│                                                                   │
│  Nguồn đề: Chương 11 (Bug đã gặp) hoặc Chương 12 (Hướng PT)    │
│                                                                   │
│         ┌──────────────────┐   ┌──────────────────┐             │
│         │   PATTERN A      │   │   PATTERN B      │             │
│         │  "Fix Bug"       │   │  "Mở rộng UI"    │             │
│         │                  │   │                  │             │
│         │ Thầy cho: code   │   │ Thầy cho: yêu   │             │
│         │ Kotlin bị lỗi    │   │ cầu tính năng /  │             │
│         │ có chủ ý         │   │ data JSON mẫu    │             │
│         └────────┬─────────┘   └────────┬─────────┘             │
└──────────────────┼──────────────────────┼───────────────────────┘
                   │                      │
                   ▼                      ▼
┌──────────────────────────────────────────────────────────────────┐
│                   SINH VIÊN XỬ LÝ (không WiFi)                   │
│                                                                   │
│  1. Đọc đề → xác định Pattern A hay B                           │
│  2. Tìm package tương ứng trong exam-answers/                    │
│  3. Mở NOTES.md → đọc hướng dẫn kéo thả                        │
│  4. Kéo thư mục app/ vào BookStore/ (Replace)                   │
│  5. Android Studio: Build → Rebuild Project → Run               │
│  6. Demo trực tiếp trên máy / giải thích miệng                  │
└──────────────────────────────────────────────────────────────────┘
```

---

## 🔴 Pattern A — Fix Bug / Giải thích cơ chế

### Cách thầy ra đề
Thầy đưa ra một đoạn code Kotlin **có lỗi chủ ý** (hoặc hỏi "tại sao code này lỗi?") và yêu cầu:
- Chỉ ra lỗi nằm ở đâu
- Giải thích **tại sao** bị lỗi (cơ chế kỹ thuật)
- Sửa lại đúng + giải thích giải pháp

### Dạng lỗi thường gặp

| Dạng lỗi | Ví dụ | Giải pháp |
|----------|-------|-----------|
| **Logic sai** | `mutableStateOf(list)` thay vì `mutableStateListOf()` | Compose không detect structural change trong List |
| **NPE / Null** | `items!!` thay vì `items ?: emptyList()` | Dùng Elvis `?:` hoặc safe call `?.` |
| **Missing annotation** | Quên `@SerializedName("user_id")` | Gson không map snake_case → camelCase tự động |
| **Scope sai** | `hiltViewModel()` riêng mỗi screen → mỗi screen instance khác nhau | Hoist ViewModel lên MainScreen |
| **DI thiếu** | Thiếu `@Provides` hoặc inject sai type | Thêm provider vào AppModule |
| **Extension visibility** | `private fun Book.displayPrice()` bị gọi từ file khác | Đổi thành `public` (bỏ `private`) |
| **Navigation flat** | `NavHost` flat thay vì `navigation(route = "graph")` | Dùng nested graph với `hierarchy` để highlight tab |

### Cách dùng trong exam
```
1. Xem code thầy cho → tìm dòng có khả năng lỗi
2. Mở file _broken/ tương ứng trong exam-answers/ để tham chiếu
3. So sánh với code đúng trong BookStore/ (src/main/)
4. Giải thích bằng ngôn ngữ của comment trong project
```

---

## 🟦 Pattern B — Mở rộng UI (Tạo Composable mới)

### Cách thầy ra đề
Thầy đưa ra **yêu cầu mới** (không phải code lỗi) và một bộ input, ví dụ:
> *"Hãy tạo component hiển thị trạng thái đơn hàng: PENDING=xám, SHIPPED=xanh, DELIVERED=xanh lá, CANCELLED=đỏ"*

Hoặc cung cấp JSON mẫu:
> *`{ "status": "SHIPPED", "rating": 4.3, "stock": 2 }`* → "Hãy hiển thị dữ liệu này lên UI"

### Công thức chung (Template Pattern B)

```kotlin
// Bước 1: Nhận input (status, rating, count, ...)
@Composable
fun XxxComponent(input: TypeA) {

    // Bước 2: Map input → (label, color) bằng when()
    val (label, color) = when (input) {
        "STATE_A" -> "Tên hiển thị A" to Color(0xFFxxxxxx)
        "STATE_B" -> "Tên hiển thị B" to Color(0xFFyyyyyy)
        else      -> "Không xác định"  to Color.Gray
    }

    // Bước 3: Render bằng Material3 component
    // Chip / Badge / Row of Icons / LinearProgressIndicator / ...
    AssistChip(
        onClick = {},
        label   = { Text(label, color = Color.White, fontSize = 12.sp) },
        colors  = AssistChipDefaults.assistChipColors(containerColor = color)
    )
}
```

### Mapping các loại input → component

| Input | Component | Package |
|-------|-----------|---------|
| `status: String` (PENDING/SHIPPED/…) | `AssistChip` màu theo trạng thái | `13_order_status_chip` |
| `cartItems.size: Int` | `BadgedBox` + `Badge` trên icon Cart | `14_cart_badge` |
| `quantity: Int` (tồn kho) | `SuggestionChip` cảnh báo màu cam/đỏ | `15_stock_badge` |
| `rating: Float` (0.0 → 5.0) | `Row` lặp Icon ★ tô màu vàng | `16_rating_bar` |
| `isDarkTheme: Boolean` | `MaterialTheme` + `darkColorScheme` | `01_dark_mode` |

### Cách dùng trong exam
```
1. Đọc yêu cầu → xác định input type và mapping logic
2. Tìm package Pattern B phù hợp (13→16)
3. Mở NOTES.md → xem cấu trúc file cần tạo
4. Kéo file DROP-IN vào project
5. Demo bằng cách gọi Composable trong màn hình sẵn có
   (vd: gọi OrderStatusChip("SHIPPED") trong OrderHistoryScreen)
```

---

## Hướng dẫn sử dụng nhanh

1. **Đọc đề thầy ra** → xác định loại đề (Pattern A hay B) → tìm package tương ứng
2. **Mở NOTES.md** của package → đọc hướng dẫn kéo thả
3. **Kéo thả** theo bảng → Build → Rebuild → Run → demo

---

## Hai loại đề

| Loại | Input thầy cho | Output | Packages cover |
|------|---------------|--------|----------------|
| **Pattern A — Fix Bug** | Code Kotlin bị lỗi có chủ ý | Sửa lại + giải thích | 03→12 |
| **Pattern B — Mở rộng UI** | Yêu cầu tính năng / data JSON | Composable mới + demo trực tiếp | 01, 02, 13→16 |

---

## Danh sách packages

### 🔴 Pattern A — Fix Bug / Giải thích

| # | Package | Nguồn đề | Khả năng | Hành động |
|---|---------|----------|----------|-----------|
| 01 | `01_dark_mode/` | Ch.12 Mục 12.1.3 | 🔴 Rất cao | **Kéo thả** 4 file |
| 02 | `02_wishlist/` | Ch.12 Mục 12.1.1 | 🔴 Rất cao | **Kéo thả** 6 file |
| 03 | `03_navigation_explain/` | Ch.11 Bug Navigation | 🔴 Rất cao | **Chỉ giải thích** (đã fix) |
| 04 | `04_profile_dialog_explain/` | Ch.11 Bug Dialog | 🔴 Cao | **Chỉ giải thích** (đã fix) |
| 05 | `05_uistate_explain/` | Ch.11 KK5 UiState | 🔴 Cao | **Chỉ giải thích** (đã có) |
| 06 | `06_display_price_extension/` | Ch.11 Bug displayPrice | 🟡 Vừa | **Chỉ giải thích** (đã fix) |
| 07 | `07_jwt_serialized_name/` | Ch.11 Bug JwtResponse | 🟡 Vừa | **Chỉ giải thích** (đã fix) |
| 08 | `08_nullpointer_orderhistory/` | Ch.11 Bug NPE Order | 🟡 Vừa | **Chỉ giải thích** (đã fix) |
| 09 | `09_okhttp_jwt_interceptor/` | Ch.11 KK2 JWT Interceptor | 🟡 Vừa | **Kéo thả** 2 file |
| 10 | `10_google_books_dto/` | Ch.11 KK1 Google Books DTO | 🔴 Cao | **Chỉ giải thích** (đã fix) |
| 11 | `11_cart_state_management/` | Ch.11 KK3 Cart StateFlow | 🔴 Cao | **Chỉ giải thích** (đã fix) |
| 12 | `12_hilt_configuration/` | Ch.11 KK4 Hilt | 🟡 Vừa | **Chỉ giải thích** (đã fix) |

### 🟦 Pattern B — Mở rộng UI (tạo Composable mới)

| # | Package | Nguồn đề | Khả năng | Hành động |
|---|---------|----------|----------|-----------|
| 13 | `13_order_status_chip/` | Ch.12.1.2 Trạng thái đơn hàng | 🔴 Rất cao | **DROP-IN** 1 file |
| 14 | `14_cart_badge/` | Ch.11 KK3 Cart state | 🔴 Rất cao | **Kéo thả** 2 file |
| 15 | `15_stock_badge/` | Ch.12.1.2 Tồn kho | 🟡 Vừa | **DROP-IN** 1 file |
| 16 | `16_rating_bar/` | Ch.12.1.1 Đánh giá | 🟡 Vừa | **DROP-IN** 1 file |

---

## Chi tiết từng package

### 📦 01 — Dark Mode *(KÉO THẢ)*
```
Kéo: exam-answers/01_dark_mode/app/ → BookStore/app/
Chọn Replace khi hỏi.

File thêm vào:
  viewmodel/ThemeViewModel.kt          ← DROP-IN (mới)
  ui/theme/Theme.kt                    ← REPLACE
  MainActivity.kt                      ← REPLACE
  ui/screens/SettingsScreen.kt         ← REPLACE
```
**Demo:** Vào Settings → bật Switch "Chế độ tối" → app chuyển dark ngay lập tức.

---

### 📦 02 — Wishlist *(KÉO THẢ)*
```
Kéo: exam-answers/02_wishlist/app/ → BookStore/app/
Chọn Replace khi hỏi.

File thêm vào:
  viewmodel/WishlistViewModel.kt       ← DROP-IN (mới)
  ui/screens/WishlistScreen.kt         ← DROP-IN (mới)
  ui/screens/MainScreen.kt             ← REPLACE (thêm WishlistViewModel + route)
  ui/screens/AccountScreen.kt          ← REPLACE (thêm menu "Sách yêu thích")
  ui/screens/BookDetailScreen.kt       ← REPLACE (thêm nút ❤️)
  ui/components/DetailTopBar.kt        ← REPLACE (thêm param extraActions)
```
**Demo:** Chi tiết sách → ❤️ → Account → Sách yêu thích → thấy sách → xóa → biến mất.

---

### 📖 03 — Navigation (EXPLAIN ONLY)
Project đã fix. Mở `MainScreen.kt` chỉ vào `navigation(route = "home_graph")`.  
File code lỗi tham khảo: `_broken/MainScreen_flat_example.kt`

---

### 📖 04 — Profile Dialog (EXPLAIN ONLY)
Project đã fix. Mở `ProfileScreen.kt` line 31-43 chỉ vào `if (viewModel.updateSuccess)`.  
File code lỗi tham khảo: `_broken/ProfileScreen_broken.kt`

---

### 📖 05 — UiState Sealed Class (EXPLAIN ONLY)
Project đã có. Mở `UiState.kt` + `CategoryViewModel.kt`.  
File code lỗi tham khảo: `_broken/HomeViewModel_broken.kt`

---

### 📦 06 — displayPrice Extension *(EXPLAIN ONLY)*
Mở `utils/Extensions.kt` → `fun Book.displayPrice()` (public).  
Mở `CategoryDetailScreen.kt` → `addBook(book.copy(price = book.displayPrice()), ...)`.  
File lỗi: `_broken/Extensions_broken.kt`

---

### 📦 07 — JWT @SerializedName *(EXPLAIN ONLY)*
Mở `data/dto/response/JwtResponse.kt` → `@SerializedName("id") val userId`.  
File lỗi: `_broken/JwtResponse_broken.kt`

---

### 📦 08 — NPE OrderHistory *(EXPLAIN ONLY)*
Mở `data/dto/response/OrderResponse.kt` → `val items: List<OrderItemResponse> = emptyList()`.  
File lỗi: `_broken/OrderResponse_broken.kt`

---

### 📦 09 — OkHttp JWT Interceptor *(KÉO THẢ)*
```
Kéo: exam-answers/09_okhttp_jwt_interceptor/app/ → BookStore/app/
Chọn Replace khi hỏi.

File thêm vào:
  data/api/AuthInterceptor.kt    ← DROP-IN (mới)
  di/AppModule.kt                ← REPLACE (thêm provideOkHttpClient + AuthInterceptor)
```
**Demo:** Đăng nhập → gọi API lấy đơn hàng → Logcat thấy `Authorization: Bearer ...` header.

---

### 📖 10 — Google Books DTO + toDomain() *(EXPLAIN ONLY)*
Mở `data/dto/GoogleBookDto.kt` → chỉ các DTO lồng nhau.  
Mở `data/repo/BookRepository.kt` → `fun BookItem.toDomainModel()` với Elvis `?:` chain.  
File lỗi: `_broken/BookRepository_broken.kt`

---

### 📖 11 — Cart State Management / ViewModel Hoisting *(EXPLAIN ONLY)*
Mở `MainScreen.kt` → `val cartViewModel: CartViewModel = hiltViewModel()` được hoist.  
Chỉ ra cartViewModel được truyền vào `HomeScreen(cartViewModel = cartViewModel)`, `BookDetailScreen(...)`, `CartScreen(...)`.  
⚠️ Nếu thầy hỏi về StateFlow+Room: đọc mục "Lưu ý quan trọng" trong NOTES.md.  
File lỗi: `_broken/CartViewModel_broken.kt`

---

### 📖 12 — Hilt Configuration *(EXPLAIN ONLY)*
Mở `di/AppModule.kt` → chỉ `@Provides`, `@Singleton`, dependency graph.  
Mở `viewmodel/CategoryViewModel.kt` → `@HiltViewModel @Inject constructor`.  
File lỗi: `_broken/AppModule_broken.kt`

---

### 📦 13 — OrderStatusChip *(DROP-IN 1 file)*
```
Kéo: exam-answers/13_order_status_chip/app/ → BookStore/app/
Chọn Replace khi hỏi.

File thêm vào:
  ui/components/OrderStatusChip.kt    ← DROP-IN (mới)
```
**Demo:** Gọi `OrderStatusChip("SHIPPED")` → thấy chip tím "Đang giao hàng".  
**Pattern:** Giống `UVIndexIndicator` — `when(status)` → `(label, color)` → chip UI.

---

### 📦 14 — Cart Badge *(KÉO THẢ 2 file)*
```
Kéo: exam-answers/14_cart_badge/app/ → BookStore/app/
Chọn Replace khi hỏi.

File thêm vào:
  ui/components/AppBottomNavigation.kt    ← REPLACE (thêm BadgedBox)
  ui/screens/MainScreen.kt               ← REPLACE (truyền cartItems.size)
```
**Demo:** Thêm sách vào giỏ → badge số đỏ hiện trên icon giỏ hàng.  
⚠️ Nếu đã apply Package 02 (Wishlist) → chỉ REPLACE `AppBottomNavigation.kt`, sửa tay `MainScreen.kt`.

---

### 📦 15 — StockBadge *(DROP-IN 1 file)*
```
Kéo: exam-answers/15_stock_badge/app/ → BookStore/app/

File thêm vào:
  ui/components/StockBadge.kt    ← DROP-IN (mới)
```
**Demo:** Gọi `StockBadge(3)` → chip cam "Sắp hết (3 còn lại)".

---

### 📦 16 — StarRating *(DROP-IN 1 file)*
```
Kéo: exam-answers/16_rating_bar/app/ → BookStore/app/

File thêm vào:
  ui/components/StarRating.kt    ← DROP-IN (mới)
```
**Demo:** Gọi `StarRating(rating = 4.3, showCount = true, count = 128)` → sao icon Material vàng.

---

## ⚠️ Lưu ý quan trọng

1. **Backup trước khi kéo thả**: `MainScreen.kt` và `BookDetailScreen.kt` là file lớn — nếu đề thầy khác với dự đoán, cần restore. Dùng git hoặc copy thủ công.
2. **Sau khi kéo thả**: Build → Rebuild Project → Run (không chỉ sync Gradle).
3. **Nếu thầy hỏi miệng**: Đọc phần "Giải thích cho thầy" trong NOTES.md tương ứng.
4. **Package 02 (Wishlist) cần chú ý**: `BookDetailScreen.kt` REPLACE thêm param `wishlistViewModel` → nếu thầy không hỏi wishlist, ĐỪNG kéo thả package này.
5. **Pattern B packages 13/15/16**: Chỉ DROP-IN 1 file nhỏ → an toàn nhất, không risk conflict với code hiện tại.
