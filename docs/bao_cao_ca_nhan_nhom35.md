# BÁO CÁO CÁ NHÂN — NHÓM 35
**Học phần:** Các Công Nghệ Lập Trình Hiện Đại  
**Đề tài:** Tìm Hiểu và Ứng Dụng Công Nghệ Kotlin  
**Giảng viên hướng dẫn:** Phạm Thi Vương  
**Trường:** Đại học Sài Gòn — Khoa Công Nghệ Thông Tin  
**Ngày:** TP.Hồ Chí Minh, 11 tháng 04 năm 2026

---

## THÀNH VIÊN NHÓM

| STT | Họ và tên | MSSV |
|---|---|---|
| 1 | Nguyễn Hào Phong | 3121560070 |
| 2 | Lê Nguyễn Nhất Tâm | 3122410369 |
| 3 | Phan Trung Nghĩa | 3121410345 |

---

# PHẦN 1 — BÁO CÁO CÁ NHÂN: NGUYỄN HÀO PHONG (MSSV: 3121560070)

---

## I. Nhiệm vụ

- Đề xuất ý tưởng trọng tâm của dự án: xây dựng ứng dụng bán sách trực tuyến **BookVerse** trên nền tảng Android, sử dụng Kotlin và Jetpack Compose, tận dụng Google Books API làm nguồn dữ liệu sách chính, kết nối với backend Spring Boot (JWT, MySQL) để quản lý người dùng, đơn hàng và đánh giá.
- Thiết kế và xây dựng database bằng Spring Boot. Hướng dẫn các thành viên cài đặt và chạy database trên máy.
- Set up dự án và GitHub.
- Thiết kế và triển khai giao diện: Trang chủ, Trang chi tiết sách, Trang tìm kiếm sách, Trang kết quả tìm kiếm.
- Thực hiện và hoàn thiện các chương kỹ thuật trọng tâm trong báo cáo:
  - **Chương 1:** Giới thiệu chung
  - **Chương 2:** Cơ hội nghề nghiệp và thị trường
  - **Chương 7:** Kiến trúc MVVM và Retrofit
  - **Chương 8:** Dependency Injection và Hilt
- Cài đặt và triển khai dự án, thiết kế UI, merge code của các thành viên và sửa lỗi hệ thống, đẩy hệ thống lên GitHub.
- Hỗ trợ kiểm thử, chỉnh sửa định dạng báo cáo, và tổng hợp nội dung kỹ thuật với các thành viên khác.
- Tham gia hoàn thiện báo cáo nhóm, viết nhật ký làm việc và báo cáo cá nhân.

---

## II. Các công việc hằng tuần

### Tuần 1 (12/01 – 18/01)
- Tham gia cùng nhóm thảo luận chọn đề tài, liệt kê các công nghệ mới (Kotlin, Flutter, React Native).
- Tìm hiểu tổng quan về Kotlin, lịch sử hình thành và ưu điểm so với Java.
- Đề xuất định hướng xây dựng ứng dụng thực tế (bán sách, đặt vé, …) để áp dụng Kotlin.

### Tuần 2 (19/01 – 25/01)
- Chốt đề tài nghiên cứu Kotlin cho nhóm.
- Phân công nhiệm vụ: phụ trách tìm hiểu về Jetpack Compose, Navigation, và làm báo cáo chương 1.
- Bắt đầu tự học Kotlin nâng cao: Coroutines, Flow, Sealed Class, Extension Functions.

### Tuần 3 (26/01 – 01/02)
- Thiết kế và xây dựng database.
- Thiết kế giao diện bằng Figma.
- Hoàn thành chương 2 trong báo cáo.

### Tuần 4 (02/02 – 08/03) *(do nghỉ Tết, có gián đoạn)*
- Test API, xin ý kiến các thành viên trong nhóm về database và mở rộng database.

### Tuần 5 (09/03 – 15/03)
- Hỗ trợ các thành viên trong nhóm cài đặt database.
- Hỗ trợ thiết lập cơ sở dữ liệu: trực tiếp hướng dẫn các thành viên cài đặt, cấu hình môi trường Database; khắc phục các lỗi phát sinh trong quá trình kết nối, đảm bảo toàn bộ nhóm có môi trường phát triển đồng bộ.
- Thiết lập mã nguồn và lớp mạng (Network Layer): khởi tạo GitHub Repository, thống nhất Git workflow; cài đặt và cấu hình Retrofit, xây dựng các interface và data model để kết nối với Google API.
- Viết mục Chương 7: lý thuyết, ví dụ và giải thích.

### Tuần 6 (16/03 – 22/03)
- Hoàn thiện toàn bộ màn hình Trang chủ (HomeScreen) theo đúng thiết kế Figma.
- Áp dụng kỹ thuật State Hoisting để quản lý luồng sự kiện; cài đặt các action điều hướng chuyển trang (Navigation).
- Kết nối thành công với Google Books API thông qua Retrofit; xử lý logic tại ViewModel, bóc tách dữ liệu JSON, hiển thị lên giao diện; tích hợp thư viện Coil để tải và cache ảnh bìa sách.
- Viết mục Chương 8: lý thuyết, ví dụ và giải thích.

### Tuần 7 (23/03 – 29/03)
- Phân tích thiết kế và lập trình giao diện Trang Chi tiết sách (BookDetailScreen) bằng Jetpack Compose.
- Xử lý hiển thị các thông tin động (tiêu đề, tác giả, đánh giá sao, tính toán phần trăm giảm giá) và dùng Coil để tối ưu tải ảnh bìa sách.
- Lập trình tính năng tìm kiếm trên TopBar.

### Tuần 8 (30/03 – 05/04)
- Xây dựng giao diện Trang Tìm kiếm (SearchScreen) và trang kết quả tìm kiếm.
- Xử lý các trạng thái màn hình: đang tải, rỗng, hiển thị dữ liệu thành công.
- Cấu hình Jetpack Navigation để truyền tham số (từ khóa tìm kiếm) giữa các màn hình.
- Xây dựng SearchViewModel và kết nối với Repository để gọi Google Books API thực hiện tìm kiếm theo từ khóa.

### Tuần 9 (06/04 – 12/04)
- Merge code các thành viên, test ứng dụng và yêu cầu các thành viên sửa lỗi.
- Bổ sung mục đồ án chương 7, 8.

### Tuần 10 (13/04 – 19/04)
- Hoàn thiện báo cáo cá nhân, cập nhật nhật ký làm việc.
- Tổng hợp nội dung báo cáo nhóm, kiểm tra lỗi chính tả và định dạng.

---

## III. Đóng góp trong báo cáo

### 1. Vai trò và đóng góp trong dự án

Trong dự án BookVerse, giữ vai trò **triển khai dự án, thiết kế database và phát triển giao diện người dùng (UI)**, đồng thời chịu trách nhiệm viết các chương kỹ thuật quan trọng trong báo cáo.

#### a) Triển khai kiến trúc và nền tảng dự án
- Thiết lập cấu trúc dự án, áp dụng quản lý thư viện bằng **Version Catalog** (`libs.versions.toml`) giúp dễ dàng bảo trì và đồng bộ môi trường làm việc nhóm.
- Tích hợp mô hình **Dependency Injection** sử dụng Dagger Hilt để quản lý vòng đời của các ViewModel (HomeViewModel, CartViewModel, SearchViewModel, …) và các thành phần một cách chặt chẽ.
- Thiết lập lớp mạng (Network Layer) với Retrofit và OkHttp để giao tiếp với hệ thống API, kết hợp thư viện Coil để xử lý tải hình ảnh.

#### b) Thiết kế và mô hình hóa cơ sở dữ liệu (Database Design)
- Phân tích yêu cầu nghiệp vụ để thiết kế sơ đồ thực thể liên kết (ERD), định nghĩa cấu trúc và mối quan hệ giữa các bảng dữ liệu.
- Thiết kế các Data Class (Model) trong Kotlin đồng bộ với cấu trúc JSON từ RESTful API, đảm bảo quá trình parse dữ liệu chính xác và an toàn.

#### c) Phát triển giao diện người dùng (UI/UX) với Jetpack Compose
- Thiết kế và lập trình toàn bộ các màn hình chính: HomeScreen, BookDetailScreen, SearchScreen, ResultSearchScreen.
- Xây dựng hệ thống Component tái sử dụng: `BookCard`, `Contextual Search`, và các cụm danh sách `BookSection`.

#### d) Xây dựng hệ thống điều hướng (Navigation)
- Cấu hình NavHost để quản lý luồng di chuyển, hỗ trợ truyền tham số động qua route (ví dụ: `book_detail/{bookId}`, `search_results/{query}`), và tích hợp AppBottomNavigation hiển thị linh hoạt dựa trên `currentRoute`.

#### e) Thực hiện các chương kỹ thuật trong báo cáo

- **Chương 1 – Giới thiệu chung:** Trình bày bối cảnh thực hiện đồ án, lý do chọn đề tài xây dựng ứng dụng bán sách trực tuyến BookVerse. Phân tích sự cần thiết của hệ thống, xác định mục tiêu cốt lõi, đối tượng người dùng và phạm vi giới hạn (nền tảng di động Android).

- **Chương 2 – Cơ hội nghề nghiệp và thị trường:** Nghiên cứu và phân tích tổng quan về sự phát triển của thị trường thương mại điện tử, đặc biệt là ngách bán lẻ sách trực tuyến. Đánh giá nhu cầu tuyển dụng và cơ hội nghề nghiệp cho lập trình viên Mobile (Android, Kotlin, Jetpack Compose).

- **Chương 7 – Kiến trúc MVVM và Retrofit:** Trình bày lý thuyết chuyên sâu về mẫu kiến trúc MVVM (Model–View–ViewModel). Giải thích vai trò từng thành phần và nguyên lý luồng dữ liệu một chiều (Unidirectional Data Flow). Mô tả chi tiết việc thiết lập Network Layer bằng Retrofit và OkHttp. Kèm sơ đồ kiến trúc và code minh họa bóc tách logic gọi API ra khỏi giao diện UI.

- **Chương 8 – Dependency Injection và Hilt:** Phân tích lý thuyết về Dependency Injection và lợi ích trong việc nâng cao khả năng bảo trì, giảm tight coupling. Hướng dẫn tích hợp Dagger Hilt vào dự án Android. Giải thích các Annotation quan trọng: `@HiltAndroidApp`, `@AndroidEntryPoint`, `@Inject`, `@Module`. Minh họa bằng code dự án: cách Provide các module Network, Repository và tiêm vào các ViewModel.

---

### 2. Quá trình thiết kế và tích hợp giao diện Trang chủ & Chi tiết sách

**Mục tiêu:** Xây dựng màn hình hiển thị danh sách sản phẩm trực quan, tối ưu hiệu năng cuộn danh sách dài, thiết kế thanh điều hướng ngữ cảnh (Contextual Search Bar) và xử lý luồng thêm vào giỏ hàng.

#### a) Thiết kế các thành phần dùng chung (`BookCard.kt`, `BookSection.kt`)
- Thiết kế `BookCard` sử dụng `Card` kết hợp `Column` và `Row` để bố cục thông tin sách.
- Ứng dụng Coil (`AsyncImage`) để tải và cache ảnh bìa bất đồng bộ từ URL, cấu hình `ContentScale.Crop` và clip bo góc.
- Tự động tính toán và hiển thị % giảm giá (Discount badge) và render số lượng sao đánh giá.
- Tách biệt logic UI (Dumb UI), chỉ nhận dữ liệu `book` và đẩy các action `onBookClick`, `onAddToCart` ra ngoài theo nguyên lý State Hoisting.
- `BookSection`: gom nhóm sách theo lưới 2 cột sử dụng hàm `chunked(2)`, phân bổ không gian đều nhau bằng `Modifier.weight(1f)`.

#### b) Xây dựng giao diện Trang chủ (`HomeScreen.kt`)
- Cấu trúc màn hình bằng `Scaffold` (để chứa Snackbar) và `LazyColumn` để tối ưu hóa bộ nhớ khi render hàng loạt danh mục (TopBar, Banner, Category, BookSection).
- Gọi dữ liệu từ `HomeViewModel` (được tiêm qua Hilt: `= hiltViewModel()`).
- Lắng nghe trạng thái `isLoading`: hiển thị `CircularProgressIndicator` khi loading; render danh sách `BookSection` khi Success.

#### c) Xây dựng thanh điều hướng ngữ cảnh (`DetailTopBar.kt`)
- Thiết kế TopBar chuyển đổi trạng thái (`isSearchActive`) giữa thanh công cụ thông thường và thanh tìm kiếm.
- Tích hợp `FocusRequester` và `LocalSoftwareKeyboardController` để tự động bật bàn phím ảo khi kích hoạt tìm kiếm.
- Sử dụng `BackHandler` để chặn phím Back vật lý: ưu tiên thu gọn thanh tìm kiếm thay vì thoát màn hình Chi tiết.

#### d) Tích hợp luồng Thêm Giỏ Hàng & Thông báo (Snackbar)
- Nhận `CartViewModel` từ MainScreen để đồng bộ dữ liệu giỏ hàng toàn cục.
- Khi nhấn "Thêm vào giỏ", chuẩn hóa giá tiền (`book.copy(price = book.displayPrice())`) trước khi lưu vào CartViewModel.
- Khởi tạo `rememberCoroutineScope()` để gọi `snackbarHostState.showSnackbar()` hiển thị thông báo "Đã thêm vào giỏ" không làm block UI thread.

---

### 3. Quá trình xây dựng luồng Tìm kiếm và Kết quả tìm kiếm

**Mục tiêu:** Triển khai tính năng tìm kiếm realtime, xử lý chặt chẽ các trạng thái UI phức tạp (Loading/Empty/Success) và tối ưu hóa lưới hiển thị sản phẩm.

#### a) Thiết lập luồng dữ liệu tìm kiếm (`SearchViewModel.kt`)
- Kế thừa `ViewModel`, sử dụng `@HiltViewModel` để tiêm `BookRepository`.
- Quản lý trạng thái `books` (kết quả trả về) và `isLoading` (cờ trạng thái tải) bằng `mutableStateOf`.
- Hàm `searchBooks(query)`: khởi chạy `viewModelScope.launch` để gọi API tìm kiếm, tự động cập nhật UI khi có data hoặc trả về `emptyList()` nếu có lỗi.

#### b) Xây dựng màn hình Kết quả tìm kiếm (`BookSearchResultsScreen.kt`)
- Sử dụng `LaunchedEffect(initialQuery)` để tự động gọi API `viewModel.searchBooks()` ngay khi màn hình khởi tạo với từ khóa truyền từ route.
- Cấu trúc giao diện bằng `Scaffold` chứa `SearchTopBar` và `FilterBar`.
- Xử lý luồng hiển thị (UI States):
  - `viewModel.isLoading` → hiện vòng xoay
  - `viewModel.books.isEmpty()` → gọi Component `EmptyResultView`
  - Có dữ liệu → truyền list sách xuống `SearchResultContentView`

#### c) Cấu trúc lưới kết quả
- Sử dụng `LazyVerticalGrid` với `GridCells.Fixed(2)` để tạo lưới 2 cột co giãn linh hoạt.
- Truyền sự kiện `onAddToCart` từ `BookCard` ngược lên `BookSearchResultsScreen` để gọi `CartViewModel` lưu vào giỏ hàng.

#### d) Kết quả đạt được
- Ứng dụng điều hướng linh hoạt, tham số `query` được truyền an toàn qua Navigation Compose.
- Giao diện tìm kiếm phản hồi nhanh, không bị giật lag khi cuộn lưới nhờ `LazyVerticalGrid` và Coil.
- Luồng dữ liệu (Data Flow) nhất quán: thêm sách từ trang Tìm kiếm vẫn hiển thị chính xác bên trang Giỏ hàng nhờ kiến trúc chia sẻ ViewModel.
- UX được tối ưu với các thông báo lỗi và Snackbar rõ ràng, thân thiện.

---
---

# PHẦN 2 — BÁO CÁO CÁ NHÂN: PHAN TRUNG NGHĨA (MSSV: 3121410345)

---

## I. Nhiệm vụ

- Đề xuất ý tưởng trọng tâm của dự án: xây dựng ứng dụng bán sách trực tuyến **BookVerse** trên nền tảng Android, sử dụng Kotlin và Jetpack Compose, tận dụng Google Books API làm nguồn dữ liệu sách chính, kết nối với backend Spring Boot (JWT, MySQL) để quản lý người dùng, đơn hàng và đánh giá.
- Thiết kế và triển khai giao diện Đăng nhập và Đăng ký (`LoginScreen`, `RegisterScreen`) cùng các thành phần liên quan (`AuthTextField`, `SocialLoginButton`), tích hợp xác thực với backend Spring Boot qua JWT.
- Xây dựng hệ thống điều hướng (Navigation) với **Nested Graphs** — cấu hình NavHost, BottomNavigation, xử lý ẩn/hiện thanh điều hướng dựa trên `currentRoute`, hỗ trợ truyền tham số động qua route.
- Thực hiện và hoàn thiện các chương kỹ thuật trọng tâm trong báo cáo:
  - **Chương 6:** Lập trình giao diện với Jetpack Compose (bao gồm Nested Navigation Graphs)
  - **Chương 9:** Mô tả và phân tích thiết kế đồ án (phần 1.1 Ý tưởng, 1.2 Mục tiêu, 2.1 Nhóm chức năng người dùng, 3. Công nghệ sử dụng, 4. Thiết kế kiến trúc hệ thống)
  - **Chương 10:** Triển khai và kết quả (cấu trúc thư mục dự án, hướng dẫn cài đặt, demo sản phẩm)
  - **Chương 11:** Đánh giá và tổng kết (kết quả đạt được, ưu/nhược điểm, khó khăn và giải pháp)
  - **Chương 12:** Hướng phát triển trong tương lai (đồ án và định hướng bản thân)
- Cài đặt và triển khai dự án, thiết kế UI, gộp code của các thành viên và sửa lỗi hệ thống, đẩy hệ thống lên GitHub.
- Hỗ trợ kiểm thử, chỉnh sửa định dạng báo cáo, và tổng hợp nội dung kỹ thuật với các thành viên khác.
- Tham gia hoàn thiện báo cáo nhóm, viết nhật ký làm việc và báo cáo cá nhân.

---

## II. Các công việc hằng tuần

### Tuần 1 (12/01 – 18/01)
- Tham gia cùng nhóm thảo luận chọn đề tài, liệt kê các công nghệ mới (Kotlin, Flutter, React Native).
- Tìm hiểu tổng quan về Kotlin, lịch sử hình thành và ưu điểm so với Java, khả năng tương thích với Android.

### Tuần 2 (19/01 – 25/01)
- Chốt đề tài nhóm: Tìm hiểu và ứng dụng Kotlin — Xây dựng ứng dụng bán sách BookVerse.
- Phân công nhiệm vụ: phụ trách tìm hiểu về Jetpack Compose, Navigation, và viết các chương kỹ thuật liên quan đến giao diện và kiến trúc.
- Bắt đầu tự học Kotlin nâng cao: Coroutines, Flow, Sealed Class, Extension Functions.

### Tuần 3 (26/01 – 01/02)
- Xây dựng base project Android với Jetpack Compose, cấu hình Hilt, Retrofit, Navigation.
- Thiết kế sơ bộ giao diện đăng nhập và đăng ký dựa trên mockup Figma.
- Viết nội dung lý thuyết cho Chương 6 (Jetpack Compose) trong báo cáo.

### Tuần 4 (02/02 – 08/03) *(do nghỉ Tết, có gián đoạn)*
- Hoàn thiện giao diện `LoginScreen` và `RegisterScreen` với các thành phần `AuthTextField`, `SocialLoginButton`.
- Tích hợp `AuthViewModel` để xử lý đăng nhập/đăng ký thông qua `ApiService`.
- Viết tiếp các mục trong Chương 6 (các thành phần UI, navigation, nested graphs).

### Tuần 5 (09/03 – 15/03)
- Kết nối backend Spring Boot (đã được thành viên khác xây dựng) để test luồng đăng nhập/đăng ký.
- Sửa lỗi xác thực JWT, cấu hình `TokenManager` lưu token vào DataStore.
- Bắt đầu viết Chương 9 (Mô tả và phân tích thiết kế đồ án): ý tưởng, mục tiêu.

### Tuần 6 (16/03 – 22/03)
- Hoàn thiện luồng đăng nhập: tự động chuyển hướng về màn hình trước đó (`returnRoute`), hiển thị thông báo lỗi.
- Xây dựng `AppBottomNavigation` và cấu hình NavHost với các tab chính.
- Viết Chương 9: các chức năng chính, công nghệ sử dụng, kiến trúc tổng thể.

### Tuần 7 (23/03 – 29/03)
- Tích hợp **Nested Navigation Graphs** để xử lý điều hướng lồng nhau (ví dụ từ tab Danh mục vào chi tiết danh mục, rồi vào chi tiết sách).
- Đảm bảo BottomNavigation ẩn/hiện đúng theo từng màn hình.
- Viết Chương 10: cấu trúc thư mục dự án, hướng dẫn cài đặt, demo sản phẩm (mô tả các màn hình đã hoàn thành).

### Tuần 8 (30/03 – 05/04)
- Hoàn thiện giao diện đăng nhập/đăng ký với validation, hiển thị lỗi, xử lý loading state.
- Hỗ trợ các thành viên khác tích hợp giỏ hàng và đặt hàng.
- Viết Chương 11: đánh giá ưu/nhược điểm của Kotlin, các khó khăn gặp phải và giải pháp.

### Tuần 9 (06/04 – 12/04)
- Rà soát toàn bộ code frontend, chuẩn hóa extension functions (`toVnd()`, `orDefault()`, `displayPrice()`).
- Viết Chương 12: hướng phát triển đồ án (thêm thanh toán thực tế, admin dashboard, KMM) và định hướng bản thân.

### Tuần 10 (13/04 – 19/04)
- Hoàn thiện báo cáo cá nhân, cập nhật nhật ký làm việc.
- Tổng hợp nội dung báo cáo nhóm, kiểm tra lỗi chính tả và định dạng.

---

## III. Đóng góp trong báo cáo

### 1. Vai trò và đóng góp trong dự án

Trong dự án BookVerse, giữ vai trò **phát triển giao diện người dùng (UI) và xử lý xác thực**, đồng thời chịu trách nhiệm viết các chương kỹ thuật quan trọng trong báo cáo.

#### a) Thiết kế và triển khai toàn bộ giao diện Đăng nhập / Đăng ký
- `LoginScreen.kt` và `RegisterScreen.kt` sử dụng Jetpack Compose, tuân thủ Material Design 3.
- Các thành phần tái sử dụng:
  - `AuthTextField`: hỗ trợ hiển thị lỗi, icon, toggle mật khẩu.
  - `SocialLoginButton`: nút đăng nhập bằng Facebook/Google.
- Xử lý validation: kiểm tra email, số điện thoại, độ dài mật khẩu, xác nhận mật khẩu, đồng ý điều khoản.
- Hiển thị thông báo lỗi qua Toast và cập nhật state `AuthState` (Idle, Loading, Success, LoginSuccess, Error).

#### b) Xây dựng hệ thống điều hướng (Navigation) với Nested Graphs
- Cấu hình NavHost trong `MainScreen.kt` với các route cho từng màn hình.
- Tích hợp `AppBottomNavigation` hiển thị có điều kiện dựa trên `currentRoute`.
- Hỗ trợ truyền tham số động qua route: `book_detail/{bookId}`, `category_detail/{index}`, `login/{returnRoute}`.

#### c) Thực hiện các chương kỹ thuật trong báo cáo

- **Chương 6 – Lập trình giao diện với Jetpack Compose:** Lý thuyết Compose, các khái niệm, layout, Material Components, đặc biệt là phần Nested Navigation Graphs với sơ đồ và code minh họa.

- **Chương 9 – Mô tả và phân tích thiết kế đồ án:** Ý tưởng, mục tiêu, chức năng, công nghệ sử dụng, kiến trúc tổng thể, luồng hoạt động.

- **Chương 10 – Triển khai và kết quả:** Cấu trúc thư mục dự án, hướng dẫn cài đặt, demo sản phẩm (các màn hình chính).

- **Chương 11 – Đánh giá và tổng kết:** Kết quả đạt được, ưu/nhược điểm của Kotlin, 5 khó khăn chính và giải pháp.

- **Chương 12 – Hướng phát triển trong tương lai:** Hướng phát triển đồ án (thanh toán, admin, KMM, …) và định hướng phát triển bản thân.

---

### 2. Quá trình thiết kế và tích hợp giao diện Đăng nhập / Đăng ký

**Mục tiêu:** Xây dựng màn hình đăng nhập và đăng ký thân thiện, an toàn, có validation đầy đủ, kết nối với backend Spring Boot qua JWT.

#### a) Thiết kế thành phần dùng chung (`AuthTextField.kt`)
- Sử dụng `OutlinedTextField` với các tùy chỉnh: màu sắc viền, icon leading, icon trailing (hiển thị/ẩn mật khẩu).
- Hỗ trợ hiển thị lỗi (`isError`) và thông báo lỗi bằng dấu `*` trên label.
- Nhận `keyboardType`, `visualTransformation` để xử lý trường mật khẩu.

#### b) Thiết kế nút đăng nhập mạng xã hội (`SocialLoginButton.kt`)
- Nhận tham số: `text`, `icon`, `backgroundColor`, `onClick`.
- Sử dụng `Button` với `Row` chứa icon dạng text (F, G) và text mô tả.

#### c) Xây dựng `LoginScreen.kt`
- `Scaffold` với `TopAppBar` có nút back.
- `AuthTextField` cho username (email) và password.
- Checkbox "Ghi nhớ mật khẩu" (chỉ UI).
- Nút "Đăng nhập" gọi `AuthViewModel.login()`.
- Lắng nghe `authState` qua `collectAsStateWithLifecycle()`:
  - Loading → hiển thị `CircularProgressIndicator`
  - LoginSuccess → lưu token, userId, username vào TokenManager, điều hướng về `returnRoute`
  - Error → hiển thị Toast với thông báo lỗi

#### d) Xây dựng `RegisterScreen.kt`
- Các `AuthTextField` cho: Họ tên, Tên đăng nhập (email), Email, Số điện thoại, Mật khẩu, Xác nhận mật khẩu.
- Checkbox đồng ý điều khoản với `ClickableText` tạo liên kết đến Terms và Privacy.
- Validation đầy đủ:
  - Không bỏ trống
  - Email đúng định dạng (`Patterns.EMAIL_ADDRESS.matcher().matches()`)
  - Số điện thoại có ít nhất 10 chữ số
  - Mật khẩu và xác nhận khớp
  - Đồng ý điều khoản
- Gọi `AuthViewModel.register(RegisterRequest)`.
- Xử lý thành công: hiển thị thông báo, chuyển về LoginScreen.
- Xử lý lỗi từ backend: parse JSON để lấy message, hiển thị Toast thân thiện (ví dụ: "Email đã tồn tại").

#### e) Tích hợp `AuthViewModel` và `TokenManager`
- `AuthViewModel` sử dụng `UserRepository` (gọi `ApiService`).
- Sau đăng nhập thành công, gọi `tokenManager.saveToken()`, `saveUserId()`, `saveUsername()`.
- `isLoggedIn` là `Flow<Boolean>` từ `tokenManager.token.map { it != null }`, dùng để bảo vệ các màn hình yêu cầu đăng nhập (giỏ hàng, tài khoản).

#### f) Kết quả đạt được
- Giao diện đăng nhập/đăng ký hoạt động ổn định, đồng bộ với backend.
- Validation chặt chẽ, thông báo lỗi rõ ràng.
- Token JWT được lưu an toàn trong DataStore, tự động gắn vào header các request sau.
- Người dùng có thể đăng ký tài khoản mới, đăng nhập và được chuyển hướng đúng màn hình.

---

### 3. Đóng góp cụ thể trong từng chương

- **Chương 6:** Viết toàn bộ lý thuyết Jetpack Compose, các thành phần UI, state, modifier. Bổ sung phần Nested Navigation Graphs với sơ đồ điều hướng của BookVerse, giải thích cấu hình NavHost, BottomNavigation và `popUpTo`. Ví dụ "Bộ đếm đơn giản" minh họa recomposition.

- **Chương 9:** Trình bày ý tưởng, mục tiêu tổng quát và cụ thể, liệt kê 15 chức năng người dùng và 5 chức năng nhân viên. Mô tả công nghệ sử dụng (frontend, backend, external). Thiết kế kiến trúc tổng thể (5 tầng) và luồng hoạt động điển hình (xem danh mục sách).

- **Chương 10:** Vẽ sơ đồ cấu trúc thư mục dự án (`data`, `di`, `ui`, `utils`, `viewmodel`, `BookstoreApplication`, `MainActivity`). Hướng dẫn cài đặt chi tiết. Demo sản phẩm mô tả các màn hình kèm luồng chính.

- **Chương 11:** Tóm tắt kết quả lý thuyết, kỹ thuật, thực hành. Đánh giá ưu điểm và nhược điểm của Kotlin. Liệt kê 5 khó khăn lớn nhất (Google Books API, JWT, state giỏ hàng, Hilt, lỗi mạng) và giải pháp tương ứng.

- **Chương 12:** Đề xuất hướng phát triển đồ án (thanh toán, admin dashboard, tối ưu, thông báo đẩy, KMM, triển khai cloud). Định hướng phát triển bản thân (học KMP, backend, tham gia cộng đồng, thực tập, lộ trình nghề nghiệp).

---
---

# PHẦN 3 — BÁO CÁO CÁ NHÂN: LÊ NGUYỄN NHẤT TÂM (MSSV: 3122410369)

---

## I. Nhiệm vụ

- Đề xuất ý tưởng trọng tâm của dự án: xây dựng ứng dụng bán sách trực tuyến **BookVerse** trên nền tảng Android, sử dụng Kotlin và Jetpack Compose, tận dụng Google Books API làm nguồn dữ liệu sách chính, kết nối với backend Spring Boot (JWT, MySQL) để quản lý người dùng, đơn hàng và đánh giá.
- Thiết kế và triển khai toàn bộ luồng mua hàng phía client:
  - **Giỏ hàng:** `CartViewModel` (quản lý state dùng chung), `CartScreen` (giao diện, mã giảm giá, tổng tiền).
  - **Thanh toán:** `CheckoutScreen` và `CheckoutViewModel` — form giao hàng giữ state qua `rememberSaveable`, tích hợp thanh toán **MoMo** qua deeplink, hỗ trợ COD.
  - **Lịch sử đơn hàng:** `OrderHistoryScreen` — 5 tab trạng thái, tự động reload khi quay lại từ app MoMo.
- Thiết kế và triển khai tính năng chỉnh sửa thông tin cá nhân người dùng (`ProfileScreen`, `AccountViewModel`).
- Thực hiện và hoàn thiện các chương kỹ thuật trong báo cáo:
  - **Chương 4:** Ngôn ngữ Kotlin cơ bản (Data Class, Collections API, `when` expression, hàm, kiểu dữ liệu).
  - **Chương 5:** Kotlin nâng cao (Null Safety, Sealed Class, Coroutines, Extension Functions).
  - **Chương 6:** Hỗ trợ viết phần điều hướng — bổ sung ví dụ lý thuyết cho mục điều hướng phẳng (Flat Navigation) và giải thích `saveState`/`restoreState`.
  - **Chương 10:** Phần 10.2 — Hướng dẫn cài đặt và khởi chạy dự án (Docker Desktop, Android Studio, IntelliJ); Phần 10.3 — Demo sản phẩm (luồng chính: đăng ký → đăng nhập → tìm sách → giỏ hàng → thanh toán → xem đơn hàng).
- Tham gia kiểm thử, sửa lỗi hệ thống, cấu hình network security cho phép HTTP nội bộ và tích hợp Google Books API key.
- Tham gia hoàn thiện báo cáo nhóm, viết nhật ký làm việc và báo cáo cá nhân.

---

## II. Các công việc hằng tuần

### Tuần 1 (12/01 – 18/01)
- Tham gia cùng nhóm thảo luận chọn đề tài, liệt kê các công nghệ mới (Kotlin, Flutter, React Native).
- Tìm hiểu tổng quan về Kotlin, lịch sử hình thành và ưu điểm so với Java.
- Đề xuất định hướng xây dựng ứng dụng thực tế để áp dụng Kotlin.

### Tuần 2 (19/01 – 25/01)
- Chốt đề tài nghiên cứu Kotlin cho nhóm: Ứng dụng bán sách **BookVerse**.
- Phân công nhiệm vụ: phụ trách luồng mua hàng (giỏ hàng, thanh toán) và các chương lý thuyết Kotlin (chương 4, 5).
- Bắt đầu tự học Kotlin cơ bản và nâng cao: Data Class, Extension Functions, Coroutines, Sealed Class.

### Tuần 3 (26/01 – 01/02)
- Tìm hiểu và thực hành Jetpack Compose cơ bản: `LazyColumn`, `Scaffold`, `Card`, `ViewModel`.
- Bắt đầu nghiên cứu tài liệu cho Chương 4 (Kotlin cơ bản): Data Class, Collections.
- Nghiên cứu tài liệu cho Chương 5 (Kotlin nâng cao): Null Safety, Extension Functions.

### Tuần 4 (02/03 – 08/03) *(do nghỉ Tết, có gián đoạn)*
- Phác thảo cấu trúc `CartViewModel` và `CartItem` data class (trên giấy/tài liệu, chưa code).
- Hoàn thiện lý thuyết cho Chương 4 trong báo cáo: Data Class, Collections API, `when` expression.

### Tuần 5 (09/03 – 15/03)
- Hỗ trợ nhóm cài đặt và kết nối backend.
- Tiếp tục nghiên cứu và hoàn thiện lý thuyết Chương 5: Sealed Class, Coroutines.

### Tuần 6 (16/03 – 22/03)
- Xây dựng `CartViewModel` với `mutableStateListOf<CartItem>()`, các hàm `addBook()`, `increaseQuantity()`, `decreaseQuantity()`, `removeItem()`, `clearCart()` và logic tính `subtotal`, `shippingFee`, `total` — toàn bộ là state cục bộ, chưa gọi API.
- Viết Chương 5 trong báo cáo: Null Safety và Extension Functions.

### Tuần 7 (23/03 – 29/03)
- Hoàn thiện `CartViewModel`: tích hợp logic mã giảm giá (`applyDiscount()`) với 3 mã SALE10, GIAM17, FREESHIP, xử lý `discountError`.
- Thiết kế sơ bộ giao diện `CartScreen` và luồng `CheckoutScreen`.
- Viết phần Sealed Class và Coroutines cho Chương 5 trong báo cáo.

### Tuần 8 (30/03 – 05/04)
- Xây dựng giao diện `CartScreen`: `LazyColumn` hiển thị `CartItemCard`, `OrderSummaryCard`, `CouponRow`, nút thanh toán. Tích hợp auth guard — tự động điều hướng về đăng nhập nếu chưa xác thực.
- Xây dựng `CheckoutScreen`: form nhập thông tin giao hàng dùng `rememberSaveable`, tự động pre-fill từ profile người dùng qua `LaunchedEffect`. Tích hợp phương thức thanh toán COD và MoMo (deeplink + fallback trình duyệt).
- Xây dựng `ProfileScreen`: cho phép người dùng chỉnh sửa họ tên, email, số điện thoại, địa chỉ và lưu lên backend qua `AccountViewModel`.
- Viết Chương 4 phần đồ án (4.3): áp dụng Data Class, Collections, `when` từ code thực tế của project.

### Tuần 9 (06/04 – 12/04)
- Xây dựng `OrderHistoryScreen`: `PrimaryScrollableTabRow` với 5 tab, `DisposableEffect` + `LifecycleEventObserver` tự động reload khi ON_RESUME, hàm `normalizeForTab()` và `getStatusInfo()`.
- Sửa lỗi CartViewModel không được chia sẻ đúng giữa các màn hình (đảm bảo `@HiltViewModel` singleton qua Hilt).
- Sửa lỗi navigation: `saveState`/`restoreState` cho BottomNavigation để duy trì back stack khi chuyển tab.
- Cấu hình `network_security_config.xml` cho phép cleartext HTTP đến địa chỉ nội bộ; tích hợp Google Books API key để khắc phục lỗi HTTP 429.
- Viết Chương 5 phần đồ án (5.3): áp dụng Null Safety, Sealed Class, Coroutines, Extension Functions từ code dự án.
- Viết phần hỗ trợ Chương 6 (điều hướng phẳng, `saveState`/`restoreState`).
- Viết Chương 10 — phần 10.2 (hướng dẫn cài đặt với Docker Desktop) và 10.3 (demo sản phẩm).

### Tuần 10 (13/04 – 19/04)
- Hoàn thiện báo cáo cá nhân, cập nhật nhật ký làm việc.
- Rà soát code, kiểm thử các luồng chính trên thiết bị thật.
- Tổng hợp nội dung báo cáo nhóm, kiểm tra lỗi chính tả và định dạng.

---

## III. Đóng góp trong báo cáo

### 1. Vai trò và đóng góp trong dự án

Trong dự án BookVerse, giữ vai trò **phát triển luồng mua hàng và quản lý trạng thái đơn hàng**, đồng thời chịu trách nhiệm viết các chương lý thuyết Kotlin (cơ bản và nâng cao) trong báo cáo.

#### a) Thiết kế và xây dựng hệ thống giỏ hàng (`CartViewModel`, `CartScreen`)
- `CartViewModel` được đánh dấu `@HiltViewModel` — Hilt tạo và quản lý vòng đời, đảm bảo **một instance duy nhất** được chia sẻ giữa tất cả các màn hình (HomeScreen, BookDetailScreen, CartScreen, CheckoutScreen).
- Sử dụng `mutableStateListOf<CartItem>()` — Compose quan sát trực tiếp thay đổi danh sách mà không cần `collectAsState()`, giúp UI tự động recompose khi thêm/xóa sách.
- Computed properties `subtotal`, `total` sử dụng Kotlin `get()`, luôn tính lại từ `cartItems` hiện tại — nhất quán dữ liệu tuyệt đối.
- Tích hợp hệ thống mã giảm giá: `applyDiscount()` xử lý 3 loại mã (phần trăm, cố định, miễn phí ship) với `discountError` phản hồi ngay lên UI.

#### b) Xây dựng luồng Thanh toán (`CheckoutScreen`, `CheckoutViewModel`)
- **Auth guard trong CartScreen:** `LaunchedEffect(isLoggedIn)` theo dõi `Flow<Boolean>` từ `TokenManager` — nếu chưa đăng nhập, tự động điều hướng `navigate("login/cart")` với `returnRoute` để quay lại sau khi đăng nhập.
- **`rememberSaveable` cho form giao hàng:** Toàn bộ 7 trường nhập liệu (tên, số điện thoại, email, tỉnh/thành, quận/huyện, địa chỉ, ghi chú) dùng `rememberSaveable` thay vì `remember` — dữ liệu không bị mất khi người dùng xoay màn hình (configuration change).
- **Pre-fill thông minh từ profile:** `LaunchedEffect(profile)` kết hợp cờ `isPrefilled` — tự động điền sẵn thông tin từ lần đặt hàng trước, chỉ fill đúng 1 lần khi màn hình khởi tạo.
- **Tích hợp MoMo:** Backend trả về `payUrl` (URL thanh toán) và `deeplink` (mở trực tiếp app MoMo). Frontend mở deeplink qua `Intent(ACTION_VIEW, Uri.parse(deeplink))` — nếu thiết bị không có app MoMo, fallback tự động mở `payUrl` trên trình duyệt.
- **Ghi ngược thông tin:** Sau khi đặt hàng thành công, `accountViewModel.applyShippingInfo()` lưu thông tin giao hàng vừa dùng về profile → lần sau pre-fill sẵn.

#### c) Xây dựng màn hình Lịch sử đơn hàng (`OrderHistoryScreen`)
- `PrimaryScrollableTabRow` với 5 tab: Tất cả / Chờ xác nhận / Đang xử lý / Đang giao / Đã hủy — thiết kế tương tự Shopee, hỗ trợ cuộn ngang khi tab dài.
- **`DisposableEffect` + `LifecycleEventObserver`:** Đăng ký observer theo dõi `Lifecycle.Event.ON_RESUME` — tự động gọi `viewModel.loadOrderHistory()` mỗi khi người dùng quay lại màn hình (ví dụ: sau khi hoàn tất thanh toán MoMo và bấm back về app).
- **`normalizeForTab()`:** Ánh xạ các trạng thái backend (`CONFIRMED` → `PROCESSING`, `SHIPPING`/`DELIVERED` → `SHIPPED`) về nhóm tab UI — tách biệt hoàn toàn logic backend và hiển thị frontend.
- **`getStatusInfo()`:** Trả về `StatusInfo(label, color, icon)` theo trạng thái — màu cam cho PENDING, xanh dương cho PROCESSING, tím cho SHIPPED, xanh lá cho DELIVERED, đỏ cho CANCELLED.
- **Auto-switch tab:** `LaunchedEffect(allOrders)` kiểm tra sau khi reload: nếu `initialTab == 1` (PENDING) mà không còn đơn PENDING nào → tự chuyển sang tab PROCESSING (index 2), giúp user thấy đơn hàng vừa thanh toán xong ngay lập tức.

#### d) Phát triển tính năng chỉnh sửa thông tin người dùng (`ProfileScreen`)
- Giao diện chỉnh sửa các trường: Họ tên, Email, Số điện thoại, Tỉnh/Thành, Quận/Huyện, Địa chỉ chi tiết.
- Gọi `AccountViewModel.updateProfile()` để lưu thay đổi lên backend — chỉ hiển thị dialog "Cập nhật thành công" khi người dùng chủ động bấm nút lưu, không hiện khi chỉ điều hướng đến màn hình.

#### e) Thực hiện các chương kỹ thuật trong báo cáo

- **Chương 4 – Ngôn ngữ Kotlin cơ bản:** Trình bày các đặc trưng cốt lõi của Kotlin: kiểu dữ liệu, hàm, Data Class, Collections API (`filter`, `map`, `groupBy`, `sumOf`), `when` expression. Phần 4.3 (Đồ án) minh họa bằng code thực tế của project: `CartItem` data class, `applyDiscount()` dùng `when`, `cartItems.sumOf { }` tính tổng tiền.

- **Chương 5 – Kotlin nâng cao:** Trình bày Null Safety (`?.`, `?:`, `!!`), Sealed Class (`AuthState`: Idle/Loading/Success/Error), Coroutines (`viewModelScope.launch`, `withContext(Dispatchers.IO)`), Extension Functions (`Double.toVnd()`, `String?.orDefault()`, `Book.displayPrice()`). Phần 5.3 (Đồ án) minh họa từ `OrderHistoryScreen`, `CartViewModel`, `CheckoutViewModel` của project.

- **Chương 6 – Hỗ trợ phần điều hướng:** Bổ sung ví dụ lý thuyết cho mục điều hướng phẳng (Flat Navigation) và giải thích `saveState`/`restoreState` trong `BottomNavigation` — kỹ thuật duy trì back stack của từng tab khi người dùng chuyển qua lại giữa các mục điều hướng chính.

- **Chương 10 – Hướng dẫn cài đặt và Demo:**
  - *Mục 10.2 – Hướng dẫn cài đặt:* Trình bày quy trình clone và khởi chạy dự án từ đầu: khởi động MySQL và MailHog qua Docker Desktop (`docker compose up -d`), mở backend bằng IntelliJ Community và chạy `BookstoreDbApplication`, mở frontend bằng Android Studio, cấu hình địa chỉ IP nội bộ, build và chạy app trên thiết bị/giả lập.
  - *Mục 10.3 – Demo sản phẩm:* Tường thuật luồng chính 7 bước: Đăng ký tài khoản → Đăng nhập → Khám phá trang chủ → Tìm kiếm và xem chi tiết sách → Thêm vào giỏ hàng → Thanh toán (COD hoặc MoMo) → Xem lịch sử đơn hàng.

---

### 2. Quá trình thiết kế và xây dựng hệ thống Giỏ hàng & Thanh toán

**Mục tiêu:** Xây dựng luồng mua hàng hoàn chỉnh, đảm bảo dữ liệu giỏ hàng nhất quán trên toàn ứng dụng, form thanh toán không mất dữ liệu khi xoay màn hình, và hỗ trợ nhiều phương thức thanh toán.

#### a) Thiết kế `CartViewModel` — State Management toàn cục
- Khai báo `@HiltViewModel` để Hilt quản lý instance: tất cả màn hình nhận cùng một ViewModel qua `hiltViewModel()`, tránh tình trạng "giỏ hàng A" và "giỏ hàng B" bất đồng bộ.
- `cartItems = mutableStateListOf<CartItem>()` — Compose theo dõi sự thay đổi từng phần tử trong list (không cần `toList()` hay emit); UI recompose đúng vùng thay đổi, tối ưu hiệu năng.
- Logic `addBook()`: kiểm tra `indexOfFirst { it.book.id == book.id }` — nếu sách đã có thì tăng số lượng, nếu chưa có thì thêm mới → tránh trùng lặp.
- `total` tự tính: `subtotal + shippingFee - discountAmount` với `get()` property — luôn phản ánh giá trị mới nhất mà không cần gọi thủ công.

#### b) Xây dựng `CartScreen` — Giao diện giỏ hàng
- **Auth guard:** `collectAsStateWithLifecycle(initialValue = null)` theo dõi `isLoggedIn` — giá trị `null` là "chưa xác định" (tránh flash về login khi app vừa khởi động), `false` mới điều hướng về login.
- **`LazyColumn` với `key`:** `items(cartItems, key = { it.book.id })` — Compose theo dõi đúng item theo ID, tránh recompose toàn bộ danh sách khi chỉ thay đổi số lượng một mục.
- **`CartItemCard`:** Dùng `AsyncImage` (Coil) tải ảnh bìa, `QuantityButton` tùy chỉnh hình tròn viền (thay vì `IconButton` mặc định) để đồng bộ với ngôn ngữ thiết kế của app.
- **`OrderSummaryCard`:** Hiển thị tạm tính, phí ship, giảm giá (ẩn nếu `discountAmount == 0`), và tổng cộng in đậm.
- **`CouponRow`:** `OutlinedTextField` + nút "Áp dụng" — hiển thị thông báo lỗi mã không hợp lệ ngay bên dưới input.

#### c) Xây dựng `CheckoutScreen` — `rememberSaveable` và Pre-fill
- Vấn đề: `remember {}` lưu state trong Composition nhưng mất khi configuration change (xoay màn hình). `rememberSaveable {}` serialize state vào `Bundle` của Android → state tồn tại qua cả configuration change và process death.
- Toàn bộ 7 trường form (tên nhận hàng, SĐT, email, tỉnh/thành, quận/huyện, địa chỉ, ghi chú) đều dùng `rememberSaveable`.
- Cờ `isPrefilled by rememberSaveable { mutableStateOf(false) }` đảm bảo chỉ pre-fill đúng một lần: khi profile load xong lần đầu (`LaunchedEffect(profile)`), nếu `!isPrefilled && profile != null` thì điền dữ liệu và set `isPrefilled = true` — người dùng chỉnh sửa sau đó sẽ không bị ghi đè.

#### d) Tích hợp thanh toán MoMo
- Backend tạo URL thanh toán MoMo và trả về `payUrl` + `deeplink` trong response.
- Frontend mở app MoMo qua deeplink; nếu thiết bị không cài MoMo, tự động fallback mở `payUrl` trên trình duyệt hệ thống.
- Sau khi người dùng thanh toán xong và quay lại app, `ON_RESUME` của `OrderHistoryScreen` kích hoạt `loadOrderHistory()` — đơn hàng tự cập nhật trạng thái từ PENDING lên PROCESSING.

#### e) Kết quả đạt được
- Giỏ hàng hoạt động nhất quán: thêm sách từ HomeScreen, BookDetailScreen hay SearchScreen đều phản ánh đúng trong CartScreen nhờ ViewModel singleton qua Hilt.
- Form thanh toán không mất dữ liệu khi xoay màn hình; tự động điền thông tin từ profile người dùng.
- Hỗ trợ 2 phương thức thanh toán: COD (tạo đơn ngay, nhận email xác nhận) và MoMo (deeplink → app/browser).
- Lịch sử đơn hàng tự động cập nhật và chuyển đúng tab sau khi thanh toán xong, không cần thao tác thủ công.

---

### 3. Đóng góp cụ thể trong từng chương

- **Chương 4 (Kotlin cơ bản):** Viết toàn bộ lý thuyết, ví dụ và phần đồ án (4.3) — bao gồm kiểu dữ liệu, hàm, Data Class, Collections API và `when` expression; minh họa bằng code thực tế của project như `CartItem` data class và `applyDiscount()`.

- **Chương 5 (Kotlin nâng cao):** Viết toàn bộ lý thuyết, ví dụ và phần đồ án (5.3) — bao gồm Null Safety, Sealed Class (`AuthState`), Coroutines (`viewModelScope`) và Extension Functions (`toVnd()`, `displayPrice()`); minh họa qua `CartViewModel`, `CheckoutViewModel` và `OrderHistoryScreen`.

- **Chương 6 (hỗ trợ phần điều hướng):** Bổ sung mục điều hướng phẳng (Flat Navigation) và giải thích `saveState`/`restoreState` trong `BottomNavigation` — xuất phát từ lỗi thực tế khi điều hướng giữa các tab không giữ lại back stack.

- **Chương 10 (Hướng dẫn cài đặt + Demo):** Viết mục 10.2 — hướng dẫn khởi chạy dự án với Docker Desktop (MySQL, MailHog), Android Studio và IntelliJ; và mục 10.3 — tường thuật luồng demo chính 7 bước từ đăng ký đến xem đơn hàng.

---
---

# PHỤ LỤC — NHẬT KÝ LÀM VIỆC NHÓM 35

**Tên đề tài:** Kotlin  
**Các thành viên:**
- Nguyễn Hào Phong — 3121560070
- Lê Nguyễn Nhất Tâm — 3122410369
- Phan Trung Nghĩa — 3121410345

---

## Tuần 1: 12/01 – 18/01

**Công việc đã thực hiện:**
- Tuyển thành viên nhóm.
- Liệt kê các đề tài mới mẻ và hiện đại.
- Thảo luận chọn đề tài.
- Tạo file word và chuẩn bị word theo cấu trúc đồ án tham khảo.

**Buổi họp nhóm 1:**
- Thời gian: 19:00, 18/01/2026
- Nội dung: thảo luận chọn đề tài cho nhóm

**Vướng mắc:**
- Chưa thống nhất được đề tài.
- Nhóm chưa đủ thành viên, cần tuyển thêm.

---

## Tuần 2: 19/01 – 25/01

**Công việc đã làm (tuần trước):**
- Liệt kê các đề tài mới mẻ và hiện đại.
- Thảo luận chọn đề tài.
- Tạo file word và chuẩn bị theo cấu trúc đồ án tham khảo.

**Buổi họp nhóm 1 (tuần trước):**
- Thời gian: 19:00, 24/01/2026
- Nội dung: thảo luận chọn đề tài

**Công việc sẽ làm:**
- Tuyển thành viên; chốt đề tài nhóm.
- Mỗi thành viên tự học framework.
- Phân công công việc cho các thành viên.

**Buổi họp nhóm 1:**
- Thời gian: 13:00, 25/01/2026
- Nội dung: Tìm thành viên; phân công công việc

**Vướng mắc:** Nhóm chưa đủ thành viên.

---

## Tuần 3: 26/01 – 01/02

**Công việc đã làm:**
- Chốt đề tài nhóm.
- Mỗi thành viên tự học framework.
- Hoàn thành Lời mở đầu, Phần 1 của word.
- Phân công công việc cho các thành viên.

**Công việc sẽ làm:**
- Hoàn thành chương 3, chương 4 của word.
- Chọn đề tài dự án áp dụng Kotlin.
- Xây dựng base cho dự án áp dụng Kotlin.
- Phân công công việc trong tuần.

**Buổi họp nhóm 1:**
- Thời gian: 13:00, 28/01/2026
- Nội dung: Tìm thành viên; phân công công việc

**Buổi họp nhóm 2:**
- Thời gian: 20:00, 01/02/2026
- Nội dung: Chốt đề tài dự án áp dụng Kotlin

**Vướng mắc:**
- Thiếu kiến thức về framework đã chọn.
- Chưa có ý tưởng về đề tài dự án áp dụng Kotlin.

---

## Tuần 4: 02/03 – 08/03

**Công việc đã làm:**
- Chọn đề tài dự án áp dụng Kotlin: Ứng dụng bán sách **BookVerse**.
- Phân công công việc cho các thành viên.

**Công việc sẽ làm:**
- Hoàn thành lý thuyết cho các chương thuộc phần 2 trong word.
- Xây dựng base cho dự án áp dụng Kotlin.
- Phân công công việc trong tuần.

**Buổi họp nhóm 1:**
- Thời gian: 13:00, 12/03/2026
- Nội dung: Phân công công việc

---

## Tuần 5: 09/03 – 15/03

**Công việc đã làm:**
- Hoàn thành lý thuyết cho các chương 5, 6 thuộc phần 2 trong word.
- Xây dựng base cho dự án áp dụng Kotlin.
- Phân công công việc cho các thành viên.

**Công việc sẽ làm:**
- Hoàn thiện hơn các chương thuộc phần 2 về mặt lý thuyết.
- Xây dựng các tính năng áp dụng vào dự án.

**Buổi họp nhóm 1:**
- Thời gian: 19:00, 12/03/2026 — kiểm tra tiến độ

**Buổi họp nhóm 2:**
- Thời gian: 19:00, 15/03/2026 — kiểm tra tiến độ

---

## Tuần 6: 16/03 – 22/03

**Công việc đã làm (tuần trước):**
- Hoàn thiện giao diện đăng nhập/đăng ký (LoginScreen, RegisterScreen) với validation và xử lý lỗi.
- Tích hợp AuthViewModel, gọi API đăng ký/đăng nhập từ backend Spring Boot.
- Lưu JWT token vào TokenManager (Preferences DataStore), tự động thêm token vào header các request sau.
- Xây dựng AppBottomNavigation và cấu hình NavHost cho 4 tab chính: Trang chủ, Danh mục, Giỏ hàng, Tài khoản.
- Viết nội dung chương 6 (Jetpack Compose) và chương 7 (MVVM & Retrofit) trong báo cáo.

**Công việc sẽ làm:**
- Xây dựng màn hình danh mục sách (CategoryScreen, CategoryDetailScreen).
- Tích hợp gọi Google Books API để lấy dữ liệu sách theo danh mục.
- Bắt đầu viết chương 9 (Mô tả và phân tích thiết kế đồ án).

**Buổi họp nhóm 1:**
- Thời gian: 20:00, 22/03/2026 — kiểm tra tiến độ

---

## Tuần 7: 23/03 – 29/03

**Công việc đã làm:**
- Hoàn thiện HomeScreen (hiển thị sách nổi bật, danh mục).
- Xây dựng CategoryScreen và CategoryDetailScreen: hiển thị sách theo danh mục, tích hợp lọc và sắp xếp cơ bản.
- Triển khai Nested Navigation Graphs: điều hướng lồng nhau giữa các tab và màn hình con.
- Cấu hình ẩn/hiện BottomNavigation dựa trên `currentRoute`.
- Viết nội dung chương 6: bổ sung phần Nested Navigation Graphs và ví dụ bộ đếm.

**Công việc sẽ làm:**
- Xây dựng màn hình chi tiết sách (BookDetailScreen).
- Xây dựng CartViewModel và màn hình giỏ hàng (CartScreen).
- Tiếp tục viết chương 9 (chức năng, công nghệ, kiến trúc).

---

## Tuần 8: 30/03 – 05/04

**Công việc đã làm:**
- Hoàn thiện BookDetailScreen: hiển thị ảnh bìa, thông tin sách, mô tả, thông số xuất bản.
- Xây dựng CartScreen: hiển thị danh sách sách trong giỏ, tăng/giảm số lượng, xóa, tính tổng tiền.
- Xây dựng CheckoutScreen: form nhập thông tin giao hàng (dùng `rememberSaveable` để giữ dữ liệu khi xoay màn hình), chọn phương thức thanh toán (COD, chuyển khoản, MoMo).
- Tích hợp mã giảm giá (SALE10, GIAM17, FREESHIP) trong CartViewModel.
- Viết nội dung chương 10 (Triển khai và kết quả): cấu trúc thư mục, hướng dẫn cài đặt.

**Công việc sẽ làm:**
- Xây dựng OrderHistoryScreen (lịch sử đơn hàng).
- Kết nối backend để tạo đơn hàng và gửi email xác nhận.
- Hoàn thiện chương 11 (Đánh giá và tổng kết).

**Buổi họp nhóm 1:**
- Thời gian: 19:45, 01/04/2026 — kiểm tra tiến độ

**Buổi họp nhóm 2:**
- Thời gian: 19:00, 05/04/2026 — kiểm tra tiến độ

---

## Tuần 9: 06/04 – 12/04

**Công việc đã làm:**
- Hoàn thiện OrderHistoryScreen: gọi API lấy danh sách đơn hàng, hiển thị theo trạng thái (chờ xác nhận, đang giao, hoàn tất).
- Tích hợp gửi email xác nhận đơn hàng bất đồng bộ qua MailHog (backend).
- Viết các extension functions: `Double.toVnd()`, `String?.orDefault()`, `Book.displayPrice()` (xử lý giá khi API không trả về).
- Hoàn thiện chương 9 (ý tưởng, mục tiêu, chức năng, công nghệ, kiến trúc) và chương 11 (đánh giá, khó khăn).
- Bắt đầu viết chương 12 (Hướng phát triển).

**Công việc sẽ làm:**
- Rà soát code, sửa lỗi giao diện trên nhiều thiết bị.
- Hoàn thiện báo cáo nhóm và báo cáo cá nhân.

---

## Tuần 10: 13/04 – 19/04

**Công việc đã làm:**
- Rà soát toàn bộ mã nguồn, sửa lỗi cuối cùng, tối ưu hiệu năng.
- Hoàn thiện báo cáo nhóm (các chương 6, 7, 8, 9, 10, 11, 12) và báo cáo cá nhân.
- Viết nhật ký làm việc tổng hợp.
- Quay video demo ứng dụng (các luồng chính: đăng ký, đăng nhập, tìm kiếm sách, thêm giỏ, đặt hàng, xem lịch sử).
- Chuẩn bị slide thuyết trình.

**Công việc sẽ làm:**
- Nộp báo cáo cuối cùng.
- Điền biên bản đánh giá đồ án cuối kì.

---

*Tài liệu tổng hợp từ báo cáo cá nhân của Nguyễn Hào Phong (3121560070), Phan Trung Nghĩa (3121410345) và Nhật ký làm việc Nhóm 35 — môn Các Công Nghệ Lập Trình Hiện Đại, Đại học Sài Gòn, năm học 2025–2026.*
