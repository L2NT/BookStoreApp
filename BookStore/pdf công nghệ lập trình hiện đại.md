Thành phố Hồ Chí Minh, tháng 4 năm 2026
TRƯỜNG ĐẠI HỌC SÀI GÒN
KHOA CÔNG NGHỆ THÔNG TIN
----------
BÁO CÁO HỌC PHẦN:
CÁC CÔNG NGHỆ LẬP TRÌNH HIỆN ĐẠI
TÌM HIỂU VỀ KOTLIN
Sinh Viên Thực Hiện Nhóm 35 GVHD: Phạm Thi Vương
1. Nguyễn Hào Phong - 3121560070
2. Phan Trung Nghĩa - 3121410035
3. Lê Nguyễn Nhất Tâm - 3122410369
   2
   BẢNG PHÂN CÔNG
   MSSV Họ và tên Công việc đảm nhận
   3121560070 Nguyễn Hào Phong
   Dựng khung đồ án, chuẩn bị api,
   chương 1,
   chương 2, chương 7, chương 8
   3122410369 Lê Nguyễn Nhất Tâm Chương 4, 5, 10
   3121410345 Phan Trung Nghĩa Chương 6, 9, 10,11, 12
   3
   LỜI CAM ĐOAN
   Trong quá trình làm bài, chúng em xin cam đoan bài báo cáo “Tìm hiểu về kotlin”
   này là công trình nghiên cứu của nhóm. Tất cả những thông tin trong bài báo cáo đều
   hoàn toàn trung thực, tuyệt đối không có sự sao chép, gian lận hay sử dụng kết quả của
   bất kì đề tài tương tự nào.
   Chúng em xin hoàn toàn chịu trách nhiệm về sự cam đoan này!
   4
   LỜI CẢM ƠN
   Đầu tiên, chúng em xin gửi lời cảm ơn chân thành đến Trường Đại học Sài Gòn
   đã đưa môn học Các công nghệ lập trình hiện đại vào chương trình giảng dạy. Đặc biệt,
   em xin gửi lời cảm ơn sâu sắc đến giảng viên bộ môn – Thầy Phạm Thi Vương đã dạy
   dỗ, truyền đạt những kiến thức quý báu cho chúng em trong thời gian học tập vừa qua.
   Do vốn kiến thức còn nhiều hạn chế và khả năng tiếp thu thực tế còn nhiều bỡ ngỡ, dù
   chúng em đã cố gắng hết sức nhưng chắc chắn bài báo cáo khó có thể tránh khỏi những
   thiếu sót, kính mong thầy xem xét và góp ý để bài báo cáo của chúng em được hoàn
   thiện hơn.
   Chúng em xin chân thành cảm ơn!
   5
   MỤC LỤC
   BẢNG PHÂN CÔNG......................................................................................................... 2
   LỜI CAM ĐOAN ............................................................................................................... 3
   LỜI CẢM ƠN ..................................................................................................................... 4
   MỤC LỤC .......................................................................................................................... 5
   DANH MỤC KÝ HIỆU VÀ VIẾT TẮT ........................................................................... 7
   DANH MỤC HÌNH ẢNH ................................................................................................ 10
   LỜI MỞ ĐẦU .................................................................................................................. 13
   PHẦN 1: TỔNG QUAN VỀ KOTLIN ........................................................................... 15
   CHƯƠNG 1: GIỚI THIỆU CHUNG ........................................................................... 15
   1.1. Lịch sử hình thành và phát triển ........................................................................ 15
   CHƯƠNG 2: CƠ HỘI NGHỀ NGHIỆP VÀ THỊ TRƯỜNG ...................................... 20
   2.1. Các vị trí công việc ............................................................................................ 20
   2.2. Nhu cầu tuyển dụng ........................................................................................... 22
   2.3. Mức lương tham khảo ....................................................................................... 24
   2.4. Các công ty/sản phẩm tiêu biểu đang sử dụng .................................................. 32
   PHẦN 2: NỘI DUNG CỐT LÕI VÀ THỰC HÀNH ...................................................... 34
   CHƯƠNG 3: CÀI ĐẶT MÔI TRƯỜNG VÀ “HELLO WORLD” ............................. 34
   3.1. Lý thuyết ............................................................................................................ 34
   3.2. Hướng dẫn và thực hành.................................................................................... 36
   CHƯƠNG 4: NGÔN NGỮ LẬP TRÌNH KOTLIN ..................................................... 42
   4.1. Lý thuyết ............................................................................................................ 42
   4.2. Ví dụ và giải thích ............................................................................................. 46
   4.3. Đồ án.................................................................................................................. 50
   CHƯƠNG 5: KOTLIN NÂNG CAO VÀ LẬP TRÌNH HÀM .................................... 61
   5.1. Lý thuyết ............................................................................................................ 61
   5.2. Ví dụ và giải thích ............................................................................................. 67
   5.3. Đồ án.................................................................................................................. 72
   CHƯƠNG 6: LẬP TRÌNH GIAO DIỆN VỚI JETPACK COMPOSE ....................... 91
   6.1. Lý thuyết về Jetpack Compose .......................................................................... 91
   6.2. Ví dụ và giải thích ............................................................................................. 98
   6
   6.3. Đồ án — Điều hướng với Jetpack Compose Navigation trong ứng dụng bán
   sách .................................................................................................................... 107
   CHƯƠNG 7: KIẾN TRÚC MVVM VÀ RETROFIT ............................................... 122
   7.1. Lý thuyết .......................................................................................................... 122
   7.2. Ví dụ và giải thích ........................................................................................... 139
   7.3. Đồ án................................................................................................................ 146
   CHƯƠNG 8: DEPENDENCY INJECTION VÀ HILT ............................................ 149
   8.1. Lý thuyết .......................................................................................................... 149
   8.2. Ví dụ và giải thích ........................................................................................... 166
   8.3. Đồ án................................................................................................................ 170
   PHẦN 3: XÂY DỰNG ĐỒ ÁN ỨNG DỤNG BÁN SÁCH ......................................... 176
   CHƯƠNG 9: MÔ TẢ VÀ PHÂN TÍCH THIẾT KẾ ĐỒ ÁN ................................... 176
   9.1. Ý tưởng và mục tiêu đồ án .............................................................................. 176
   9.2. Các chức năng chính........................................................................................ 182
   9.3. Công nghệ sử dụng .......................................................................................... 187
   9.4. Thiết kế kiến trúc hệ thống .............................................................................. 191
   CHƯƠNG 10: TRIỂN KHAI VÀ KẾT QUẢ............................................................ 204
   10.1. Cấu trúc thư mục dự án ................................................................................. 204
   10.2. Hướng dẫn cài đặt dự án ................................................................................ 208
   10.3. Demo sản phẩm ............................................................................................. 213
   PHẦN 4: TỔNG KẾT .................................................................................................... 235
   CHƯƠNG 11: ĐÁNH GIÁ VÀ TỔNG KẾT ............................................................ 235
   11.1. Tóm tắt kết quả đạt được ............................................................................... 235
   11.2. Đánh giá ưu và nhược điểm của công nghệ .................................................. 236
   11.3. Những khó khăn gặp phải và giải pháp ......................................................... 238
   CHƯƠNG 12: HƯỚNG PHÁT TRIỂN TRONG TƯƠNG LAI ............................... 240
   12.1. Hướng phát triển đồ án .................................................................................. 240
   12.2. Định hướng phát triển của bản thân .............................................................. 242
   TÀI LIỆU THAM KHẢO .............................................................................................. 243
   PHỤ LỤC ......................................................................................................................... 244
   7
   DANH MỤC KÝ HIỆU VÀ VIẾT TẮT
   STT Tên Viết Tắt Diễn Giải
```
1 ANR Application Not Responding (Ứng dụng khôngphản hồi)
```
```
2 API Application Programming Interface (Giao diện lậptrình ứng dụng)
```
3 APK Android Package Kit
```
4 CI/CD Continuous Integration / Continuous Deployment(Tích hợp liên tục / Triển khai liên tục)
```
```
5 COD Cash On Delivery (Thanh toán khi nhận hàng)
```
```
6 CPU Central Processing Unit (Bộ xử lý trung tâm)
```
```
7 DI Dependency Injection (Tiêm phụ thuộc)
```
```
8 DSL Domain Specific Language (Ngôn ngữ đặc thùmiền)
```
```
9 DTO Data Transfer Object (Đối tượng truyền dữ liệu)
```
```
10 HTTP Hypertext Transfer Protocol (Giao thức truyềnsiêu văn bản)
```
```
11 I/O Input / Output (Đầu vào / Đầu ra)
```
```
12 IDE Integrated Development Environment (Môitrường phát triển tích hợp)
```
```
13 IoC Inversion of Control (Đảo ngược quyền kiểmsoát)
```
8
```
14 JDK Java Development Kit (Bộ công cụ phát triểnJava)
```
```
15 JSON JavaScript Object Notation (Định dạng trao đổi dữliệu)
```
```
16 JWT JSON Web Token (Token xác thực dạng JSON)
```
```
17 JVM Java Virtual Machine (Máy ảo Java)
```
```
18 KAPT Kotlin Annotation Processing Tool (Công cụ xử lýannotation của Kotlin)
```
```
19 KMP Kotlin Multiplatform (Kotlin đa nền tảng)
```
```
20 KSP Kotlin Symbol Processing (Xử lý ký hiệu Kotlin)
```
```
21 LTS Long Term Support (Hỗ trợ dài hạn)
```
22 MVC Model – View – Controller
23 MVI Model – View – Intent
24 MVVM Model – View – ViewModel
```
25 NPE NullPointerException (Ngoại lệ trỏ tới null)
```
```
26 OOP Object-Oriented Programming (Lập trình hướngđối tượng)
```
```
27 ORM Object-Relational Mapping (Ánh xạ quan hệ đốitượng)
```
28 REST Representational State Transfer
```
29 SDK Software Development Kit (Bộ công cụ phát triểnphần mềm)
```
```
30 SLA Service Level Agreement (Thỏa thuận mức độdịch vụ)
```
9
```
31 SQL Structured Query Language (Ngôn ngữ truy vấncó cấu trúc)
```
```
32 UI User Interface (Giao diện người dùng)
```
```
33 URL Uniform Resource Locator (Định vị tài nguyênthống nhất)
```
34 WPF Windows Presentation Foundation
```
35 XML Extensible Markup Language (Ngôn ngữ đánhdấu mở rộng)
```
10
DANH MỤC HÌNH ẢNH
Hình 1.1: Logo công ty JetBrains ....................................................................... 15
Hình 2.1: ITviec hiện có hơn 20 việc làm liên quan đến Next.js được đăng
tuyển, trải dài từ vị trí intern đến Senior ................................................. 20
Hình 2.2: Trên LinkedIn Việt Nam, có hơn 2000 kết quả tuyển dụng liên quan
đến Kotlin. ............................................................................................... 23
Hình 2.3: Có hơn 300 công việc liên quan đến Next.js tại thị trường Singapore.
................................................................................................................. 24
Hình 2.4: Một số tin tuyển dụng vị trí Fresher trên TopCV. ............................. 26
Hình 2.5: Một số tin tuyển dụng vị trí Junior trên ITViec.................................. 27
Hình 2.6: Một số tin tuyển dụng vị trí Middle trên TopCV. ............................. 29
```
Hình 2.7: Một số tin tuyển dụng) yêu cầu từ 4–6 năm kinh nghiệm, được phân
```
loại ở cấp bậc Senior. .............................................................................. 30
Hình 2.8: Tin tuyển dụng vị trí Tech Lead trên thị trường Việt Nam. ............... 31
Hình 2.9: Tại Việt Nam, Kotlin thường được áp dụng trong thương mại điện tử,
fintech, SaaS và nền tảng tuyển dụng tảng tuyển dụng. ......................... 34
Hình 3.1: Trang web tải JDK LTS trên Apdotium.net ....................................... 37
HÌnh 3.2: Kết quả sau khi chạy câu lệnh java -verison ...................................... 37
Hình 3.3: Giao diện trang web tải IntelliJ IDEA của JetBrains ......................... 38
Hình 3.4: Giao diện màn hình Welcome của IntelliJ IDEA ............................... 38
Hình 3.5: Tạo dự án Kotlin mới.......................................................................... 39
Hình 3.6: Cấu hình dự án Kotlin mới ................................................................. 40
Hình 3.7: Hình ảnh giao diện sau khi tạo dự án Kotlin mới ............................... 41
Hình 3.8: Kết quả mã nguồn "Hello World" ........................................................ 2
Hình 4.1: Cấu trúc file ví dụ quản lý danh mục sách ........................................... 3
Hình 4.2: Kết quả chạy ví dụ quản lý danh mục sách .......................................... 4
Hình 4.3: Cấu trục thư mục data/model/ chứa các Data Class trong đồ án .......... 5
Hình 4.4: Màn hình giỏ hàng hiển thị subtotal và total được tính tự động từ
computed property] ................................................................................... 7
Hình 5.1: Cấu trục thư mục ví dụ tải dữ liệu bất đồng bộ 1 ............................... 10
Hình 5.2: Cấu trục thư mục ví dụ tải dữ liệu bất đồng bộ 2 ............................... 13
Hình 5.3: Trạng thái giao diện UiState.Loading, ............................................... 15
Hình 5.4: Trạng thái giao diện UiState.Success ................................................. 15
Hình 5.5: Trạng thái giao diện UiState.Error ..................................................... 15
11
Hình 5.5: Màn hình danh mục —trạng thái Loading ......................................... 20
Hình 5.6: Màn hình danh mục —trạng thái Success ......................................... 20
Hình 5.7: Màn hình danh mục —trạng thái Error .............................................. 22
Hình 5.8: Màn hình giỏ hàng — Tổng tiền tính bằng sumOf, xóa sản phẩm
bằng removeAll ....................................................................................... 24
Hình 6.1: Luồng điều hướng từ BookListScreen sang BookDetailScreen khi
bấm vào sách ........................................................................................... 32
Hình 6.2: Sơ đồ kiến trúc Nested Navigation Graphs trong đồ án ..................... 34
Hình 6.3: Bottom Navigation ẩn khi vào màn hình chi tiết sách........................ 34
Hình 6.4: Bottom Navigation hiện khi ở trang chủ ............................................ 34
```
Hình 6.5: Tab "Danh mục" vẫn sáng (highlighted) khi người dùng đang ở màn
```
hình CategoryDetail ................................................................................ 36
Hình 6.6: Luồng deep link từ MoMo trở về màn hình đơn hàng ....................... 42
Hình 7.1: Mô hình MVVM ................................................................................. 42
Hình 7.2: Cấu trúc thư mục mô hình MVVM .................................................... 46
Hình 7.3: Hình ảnh loading................................................................................. 50
Hình 7.4: Hình ảnh thành công ........................................................................... 61
Hình 7.5: Hình ảnh thư mục đồ án...................................................................... 61
Hình 7.6: Hình ảnh load dữ liệu ......................................................................... 67
Hình 7.7: Hình ảnh load ra kết quả ..................................................................... 72
Hình 8.1: Hilt Components ................................................................................. 91
Hình 8.2: Scoping .............................................................................................. 91
Hình 8.3: Ví dụ về Hilt ....................................................................................... 98
Hình 9.1: Sơ đồ cơ sở dữ liệu ........................................................................... 107
HÌnh 10.1: Cấu trúc thư mục dự án .................................................................. 122
HÌnh 10.2: Thư mục data/ ................................................................................. 122
HÌnh 10.3: Thư mục di/ .................................................................................... 139
HÌnh 10.4: Thư mục ui/ .................................................................................... 146
HÌnh 10.5: Thư mục viewmode/ ....................................................................... 149
HÌnh 10.6: Thư mục utils/ ................................................................................. 149
Hình 10.7: Các têp tin gốc trong thư mục dự án............................................... 166
Hình 10.8: Cấu trúc thư mục sau khi clone cả 2 repo....................................... 170
Hình 10.9: 2 container đang ở trạng thái Up .................................................... 176
Hình 10.10: Phần kết nối docker trong file application.properties .................. 176
Hình 10.11: Log backend khởi động thành công tại cổng 8081 ................ 176
12
Hình 10.12: Cấu hình RetrofitClient.kt — đổi IP theo mạng WiFi hiện tại..... 182
Hình 10.13: Thêm IP vào network_security_config.xml ................................. 187
Hình 10.14: Chọn thiết bị trong dropdown Device Manager của Android Studio
............................................................................................................... 191
Hình 10.16: Giao diện màn hình Đăng ký ........................................................ 204
Hình 10.17: Thông báo lỗi validation ............................................................... 204
Hình 10.18: Giao diện màn hình Đăng nhập .................................................... 208
Hình 10.19: Giao diện trang chủ — danh mục và banner ................................ 213
Hình 10.20: Giao diện trang chủ — danh sách sách nổi bật ............................ 235
Hình 10.21: Giao diện màn hình Tìm kiếm ...................................................... 235
Hình 10.22: Kết quả tìm kiếm — lưới 2 cột ..................................................... 235
Hình 10.23: Giao diện Chi tiết sách 1 ............................................................... 236
Hình 10.24: Giao diện Chi tiết sách 2 ............................................................... 238
Hình 10.25: Giao diện Giỏ hàng ....................................................................... 240
Hình 10.26: Giao diện Thanh toán — form giao hàng ..................................... 240
Hình 10.27: Chọn phương thức thanh toán ...................................................... 242
```
Hình 10.28: Giao diện thanh toán MoMo (sandbox) ........................................ 243
```
Hình 10.29: Tab Chờ xác nhận với đơn có thể bấm ......................................... 244
Hình 10.30: Dialog tùy chọn — Hủy đơn / Thanh toán MoMo ....................... 234
13
LỜI MỞ ĐẦU
Trong bối cảnh công nghệ thông tin phát triển kthông ngừng, các ứng dụng di
động ngày nay không chỉ đòi hỏi tính năng đa dạng mà còn yêu cầu sự ổn định cao,
tốc độ xử lý tối ưu và giao diện người dùng hiện đại. Java, dù là một ngôn ngữ lâu
đời và mạnh mẽ, vẫn bộc lộ những hạn chế về sự rườm rà trong cú pháp và những rủi
```
ro liên quan đến lỗi tham chiếu null (Null Pointer Exception). Chính vì vậy, sự ra đời
```
của Kotlin đã đánh dấu một bước tiến quan trọng, mang đến một ngôn ngữ lập trình
hiện đại, an toàn và ngắn gọn hơn. Với việc được Google công bố là ngôn ngữ ưu
```
tiên hàng đầu (Kotlin-first) cho phát triển Android, Kotlin đã nhanh chóng khẳng
```
định vị thế và trở thành một giải pháp toàn diện cho việc xây dựng các hệ thống phần
mềm từ di động đến backend. Việc lựa chọn nghiên cứu và ứng dụng Kotlin trở thành
một hướng đi chiến lược, giúp người học tiếp cận với tư duy lập trình mới, nâng cao
hiệu suất làm việc và chuẩn bị nền tảng vững chắc cho con đường nghề nghiệp trong
tương lai.
Mục tiêu của báo cáo này là nghiên cứu một cách hệ thống về Kotlin, từ lịch
sử hình thành, quá trình phát triển cho đến những đặc điểm cú pháp nổi bật và các
tính năng an toàn vượt trội. Bên cạnh việc tìm hiểu lý thuyết, báo cáo còn hướng
tới việc áp dụng kiến thức đã học để xây dựng một ứng dụng thực tế – "Ứng dụng
bán sách". Qua đồ án này, nhóm không chỉ củng cố kỹ năng lập trình cốt lõi mà
còn hình thành tư duy thiết kế giao diện khai báo với Jetpack Compose và quản lý
phụ thuộc khoa học với thư viện Hilt theo chuẩn mực phát triển hiện đại.
Phạm vi của báo cáo tập trung chủ yếu vào việc trình bày các kiến thức nền
tảng của ngôn ngữ Kotlin và các bước thực hành liên quan đến bộ công cụ Jetpack
```
Compose. Những công nghệ hỗ trợ như Hilt (Dependency Injection) hay Android
```
Studio sẽ được đề cập trong phạm vi hỗ trợ nhằm làm rõ quy trình triển khai ứng
dụng, nhưng không đi quá sâu vào các chi tiết kỹ thuật nằm ngoài phạm vi cốt lõi
của ngôn ngữ.
14
Toàn bộ báo cáo được triển khai theo một cấu trúc logic và mạch lạc. Phần
đầu tiên sẽ giới thiệu tổng quan về Kotlin, từ bối cảnh ra đời cho đến vị thế hiện
tại trên thị trường công nghệ. Phần tiếp theo đi sâu vào các kiến thức cốt lõi như
Null Safety, Data Class, kết hợp với thực hành xây dựng giao diện bằng Jetpack
Compose và quản lý đối tượng bằng Hilt, giúp người đọc nắm vững lý thuyết
thông qua các ví dụ minh họa trực quan. Phần ba tập trung mô tả quá trình xây
dựng đồ án ứng dụng bán sách, nơi các thành phần kiến thức được kết nối để tạo
thành một sản phẩm hoàn chỉnh. Cuối cùng, báo cáo khép lại bằng phần tổng kết,
đánh giá những kết quả đạt được, nêu bật các ưu điểm, hạn chế và định hướng
phát triển mở rộng cho ứng dụng trong tương lai.
15
PHẦN 1: TỔNG QUAN VỀ KOTLIN
CHƯƠNG 1: GIỚI THIỆU CHUNG
1.1. Lịch sử hình thành và phát triển
1.1.1. Ai/Tổ chức nào đã tạo ra?
Ngôn ngữ lập trình Kotlin được nghiên cứu và phát triển bởi JetBrains –
```
một công ty công nghệ nổi tiếng có trụ sở chính tại Cộng hòa Séc (đây cũng là
```
đơn vị tạo ra những công cụ lập trình phổ biến như IntelliJ IDEA, WebStorm,
```
PyCharm).
```
Hình 1.1: Logo công ty JetBrains
1.2. Thời điểm ra đời
Tháng 7 năm 2011: JetBrains lần đầu tiên công bố dự án Kotlin sau một
thời gian dài nghiên cứu và phát triển nội bộ.
Tháng 2 năm 2012: JetBrains chính thức mở mã nguồn dự án Kotlin
theo giấy phép Apache 2.
Ngày 15 tháng 2 năm 2016: Phiên bản Kotlin 1.0 chính thức được phát
hành. Đây là cột mốc quan trọng đánh dấu sự ổn định đầu tiên của ngôn ngữ
này, cam kết khả năng tương thích ngược lâu dài.
Tháng 5 năm 2017: Tại sự kiện Google I/O, Google chính thức công bố
Kotlin là ngôn ngữ được hỗ trợ ưu tiên để phát triển ứng dụng Android, tạo nên
sự bùng nổ về mức độ phổ biến của ngôn ngữ này trên toàn cầu.
16
1.1.3. Bối cảnh và lý do ra đời
Sự hạn chế của ngôn ngữ Java : Vào thời điểm Kotlin bắt đầu được
```
nghiên cứu (khoảng năm 2010-2011), Java là ngôn ngữ thống trị trên nền tảng
```
JVM và Android. Tuy nhiên, Java tồn tại nhiều vấn đề gây khó khăn cho lập
trình viên. Lập trình viên phải viết quá nhiều mã nguồn lặp đi lặp lại chỉ để
```
thực hiện những tác vụ đơn giản (như tạo Getter, Setter, Constructors). Java
```
không có cơ chế quản lý các giá trị null một cách chặt chẽ ở mức biên dịch,
```
dẫn đến việc ứng dụng thường xuyên bị lỗi (crash) khi thực thi nếu lập trình
```
viên quên kiểm tra null.
Nhu cầu thực tế của JetBrains: Là một công ty chuyên sản xuất các công
```
cụ lập trình (IDE), JetBrains sở hữu hàng triệu dòng code bằng Java. Họ nhận
```
thấy rằng việc sử dụng Java làm giảm năng suất làm việc của đội ngũ kỹ sư.
Họ cần một ngôn ngữ mới có khả năng:
17
```
Tương thích hoàn toàn với Java (Interoperability): Có thể chạy chung
```
với mã Java cũ trong cùng một dự án mà không cần viết lại toàn bộ.
Nhu cầu thực tế của JetBrains: Là một công ty chuyên sản xuất các công
```
cụ lập trình (IDE), JetBrains sở hữu hàng triệu dòng code bằng Java. Họ nhận
```
thấy rằng việc sử dụng Java làm giảm năng suất làm việc của đội ngũ kỹ sư.
Họ cần một ngôn ngữ mới có khả năng:Tương thích hoàn toàn với Java
```
(Interoperability): Có thể chạy chung với mã Java cũ trong cùng một dự án mà
```
không cần viết lại toàn bộ.Tối ưu hóa công cụ: Ngôn ngữ phải được thiết kế để
```
các IDE có thể phân tích và hỗ trợ lập trình viên tốt nhất (như tự động gợi ý
```
```
code, phát hiện lỗi sớm).
```
Sự bùng nổ của phát triển ứng dụng di động: Khi Android trở thành hệ
điều hành di động phổ biến nhất, các nhà phát triển đòi hỏi một ngôn ngữ giúp
họ viết mã nhanh hơn, an toàn hơn để cạnh tranh với sự hiện đại của ngôn ngữ
Swift trên nền tảng iOS.
1.1.4. Sự thay đổi qua các phiên bản
```
• Giai đoạn hình thành và ổn định (Phiên bản 1.0 - 1.2)
```
```
Kotlin 1.0 (2016): Là phiên bản ổn định đầu tiên, đánh dấu việc Kotlin
```
sẵn sàng cho các dự án thực tế với cam kết tương thích ngược lâu dài.
```
Kotlin 1.1 (2017): Giới thiệu tính năng Coroutines (dưới dạng thử
```
```
nghiệm) – một bước ngoặt trong việc xử lý các tác vụ bất đồng bộ, giúp mã
```
nguồn tránh được tình trạng "callback hell".
```
• Giai đoạn bùng nổ và hiện đại hóa (Phiên bản 1.3 - 1.5)
```
```
Kotlin 1.3 (2018): Coroutines chính thức trở nên ổn định. Phiên bản này
```
cũng giới thiệu Kotlin/Native, cho phép biên dịch mã nguồn trực tiếp thành mã
máy mà không cần máy ảo JVM.
18
```
Kotlin 1.4 (2020): Tập trung mạnh vào hiệu suất của bộ soạn thảo và cải
```
```
thiện hệ sinh thái đa nền tảng (Kotlin Multiplatform). Giới thiệu giao diện lập
```
trình mới cho các thư viện tiêu chuẩn.
```
Kotlin 1.5 (2021): Giới thiệu JVM Records, Sealed Interfaces và Inline
```
Classes, giúp việc định nghĩa cấu trúc dữ liệu trở nên chặt chẽ và tối ưu bộ nhớ
hơn.
```
• Giai đoạn tối ưu hóa và Jetpack Compose (Phiên bản 1.6 - 1.9)
```
Kotlin 1.7 - 1.9: Đây là giai đoạn tối ưu hóa cực kỳ quan trọng cho các
thư viện hiện đại như Jetpack Compose và Hilt. Ra mắt trình quản lý bộ nhớ
mới cho Kotlin/Native.
```
Giới thiệu Kotlin Symbol Processing (KSP): Công cụ giúp các thư viện
```
như Hilt và Room xử lý mã nguồn nhanh hơn gấp nhiều lần so với công nghệ
KAPT cũ.
Bắt đầu thử nghiệm trình biên dịch K2 – hứa hẹn tốc độ biên dịch nhanh
gấp đôi.
```
• Kỷ nguyên mới (Phiên bản 2.0+)
```
```
Kotlin 2.0 (Ra mắt năm 2024): Đây là cột mốc lớn nhất sau phiên bản
```
1.0.
K2 Compiler chính thức trở nên ổn định: Trình biên dịch mới này không
chỉ giúp tăng tốc độ build dự án mà còn giúp các công cụ phân tích mã nguồn
hiểu code sâu sắc hơn.
Hỗ trợ tối đa cho việc phát triển giao diện bằng Jetpack Compose, giúp
quá trình render và cập nhật UI mượt mà hơn đáng kể.
```
1.1.5. Hệ sinh thái (Ecosystem)
```
• Thư viện
19
Retrofit / Ktor Client: Thư viện tiêu chuẩn để gọi dữ liệu từ API và xử lý
phản hồi từ server.
```
Coil: Thư viện tải và cache hình ảnh hiện đại, được tối ưu hóa riêng cho
```
Jetpack Compose.
Room Persistence: Thư viện ORM giúp làm việc với cơ sở dữ liệu
```
SQLite cục bộ (dùng để lưu danh sách sách yêu thích hoặc giỏ hàng).
```
Kotlin Serialization: Thư viện giúp chuyển đổi dữ liệu JSON từ API
```
thành các đối tượng Kotlin (Data Class) một cách an toàn.
```
• Framework
Jetpack Compose: Framework hiện đại để xây dựng giao diện người
```
dùng (UI) theo phong cách khai báo (Declarative).
```
```
Hilt: Framework quản lý phụ thuộc (Dependency Injection) chuẩn của
```
Google, giúp mã nguồn sạch sẽ và dễ kiểm thử.
Spring Boot / Ktor: Các framework mạnh mẽ phía Backend, thường
được kết hợp để xây dựng hệ thống Fullstack hoàn toàn bằng ngôn ngữ Kotlin.
• Công cụ hỗ trợ
```
Kotlin Multiplatform (KMP): Framework cho phép chia sẻ mã nguồn
```
```
logic giữa Android, iOS và Web.Công cụ hỗ trợMaterial Design 3 (M3): Bộ
```
thư viện component UI chuẩn từ Google, cung cấp các thành phần giao diện
hiện đại sẵn có cho Compose.
Android Studio: IDE chính thống tích hợp sẵn các công cụ như Layout
Inspector và Compose Preview để phát triển ứng dụng di động.
```
Gradle (Kotlin DSL): Công cụ quản lý mã nguồn, thư viện và quy trình
```
```
đóng gói ứng dụng (Build tool).
```
ktlint / Detekt: Công cụ kiểm tra lỗi cú pháp và định dạng mã nguồn,
giúp duy trì chất lượng code tương tự như ESLint/Prettier.
20
• Cộng đồng phát triển
```
Github: hàng nghìn contributor, dự án được cập nhật thường xuyên.
```
StackOverflow, Reddit, Discord: cộng đồng thảo luận, chia sẻ kinh
nghiệm, giải pháp.
Công ty lớn áp dụng: Google, Netflix, Pinterest, Uber, Trello … góp
phần khẳng định vị thế của Kotlin.
CHƯƠNG 2: CƠ HỘI NGHỀ NGHIỆP VÀ THỊ TRƯỜNG
2.1. Các vị trí công việc
Các vị trí công việc liên quan đến kotlin hiện nay thường tập trung chủ yếu vào
lĩnh vực phát triển ứng dụng di động, do kotlin được sử dụng để xây dựng các ứng
dụng di động hiệu suất cao.
Hình 2.1: ITviec hiện có hơn 20 việc làm liên quan đến Next.js được đăng
tuyển, trải dài từ vị trí intern đến Senior
2.1.1. Android Developer
• Đây là vị trí phổ biến và có nhu cầu tuyển dụng cao nhất. Kể từ
khi Google ưu tiên Kotlin, hầu hết các dự án Android mới đều
yêu cầu kỹ năng này.
21
• Công việc chính: Xây dựng giao diện người dùng bằng Jetpack
Compose, quản lý luồng dữ liệu, tích hợp các thư viện như Hilt
để quản lý mã nguồn và xử lý các tác vụ bất đồng bộ với
Coroutines.
• Yêu cầu: Hiểu biết sâu về vòng đời ứng dụng Android, kiến trúc
MVVM/MVI và các bộ công cụ Jetpack.
2.1.2. Backend Developer
```
• Nhờ khả năng chạy trên máy ảo Java (JVM) và tương thích hoàn
```
toàn với các thư viện Java, Kotlin đang dần thay thế Java trong
phát triển phía máy chủ.
• Công việc chính: Xây dựng các API, hệ thống Microservices và
quản lý cơ sở dữ liệu bằng các framework mạnh mẽ như Spring
Boot hoặc Ktor.
```
• Yêu cầu: Kiến thức về cơ sở dữ liệu (SQL/NoSQL), kiến trúc hệ
```
```
thống và bảo mật (như Keycloak hoặc OAuth2).
```
2.1.3. Kotlin Multiplatform Developer
• Đây là vị trí đang trở thành xu hướng mới, cho phép viết mã
nguồn một lần và chạy trên cả Android, iOS, Desktop và Web.
• Công việc chính: Phát triển các thư viện logic dùng chung
```
(Business Logic) và phối hợp với các nhóm nền tảng khác để tối
```
ưu hóa hiệu năng ứng dụng trên từng thiết bị.
• Yêu cầu: Kỹ năng tổ chức mã nguồn tốt và kinh nghiệm làm việc
```
với Kotlin Multiplatform (KMP).
```
2.1.4. Kotlin Fullstack Developer
• Với sự hỗ trợ của Kotlin/JS và các framework backend, một lập
trình viên có thể sử dụng duy nhất ngôn ngữ Kotlin để xây dựng
toàn bộ một hệ thống phần mềm.
22
```
• Công việc chính: Đảm nhiệm cả việc xây dựng giao diện web (Sử
```
```
dụng Kotlin/JS hoặc Compose for Web) và hệ thống xử lý dữ liệu
```
```
phía sau (Backend).
```
2.2. Nhu cầu tuyển dụng
Sự chuyển dịch mạnh mẽ từ Java sang Kotlin, đặc biệt là sau tuyên bố "Kotlin-
first" của Google, đã tạo ra một làn sóng nhu cầu nhân lực rất lớn trên phạm vi toàn
cầu nói chung và Việt Nam nói riêng.
2.2.1. Thị trường Việt Nam
Tại Việt Nam, thị trường tuyển dụng Kotlin đang trải qua giai đoạn chuyển đổi
```
số mạnh mẽ từ các dự án kế thừa (Legacy) sang các kiến trúc hiện đại.
```
• Xu hướng tại các công ty Outsourcing: Các tập đoàn lớn như FPT Software,
NashTech hay KMS Solutions liên tục tuyển dụng lập trình viên Kotlin để phục
vụ các dự án từ đối tác nước ngoài. Yêu cầu hiện nay không chỉ dừng lại ở ngôn
ngữ mà còn đi kèm với các công nghệ như Jetpack Compose và Hilt.
```
• Sự bùng nổ của các "Super App" nội địa: Các công ty sản phẩm (Product) hàng
```
đầu tại Việt Nam như MoMo, ZaloPay, Shopee, Tiki hay các hệ thống ngân hàng
```
số (Techcombank, VPBank) đều đã chuyển dịch sang Kotlin để xây dựng các
```
tính năng phức tạp, yêu cầu độ ổn định và bảo mật cao.
Phân khúc lập trình viên:
• Intern/Fresher: Nhu cầu thực tập sinh rất lớn tại các Lab công nghệ, mức
lương khởi điểm dao động từ 8.000.000 – 12.000.000 VNĐ.
• Junior/Middle: Đây là phân khúc có nhu cầu tuyển dụng cao nhất, yêu cầu
ứng viên thành thạo Coroutines và kiến trúc MVVM, mức lương từ
18.000.000 – 35.000.000 VNĐ.
• Senior/Architect: Các vị trí đòi hỏi khả năng tối ưu hóa hệ thống và triển khai
Clean Architecture, mức lương có thể vượt mốc 50.000.000 VNĐ hoặc nhận
lương theo USD.
23
Hình 2.2: Trên LinkedIn Việt Nam, có hơn 2000 kết quả tuyển dụng liên
quan đến Kotlin.
2.2.2. Thị trường thế giới
Trên bình diện quốc tế, Kotlin không còn là một ngôn ngữ "mới nổi" mà đã trở
thành tiêu chuẩn bắt buộc trong phát triển ứng dụng di động hiện đại.
• Sự thống trị trong mảng Android: Theo thống kê từ Google, hơn 95% trong
số 1.000 ứng dụng hàng đầu trên Play Store hiện được viết bằng Kotlin. Điều
này khiến nhu cầu tuyển dụng lập trình viên Kotlin luôn ở mức cao và ổn
định.
• Mở rộng sang hệ sinh thái đa nền tảng: Sự ra đời của Kotlin Multiplatform
```
(KMP) đã khiến các công ty công nghệ lớn (như Netflix, McDonald's,
```
```
VMware) săn đón các kỹ sư Kotlin để tối ưu hóa quy trình phát triển ứng
```
dụng trên cả iOS và Android với một bộ mã nguồn duy nhất.
• Mức lương hấp dẫn: Theo báo cáo của Stack Overflow, Kotlin thường xuyên
nằm trong nhóm các ngôn ngữ lập trình có mức lương cao nhất. Tại các thị
trường như Mỹ hoặc Châu Âu, mức lương cho một kỹ sư Kotlin kinh nghiệm
thường dao động từ $100.000 đến $160.000/năm.
24
Hình 2.3: Có hơn 300 công việc liên quan đến Next.js tại thị trường
Singapore.
2.3. Mức lương tham khảo
```
2.3.1. Intern (0 - Dưới 6 tháng)
```
Mức lương: 3.000.000 – 6.000.000 VNĐ/tháng
Kinh nghiệm: 0 - Dưới 6 tháng
```
Kỹ năng cứng (Hard Skills):
```
```
• Biết cú pháp Kotlin cơ bản (val/var, null safety).
```
• Biết sử dụng cơ bản Jetpack Compose để vẽ UI.
• Hiểu khái niệm cơ bản về Hilt/DI.
• Biết sử dụng Git cơ bản.
```
Kỹ năng mềm (Soft Skills):
```
• Tinh thần học hỏi: Chủ động hỏi, ghi chép và tự tổng hợp kiến thức.
• Tuân thủ: Chấp nhận và làm theo hướng dẫn chi tiết, chính xác.
• Ngoại ngữ: Đủ để đọc hiểu tài liệu kỹ thuật cơ bản.
Thực tế cho thấy, số lượng công việc dành cho ứng viên chưa có nhiều kinh
nghiệm hiện còn khá hạn chế, mức lương khởi điểm dao động khoảng 3 – 6 triệu
VNĐ/tháng tùy công ty và yêu cầu công việc.
```
2.3.2. Fresher (Dưới 1 năm)
```
Mức lương: 6.000.000 – 12.000.000 VNĐ/tháng
25
```
Kinh nghiệm: Dưới 1 năm (sau giai đoạn Intern)
```
```
Kỹ năng cứng (Hard Skills):
```
• Kotlin & xử lý bất đồng bộ:
o Thành thạo Kotlin cơ bản: data class, sealed class, extension function.
```
o Có kinh nghiệm sử dụng Coroutine (launch, async, suspend).
```
o Hiểu Flow cơ bản là lợi thế.
o Hiểu các scope như viewModelScope, lifecycleScope.
• Kiến trúc & Clean Code:
o Có kinh nghiệm làm việc với MVVM hoặc MVC.
o Biết tách layer: UI – ViewModel – Repository – Data Source.
```
o Biết xử lý UI State (Loading / Success / Error).
```
o Code rõ ràng, dễ maintain và có khả năng refactor.
• Networking & Data:
o Sử dụng Retrofit / OkHttp để gọi API.
o Hiểu RESTful API.
o Biết xử lý timeout, error và parsing JSON.
o Có kinh nghiệm với Room hoặc SQLite là lợi thế.
```
Kỹ năng mềm (Soft Skills):
```
o Chịu trách nhiệm: Hoàn thành các task nhỏ được giao và đảm
bảo code chạy.
o Tìm kiếm/Debug: Tự debug các lỗi phổ biến trước khi nhờ hỗ trợ.
o Tư duy code sạch: Bắt đầu có ý thức về việc viết code dễ đọc.
26
Hình 2.4: Một số tin tuyển dụng vị trí Fresher trên TopCV.
```
2.3.3. Junior Developer (1 - 2 năm)
```
Mức lương: 15.000.000 – 25.000.000 VNĐ/tháng
Kinh nghiệm: 1 - 2 năm
```
Kỹ năng cứng (Hard Skills):
```
• Hiểu biết về các nguyên tắc cơ bản của Java/Kotlin, Android
Studio và Android SDK.
• Làm quen với các nguyên tắc SOLID, OOP, cấu trúc dữ liệu và
```
kiến trúc sạch (MVVM).
```
• Kinh nghiệm làm việc với cơ sở dữ liệu như SQLite, Room và
Realm.
• Hiểu biết về tích hợp API RESTful và xử lý dữ liệu JSON.
• Hiểu biết thành thạo về các công cụ kiểm soát phiên bản mã,
chẳng hạn như Git.
27
• Chú ý đến chi tiết và có tư duy phân tích giải quyết vấn đề.
• Tiếp xúc với Jetpack Compose, Retrofit2 / OkHttp3, RxJava hoặc
Google Maps SDK.
• Hiểu biết cơ bản về Nhắn tin Firebase, Crashlytics hoặc Cấu hình
từ xa.
• Làm quen với thiết kế Material 3, Coroutines Flow hoặc thử
nghiệm JUnit/Espresso.
```
Kỹ năng mềm (Soft Skills):
```
• Độc lập và chủ động: Tự giải quyết hầu hết các vấn đề ở mức trung bình
và cần ít sự giám sát từ Senior.
```
• Ước tính: Có khả năng ước tính thời gian làm task (effort estimation)
```
hợp lý.
```
• Ngoại ngữ: Đọc hiểu tài liệu chuyên sâu (ví dụ: RFC, tài liệu kỹ thuật
```
```
nâng cao).
```
Hình 2.5: Một số tin tuyển dụng vị trí Junior trên ITViec.
```
2.3.4. Mid-Level Developer (2 - 4 năm)
```
28
Mức lương: 24.000.000 – 40.000.000 VNĐ/tháng
Kinh nghiệm: 2 – 4 năm
```
Kỹ năng cứng (Hard Skills):
```
```
• Thành thạo Kotlin (Java là một lợi thế).
```
```
• Kinh nghiệm với Jetpack components (LiveData, ViewModel,
```
```
Navigation, Room, DataStore, v.v.).
```
• Hiểu biết vững chắc về các mẫu kiến trúc như MVVM, MVI hoặc
Clean Architecture.
```
• Thành thạo với dependency injection (ví dụ: Hilt, Dagger),
```
```
networking (Retrofit/OkHttp) và reactive programming (ví dụ:
```
```
Coroutines, Flow, RxJava).
```
• Có kinh nghiệm làm việc với quy trình Git, CI/CD và các công
cụ DevOps hiện đại.
• Hiểu biết về các biện pháp bảo mật di động, đặc biệt có liên quan
```
trong các ứng dụng ngân hàng (ví dụ: mã hóa dữ liệu, lưu trữ an
```
```
toàn, xác thực sinh trắc học).
```
```
Kỹ năng mềm (Soft Skills):
```
• Phân tích & giải pháp: Phân tích được nguyên nhân gốc rễ
```
(Root Cause) của vấn đề và đề xuất giải pháp bền vững cho hệ
```
thống.
• Mentoring: Hướng dẫn và hỗ trợ các Junior trong team về kỹ
thuật và quy trình.
```
• Ngoại ngữ: Tiếng Anh giao tiếp cơ bản (Tham gia họp, thảo
```
```
luận task, phản hồi code review qua văn bản) là lợi thế lớn để đạt
```
mức lương cao hơn 30M.
29
Hình 2.6: Một số tin tuyển dụng vị trí Middle trên TopCV.
```
2.3.5. Senior Developer (4 - 6 năm)
```
Mức lương: 40.000.000 – 65.000.000+ VNĐ/tháng
Kinh nghiệm: 4 - 6 năm
```
Kỹ năng cứng (Hard Skills):
```
• Chuyên gia kiến trúc: Thiết kế kiến trúc cho các ứng dụng quy mô lớn.
• Bảo mật & Scale: Chuyên gia tối ưu hóa hiệu năng chuyên sâu và có kinh
nghiệm xử lý các vấn đề bảo mật trong môi trường Production.
```
• Full-stack/System: Thành thạo một Backend Stack (Kotlin/java,spring…)
```
```
và có khả năng thiết kế Database Schema (SQL/NoSQL).
```
• DevOps: Thiết lập và duy trì quy trình CI/CD, Monitoring, Logging .
```
Kỹ năng mềm (Soft Skills):
```
• Lãnh đạo kỹ thuật: Dẫn dắt Code Review, đưa ra các tiêu chuẩn kỹ thuật
cho toàn team.
30
• Tư duy chiến lược: Hiểu rõ mục tiêu kinh doanh và đề xuất giải pháp kỹ
thuật tối ưu chi phí và thời gian.
```
• Ngoại ngữ (Yếu tố quyết định): Tiếng Anh lưu loát (thảo luận kỹ thuật sâu,
```
bảo vệ quan điểm kiến trúc, làm việc trực tiếp với khách hàng/đối tác nước
```
ngoài).
```
```
Hình 2.7: Một số tin tuyển dụng) yêu cầu từ 4–6 năm kinh nghiệm, được
```
phân loại ở cấp bậc Senior.
So với Middle, Senior không chỉ đảm nhận phần việc độc lập mà còn có trách
nhiệm dẫn dắt đội nhóm nhỏ, review code và đưa ra giải pháp kỹ thuật cho dự án.
Trên thị trường Việt Nam, JD Senior xuất hiện phổ biến hơn Middle vì nhiều doanh
nghiệp trực tiếp tuyển ứng viên đã có kinh nghiệm cao để giảm chi phí đào tạo.
```
2.3.6. Tech Lead/Architect (6+ năm)
```
Mức lương: 65.000.000 – 100.000.000+ VNĐ/tháng
Kinh nghiệm: 6 năm trở lên
```
Kỹ năng cứng (Hard Skills):
```
31
• Định hướng công nghệ: Lựa chọn Stack công nghệ tổng thể, chịu trách nhiệm
về Roadmap kỹ thuật của sản phẩm.
```
• Quản lý vận hành: Chịu trách nhiệm về SLAs (Service Level Agreements),
```
đảm bảo hệ thống hoạt động ổn định và có khả năng phục hồi sau thảm họa
```
(Disaster Recovery).
```
• Tích hợp đa hệ thống: Thiết kế các giải pháp tích hợp với các hệ
thống Legacy/Microservices phức tạp.
```
Kỹ năng mềm (Soft Skills):
```
```
• Quản lý đội ngũ: Quản lý tiến độ dự án (Scrum/Agile), phân công task, đánh
```
giá hiệu suất của lập trình viên.
• Giao tiếp chiến lược: Thương lượng và trình bày giải pháp kỹ thuật cho quản
lý cấp cao hoặc ban lãnh đạo.
```
• Ngoại ngữ: Sử dụng thành thạo trong mọi tình huống công việc (phỏng vấn,
```
```
đào tạo, viết proposal).
```
Hình 2.8: Tin tuyển dụng vị trí Tech Lead trên thị trường Việt Nam.
32
Ở cấp độ này, JD thường được mô tả cụ thể và rõ ràng, nhấn mạnh cả năng lực
```
kỹ thuật (thiết kế kiến trúc, tối ưu hiệu năng, bảo đảm chất lượng sản phẩm) và kỹ
```
năng quản lý đội nhóm. Doanh nghiệp biết chính xác điều họ cần, đồng thời tin tưởng
rằng ứng viên ở cấp này sẽ hiểu ngay yêu cầu công việc. Theo quan sát, số lượng tin
tuyển Tech Lead có phần nhiều hơn so với Middle, phản ánh nhu cầu cao về nhân sự
chủ chốt giúp định hướng dự án.
2.4. Các công ty/sản phẩm tiêu biểu đang sử dụng
Kotlin không chỉ là một ngôn ngữ lập trình được ưa chuộng trong cộng đồng
phát triển di động, mà còn đã chứng minh tính ứng dụng thực tiễn thông qua việc
được nhiều doanh nghiệp công nghệ hàng đầu thế giới và trong nước áp dụng vào các
sản phẩm then chốt. Điều này khẳng định vị thế của Kotlin trong việc tối ưu hóa hiệu
suất phát triển, tăng tính an toàn cho mã nguồn và mang lại trải nghiệm ứng dụng
mượt mà, ổn định.
2.4.1. Quốc tế
```
• Google (Android & YouTube): Là đơn vị thúc đẩy mạnh mẽ nhất, Google đã
```
```
chuyển dịch toàn bộ hệ sinh thái Android sang ưu tiên Kotlin (Kotlin-first).
```
Các ứng dụng như YouTube, Google Drive và bản thân hệ điều hành Android
sử dụng Kotlin để giảm thiểu 33% lỗi crash hệ thống nhờ tính năng an toàn với
```
giá trị null (Null Safety).
```
• Netflix: Ứng dụng xem phim trực tuyến hàng đầu thế giới sử dụng Kotlin cho
```
ứng dụng Android của mình để tối ưu hóa việc truyền tải dữ liệu (streaming)
```
và xây dựng các dịch vụ phía Backend, giúp hệ thống chịu tải lớn nhưng vẫn
duy trì được sự ổn định tuyệt đối.
• Uber: Với mạng lưới người dùng và tài xế khổng lồ, Uber ứng dụng Kotlin để
xây dựng các ứng dụng di động có quy mô lớn. Việc sử dụng Kotlin giúp đội
33
ngũ kỹ sư của Uber viết mã nhanh hơn, dễ bảo trì và đảm bảo tính an toàn cao
cho các giao dịch và định vị thời gian thực.
• Pinterest: Là một trong những doanh nghiệp lớn đầu tiên chuyển đổi từ Java
sang Kotlin. Pinterest sử dụng ngôn ngữ này để cải thiện hiệu suất ứng dụng và
```
giảm đáng kể lượng mã nguồn thừa (boilerplate code), giúp quy trình cập nhật
```
tính năng mới trở nên linh hoạt hơn.
2.4.2. Việt Nam
• MoMo: Siêu ứng dụng thanh toán hàng đầu Việt Nam sử dụng Kotlin để phát
triển hệ thống Android, giúp đảm bảo tính bảo mật cực cao cho các giao dịch
tài chính và mang lại giao diện mượt mà cho hàng triệu người dùng hàng ngày.
• Zalo: Ứng dụng nhắn tin phổ biến nhất Việt Nam đã ứng dụng Kotlin để tối ưu
hóa tốc độ gửi nhận tin nhắn và xử lý các tác vụ bất đồng bộ phức tạp, giúp
ứng dụng hoạt động ổn định trên nhiều dòng thiết bị khác nhau.
• Tiki/Shopee: Các sàn thương mại điện tử lớn tại Việt Nam áp dụng Kotlin kết
hợp với các bộ thư viện hiện đại để xây dựng ứng dụng mua sắm, giúp tối ưu
tốc độ tải hình ảnh sản phẩm và cải thiện tỷ lệ chuyển đổi thông qua trải
nghiệm người dùng mượt mà.
34
Hình 2.9: Tại Việt Nam, Kotlin thường được áp dụng trong thương mại
điện tử, fintech, SaaS và nền tảng tuyển dụng tảng tuyển dụng.
PHẦN 2: NỘI DUNG CỐT LÕI VÀ THỰC HÀNH
CHƯƠNG 3: CÀI ĐẶT MÔI TRƯỜNG VÀ “HELLO WORLD”
3.1. Lý thuyết
3.1.1. Môi trường phát triển
Để bắt đầu với Kotlin, trước hết cần chuẩn bị môi trường phát triền phù hợp,
```
Kotlin là ngôn ngữ chạy trên máy ảo Java (JVM), do đó yêu cầu bắt buộc là phải cài
```
```
đặt Java Development Kit (JDK). Ngoài ra, chúng ta cần một công cụ quản lý thư
```
```
viện và tự động hoá build như Gradle hoặc Maven; trong đó, Gradle với Kotlin DSL
```
```
(Domain Specific Language) là lựa chọn phổ biến khi làm việc với Kotlin.
```
```
Java Development Kit (JDK)
```
```
JDK cung cấp môi trường chạy (JRE) và các công cụ phát triển (trình biên dịch
```
```
java, javac, ...) cần thiết để biên dịch và chạy các chương trình trên JVM.
```
35
Chức năng chính: Biên dịch mã nguồn Kotlin thành bytecode Java thực thi trên
JVM.
```
Phiên bản khuyến khích: nên sử dụng các phiên bản JDK LTS (Long Term
```
```
Support) như JDK 11, JDK 17 hoặc JDK 21 để đảm bảo tính ổn định và hiệu quả.
```
Kiểm tra cài đặt: sau khi cài đặt, mở terminal và gõ java –version và javac –
version để xác nhận.
Gradle
Gradle là một công cụ tự động hoá build, được sử dụng rộng rãi trong hệ
```
sinh thái Kotlin. Nó giúp quản lý thư viện (dependencies), biên dịch, chạy
```
kiểm thử và đóng gói ứng dụng.
```
Có thể cài đặt riêng hoặc thông qua sử dụng Wrapper (gradlew) đi kèm
```
dự án, giúp đồng bộ phiên bản giữa các máy.
Kotlin LTS cho phép viết các tệp cấu hình build bằng Kotlin thay vì
```
Groovy, tận dụng được các tính năng của ngôn ngữ (type-safety, code
```
```
completion).
```
Hệ điều hành
Kotlin hỗ trợ đa nền tảng, bao gồm Windows, macOS và Linux. Tuỳ theo hệ
điều hành, cách cài đặt JDK có thể khác nhau:
```
• Trên Windows, tải toàn bộ từ trang chủ của nhà cung cấp (Oracle,
```
```
Adoptium, ...).
```
• Trên macOs/Linux, có thể sử dụng trình quản lý gói như
```
Homebrew (macOS), SDKMAN (Linux/macOS) để dễ dàng cài
```
đặt và chuyển đổi giữa các phiên bản SDK.
3.1.2. Công cụ soạn thảo
IntelliJ IDEA
36
```
IntelliJ IDEA, phát triển bởi JetBrains (cũng là cha đẻ của Kotlin), là môi
```
```
trường phát triển tích hợp (IDE) mạnh mẽ nhất dành cho Kotlin. Phiên bản
```
Community Edition hoàn toàn miễn phí và cung cấp đầy đủ tính năng cần thiết.
Ưu điểm nỗi bật:
• Hỗ trợ Kotlin nguyên bản: code completion, gợi ý kiểu dữ liệu,
refactoring thông minh.
• Tích hợp build tool: nhập trực tiếp dự án Gradle hoặc Maven, tự
động tải dependencies.
• Debugger mạnh mẽ: cho phép đặt breakpoint, theo dõi giá trị
biến, thực thi từng dòng.
• Giao diện thân thiện: dễ dàng tạo mới project Kotlin với nhiều
```
mẫu có sẵn (console, web, ...).
```
Ngoài IntelliJ IDEA, một số IDE khác như Visual Studio Code hoặc Android
Studio cũng có thể sử dụng, tuy nhiên đôi khi chúng không hổ trợ cộng đồng mạnh
mẽ như IntelliJ IDEA.
3.2. Hướng dẫn và thực hành
Để bắt đầu với Kotlin, cần tiến hành một số bước cài đặt cơ bản nhằm thiết lập
môi trường làm việc và khổi tạo dự án đầu tiên. Toàn bộ quy trình có thể thực hiện
trực tiếp trên máy tính cá nhân, không yêu cầu cấu hình phức tạp.
Bước 1: cài đặt JDK
```
Truy cập vào trang Apdotium.net (hoặc trang chủ Oracle) vào tải xuống phiên
```
```
bản JDK LTS mới nhất (ví dụ JDK 17). Chạy tệp và làm theo hướng dẫn. Sau khi
```
chạy xong, mở terminal và kiểm tra phiên bản bằng lệnh:
37
Hình 3.1: Trang web tải JDK LTS trên Apdotium.net
HÌnh 3.2: Kết quả sau khi chạy câu lệnh java -verison
Bước 2: Cài đặt IntelliJ IDEA
Truy cập trang web jetbrains.com/idea/download và tải xuống phiên bản
Community Edition phù hợp với hệ điều hành. Chạy tệp cài đặt, chọn các tuỳ chọn
```
mặc định )có thể liên kết đến menu Start/Desktop). Sau khi cài đặt, khởi động IntelliJ
```
IDEA.
java -version
javac -version
38
Hình 3.3: Giao diện trang web tải IntelliJ IDEA của JetBrains
Hình 3.4: Giao diện màn hình Welcome của IntelliJ IDEA
Bước 3: Tạo dự án Kotlin mới
39
Sau khi đã cài đặt xong IntelliJ IDEA mà mở ứng dụng lần đầu, ta sẽ xuất hiện
ở màn hình chào mừng. Trên màn hình chào mừng của IntelliJ IDEA, chọn nút New
Project.
Hình 3.5: Tạo dự án Kotlin mới
Trong cửa sổ hiện ra, chọn Kotlin ở cột bên trái, sau đó chọn Build System.
```
Đặt tên dự án (Ví dụ trong hình: HelloKotlin). Trong mục Project SDK, chọn JDK đã
```
```
cài (Nếu chưa thấy, nhấn Add JDK và dẫn đến thư mục cài đặt). Nhấn Create, IntelliJ
```
IDEA sẽ tạo cấu trúc dự án với một tệp Main.kt mặc định trong thư mục
src/main/kotlin.
40
Hình 3.6: Cấu hình dự án Kotlin mới
41
Hình 3.7: Hình ảnh giao diện sau khi tạo dự án Kotlin mới
Bước 4: Viết mã nguồn “Hello, Wold!” và chạy ứng dụng
```
Mở tệp Main.kt (hoặc tệp .kt vừa được tạo). Xoá nội dung cũ nếu có và viết
```
đoạn mã sau:
```
Nhấp chuột phải vào bất kì đâu trong tệp Main.kt, chọn Run ‘MainKt’ (Hoặc
```
```
nhấn tổ hợp phím Ctrl + Shift + F10 trên Windows/Linux, ^ + Shift + R trên macOS).
```
Quan sát cửa sổ run ở cuối màn hình. Kết quả hiển thị sẽ là:
```
fun main(){
```
```
println(""Hello, World!")
```
```
}
```
42
Hình 3.8: Kết quả mã nguồn "Hello World"
CHƯƠNG 4: NGÔN NGỮ LẬP TRÌNH KOTLIN
4.1. Lý thuyết
4.1.1. Biến và Kiểu dữ liệu
Trong Kotlin, biến được khai báo theo hai cách dứt khoát thông qua từ khóa
val và var, phản ánh tư tưởng thiết kế hướng đến sự an toàn và rõ ràng trong mã
nguồn.
Khai báo biến
```
• val (value – giá trị): Khai báo hằng số bất biến (immutable). Sau
```
khi khởi tạo, giá trị không thể thay đổi. Tương đương với final
trong Java.
```
• var (variable – biến): Khai báo biến có thể thay đổi giá trị
```
```
(mutable) trong suốt vòng đời của nó
```
Ví dụ khai báo biến
Val bookTitle: String = “Kotlin Programming” // Không thể gán lại
Var bookPricee: Double = 150.000 // Có thể thay đổi
```
bookPrice = 120.000 // Hợp lệ
```
43
```
Lưu ý: Kotlin có khả năng suy luận kiểu (Type Inference). Lập trình viên
```
không cần khai báo tường minh kiểu dữ liệu nếu giá trị đã đủ rõ ràng. Ví dụ:
val name = "Kotlin" – trình biên dịch tự suy ra kiểu String.
Các kiểu dữ liệu nguyên thủy trong Kotlin
```
Không giống Java, Kotlin không phân biệt kiểu nguyên thủy (primitive)
```
```
và kiểu đối tượng (object) ở cấp ngôn ngữ. Toàn bộ đều là đối tượng nhưng
```
được trình biên dịch tối ưu hóa thành kiểu nguyên thủy của JVM ở cấp
bytecode.
• Số nguyên: Byte, Short, Int, Long
• Số thực: Float, Double
• Ký tự: Char
```
• Logic: Boolean (true / false)
```
```
• Chuỗi ký tự: String – hỗ trợ String Templates với cú pháp ${…}
```
Ví dụ minh họa String Templates:
val bookName = "Lập trình Kotlin"
val price = 200.000
```
println("Sách: $bookName – Giá: ${price}đ")
```
// Kết quả: Sách: Lập trình Kotlin – Giá: 200000.0đ
```
4.1.2. Hàm (Functions)
```
Hàm trong Kotlin được khai báo bằng từ khóa fun. Kotlin hỗ trợ nhiều dạng
hàm linh hoạt, từ hàm thông thường đến hàm biểu thức đơn dòng, giúp rút ngắn và
tăng tính biểu đạt của mã nguồn.
Cú pháp cơ bản
```
fun tên_hàm(tham_số: KiểuDữLiệu): KiểuTrảVề {
```
// Thân hàm
return giá_trị
```
}
```
Ví dụ hàm tính giá sau giảm:
44
```
fun tinhGiaSauGiam(gia: Double, phanTramGiam: Int): Double {
```
```
return gia * (1 - phanTramGiam / 100.0)
```
```
}
```
```
Hàm biểu thức đơn (Single-expression Function)
```
Khi than hàm chỉ gồm một biểu thức, có thể viết gọn bằng toán tử gán
```
(=):
```
```
fun tinhGiaSauGiam(gia: Double, phanTramGiam: Int): Double =
```
```
gia * (1 - phanTramGiam / 100.0)
```
```
Tham số mặc định và tham số có tên (Default & Named Parameters)
```
Kotlin cho phép đặt giá trị mặc định cho tham số, giúp loại bỏ việc overload
hàm không cần thiết như trong Java:
```
fun taoLoi(thongBao: String, maLoi: Int = 400): String {
```
return "[Lỗi $maLoi] $thongBao"
```
}
```
// Gọi hàm không cần truyền maLoi
```
println(taoLoi("Không tìm thấy sách")) // [Lỗi 400] Không tìm thấy sách
```
```
4.1.3. Lớp và Đối tượng (Classes & Objects)
```
Kotlin là ngôn ngữ lập trình hướng đối tượng hoàn toàn. Cú pháp khai báo lớp
ngắn gọn và mạnh mẽ hơn Java đáng kể.
Khai báo lớp cơ bản
```
Constructor chính (Primary Constructor) được đặt ngay sau tên lớp, giúp loại
```
bỏ hoàn toàn các phương thức Getter và Setter rườm rà của Java:
```
class Book(val title: String, val author: String, var price: Double) {
```
```
fun displayInfo(): String {
```
```
return "$title - $author (${price}đ)"
```
```
}
```
```
}
```
45
```
val book = Book("Kotlin Coroutines", "Roman Elizarov", 350000.0)
```
```
println(book.displayInfo())
```
```
Kế thừa (Inheritance)
```
```
Trong Kotlin, mọi lớp đều mặc định là final (không thể kế thừa). Để cho phép
```
kế thừa, phải đánh dấu lớp bằng từ khóa open:
```
open class Vehicle(val brand: String, val speed: Int)
```
```
class ElectricVehicle(brand: String, speed: Int, val batteryCapacity: Int)
```
```
: Vehicle(brand, speed)
```
Data Class
Data Class là một loại lớp đặc biệt trong Kotlin, được thiết kế chuyên dụng để
lưu trữ dữ liệu. Khi khai báo với từ khóa data class, trình biên dịch tự động sinh ra
```
các phương thức: equals(), hashCode(), toString(), copy().
```
```
data class Book(val id: Int, val title: String, val price: Double)
```
```
val book1 = Book(1, "Kotlin in Action", 299000.0)
```
```
val book2 = book1.copy(price = 250000.0) // Tạo bản sao với giá khác
```
```
println(book1) // Book(id=1, title=Kotlin in Action, price=299000.0)
```
Lưu ý: Data Class là nền tảng để xây dựng Model trong kiến trúc MVVM. Mỗi
đối tượng dữ liệu như Book, Ordder, User trong đồ án đều được định nghĩa là
Data Class
```
4.1.4 Kiểm soát luồng (Control Flow)
```
Kotlin hiện đại hóa các câu lệnh kiểm soát luồng truyền thống. Đáng chú ý là if
```
và when trong Kotlin không chỉ là câu lệnh (statement) mà còn là biểu thức
```
```
(expression) có thể trả về giá trị.
```
Biểu thức when – thay thế cho switch
46
when trong Kotlin linh hoạt và mạnh mẽ hơn switch trong Java: có thể kiểm tra
giá trị, kiểu dữ liệu, và khoảng giá trị:
```
fun xepLoaiSach(theLoai: String): String = when (theLoai) {
```
"Kỹ thuật", "Lập trình" -> "Sách chuyên ngành"
"Văn học" -> "Sách văn học"
else -> "Thể loại khác"
```
}
```
Vòng lập for – duyệt tập hợp
Kotlin đơn giản hóa việc duyệt danh sách và khoảng giá trị:
```
val books = listOf("Kotlin", "Android", "Compose")
```
```
for (book in books) {
```
```
println(book)
```
```
}
```
// Duyệt theo chỉ số
```
for (index in books.indices) {
```
```
println("$index: ${books[index]}")
```
```
}
```
4.2. Ví dụ và giải thích
Ví dụ minh họa: Hệ thống quản lý danh mục sách
4.2.1. Mục tiêu của ví dụ
Ví dụ "Hệ thống quản lý danh mục sách" được xây dựng nhằm áp dụng tổng
hợp các khái niệm ngôn ngữ cơ bản của Kotlin đã được trình bày trong phần lý
thuyết. Mục tiêu chính là minh họa cách thức hoạt động thực tế của:
• Data Class trong việc mô hình hóa dữ liệu sách.
```
• Hàm (function) để xử lý nghiệp vụ như lọc sách, tính tổng giá trị.
```
• Biểu thức when và for để kiểm soát luồng xử lý.
```
• Collections (List, Map) để quản lý tập hợp dữ liệu
```
47
4.2.2. Cấu trúc ví dụ
Ví dụ được tổ chức trong một file Kotlin duy nhất, bao gồm: định nghĩa model,
hàm nghiệp vụ, và hàm main thực thi.
Hình 4.1: Cấu trúc file ví dụ quản lý danh mục sách
4.2.3. Phân tích chi tiết và giải thích
Định nghĩa Data Class Book
48
Khai báo model dữ liệu sách sử dụng Data Class:
```
data class Book(
```
val id: Int,
val title: String,
val author: String,
val category: String,
var price: Double,
var stock: Int
```
)
```
Giải thích: Từ khóa data class giúp trình biên dịch tự động sinh
```
toString() để in thông tin sách, equals() để so sánh hai cuốn sách và
```
```
copy() để tạo bản sao với giá khác nhau mà không cần viết thêm bất kỳ
```
dòng code nào.
Hàm lọc xà xử lý danh sách
```
fun locSachTheoTheLoai(danhSach: List<Book>, theLoai: String):
```
```
List<Book> {
```
```
return danhSach.filter { it.category == theLoai }
```
```
}
```
```
fun tinhTongGiaTri(danhSach: List<Book>): Double {
```
```
return danhSach.sumOf { it.price * it.stock }
```
```
}
```
```
Giải thích: Hàm locSachTheoTheLoai sử dụng hàm bậc cao filter{} –
```
một trong những tính năng mạnh mẽ của lập trình hàm trong Kotlin. Biểu
```
thức lambda { it.category == theLoai } được truyền vào như một điều
```
kiện lọc ngắn gọn, thay thế cho vòng lặp tường minh.
Hàm main – Thực thị và hiển thị kết quả
```
fun main() {
```
```
val bookList = listOf(
```
49
```
Book(1, "Kotlin in Action", "JetBrains", "Lập trình", 299000.0,
```
```
15),
```
```
Book(2, "Android Dev Guide", "Google", "Lập trình", 350000.0,
```
```
8),
```
```
Book(3, "Doraemon Vol.1", "Fujiko", "Manga", 89000.0,
```
```
30),
```
```
Book(4, "Clean Architecture", "Robert", "Lập trình", 320000.0, 5)
```
```
)
```
```
val sachLapTrinh = locSachTheoTheLoai(bookList, "Lập trình")
```
```
println("=== Sách lập trình ===")
```
```
sachLapTrinh.forEach { println(" ${it.title} – ${it.price}đ") }
```
```
val tongGiaTri = tinhTongGiaTri(bookList)
```
```
println("Tổng giá trị kho sách: ${tongGiaTri}đ")
```
```
}
```
4.2.4. Kết quả minh họa
Khi thực thi chương trình, màn hình console xuất ra kết quả:
Hình 4.2: Kết quả chạy ví dụ quản lý danh mục sách
4.2.5. Kết luận
Qua ví dụ trên, có thể rút ra một số nhận định chính:
• Data Class giúp định nghĩa model dữ liệu cực kỳ súc tích, tự động
có các phương thức cần thiết mà không phải viết tay.
50
• Các hàm bậc cao như filter, forEach, sumOf giúp xử lý tập hợp dữ
liệu ngắn gọn và biểu đạt hơn so với vòng lặp truyền thống.
• Cú pháp Kotlin nhất quán, rõ ràng, giúp đọc và hiểu code dễ dàng
ngay cả khi chưa có nhiều kinh nghiệm.
4.3. Đồ án
Áp dụng kiến thức ngôn ngữ Kotlin cơ bản vào ứng dụng bán sách
4.3.1. Tổng quan
• Data Class: định nghĩa toàn bộ thực thể dữ liệu: sách, giỏ hàng,
người dùng, danh mục.
• Default & Named Parameters: Khởi tạo đối tượng linh hoạt, tránh
overload hàm.
```
• Computed Property (get()): Tính tổng tiền tự động, đảm bảo nhất
```
quán dữ liệu.
```
• Collections API (sumOf, indexOfFirst, copy, removeAll): Thao
```
tác danh sách giỏ hàng ngắn gọn.
• Biểu thức when: Phân loại mã giảm giá và trạng thái đơn hàng
4.3.2. Định nghĩa các Data Class trong đồ án
Toàn bộ dữ liệu của ứng dụng được biểu diễn thông qua các Data Class rõ
ràng, nhất quán. Mỗi lớp đại diện cho một thực thể nghiệp vụ trong hệ thống bán
sách:
51
Hình 4.3: Cấu trục thư mục data/model/ chứa các Data Class trong đồ án
Model Book – Thực thể sách
```
File: app/src/main/java/com/example/bookstore/data/model/Book.kt
```
52
```
data class Book(
```
val id: String,
val title: String,
val describe: String,
val author: String,
val category: String,
val price: Double – 0.0 // Giá mặc định
val imageUrl: String,
```
)
```
Giải thích: Book là model trung tâm của ứng dụng, xuất hiện ở mọi màn
hình: trang chủ, danh mục, chi tiết sách, giỏ hàng và đơn hàng. Tham số
mặc định price = 0.0 cho phép tạo đối tượng Book linh hoạt kể cả khi
Google Books API không cung cấp thông tin giá — không cần tạo
constructor overload như trong Java.
Lưu ý thiết kế: Book không có field category vì phân loại danh mục được thực
```
hiện thông qua Category.queryKeyword (từ khóa tìm kiếm). Khi người dùng
```
chọn danh mục "Văn học", hệ thống gọi API với queryKeyword =
"subject:fiction literature" và nhận về danh sách sách thuộc thể loại đó. Ngữ
cảnh danh mục được duy trì qua tham số truyền vào màn
```
hình (CategoryDetailScreen(category = ...)) thay vì lưu trong từng đối
```
tượng Book — giúp model đơn giản và không phụ thuộc vào cách phân loại
của UI.
Model CartItem – Thực thể giỏ hàng
```
File: app/src/main/java/com/example/bookstore/data/model/CartItem.kt
```
```
data class CartItem(
```
val book: Book,
var quantity: Int
```
)
```
53
Giải thích: CartItem lưu trữ một cuốn sách cùng số lượng tương ứng
```
trong giỏ hàng. Việc dùng data class giúp tận dụng hàm copy() để cập
```
nhật số lượng một cách an toàn mà không làm thay đổi đối tượng
```
gốc (immutability).
```
Model User – Thực thể người dùng
```
File: app/src/main/java/com/example/bookstore/data/model/CartItem.kt
```
```
data class User(
```
val id: Int,
val username: String,
val email: String,
val fullName: String,
val phoneNumber: String,
val address: String
```
)
```
Giải thích: User chứa thông tin tài khoản người dùng, được dùng trong
màn hình thông tin tài khoản và màn hình thanh toán để tự động điền
thông tin người nhận hàng.
Model Category – Danh mục với companion object
```
File: app/src/main/java/com/example/bookstore/data/model/Category.kt
```
```
data class Category(
```
```
val name: String, // Tên hiển thị trên UI (tiếng Việt)
```
val queryKeyword: String, // Từ khóa tìm kiếm Google Books API
```
(tiếng Anh)
```
val bookCount: Int = 568 // Default parameter — số sách hiển thị
tĩnh
```
) {
```
```
companion object {
```
```
val all: List<Category> = listOf(
```
```
Category("Văn học", "subject:fiction literature"),
```
```
Category("Kinh tế", "subject:economics business"),
```
54
```
Category("Tâm lý học", "subject:psychology self-help"),
```
```
Category("Thiếu nhi", "subject:children juvenile"),
```
```
Category("Giáo khoa", "subject:textbook education"),
```
```
Category("Lịch sử", "subject:history"),
```
// ... 6 danh mục khác
```
)
```
```
}
```
```
}
```
Giải thích:
▪ Default parameter bookCount = 568 cho phép tạo Category không
cần truyền số lượng sách — tất cả 12 danh mục đều dùng giá trị
mặc định này.
▪ companion object chứa danh sách 12 danh mục cố định, truy cập
trực tiếp qua Category.all mà không cần tạo instance — tương
đương static trong Java nhưng cú pháp rõ ràng hơn.
▪ queryKeyword và name được tách biệt: name hiển thị tiếng Việt
trên UI, còn queryKeyword là từ khóa tiếng Anh gửi lên Google
Books API.
```
Data Transfer Objects (DTOs) – Nhóm Data Class lồng nhau
```
```
File: app/src/main/java/com/example/bookstore/data/dto/GoogleBookDto.kt
```
// Phản hồi tổng thể từ Google Books API
```
data class GoogleBookResponse(
```
```
val items: List<BookItem>? = emptyList()
```
```
)
```
// Mỗi cuốn sách trong phản hồi
```
data class BookItem(
```
val id: String,
val volumeInfo: VolumeInfo?, // Nullable — có thể không có thông
tin sách
val saleInfo: SaleInfo? // Nullable — có thể không có thông tin
giá
55
```
)
```
// Thông tin chi tiết sách
```
data class VolumeInfo(
```
val title: String?,
val authors: List<String>?, // Danh sách tác giả
val description: String?,
val imageLinks: ImageLinks?
```
)
```
// Thông tin giá bán
```
data class SaleInfo(
```
```
val retailPrice: Price?, // Giá bán lẻ (sau chiết khấu)
```
val listPrice: Price?, // Giá niêm yết
val saleability: String? // "FOR_SALE" | "NOT_FOR_SALE" |
"FREE"
```
)
```
```
data class Price(
```
val amount: Double?, // Số tiền
val currencyCode: String? // Đơn vị: "VND", "USD", ...
```
)
```
Giải thích: Nhóm DTO phản ánh cấu trúc JSON phân cấp của Google
Books API. Tất cả các field đều là Nullable vì API không đảm bảo trả
về đầy đủ thông tin. Việc tổ chức thành nhiều Data Class lồng
```
nhau (BookItem → VolumeInfo, SaleInfo → Price) giúp ánh xạ dữ liệu
```
```
chính xác và dễ debug nhờ toString() tự sinh.
```
4.3.3. Hàm với Default & Named Parameters
```
File: app/src/main/java/com/example/bookstore/viewmodel/CartViewModel.kt
```
```
// Default Parameter: quantity = 1 khi không truyền (thêm 1 cuốn)
```
```
fun addBook(book: Book, quantity: Int = 1) {
```
56
```
val index = cartItems.indexOfFirst { it.book.id == book.id }
```
```
if (index >= 0) {
```
```
// Named Parameter: copy() với tên tham số rõ ràng
```
```
cartItems[index] = cartItems[index].copy(
```
```
quantity = cartItems[index].quantity + quantity
```
```
)
```
```
} else {
```
```
cartItems.add(CartItem(book, quantity))
```
```
}
```
```
}
```
Giải thích:
```
▪ Default parameter quantity: Int = 1 cho phép gọi addBook(book)
```
```
khi thêm 1 cuốn từ danh sách hoặc addBook(book,2) khi thêm nhiều
```
hơn. Không cần tạo hai hàm overload riêng biệt
```
▪ Named parameter copy(quantity = …) làm rõ thuộc tính nào đang
```
được thay đổi, đặc biệt hữu ích khi Data Class có nhiều trường cùng
kiểu.
▪ Hàm kiểm tra sách đã có trong giỏ chưa trước khi thêm
```
(indexOfFirst) – Nếu có thì cộng dồn số lượng thay vì thêm bản ghi
```
trùng.
4.3.4. Computed Property và Collections API
```
File: app/src/main/java/com/example/bookstore/viewmodel/CartViewModel.kt
```
Computed Property – Tính tổng tiền tự động
// Tổng tiền hàng — tính lại mỗi khi đọc, không lưu trữ trực tiếp
```
val subtotal: Double get() = cartItems.sumOf { it.book.price * it.quantity
```
```
}
```
// Tổng thanh toán = hàng + phí vận chuyển - giảm giá
```
val total: Double get() = subtotal + shippingFee - discountAmount
```
57
```
Giải thích: subtotal và total là computed property (thuộc tính tính
```
```
toán) — được tính lại mỗi lần được truy cập thay vì lưu sẵn giá
```
trị. Điều này đảm bảo tổng tiền luôn phản ánh chính xác trạng thái
hiện tại của giỏ hàng sau mỗi lần thêm, bớt sách, hoặc áp mã giảm
giá — không cần gọi hàm cập nhật thủ công.
58
Hình 4.4: Màn hình giỏ hàng hiển thị subtotal và total được tính tự động từ
computed property]
59
Collections API – Thao tác danh sách giỏ hàng
```
// sumOf{} — tính tổng theo biểu thức lambda
```
```
val subtotal = cartItems.sumOf { it.book.price * it.quantity }
```
```
// indexOfFirst{} — tìm chỉ số phần tử đầu tiên thỏa điều kiện
```
```
val index = cartItems.indexOfFirst { it.book.id == book.id }
```
```
// copy() — cập nhật Data Class bất biến, tạo bản sao với trường mới
```
```
cartItems[index] = cartItems[index].copy(quantity =
```
```
cartItems[index].quantity + 1)
```
```
// removeAll{} — xóa tất cả phần tử thỏa điều kiện
```
```
cartItems.removeAll { it.book.id == bookId }
```
```
Giải thích: when ở đây đóng vai trò biểu thức (expression) — kết quả
```
được gán trực tiếp vào discountAmount mà không cần biến trung
gian. Nhánh else bắt mọi mã không hợp lệ, cập nhật thông báo lỗi và
trả về 0 — đảm bảo giỏ hàng không bị trừ tiền khi mã sai.
4.3.5. Biểu thức when trong xử lý nghiệp vụ
Phân loại mã giảm giá
```
File: app/src/main/java/com/example/bookstore/viewmodel/CartViewModel.kt
```
```
fun applyDiscount() {
```
```
discountAmount = when (discountCode.trim().uppercase()) {
```
"SALE10" -> subtotal * 0.10 // Giảm 10% tổng đơn hàng
"GIAM17" -> 17_000.0 // Giảm cố định 17.000đ
"FREESHIP" -> shippingFee // Miễn phí vận chuyển
```
else -> {
```
```
discountError = "Mã giảm giá không hợp lệ"
```
0.0
```
}
```
60
```
}
```
```
}
```
Phân loại trạng thái đơn hàng
```
File: app/src/main/java/com/example/bookstore/ui/screens/OrderHistoryScreen.kt
```
// Hàm biểu thức đơn + when: ánh xạ status → nhãn hiển thị + màu sắc
- icon
```
private fun getStatusInfo(status: String): StatusInfo = when
```
```
(status.uppercase()) {
```
```
"PENDING" -> StatusInfo("Chờ xác nhận",
```
```
Color(0xFFFF9800), Icons.Outlined.HourglassEmpty)
```
```
"PROCESSING", "CONFIRMED" -> StatusInfo("Đang xử lý",
```
```
Color(0xFF2196F3), Icons.Outlined.Inventory2)
```
```
"SHIPPED", "SHIPPING" -> StatusInfo("Đang giao hàng",
```
```
Color(0xFF9C27B0), Icons.Outlined.LocalShipping)
```
```
"DELIVERED" -> StatusInfo("Đã giao hàng",
```
```
Color(0xFF4CAF50), Icons.Outlined.CheckCircle)
```
```
"CANCELLED" -> StatusInfo("Đã hủy",
```
```
Color(0xFFF44336), Icons.Outlined.Cancel)
```
```
else -> StatusInfo(status, Color.Gray,
```
```
Icons.Outlined.HourglassEmpty)
```
```
}
```
Giải thích: Ví dụ này kết hợp nhiều tính năng ngôn ngữ.
```
▪ Hàm biểu thức đơn (= when {...}) — thân hàm chỉ là một biểu
```
```
thức when, không cần dấu {} và return.
```
```
▪ When với nhiều giá trị trên một nhánh ("PROCESSING",
```
```
"CONFIRMED") — gộp hai trạng thái có cùng cách hiển thị vào
```
một nhánh, điều switch trong Java không hỗ trợ trực tiếp.
▪ StatusInfo cũng là một data class nhỏ — phản ánh cách dùng Data Class
để nhóm nhiều giá trị có liên quan thành một kiểu dữ liệu có ý nghĩa.
4.3.6. Kết quả đạt được
61
Khái niệm Áp dụng thực tế Lợi ích
Data Class
```
Book, User,.. (5 DTO
```
```
classes)
```
```
Tự sinh equals(),
```
```
copy(), toString() –
```
giảm boilrplate với
Java
Default Parameter
```
price = 0.0 (Book),
```
```
bookCount = 568
```
```
(Category), quantity = 1
```
```
(addBook)
```
Tạo đối tượng linh
hoạt, không cần
overload hàm
Named Parameter
```
copy(quantity = …)
```
trong CartViewModel
Code tự mô tả ý
định, tránh nhầm thứ
tự tham số
Computed Property
subtotal, total trong
CartViewModel
Tổng tiền đồng bộ tự
động, không cần cập
nhật thủ công
Collections API
sumOf, indexOfFirtst,
copy, removAll
Thao tác danh sách
ngắn gọn, biểu đạt rõ
ý định
when expression
```
applyDiscount(),
```
```
getStatusInfo(),
```
Phân loại đa trường
hợp an toàn, gộp
nhiều case gọn
companion object Category.all
Truy cập danh sách
danh mục toàn cục
không cần tạo
instance
CHƯƠNG 5: KOTLIN NÂNG CAO VÀ LẬP TRÌNH HÀM
5.1. Lý thuyết
5.1.1. Null Safety – An toàn với giá trị null
62
Một trong những nguyên nhân phổ biến nhất gây ra lỗi ứng dụng trong Java là
```
NullPointerException (NPE) – lỗi xảy ra khi truy cập một đối tượng có giá trị null.
```
Kotlin giải quyết vấn đề này một cách triệt để ngay tại giai đoạn biên dịch thông qua
hệ thống kiểu phân biệt Nullable và Non-Nullable.
Phân biệt Nullable và Non-Nullable
Trong Kotlin, mọi kiểu dữ liệu mặc định đều là Non-Nullable – tức là không
```
thể gán null. Để cho phép giá trị null, phải khai báo tường minh bằng dấu hỏi (?) sau
```
kiểu dữ liệu:
var name: String = "Kotlin” //Non-nullable: không thể gán null
var author: String? = null // Nullable: có thể là null
// name = null // Lỗi biên dịch – trình biên dịch từ chối
```
Toán tử truy cập an toàn – Safe Call Operator (?.)
```
Khi làm việc với biến Nullable, toán tử ?. giúp truy cập thuộc tính hoặc gọi
phương thức một cách an toàn mà không gây NPE. Nếu đối tượng là null, toàn bộ
biểu thức trả về null thay vì ném ngoại lệ:
val author: String? = null
```
val length = author?.length // Kết quả: null (không crash)
```
```
val upper = author?.uppercase() // Kết quả: null
```
```
Toán tử Elvis – Elvis Operator (?:)
```
Toán tử ?: cung cấp một giá trị mặc định khi biểu thức bên trái là null:
val displayName = author ?: "Tác giả không rõ"
// Nếu author là null, displayName = "Tác giả không rõ"
```
Toán tử khẳng định null – Not-Null Assertion (!!)
```
Toán tử !! được dùng khi lập trình viên chắc chắn giá trị không phải null tại
thời điểm thực thi. Nếu giá trị là null, NPE sẽ được ném ra. Do đó, toán tử này cần
được dùng cẩn trọng:
63
val length = author!!.length // Ném NPE nếu author là null
```
Khuyến nghị: Ưu tiên sử dụng safe call (?.) và Elvis (?:) thay vì (!!) để giữ mã
```
nguồn an toàn. Toán tử !! chỉ dùng khi có đủ cơ sở logic đảm bảo giá trị
không null.
5.1.2. Extension Functions – Hàm mở rộng
```
Extension Functions (hàm mở rộng) là một trong những tính năng ấn tượng
```
nhất của Kotlin. Chúng cho phép thêm hàm mới vào một lớp đã tồn tại – kể cả các
lớp của thư viện hay lớp của hệ thống – mà không cần kế thừa hoặc sửa đổi mã
nguồn gốc. Đây là giải pháp thay thế an toàn và linh hoạt cho pattern Decorator.
Cú pháp khai báo
```
fun TênLớp.tênHàmMới(thamSố: KiểuDữLiệu): KiểuTrảVề {
```
// this ở đây là đối tượng của TênLớp
return giá_trị
```
}
```
Ví dụ: mở rộng lớp String để định dạng giá tiền:
```
fun Double.toVND(): String {
```
```
return "%,.0f VNĐ".format(this)
```
```
}
```
val price = 299000.0
```
println(price.toVND()) // Kết quả: 299,000 VNĐ
```
```
Giải thích: Hàm toVND() được thêm vào lớp Double sẵn có của Kotlin.
```
Từ khóa this tham chiếu đến giá trị Double đang được gọi hàm. Nhờ
Extension Function, lập trình viên có thể gọi hàm này như thể nó là một
phương thức gốc của Double.
5.1.3. Higher-Order Functions và Lambda
64
```
Kotlin hỗ trợ lập trình hàm (Functional Programming) ở cấp ngôn ngữ. Hàm
```
```
trong Kotlin là công dân hạng nhất (first-class citizen) – có nghĩa là hàm có thể được
```
lưu vào biến, truyền làm tham số, và trả về từ hàm khác.
```
Hàm bậc cao (Higher-Order Fuctionns)
```
Hàm bậc cao là hàm nhận một hàm khác làm tham số hoặc trả về một hàm.
Đây là nền tảng của lập trình hàm trong Kotlin:
```
fun apDungVoiDanhSach(
```
```
danhSach: List<Book>,
```
```
dieuKien: (Book) -> Boolean
```
```
): List<Book> {
```
```
return danhSach.filter(dieuKien)
```
```
}
```
// Gọi hàm với lambda
```
val sachRe = apDungVoiDanhSach(books) { it.price < 200000.0 }
```
Các hàm xử lý tập hợp phồ biến
Kotlin cung cấp sẵn nhiều hàm bậc cao trong Collections API, giúp thao tác dữ
liệu trở nên cực kỳ súc tích và biểu đạt:
```
• filter {} – Lọc phần tử thỏa điều kiện.
```
```
• map {} – Biến đổi mỗi phần tử thành dạng khác.
```
```
• find {} – Tìm phần tử đầu tiên thỏa điều kiện, trả về null nếu
```
không tìm thấy.
```
• sumOf {} – Tính tổng giá trị số học của các phần tử.
```
```
• groupBy {} – Nhóm các phần tử theo một tiêu chí, trả về Map<K,
```
List<T>>.
Ví dụ kết hợp nhiều hàm xứ lý tập hợp:
val sachTheoGia = books
```
.filter { it.stock > 0 } // Chỉ lấy sách còn hàng
```
```
.sortedBy { it.price } // Sắp xếp tăng dần theo giá
```
```
.map { "${it.title}: ${it.price}" } // Lấy tên và giá
```
65
5.1.4. Sealed Class – Lớp niêm phong
```
Sealed Class (lớp niêm phong) là một loại lớp đặc biệt trong Kotlin, nơi tất cả
```
các lớp con được khai báo tường minh trong cùng một file. Điều này giúp trình biên
dịch biết chính xác tất cả các trạng thái có thể có của một kiểu dữ liệu, cho phép kiểm
```
tra toàn diện (exhaustive) trong biểu thức when mà không cần nhánh else.
```
Ứng dụng điển hình nhất của Sealed Class trong phát triển Android là biểu
```
diễn các trạng thái tải dữ liệu từ API (Loading, Success, Error):
```
```
sealed class UiState<out T> {
```
```
object Loading : UiState<Nothing>()
```
```
data class Success<T>(val data: T) : UiState<T>()
```
```
data class Error(val message: String) : UiState<Nothing>()
```
```
}
```
Sử dụng Sealed Class cùng with biểu thức when:
```
when (uiState) {
```
is UiState.Loading ->
```
CircularProgressIndicator() // Hiện vòng xoay
```
is UiState.Success ->
```
BookList(books = uiState.data) // Hiện danh sách sách
```
is UiState.Error ->
```
ErrorMessage(text = uiState.message) // Hiện thông báo lỗi
```
```
}
```
Lưu ý: Khi dùng Sealed Class với when, nếu thiếu một nhánh xử lý, trình biên
dịch sẽ cảnh báo lỗi ngay tại thời điểm biên dịch. Đây là cơ chế bảo vệ cực
kỳ hữu ích, giúp đảm bảo không bỏ sót trạng thái nào trong vòng đời tải dữ
liệu.
66
5.1.5. Coroutines – Lập trình bất đồng bộ
Coroutines là một trong những tính năng đặc sắc và quan trọng nhất của
```
Kotlin. Chúng cung cấp một cách tiếp cận lập trình bất đồng bộ (asynchronous
```
```
programming) nhẹ nhàng, súc tích và không gây ra callback hell – vấn đề phổ biến
```
khi lập trình với Thread hay các thư viện bất đồng bộ truyền thống.
Tại sao lập trình bắt đồng bộ?
Trong ứng dụng Android, giao diện người dùng chạy trên Main Thread. Nếu
```
thực hiện các tác vụ tốn thời gian (như gọi API, đọc cơ sở dữ liệu) trực tiếp trên Main
```
```
Thread, ứng dụng sẽ bị đóng băng (ANR – Application Not Responding). Coroutines
```
giải quyết vấn đề này bằng cách cho phép tạm dừng và tiếp tục thực thi mà không
chặn thread.
Các khái niệm cốt lõi của Coroutines
• suspend fun: – Từ khóa đánh dấu hàm có thể tạm dừng và tiếp tục
mà không chặn thread. Chỉ được gọi từ trong một Coroutine hoặc
suspend function khác.
• CoroutinScope: Định nghĩa phạm vi sống của Coroutine. Khi
scope bị hủy, mọi Coroutine bên trong bị hủy theo, tránh Memory
Leak.
• Launch: Khởi tạo một Coroutine “fire and forget” – Không chờ
kêt quả trả về.
• async/await: Khởi tạo Coroutine và chờ kết quả trả về, dùng khi
cần chạy song song nhiều tác vụ.
Dispatchers – Điều phối luồng thực thi
• Dispachers.IO: Dành cho tác vụ I/O như gọi API, đọc ghi cơ sở
dữ liệu.
```
• Dispatcher. Main: Dành cho cập nhật giao diện người dùng (UI
```
```
thread).
```
• Dispatcher. Default: Dành cho tác vụ tính toán nặng trên CPU.
67
Ví dụ gọi API bắt đồng bộ với Coroutines trong ViewModel:
```
fun loadBooks() {
```
```
viewModelScope.launch { // Phạm vi gắn với ViewModel
```
_uiState.value = UiState.Loading
```
try {
```
```
val books = withContext(Dispatchers.IO) {
```
```
bookRepository.getBooks() // Gọi API trên IO thread
```
```
}
```
```
_uiState.value = UiState.Success(books)
```
```
} catch (e: Exception) {
```
```
_uiState.value = UiState.Error(e.message ?: "Lỗi không xác
```
```
định")
```
```
}
```
```
}
```
```
}
```
5.2. Ví dụ và giải thích
Ví dụ minh họa: Tải và xứ lý dữ liệu sách bất đồng bộ
5.2.1. Mục tiêu của ví dụ
Ví dụ “Tải và xử lý dữ liệu sách bất đồng bộ” được xây dựng nhầm làm rõ hai
khái niệm nâng cao quan trọng của Kotlin:
• Null Safety: Xử lý an toàn các giá trị có thể null từ phản hồi API.
• Coroutines kết hợp Sealed Class: Mô phỏng quy tình tải dữ liệu
thực tế với các trạng thái Loading → Success/Error.
• Extension Functions: Định dạng và xử lý dữ liệu theo cách gọn
gàng, có thể tái sử dụng.
5.2.2. Cấu trúc dự án
68
Ví dụ được tổ chức theo cấu trục phân lớp đơn giản nhằm phản ánh kiến trúc
MVVM thực tế của đồ án:
Hình 5.1: Cấu trục thư mục ví dụ tải dữ liệu bất đồng bộ 1
69
Hình 5.2: Cấu trục thư mục ví dụ tải dữ liệu bất đồng bộ 2
70
5.2.3. Phân tích chi tiết và giải thích
Định nghĩa Sealed Class UiState
Sealed Class UiState đóng vai trò là “hợp đồng” giữa ViewModel và giao diện,
biểu diễn rõ ràng ba trạng thái có thể xảy ra:
```
sealed class UiState<out T> {
```
```
object Loading : UiState<Nothing>()
```
```
data class Success<T>(val data: T) : UiState<T>()
```
```
data class Error(val message: String) : UiState<Nothing>()
```
```
}
```
```
Giải thích: Từ khóa out T là Covariance (hiệp biến) – cho phép
```
UiState<Book> được coi là UiState<Any>. Điều này giúp Sealed Class
```
có thể tái sử dụng cho mọi loại dữ liệu (sách, đơn hàng, người dùng) mà
```
không cần tạo class riêng biệt.
Extennsion Function xử lý dữ liệu
Extension Functions được dùng để bổ sung khả năng định dạng cho các kiểu
dữ liệu hiện có:
```
fun Double.toFormattedPrice(): String {
```
```
return "%,.0f VNĐ".format(this)
```
```
}
```
```
fun String?.orDefault(default: String = "Không rõ"): String {
```
return this ?: default
```
}
```
```
Giải thích: Hàm orDefault() được khai báo trên kiểu String? (nullable
```
```
String). Toán tử Elvis(?:) bên trong trả về giá trị mặc định khi chuỗi là
```
null. Đây là ví dụ điển hình về cách kết hợp Null Safety và Extension
Function để tạo ra API ngôn ngữ trực quan.
71
Repository mô phỏng gọi API với Coroutines
```
class BookRepository {
```
```
suspend fun fetchBooks(): List<Book> {
```
```
delay(1500L) // Mô phỏng độ trễ mạng
```
```
return listOf(
```
```
Book("1", "Kotlin in Action", "JetBrains", 299000.0, null),
```
```
Book("2", "Android Dev Guide", null, 350000.0, "Sách
```
```
chính thức"),
```
```
)
```
```
}
```
```
}
```
Giải thích: Từ khóa suspend đánh dấu hàm này có thể tạm dừng và tiếp
```
tục. Hàm delay() của Coroutines sẽ tạm dừng Coroutine đang chạy mà
```
```
không chặn thread, khác hoàn toàn với Thread.sleep() trong Java – vốn sẽ
```
chặn toàn bộ thread.
5.2.4. Kết quả minh họa
Khi ứng dụng chạy, luồng hoạt động diễn ra theo trình tự:
```
• Giao diện hiển thị CircularProgressIndicator (trạng thái Loading).
```
• Sau 1.5 giây, dữ liệu được tải xong, giao diện chuyển sang hiển
thị danh sách sách.
```
• Nếu xảy ra lỗi (mất kết nối mạng), giao diện chuyển sang hiển thị
```
thông báo lỗi.
Hình 5.3: Trạng thái giao diện UiState.Loading,
72
Hình 5.4: Trạng thái giao diện UiState.Success
Hình 5.5: Trạng thái giao diện UiState.Error
5.2.5. Kết luận
Ví dụ “Tải và xử lý dữ liệu sách bất đồng bộ” minh họa cách Kotlin Nâng cao
giải quyết các bài toán thực tế trong phát triển Android:
• Null Safety loại bỏ hoàn toàn nguy cơ NPE ngay tại giai đoạn
biên dịch, đặc biệt quan trọng khi xử lý dữ liệu từ API có thể thiếu
trường.
• Sealeed Class tạo ra hợp đồng trạng thai rõ ràng và an toàn, buộc
lập trình viên phải xử lý mọi trường hợp có thể xảy ra.
• Coroutines làm cho mã xử lý bất đồng bộ trông và đọc giống mã
đồng bộ thông thường, giảm đáng kể độ phức tập nhận thức.
5.3. Đồ án
73
5.3.1. Tổng quan
```
Đồ án "Ứng dụng bán sách" (BookStore) vận dụng toàn diện các tính năng
```
Kotlin nâng cao đã được nghiên cứu ở mục 5.1 và 5.2 để xây dựng hai
tầng cốt lõi trong kiến trúc MVVM:
```
• Tầng Data (data/repo/, data/dto/): xử lý API, ánh xạ DTO → Domain
```
```
• Tầng ViewModel (viewmodel/): điều phối trạng thái UI và gọi
```
Coroutines
```
• Tầng UI (ui/screens/): phản ánh trạng thái qua when expression
```
Kỹ thuật Vị trí áp dụng Mục đích
Sealed Clas
UiState
UiState.kt, CategoryViewModel,
CategoryDetailScreen
Quản lý 3 trạng
thái Loading
```
Null Safety BookRepository.toDomainModel()
```
Chuyển đổi DTO
→ Book an toàn
Extension
Functions
Extensions.kt
Định dạng tiền tệ,
giá trị mặc định,
giá hiển thị
Higher-Order
Functions
CatergoryDetailScreen,
CartViewModel
Lọc và sắp xếp
danh sách
Coroutines
BookDetailViewModel,
CatergoryViewModel,
CheckoutViewModel
Gọi API bất đồng
bộ không chặn
Main Thread
5.3.2. Sealed Class quản lý trạng thái giao diện
Định nghĩa UiState
```
File: ui/state/UiState.kt định nghĩa Sealed Class tổng quát dùng chung cho
```
mọi màn hình:
```
sealed class UiState<out T> {
```
/** Trạng thái đang tải dữ liệu */
```
data object Loading : UiState<Nothing>()
```
/** Trạng thái tải thành công — chứa dữ liệu kiểu T */
```
data class Success<T>(val data: T) : UiState<T>()
```
74
/** Trạng thái lỗi — chứa thông báo lỗi */
```
data class Error(val message: String) : UiState<Nothing>()
```
```
}
```
Giải thích:
• sealed class giới hạn tập con: trình biên dịch biết chính xác tất cả các
trạng thái có thể xảy ra, bắt buộc when phải xử lý đủ cả ba nhánh —
không bỏ sót.
```
• out T (Covariance): cho phép UiState<List<Book>> được coi
```
```
là UiState<Any>, giúp tái sử dụng cho mọi loại dữ liệu (sách, đơn
```
```
hàng, người dùng) mà không cần tạo Sealed Class riêng biệt.
```
```
• data object Loading (Kotlin 1.9+): là singleton, không chứa dữ liệu —
```
dùng data object thay object để hỗ trợ equals/toString.
• UiState<Nothing> cho Loading và Error: Nothing là kiểu con của mọi
kiểu — giúp hai trạng thái này tương thích với mọi UiState<T>.
Áp dụng trong CategoryViewModel
```
File: viewmodel/CategoryViewModel.kt dùng UiState kết hợp với
```
Coroutines và StateFlow:
@HiltViewModel
```
class CategoryViewModel @Inject constructor(
```
private val repository: BookRepository
```
) : ViewModel() {
```
// Trạng thái UI khởi tạo là Loading
private val _uiState =
```
MutableStateFlow<UiState<List<Book>>>(UiState.Loading)
```
val uiState: StateFlow<UiState<List<Book>>> =
```
_uiState.asStateFlow()
```
```
fun loadBooks(query: String) {
```
```
if (query == currentQuery && _uiState.value is UiState.Success)
```
return
```
currentQuery = query
```
75
```
viewModelScope.launch {
```
_uiState.value = UiState.Loading
```
repository.getBooksResult(query)
```
```
.onSuccess { books ->
```
```
_uiState.value = UiState.Success(books)
```
```
}
```
```
.onFailure { error ->
```
```
// Elvis operator (?:) — Null Safety
```
```
_uiState.value = UiState.Error(error.message ?: "Lỗi không
```
```
xác định")
```
```
}
```
```
}
```
```
}
```
```
}
```
Giải thích:
```
• MutableStateFlow<UiState<List<Book>>>(UiState.Loading): khởi
```
tạo trạng thái ban đầu là Loading.
```
• asStateFlow(): chuyển sang StateFlow chỉ đọc — UI không thể thay
```
đổi trực tiếp, chỉ ViewModel mới cập nhật được.
```
• repository.getBooksResult() trả về
```
Result<List<Book>> — .onSuccess/ .onFailure là Higher-Order
Function của Kotlin standard library, xử lý kết quả an toàn không
cần try-catch.
Áp dụng trong CategoryDetailScreen – when exhaustive
```
File: ui/screens/CategoryDetailScreen.kt sử dụng when để phản ánh trạng
```
thái ra UI:
// Collect StateFlow từ ViewModel
```
val uiState by viewModel.uiState.collectAsStateWithLifecycle()
```
```
when (val state = uiState) {
```
76
```
is UiState.Loading -> {
```
```
Box(modifier = Modifier.fillMaxSize(), contentAlignment =
```
```
Alignment.Center) {
```
```
CircularProgressIndicator(color = AppColors.PrimaryBlue)
```
```
}
```
```
}
```
```
is UiState.Error -> {
```
```
Column(horizontalAlignment = Alignment.CenterHorizontally) {
```
```
Text("Không tải được sách")
```
```
Text(state.message, color = Color.Gray) // truy cập .message
```
của Error
```
Button(onClick = {
```
```
viewModel.loadBooks(category.queryKeyword) }) {
```
```
Text("Thử lại")
```
```
}
```
```
}
```
```
}
```
```
is UiState.Success -> {
```
// state.data là List<Book> — truy cập .data của Success
val books = state.data
```
LazyVerticalGrid(...) {
```
```
items(books) { book -> BookCard(book = book, ...) }
```
```
}
```
```
}
```
```
}
```
```
Giải thích: when (val state = uiState) là exhaustive when
```
expression — Sealed Class đảm bảo trình biên dịch báo lỗi nếu thiếu
nhánh. Việc khai báo val state = uiState trong when cho phép smart
```
cast: trong nhánh is UiState.Success, biến state được tự động ép kiểu
```
sang UiState.Success<List<Book>> nên có thể truy cập state.data trực
tiếp.
77
Hình 5.5: Màn hình danh mục —trạng thái Loading
78
Hình 5.6: Màn hình danh mục —trạng thái Success
79
Hình 5.7: Màn hình danh mục —trạng thái Error
80
5.3.3. Null Safety trong xử lý dữ liệu API
```
Dữ liệu từ Google Books API có nhiều trường tùy chọn (có
```
```
thể null). Hàm toDomainModel() trong BookRepository ánh xạ
```
DTO → Book an toàn nhờ Null Safety:
```
private fun BookItem.toDomainModel(): Book {
```
val bookPrice = this.saleInfo?.retailPrice?.amount
?: this.saleInfo?.listPrice?.amount
?: 0.0
```
return Book(
```
```
id = this.id,
```
```
title = this.volumeInfo?.title ?: "Chưa rõ tên sách",
```
```
author = this.volumeInfo?.authors?.firstOrNull() ?: "Khuyết
```
danh",
```
imageUrl = this.volumeInfo?.imageLinks?.thumbnailUrl
```
```
?.replace("http:", "https:") ?: "",
```
```
describe = this.volumeInfo?.description
```
```
?.replace(Regex("<.*?>"), "") ?: "Đang cập nhật mô tả...",
```
```
price = bookPrice
```
```
)
```
```
}
```
Giải thích từng toán tử:
81
Toán tử Dòng Ý nghĩa
```
?. (Safe Call) This.saleInfo?.retailPrice?.mount
```
Nếu saleInfo là null,
toàn bộ chuỗi trả về
null thay vì
NullPointerException
```
?: (Elvis)
```
?: this.saleInfo?.listPrice?.amount
?: 0.0
Fallback theo chuỗi:
retailPrice ->
listPrice -> 0.0
```
?.firstOrNull()
```
```
Authors?.firstOrNull()
```
Lấy tác giả đầu tiên
nếu danh sách không
rỗng, trả null nếu
trống
```
?.replace(…) thumbnailUrl?.replace(…)
```
Chỉ thay thế chuỗi
khi URL không null
?: “”
Cuối dòng imageUrl
Trả về chuỗi rỗng
nếu không có URL
```
Hàm getBooksResult() trong cùng file áp dụng thêm toán tử Elvis ở tầng xử
```
lý HTTP:
```
suspend fun getBooksResult(query: String): Result<List<Book>> {
```
```
return try {
```
```
val response = api.searchBooks(query)
```
```
if (response.isSuccessful) {
```
```
val items = response.body()?.items ?: emptyList() // Safe Call +
```
Elvis
```
Result.success(items.map { it.toDomainModel() })
```
```
} else {
```
```
Result.failure(Exception("Không tải được sách (HTTP
```
```
${response.code()})"))
```
```
}
```
```
} catch (e: Exception) {
```
```
Result.failure(Exception("Lỗi kết nối: ${e.message ?: "Không xác
```
```
định"}"))
```
```
}
```
```
}
```
82
```
Giải thích: response.body()?.items ?: emptyList(): chuỗi hai toán
```
```
tử — body() có thể trả null (HTTP body rỗng), items cũng có
```
```
thể null (API không có kết quả); Elvis ?: đảm bảo không bao giờ
```
bị NullPointerException hay IndexOutOfBoundsException khi duyệt
danh sách.
5.3.4. Extension Functions
```
File: utils/Extensions.kt định nghĩa ba Extension Function mở rộng kiểu có
```
sẵn mà không cần kế thừa:
```
Double.toVnd()– Định dạng tiền tệ VND
```
```
fun Double.toVnd(): String {
```
val fmt =
```
NumberFormat.getNumberInstance(Locale.forLanguageTag("vi-VN"))
```
fmt.maximumFractionDigits = 0
```
return "${fmt.format(this.toLong())}đ"
```
```
}
```
// Sử dụng: gọi như phương thức gốc của Double
val gia = 88_000.0
```
Text(text = gia.toVnd()) // Hiển thị: "88.000đ"
```
```
Giải thích: fun Double.toVnd() khai báo this là một Double — hàm hoạt
```
động như phương thức của Double dù được định nghĩa bên ngoài
```
lớp. Locale.forLanguageTag("vi-VN") định dạng số theo chuẩn Việt
```
```
Nam: dấu chấm phân cách hàng nghìn.
```
```
String?.orDefault() – Kết hợp Null Safety và Extension Function
```
```
fun String?.orDefault(default: String = "Chưa có thông tin"): String =
```
```
this?.ifBlank { default } ?: default
```
// Sử dụng
val description: String? = null
```
Text(text = description.orDefault()) // "Chưa có thông tin"
```
83
```
Text(text = " ".orDefault("Không rõ")) // "Không rõ" (chuỗi blank)
```
```
Text(text = "Lập trình Kotlin".orDefault()) // "Lập trình Kotlin"
```
```
Giải thích: Khai báo trên String? (nullable String) — hàm có thể gọi
```
```
trên cả giá trị null mà không gây lỗi. this?.ifBlank { default
```
```
} trả null nếu this là null, hoặc trả default nếu this chỉ chứa khoảng
```
```
trắng; toán tử Elvis ?: xử lý trường hợp null còn lại.
```
```
Book.displayPrice()– Chuẩn hóa giá hiển thị
```
```
fun Book.displayPrice(): Double =
```
```
if (price >= 1_000.0) price // Giá hợp lệ (đã là VND)
```
```
else 50_000.0 + (id.hashCode().absoluteValue % 20) * 10_000.0 //
```
Mock VND
// Sử dụng trong CategoryDetailScreen
```
val sorted = state.data.sortedBy { it.displayPrice() }
```
```
Text(text = book.displayPrice().toVnd()) // "88.000đ"
```
```
Giải thích: Google Books API trả về giá USD (ví dụ: 1.71) hoặc 0.0 khi
```
```
không có giá. displayPrice() chuẩn hóa về khoảng giá VND hợp
```
```
lệ (50.000đ – 240.000đ) dựa trên hash của id — đảm bảo mỗi cuốn sách
```
luôn hiển thị cùng một giá, nhất quán giữa các lần tải. Extension
```
Function cho phép gọi book.displayPrice() tự nhiên như thuộc tính
```
của Book.
5.3.5. Higher-Order Functions trong xử lý danh sách
Sắp xếp và lọc trong CategoryDetailScreen
Sau khi UiState.Succeess được nhận, danh sách được xử lý qua Higher-
OrderFunctions trước khi hiển thị:
```
is UiState.Success -> {
```
// Bước 1: Sắp xếp theo tiêu chí người dùng chọn
84
```
val sorted: List<Book> = when (sortOption) {
```
```
"Giá tăng dần" -> state.data.sortedBy { it.displayPrice() }
```
```
"Giá giảm dần" -> state.data.sortedByDescending {
```
```
it.displayPrice() }
```
```
"Tên A-Z" -> state.data.sortedBy { it.title }
```
else -> state.data
```
}
```
// Bước 2: Lọc theo khoảng giá người dùng chọn
```
val books: List<Book> = when (selectedPriceRange) {
```
```
"Dưới 100k" -> sorted.filter { it.displayPrice() < 100_000 }
```
```
"100k–200k" -> sorted.filter { it.displayPrice() in
```
```
100_000.0..200_000.0 }
```
```
"Trên 200k" -> sorted.filter { it.displayPrice() > 200_000 }
```
else -> sorted
```
}
```
```
}
```
Giải thích
Hàm Kiểu lambda Ý nghĩa
```
sortedBy {
```
```
it.displayPrice() }
```
```
(Book) ->
```
Comparable<*>
Sắp xếp tăng dần
theo giá hiển thị
```
sortedByDescending {
```
```
it.displayPrice() }
```
```
(Book) ->
```
Comparable<*> Sắp xếp giảm dần
```
sortedBy { it.title }
```
```
(Book) -> String
```
Sắp xết A-Z theo tên
```
filter { it.displayPrice()
```
```
< 100_000 }
```
```
(Book) -> Boolean
```
Lọc sách dưới 100k
```
filter { it.displayPrice()
```
in 100_000.0..200_000.0
```
}
```
```
(Book) -> Boolean
```
Lọc khoảng 100k–
200k dùng in range
85
```
Các hàm này là Higher-Order Function – nhận lambda { it.displayPric() }
```
```
làm tham số, không thay đổi danh sách góc (immutable), luôn trả về
```
danh sách mới.
Higher-Order Functions trong CartViewModel
```
val subtotal: Double get() = cartItems.sumOf { it.book.price * it.quantity
```
```
}
```
```
fun removeItem(bookId: String) {
```
```
cartItems.removeAll { it.book.id == bookId }
```
```
}
```
```
fun addBook(book: Book, quantity: Int = 1) {
```
```
val index = cartItems.indexOfFirst { it.book.id == book.id }
```
```
if (index >= 0) {
```
```
cartItems[index] = cartItems[index].copy(quantity =
```
```
cartItems[index].quantity + quantity)
```
```
} else {
```
```
cartItems.add(CartItem(book, quantity))
```
```
}
```
```
}
```
Giải thích flow Coroutines trong CheckoutViewModel:
```
• sumOf { it.book.price * it.quantity }: tính tổng tiền giỏ hàng —
```
Higher-Order Function nhận lambda tính giá trị mỗi phần tử rồi cộng
dồn.
```
• removeAll { it.book.id == bookId }: xóa tất cả phần tử thỏa điều kiện
```
— lambda trả về Boolean.
```
• indexOfFirst { it.book.id == book.id }: tìm vị trí phần tử đầu tiên thỏa
```
```
điều kiện — trả -1 nếu không tìm thấy (thay cho vòng lặp thủ công).
```
86
Hình 5.8: Màn hình giỏ hàng — Tổng tiền tính bằng sumOf, xóa sản phẩm
bằng removeAll
87
5.3.6. Coroutines trong kiến trúc đồ án
BookDetailViewModel – Tải chi tiết sách
@HiltViewModel
```
class BookDetailViewModel @Inject constructor(
```
private val repository: BookRepository,
```
savedStateHandle: SavedStateHandle
```
```
) : ViewModel() {
```
```
var book by mutableStateOf<Book?>(null)
```
private set
```
var isLoading by mutableStateOf(false)
```
private set
```
init {
```
```
val bookId = savedStateHandle.get<String>("bookId")
```
```
if (bookId != null) {
```
```
fetchBookDetail(bookId)
```
```
}
```
```
}
```
```
private fun fetchBookDetail(id: String) {
```
```
viewModelScope.launch { // Khởi động Coroutine gắn với
```
ViewModel
```
isLoading = true
```
```
book = repository.getBookById(id) // suspend function — tạm
```
dừng, không chặn thread
```
isLoading = false
```
```
}
```
```
}
```
```
}
```
Giải thích flow Coroutines trong CheckoutViewModel:
88
• viewModelScope.launch: khởi động Coroutine trong scope của
```
ViewModel — khi ViewModel bị hủy (người dùng rời màn hình),
```
Coroutine tự động bị hủy, tránh memory leak
```
• repository.getBookById(id) là suspend fun: Coroutine tạm dừng tại
```
```
đây chờ kết quả từ API (I/O), không chặn Main Thread. Giao diện vẫn
```
phản hồi mượt mà trong lúc chờ.
• isLoading = true/false: cập nhật trạng thái trực tiếp trên Main Thread
```
(Dispatcher mặc định của viewModelScope là Dispatchers.Main)
```
CategoryViewModel – Tải danh sách với UiState
```
fun loadBooks(query: String) {
```
```
viewModelScope.launch {
```
_uiState.value = UiState.Loading // Cập nhật UI ngay lập tức
```
repository.getBooksResult(query) // suspend: chờ API không
```
chặn thread
```
.onSuccess { books ->
```
```
_uiState.value = UiState.Success(books)
```
```
}
```
```
.onFailure { error ->
```
```
_uiState.value = UiState.Error(error.message ?: "Lỗi không
```
```
xác định")
```
```
}
```
```
}
```
```
}
```
CheckoutViewModel – Đặt hàng và tích hợp MoMo
```
fun placeOrder(cartItems: List<CartItem>, ...) {
```
```
viewModelScope.launch {
```
```
isLoading = true
```
```
errorMessage = null
```
89
```
val userId = tokenManager.userId.first() // suspend: đọc từ
```
DataStore Flow
```
val request = OrderRequest(
```
```
userId = userId ?: 0L,
```
```
items = cartItems.map { item -> // Higher-Order Function:
```
map
```
OrderItemRequest(
```
```
bookId = item.book.id,
```
```
quantity = item.quantity,
```
```
price = item.book.price,
```
```
bookTitle = item.book.title,
```
```
imgUrl = null
```
```
)
```
```
}
```
```
)
```
```
val result = orderRepository.createOrder(request) // suspend: gọi
```
backend API
```
isLoading = false
```
```
result.onSuccess { paymentResponse ->
```
```
createdOrderId = paymentResponse.orderId
```
```
if (paymentMethod == "MOMO") {
```
```
pendingPayUrl = paymentResponse.payUrl // URL
```
MoMo thanh toán
```
pendingDeeplink = paymentResponse.deeplink // Deep link
```
mở app MoMo
```
} else {
```
```
orderSuccess = true // COD — hiện dialog thành công
```
```
}
```
```
}
```
```
result.onFailure { errorMessage = it.message }
```
```
}
```
```
}
```
90
Giải thích flow Coroutines trong CheckoutViewModel:
1. viewModelScope.launch – bắt đầu Coroutine trên Main Thread.
2. tokenManager.userId.first() – suspend fun đọc bất đồng bộ từ
```
DataStore (bộ nhớ cục bộ).
```
3. cartItems.map { ... } — Higher-Order Function đồng bộ, chuyển danh
   sách CartItem → OrderItemRequest.
4. orderRepository.createOrder(request) — suspend fun gọi backend
```
API (Retrofit), tạm dừng Coroutine chờ phản hồi HTTP.
```
5. Sau khi có kết quả, Coroutine tiếp tục trên Main Thread, cập nhật state
   → Compose tự recompose.
   5.3.7. Kết quả đạt được
   Kỹ thuật Vấn đề giải quyết Kết quả thực tế
   Null Safety
   Dữ liệu API có thể thiếu
   trường
   Không có
   NullPointerException
   trong toàn bộ tầng
   data
   Sealed Class
   UiState
   Giao diện cần phản ánh
   đúng mọi trạng thái
   When exhaustive:
   Loading/ Success/
   Error được xử lý đầy
   đủ
   Extension Functions
   Định dạng tiền tệ, giá trị
   mặc định
   Api ngôn ngữ tự
```
nhiên: price.toVnd(),
```
```
text.orDefault()
```
Higher-Order
Functions
Lọc và sắp xếp danh
sách
Code ngắn gọn,
không có vòng lặp
thủ công
Coroutines
Gọi API có thể mất vài
giây
App không bao giờ
đóng băng, tự hủy
khi rời màn hình
91
Việc kết hợp năm kỹ thuật này tạo ra kiến trúc nhất quán: dữ liệu từ Google
```
Books API và backend được ánh xạ an toàn (Null Safety) → xử lý bất đồng
```
```
bộ (Coroutines) → phát trạng thái (StateFlow + UiState Sealed Class) → UI
```
```
phản ánh trực quan (Jetpack Compose when expression) → danh sách được
```
```
lọc/ sắp xếp (Higher-Order Functions) trước khi hiển thị ra màn hình.
```
CHƯƠNG 6: LẬP TRÌNH GIAO DIỆN VỚI JETPACK COMPOSE
6.1. Lý thuyết về Jetpack Compose
6.1.1. Jetpack Compose là gì?
Jetpack Compose là bộ công cụ hiện đại của Google dùng để xây dựng giao
```
diện người dùng (UI) cho Android một cách khai báo (declarative). Thay vì sử dụng
```
XML để định nghĩa giao diện và tách biệt hoàn toàn với logic xử lý như cách truyền
thống, Compose cho phép bạn xây dựng UI trực tiếp bằng mã Kotlin.
Điều này có nghĩa là toàn bộ giao diện của bạn được định nghĩa bằng các hàm
Kotlin, giúp code trở nên trực quan, dễ đọc, dễ bảo trì và giảm thiểu lỗi hơn rất nhiều.
6.1.2. Nguyên lý hoạt động
Cốt lõi của Jetpack Compose nằm ở các hàm Composable. Một hàm
Composable là một hàm Kotlin thông thường nhưng được đánh dấu bằng annotation
@Composable. Annotation này báo cho trình biên dịch Compose biết rằng hàm này
sẽ chuyển đổi dữ liệu thành các thành phần giao diện.
```
• Khai báo (Declarative): Bạn khai báo giao diện sẽ trông như thế
```
nào dựa trên trạng thái dữ liệu hiện tại. Bạn không cần viết các bước
phức tạp để tìm kiếm view và cập nhật chúng như findViewById
hay setText.
92
```
• Tự động cập nhật: Khi dữ liệu (state) thay đổi, compose tự động
```
```
gọi lại (recompose) các hàm Composable có liên quan để cập nhật
```
giao diện. Cơ chế này được gọi là recomposition.
Minh hoạ:
@Composable
```
fun Greeting(name: String) {
```
```
Text(text = "Hello $name!")
```
```
}
```
Trong ví dụ trên, Greeting là một hàm Composable nhận tham số name và hiển
thị nó. Nếu giá trị name thay đổi, Compose sẽ tự động chạy lại hàm Greeting để hiển
thị tên mới.
6.1.3. Các khái niệm cơ bản
Để bắt đầu xây dựng giao diện với Compose, bạn cần nắm các khái niệm nền
tảng sau:
a. Hàm Composable (@Composable)
Đây là đơn vị cơ bản nhất để xây dựng UI. Mọi thứ ta nhìn thấy trên màn hình
đều được tạo từ các hàm này. Ta có thể tạo các composable của riêng mình và kết
hợp chúng lại với nhau để tạo thành các composable phức tạp hơn.
b. Modifier
Modifier là một đối tượng bất biến giúp ta trang trí hoặc thay đổi hành vi của
một composable . Nó cho phép ta căn chỉnh, thêm padding, thay đổi kích thước, xử lý
```
sự kiện click, v.v. Modifier được sử dụng theo phong cách chuỗi (chaining) để áp
```
dụng nhiều hiệu ứng cùng lúc.
93
@Composable
```
fun MyComponent() {
```
```
Text(
```
```
text = "Xin chào",
```
```
modifier = Modifier
```
```
.padding(16.dp)
```
```
.fillMaxWidth()
```
```
.clickable { /* Xử lý click */ }
```
```
)
```
```
}
```
c. State
State là bất kỳ giá trị nào có thể thay đổi theo thời gian, ví dụ như nội dung
trong ô nhập liệu, vị trí của thanh trượt, hay kết quả trả về từ mạng . Để Compose có
thể theo dõi và cập nhật UI khi state thay đổi, ta cần lưu trữ state trong một đối tượng
mutableStateOf và sử dụng remember để giữ giá trị này qua các lần recomposition.
@Composable
```
fun MyScreen() {
```
```
var count by remember { mutableStateOf(0) }
```
```
Button(onClick = { count++ }) {
```
```
Text("Đã nhấn $count lần")
```
```
}
```
```
}
```
d. Surface và MarterialTheme
```
Surface: Là một composable trung tâm trong Material Design, đại diện
```
cho một mặt phẳng. Nó được dùng để làm nền, tạo bóng đổ, xử lý hình
```
dạng (shape) và là nơi bắt đầu cho nhiều composable khác.
```
```
MarterialTheme: Cung cấp hệ thống màu sắc, kiểu chữ (typography)
```
```
và hình dạng (shapes) nhất quán cho toàn bộ ứng dụng theo chuẩn
```
Material Design 3.
```
6.1.4. Các thành phần giao diện chính (UI Components)
```
a. Layouts (Bố cuc)
94
Các Composable Layout giúp sắp xếp các thành phần UI trên màn hình.
Composable Mục đích Ví dụ sử dụng
Column
Sắp xếp các thành phần
```
con theo chiều dọc (từ
```
```
trên xuống dưới)
```
Một form đăng nhập
với các trường nhập
liệu xếp chồng
Row
Sắp xếp các thành phần
con theo chiều ngang
```
(từ trái sang phải)
```
Một hàng các biểu
tượng hoặc nút bấm
Box
Xếp chồng các thành
phần con lên nhau.
Thành phần được khai
báo sau sẽ nằm trên
thành phần khai báo
trước
Một hình ảnh nền với
```
một lớp phủ (overlay)
```
văn bản bên trên
LazyColumn /
LazyRow
Phiên bản tương đương
của RecyclerView, hiển
thị danh sách các thành
phần có thể cuộn một
cách hiệu quả. Nó chỉ
render những thành
phần đang hiển thị trên
màn hình
Danh sách hàng trăm
bài báo, tin nhắn
LazyVerticalGrid
Hiển thị danh sách các
thành phần dưới
```
dạng lưới (grid) có
```
thể cuộn
Thư viện ảnh, danh
sách sản phẩm
b. Marterial Components (Thành phần Marterial)
Đây là các composable được Google thiết kế sẵn để tuân thủ các nguyên tắc
của Material Design, giúp ứng dụng của bạn có giao diện chuyên nghiệp và nhất
quán.
95
Loại thành phần
Các composable phổ
biến
Mô tả ngắn
Tương tác cơ bản
Button, IconButton,
FloatingActionButton,
Checkbox, RadioButton,
Switch, Slider
Cho phép người dùng
thực hiện các hành động
và lựa chọn
Hiển thị thông tin
Text, Image, Card,
ProgressIndicator,
Snackbar
Dùng để hiển thị văn bản,
hình ảnh, nhóm nội dung,
trạng thái tải và thông báo
ngắn
Nhập liệu
TextField,
OutlinedTextField
Cho phép người dùng
nhập văn bản
Điều hướng & Cấu trúc
TopAppBar,
BottomNavigation,
NavigationDrawer,
ModalDrawer, Scaffold,
TabRow
Cung cấp cấu trúc tổng
thể cho màn hình và hỗ
trợ điều hướng giữa các
phần. Scaffold là
composable đặc biệt giúp
bạn dễ dàng kết hợp các
thành phần này lại với
nhau
Tạm thời / Nổi bật
AlertDialog, Dialog,
BottomSheet, Menu,
Tooltip
Hiển thị các nội dung tạm
thời, yêu cầu xác nhận
hoặc cung cấp thêm tùy
chọn
```
6.1.5. Điều hướng trong Compose (Navigation) và Nested
```
Navigation Graphs.
```
Trong các ứng dụng có nhiều màn hình, việc điều hướng (navigation) là yếu tố
```
không thể thiếu. Jetpack Compose cung cấp thư viện navigation-compose để quản lý
điều hướng giữa các composable một cách khai báo và an toàn về kiểu.
a. Các thành phần cơ bản của Navigation
• NavController: Đối tượng trung tâm quản lý back stack và các
hành động điều hướng. Được tạo bằng
```
rememberNavController().
```
96
```
• NavHost: Vùng chứa định nghĩa các destination (đích đến) và
```
liên kết chúng với các composable. Mỗi destination có một route
```
(chuỗi định danh).
```
```
• composable(): Hàm mở rộng dùng để thêm một destination vào
```
NavHost, kèm theo route và composable tương ứng.
• Ví dụ cơ bản:
```
val navController = rememberNavController()
```
```
NavHost(navController = navController, startDestination = "home") {
```
```
composable("home") { HomeScreen(navController) }
```
```
composable("detail") { DetailScreen() }
```
```
}
```
```
// Điều hướng: navController.navigate("detail")
```
b. Truyền tham số khi điều hướng
NavController cho phép truyền tham số động qua route, ví dụ
```
"book_detail/{bookId}". Tham số được khai báo với navArgument và kiểu dữ liệu
```
```
tương ứng (NavType.StringType, IntType, ...).
```
```
composable(
```
```
route = "book_detail/{bookId}",
```
```
arguments = listOf(navArgument("bookId") { type =
```
```
NavType.StringType })
```
```
) { backStackEntry ->
```
```
val bookId = backStackEntry.arguments?.getString("bookId") ?: ""
```
```
BookDetailScreen(bookId = bookId)
```
```
}
```
// Điều hướng kèm tham số:
```
navController.navigate("book_detail/abc123")
```
c. Nested Navigation Graphs (Đồ thị điều hướng lồng nhau)
Trong các ứng dụng có cấu trúc phức tạp, việc nhóm các màn hình có liên quan
```
thành một đồ thị con (nested graph) giúp tổ chức code rõ ràng, tái sử dụng logic và dễ
```
dàng quản lý back stack. Nested graph thường được sử dụng kết hợp với
BottomNavigation để mỗi tab có một luồng điều hướng riêng.
Lợi ích của Nested Navigation Graphs:
• Tách biệt luồng màn hình: Mỗi tab có thể quản lý back stack
riêng, tránh xung đột.
97
```
• Tái sử dụng logic: Các màn hình con (ví dụ BookDetailScreen)
```
```
có thể được gọi từ nhiều nơi (Home, Category, Search) mà
```
không cần viết lại.
• Hỗ trợ BottomNavigation: Dễ dàng chuyển đổi giữa các tab
```
mà vẫn giữ được trạng thái riêng (vị trí cuộn, dữ liệu đã nhập).
```
• Quản lý back stack tốt hơn: Khi người dùng nhấn nút Back, họ
quay lại đúng màn hình trước đó trong cùng luồng.
d. Hàm navigation() — Khai báo sub-graph
```
Để tạo một Nested Navigation Graph thực sự, dùng hàm navigation() bên
```
```
trong NavHost. Mỗi sub-graph có route riêng (graph route) và startDestination riêng:
```
e. Quản lý back stack khi chuyển tab – popUpTo, saveState, restoreState
Khi người dùng bấm vào tab khác trên BottomNavigation, cần cấu hình để
tránh back stack tích lũy vô hạn và giữ trạng thái từng tab:
```
• popUpTo(...): Xóa các destination ra khỏi back stack đến một điểm
```
nhất định.
```
• saveState = true: Lưu lại state của tab vừa rời khỏi (vị trí cuộn, dữ
```
```
liệu đã nhập).
```
• launchSingleTop = true: Không tạo thêm instance mới nếu
destination đích đã ở top của stack.
98
• restoreState = true: Khôi phục state đã lưu khi quay lại tab đó.
f. NavDestination.hierarchy – Highlight tab tự động
hierarchy là một Sequence<NavDestination> chứa destination hiện tại và tất cả
các graph cha của nó theo thứ tự từ trong ra ngoài. Ví dụ, khi đang ở màn
```
hình checkout (nằm trong cart_graph):
```
```
hierarchy = [checkout, cart_graph, NavGraph(root)]
```
Nhờ đó, có thể tự động highlight đúng tab mà không cần kiểm tra route thủ
công:
g. Deep link – navDeepLink {}
Deep Link cho phép ứng dụng bên ngoài mở trực tiếp một destination cụ thể
```
thông qua URI scheme. Trong Navigation Compose, khai báo bằng navDeepLink {
```
```
uriPattern = "..." } bên trong composable():
```
6.2. Ví dụ và giải thích
```
6.2.1 Ví dụ về Bộ đếm đơn giản (Counter)
```
99
Mục tiêu: Minh họa cách sử dụng state và recomposition trong Compose. Người
dùng có thể nhấn nút để tăng số đếm và giao diện tự động cập nhật.
```
• NavHost: Vùng chứa định nghĩa các destination (đích đến) và
```
liên kết chúng với các composable. Mỗi destination có một route
```
(chuỗi định danh).
```
```
• composable(): Hàm mở rộng dùng để thêm một destination vào
```
NavHost, kèm theo route và composable tương ứng.
• Ví dụ cơ bản:
```
val navController = rememberNavController()
```
```
NavHost(navController = navController, startDestination = "home") {
```
```
composable("home") { HomeScreen(navController) }
```
```
composable("detail") { DetailScreen() }
```
```
}
```
```
// Điều hướng: navController.navigate("detail")
```
100
@Composable
```
fun Counter() {
```
// 1. Khai báo state
```
var count by remember { mutableStateOf(0) }
```
// 2. Giao diện
```
Column(
```
```
horizontalAlignment = Alignment.CenterHorizontally,
```
```
verticalArrangement = Arrangement.Center,
```
```
modifier = Modifier.fillMaxSize()
```
```
) {
```
// 3. Hiển thị giá trị
```
Text(
```
```
text = "Bạn đã nhấn $count lần",
```
```
style = MaterialTheme.typography.headlineMedium
```
```
)
```
// 4. Nút bấm
```
Button(
```
```
onClick = { count++ },
```
```
modifier = Modifier.padding(16.dp)
```
```
) {
```
```
Text("Nhấn vào đây")
```
```
}
```
```
}
```
```
}
```
```
• mutableStateOf(0): tạo một đối tượng MutableState<Int> với giá
```
trị khởi tạo là 0. Đối tượng này có thể quan sát được – khi giá trị
thay đổi, Compose sẽ biết và lên lịch recompose cho các
composable đang đọc nó.
• remember: giúp lưu trữ đối tượng state qua các lần recompose.
```
Nếu không có remember, mỗi lần recompose, mutableStateOf(0)
```
sẽ được tạo lại, dẫn đến mất giá trị hiện tại.
• by là từ khóa delegate, cho phép đọc/ghi trực tiếp biến count thay
vì phải dùng count.value. Nhờ đó, ta có thể viết count++ thay vì
count.value++.
• Column: layout sắp xếp các phần tử con theo chiều dọc.
101
• horizontalAlignment = Alignment.CenterHorizontally: căn giữa
các phần tử con theo chiều ngang.
• verticalArrangement = Arrangement.Center: phân bố các phần tử
```
con sao cho chúng nằm giữa theo chiều dọc (tức là toàn bộ nội
```
```
dung được căn giữa trong màn hình).
```
```
• modifier = Modifier.fillMaxSize(): yêu cầu Column chiếm toàn
```
```
bộ không gian có sẵn (cả chiều rộng và chiều cao).
```
• text: sử dụng template string "Bạn đã nhấn $count lần". Biến
count được tự động theo dõi, khi count thay đổi, Text sẽ được
recompose để hiển thị giá trị mới.
• style = MaterialTheme.typography.headlineMedium: áp dụng
kiểu chữ headlineMedium từ theme Material, giúp văn bản có
kích thước lớn và đậm phù hợp làm tiêu đề.
```
• onClick = { count++ }: hàm lambda được gọi mỗi khi người dùng
```
nhấn nút. Ở đây, ta tăng giá trị count lên 1. Khi count thay đổi,
state được cập nhật, kích hoạt recompose cho toàn bộ composable
Counter.
```
• modifier = Modifier.padding(16.dp): thêm khoảng đệm 16.dp
```
xung quanh nút, tạo khoảng cách với các thành phần khác.
6.2.2. Điều hướng giữa 2 màn hình với tham số
Mục tiêu: Minh họa cách thiết lập NavController + NavHost, điều hướng giữa
các composable và truyền tham số qua route.
102
Composable
```
fun SimpleNavApp() {
```
```
val navController = rememberNavController()
```
```
NavHost(
```
```
navController = navController,
```
```
startDestination = "book_list"
```
```
) {
```
// Màn hình danh sách sách
```
composable("book_list") {
```
```
BookListScreen(
```
```
onBookClick = { bookId ->
```
```
navController.navigate("book_detail/$bookId") // Truyền tham số
```
qua route
```
}
```
```
)
```
```
}
```
// Màn hình chi tiết — nhận tham số bookId từ route
```
composable(
```
```
route = "book_detail/{bookId}",
```
```
arguments = listOf(navArgument("bookId") { type =
```
```
NavType.StringType })
```
```
) { backStackEntry ->
```
```
val bookId = backStackEntry.arguments?.getString("bookId") ?: ""
```
```
BookDetailScreen(
```
```
bookId = bookId,
```
```
onBackClick = { navController.popBackStack() } // Quay lại màn hình
```
trước
103
```
)
```
```
}
```
```
}
```
```
}
```
```
• rememberNavController(): Tạo và ghi nhớ NavController qua các lần
```
recompose.
```
• NavHost(startDestination = "book_list"): Khai báo màn hình đầu tiên
```
khi mở app.
```
• navController.navigate("book_detail/$bookId"): Điều hướng đến
```
destination mới, đẩy vào back stack.
```
• navArgument("bookId") { type = NavType.StringType }: Khai báo
```
tham số kiểu String cho route.
```
• backStackEntry.arguments?.getString("bookId"): Đọc tham số từ
```
```
route trong lambda của composable().
```
```
• navController.popBackStack(): Quay lại destination trước đó trong
```
back stack.
Hình 6.1: Luồng điều hướng từ BookListScreen sang BookDetailScreen khi
bấm vào sách
6.2.3. BottomNavigation 2 tab với Nested Graph và giữ trạng thái
```
Mục tiêu: Minh họa cách dùng navigation() tạo 2 sub-graph, highlight tab
```
bằng hierarchy, và giữ trạng thái tab khi switch bằng saveState/restoreState.
@Composable
```
fun TwoTabApp() {
```
```
val navController = rememberNavController()
```
```
Scaffold(
```
```
bottomBar = {
```
104
```
val navBackStackEntry by navController.currentBackStackEntryAsState()
```
val currentDestination = navBackStackEntry?.destination
```
NavigationBar {
```
// Tab Trang chủ
```
NavigationBarItem(
```
// hierarchy: tự động highlight tab kể cả khi đang ở màn hình con
```
(book_detail)
```
```
selected = currentDestination
```
```
?.hierarchy?.any { it.route == "home_graph" } == true,
```
```
onClick = {
```
```
navController.navigate("home_graph") {
```
```
popUpTo(navController.graph.findStartDestination().id) {
```
```
saveState = true // Lưu state tab vừa rời
```
```
}
```
```
launchSingleTop = true
```
```
restoreState = true // Khôi phục state khi quay lại
```
```
}
```
```
},
```
```
icon = { Icon(Icons.Outlined.Home, "Trang chủ") },
```
```
label = { Text("Trang chủ") }
```
```
)
```
```
// Tab Giỏ hàng (tương tự)
```
```
NavigationBarItem(
```
```
selected = currentDestination
```
105
```
?.hierarchy?.any { it.route == "cart_graph" } == true,
```
```
onClick = {
```
```
navController.navigate("cart_graph") {
```
```
popUpTo(navController.graph.findStartDestination().id) { saveState
```
```
= true }
```
```
launchSingleTop = true
```
```
restoreState = true
```
```
}
```
```
},
```
```
icon = { Icon(Icons.Outlined.ShoppingCart, "Giỏ hàng") },
```
```
label = { Text("Giỏ hàng") }
```
```
)
```
```
}
```
```
}
```
```
) { innerPadding ->
```
```
NavHost(
```
```
navController = navController,
```
```
startDestination = "home_graph",
```
```
modifier = Modifier.padding(innerPadding)
```
```
) {
```
// HOME GRAPH — sub-graph riêng của tab Trang chủ
```
navigation(startDestination = "home", route = "home_graph") {
```
```
composable("home") { HomeScreen(navController) }
```
```
composable("book_detail/{bookId}") { BookDetailScreen() }
```
106
```
}
```
// CART GRAPH — sub-graph riêng của tab Giỏ hàng
```
navigation(startDestination = "cart", route = "cart_graph") {
```
```
composable("cart") { CartScreen() }
```
```
composable("checkout") { CheckoutScreen() }
```
```
}
```
```
}
```
```
}
```
```
}
```
107
```
• navigation(startDestination = "home", route = "home_graph"):
```
Tạo sub-graph — mỗi tab có back stack riêng, tránh xung đột khi
switch tab.
```
• hierarchy?.any { it.route == "home_graph" }: Trả về true cho tất
```
```
cả màn hình trong graph đó (home và book_detail), không cần
```
kiểm tra từng route thủ công.
• saveState = true + restoreState = true: Khi quay lại tab, người
dùng tiếp tục đúng nơi đã rời — vị trí cuộn, dữ liệu nhập được
giữ nguyên.
6.3. Đồ án — Điều hướng với Jetpack Compose Navigation trong ứng
dụng bán sách
6.3.1. Tổng quan cấu trúc điều hướng
Hình 6.2: Sơ đồ kiến trúc Nested Navigation Graphs trong đồ án
108
Trong MainScreen.kt, toàn bộ điều hướng được đặt trong một NavHost duy
```
nhất. Tuy nhiên, khác với cách tổ chức phẳng (flat), đồ án sử dụng Nested Navigation
```
```
Graphs thực sự thông qua hàm navigation() — mỗi tab là một sub-graph riêng biệt
```
```
với route và startDestination độc lập. Bốn tab chính (Trang chủ, Danh mục, Giỏ
```
```
hàng, Tài khoản) là các navigation graph cấp một, không phải destination đơn lẻ.
```
6.3.1. Hiển thị BottomNavigation có điều kiện:
Thanh điều hướng dưới cùng chỉ hiển thị trên các màn hình chính và màn hình
```
category_detail (để tiện chuyển tab). Các màn hình con (chi tiết sách, thanh toán,
```
```
profile, …) sẽ ẩn bottom bar để tối ưu không gian.
```
```
val navBackStackEntry by navController.currentBackStackEntryAsState()
```
val currentRoute = navBackStackEntry?.destination?.route
```
val showBottomBar = currentRoute in listOf("home", "category", "cart",
```
```
"account") ||
```
```
currentRoute?.startsWith("category_detail/") == true
```
```
Scaffold(
```
```
bottomBar = { if (showBottomBar) AppBottomNavigation(navController) }
```
```
) { innerPadding ->
```
```
NavHost(..., modifier = Modifier.padding(innerPadding)) { ... }
```
```
}
```
109
Hình 6.3: Bottom Navigation ẩn khi vào màn hình chi tiết sách
110
Hình 6.4: Bottom Navigation hiện khi ở trang chủ
111
6.3.2. Cấu hình popUpTo và launchSingleTop cho
```
BottomNavigation:
```
Khi chuyển giữa các tab, cần tránh tạo nhiều instance trùng lặp. Cấu hình sau
đảm bảo mỗi tab chỉ có một instance, lưu và khôi phục trạng thái:
```
navController.navigate(item.graphRoute) {
```
// Xóa back stack về start destination để tránh stack quá sâu khi switch
tab
```
popUpTo(navController.graph.findStartDestination().id) {
```
```
saveState = true // Lưu state của tab vừa rời khỏi
```
```
}
```
```
launchSingleTop = true // Không tạo duplicate nếu đã ở tab đó
```
```
restoreState = true // Khôi phục state khi quay lại tab này
```
```
}
```
Giải thích từng tham số:
```
• popUpTo(navController.graph.findStartDestination().id): pop về tận
```
```
start destination của toàn bộ NavHost (home_graph) — ngăn back
```
stack tích lũy vô hạn khi người dùng chuyển tab nhiều lần.
```
• saveState = true: lưu lại toàn bộ state (vị trí cuộn, dữ liệu đã nhập) của
```
tab trước đó để khôi phục sau.
• launchSingleTop = true: nếu destination đích đã là top của back stack,
không tạo thêm instance mới.
• restoreState = true: khi quay lại tab đã từng mở, khôi phục lại state đã
lưu — người dùng tiếp tục đúng nơi họ đã rời.
6.3.3. Nested Navigation Graphs trong đồ án
Điểm cốt lõi của cấu trúc điều hướng trong đồ án là sử dụng
```
hàm navigation() để tạo các sub-graph thực sự — mỗi tab là một graph độc
```
lập, không phải destination đơn lẻ.
```
NavHost(
```
```
navController = navController,
```
112
```
startDestination = BottomNavItem.Home.graphRoute, // "home_graph"
```
...
```
) {
```
// HOME GRAPH — Trang chủ, Tìm kiếm, Chi tiết sách
```
navigation(
```
```
startDestination = BottomNavItem.Home.route, // "home"
```
```
route = BottomNavItem.Home.graphRoute // "home_graph"
```
```
) {
```
```
composable("home") { HomeScreen(...) }
```
```
composable("search_screen") { SearchScreen(...) }
```
```
composable("search_results/{query}") { ... }
```
```
composable("book_detail/{bookId}") { ... }
```
```
}
```
// CATEGORY GRAPH — Danh mục, Chi tiết danh mục
```
navigation(
```
```
startDestination = BottomNavItem.Category.route, // "category"
```
```
route = BottomNavItem.Category.graphRoute //
```
"category_graph"
```
) {
```
```
composable("category") { CategoryScreen(...) }
```
```
composable(
```
```
route = "category_detail/{index}",
```
```
arguments = listOf(navArgument("index") { type =
```
```
NavType.IntType })
```
```
) { CategoryDetailScreen(...) }
```
```
}
```
// CART GRAPH — Giỏ hàng, Thanh toán
```
navigation(
```
```
startDestination = BottomNavItem.Cart.route, // "cart"
```
```
route = BottomNavItem.Cart.graphRoute // "cart_graph"
```
```
) {
```
```
composable("cart") { CartScreen(...) }
```
```
composable("checkout") { CheckoutScreen(...) }
```
113
```
}
```
// ACCOUNT GRAPH — Tài khoản và các màn hình con
```
navigation(
```
```
startDestination = BottomNavItem.Account.route, // "account"
```
```
route = BottomNavItem.Account.graphRoute //
```
"account_graph"
```
) {
```
```
composable("account") { AccountScreen(...) }
```
```
composable("profile") { ProfileScreen(...) }
```
```
composable("settings") { SettingsScreen(...) }
```
```
composable("change_password") { ChangePasswordScreen(...) }
```
```
composable("order_history") { OrderHistoryScreen(...) }
```
```
composable(
```
```
route = "order_history?success={success}",
```
```
deepLinks = listOf(navDeepLink {
```
```
uriPattern =
```
```
"bookstore://payment/result?success={success}&orderId={orderId}"
```
```
})
```
```
) { OrderHistoryScreen(...) }
```
```
composable("contact") { ContactScreen(...) }
```
```
}
```
```
// SHARED SCREENS — Ngoài mọi graph (auth flow)
```
```
composable("login/{returnRoute}") { LoginScreen(...) }
```
```
composable("register") { RegisterScreen(...) }
```
```
}
```
Lý do dùng Nested Graphs thay vì flat NavHost
114
Vấn đề với flat NavHost Giải pháp của Nested Graphs
Tab switching xóa toàn bộ back
stack
Mỗi graph có back stack riêng,
tránh xung đột
Không tự động highlight tab khi ở
màn hình con
hierarchy API tự động deetect
graph hiện tại
Login/ register cần nằm riêng
không thuộc tab nào
```
Khai báo ngoài tất cả navigation()
```
block
book_detail cần accessible từ
nhiều tab
Đặt trong home_graph, navigate
từ category dùng navigateAsTab
Trường hợp đặc biệt - book_detail chỉ nằm trong home_graph: Khi người
dùng đang ở tab Danh mục và bấm vào một cuốn
```
sách, CategoryDetailScreen gọi navController.navigate("book_detail/$bookId") — ro
```
ute này nằm trong home_graph, nên Compose điều hướng vào home_graph và tab
Trang chủ sẽ sáng lên. Đây là hành vi chấp nhận được vì người dùng đang xem chi
tiết một cuốn sách — sau đó nhấn Back sẽ trở về đúng CategoryDetailScreen.
6.3.4. Cơ chế highlight tab với NavDestination.hierarchy
Một trong những lợi ích lớn nhất của Nested Navigation Graphs là khả năng tự
động highlight đúng tab khi người dùng đang ở bất kỳ màn hình nào trong graph đó
— kể cả màn hình con sâu nhất.
115
// Trong AppBottomNavigation.kt
```
val navBackStackEntry by navController.currentBackStackEntryAsState()
```
val currentDestination = navBackStackEntry?.destination
```
items.forEach { item ->
```
```
NavigationBarItem(
```
```
selected = currentDestination
```
?.hierarchy // Duyệt cây cha của destination hiện tại
```
?.any { it.route == item.graphRoute } // Kiểm tra xem có nằm trong
```
graph này không
== true,
```
onClick = { ... }
```
```
)
```
```
}
```
Giải thích NavDestination.hierarchy:
hierarchy là một Sequence<NavDestination> chứa destination hiện tại và tất
cả các graph cha của nó theo thứ tự từ trong ra ngoài. Ví dụ, khi người dùng đang ở
màn hình category_detail/2:
```
hierarchy = [category_detail/2, category_graph, NavGraph(root)]
```
```
So sánh với cách kiểm tra thủ công (không dùng Nested Graphs):
```
116
/ /Cách cũ — dễ bỏ sót, phải cập nhật thủ công mỗi khi thêm màn hình
```
val selectedTab = when {
```
```
currentRoute == "category" -> BottomNavItem.Category
```
```
currentRoute?.startsWith("category_detail/") == true ->
```
BottomNavItem.Category
```
currentRoute == "profile" -> BottomNavItem.Account
```
```
currentRoute == "settings" -> BottomNavItem.Account
```
// ... phải liệt kê tất cả
else -> BottomNavItem.Home
```
}
```
// Cách mới với hierarchy — tự động, không cần cập nhật khi thêm màn hình mới
```
selected = currentDestination?.hierarchy?.any { it.route == item.graphRoute } ==
```
true
```
Hình 6.5: Tab "Danh mục" vẫn sáng (highlighted) khi người dùng đang ở
```
màn hình CategoryDetail
6.3.5. BottomNavItem Sealed Class – Phân biệt route và
graphRoute
```
Để quản lý rõ ràng sự phân biệt giữa destination route (route của màn hình
```
```
chính) và graph route (route của cả graph), đồ án định nghĩa BottomNavItem là một
```
Sealed Class:
117
```
Sealed class BottomNavItem(
```
val route: String, // Route của màn hình startDestination
```
val graphRoute: String, // Route của navigation graph (dùng để switch tab)
```
val title: String,
val icon: ImageVector
```
) {
```
```
object Home : BottomNavItem("home", "home_graph", "Trang chủ",
```
```
Icons.Outlined.Home)
```
```
object Category : BottomNavItem("category", "category_graph", "Danh
```
```
mục", Icons.Outlined.GridView)
```
```
object Cart : BottomNavItem("cart", "cart_graph", "Giỏ hàng",
```
```
Icons.Outlined.ShoppingCart)
```
```
object Account : BottomNavItem("account", "account_graph", "Tài
```
```
khoản", Icons.Outlined.Person)
```
```
}
```
Tại sao cần tách route và graphRoute?
Với Nested Navigation Graphs, có hai loại route khác nhau cần phân biệt rõ:
118
route graphRoute
Là gì
Route của màn hình home,
category, …
Route của graph home_graph,
category_graph, …
Dùng để
Khai báo startDestination của
graph
```
Navigate khi switch tab; kiểm tra
```
hierarchy
Ví dụ
navigate
```
navController.navigate(“ho
```
```
me”) thẳng vào màn hinh
```
```
navController.navigate(“home_gra
```
```
ph”) – vào graph, tự đến
```
startDestination
Khi nào
dùng
route
```
Khai báo compose(“home”)
```
```
{…} trong NavHost
```
Khi nào
dùng
graphRou
te
```
AppBottomNavigation onClick;
```
hierarchy check
Ứng dụng trong navigateAsTab bên trong BookDetailScreen:
```
Khi người dùng đang ở BookDetailScreen (nằm trong home_graph) và
```
muốn chuyển sang tab khác bằng các nút điều hướng trên app bar, hàm nội
bộ navigateAsTab được dùng để switch tab đúng chuẩn
119
```
// Định nghĩa bên trong composable "book_detail/{bookId}"
```
```
fun navigateAsTab(graphRoute: String) {
```
```
navController.navigate(graphRoute) {
```
```
popUpTo(navController.graph.findStartDestination().id) { saveState =
```
```
true }
```
```
launchSingleTop = true
```
```
restoreState = true
```
```
}
```
```
}
```
```
BookDetailScreen(
```
```
onHomeClick = { navigateAsTab(BottomNavItem.Home.graphRoute)
```
```
},
```
```
onCartClick = { navigateAsTab(BottomNavItem.Cart.graphRoute) },
```
```
onCategoryClick = {
```
```
navigateAsTab(BottomNavItem.Category.graphRoute) },
```
```
onAccountClick = {
```
```
navigateAsTab(BottomNavItem.Account.graphRoute) },
```
...
```
)
```
Cách tiếp cận này đảm bảo hành vi chuyển tab từ BookDetailScreen hoàn toàn
nhất quán với hành vi chuyển tab từ bottom navigation bar.
6.3.6. Deep Link tích hợp thanh toán MoMo
120
Một use case nâng cao của Navigation trong đồ án là xử lý kết quả thanh toán
```
MoMo thông qua deep link. Sau khi người dùng hoàn tất (hoặc hủy) thanh toán trên
```
app MoMo, ứng dụng được gọi lại qua URI scheme:
```
composable(
```
```
route = "order_history?success={success}",
```
```
arguments = listOf(
```
```
navArgument("success") { type = NavType.BoolType; defaultValue =
```
```
false }
```
```
),
```
```
deepLinks = listOf(
```
```
navDeepLink {
```
```
uriPattern =
```
```
"bookstore://payment/result?success={success}&orderId={orderId}"
```
```
}
```
```
)
```
```
) { backStackEntry ->
```
```
val success = backStackEntry.arguments?.getBoolean("success") ?: false
```
```
// success=true → mở tab "Đang xử lý" (index 2)
```
```
// success=false → mở tab "Chờ xác nhận" (index 1)
```
```
OrderHistoryScreen(navController = navController, initialTab = if (success)
```
```
2 else 1)
```
```
}
```
Luồng hoạt động:
1. Người dùng bấm "Thanh toán MoMo" → ứng dụng mở app MoMo
   qua payUrl/deeplink.
2. Người dùng hoàn tất hoặc hủy thanh toán trên MoMo.
3. MoMo gọi lại bookstore://payment/result?success=true&orderId=123.
   121
4. Android router map URI này đến
```
destination order_history?success={success} trong account_graph.
```
5. OrderHistoryScreen nhận initialTab = 2 (Đang xử lý) nếu thành công,
```
hoặc initialTab = 1 (Chờ xác nhận) nếu hủy.
```
Hình 6.6: Luồng deep link từ MoMo trở về màn hình đơn hàng
6.3.7. Kết quả đạt được
Việc áp dụng Nested Navigation Graphs kết hợp các tính năng của Jetpack
Compose Navigation mang lại những kết quả cụ thể trong đồ án:
122
Kỹ thuật
Vần đề giải
quyết
Kết quả thực tế
```
Nested Graphs (navigation())
```
Quản lý back
stack độc lập cho
từng tab
Mỗi tab có luồng điều
hướng riêng, không xung
đột
NavDestination.hierarchy
Highlight đúng
tab khi ở màn
hình con
Tab tự sáng chính xác,
không cần check route thủ
công
popUpTo + saveState / restoreState
Mất state khi
switch tab
Người dùng quay lại tab
đúng vị trí đã rời
BottomNavItem Sealed Class
Nhầm lẫn giữa
destination route
và graph route
Phân biệt
rõ route / graphRoute trong
toàn bộ codebase
Deep Link
Không có cách
nhận kết quả từ
app ngoài
MoMo callback được map
trực tiếp đến đúng màn
hình và tab
Shared screens ngoài graph
Login/Register
không thuộc tab
nào
Khai báo ngoài tất
```
cả navigation() block,
```
accessible từ bất kỳ đâu
CHƯƠNG 7: KIẾN TRÚC MVVM VÀ RETROFIT
7.1. Lý thuyết
7.1.1. Giới thiệu tổng quan về mô hình MVVM
7.1.1.1. Mô hình MVVM là gì?
123
Mô hình MVVM là một mô hình định nghĩa cấu trúc ứng dụng, được phát
triển dựa trên kiến trúc của MVP. Mô hình này cho phép người dùng tách biệt
```
giữa Model (dữ liệu), ViewModel (mã thực thi) và View (giao diện người dùng).
```
Khác với các mô hình truyền thống, mô hình MVVM không cho phép
người dùng xử lý sự kiện Click và các hoạt động khác bằng cách viết mã trực tiếp
trên met Button. Nguyên nhân là vì trong MVVM, các control như ListView,
Button hay SearchBar,… không thể kết nối với dữ liệu một cách trực tiếp. Thay
```
vào đó, bạn sẽ phải sử dụng thuộc tính Command (thuộc kiểu ICommand) để kết
```
nối các hành động với ViewModel.
MVVM có thể được _hiểu như thế nào?
Hình 7.1: Mô hình MVVM
• View
o View được hiểu là thành phần giao diện mô tả dữ liệu của một ứng
dụng, đồng thời đây cũng là thành phần duy nhất cho phép người
dùng tương tác trong chương trình.
o View trong MVVM được đánh giá là tích cực hơn so với các mô
hình khác nhờ vào khả năng thực hiện hành vi và cung cấp phản
hồi cho người dùng với một số tính năng nổi bật như Command,
Binding,
124
• Model: Giống với mô hình MVC, Model là đối tượng cho phép bạn
truy xuất dữ liệu và thao tác trên dữ liệu thật sự.
• ViewModel : ViewModel đóng vai trò trung gian và có nhiệm vụ
đồng bộ hóa dữ liệu khi truyền tải từ Model lên View, đồng thời xử
lý các hoạt động từ View để cập nhật Model. View sẽ được ánh xạ
```
(binding) tới ViewModel, nhưng ViewModel lại không biết thông
```
tin của View mà thông tin này sẽ được ẩn giấu bởi Data-binding
cùng cơ chế hoạt động của mô hình Observer. Trong đó, một
```
ViewModel có khả năng ánh xạ (binding) từ nhiều View.
```
Lưu ý: Điểm đặc biệt của mô hình MVVM là sự tách biệt giữa các tầng và
tầng bên dưới sẽ không bị phụ thuộc vào tầng bên trên. Cụ thể, các tầng dưới
sẽ không được biết thông tin của các tầng bên trên, chẳng hạn như
ViewModel không biết gì về View cụ thể mà nó đang liên kết và một
ViewModel có thể sử dụng cho nhiều View khác nhau. Để liên lạc với View,
```
ViewModel cần sử dụng Observer design pattern (hay binding data) với một
```
hoặc hai chiều tùy theo nhu cầu riêng biệt của từng ứng dụng.
Cấu trúc thư mục trong MVVM
Mô hình MVVM thường bao gồm 3 thư mục chính, mỗi thư mục sẽ chứa
những file code liên quan khác nhau, cụ thể là:
125
Hình 7.2: Cấu trúc thư mục mô hình MVVM
• Views
o Thư mục View chứa các file giao diện và mỗi file giao diện sẽ đi
kèm với một code-behind. Tuy nhiên, chúng ta thường sẽ không
sử dụng file code-behind mà chuyển xuống class ViewModel.
o Bạn cũng có thể sử dụng file code-behind, nhưng điều này thường
không được khuyến khích vì nó có thể phá vỡ đi quy ước của mô
hình MVVM. Trong file XAML, bạn có thể khai báo thuộc tính
Datacontext hoặc sử dụng các thiết lập khác để liên kết
ViewModel với giao diện người dùng. Tuy nhiên, cần lưu ý là
bạn nên hạn chế code tại đây.
o Trong mô hình MVVM, View với nhiệm vụ hiển thị giao diện
người dùng và tạo nên sự chia tách gọn gàng giữa UI với
Presentation Logic và Data.
126
• Models: Thư mục Models bao gồm các class chứa data và các liên
kết validation, logic nghiệp vụ với mục đích đảm bảo tính toàn vẹn
của data. Từ đó, bạn có thể dễ dàng tách chúng ta thư mục
Repositories khác và sử dụng như một phần của mô hình MVVM.
• ViewModels:
o Trong mô hình MVVM thường có thư mục riêng được tạo ra để
chứa các lớp ViewModel tương ứng với mỗi file giao diện riêng
biệt – đó là thư mục ViewModels. Thư mục này có nhiệm vụ quản
lý và tổ chức logic của ViewModel trong các ứng dụng.
o ViewModels có thể sử dụng các Model để định nghĩa dữ liệu và
logic liên quan. ViewModel được ví như một trung gian đứng giữa
View và Model, có nhiệm vụ gửi và nhận dữ liệu, từ đó cung cấp
các khái niệm về DataContext, Binding, Behaviors SDK và cho
phép người tách code-behind từ View đưa xuống ViewModel.
o Bên cạnh đó, một lớp ViewModels còn chứa các logic hiển thị và
state của ứng dụng. Như vậy, ViewModels sẽ chịu trách nhiệm cho
các chức năng của ứng dụng và nó định nghĩa cho các thuộc tính
```
(properties), commands và events để tương tác với các thành phần
```
giao diện trong View, từ đó chuyển đổi controls trong view cần
data-bind.
• Data Binding
o Data Binding là một kỹ thuật quan trọng, được dùng để liên kết giữa
giao diện UI và dữ liệu thông qua Business logic. Cụ thể, UI sẽ tự
động cập nhật để hiển thị các thay đổi dữ liệu nhờ vào quá trình
Data Binding. Không chỉ thế, trong WPF, Data Binding còn có khả
127
năng hỗ trợ các chiều khác nhau – tức là cập nhật các thay đổi từ
UI vào dữ liệu.
o Kỹ thuật Data Binding trong MVVM được ví như một bước tiến
mới mà bất kỳ lập trình viên nào cũng mong muốn khám phá. Thậm
chí, Data Binding còn trở thành thành phần cốt lõi tạo nên cơ chế
hoạt động của WPF. Qua đó, bạn có thể binding dữ liệu của bất kỳ
đối tượng nào, từ các control đơn giản cho đến các user control
phức tạp nhất. Đặc biệt, kỹ thuật này còn hỗ trợ người dùng thực
hiện các công việc trên một cách dễ dàng mà không cần phải sử
dụng đến bất cứ dòng code-behind nào.
• Data Template
o Data Template là kỹ thuật được sử dụng cho các Control để tạo
khuôn mẫu giao diện cho ứng dụng. Trong WPF, template có vai
trò xác định cách thức hoặc cấu trúc của dữ liệu hay control khi
hiển thị ra màn hình.
o Data Template có khả năng gắn các dữ liệu dạng non-visuel vào
một cấu trúc với một hoặc nhiều thành phần được hiển thị. Qua
đó, dữ liệu sẽ được hiển thị theo đúng ý muốn của bạn. Ngoài ra,
tính năng này cũng không sử dụng đến code-behind của ứng dụng
giống như Data Binding.
• Command
o Nếu như Data Bingding và Data Template đóng vai trò quan trọng
trong việc hỗ trợ người dùng nhận biết các thành phần của dữ liệu
và cập nhật dữ liệu đó, thì Command sẽ đảm nhận nhiệm vụ nhận
dữ liệu tương tác người dùng và xử lý yêu cầu đó.
128
o Cụ thể, các command sẽ xem dữ liệu và cung cấp cho người dùng
bằng chức năng binding. Thông qua đó, command binding trong mô
hình MVVM cho phép bạn xác định các phương pháp xử lý để kích
hoạt thông qua các thao tác như phím tắt, chuột,…
129
7.1.2. Retrofit
Retrofit là gì?
Được phát triển bởi Square
Retrofit là một HTTP client type-safe cho Android và Java. Retrofit giúp dễ
dàng kết nối đến một dịch vụ REST trên web bằng cách chyển đổi API thành Java
Interface.
Retrofit rất mạnh mẽ giúp bạn dễ dàng xử lý dữ liệu JSON hoặc XML sau
```
đó phân tích cú pháp thành Plain Old Java Objects (POJOs). Tất cả các yêu cầu
```
GET, POST, PUT, PATCH, và DELETE đều có thể được thực thi.
Giống như hầu hết các phần mềm mã nguồn mở khác, Retrofit được xây
dựng dựa trên một số thư viện mạnh mẽ và công cụ khác. Đằng sau nó, Retrofit
```
làm cho việc sử dụng OkHttp (từ cùng một nhà phát triển) để xử lý các yêu cầu
```
trên mạng. Ngoài ra, Retrofit không tích hợp bất kỳ một bộ chuyển đổi JSON nào
để phân tích từ JSON thành các đối tượng Java. Thay vào đó nó đi kèm với các
thư viện chuyển đổi JSON sau đây để xử lý điều đó
Cách dùng Retrofit
Để làm việc với Retrofit bạn cần triển khai cơ bản 3 lớp:
• Model class để ánh xạ với JSON data.
• Một interface dùng để định nghĩa các hàm và phương thức HTTP
• Retrofit.Builder Lớp để định nghĩa URL Endpoint cho các hoạt
động liên quan tới HTTP
Request method
Mỗi method phải có một HTTP annotation. Có 5 annotations GET, POST,
PUT, DELETE, and HEAD Bên trong mỗi annotation là một đoạn của URL.
```
@GET("users/list")
```
Bạn cũng có thể chỉ định tham số truy vấn trong URL
130
```
@GET("users/list?sort=desc")
```
URL MANIPULATION
```
interface GitHubService {
```
```
@GET("users/{user}/repos")
```
```
fun listRepos(@Path("user") user: String): Call<List<Repo>>
```
```
}
```
```
Khối {user] trong đoạn trên được thay thế bới tham số user trong hàm
```
listRepos. Bằng việc sử dụng anotation @Path và truyền vào cùng chuỗi string
```
trong khối {}
```
Tham số query cũng có thể add thêm được như sau:
```
@GET("group/{id}/users")
```
```
fun groupList(
```
```
@Path("id") groupId: Int,
```
```
@Query("sort") sort: String
```
```
): Call<List<User>>
```
Nếu mà tham số query phức tạp có thể sử dụng Map:
```
@GET("group/{id}/users")
```
```
fun groupList(
```
```
@Path("id") groupId: Int,
```
@QueryMap options: Map<String, String>
```
): Call<List<User>>
```
Requets Body
Một đối tượng có thể được chỉ định cho mục đích sử dụng làm phần body
cho truy vấn với @Body annotation
131
```
@POST("users/new")
```
```
fun createUser(@Body user: User): Call<User>
```
Đối tượng cũng sẽ được chuyển đổi bằng cách sử dụng trình chuyển đổi
được chỉ định trong Retrofit instance. Nếu không có trình chuyển đổi nào được
thêm vào, chỉ có thể sử dụng RequestBody.
Form Encoded and multipart
Các phương thức cũng có thể được khai báo để gửi dữ liệu được mã hóa
theo mẫu và nhiều phần. Dữ liệu được mã hóa biểu mẫu được gửi khi có
annotation @FormUrlEncoding . Mỗi cặp key-value được chú thích bằng @Field
chứa tên và đối tượng cung cấp giá trị.
@FormUrlEncoded
```
@POST("user/edit")
```
```
fun updateUser(
```
```
@Field("first_name") first: String,
```
```
@Field("last_name") last: String
```
```
): Call<User>
```
Yêu cầu nhiều phần được sử dụng với @Multipart .Mỗi phần được khai báo
bằng cách sử dụng chú thích @Part.
@Multipart
```
@PUT("user/photo")
```
```
fun updateUser(
```
```
@Part("photo") photo: RequestBody,
```
```
@Part("description") description: RequestBody
```
```
): Call<User>
```
Header manipulation
Bạn có thể Header tĩnh cho phương thức sử dụng @Headers annotation.
132
```
@Headers("Cache-Control: max-age=640000")
```
```
@GET("widget/list")
```
```
fun widgetList(): Call<List<Widget>>
```
```
@Headers(
```
"Accept: application/vnd.github.v3.full+json",
"User-Agent: Retrofit-Sample-App"
```
)
```
```
@GET("users/{username}")
```
```
fun getUser(@Path("username") username: String): Call<User>
```
Lưu ý: các headers không ghi đè lên nhau. Tất cả các tiêu đề có cùng
tên sẽ được bao gồm trong yêu cầu. Một tiêu đề yêu cầu có thể được cập
nhật động bằng cách sử dụng chú thích @Header. Một tham số tương
ứng phải được cung cấp cho @Header. Nếu giá trị là null, header sẽ bị
bỏ qua. Nếu không, toString sẽ được gọi trên giá trị và kết quả được sử
dụng.
```
@GET("user")
```
```
fun getUser(@Header("Authorization") authorization: String):
```
Call<User>
Tương tự như các tham số truy vấn, đối với hearder phức tạp, có thể sự
dụng Map
```
@GET("user")
```
```
fun getUser(@HeaderMap headers: Map<String, String>): Call<User>
```
Header cần thêm vào mỗi request tuy nhiên có thể sử dụng OkHttp
Interceptor để thay thế.
133
Converters
```
Theo mặc định, Retrofit chỉ có thể giải tuần tự hóa (deserialize) các
```
HTTPbodies thành ResponseBody của OkHttp và nó chỉ có thể chấp nhận
loại RequestBody của nó cho @Body. Bộ chuyển đổi có thể được thêm vào để hỗ
trợ các loại khác. Dưới đây là 6 thư viện phổ biến sử dụng.
o Gson: com.squareup.retrofit:converter-gson
o Jackson: com.squareup.retrofit:converter-jackson
o Moshi: com.squareup.retrofit:converter-moshi
o Protobuf: com.squareup.retrofit2:converter-protobuf
o Wire: com.squareup.retrofit2:converter-wire Và đối với XML, Retrofit
hỗ trợ
o Simple Framework: com.squareup.retrofit2:converter-
simpleframework
Caching là gì?
Caching là cách lưu trữ tạm thời dữ liệu được tìm nạp từ mạng trên bộ lưu
trữ của thiết bị để chúng ta có thể truy cập vào lần sau khi thiết bị ngoại tuyến
hoặc nếu chúng ta muốn truy cập lại một dữ liệu.
Lợi ích của việc Caching
o Giảm tiêu thụ băng thông.
o Tiết kiệm cho bạn thời gian bạn dành thời gian chờ đợi máy chủ cung
cấp cho bạn phản hồi mạng.
o Tiết kiệm cho máy chủ gánh nặng của lưu lượng bổ sung.
o Nếu bạn cần truy cập lại cùng một tài nguyên mạng sau khi đã truy cập
gần đây, thiết bị của bạn đã giành được Yêu cầu phải gửi yêu cầu đến
```
máy chủ; Thay vào đó, nó sẽ nhận được phản hồi lưu trữ. Vì vậy, chuyển
```
sang phần thực hành nào
Tạo instance Retrofit
Khi sử dụng Retrofit, cùng vs GSON, thì Retrofit instance sẽ có dạng thế
này:
134
```
private val sRetrofit: Retrofit by lazy {
```
```
Retrofit.Builder()
```
```
.baseUrl(BASE_URL)
```
```
.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
```
```
.addConverterFactory(GsonConverterFactory.create())
```
```
.build()
```
```
}
```
Với instance ở trên có nghĩa là ta đã dùng OkHttpClient mặc định để thực
thi requests. Điều đó không được "thân thiện" với bộ nhớ cho lắm . Chúng ta sẽ
tạo ra instance của OkHttpClient để cache dữ liệu & xử lí dữ việc lấy dữ liệu một
cách thuận tiện khi:
o Thiết bị đang offline.
o Thiết bị cần truy cập cùng một dữ liệu từ internet trong một khoảng thời
gian ngắn.
Tạo phương thức kiểm tra kết nối internet
135
```
fun isNetworkAvailable(context: Context): Boolean {
```
val connectivityManager =
```
context.getSystemService(Context.CONNECTIVITY_SERVIC
```
```
E) as ConnectivityManager
```
val network = connectivityManager.activeNetwork = return
false
val capabilities =
```
connectivityManager.getNetworkCapabilities(network) ?:
```
return false
return
```
capabilities.hasCapability(NetworkCapabilities.NET_CAPABI
```
```
LITY_INTERNET)
```
```
}
```
Định nghĩa một số tham số có sử dụng
Dưới đây là một số tham số có sử dụng trong quá trình tạo OkHttpClient. Ta
chủ yếu quan tâm đến CACHE_SIZE, TIME_CACHE_ONLINE,
```
TIME_CACHE_OFFLINE:
```
o CACHE_SIZE: chỉ ra lượng cache sẽ lưu là 10MB. Chú ý rằng
CACHE_SIZE phải là kiểu long.
o TIME_CACHE_ONLINE: nếu có internet sẽ lấy cache lưu 1 phút trước,
nếu quá 1 phút sẽ không lấy, 'max-age' là thuộc tính phụ trách việc này.
o TIME_CACHE_OFFLINE: nếu không có internet sẽ lấy cache lưu 1
ngày trước đây, nếu quá thì không lấy, "max-stale" là thuộc tính phụ
trách việc này, 'only-if-cached' là để không request mà chỉ lấy cache.
136
```
companion object {
```
```
private const val CACHE_SIZE = (10 * 1024 *
```
```
1024).toLong() // 10 MB
```
private const val READ_TIMEOUT = 5000
private const val WRITE_TIMEOUT = 5000
private const val CONNECT_TIMEOUT = 5000
private var CACHE_CONTROL = "Cache-Control"
private const val TIME_CACHE_ONLINE = "public, max-
```
age = 60" // 1 minute
```
private const val TIME_CACHE_OFFLINE = "public,
only-if-cached, max-stale = 86400" // 1 day
```
}
```
Tạo OkHttpClient
Tạo instance của OkHttpClient với các thông số đã khai báo bên trên
137
```
private fun initClient(context: Context): OkHttpClient {
```
```
return OkHttpClient.Builder().apply {
```
```
readTimeout(READ_TIMEOUT.toLong(),
```
```
TimeUnit.MILLISECONDS)
```
```
writeTimeout(WRITE_TIMEOUT.toLong(),
```
```
TimeUnit.MILLISECONDS)
```
```
connectTimeout(CONNECT_TIMEOUT.toLong(),
```
```
TimeUnit.MILLISECONDS)
```
```
retryOnConnectionFailure(true)
```
```
cache(Cache(context.cacheDir, CACHE_SIZE))
```
```
addInterceptor { chain ->
```
```
var request = chain.request()
```
// Xử lý Header Cache dựa trên trạng thái mạng
```
val cacheHeaderValue = if (isNetworkAvailable(context)) {
```
TIME_CACHE_ONLINE
```
} else {
```
TIME_CACHE_OFFLINE
```
}
```
// Thêm API Key vào URL Query Parameters
```
val httpUrl = request.url.newBuilder()
```
```
.addQueryParameter(QUERRY_PARAMETER_API_KEY,
```
```
API_KEY)
```
```
.build()
```
138
```
request = request.newBuilder()
```
```
.header(CACHE_CONTROL, cacheHeaderValue)
```
```
.url(httpUrl)
```
```
.build()
```
```
chain.proceed(request)
```
```
}
```
```
}.build()
```
```
}
```
Thêm instance OkHttpClient vừa tạo vào Retrofit
139
```
companion object {
```
@Volatile
private var sRetrofit: Retrofit? = null
```
fun getInstance(context: Context): Retrofit {
```
```
return sRetrofit ?: synchronized(this) {
```
```
sRetrofit ?: Retrofit.Builder()
```
```
.baseUrl(BASE_URL)
```
// Gọi hàm initClient đã chuyển đổi ở bước trước
```
.client(initClient(context))
```
```
.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
```
```
.addConverterFactory(GsonConverterFactory.create())
```
```
.build()
```
```
.also { sRetrofit = it }
```
```
}
```
```
}
```
```
}
```
7.2. Ví dụ và giải thích
Tầng Model: Định nghĩa cấu trúc dữ liệu
Đoạn code này định nghĩa "khuôn mẫu" cho dữ liệu mà ứng dụng sẽ nhận
về.
140
```
data class Post(
```
val id: Int,
val title: String,
val body: String
```
)
```
Tầng Network: Interface định nghĩa API
Đây là nơi bạn ra lệnh cho Retrofit biết cần phải làm gì với Server.
```
interface PostApiService {
```
```
@GET("posts")
```
```
suspend fun getPosts(): List<Post>
```
```
}
```
Giải thích chi tiết:
```
• @GET("posts"): Đây là một Annotation. Nó nói với Retrofit
```
rằng: "Hãy gửi một yêu cầu HTTP loại GET tới đường dẫn
/posts".
• suspend: Từ khóa cực kỳ quan trọng trong Kotlin Coroutines. Nó
đánh dấu hàm này là "hàm tạm dừng", nghĩa là nó có thể chạy các
```
tác vụ mạng tốn thời gian mà không làm đứng (treo) giao diện
```
người dùng.
• List<Post>: Kiểu dữ liệu trả về. Retrofit sẽ tự động hiểu rằng nó
cần trả về một danh sách các đối tượng Post mà chúng ta đã định
nghĩa ở trên.
Tầng Network: Khởi tạo Retrofit Instance
Đoạn code này thiết lập cấu hình kết nối mạng dùng chung cho toàn app.
141
```
object RetrofitInstance {
```
private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
```
val api: PostApiService by lazy {
```
```
Retrofit.Builder()
```
```
.baseUrl(BASE_URL)
```
```
.addConverterFactory(GsonConverterFactory.create())
```
```
.build()
```
```
.create(PostApiService::class.java)
```
```
}
```
```
}
```
Giải thích chi tiết:
• object: Tạo ra một Singleton, nghĩa là trong suốt quá trình app
chạy, chỉ có duy nhất một thực thể RetrofitInstance được tạo ra
để tiết kiệm tài nguyên.
• by lazy: Cơ chế "khởi tạo chậm". Biến api sẽ chỉ được tạo ra khi
lần đầu tiên có ai đó gọi đến nó, giúp app khởi động nhanh hơn.
• baseUrl: Địa chỉ gốc của Server. Các Endpoint sau này sẽ được
nối đuôi vào đây.
• GsonConverterFactory: Đây là bộ "thông dịch viên". Nó tự động
```
biến đổi chuỗi JSON (văn bản) từ Server thành đối tượng Kotlin
```
```
(Object) một cách tự động.
```
Tầng ViewModel: Xử lý Logic và Quản lý Trạng thái
Đây là bộ não điều khiển sự tương tác giữa Dữ liệu và Giao diện.
142
```
class PostViewModel : ViewModel() {
```
```
private val _posts = MutableStateFlow<List<Post>>(emptyList())
```
val posts: StateFlow<List<Post>> = _posts
```
private val _isLoading = MutableStateFlow(false)
```
val isLoading: StateFlow<Boolean> = _isLoading
```
fun fetchPosts() {
```
```
viewModelScope.launch {
```
_isLoading.value = true
```
try {
```
```
val response = RetrofitInstance.api.getPosts()
```
_posts.value = response
```
} catch (e: Exception) {
```
// Handle error
```
} finally {
```
_isLoading.value = false
```
}
```
```
}
```
```
}
```
```
}
```
Giải thích chi tiết:
• MutableStateFlow vs StateFlow: Đây là kỹ thuật Encapsulation
```
(Đóng gói). Ta dùng Mutable (có thể sửa) bên trong ViewModel
```
để cập nhật dữ liệu, nhưng chỉ cho phép View bên ngoài đọc dữ
```
liệu thông qua StateFlow (chỉ đọc) để đảm bảo an toàn, tránh việc
```
UI vô tình sửa đổi dữ liệu gốc.
143
```
• viewModelScope.launch: Tạo ra một môi trường (scope) để chạy
```
Coroutine. Nếu người dùng thoát màn hình này, mọi tác vụ mạng
đang chạy dở sẽ tự động bị hủy để tránh lãng phí pin và tài nguyên
```
(Memory Leak).
```
• try - catch - finally: Cấu trúc xử lý lỗi mẫu mực. try để gọi mạng,
catch để bắt lỗi nếu mất kết nối, và finally để tắt vòng xoay
Loading dù thành công hay thất bại.
Tầng View: Hiển thị với Jetpack Compose
Đoạn code này dùng để vẽ giao diện dựa trên dữ liệu nhận được.
@Composable
```
fun PostScreen(viewModel: PostViewModel = viewModel()) {
```
```
val posts by viewModel.posts.collectAsState()
```
```
val isLoading by viewModel.isLoading.collectAsState()
```
```
if (isLoading) {
```
```
CircularProgressIndicator()
```
```
} else {
```
```
LazyColumn {
```
```
items(posts) { post ->
```
```
Text(text = post.title)
```
```
}
```
```
}
```
```
}
```
```
}
```
Giải thích chi tiết:
144
```
• collectAsState(): Chuyển đổi dữ liệu từ luồng Flow của
```
ViewModel thành một State mà Compose có thể hiểu được. Khi
dữ liệu trong Flow thay đổi, hàm @Composable này sẽ tự động
```
chạy lại (Recomposition) để cập nhật màn hình.
```
```
• if (isLoading): Logic điều kiện trực tiếp trong UI. Nếu đang tải
```
```
thì hiện vòng xoay (CircularProgressIndicator), nếu tải xong thì
```
hiện danh sách.
• LazyColumn: Một thành phần cực kỳ tối ưu trong Compose
```
(giống RecyclerView), nó chỉ vẽ những phần tử nào đang hiện
```
trên màn hình, giúp app chạy mượt mà dù danh sách có hàng ngàn
bài viết.
Tóm tắt luồng hoạt động:
```
• View gọi fetchPosts() của ViewModel.
```
• ViewModel bật isLoading = true và gọi Retrofit. Retrofit dùng
HTTP GET lấy JSON từ Server về.
• Gson chuyển JSON thành danh sách Post.
• ViewModel nhận danh sách, tắt isLoading và đẩy vào posts
```
(Flow).
```
• View thấy dữ liệu mới, tự động vẽ lại danh sách trên màn hình.
Kết quả:
145
Hình 7.3: Hình ảnh loading Hình 7.4: Hình ảnh thành
công
```
Hình ảnh 1 (Loading): Mới mở app lên màn hình trắng, ông sẽ thấy một
```
```
vòng xoay màu tím/xanh (CircularProgressIndicator) xoay xoay ở chính giữa
```
```
màn hình trong khoảng 1-2 giây (đây là lúc API đang gọi mạng).
```
```
Hình ảnh 2 (Success): Vòng xoay biến mất. Màn hình hiện ra một danh sách
```
```
cuộn dọc (Scrollable List). Trong đó chứa khoảng 100 dòng text, mỗi dòng là
```
```
một tiêu đề bài viết (Title) lấy từ API jsonplaceholder.
```
Gỉai thích:
146
```
• Model (M): Là RetrofitInstance, PostApiService và data class Post.
```
Nhiệm vụ: Lấy dữ liệu.
```
• ViewModel (VM): Là PostViewModel. Nhiệm vụ: Quản lý cái biến
```
_isLoading và danh sách posts.
```
• View (V): Là PostScreen. Nhiệm vụ: Thấy isLoading = true thì tự động
```
hiện vòng xoay, thấy posts có dữ liệu thì tự động vẽ danh sách chữ.
View không hề biết Retrofit
7.3. Đồ án
Cấu trúc thư mục
Hình 7.5: Hình ảnh thư mục đồ án
147
Sự phân bổ của dự án được ánh xạ trực tiếp vào mô hình MVVM như sau:
```
Model (Tầng Dữ liệu - Thư mục data) Trong kiến trúc hiện đại, Model
```
```
không chỉ đơn thuần là các lớp định nghĩa cấu trúc dữ liệu (Data Classes) mà
```
```
nó đại diện cho toàn bộ Tầng dữ liệu (Data Layer).
```
```
• Nhiệm vụ: Hoạt động như một "Nguồn sự thật duy nhất" (Single Source
```
```
of Truth) của ứng dụng.
```
• Cấu trúc: Tầng này bao gồm các Entity/Model, các dịch vụ mạng api
```
(Retrofit), và đặc biệt là lớp Repository. Repository đóng vai trò là người
```
trung gian che giấu đi sự phức tạp của việc lấy dữ liệu. ViewModel không
```
cần biết dữ liệu được lấy từ Internet (API) hay từ Database cục bộ, nó chỉ
```
cần gọi hàm từ Repository.
```
View (Tầng Giao diện - Thư mục ui) Tầng View đại diện cho các thành phần
```
hiển thị mà người dùng có thể nhìn thấy và tương tác.
```
• Thành phần: Bao gồm các Activity (MainActivity) và các hàm
```
```
@Composable của Jetpack Compose (như HomeScreen, BookCard).
```
```
• Nhiệm vụ: Hoạt động theo nguyên lý "Giao diện thụ động" (Dumb UI).
```
Tầng View hoàn toàn không chứa bất kỳ logic tính toán hay xử lý API
nào. Nó chỉ làm 2 việc:
```
o Quan sát (Observe) các trạng thái (State) từ ViewModel để tự động vẽ
```
```
lại màn hình (Recomposition).
```
```
o Bắt các sự kiện của người dùng (Click, Type) và đẩy (Delegate) xuống
```
cho ViewModel xử lý.
```
ViewModel (Tầng Logic Trung gian - Thư mục viewmodel) Đây là trái tim
```
của kiến trúc, đóng vai trò là cầu nối giữa View và Model.
• Thành phần: Các lớp kế thừa từ ViewModel như HomeViewModel,
SearchViewModel.
```
• Nhiệm vụ: Giữ các trạng thái của màn hình (UI State) bằng StateFlow
```
hoặc MutableState. Khi nhận được hành động từ View, ViewModel sẽ xử
```
lý logic, gọi xuống tầng Model (thông qua Repository) để lấy dữ liệu mới.
```
Sau khi có dữ liệu, ViewModel sẽ cập nhật lại UI State. Đặc biệt,
```
ViewModel nhận biết được vòng đời (Lifecycle-aware), giúp dữ liệu
```
không bị mất đi khi người dùng xoay màn hình.
148
Để hiểu rõ cách MVVM hoạt động trong dự án, quy trình tìm kiếm một cuốn
sách diễn ra theo luồng dữ liệu một chiều như sau:
• User Action: Người dùng gõ từ khóa "Kotlin" và nhấn Enter trên thanh
SearchTopBar tại màn hình BookSearchResultsScreen.
• View -> ViewModel: View gọi hàm
```
searchViewModel.searchBooks("Kotlin").
```
```
• ViewModel -> Model (Repository): SearchViewModel chuyển trạng thái
```
```
isLoading = true (lúc này View tự động hiện vòng xoay Loading) và gọi
```
```
hàm bất đồng bộ repository.searchBooks("Kotlin").
```
• Repository -> Network: BookRepository gọi phương thức GET thông
```
qua Retrofit Client (api.searchBooks("Kotlin")) để gửi request lên Google
```
Books API.
• Network -> Repository: API trả về file JSON. Retrofit sử dụng
Gson/Moshi để tự động map JSON này thành danh sách các đối tượng
```
sách (List<Book>).
```
• Repository -> ViewModel: Trả danh sách sách đã được chuẩn hóa về cho
ViewModel.
• ViewModel -> View: SearchViewModel cập nhật lại trạng thái: books =
kết_quả_trả_về và isLoading = false.
• View Recomposition: Jetpack Compose nhận thấy State thay đổi, tự động
```
ẩn vòng xoay Loading và vẽ lại lưới sách (LazyVerticalGrid) bằng danh
```
sách sách mới.
Kết quả:
149
Hình 7.6: Hình ảnh load dữ
liệu
Hình 7.7: Hình ảnh load ra
kết quả
CHƯƠNG 8: DEPENDENCY INJECTION VÀ HILT
8.1. Lý thuyết
8.1.1. Tổng quan về Dependency Injection
150
```
Dependency Injection (DI) là một mẫu thiết kế cho phép loại bỏ các phụ
```
thuộc cứng và làm cho chúng có thể thay đổi, dù là tại thời điểm chạy
```
(runtime) hay thời điểm biên dịch (compile time). DI là một dạng của
```
```
Inversion of Control (IoC), một thuật ngữ rộng hơn bao gồm các kỹ
```
thuật lập trình khác nhau nhằm tách rời các thành phần và cải thiện tính
mô-đun.
8.1.2. Dependency Injection Là gì?
```
Ở cốt lõi của nó, DI là một kỹ thuật trong đó một đối tượng (gọi là "client")
```
```
nhận được các phụ thuộc mà nó cần từ một đối tượng khác (gọi là "injector").
```
Điều này có nghĩa là, thay vì tạo ra các phụ thuộc bên trong chính nó, đối tượng
client sẽ được cung cấp những phụ thuộc này từ bên ngoài.
Ví dụ: Trong một ứng dụng Android, bạn có thể cần một đối tượng
Repository để truy xuất dữ liệu từ một cơ sở dữ liệu hoặc một dịch vụ web. Thay
vì khởi tạo Repository trực tiếp bên trong Activity hoặc Fragment, bạn có thể sử
dụng DI để cung cấp nó từ bên ngoài, giúp mã của bạn dễ dàng kiểm tra và bảo trì
hơn.
8.1.3. Các Hình Thức Của Dependency Injection
• Constructor Injection: Các phụ thuộc được cung cấp thông qua
constructor của đối tượng.
• Setter Injection: Các phụ thuộc được cung cấp thông qua các phương
thức setter của đối tượng.
• Interface Injection: Đối tượng cung cấp các phương thức để nhận các
phụ thuộc từ bên ngoài.
8.1.3.1. Lợi ích Của Dependency Injection
• Tăng Tính Tái Sử Dụng Mã: DI giúp tách rời các thành phần của ứng
dụng, làm cho chúng dễ dàng tái sử dụng trong các bối cảnh khác nhau.
• Dễ dàng kiểm tra: Với DI bạn có thể dễ dàng thany thế các phụ thuộc
```
bằng các phiên bản giả (mock) trong quá trình kiểm tra.
```
151
• Giảm sự phụ thuộc cứng: DI giúp giảm bớt sự phụ thuộc cứng, làm cho
mã nguồn dễ dàng mở rộng và bảo trì.
8.1.3.2. Các Framework DI Tiêu Biểu
Dagger
Dagger là một framework DI mạnh mẽ và phổ biến được phát triển bởi
Google. Nó sử dụng code generation để tạo ra các class DI, giúp cải
thiện hiệu suất.
Ưu Điểm Của Dagger:
• Hiệu Suất Cao: Sử dụng code generation giúp Dagger nhanh và hiệu
quả.
• Tích Hợp Tốt Với Android: Được phát triển bởi Google, Dagger có
sự tích hợp tốt với các thành phần của Android.
• Hỗ Trợ Kiểm Tra: Dễ dàng tạo mock dependencies cho các bài kiểm
tra.
Ví Dụ Dagger:
152
// Định nghĩa một module cung cấp các phụ thuộc
@Module
```
class NetworkModule {
```
@Provides
```
fun provideRetrofit(): Retrofit {
```
```
return Retrofit.Builder()
```
```
.baseUrl("https://api.example.com")
```
```
.build()
```
```
}
```
```
}
```
// Component để tiêm các phụ thuộc
```
@Component(modules = [NetworkModule::class])
```
```
interface AppComponent {
```
```
fun inject(activity: MainActivity)
```
```
}
```
// Sử dụng trong Activity
```
class MainActivity : AppCompatActivity() {
```
@Inject lateinit var retrofit: Retrofit
```
override fun onCreate(savedInstanceState: Bundle?) {
```
```
(application as MyApplication).appComponent.inject(this)
```
```
super.onCreate(savedInstanceState)
```
// Sử dụng retrofit
```
}
```
```
}
```
153
• Koin
Koin là một framework DI nhẹ và dễ sử dụng, đặc biệt phù hợp với
Kotlin. Không giống như Dagger, Koin không sử dụng code
generation mà dựa vào reflection, làm cho quá trình thiết lập nhanh
chóng và dễ dàng hơn.
Ưu Điểm Của Koin:
o Dễ Dàng Sử Dụng: Thiết lập nhanh chóng và cú pháp đơn
giản.
o Không Cần Code Generation: Không cần các annotation
processors, giúp giảm thời gian biên dịch.
o Tích Hợp Kotlin DSL: Sử dụng Kotlin DSL để định nghĩa
các module, làm cho mã nguồn ngắn gọn và rõ ràng.
Ví Dụ Koin:
154
// Định nghĩa một module Koin
```
val appModule = module {
```
```
single {
```
```
Retrofit.Builder().baseUrl("https://api.example.com").b
```
```
uild() }
```
```
}
```
// Khởi tạo Koin trong Application class
```
class MyApplication : Application() {
```
```
override fun onCreate() {
```
```
super.onCreate()
```
```
startKoin {
```
```
androidContext(this@MyApplication)
```
```
modules(appModule)
```
```
}
```
```
}
```
```
}
```
// Sử dụng trong Activity
```
class MainActivity : AppCompatActivity() {
```
```
private val retrofit: Retrofit by inject()
```
```
override fun onCreate(savedInstanceState: Bundle?) {
```
```
super.onCreate(savedInstanceState)
```
// Sử dụng retrofit
```
}
```
```
}
```
155
• Hilt
Hilt là một framework DI được xây dựng trên nền tảng của Dagger
và được Google phát triển để tối ưu hóa cho các ứng dụng Android.
Hilt đơn giản hóa việc thiết lập và sử dụng DI bằng cách cung cấp
các annotation chuyên dụng.
Ưu Điểm Của Hilt:
▪ Tích Hợp Tốt Với Android:: Được thiết kế để làm việc mượt mà
với các thành phần của Android như Activity, Fragment,
ViewModel, v.v.
▪ Thiết Lập Dễ Dàng: Cung cấp các annotation giúp giảm thiểu cấu
hình phức tạp.
▪ Dựa Trên Dagger: Hưởng lợi từ hiệu suất cao của Dagger.
Ví dụ Hilt:
156
// Đánh dấu Application class với @HiltAndroidApp
@HiltAndroidApp
```
class MyApplication : Application()
```
// Định nghĩa một module Hilt
@Module
```
@InstallIn(SingletonComponent::class)
```
```
object NetworkModule {
```
@Provides
```
fun provideRetrofit(): Retrofit {
```
```
return Retrofit.Builder()
```
```
.baseUrl("https://api.example.com")
```
```
.build()
```
```
}
```
```
}
```
// Sử dụng Hilt trong Activity
@AndroidEntryPoint
```
class MainActivity : AppCompatActivity() {
```
@Inject lateinit var retrofit: Retrofit
```
override fun onCreate(savedInstanceState: Bundle?) {
```
```
super.onCreate(savedInstanceState)
```
// Sử dụng retrofit
```
}
```
```
}
```
157
8.1.3.3. Hilt
Vấn đề
Khi tạo các instances của các class trong project của bạn, bạn có thể thực
hiện theo cách thủ công bằng cách thỏa mãn các phụ thuộc:
```
class FeedViewModel(
```
private val loadCurrentMomentUseCase:
LoadCurrentMomentUseCase
```
) : ViewModel()
```
//Ví dụ việc khởi tạo instance của class FeedViewModel:
```
FeedViewModel(LoadCurrentMomentUseCase())
```
và phụ thuộc bắc cầu mà class yêu cầu:
```
class LoadCurrentMomentUseCase(
```
private val getTimeZoneUseCase: GetTimeZoneUseCase
```
) {...}
```
```
class FeedViewModel(
```
private val loadCurrentMomentUseCase:
LoadCurrentMomentUseCase
```
) : ViewModel()
```
//Ví dụ việc khởi tạo instance của class FeedViewModel:
```
FeedViewModel(LoadCurrentMomentUseCase(GetTimeZoneUseCase(
```
```
))
```
158
Việc khởi tạo instance một cách thủ công như trên các bạn có thể thấy
nhược điểm rằng nếu constructor của class FeedViewModel tiếp tục cần
truyền vào nhiều tham số hơn, các tham số có nhiều sự phụ thuộc hơn thì
một điều kinh khủng sẽ xảy ra, các bạn cũng mường tượng được rồi đúng
không Không những thế việc làm này còn lặp đi lặp lại từ các class khác.
Một khối lượng duplicate code khủng khiếp. Tất nhiên các bạn vẫn có
cách để tránh việc duplicate code trong trường hợp này nhưng tội gì phải
làm vậy khi các bạn đã có Hilt.
Tất cả các ứng dụng sử dụng Hilt phải chứa một Application class có
@HiltAndroidApp annotation vì nó kích hoạt generate code của Hilt tại
thời điểm biên dịch:
@HiltAndroidApp
```
class MusicApp : Application()
```
và để Hilt có thể đưa các phụ thuộc vào một Activity thì Activity đó cần
phải có @AndroidEntryPoint annotaion:
@AndroidEntryPoint
```
class PlayActivity : AppCompatActivity() { /* ... */ }
```
Để thêm một phụ thuộc, hãy sử dụng @Inject annotation vào các biến mà
bạn muốn Hilt đưa vào. Tất cả các biến được đưa vào Hilt sẽ khả dụng khi
super.onCreate được gọi:
159
@AndroidEntryPoint
```
class PlayActivity : AppCompatActivity() {
```
@Inject lateinit var player: MusicPlayer
```
override fun onCreate(savedInstanceState: Bundle) {
```
```
super.onCreate(bundle)
```
```
player.play("YHLQMDLG")
```
```
}
```
```
}
```
Trong ví dụ này, đoạn code @Inject lateinit var player: MusicPlayer đang
```
"tiêm" (inject) một instance có kiểu
```
là MusicPlayer vào PlayActivity class. Nhưng làm thế nào Hilt biết cách
cung cấp instance có kiểu là MusicPlayer? Hiện tại thì chưa, bạn cần cho
Hilt biết cách làm điều đó bằng cách sử dụng @Inject annotation với
constructor của MusicPlayer class:
```
class MusicPlayer @Inject constructor() {
```
```
fun play(id: String) { ... }
```
```
}
```
Đây là tất cả những gì cần thiết để làm DI hoạt động trong project của
bạn. Vừa rồi là một ví dụ đơn giản là MusicPlayer class không phụ thuộc
vào bất kỳ class nào khác. Nhưng nếu bạn có các phụ thuộc khác được
truyền dưới dạng các tham số, Hilt sẽ xử lý điều đó và đáp ứng các phụ
thuộc đó khi cung cấp một instance của MusicPlayer:
160
//trong activity vẫn chỉ cần sử dụng
@Inject lateinit var player: MusicPlayer
```
class MusicPlayer @Inject constructor(
```
private val musicRepository: MusicRepository
```
) {
```
```
fun play(id: String) { ... }
```
```
}
```
```
class MusicRepository @Inject constructor() { ... }
```
Annotations recap
• Cho đến nay, chúng ta đã thấy rằng khi @Inject được sử dụng để
chú thích cho constructor của một class, nó sẽ cho Hilt biết cách
cung cấp các instance của class đó. Và khi nó chú thích một biến
trong một @AndroidEntryPoint class, Hilt sẽ đưa một instance của
kiểu đó vào class.
• @AndroidEntryPoint: có thể chú thích hầu hết các class của Android
framework, không chỉ mỗi Activity. Nó sẽ tự tạo một class như một
vùng chứa các phụ thuộc cho class có @AndroidEntryPoint
annotation và tạo tất cả các biến có @Inject annotation với kiểu
tướng ứng.
• @HiltAndroidApp: được sử dụng ở class kế thừa Application class.
Ngoài việc kích hoạt việc generate code của Hilt nó còn tạo một
vùng chứa các phụ thuộc được liến kết với Application class của
bạn.
Hilt Modules
161
• Hilt ModulesTrong ví dụ gần nhất, MusicPlayer class có thêm sự
phụ thuộc là MusicRepository class, thông thường việc giao tiếp
giữa các lớp với nhau sẽ thông qua interface, nếu bạn truyền tham
số cho constructor của MusicPlayer class là một interface hoặc một
class nhưng bạn lại không sở hữu class đó vì nó được lấy từ thư
viện,... thì bạn không thể có @Inject annotation trong constructor
được.
• Mình sẽ đổi tham số truyền vào constructor của MusicPlayer class
```
là MusicDatabase (đây là một abstract class)
```
```
abstract class MusicDatabase : RoomDatabase() { ... }
```
```
class MusicPlayer @Inject constructor(
```
private val db: MusicDatabase
```
) {
```
```
fun play(id: String) { ... }
```
```
}
```
• Trong Hilt thì bạn không cần phải lo lắng về các phụ thuộc có tính
chất bắc cầu, vì nó sẽ tự động kết nối tất cả các phụ thuộc đó lại với
nhau. Tuy nhiên, các bạn cần cho Hilt biết cách cung cấp để tạo các
instance đó. Ở ví dụ trên để cung cấp instance của MusicDatabase
các bạn hãy sử dụng Hilt modules.
• Hilt modules là một class có @Module annotation , trong class này
sẽ có các function cho Hilt biết cách cung cấp để tạo các instance
của một số kiểu nhất định. Trong thuật ngữ Hilt, vấn đề này được
gọi là bindings .
162
@Module
```
@InstallIn(SingletonComponent::class)
```
```
object DataModule {
```
@Provides
```
fun provideMusicDB(@ApplicationContext context: Context):
```
```
MusicDatabase {
```
```
return Room.databaseBuilder(
```
context, MusicDatabase::class.java, "music.db"
```
).build()
```
```
}
```
```
}
```
• Function provideMusicDB có @Provides annotation cho Hilt biết
cách cung cấp instance có kiểu là MusicDatabase. Phần nội dung
bên trong khối block sẽ chứa code mà Hilt cần phải thực thi. Tham
số truyền vào cho Hilt biết các phụ thuộc với các kiểu tương ứng,
trong trường hợp này là Context, trong Hilt đã có sẵn
• @ApplicationContext annotation để các bạn có thể lấy được context
của ứng dụng rồi. Tóm lại, function này sẽ cung cấp instance của
MusicDatabase, và việc khởi tạo instance của MusicPlayer vẫn
không có gì thay đổi:
@Inject lateinit var player: MusicPlayer
• Hilt modules cũng có @InstallIn annotation cho biết thông tin này
đã có sẵn trong các vùng chứa hoặc các components phụ thuộc gì
```
(như SingletonComponent ở ví dụ trên), chúng ta sẽ cùng nhau tìm
```
hiểu các components là gì nhé.
Hilt Components
• Hilt Components là một class mà Hilt tạo ra có trách nhiệm cung
cấp các instance của từng loại. Tại thời điểm biên dịch, Hilt duyệt
qua "đồ thị" phụ thuộc của ứng dụng của bạn và tạo mã để cũng cấp
tất cả các kiểu với các phụ thuộc bắc cầu của chúng.
• Hệ thống phân cấp các components của Hilt
163
Hình 8.1: Hilt Components
• Ở ví dụ gần nhất MusicDatabase được binding trong component
là SingletonComponent thì nó cũng sẽ có sẵn trong các component
còn lại trong hệ thống phân cấp.
• Các component này được tạo tự động tại thời điểm biên dịch, chúng
được tạo, quản lý và liên kết với các framework Android tương ứng
khi bạn chú thích các class đó bằng @AndroidEntryPoint
annotation.
• Các @InstallIn annotation cho module rất hữu ích để kiểm soát
```
những nơi có sự ràng buộc (binding) lại với nhau.
```
Scoping
• Ở phần đầu mình có nhắc việc tạo các instance một cách thủ công,
nếu bạn để ý thì mỗi lần tạo instance các bạn đang tạo một phiên bản
khác của nó. Điều đó hoàn toàn không lý tưởng một chút nào, hãy
nên sử dụng chỉ cùng một phiên bản của instance trong toàn bộ ứng
dụng. Có rất nhiều cách để có thể thực hiện việc tạo một instance
duy nhất, đặc biệt là với ngôn ngữ kotlin, chúng ta sẽ phải viết logic,
code thêm rất nhiều đặc biệt với các trường hợp có sự phụ thuộc bắc
cầu nhưng với Hilt chỉ cần thêm @Singleton annotation sẽ giải quyết
mọi vấn đề.
164
• Bằng cách sử dụng @Singleton annotation trong các @Provides
method, các bạn đang nói với Hilt rằng sẽ luôn chia sẻ cùng một
phiên bản của kiểu này trong component đó.
@Module
```
@InstallIn(SingletonComponent::class)
```
```
object DataModule {
```
@Singleton
@Provides
```
fun provideMusicDB(@ApplicationContext context: Context):
```
```
MusicDatabase {
```
```
return Room.databaseBuilder(
```
context, MusicDatabase::class.java, "music.db"
```
).build()
```
```
}
```
```
}
```
Ở đoạn code trên Hilt sẽ giúp bạn tạo một instance, một phiên bản
duy nhất của MusicDatabase trong toàn bộ ứng dụng.
@Singleton là một scope annotation. Mỗi Hilt component sẽ có một
scope annotation tương ứng
Hình 8.2: Scoping
165
Nếu bạn muốn xác định một scope trong ActivityComponent hãy sử
dụng @ActivityScoped annotation. Các annotation này có thể được
sử dụng trong module nhưng chúng cũng có thể sử dụng trong các
class mà constructor có @Inject annotation.
Bindings
Có hai loại bindings:
• Unscoped bindings: là các liên kết mà không được chú thích bằng
các scope annotaion. Các liên kết này có sẵn cho tất cả các
component nếu chúng không được installed trong một module,
giống MusicPlayer trong các ví dụ trên.
• Scoped bindings: là các liên kết được chú thích bằng các scope
annotaion hoặc các unscoped bindings được installed trong một
module của coponent tương ứng, giống MusicDatabase trong các ví
dụ trên.
Jetpack Extensions
• Hilt cung cấp tích hợp với các Jetpack library phổ biến nhất như:
ViewModel, Navigation, Compose và WorkManager.
• Ngoài ViewModel ra thì khi tích hợp với các Jetpack library khác
các bạn sẽ phải thêm một số yêu cầu nhỏ nữa để sử dụng Hilt
@HiltViewModel
```
class ExampleViewModel @Inject constructor(
```
private val savedStateHandle: SavedStateHandle,
private val repository: ExampleRepository
```
) : ViewModel() {
```
...
```
}
```
Ngoài việc constructor vẫn có @Inject annotation, để cho Hilt biết
cách cung cấp các phiên bản của ViewModel này, bạn chỉ cần chú
thích lớp với annotaion là @HiltViewModel. Vậy là xong, hilt sẽ xử
lý việc tạo instance của ViewModel này cho bạn, nhưng hãy đảm
bảo rằng bạn đã có các liên kết để tạo các instance như
SavedStateHandle, ExampleRepository. Bạn muốn lấy instance của
ViewModel trên Activity, Fragment,... đơn giản với một dòng code.
166
```
private val viewModel: ExampleViewModel by viewModels()
```
8.2. Ví dụ và giải thích
Hướng dẫn cài đặt Hilt vào dự án
Bước 1: Thêm Plugin vào build.gradle.kts
```
plugins {
```
// Thêm plugin Hilt
```
id("com.google.dagger.hilt.android") version "2.51.1" apply false
```
```
}
```
Bước 2: Cấu hình build.gradle.kts
```
plugins {
```
```
id("com.android.application")
```
```
id("kotlin-android")
```
```
id("kotlin-kapt") // Hoặc id("com.google.devtools.ksp") nếu dùng
```
KSP
```
id("com.google.dagger.hilt.android")
```
```
}
```
```
dependencies {
```
// Hilt Core
```
implementation("com.google.dagger:hilt-android:2.51")
```
```
kapt("com.google.dagger:hilt-compiler:2.51")
```
// Hilt tích hợp với Jetpack Compose Navigation
```
implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
```
```
}
```
Khởi tạo lớp Application
Hilt yêu cầu một lớp Application được đánh dấu để làm "gốc" cho toàn bộ
sơ đồ phụ thuộc.
@HiltAndroidApp
```
class TourApplication : Application() {
```
// Không cần viết gì thêm ở đây, Hilt sẽ tự động sinh code
```
}
```
167
Giải thích: Chú thích @HiltAndroidApp sẽ kích hoạt việc sinh mã nguồn
của Hilt, bao gồm một lớp cơ sở cho ứng dụng của bạn, đóng vai trò là
thùng chứa phụ thuộc ở cấp độ ứng dụng.
Khai báo Hilt Module
```
Vì Retrofit hay ApiService là các thư viện bên ngoài (bạn không thể nhảy
```
```
vào code của họ để sửa), nên bạn cần một cái Module để dạy Hilt cách tạo
```
ra chúng.
@Module
```
@InstallIn(SingletonComponent::class) // Giữ đối tượng này sống suốt
```
vòng đời của App
```
object NetworkModule {
```
@Provides
@Singleton // Chỉ tạo 1 lần duy nhất để tiết kiệm RAM
```
fun provideRetrofit(): Retrofit {
```
```
return Retrofit.Builder()
```
```
.baseUrl("https://jsonplaceholder.typicode.com/")
```
```
.addConverterFactory(GsonConverterFactory.create())
```
```
.build()
```
```
}
```
@Provides
@Singleton
```
fun provideApiService(retrofit: Retrofit): PostApiService {
```
```
return retrofit.create(PostApiService::class.java)
```
```
}
```
```
}
```
Giải thích:
• @Module: Đánh dấu đây là nơi cung cấp các "nguyên liệu".
```
• @InstallIn(SingletonComponent::class): Xác định thời gian sống. Ở
```
```
đây là Singleton (duy nhất), nghĩa là dù bạn chuyển bao nhiêu màn
```
hình thì cái Retrofit này vẫn là cái cũ, không bị khởi tạo lại.
• @Provides: Nói với Hilt: "Đây là cách tạo ra đối tượng này nè".
• Tham số retrofit: Retrofit trong hàm bên dưới: Hilt cực kỳ thông
minh. Nó thấy hàm provideApiService cần một cái Retrofit, nó sẽ tự
nhìn lên hàm trên để lấy kết quả trả về và lắp vào.
168
Tiêm ViewModel
@HiltViewModel
```
class PostViewModel @Inject constructor(
```
private val apiService: PostApiService // "Đặt hàng" ở đây
```
) : ViewModel() {
```
```
private val _posts = MutableStateFlow<List<Post>>(emptyList())
```
val posts: StateFlow<List<Post>> = _posts
```
fun loadData() {
```
```
viewModelScope.launch {
```
```
val data = apiService.getPosts() // Sử dụng ngay, không cần khởi
```
tạo!
_posts.value = data
```
}
```
```
}
```
```
}
```
Giải thích:
• @HiltViewModel: Nói cho Hilt biết lớp này là một ViewModel.
• @Inject constructor: Đây là hành động "đặt hàng". Bạn nói với Hilt:
"Khi tạo PostViewModel, hãy nhớ mang theo một cái
PostApiService đã chuẩn bị ở Bước 2 cho tôi".
• private val apiService: Bạn không bao giờ phải viết val apiService
= Retrofit... nữa. Code cực kỳ sạch và ngắn gọn.
Hiển thị ở Giao diện
169
@AndroidEntryPoint // Bắt buộc phải có ở Activity/Fragment dùng Hilt
```
class MainActivity : ComponentActivity() {
```
```
override fun onCreate(savedInstanceState: Bundle?) {
```
```
super.onCreate()
```
```
setContent {
```
```
// Dùng hàm hiltViewModel() thay vì viewModel() thông thường
```
```
val viewModel: PostViewModel = hiltViewModel()
```
```
PostScreen(viewModel)
```
```
}
```
```
}
```
```
}
```
Giải thích:
• @AndroidEntryPoint: Đánh dấu đây là "điểm tiếp nhận". Nếu không
có nó, Hilt không thể đổ dữ liệu vào Activity này.
```
• hiltViewModel(): Đây là hàm tiện ích của thư viện
```
androidx.hilt:hilt-navigation-compose. Nó sẽ tự động kết nối với
Hilt để lấy về một PostViewModel đã có sẵn apiService bên trong.
Kết quả
170
Hình 8.3: Ví dụ về Hilt
8.3. Đồ án
Xây dựng lớp giao tiếp mạng với Retrofit
Thay vì gọi HTTP request thủ công, dự án sử dụng Retrofit để biến các
RESTful API thành các Interface của Kotlin.
• Định nghĩa Endpoints: Các đường dẫn API được định nghĩa
thông qua Interface PostApiService với các Annotation rõ ràng
như @GET. Việc này kết hợp với suspend function của
Coroutines giúp xử lý các tác vụ gọi mạng bất đồng bộ mà không
```
làm treo giao diện (UI Thread).
```
```
interface GoogleBooksApiService {
```
```
@GET("volumes")
```
```
suspend fun searchBooks(
```
```
@Query("q") query: String,
```
```
@Query("maxResults") maxResults: Int = 20
```
171
```
): Response<GoogleBookResponse>
```
```
@GET("volumes/{volumeId}")
```
```
suspend fun getBookById(@Path("volumeId") volumeId:
```
```
String): Response<BookItem>
```
```
}
```
```
• Tích hợp Converter: Quá trình chuyển đổi dữ liệu thô (JSON)
```
từ server trả về thành các đối tượng Data Class của Kotlin được
tự động hóa hoàn toàn nhờ GsonConverterFactory.
```
object GoogleBooksClient {
```
private const val BASE_URL =
"https://www.googleapis.com/books/v1/"
private const val API_KEY = "AIzaSyCB6PVlT939N3rD-
La0y52Y0bEYydSeF0o"
```
private val okHttpClient = OkHttpClient.Builder()
```
```
.addInterceptor { chain ->
```
```
val original = chain.request()
```
```
val url = original.url.newBuilder()
```
```
.addQueryParameter("key", API_KEY)
```
```
.build()
```
```
chain.proceed(original.newBuilder().url(url).build())
```
```
}
```
```
.build()
```
```
val instance: Retrofit by lazy {
```
```
Retrofit.Builder()
```
```
.baseUrl(BASE_URL)
```
```
.client(okHttpClient)
```
```
.addConverterFactory(GsonConverterFactory.create())
```
```
.build()
```
```
}
```
```
val apiService: GoogleBooksApiService by lazy {
```
```
instance.create(GoogleBooksApiService::class.java)
```
```
}
```
```
}
```
172
```
Quản lý khởi tạo tập trung bằng Dagger Hilt (NetworkModule)
```
Nếu khởi tạo đối tượng Retrofit thủ công ở mỗi ViewModel, ứng dụng sẽ gặp
```
tình trạng rò rỉ bộ nhớ (Memory Leak) và các thành phần bị liên kết quá chặt
```
```
chẽ (Tight Coupling). Để giải quyết triệt để, dự án sử dụng Hilt để tạo một
```
"Container" quản lý cấu hình mạng:
• Khởi tạo ở cấp độ ứng dụng: Đánh dấu lớp BookstoreApplication bằng
Annotation @HiltAndroidApp để kích hoạt bộ máy Dagger Hilt hoạt động
xuyên suốt vòng đời của app.
@HiltAndroidApp
```
class BookstoreApplication : Application()
```
173
• Tối ưu hóa bộ nhớ với Singleton: Khai báo đối tượng NetworkModule
```
và gắn @InstallIn(SingletonComponent::class). Bên trong module này,
```
em sử dụng kết hợp @Provides và @Singleton khi cấu hình
```
Retrofit.Builder(). Kỹ thuật này đảm bảo HTTP Client và API Service chỉ
```
được khởi tạo một lần duy nhất trong bộ nhớ RAM, tối ưu hóa hiệu năng
khi người dùng thao tác liên tục trên ứng dụng.
```
object RetrofitClient {
```
private const val PRODUCTION_URL = "https://bookstore-
backend-production-4b7e.up.railway.app/"
private const val LOCAL_URL = "http://192.168.1.4:8081/"
private const val USE_LOCAL = true
```
// Khởi tạo Retrofit duy nhất (Singleton)
```
```
val instance: Retrofit by lazy {
```
```
val gson = GsonBuilder().setLenient().create()
```
```
Retrofit.Builder()
```
```
.baseUrl(if (USE_LOCAL) LOCAL_URL else
```
```
PRODUCTION_URL)
```
```
.addConverterFactory(GsonConverterFactory.create(gson))
```
```
.build()
```
```
}
```
// Cung cấp Service API cho toàn bộ ứng dụng
```
val apiService: GoogleBooksApiService by lazy {
```
```
instance.create(GoogleBooksApiService::class.java)
```
```
}
```
```
}
```
```
Tiêm phụ thuộc (Dependency Injection) vào luồng MVVM
```
Sức mạnh lớn nhất của Hilt thể hiện ở việc tự động "lắp ráp" các thành phần
```
lại với nhau mà không cần code khởi tạo rườm rà (Boilerplate code):
```
174
• Tại tầng ViewModel: Lớp PostViewModel được đánh dấu bằng
@HiltViewModel. Thay vì tự khởi tạo apiService, em sử dụng @Inject
constructor. Hilt sẽ tự động tìm PostApiService đã được tạo ở
NetworkModule và tiêm thẳng vào ViewModel. Nhờ đó, ViewModel
```
chỉ việc tập trung vào logic gọi hàm loadData() và cập nhật StateFlow.
```
```
• Tại tầng UI (Compose): Màn hình MainActivity được gắn
```
```
@AndroidEntryPoint để kích hoạt Hilt. Tại đây, hàm hiltViewModel()
```
```
được gọi để tự động cung cấp PostViewModel (đã chứa đầy đủ cấu hình
```
```
mạng) cho giao diện PostScreen.
```
@HiltViewModel
```
class HomeViewModel @Inject constructor(
```
private val repository: BookRepository
```
) : ViewModel() {
```
```
var books by mutableStateOf<List<Book>>(emptyList())
```
private set
```
var isLoading by mutableStateOf(false)
```
private set
```
init {
```
```
fetchBooks("lập trình android")
```
```
}
```
```
fun fetchBooks(query: String) {
```
```
viewModelScope.launch {
```
```
isLoading = true
```
```
books = repository.getBooks(query)
```
```
isLoading = false
```
```
}
```
```
}
```
```
}
```
175
Kết quả:
176
PHẦN 3: XÂY DỰNG ĐỒ ÁN ỨNG DỤNG BÁN SÁCH
CHƯƠNG 9: MÔ TẢ VÀ PHÂN TÍCH THIẾT KẾ ĐỒ ÁN
9.1. Ý tưởng và mục tiêu đồ án
9.1.1. Ý tưởng
Trong bối cảnh thương mại điện tử phát triển mạnh mẽ, nhu cầu mua sắm
trực tuyến, đặc biệt là sách, ngày càng gia tăng. Người dùng mong muốn một ứng
dụng không chỉ cho phép tìm kiếm và mua sách một cách nhanh chóng, mà còn
cung cấp những trải nghiệm phong phú như xem đánh giá từ cộng đồng, lọc sách
theo nhiều tiêu chí, theo dõi đơn hàng và nhận thông báo. Bên cạnh đó, các cửa
hàng sách cần một công cụ quản lý tập trung để theo dõi doanh thu, tồn kho và
tương tác với khách hàng hiệu quả hơn. Xuất phát từ thực tế đó, ý tưởng xây dựng
ứng dụng BookVerse – một nền tảng bán sách trực tuyến hiện đại dành cho
Android – đã được hình thành.
Ý tưởng chính của đồ án là phát triển một hệ thống hoàn chỉnh gồm ứng
```
dụng di động (frontend) và máy chủ API (backend), cho phép người dùng thực
```
hiện toàn bộ quy trình mua sách từ khám phá, tìm kiếm, đánh giá, thêm vào giỏ
```
hàng, thanh toán (mô phỏng) đến quản lý đơn hàng và tài khoản cá nhân. Điểm
```
đặc biệt là ứng dụng tận dụng Google Books API làm nguồn dữ liệu sách chính,
giúp kho sách luôn phong phú và cập nhật mà không cần nhập liệu thủ công. Toàn
bộ giao diện được xây dựng bằng Jetpack Compose theo phong cách khai báo,
trong khi backend sử dụng Spring Boot với cơ chế xác thực JWT, lưu trữ dữ liệu
trên MySQL và gửi email xác nhận đơn hàng bất đồng bộ.
177
```
Cụ thể, ứng dụng được thiết kế với các luồng chính: (1) Người dùng đăng
```
```
ký/đăng nhập, quản lý thông tin cá nhân và đổi mật khẩu; (2) Khám phá sách qua
```
```
danh mục (Văn học, Kinh tế, Tâm lý học, Thiếu nhi, Giáo khoa, Lịch sử, Nghệ
```
```
thuật, Khoa học, Tôn giáo, Chính trị, Nấu ăn, Du lịch) cùng các phần sách nổi bật
```
```
và sách mới phát hành; (3) Tìm kiếm sách theo từ khóa kết hợp bộ lọc thể loại,
```
```
khoảng giá, đánh giá sao và sắp xếp linh hoạt; (4) Xem chi tiết sách với đầy đủ
```
```
thông tin, mô tả, thông số xuất bản, cùng hệ thống đánh giá cộng đồng (điểm trung
```
```
bình, biểu đồ sao, danh sách bình luận) và cho phép người dùng gửi đánh giá của
```
```
riêng mình; (5) Quản lý giỏ hàng (thêm, sửa số lượng, xóa) và tiến hành đặt hàng
```
```
với các phương thức thanh toán đa dạng (COD, chuyển khoản, ví MoMo); (6)
```
```
Theo dõi lịch sử đơn hàng phân theo trạng thái (chờ xác nhận, chờ lấy hàng, đang
```
```
giao hàng, hoàn tất) và nhận thông báo hệ thống về khuyến mãi cũng như cập nhật
```
đơn hàng.
Giá trị mà đồ án hướng tới là hai mặt: với người dùng, mang lại trải nghiệm
mua sách tiện lợi, minh bạch về giá và đánh giá, tiết kiệm thời gian nhờ các công
```
cụ lọc tìm thông minh; với chủ cửa hàng (sau khi mở rộng), cung cấp khả năng
```
quản lý đơn hàng tập trung, thống kê doanh thu và tương tác với khách hàng qua
hệ thống đánh giá. Điểm khác biệt so với các ứng dụng bán sách thông thường
nằm ở việc tích hợp Google Books API để có kho dữ liệu khổng lồ mà không tốn
công nhập liệu, kết hợp với bộ lọc đa chiều và hiển thị đánh giá trực quan bằng
biểu đồ sao. Ngoài ra, việc sử dụng JWT kết hợp gửi email bất đồng bộ đảm bảo
bảo mật và trải nghiệm mượt mà.
178
Trong quá trình thực hiện, đồ án cũng đối mặt với một số thách thức như:
cấu trúc dữ liệu phức tạp từ Google Books API đòi hỏi phải xây dựng các DTO
```
trung gian và extension function để chuyển đổi; việc quản lý token JWT trên client
```
```
cần cơ chế tự động làm mới (sẽ phát triển sau); đồng bộ giỏ hàng giữa các thiết bị
```
yêu cầu lưu trữ cục bộ bằng Room và đồng bộ lên server. Các giải pháp tương ứng
bao gồm sử dụng GoogleBookDto và mapping thủ công, triển khai Authenticator
trong OkHttp, và thiết kế bảng cart_items trên cơ sở dữ liệu local. Nhờ những
phân tích và thiết kế chi tiết, BookVerse hứa hẹn trở thành một ứng dụng bán sách
hiện đại, đáp ứng tốt nhu cầu của cả người dùng và nhà quản lý.
9.1.2. Mục tiêu
Dự án BookVerse – Ứng dụng bán sách trực tuyến được thực hiện nhằm
xây dựng một nền tảng mua bán sách hiện đại, hoàn chỉnh trên thiết bị di động
Android, kết nối với hệ thống backend REST API tự phát triển. Mục tiêu được
chia làm hai nhóm chính: mục tiêu tổng quát và mục tiêu cụ thể.
9.1.2.1. Mục tiêu tổng quát
Nghiên cứu và áp dụng ngôn ngữ Kotlin cùng các công nghệ hiện đại
```
(Jetpack Compose, Coroutines, Hilt, Retrofit) để xây dựng một ứng dụng thực tế
```
có tính ứng dụng cao.
Phát triển một hệ thống bán sách trực tuyến đầy đủ chức năng: từ khám phá
```
sách, tìm kiếm, lọc, đánh giá, giỏ hàng, đặt hàng, thanh toán (mô phỏng), quản lý
```
đơn hàng, quản lý tài khoản và thông báo.
Xây dựng backend bằng Spring Boot cung cấp API RESTful, xác thực
JWT, lưu trữ dữ liệu trên MySQL, gửi email xác nhận đơn hàng bất đồng bộ.
Tích hợp nguồn dữ liệu sách phong phú từ Google Books API, giúp kho
sách luôn đa dạng và cập nhật mà không cần nhập liệu thủ công.
179
Đảm bảo ứng dụng có trải nghiệm người dùng mượt mà, giao diện thân
thiện, mã nguồn dễ bảo trì và mở rộng nhờ áp dụng kiến trúc MVVM, dependency
injection và lập trình bất đồng bộ với Coroutines.
9.1.2.2. Mục tiêu cụ thể
a. Mục tiêu kỹ thuật
```
Frontend (Android – Kotlin)
```
• Sử dụng Jetpack Compose để xây dựng toàn bộ giao diện khai
báo, tái sử dụng component.
• Áp dụng kiến trúc MVVM với ViewModel, StateFlow,
```
collectAsState().
```
• Gọi API qua Retrofit + OkHttp, xử lý bất đồng bộ bằng
```
Coroutines (suspend functions, viewModelScope).
```
```
• Quản lý phụ thuộc bằng Hilt (Dagger Hilt), bao gồm các
```
```
module: NetworkModule, RepositoryModule, DatabaseModule.
```
• Lưu token JWT vào DataStore / SharedPreferences, tự động
đính kèm vào header qua Interceptor.
• Quản lý giỏ hàng tạm thời bằng StateFlow trong
CartViewModel, có thể mở rộng lưu cục bộ bằng Room.
```
• Hỗ trợ lazy loading danh sách sách, phân trang (sử dụng
```
```
LazyColumn/LazyVerticalGrid).
```
• Tối ưu hiệu năng tải ảnh với Coil kết hợp cache.
```
Backend (Spring Boot – Java)
```
• Xây dựng các REST API đáp ứng đầy đủ nghiệp vụ: xác thực,
```
quản lý user, đơn hàng, đánh giá, tìm kiếm sách (proxy sang
```
```
Google Books).
```
```
• Bảo mật bằng Spring Security + JWT (HS256), tự phát hành và
```
kiểm tra token.
• Sử dụng Spring Data JPA để tương tác với MySQL, tự động tạo
```
bảng (DDL auto-update).
```
180
• Gửi email xác nhận đơn hàng bất đồng bộ qua JavaMailSender +
```
MailHog (môi trường phát triển).
```
• Xử lý ngoại lệ tập trung với @RestControllerAdvice
```
(GlobalExceptionHandler).
```
• Cấu hình CORS cho phép frontend Android gọi API.
Cơ sở dữ liệu
• Thiết kế các bảng: users, orders, order_items, reviews với quan
hệ hợp lý.
• Sử dụng user_id làm khóa ngoại cho orders và reviews.
b. Mục tiêu chức năng
• Đăng ký / Đăng nhập: Đăng ký tài khoản với username,
password, email, họ tên, số điện thoại, địa chỉ. Đăng nhập nhận
JWT, tự động duy trì phiên.
```
• Quản lý tài khoản: Xem và cập nhật thông tin cá nhân (họ tên,
```
```
email, số điện thoại, địa chỉ). Đổi mật khẩu (yêu cầu nhập mật
```
```
khẩu cũ, mới và xác nhận).
```
```
• Khám phá sách: Xem danh mục sách (Văn học, Kinh tế, Tâm lý
```
học, Thiếu nhi, Giáo khoa, Lịch sử, Nghệ thuật, Khoa học, Tôn
```
giáo, Chính trị, Nấu ăn, Du lịch). Xem sách nổi bật và sách mới
```
phát hành trên trang chủ.
```
• Tìm kiếm và lọc sách: Tìm kiếm theo từ khóa (gọi Google
```
```
Books API). Lọc theo thể loại, khoảng giá, đánh giá sao. Sắp
```
xếp kết quả theo: phổ biến nhất, mới nhất, giá tăng dần, giá
giảm dần, đánh giá cao nhất.
• Xem chi tiết sách: Hiển thị đầy đủ thông tin: ảnh bìa, tên sách,
```
tác giả, giá, mô tả, thông tin xuất bản (nhà xuất bản, năm, số
```
```
trang, kích thước, loại bìa). Xem đánh giá cộng đồng (điểm
```
```
trung bình, biểu đồ sao, danh sách bình luận).
```
• Đánh giá sách: Người dùng đã đăng nhập có thể gửi đánh giá
```
(rating từ 1–5 sao, comment).
```
181
• Giỏ hàng: Thêm sách vào giỏ, cập nhật số lượng, xóa sách. Hiển
thị tổng tiền tạm tính, phí vận chuyển, giảm giá.
```
• Đặt hàng và thanh toán: Nhập thông tin giao hàng (họ tên, SĐT,
```
```
email, địa chỉ tỉnh/huyện/chi tiết, ghi chú). Chọn phương thức
```
thanh toán: COD, chuyển khoản ngân hàng, ví MoMo. Gửi đơn
hàng, nhận email xác nhận.
• Quản lý đơn hàng: Xem danh sách đơn hàng theo trạng thái:
Chờ xác nhận, Chờ lấy hàng, Đang giao hàng, Hoàn tất.
• Thông báo hệ thống: Nhận các thông báo khuyến mãi, cập nhật
trạng thái đơn hàng, xác nhận đánh giá. Đánh dấu thông báo đã
đọc.
c. Mục tiêu trải nghiệm người dùng (UX/UI)
• Xây dựng giao diện thân thiện, nhất quán theo Material Design 3,
```
dễ thao tác trên cả điện thoại và máy tính bảng (responsive).
```
```
• Tối ưu số bước để hoàn tất một đơn hàng (từ tìm sách → thêm
```
```
giỏ → thanh toán chỉ 4–5 bước).
```
```
• Hiển thị trạng thái tải dữ liệu (CircularProgressIndicator), xử lý
```
```
lỗi mạng và hiển thị thông báo phù hợp (snackbar, toast).
```
• Cập nhật giao diện theo thời gian thực nhờ StateFlow và
recomposition của Compose.
d. Mục tiêu vể quản lý và triển khai
• Quản lý mã nguồn bằng Git, sử dụng GitHub, tuân thủ quy trình
commit rõ ràng.
```
• Viết tài liệu hướng dẫn cài đặt, cấu hình và chạy ứng dụng (cả
```
```
frontend và backend) để người khác có thể dễ dàng triển khai.
```
```
• Kiểm thử cơ bản các luồng chính bằng Postman (API) và thủ
```
```
công trên thiết bị (Android).
```
```
• Triển khai backend lên môi trường cloud (Render, Railway hoặc
```
```
AWS) trong tương lai để ứng dụng hoạt động thực tế.
```
e. Mục tiêu phát triển mở rộng
182
```
• Thêm chức năng yêu thích sách (wishlist) lưu trên server.
```
• Phát triển phiên bản iOS sử dụng Kotlin Multiplatform Mobile
```
(KMM) chia sẻ logic.
```
```
• Xây dựng admin dashboard (web) để quản lý toàn bộ hệ thống.
```
• Tích hợp Firebase Cloud Messaging để gửi thông báo đẩy khi đơn
hàng thay đổi trạng thái.
9.2. Các chức năng chính
9.2.1. Đăng ký tài khoản
• Người dùng nhập các thông tin: Họ tên, Email, Số điện thoại, Mật
khẩu, Xác nhận mật khẩu.
• Đồng ý với Điều khoản dịch vụ và Chính sách bảo mật trước khi
đăng ký.
• Hệ thống gửi yêu cầu POST /api/auth/register đến backend, lưu
thông tin người dùng vào cơ sở dữ liệu, mật khẩu được mã hóa
bằng BCrypt.
• Sau khi đăng ký thành công, người dùng được chuyển đến màn
hình đăng nhập.
9.2.2. Đăng nhập
```
• Người dùng nhập username (email) và mật khẩu.
```
• Gửi POST /api/auth/login, backend xác thực và trả về
JwtResponse chứa accessToken.
• Ứng dụng lưu token vào SharedPreferences hoặc DataStore, tự
động thêm vào header Authorization: Bearer <token> cho các
request tiếp theo.
```
• Hỗ trợ đăng nhập qua mạng xã hội (Facebook, Google) – giao
```
diện đã có, sẽ tích hợp OAuth2 trong tương lai.
9.2.3. Quản lý thông tin cá nhân
183
• Người dùng có thể xem và cập nhật thông tin: Họ tên, Số điện
thoại, Email, Địa chỉ.
```
• Gọi GET /api/users/{id} để lấy thông tin hiện tại.
```
```
• Gọi PUT /api/users/{id} để cập nhật thông tin mới.
```
• Dữ liệu được cập nhật ngay lập tức lên cơ sở dữ liệu.
9.2.4. Đổi mật khẩu
• Người dùng nhập mật khẩu cũ, mật khẩu mới và xác nhận mật
khẩu mới.
• Gửi POST /api/users/change-password kèm JWT.
• Backend kiểm tra mật khẩu cũ có khớp không, sau đó mã hóa
mật khẩu mới và lưu.
```
• Phản hồi thành công hoặc thông báo lỗi (mật khẩu cũ sai, mật
```
```
khẩu mới không khớp, v.v.).
```
9.2.5. Xem danh mục sách
• Trang chủ hiển thị các danh mục chính: Văn học, Kinh tế, Tâm
lý học, Thiếu nhi, Giáo khoa, Lịch sử, Nghệ thuật, Khoa học,
Tôn giáo, Chính trị, Nấu ăn, Du lịch.
```
• Mỗi danh mục hiển thị số lượng sách (mock hoặc từ API sau khi
```
```
tích hợp).
```
• Người dùng nhấn vào một danh mục để xem danh sách sách
thuộc thể loại đó.
9.2.6. Xem sách nổi bật và sách mới phát hành
• Trang chủ hiển thị hai khu vực: "Sách nổi bật" và "Sách mới
phát hành".
```
• Mỗi sách hiển thị ảnh bìa, tên sách, tác giả, giá khuyến mãi (nếu
```
```
có), giá gốc, số đánh giá.
```
184
• Dữ liệu được lấy từ Google Books API thông qua backend
```
(GET /api/books/search?q= với từ khóa đặc biệt).
```
9.2.7. Tìm kiếm sách
• Người dùng nhập từ khóa vào ô tìm kiếm.
```
• Ứng dụng gọi GET /api/books/search?q={keyword}.
```
• Backend proxy sang Google Books API, trả về danh sách sách
dạng JSON.
```
• Kết quả hiển thị dạng lưới (grid) hoặc danh sách, mỗi sách có
```
ảnh, tên, tác giả, giá.
9.2.8. Lọc và sắp xếp kết quả tìm kiếm
```
• Bộ lọc (Filter): Người dùng có thể lọc theo:
```
```
• Thể loại (Văn học, Kinh tế, Tâm lý học, v.v.)
```
```
• Khoảng giá (Dưới 100.000đ, 100.000đ–200.000đ, 200.000đ–
```
```
500.000đ, Trên 500.000đ)
```
• Đánh giá
```
• Sắp xếp (Sort): Các tùy chọn sắp xếp bao gồm:
```
o Phổ biến nhất
o Mới nhất
o Giá: Thấp đến cao
o Giá: Cao đến thấp
o Đánh giá cao nhất
• Sau khi chọn bộ lọc / sắp xếp, ứng dụng gửi lại yêu cầu tìm kiếm
```
với các tham số tương ứng (hiện tại lọc phía client, sau này có thể
```
```
mở rộng backend).
```
9.2.9. Xem chi tiết sách
```
• Người dùng nhấn vào một sách bất kỳ (từ trang chủ, danh mục,
```
```
kết quả tìm kiếm) để xem chi tiết.
```
185
• Màn hình chi tiết hiển thị:
o Ảnh bìa lớn, tên sách, tác giả.
```
o Giá khuyến mãi, giá gốc, tình trạng (còn hàng / hết hàng).
```
```
o Mô tả sản phẩm, thông tin xuất bản (nhà xuất bản, năm
```
```
xuất bản, số trang, kích thước, loại bìa).
```
```
• Khu vực đánh giá: điểm trung bình (ví dụ 4.0/5), tổng số đánh
```
```
giá, biểu đồ phân bố số sao, danh sách bình luận (tên người
```
```
dùng, thời gian, số sao, nội dung).
```
```
• Các sách liên quan (cùng thể loại hoặc cùng tác giả).
```
```
• Dữ liệu sách chi tiết được lấy từ Google Books API (qua
```
```
backend), dữ liệu đánh giá lấy từ GET /api/reviews/{bookId}.
```
9.2.10. Đánh giá sách
• Người dùng đã đăng nhập có thể viết đánh giá cho sách.
```
• Chọn số sao (1–5) và nhập nội dung bình luận.
```
```
• Gửi POST /api/reviews với ReviewRequest (bookId, rating,
```
```
comment).
```
• Backend lưu đánh giá vào bảng reviews, gắn với user hiện tại
```
(lấy từ JWT).
```
• Sau khi gửi thành công, đánh giá mới xuất hiện trong danh sách
và điểm trung bình được cập nhật.
9.2.11. Quản lý giỏ hàng
• Người dùng thêm sách vào giỏ hàng từ màn hình chi tiết sách.
• Trong giỏ hàng, có thể:
o Tăng/giảm số lượng của từng sách.
o Xóa sách khỏi giỏ.
```
o Xem tổng tiền tạm tính, phí vận chuyển (giả lập), giảm
```
```
giá (nếu có), tổng cộng.
```
• Giỏ hàng được quản lý tạm thời bằng StateFlow trong
CartViewModel, có thể lưu cục bộ bằng Room để giữ lại sau khi
đóng ứng dụng.
186
9.2.12. Đặt hàng và thanh toán
• Từ màn hình giỏ hàng, người dùng nhấn "Thanh toán" →
chuyển đến màn hình nhập thông tin giao hàng.
• Nhập các thông tin: Họ tên người nhận, Số điện thoại, Email,
```
Tỉnh/Thành phố, Quận/Huyện, Địa chỉ chi tiết, Ghi chú (không
```
```
bắt buộc).
```
• Chọn phương thức thanh toán:
```
o Thanh toán khi nhận hàng (COD)
```
o Chuyển khoản ngân hàng
o Ví MoMo
• Nhấn "Đặt hàng" → gửi POST /api/orders với OrderRequest
```
(bao gồm danh sách sách, thông tin người nhận, tổng tiền,
```
```
phương thức thanh toán).
```
• Backend lưu đơn hàng vào bảng orders và order_items, trạng
thái ban đầu là "PENDING".
• Đồng thời, backend gửi email xác nhận đơn hàng bất đồng bộ
```
đến email người nhận (sử dụng MailHog trong môi trường phát
```
```
triển).
```
• Sau khi đặt hàng thành công, giỏ hàng được xóa và người dùng
được chuyển đến màn hình thông báo thành công hoặc lịch sử
đơn hàng.
9.2.13. Xem lịch sử đơn hàng
• Người dùng truy cập màn hình "Tài khoản" → "Đơn hàng của
tôi".
• Danh sách đơn hàng được phân theo trạng thái: Chờ xác nhận,
Chờ lấy hàng, Đang giao hàng, Hoàn tất.
```
• Gọi GET /api/orders/user/{userId} để lấy toàn bộ đơn hàng của
```
người dùng, sau đó lọc theo trạng thái ở client.
• Mỗi đơn hàng hiển thị mã đơn, tổng tiền, thời gian đặt, trạng
thái hiện tại.
187
```
• Nhấn vào một đơn hàng để xem chi tiết (danh sách sách, thông
```
```
tin giao hàng, lịch sử cập nhật trạng thái).
```
9.2.14. Nhận các thông báo hệ thống
• Hệ thống hiển thị các thông báo như:
```
• Ưu đãi đặc biệt (giảm giá sách mới)
```
• Đơn hàng đã được xác nhận
• Đơn hàng đã giao thành công
```
• Thông báo được lấy từ API (sau này tích hợp Firebase Cloud
```
```
Messaging) hoặc lưu cục bộ.
```
• Người dùng có thể đánh dấu tất cả thông báo đã đọc.
9.3. Công nghệ sử dụng
9.3.1. Framework và môi trường runtime
```
• Frontend (Android):
```
• Kotlin1.9+
• Ngôn ngữ lập trình chính, tận dụng các tính năng hiện đại như
Coroutines, Data Class, Sealed Class, Extension Function, Null
Safety.
• Jetpack Compose 2024.01.00
• Framework UI khai báo của Google, thay thế XML truyền thống,
Cho phép xây dựng bằng mã Kotlin
```
• Android SDK (API 24 – 34)
```
```
• Hỗ trợ đa nền tảng thiết bị từ Android 7.0 (Nougat) trở lên.
```
```
Backend:
```
• Spring Boot 3.2.x
• Framework chính cho REST API, tích hợp Spring Security,
Spring Data JPA, Spring Mall.
• Java 17
• Ngôn ngữ nền tảng chạy trên JVM.
• MySQL 8.0
188
• Hệ quản trị cơ sở dữ liệu quan hệ.
9.3.2. Xác thực và quản lý phiên đăng nhập
```
• JWT (JSON Web Token)
```
• Tự phát hành và kiểm tra Token bằng thư viện jjwt.
```
• Token được lưu trên client (SharedPreferences) và gửi qua header
```
```
Authorization : Beaer <token>.
```
• Spring Security
• Cấu hình bảo mật, mã hoá mật khẩu bằng
BCryptPasswordEncoder, vô hiệu hoá CSRF, chuyển sang cơ chế
```
Stateless (SessionCreationPolicy.STATELESS).
```
• JwtAuthenticationFilter
• Bộ lọc tuỳ chỉnh các trích xuất và xác thực token từ mỗi request.
9.3.3. HTTP và API
```
Frontend:
```
• Retrofit 2.9
• HTTP client type-safe.
• Chuyển đổi API thành Interface Kotlin.
• OkHttp 4.12
• Xử lý mạng, hỗ trợ interceptor để tự động thêm token vào header.
• GsonConvertorFactory
• Chuyển đổi JSON thành đối tượng Kotlin.
```
Backend:
```
```
• RestTemplate (hoặc WebClient)
```
• Gọi sang Google Book API.
• Spring Data JPA
• Truy xuất và thao tác với MySQL thông qua repository.
```
9.3.4. UI và thư viện giao diện (Frontend)
```
```
• Marterial Design 3 (androidx.compose.marterial3)
```
• Bộ component chuẩn của Google
189
• Cung cấp các thành phần như Button, TextField, Card, Scaffold,
BottomNavigation, LazyColumn, LazyVertivalGrid.
• Coil 2.6
• Thư viện tải ảnh dành riêng cho Compose, hỗ trợ cache và
placeholder.
```
• Accompanist (optional)
```
• Hỗ trợ hệ thống màu động, system UI controller.
```
9.3.5. State Management và UX Helpers (Frontend)
```
• StateFlow / MutableStateFlow
• Quản lý trạng thái dữ liệu trong ViewModel, kết hợp
```
collectAsState() trong Compose.
```
```
• Coroutines (kotlinx.couroutines 1.7)
```
• Xử lý bất đồng bộ.
• Sử dụng viewModelScope, launch, async, withContext.
```
• LiveData (một số module cũ)
```
• Dùng kết hợp nếu cần tương thích.
9.3.6. Dependency Injection
```
• Hilt (Dagger Hilt 2.48)
```
• Frameworkd DI chính thức của Google dành cho Android, tích
```
hợp sẵn với ViewModel (@HiltViewModel), Activity
```
```
(@AndroidEntryPoint), và các module tuỳ chỉnh (@Module,
```
```
@InstallIn).
```
Các module chính:
```
• NetworkModule (cung cấp Retrofit, API Service).
```
```
• RepositoryModule (cung cấp BookRepository,
```
```
OrderRepository).
```
```
• DatabaseModule (cung cấp Room Database - phát triển sau).
```
9.3.7. Styling và công cụ Build
```
• Không sử dụng CSS (Do là Android)
```
190
• Thay vào đó, Compose sử dụng các modifier như
```
Modifier.padding(), Modifier.fillMaxWidth(), cùng hệ thống
```
MarterialTheme để quản lý màu sắc, typography, shape.
```
• Gradle (Kotlin DSL)
```
• Công cụ build chính, cấu hình dependencies, plugins, signing
config.
```
• Android Studio Hedgehog (2023.1.1)
```
• IDE chính thức, hỗ trợ Compose Preview, Layout Inspector,
debug.
9.3.8. Linting và kiểu dữ liệu
```
• Kotlin (ngôn ngữ)
```
• Có sẵn type interference, null safety, data class, sealed class.
• Ktlint / Detekt
```
• Công cụ kiểm tra code style và chất lượng mã nguồn (có thể bổ
```
```
sung).
```
9.3.9. Công cụ môi trường và quản lý gói
```
• Gradle (8.0+)
```
• Quản lý thư viện, build APK/AAB.
• Git + Github
• Quản lý phiên bản mã ngồn.
• Postman
• Kiểm thử API backend trong quá trình phát triển.
• Mailhog
• Công cụ giả lập SMTP server để nhận email xác nhận đơn hàng
trong môi trường phát triển.
9.3.10. Kiến trúc và mô hình tổ chức mã nguồn
```
Dự án áp dụng kiến trúc MVVN (Model – View – ViewModel) kết hợp với
```
Repository Pattern và Clean Architecture ở mức cơ bản:
```
• data/: Chứa các model (entity), DTO, API Service (Retrofit),
```
repository.
191
```
• ui/: Chứa các composable (view) tương ứng với từng màn hình.
```
• viewmodel/: Chứa các ViewModel quản lý state và logic gọi
repository.
• di/: Chứa các Hilt module cung cấp dependencies.
• utils/: Các extension funtions, constants, helper classes.
9.4. Thiết kế kiến trúc hệ thống
9.4.1. Kiến trúc tổng thể hệ thống
Tổng quan kiến trúc: Hệ thống BookVerse được xây dựng theo mô
```
hình Client – Server với kiến trúc phân tầng (layered architecture) rõ
```
ràng. Toàn bộ ứng dụng được chia thành các thành phần độc lập, có
trách nhiệm riêng, giúp dễ bảo trì, mở rộng và kiểm thử.
1. Tầng Presentation (Giao diện người dùng)
   Đóng vai trò là giao diện người dùng.
```
Công nghệ: Jetpack Compose (Material 3).
```
Chịu trách nhiệm:
• Hiển thị giao diện dựa trên state từ ViewModel.
```
• Gửi hành động người dùng (click, nhập liệu, submit) đến
```
ViewModel.
• Không chứa logic dịch vụ, không gọi trực tiếp Repository hay
API.
2. Tầng ViewModel (Logic giao diện và quản lý state)
```
Công nghệ: ViewModel (AndroidX), StateFlow/MutableStateFlow,
```
mutableStateOf, sealed class UiState.
Chịu trách nhiệm:
```
• Lưu trữ và cập nhật UI state (dùng StateFlow hoặc
```
```
mutableStateOf).
```
• Xử lý các tác vụ bất đồng bộ bằng viewModelScope.launch.
• Gọi Repository để lấy hoặc gửi dữ liệu.
```
• Chuyển đổi kết quả từ Repository (thành công/thất bại) thành UI
```
```
state tương ứng (Success / Error).
```
192
3. Tầng Repository (Trung gian dữ liệu)
   Công nghệ: Kotlin classes với suspend fun, Result pattern.
   Các Repository:
   • BookRepository – gọi GoogleBooksApiService, ánh xạ DTO →
   Model.
   • UserRepository – gọi ApiService cho login, register, profile,
   change password.
   • OrderRepository – gọi ApiService tạo đơn hàng, lấy lịch sử đơn
   hàng.
   Trách nhiệm:
```
• Quyết định nguồn dữ liệu (local cache hay remote). Hiện tại chủ
```
yếu remote.
• Xử lý lỗi mạng và chuyển thành Result.failure với thông báo thân
thiện.
• Không chứa logic UI hay ViewModel.
4. Tầng DataSource (Nguồn dữ liệu)
   a. Remote Data Source (API)
   Retrofit với hai service:
```
• ApiService – giao tiếp với backend Spring Boot (base URL linh
```
```
hoạt).
```
• GoogleBooksApiService – giao tiếp trực tiếp với Google Books
```
API (có interceptor thêm API key).
```
• OkHttpClient: cấu hình timeout, logging interceptor.
• TokenManager: lưu JWT vào DataStore, tự động đọc token để gắn
```
vào header (qua Bearer). Tuy nhiên trong code mẫu, việc thêm
```
header được thực hiện thủ công trong Repository khi gọi API.
b. Local Data Source
• Preferences DataStore: lưu token, userId, username. Các flow
token, userId, username cho phép đọc bất đồng bộ.
193
• TokenManager là wrapper, cung cấp suspend functions
```
saveToken(), clearAll(), v.v.
```
```
• Cart hiện tại chỉ lưu trong CartViewModel (mutableStateListOf),
```
không lưu xuống local – có thể mở rộng với Room trong tương
lai.
5. Tầng Backend (Spring Boot)
```
• Controller: Nhận request từ client, xác thực JWT (trừ các
```
```
endpoint public như login, register), gọi Service.
```
```
• Service: Xử lý logic nghiệp vụ (mã hóa mật khẩu, tạo đơn hàng,
```
```
gửi email, gọi Google Books API).
```
```
• Repository (Spring Data JPA): Tương tác với MySQL (users,
```
```
orders, order_items, reviews).
```
```
• Security: JwtTokenProvider (tạo và validate token),
```
```
JwtAuthenticationFilter (lọc request, set authentication),
```
```
CustomUserDetailsService (load user từ DB), SecurityConfig
```
```
(cấu hình CORS, session stateless).
```
• EmailService: gửi email xác nhận đơn hàng bất đồng bộ
```
(@Async).
```
```
Luồng hoạt động điển hình (Xem danh mục sách)
```
• Người dùng nhấn vào một danh mục trên CategoryScreen.
• Navigation chuyển đến CategoryDetailScreen với tham số index
→ lấy Category từ Category.all.
• CategoryDetailScreen gọi
```
CategoryViewModel.loadBooks(category.queryKeyword).
```
• CategoryViewModel cập nhật _uiState.value = UiState.Loading,
sau đó viewModelScope.launch gọi
```
repository.getBooksResult(query).
```
• BookRepository gọi
```
GoogleBooksApiService.searchBooks(query) (suspend).
```
```
• GoogleBooksApiService (Retrofit) thực hiện HTTP GET đến
```
```
https://www.googleapis.com/books/v1/volumes?q=...&key=....
```
194
• Response trả về → Repository chuyển DTO thành Model
```
(toDomainModel()), bọc trong Result.success hoặc
```
Result.failure.
• CategoryViewModel nhận kết quả, cập nhật _uiState.value =
```
UiState.Success(books) hoặc UiState.Error(message).
```
```
• CategoryDetailScreen collectAsStateWithLifecycle() lắng nghe
```
uiState. Khi state thay đổi, Compose tự động recompose:
• Nếu Loading → hiển thị CircularProgressIndicator.
• Nếu Success → hiển thị danh sách sách qua LazyVerticalGrid và
BookCard.
• Nếu Error → hiển thị thông báo lỗi và nút "Thử lại".
9.4.2. Thiết kế cơ sở dữ liệu
Hình 9.1: Sơ đồ cơ sở dữ liệu
195
9.4.3. Thiết kế các Module chức năng
Hệ thống BookVerse được chia thành các module chức năng độc lập,
mỗi module đảm nhận một nghiệp vụ cụ thể. Các module được tổ chức
```
theo cả hai phía client (Android) và server (Spring Boot), đảm bảo tính
```
tách biệt, dễ bảo trì và mở rộng.
```
Module xác thực (Authentication)
```
Mục tiêu: Cung cấp cơ chế đăng ký, đăng nhập, quản lý phiên làm việc
bằng JWT.
Chức năng chính:
```
• Đăng ký tài khoản mới (username, password, email, họ tên, số
```
```
điện thoại).
```
• Đăng nhập, nhận JWT token.
• Lưu token vào DataStore, tự động đính kèm vào các request sau.
```
• Kiểm tra trạng thái đăng nhập (Flow isLoggedIn).
```
```
• Đăng xuất (xóa token).
```
Thành phần:
• Client:
```
• AuthViewModel: quản lý AuthState (Idle, Loading, Success,
```
```
LoginSuccess, Error). Các method login(), register(),
```
```
loginWithSocial().
```
```
• UserRepository: gọi ApiService.login(),
```
```
ApiService.registerUser().
```
• TokenManager: lưu/đọc token, userId, username từ DataStore.
• LoginScreen, RegisterScreen: giao diện nhập liệu, hiển thị lỗi,
điều hướng.
• Backend:
• AuthController: endpoints /api/auth/login, /api/auth/register.
```
• JwtTokenProvider: tạo và validate JWT (HS256, thời hạn 7
```
```
ngày).
```
• CustomUserDetailsService: load user từ database theo username.
196
• SecurityConfig: cấu hình bảo mật, mã hóa BCrypt, session
stateless.
```
API (ví dụ):
```
• POST /api/auth/register — Đăng ký tài khoản mới.
• POST /api/auth/login — Đăng nhập, nhận JWT token.
Luồng xử lý:
• Người dùng nhập thông tin tại RegisterScreen → gọi
```
AuthViewModel.register().
```
```
• UserRepository.register() gửi POST request → backend lưu user
```
```
(BCrypt password).
```
• Thành công → chuyển sang màn hình đăng nhập.
• Đăng nhập → gửi LoginRequest → backend xác thực, trả về
JWT.
• Client lưu token, userId, username vào DataStore, cập nhật
AuthState.LoginSuccess.
```
• Điều hướng về màn hình trước đó (returnRoute).
```
```
Module người dùng (User)
```
Mục tiêu: Quản lý thông tin cá nhân, địa chỉ, đổi mật khẩu.
Chức năng chính:
```
• Xem thông tin cá nhân (fullName, email, phone, address,
```
```
province, district).
```
• Cập nhật thông tin cá nhân.
```
• Đổi mật khẩu (yêu cầu mật khẩu cũ, mật khẩu mới, xác nhận).
```
• Tự động pre‑fill thông tin giao hàng từ profile khi vào Checkout.
Thành phần:
• Client:
197
• AccountViewModel: quản lý userProfile, editFullName,
```
editEmail, …, các method loadProfile(), saveProfile(),
```
```
changePassword(), applyShippingInfo().
```
```
• UserRepository: gọi ApiService.getUserProfile(), updateUser(),
```
```
changePassword().
```
• ProfileScreen, ChangePasswordScreen, SettingsScreen.
• Backend:
```
• UserController: endpoints /api/users/{id} (GET, PUT),
```
```
/api/users/change-password (POST).
```
```
• UserService, UserRepository (JPA).
```
```
API:
```
```
• GET /api/users/{id} — Lấy thông tin người dùng theo ID.
```
```
• PUT /api/users/{id} — Cập nhật thông tin người dùng.
```
• POST /api/users/change-password — Đổi mật khẩu.
Luồng xử lý:
```
• AccountScreen gọi loadProfile() → lấy userId từ TokenManager
```
```
→ GET /api/users/{id} → hiển thị.
```
• Người dùng sửa thông tin tại ProfileScreen, nhấn “Lưu thay đổi”
```
→ gọi saveProfile() → PUT request → cập nhật database.
```
• Đổi mật khẩu: nhập oldPassword, newPassword → gọi
```
changePassword() → backend kiểm tra oldPassword, mã hóa mới
```
và lưu.
```
Module Sách & Tích hợp Google Books (Book)
```
Mục tiêu: Cung cấp dữ liệu sách từ Google Books API, hỗ trợ tìm kiếm,
xem chi tiết, lọc theo danh mục.
Chức năng chính:
198
```
• Tìm kiếm sách theo từ khóa (gọi trực tiếp Google Books API từ
```
```
client).
```
```
• Lấy danh sách sách theo danh mục (subject).
```
• Lấy chi tiết sách theo volumeId.
• Ánh xạ dữ liệu JSON từ Google Books thành domain model Book
```
(xử lý null, giá, ảnh, mô tả).
```
```
• Hỗ trợ phân loại danh mục sách (12 danh mục với từ khóa tìm
```
```
kiếm tương ứng).
```
Thành phần:
• Client:
```
• BookRepository: gọiGoogleBooksApiService.searchBooks(),
```
```
getBookById(), chuyển DTO → Model.
```
```
• GoogleBooksApiService: interface Retrofit (GET volumes?q=...,
```
```
volumes/{volumeId}).
```
• GoogleBooksClient: singleton tạo OkHttpClient với interceptor
thêm API key.
• HomeViewModel, CategoryViewModel,
BookDetailViewModel, SearchViewModel.
```
• Category data class: chứa name (tiếng Việt) và queryKeyword (từ
```
```
khóa tìm kiếm).
```
• Backend:
```
• BookController (có thể proxy – trong code mẫu backend có
```
BookController với endpoint /api/books/search gọi Google
```
Books API). Thực tế client gọi trực tiếp Google, không qua
```
backend.
```
API (Google Books):
```
• GET https://www.googleapis.com/books/v1/volumes — Tìm
kiếm sách theo từ khóa
• GET
```
https://www.googleapis.com/books/v1/volumes/{volumeId} —
```
Lấy chi tiết một cuốn sách theo ID
199
Luồng xử lý:
```
• CategoryViewModel.loadBooks(category.queryKeyword) →
```
```
gọi bookRepository.getBooksResult(query).
```
• BookRepository gọi
```
GoogleBooksApiService.searchBooks(query, maxResults=20).
```
• Retrofit thực hiện GET, trả về JSON → chuyển thành
GoogleBookResponse.
```
• Duyệt items, gọi extension function toDomainModel() để tạo
```
```
Book (xử lý null title, author, imageUrl, description, price).
```
```
• Trả về Result.success(books) hoặc Result.failure.
```
```
• CategoryViewModel cập nhật UiState.Success(books) hoặc
```
UiState.Error.
```
Module Giỏ Hàng (Cart) — client-side
```
Chức năng chính:
```
• Thêm sách vào giỏ (tăng số lượng nếu đã có).
```
• Tăng/giảm số lượng, xóa sách khỏi giỏ.
```
• Tính tổng tiền tạm tính, phí vận chuyển (cố định 20.000đ), áp
```
```
dụng mã giảm giá (SALE10, GIAM17, FREESHIP).
```
```
• Lưu giỏ hàng trong CartViewModel (mutableStateListOf), không
```
lưu xuống database.
Thành phần:
• CartViewModel: chứa cartItems: SnapshotStateList<CartItem>,
```
các method addBook(), increaseQuantity(), decreaseQuantity(),
```
```
removeItem(), applyDiscount(), clearCart().
```
• CartScreen: hiển thị danh sách, OrderSummaryCard,
CouponRow.
• CartItem: data class chứa book và quantity.
200
Luồng xử lý:
• Người dùng nhấn “Thêm vào giỏ” →
```
CartViewModel.addBook(book) kiểm tra sách tồn tại, cập nhật
```
số lượng.
```
• CartScreen lắng nghe cartItems qua collectAsState(), hiển thị
```
danh sách.
```
• Người dùng nhập mã giảm giá → applyDiscount() tính
```
discountAmount dựa trên subtotal.
• Nút “Thanh toán” → điều hướng sang CheckoutScreen, truyền
cartViewModel để lấy dữ liệu.
```
Module Đơn hàng (Order)
```
Mục tiêu: Xử lý đặt hàng, lưu đơn hàng vào database, gửi email xác
nhận, hiển thị lịch sử đơn hàng.
Chức năng chính:
```
• Tạo đơn hàng (gửi thông tin giỏ hàng, thông tin giao hàng,
```
```
phương thức thanh toán).
```
```
• Lấy danh sách đơn hàng của người dùng (có phân loại trạng thái).
```
```
• Hiển thị chi tiết đơn hàng (mã đơn, trạng thái, người nhận, ngày
```
```
đặt, tổng tiền, danh sách sách).
```
Thành phần:
• Client:
```
• OrderRepository: gọi ApiService.createOrder(),
```
```
getOrderHistory().
```
• CheckoutViewModel: quản lý paymentMethod, isLoading,
```
orderSuccess, errorMessage. Phương thức placeOrder().
```
```
• CheckoutScreen: form nhập thông tin giao hàng (dùng
```
```
rememberSaveable), gọi placeOrder().
```
201
• OrderHistoryScreen: hiển thị danh sách OrderResponse từ
AccountViewModel.orderHistory.
```
• AccountViewModel: loadOrderHistory() gọi
```
```
orderRepository.getOrderHistory().
```
• Backend:
```
• OrderController: endpoints /api/orders (POST),
```
```
/api/orders/user/{userId} (GET).
```
• OrderService: tạo Order và OrderDetail, gửi email bất đồng bộ.
```
• OrderRepository, OrderDetailRepository (JPA).
```
• EmailService: @Async gửi email qua MailHog.
```
API:
```
• POST /api/orders/ —Tạo đơn hàng mới
```
• GET /api/orders/user/{userId} — Lấy lịch sử đợn hàng của người
```
dùng
Luồng xử lý:
• Người dùng điền form tại CheckoutScreen, nhấn “Đặt hàng”.
```
• CheckoutViewModel.placeOrder() kiểm tra dữ liệu, tạo
```
OrderRequest từ giỏ hàng và form.
```
• Gọi orderRepository.createOrder(request) →
```
```
ApiService.createOrder() với Bearer token.
```
• Backend lưu vào database, gửi email, trả về thành công.
```
• Client hiển thị AlertDialog, gọi applyShippingInfo() để lưu thông
```
tin vào profile, xóa giỏ hàng, chuyển về trang chủ.
• Tại OrderHistoryScreen,
```
AccountViewModel.loadOrderHistory() gọi API và hiển thị danh
```
sách.
```
Module Đánh giá (Review)
```
```
Mục tiêu: Cho phép người dùng đánh giá sách (số sao, bình luận) và
```
xem đánh giá của cộng đồng.
202
Chức năng chính:
```
• Gửi đánh giá cho một cuốn sách (yêu cầu đăng nhập).
```
• Lấy danh sách đánh giá theo bookId.
• Lấy điểm đánh giá trung bình.
• Hiển thị biểu đồ phân bố sao và danh sách bình luận.
Thành phần:
• Client:
```
• ReviewService (trong data/repo hoặc trực tiếp gọi ApiService –
```
```
code mẫu có ApiService.addReview(), getAverageRating()).
```
```
• BookReviewsSection: composable hiển thị đánh giá mock (chưa
```
```
tích hợp API thực sự trong code mẫu nhưng có sẵn interface).
```
```
• ApiService: addReview(), getAverageRating().
```
• Backend:
```
• ReviewController: endpoints /api/reviews (POST),
```
```
/api/reviews/book/{bookId} (GET),
```
```
/api/reviews/book/{bookId}/average-rating (GET).
```
```
• ReviewService, ReviewRepository (JPA).
```
```
• Entity Review: bookId, user (ManyToOne), rating, comment,
```
createdAt.
```
API:
```
• POST /api/review — Thêm đánh giá cho sách.
```
• GET /api/review/book/{bookId} — Lấy danh sách đánh giá theo
```
sách.
```
• GET /api/review/book/{bookId}/average-rating — Lấy điểm
```
đánh giá trung bình.
```
Luồng xử lý (dự kiến):
```
• Người dùng nhập rating và comment tại BookDetailScreen, nhấn
“Gửi”.
203
```
• Gọi ApiService.addReview() với token.
```
• Backend lưu review, gắn với user hiện tại.
• Sau khi gửi thành công, gọi lại API lấy danh sách đánh giá để cập
nhật giao diện.
```
Module Tìm kiếm (Search)
```
Mục tiêu: Cho phép người dùng tìm kiếm sách nhanh chóng qua từ
khóa.
Chức năng chính:
• Hiển thị thanh tìm kiếm trên TopBar của các màn hình.
• Chuyển đến SearchScreen hoặc BookSearchResultsScreen với từ
khóa.
• Gọi Google Books API và hiển thị kết quả dạng lưới.
```
• Hỗ trợ xu hướng tìm kiếm và danh mục phổ biến (giao diện tĩnh).
```
Thành phần:
```
• SearchViewModel: gọi BookRepository.getBooks(query).
```
• SearchScreen: hiển thị SearchTopBar, TrendingSearchesSection,
PopularCategoriesSection.
• BookSearchResultsScreen: hiển thị danh sách kết quả qua
LazyVerticalGrid và BookCard.
• SearchTopBar: composable tái sử dụng cho thanh tìm kiếm trên
nhiều màn hình.
Luồng xử lý:
• Người dùng nhấn vào biểu tượng kính lúp hoặc thanh SearchBar
trên HomeScreen.
```
• Điều hướng đến SearchScreen (hoặc trực tiếp đến
```
```
SearchResultsScreen).
```
• Nhập từ khóa, nhấn tìm kiếm → gọi
```
SearchViewModel.searchBooks(query).
```
204
```
• SearchViewModel gọi bookRepository.getBooks(query) → hiển
```
thị kết quả.
• Người dùng nhấn vào một BookCard → điều hướng đến
BookDetailScreen.
9.4.4. Thiết kế API
CHƯƠNG 10: TRIỂN KHAI VÀ KẾT QUẢ
10.1. Cấu trúc thư mục dự án
Dự án BookVerse được tổ chức theo kiến trúc phân tầng rõ ràng, tuân thủ các
nguyên tắc của MVVM và Clean Architecture. Toàn bộ mã nguồn Kotlin được đặt
trong thư mục src/main/java/com/example/bookstore/, tách biệt với các tệp cấu hình
và tài nguyên. Dưới đây là sơ đồ tổng thể cấu trúc thư mục của ứng dụng.
HÌnh 10.1: Cấu trúc thư mục dự án
205
10.1.1. Thư mục data/
HÌnh 10.2: Thư mục data/
• Chức năng: quản lý toàn bộ dữ liệu của ứng dụng, bao gồm gọi
```
API, chuyển đổi dữ liệu (DTO), lưu trữ cục bộ và định nghĩa các
```
model.
• Chi tiết
• api/: Chứa các interface và client Retrofit để giao tiếp với
backend và Google Books API.
• dto/: Data Transfer Objects – các lớp trung gian ánh xạ JSON từ
API.
• local/: Lưu trữ cục bộ.
• model/: Domain model thuần túy của ứng dụng.
• repo/: Repository pattern – trung gian giữa ViewModel và nguồn
dữ liệu.
• Ý nghĩa: tập trung toàn bộ logic truy xuất dữ liệu từ nhiều nguồn
```
(API, local). Việc tách riêng dto, model, repo giúp việc thay đổi
```
```
nguồn dữ liệu (ví dụ từ Google Books API sang một API khác)
```
không ảnh hưởng đến các tầng bên trên. Repository đóng vai trò
trung gian, che giấu chi tiết nguồn dữ liệu.
10.1.2. Thư mục di/
HÌnh 10.3: Thư mục di/
206
• Chức năng: Chứa các module Hilt để cung cấp dependency
injection.
• Ví dụ: TokenManager, GoogleBooksApiService, BookRepository, ApiService.
```
• Ý nghĩa: di/ (Hilt modules) quản lý dependency injection tập
```
trung, giúp giảm mã nguồn boilerplate, tăng khả năng kiểm thử
```
(dễ dàng thay thế dependency thật bằng mock), và đảm bảo các
```
đối tượng như TokenManager, ApiService được khởi tạo đúng
cách với vòng đời phù hợp.
10.1.3. Thư mục ui/
HÌnh 10.4: Thư mục ui/
```
• Chức năng: Tập trung toàn bộ giao diện người dùng (Jetpack
```
```
Compose) và các thành phần liên quan.
```
• Chi tiết
• components/: Các composable tái sử dụng.
• screens/: Các màn hình chính của ứng dụng.
• state/: Quản lý trạng thái chung.
```
• theme/: Giao diện chủ đề (theming).
```
```
• Ý nghĩa: ui/ được chia nhỏ thành components (các composable
```
```
tái sử dụng), screens (các màn hình chính), state (các sealed class
```
```
quản lý trạng thái), theme (màu sắc, kiểu dáng). Cách tổ chức này
```
giúp tái sử dụng linh hoạt các thành phần giao diện, dễ dàng thay
```
đổi giao diện tổng thể (theme) mà không ảnh hưởng đến logic
```
nghiệp vụ.
10.1.4. Thư mục viewmodel/
207
HÌnh 10.5: Thư mục viewmode/
• Chức năng: Chứa tất cả các ViewModel, mỗi ViewModel quản
lý state và logic cho một hoặc nhiều màn hình.
• Ví dụ: AuthState, mutableStateListOf, UiState<List<Book>>,
OrderRepository,...
• Ý nghĩa: chứa tất cả ViewModel – nơi chứa logic giao diện và
```
quản lý state. Việc tách ViewModel riêng giúp UI (Compose)
```
hoàn toàn thụ động, chỉ hiển thị theo state, dễ dàng viết unit test
cho logic mà không cần đến màn hình.
10.1.5. Thư mục utils/
HÌnh 10.6: Thư mục utils/
```
• Chức năng: Chứa các hàm tiện ích mở rộng (extension functions)
```
và các helper.
```
• Ví dụ: Double.toVnd(), String?.orDefault(),
```
```
Book.displayPrice(),...
```
• Ý nghĩa: chứa các extension functions giúp mở rộng chức năng
```
cho các kiểu có sẵn (ví dụ Double.toVnd(), String?.orDefault()),
```
làm mã nguồn trở nên tự nhiên và dễ đọc hơn.
10.1.6. Các tệp tin gốc
208
Hình 10.7: Các têp tin gốc trong thư mục dự án
• Chức năng:
• BookstoreApplication.kt : Lớp Application, được đánh dấu
@HiltAndroidApp để khởi tạo Hilt.
• MainActivity.kt : Activity chính, đánh dấu @AndroidEntryPoint,
```
gọi setContent { BookStoreTheme { MainScreen() } }
```
• Ý nghĩa: điểm khởi đầu của ứng dụng, nơi kích hoạt Hilt và
Compose.
10.2. Hướng dẫn cài đặt dự án
```
Dự án gồm 2 phần độc lập: Frontend (Android – Android Studio) và Backend
```
```
(Spring Boot – IntelliJ IDEA Community). Cả hai cần chạy đồng thời và kết
```
```
nối qua mạng nội bộ (WiFi cùng mạng).
```
Yêu cầu hệ thống
Công cụ Phiên bản tối thiểu Ghi chú
```
Android Studio Hedgehog (2023.1.1) trở
```
lên
Chạy frontend
IntelliJ IDEA
Community
2023.x trở lên Chạy backend
Java JDK 17 Backend Spring Boot
Docker Desktop Bất kỳ Chạy MySQL+Mailhog
```
(thay thế cài MySQL thủ
```
```
công)
```
```
Android SDK API 26 (Android 8.0) minSdk của ứng dụng
```
Git Bất kỳ Clone source code
209
Bước 1 – Clone source code
Dự án được chia làm 2 repository riêng biệt. Clone cả hai về cùng một thư
mục trên máy tính.
```
Clone Frontend (Android):
```
git clone https://github.com/HaoPhong11/BookStore.git
```
Clone Backend (Spring Boot):
```
git clone https://github.com/HaoPhong11/bookstore-backend.git
Sau khi clone, cấu trúc thư mục sẽ là:
Hình 10.8: Cấu trúc thư mục sau khi clone cả 2 repo
Bước 2 – Khởi động Database bằng Docker
Dự án dùng Docker Compose để khởi động MySQL và Mailhog — không
cần cài MySQL thủ công.
Cài đặt Docker Desktop
Tải và cài Docker Desktop nếu chưa có. Sau khi cài, khởi động
```
Docker Desktop và đảm bảo Docker đang chạy (icon Docker trên
```
```
taskbar sáng).
```
Chạy docker-compose
Mở Terminal/Command Prompt, di chuyển vào thư mục backend rồi chạy:
cd bookstore-backend
docker-compose up -d
210
Lệnh này sẽ khởi động 2 container:
Hình 10.9: 2 container đang ở trạng thái Up
Mở Backend bằng IntelliJ IDEA Community
1. Mở IntelliJ IDEA Community.
2. Chọn File → Open và chọn thư mục bookstore-backend/.
3. IntelliJ sẽ tự động nhận diện dự án Maven và tải dependencies.
   Cấu hình application.properties
   Mở file bookstore-backend/src/main/resources/application.properties và
   kiểm tra thông tin kết nối khớp với Docker:
   Hình 10.10: Phần kết nối docker trong file application.properties
   Chạy Backend
1. src/main/java/com/example/bookstore_db/BookstoreDbApplication.j
   ava
2. Bấm nút Run (tam giác xanh) ở góc trên cùng bên phải, hoặc nhấn
   Shift + F10.
3. Backend khởi động thành công khi log hiển thị:Started
   BookstoreDbApplication in X.XXX seconds
   211
   Hình 10.11: Log backend khởi động thành công tại cổng 8081
   Backend sẽ chạy tại địa chỉ: http://localhost:8081
   Bước 3 – Cài đặt và chạy Frontend
   Mở Frontend bằng Android Studio
1. Mở Android Studio.
2. Chọn File → Open và chọn thư mục BookStore/.
3. Android Studio sẽ tự động sync Gradle. Chờ đến khi thanh trạng thái
   phía dưới không còn hiển thị tiến trình.
   Lấy IP LAN của máy tính
   Điện thoại và máy tính phải cùng mạng WiFi. Lấy IP LAN của máy
   tính:
   ● Windows: Mở Command Prompt → gõ ipconfig → tìm IPv4
```
Address (thường dạng 192.168.x.x)
```
● macOS/Linux: Mở Terminal → gõ ifconfig → tìm địa chỉ
inet
212
Cấu hình địa chỉ Backend
Mở file
BookStore/app/src/main/java/com/example/bookstore/data/api/Ret
rofitClient.kt
Hình 10.12: Cấu hình RetrofitClient.kt — đổi IP theo mạng WiFi hiện tại
Whitelist IP trong Network Security Config
Android 9+ chặn HTTP theo mặc định. Mở file:
BookStore/app/src/main/res/xml/network_secur
ity_config.xml
Thêm IP LAN của máy tính vào danh sách:
Hình 10.13: Thêm IP vào network_security_config.xml
```
Lưu ý: Mỗi khi IP máy tính thay đổi (đổi mạng WiFi hoặc khởi động lại
```
```
router), cần cập nhật lại cả hai chỗ: RetrofitClient.kt và
```
network_security_config.xml.
Bước 4 – Chạy ứng dụng
Chọn thiết bị
Trong Android Studio, chọn thiết bị chạy ứng dụng:
213
Hình 10.14: Chọn thiết bị trong dropdown Device Manager của Android
Studio
Build và chạy
```
Bấm nút Run (tam giác xanh) hoặc nhấn Shift + F10 trong Android
```
Studio.
10.3. Demo sản phẩm
10.3.1. Màn hình Đăng ký
Kết quả đạt được: Màn hình đăng ký với validation client-side đầy đủ và
xử lý trạng thái bất đồng bộ qua Sealed Class AuthState.
RegisterScreen gồm sáu trường nhập liệu: Họ và tên, Tên đăng nhập,
Email, Số điện thoại, Mật khẩu, Xác nhận mật khẩu. Khi nhấn "Đăng ký", ứng
```
dụng validate toàn bộ form (định dạng email, độ dài số điện thoại, mật khẩu khớp
```
```
nhau). Nút bị vô hiệu hóa trong lúc gọi API để tránh gửi request trùng lặp; khi API
```
trả về, AuthState phân loại kết quả: thành công → chuyển sang màn hình đăng
nhập, thất bại → Toast thông báo lỗi và highlight trường tương ứng.
214
Hình 10.16: Giao diện màn hình Đăng ký
215
Hình 10.17: Thông báo lỗi validation
216
10.3.2. Màn hình Đăng nhập
Kết quả đạt được: Màn hình đăng nhập tự động bỏ qua nếu token JWT còn
hiệu lực, hỗ trợ điều hướng trả về đúng màn hình trước khi yêu cầu đăng nhập.
```
LoginScreen nhận tham số returnRoute (login/{returnRoute}) để sau khi
```
```
đăng nhập thành công đưa người dùng về đúng nơi (ví dụ cart, account). Khi mở
```
```
màn hình, ứng dụng kiểm tra token trong SharedPreferences; nếu còn hợp lệ, bỏ
```
qua form và chuyển thẳng đến returnRoute.
217
Hình 10.18: Giao diện màn hình Đăng nhập
218
10.3.3. Trang chủ
Kết quả đạt được: Trang chủ cuộn mượt mà với dữ liệu sách tải từ Google
Books API, hiển thị trạng thái loading và thông báo thêm giỏ hàng qua Snackbar.
HomeScreen dùng LazyColumn hiển thị nối
```
tiếp: HomeTopBar, SearchBar, PromoBanner, CategorySection (danh mục
```
```
ngang), và BookSection (sách nổi bật). Dữ liệu được HomeViewModel tải bất
```
```
đồng bộ qua Coroutines; trong lúc chờ, hiển thị CircularProgressIndicator. Khi
```
```
nhấn "Thêm vào giỏ", cartViewModel.addBook() được gọi và Snackbar xác
```
nhận ngay phía dưới.
219
Hình 10.19: Giao diện trang chủ — danh mục và banner
220
Hình 10.20: Giao diện trang chủ — danh sách sách nổi bật
221
10.3.4. Tìm kiếm và Chi tiết sách
Kết quả đạt được: Luồng tìm kiếm hai bước và màn hình chi tiết sách với
bottom bar hành động cố định.
```
SearchScreen: Hiển thị gợi ý xu hướng tìm kiếm (top 5, màu sắc phân hạng
```
```
bằng when) và 12 danh mục phổ biến theo lưới 2 cột (chunked(2)).
```
```
BookSearchResultsScreen: SearchViewModel gọi Google Books API và
```
```
hiển thị kết quả bằng LazyVerticalGrid(GridCells.Fixed(2)). Số lượng kết quả
```
được in ngay đầu danh sách.
```
BookDetailScreen: Nội dung cuộn qua LazyColumn (ảnh bìa, thông tin,
```
```
mô tả, thông số kỹ thuật, đánh giá). Bottom bar cố định gồm bộ chọn số lượng và
```
hai nút: Thêm vào giỏ và Mua ngay.
222
Hình 10.21: Giao diện màn hình Tìm kiếm
223
Hình 10.22: Kết quả tìm kiếm — lưới 2 cột
224
Hình 10.23: Giao diện Chi tiết sách 1
225
Hình 10.24: Giao diện Chi tiết sách 2
226
10.3.5. Giỏ hàng
Kết quả đạt được: Giỏ hàng với guard xác thực, tính toán đơn hàng theo
thời gian thực và hỗ trợ mã giảm giá.
```
CartScreen kiểm tra đăng nhập khi mở; nếu chưa đăng nhập, chuyển
```
```
đến login/cart. Mỗi sản phẩm hiển thị ảnh bìa (AsyncImage — Coil), tên, giá
```
```
(Double.toVnd()), bộ điều chỉnh số lượng và nút xóa. OrderSummaryCard tính
```
tạm tính, phí ship, giảm giá và tổng cộng tự động từ CartViewModel. Nút "Thanh
toán" điều hướng đến CheckoutScreen.
227
Hình 10.25: Giao diện Giỏ hàng
228
10.3.6. Thanh toán
Kết quả đạt được: Form thanh toán tự điền từ profile, tích hợp MoMo qua
Intent deeplink, và bảo toàn dữ liệu form khi xoay màn hình
bằng rememberSaveable.
CheckoutScreen dùng rememberSaveable cho tất cả biến state của form,
giúp dữ liệu không bị mất khi xoay màn hình. Form tự điền
từ accountViewModel .userProfile qua LaunchedEffect. Người dùng chọn
phương thức thanh toán qua RadioButton: COD hoặc MoMo. Với MoMo, ứng
```
dụng gọi API lấy deeplink và mở app MoMo bằng Intent(ACTION_VIEW); nếu
```
chưa cài, fallback sang trình duyệt.
229
Hình 10.26: Giao diện Thanh toán — form giao hàng
230
Hình 10.27: Chọn phương thức thanh toán
231
```
Hình 10.28: Giao diện thanh toán MoMo (sandbox)
```
232
10.3.7. Đơn hàng của tôi
Kết quả đạt được: Màn hình quản lý đơn hàng với tab lọc trạng thái, tự
động reload khi quay lại app và hỗ trợ hủy hoặc thanh toán lại.
OrderHistoryScreen dùng PrimaryScrollableTabRow với năm tab: Tất
cả, Chờ xác nhận, Đang xử lý, Đang giao, Đã hủy. Sau khi thanh toán MoMo và
quay lại app, DisposableEffect + LifecycleEventObserver phát
hiện ON_RESUME và tự động tải lại danh sách. Nếu không còn đơn PENDING,
tab tự chuyển sang "Đang xử lý". Đơn hàng PENDING có thể bấm để
mở AlertDialog với hai lựa chọn: Hủy đơn hoặc Thanh toán MoMo.
233
Hình 10.29: Tab Chờ xác nhận với đơn có thể bấm
234
Hình 10.30: Dialog tùy chọn — Hủy đơn / Thanh toán MoMo
235
PHẦN 4: TỔNG KẾT
CHƯƠNG 11: ĐÁNH GIÁ VÀ TỔNG KẾT
11.1. Tóm tắt kết quả đạt được
Báo cáo đã hoàn thành mục tiêu đề ra là nghiên cứu một cách hệ thống và toàn
diện về ngôn ngữ Kotlin, từ các khái niệm cơ bản đến ứng dụng thực tế xây dựng một
hệ thống bán sách trực tuyến hoàn chỉnh. Nhóm đã đạt được các kết quả cụ thể sau:
11.1.1. Về Lý thuyết:
• Đã trình bày tổng quan chi tiết về lịch sử hình thành, quá trình
```
phát triển qua các phiên bản của Kotlin (từ 1.0 đến 2.0+).
```
• Phân tích rõ hệ sinh thái phong phú của Kotlin bao gồm các thư
```
viện (Retrofit, Coil, Room), framework (Jetpack Compose, Hilt,
```
```
Spring Boot), công cụ hỗ trợ (Android Studio, Gradle KTS) và
```
cộng đồng phát triển mạnh mẽ.
• Khảo sát chi tiết cơ hội nghề nghiệp, nhu cầu tuyển dụng và mức
lương cho các vị tr liên quan đến Kotlin tại thị trường Việt Nam
và thế giới, từ Intern đến Tech Lead.
11.1.2. Về kỹ thuật:
• Đã đi sâu tìm hiểu và thực hành các khái niệm cốt lõi của ngôn ngữ
```
Kotlin: biến và kiểu dữ liệu (val/var, type inference), hàm (function,
```
```
default parameters, named arguments), lớp và đối tượng (class, data
```
```
class, inheritance), kiểm soát luồng (if, when, for).
```
```
• Nắm vững các tính năng nâng cao: Null Safety (safe call operator, Elvis
```
```
operator), Extension Functions, Higher-Order Functions và Lambda,
```
```
Sealed Class, Coroutines (suspend, launch, async, Dispatchers).
```
236
• Áp dụng thành công Jetpack Compose để xây dựng giao diện khai báo
với các thành phần: Column, Row, LazyColumn, LazyVerticalGrid,
```
Material Design 3 components (Button, TextField, Card, Scaffold,
```
```
BottomNavigation).
```
• Triển khai kiến trúc MVVM kết hợp Repository Pattern, sử dụng
StateFlow để quản lý trạng thái và Coroutines để xử lý bất đồng bộ.
• Tích hợp Hilt để quản lý dependency injection, giảm thiểu boilerplate
code và tăng khả năng kiểm thử.
11.1.3. Về thực hành:
• Xây dựng thành công backend REST API bằng Spring Boot với các
```
module: xác thực JWT, quản lý người dùng, quản lý đơn hàng, quản lý
```
đánh giá, tích hợp Google Books API.
• Thiết kế cơ sở dữ liệu MySQL với các bảng users, orders, order_items,
reviews, thiết lập quan hệ khóa ngoại phù hợp.
• Phát triển ứng dụng Android hoàn chỉnh với các màn hình: đăng
```
nhập/đăng ký, trang chủ (danh mục, sách nổi bật, sách mới), tìm kiếm và
```
lọc sách, chi tiết sách, giỏ hàng, thanh toán, lịch sử đơn hàng, thông báo,
tài khoản cá nhân.
• Tích hợp gửi email xác nhận đơn hàng bất đồng bộ qua JavaMailSender
và MailHog.
• Hoàn thiện các luồng chức năng chính: từ đăng ký → đăng nhập → tìm
kiếm sách → thêm vào giỏ → đặt hàng → thanh toán → xem lịch sử →
đánh giá sách.
11.2. Đánh giá ưu và nhược điểm của công nghệ
Qua quá trình tìm hiểu và thực hành xây dựng đồ án BookVerse, nhóm đưa ra
đánh giá về ưu và nhược điểm của ngôn ngữ Kotlin cũng như các công nghệ liên
quan như sau:
237
11.2.1. Ưu điểm:
• Cú pháp ngắn gọn, dễ đọc: Kotlin giảm đáng kể lượng boilerplate code
```
so với Java (không cần getter/setter, không cần new keyword, type
```
```
inference, data class tự động sinh equals(), hashCode(), toString()).
```
```
• Null Safety triệt để: Hệ thống kiểu phân biệt nullable (String?) và non-
```
```
nullable (String), loại bỏ gần như hoàn toàn lỗi NullPointerException
```
```
(NPE) ngay tại thời gian biên dịch, đặc biệt hữu ích khi xử lý dữ liệu từ
```
API.
• Coroutines mạnh mẽ: Lập trình bất đồng bộ trở nên đơn giản và dễ hiểu
với các từ khóa suspend, launch, async. Coroutines nhẹ hơn thread
truyền thống, hỗ trợ cấu trúc đồng thời an toàn, tránh memory leak nhờ
viewModelScope và lifecycleScope.
• Extension Functions: Cho phép mở rộng chức năng của các lớp có sẵn
```
(kể cả lớp từ thư viện) mà không cần kế thừa, giúp code trở nên tự nhiên
```
```
và tái sử dụng cao (ví dụ: Double.toVND(), String?.orDefault()).
```
```
• Sealed Class: Biểu diễn các trạng thái có giới hạn (Loading, Success,
```
```
Error) một cách an toàn, kết hợp với when đảm bảo xử lý exhaustive,
```
loại bỏ trạng thái không xác định.
• Interoperability hoàn hảo với Java: Kotlin có thể gọi Java và ngược lại,
cho phép sử dụng toàn bộ hệ sinh thái thư viện Java khổng lồ, dễ dàng
chuyển đổi dự án Java cũ sang Kotlin từng phần.
• Hỗ trợ mạnh mẽ từ Google: Kotlin là ngôn ngữ chính thức cho Android,
Jetpack Compose, Hilt, Room đều được tối ưu cho Kotlin, tài liệu phong
phú, cộng đồng lớn.
11.2.2. Nhược điểm:
• Thời gian biên dịch chậm hơn Java: Mặc dù đã được cải thiện với K2
```
Compiler (Kotlin 2.0), trong các dự án lớn, thời gian build có thể vẫn lâu
```
hơn so với Java thuần túy.
• Đường cong học tập với Coroutines và Flow: Người mới bắt đầu có thể
gặp khó khăn khi hiểu về structured concurrency, exception handling
trong coroutines, backpressure với Flow.
238
```
• Kích thước file binary lớn hơn: Do runtime của Kotlin (khoảng 1-2MB)
```
được đóng gói vào ứng dụng, làm tăng nhẹ kích thước APK so với ứng
```
dụng Java thuần (nhưng có thể giảm bằng ProGuard/R8).
```
• Spring Boot hỗ trợ Kotlin chưa đầy đủ: Mặc dù có thể viết Spring Boot
bằng Kotlin, một số tính năng như @Autowired với constructor injection
hoạt động bình thường, nhưng tài liệu và ví dụ chủ yếu vẫn bằng Java,
đôi khi gặp rắc rối khi cấu hình.
• Khả năng kiểm tra null tại runtime: Dù Null Safety được kiểm tra tại
```
compile time, nhưng khi tương tác với Java code (hoặc API trả về dữ
```
```
liệu có thể null), vẫn có thể xảy ra NPE nếu không xử lý cẩn thận.
```
11.3. Những khó khăn gặp phải và giải pháp
Trong quá trình thực hiện đồ án, nhóm đã gặp một số khó khăn và đưa ra các
giải pháp tương ứng:
Khó khăn 1: Tích hợp Google Books API và xử lý cấu hình JSON
phức tạp. Dữ liệu trả về từ Google Books API có cấu trúc lồng nhau,
```
nhiều trường tùy chọn (optional), không đồng nhất.
```
```
• Giải pháp: Xây dựng các DTO trung gian (GoogleBookDto,
```
```
VolumeInfo, SaleInfo) ánh xạ đúng cấu trúc JSON. Sử dụng
```
```
@SerialName (Kotlinx.Serialization) hoặc GSON với annotation
```
```
@SerializedName. Viết extension function toDomain() để
```
```
chuyển đổi từ DTO sang domain model (Book), sử dụng toán tử
```
```
Elvis (?:) để gán giá trị mặc định cho các trường nullable.
```
Khó khăn 2: Quản lý token JWT và tự động thêm vào header. Cần
lưu token sau đăng nhập và tự động đính kèm vào mọi request API,
```
đồng thời xử lý token hết hạn (401) và refresh token.
```
239
• Giải pháp: Sử dụng SharedPreferences để lưu token. Tạo OkHttp
Interceptor tùy chỉnh, kiểm tra token trong SharedPreferences và thêm
header Authorization: Bearer <token> trước khi gửi request. Xử lý lỗi
401 bằng cách bắt trong Response của Retrofit, gọi refresh token
```
endpoint (sẽ phát triển sau) hoặc chuyển hướng về màn hình đăng nhập.
```
```
Khó khăn 3: Quản lý trạng thái (state) trong Jetpack Compose và đồng
```
```
bộ giỏ hàng. Giỏ hàng cần được chia sẻ giữa nhiều màn hình (danh sách
```
```
sách, chi tiết sách, giỏ hàng) và giữ nguyên khi xoay màn hình hoặc
```
đóng ứng dụng tạm thời.
• Giải pháp: Sử dụng StateFlow trong CartViewModel với Hilt
scope ActivityRetainedScoped hoặc ViewModelScoped. Lưu
```
giỏ hàng xuống Room Database (entity CartItemEntity) mỗi khi
```
có thay đổi, và load lại khi khởi động ứng dụng. Dùng
```
collectAsState() trong composable để lắng nghe thay đổi và tự
```
động recompose.
Khó khăn 4: Cấu hình Hilt cho nhiều module và ViewModel. Hilt yêu cầu
cấu hình module cung cấp các dependency như Retrofit, ApiService,
```
Repository; đồng thời cần tích hợp với ViewModel.
```
```
• Giải pháp: Tạo các module riêng: NetworkModule (cung cấp
```
```
Retrofit, OkHttpClient, ApiService), RepositoryModule (cung
```
```
cấp BookRepository, OrderRepository). Sử dụng
```
@HiltViewModel cho ViewModel và @AndroidEntryPoint cho
Activity. Thêm dependency hilt-navigation-compose để sử dụng
```
hiltViewModel() trong Compose.
```
Khó khăn 5: Xử lý lỗi mạng và hiển thị thông báo cho người dùng. Khi mất
```
kết nối hoặc API trả về lỗi (400, 401, 500), ứng dụng cần hiển thị thông báo
```
phù hợp và không bị crash.
240
```
• Giải pháp: Sử dụng Sealed Class UiState (Loading, Success,
```
```
Error) để đại diện cho trạng thái tải dữ liệu. Trong ViewModel,
```
bắt exception khi gọi repository, cập nhật _uiState.value =
```
UiState.Error(message). Trong composable, dùng when(uiState)
```
để hiển thị CircularProgressIndicator, danh sách dữ liệu, hoặc
Snackbar/Toast với thông báo lỗi.
CHƯƠNG 12: HƯỚNG PHÁT TRIỂN TRONG TƯƠNG LAI
12.1. Hướng phát triển đồ án
Đồ án BookVerse – Ứng dụng bán sách trực tuyến hiện đã đạt được những kết
quả cốt lõi về mặt chức năng và kỹ thuật. Để trở thành một sản phẩm hoàn chỉnh, có
thể triển khai thực tế, nhóm định hướng phát triển các tính năng và cải tiến sau:
12.1.1. Hoàn thiện các tính năng cốt lõi
• Tích hợp thanh toán thực tế: Kết nối với các cổng thanh toán phổ
biến tại Việt Nam như VNPay, Momo, ZaloPay hoặc quốc tế như
Stripe. Cần xây dựng cơ chế webhook để xử lý kết quả thanh toán
bất đồng bộ, cập nhật trạng thái đơn hàng tự động.
• Quản lý giỏ hàng đa thiết bị: Lưu giỏ hàng lên server thay vì chỉ
lưu cục bộ, đồng bộ giỏ hàng khi người dùng đăng nhập từ nhiều
```
thiết bị khác nhau (điện thoại, máy tính bảng).
```
```
• Chức năng yêu thích sách (Wishlist): Cho phép người dùng thêm
```
sách vào danh sách yêu thích, lưu trữ trên server, có thể xem lại
sau.
• Tích hợp đánh giá nâng cao: Cho phép người dùng trả lời bình
luận của người khác, báo cáo bình luận vi phạm, và hiển thị đánh
giá có ảnh/video kèm theo.
```
12.1.2. Phát triển module Quản trị viên (Admin Dashboard)
```
241
```
• Quản lý sách: Xây dựng giao diện web (hoặc màn hình riêng trên
```
```
Android) cho phép admin thêm, sửa, xóa sách trong cơ sở dữ liệu nội bộ
```
```
(không chỉ phụ thuộc vào Google Books API). Hỗ trợ upload ảnh bìa,
```
nhập mô tả, giá, số lượng tồn kho.
```
• Quản lý đơn hàng: Cập nhật trạng thái đơn hàng (PENDING →
```
```
PROCESSING → SHIPPED → DELIVERED / CANCELLED). Gửi
```
thông báo đẩy hoặc email khi trạng thái thay đổi.
```
• Thống kê doanh thu: Xây dựng bảng điều khiển (dashboard) với biểu đồ
```
```
thống kê doanh thu theo ngày, tháng, năm; danh sách sách bán chạy
```
```
nhất; số lượng đơn hàng theo trạng thái.
```
• Quản lý người dùng: Xem danh sách người dùng, khóa/mở khóa tài
```
khoản, phân quyền (user, staff, admin).
```
12.1.3. Tối ưu hiệu năng và trải nghiệm người dùng
```
• Phân trang (Paging) cho danh sách sách: Sử dụng thư viện Paging 3 của
```
Android để tải dữ liệu theo trang, giảm tải bộ nhớ và tăng tốc độ hiển thị
khi cuộn danh sách dài.
• Caching dữ liệu sách với Room: Lưu trữ kết quả tìm kiếm sách từ
Google Books API vào cơ sở dữ liệu cục bộ, cho phép xem offline và
giảm số lượng request mạng.
• Tối ưu ảnh: Sử dụng Coil với cơ chế cache mạnh mẽ, định dạng WebP,
và lazy loading.
```
• Hỗ trợ chế độ tối (Dark Mode): Cấu hình theme động theo hệ thống hoặc
```
tùy chọn người dùng, sử dụng MaterialTheme và dynamicColor.
```
• Thông báo đẩy (Push Notification): Tích hợp Firebase Cloud Messaging
```
```
(FCM) để gửi thông báo về khuyến mãi, cập nhật đơn hàng, nhắc nhở
```
đánh giá sách.
12.1.4. Mở rộng nền tảng
• Phát triển phiên bản iOS: Sử dụng Kotlin Multiplatform Mobile
```
(KMM) để chia sẻ logic (repository, ViewModel, network) giữa
```
Android và iOS, chỉ viết lại giao diện bằng SwiftUI.
242
• Xây dựng website: Dùng Kotlin/JS hoặc framework hiện đại như
Next.js để tạo phiên bản web của BookVerse, dùng chung
backend API.
• Triển khai lên cloud: Đóng gói backend Spring Boot thành
```
Docker container, triển khai lên các nền tảng như AWS (EC2,
```
```
RDS), Google Cloud Run, hoặc Render để sản phẩm có thể truy
```
cập công khai.
12.2. Định hướng phát triển của bản thân
Việc hoàn thành môn học và đồ án BookVerse là một bước đệm quan trọng.
Dựa trên kiến thức đã học về Kotlin, Jetpack Compose, Spring Boot và phân tích thị
trường trong Chương 1, mỗi thành viên trong nhóm tự định hướng phát triển bản thân
như sau:
• Làm chủ hệ sinh thái Kotlin và Jetpack Compose: Tiếp tục học
sâu về StateFlow, SharedFlow, Compose Multiplatform,
Compose Navigation nâng cao, và các thư viện mới như Compose
Material 3, Compose Destinations.
• Mở rộng sang phát triển đa nền tảng với Kotlin Multiplatform
```
(KMP): Tìm hiểu và thực hành xây dựng ứng dụng chia sẻ logic
```
```
giữa Android, iOS, Desktop (Compose for Desktop) và Web
```
```
(Kotlin/JS). Định hướng trở thành Kotlin Multiplatform
```
Developer – một vị trí đang có nhu cầu cao trên thị trường quốc
tế.
• Nâng cao kỹ năng backend với Spring Boot và Ktor: Học thêm
```
về microservices, gRPC, message queue (RabbitMQ, Kafka), và
```
```
bảo mật nâng cao (OAuth2, Keycloak). Mục tiêu có thể đảm nhận
```
vị trí Backend Developer hoặc Fullstack Kotlin Developer.
• Tham gia các dự án mã nguồn mở và cộng đồng Kotlin: Đóng
góp cho các thư viện phổ biến trên GitHub, tham gia các nhóm
Kotlin Vietnam, StackOverflow, Discord để trao đổi kinh nghiệm
và nâng cao kỹ năng.
243
• Tích lũy kinh nghiệm thực tế: Thực tập tại các công ty công nghệ
```
có sử dụng Kotlin (như MoMo, Zalo, Tiki, các công ty
```
```
outsourcing như KMS, NashTech) để áp dụng kiến thức vào dự
```
```
án thực tế, học quy trình làm việc chuyên nghiệp (Agile/Scrum,
```
```
code review, CI/CD).
```
• Chuẩn bị chứng chỉ chuyên môn: Đạt các chứng chỉ như Android
```
Developer Certification (Google), Spring Professional, hoặc
```
Kotlin Multiplatform Developer để khẳng định năng lực.
• Định hướng lộ trình nghề nghiệp rõ ràng:
• Mục tiêu trước mắt: Ứng tuyển vị trí Android Developer Intern
```
hoặc Fresher tại các công ty sản phẩm (FPT Software, KMS
```
```
Solutions, MoMo, Tiki) hoặc công ty outsourcing.
```
• Dài hạn: Trở thành Android Developer chuyên nghiệp, sau đó
định hướng Kotlin Multiplatform Developer hoặc Fullstack
```
Kotlin Developer (Spring Boot + Compose for Web).
```
• Không ngừng cập nhật xu hướng công nghệ mới như Compose
for iOS, Compose for Desktop, Kotlin/Wasm.
• Xây dựng sản phẩm cá nhân: Tận dụng kiến thức để phát triển
một ứng dụng thương mại hoàn chỉnh, đưa lên cửa hàng Google
Play và duy trì cập nhật, vừa để tạo thu nhập thụ động vừa xây
dựng thương hiệu cá nhân.
TÀI LIỆU THAM KHẢO
```
[1]. JetBrains (2024), Kotlin Programming Language Documentation,
```
truy cập từ: https://kotlinlang.org/docs/home.html
```
[2]. Google Developers (2024), Guide to app architecture (Tài liệu
```
```
chuẩn về kiến trúc MVVM), truy cập từ:
```
```
https://developer.android.com/topic/architecture
```
```
[3]. Google Developers (2024), Jetpack Compose UI App Development,
```
truy cập từ: https://developer.android.com/jetpack/compose
```
[4]. Google Developers (2024), Dependency injection with Hilt, truy cập
```
từ: https://developer.android.com/training/dependency-injection/hilt-
android
244
```
[5]. Square, Inc. (2024), Retrofit: A type-safe HTTP client for Android
```
and Java, truy cập từ: https://square.github.io/retrofit/
```
[6]. Google Design (2024), Material Design 3 Guidelines (Tài liệu
```
```
chuẩn hóa giao diện UI/UX), truy cập từ: https://m3.material.io/
```
```
[7]. Google Developers (2024), Google Books APIs Documentation (Tài
```
```
liệu tích hợp API), truy cập từ: https://developers.google.com/books
```
```
[8]. VMware (2024), Spring Boot Reference Documentation (Tài liệu về
```
```
Backend), truy cập từ: https://docs.spring.io/spring-
```
boot/docs/current/reference/html/
PHỤ LỤC
Link github:
```
Frontend: https://github.com/HaoPhong11/BookStore.git
```
```
Backend: https://github.com/HaoPhong11/bookstore-backend.git
```