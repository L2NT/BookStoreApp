## 10.3. Demo sản phẩm

Phần này trình bày luồng chức năng chính của ứng dụng BookVerse theo trình tự:
đăng ký tài khoản → đăng nhập → trang chủ → tìm kiếm → giỏ hàng → thanh toán
→ xem đơn hàng.

---

### 10.3.1. Màn hình Đăng ký

**Kết quả đạt được:** Màn hình đăng ký với validation client-side đầy đủ và xử
lý trạng thái bất đồng bộ qua Sealed Class `AuthState`.

`RegisterScreen` gồm sáu trường nhập liệu: Họ và tên, Tên đăng nhập, Email, Số
điện thoại, Mật khẩu, Xác nhận mật khẩu. Khi nhấn "Đăng ký", ứng dụng validate
toàn bộ form (định dạng email, độ dài số điện thoại, mật khẩu khớp nhau). Nút
bị vô hiệu hóa trong lúc gọi API để tránh gửi request trùng lặp; khi API trả
về, `AuthState` phân loại kết quả: thành công → chuyển sang màn hình đăng nhập,
thất bại → Toast thông báo lỗi và highlight trường tương ứng.

Hình 10.X. Giao diện màn hình Đăng ký

Hình 10.X. Thông báo lỗi validation

---

### 10.3.2. Màn hình Đăng nhập

**Kết quả đạt được:** Màn hình đăng nhập tự động bỏ qua nếu token JWT còn hiệu
lực, hỗ trợ điều hướng trả về đúng màn hình trước khi yêu cầu đăng nhập.

`LoginScreen` nhận tham số `returnRoute` (`login/{returnRoute}`) để sau khi đăng
nhập thành công đưa người dùng về đúng nơi (ví dụ `cart`, `account`). Khi mở
màn hình, ứng dụng kiểm tra token trong `SharedPreferences`; nếu còn hợp lệ,
bỏ qua form và chuyển thẳng đến `returnRoute`.

Hình 10.X. Giao diện màn hình Đăng nhập

---

### 10.3.3. Trang chủ

**Kết quả đạt được:** Trang chủ cuộn mượt mà với dữ liệu sách tải từ Google
Books API, hiển thị trạng thái loading và thông báo thêm giỏ hàng qua Snackbar.

`HomeScreen` dùng `LazyColumn` hiển thị nối tiếp: `HomeTopBar`, `SearchBar`,
`PromoBanner`, `CategorySection` (danh mục ngang), và `BookSection` (sách nổi
bật). Dữ liệu được `HomeViewModel` tải bất đồng bộ qua Coroutines; trong lúc
chờ, hiển thị `CircularProgressIndicator`. Khi nhấn "Thêm vào giỏ",
`cartViewModel.addBook()` được gọi và `Snackbar` xác nhận ngay phía dưới.

Hình 10.X. Giao diện trang chủ — danh mục và banner

Hình 10.X. Giao diện trang chủ — danh sách sách nổi bật

---

### 10.3.4. Tìm kiếm và Chi tiết sách

**Kết quả đạt được:** Luồng tìm kiếm hai bước và màn hình chi tiết sách với
bottom bar hành động cố định.

**`SearchScreen`:** Hiển thị gợi ý xu hướng tìm kiếm (top 5, màu sắc phân hạng
bằng `when`) và 12 danh mục phổ biến theo lưới 2 cột (`chunked(2)`).

**`BookSearchResultsScreen`:** `SearchViewModel` gọi Google Books API và hiển
thị kết quả bằng `LazyVerticalGrid(GridCells.Fixed(2))`. Số lượng kết quả được
in ngay đầu danh sách.

**`BookDetailScreen`:** Nội dung cuộn qua `LazyColumn` (ảnh bìa, thông tin, mô
tả, thông số kỹ thuật, đánh giá). Bottom bar cố định gồm bộ chọn số lượng và
hai nút: **Thêm vào giỏ** và **Mua ngay**.

Hình 10.X. Giao diện màn hình Tìm kiếm

Hình 10.X. Kết quả tìm kiếm — lưới 2 cột

Hình 10.X. Giao diện Chi tiết sách

---

### 10.3.5. Giỏ hàng

**Kết quả đạt được:** Giỏ hàng với guard xác thực, tính toán đơn hàng theo thời
gian thực và hỗ trợ mã giảm giá.

`CartScreen` kiểm tra đăng nhập khi mở; nếu chưa đăng nhập, chuyển đến
`login/cart`. Mỗi sản phẩm hiển thị ảnh bìa (`AsyncImage` — Coil), tên, giá
(`Double.toVnd()`), bộ điều chỉnh số lượng và nút xóa. `OrderSummaryCard` tính
tạm tính, phí ship, giảm giá và tổng cộng tự động từ `CartViewModel`. Nút
"Thanh toán" điều hướng đến `CheckoutScreen`.

Hình 10.X. Giao diện Giỏ hàng

---

### 10.3.6. Thanh toán

**Kết quả đạt được:** Form thanh toán tự điền từ profile, tích hợp MoMo qua
Intent deeplink, và bảo toàn dữ liệu form khi xoay màn hình bằng `rememberSaveable`.

`CheckoutScreen` dùng `rememberSaveable` cho tất cả biến state của form, giúp
dữ liệu không bị mất khi xoay màn hình. Form tự điền từ `accountViewModel
.userProfile` qua `LaunchedEffect`. Người dùng chọn phương thức thanh toán qua
`RadioButton`: **COD** hoặc **MoMo**. Với MoMo, ứng dụng gọi API lấy `deeplink`
và mở app MoMo bằng `Intent(ACTION_VIEW)`; nếu chưa cài, fallback sang trình
duyệt.

Hình 10.X. Giao diện Thanh toán — form giao hàng

Hình 10.X. Chọn phương thức thanh toán

Hình 10.X. Giao diện thanh toán MoMo (sandbox)

---

### 10.3.7. Đơn hàng của tôi

**Kết quả đạt được:** Màn hình quản lý đơn hàng với tab lọc trạng thái, tự động
reload khi quay lại app và hỗ trợ hủy hoặc thanh toán lại.

`OrderHistoryScreen` dùng `PrimaryScrollableTabRow` với năm tab: Tất cả, Chờ
xác nhận, Đang xử lý, Đang giao, Đã hủy. Sau khi thanh toán MoMo và quay lại
app, `DisposableEffect` + `LifecycleEventObserver` phát hiện `ON_RESUME` và tự
động tải lại danh sách. Nếu không còn đơn `PENDING`, tab tự chuyển sang "Đang
xử lý". Đơn hàng `PENDING` có thể bấm để mở `AlertDialog` với hai lựa chọn:
**Hủy đơn** hoặc **Thanh toán MoMo**.

Hình 10.X. Tab Chờ xác nhận với đơn có thể bấm

Hình 10.X. Tab Đang xử lý sau khi thanh toán MoMo thành công

Hình 10.X. Dialog tùy chọn — Hủy đơn / Thanh toán MoMo

