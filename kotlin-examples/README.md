# kotlin-examples — Ví dụ minh họa Chương 3 & 4

Thư mục này chứa các file Kotlin **độc lập**, **không liên quan đến project Android**,  
dùng để minh họa các khái niệm lý thuyết trong báo cáo.

---

## Cấu trúc

```
kotlin-examples/
├── Chuong3Example.kt   ← Ví dụ Chương 3: Ngôn ngữ Kotlin cơ bản
├── Chuong4Example.kt   ← Ví dụ Chương 4: Kotlin nâng cao + Coroutines
└── README.md           ← File này
```

---

## Cách chạy

### ✅ Cách 1 — Kotlin Playground (Dễ nhất, không cần cài đặt)

1. Truy cập **https://play.kotlinlang.org**
2. Xóa toàn bộ code mặc định
3. Copy & Paste nội dung file `.kt` muốn chạy
4. Nhấn nút **▶ Run**
5. Chụp ảnh màn hình kết quả ở phần **Output**

> **Lưu ý**: `Chuong4Example.kt` dùng `kotlinx.coroutines`.  
> Kotlin Playground đã tích hợp sẵn — không cần cài thêm gì.

---

### ✅ Cách 2 — IntelliJ IDEA Community (Chạy local)

#### Cho `Chuong3Example.kt` (không cần thư viện thêm):

1. Mở IntelliJ IDEA Community
2. **File → New Project → New Project** (chọn Kotlin, Build System: Gradle/IntelliJ)
3. Tạo file Kotlin mới trong `src/main/kotlin/`
4. Paste nội dung `Chuong3Example.kt`
5. Nhấn chuột phải → **Run 'Chuong3ExampleKt'** hoặc `Ctrl+Shift+F10`

#### Cho `Chuong4Example.kt` (cần kotlinx.coroutines):

1. Tạo project Gradle Kotlin như trên
2. Trong `build.gradle.kts`, thêm dependency:
   ```kotlin
   dependencies {
       implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
   }
   ```
3. Nhấn **Sync Now** (Gradle sync)
4. Paste nội dung `Chuong4Example.kt` vào file Kotlin
5. Chạy như bình thường

---

## Nội dung từng file

### `Chuong3Example.kt`
| Mục | Khái niệm | Đoạn code |
|-----|-----------|-----------|
| 1 | `val` / `var` + String Templates | `val bookName = "..."`, `"Sách: $bookName – Giá: ${price}đ"` |
| 2 | Default & Named Parameters | `fun taoThongBaoLoi(thongBao: String, maLoi: Int = 400)` |
| 3 | Class + phương thức | `class Book2(...)` với `fun displayInfo()` |
| 4 | Data Class | `data class Book(...)` — tự sinh `toString()`, `copy()` |
| 5 | `filter{}` + `forEach{}` | `locSachTheoTheLoai(bookList, "Lập trình")` |
| 6 | `sumOf{}` | `tinhTongGiaTri(bookList)` |
| 7 | `when` expression | `xepLoaiSach(theLoai)` |
| 8 | `for` + `indices` | `for (index in bookList.indices)` |
| 9 | `copy()` | `bookGoc.copy(price = bookGoc.price * 0.9)` |
| 10 | `groupBy{}` | `bookList.groupBy { it.category }` |

### `Chuong4Example.kt`
| Mục | Khái niệm | Đoạn code |
|-----|-----------|-----------|
| 1 | Nullable Fields | `val author: String?`, `val description: String?` |
| 2 | Sealed Class + Covariance | `sealed class UiState<out T>` với Loading/Success/Error |
| 3 | Extension Functions | `fun Double.toFormattedPrice()`, `fun String?.orDefault()` |
| 4 | Null Safety (`?.`, `?:`, `!!`) | `book.author?.uppercase()`, `book.author ?: "Không rõ"` |
| 5 | Higher-Order Function | `fun apDungBoLoc(danhSach, boLoc: (Book) -> Boolean)` |
| 6 | `suspend fun` + Coroutines | `suspend fun fetchBooks()` với `delay(1500L)` |
| 7 | `runBlocking` + `launch` + `join` | `fun main() = runBlocking { val job = launch {...}; job.join() }` |

---

## Kết quả mong đợi

### `Chuong3Example.kt`
```
╔══════════════════════════════════════════════════╗
║   CHƯƠNG 3 — HỆ THỐNG QUẢN LÝ DANH MỤC SÁCH   ║
╚══════════════════════════════════════════════════╝

▶ 1. val / var và String Templates
   Sách: Lập trình Kotlin – Giá: 200000.0đ

▶ 2. Tham số mặc định (Default Parameters)
   [Lỗi 400] Không tìm thấy sách
   [Lỗi 500] Lỗi server

▶ 3. Class và phương thức
   Kotlin Coroutines - Roman Elizarov (350000.0đ)

▶ 4. Data Class + Collections
   book[0].toString() = Book(id=1, title=Kotlin in Action, author=JetBrains, category=Lập trình, price=299000.0, stock=15)

▶ 5. filter{} + forEach{} — Lọc sách lập trình
   === Sách lập trình ===
   Kotlin in Action – 299000.0đ
   Android Dev Guide – 350000.0đ
   Clean Architecture – 320000.0đ

▶ 6. sumOf{} — Tổng giá trị kho
   Tổng giá trị kho sách: 1.1555E7đ

▶ 7. when expression — Phân loại sách
   Kotlin in Action → Sách chuyên ngành
   Android Dev Guide → Sách chuyên ngành
   Doraemon Vol.1 → Truyện tranh & Manga
   Clean Architecture → Sách chuyên ngành

▶ 8. for + indices — Duyệt theo chỉ số
   [0] Kotlin in Action
   [1] Android Dev Guide
   [2] Doraemon Vol.1
   [3] Clean Architecture

▶ 9. Data Class copy() — Sao chép với giá khác
   Giá gốc : Kotlin in Action – 299000.0đ
   Giá KM  : Kotlin in Action – 269100.0đ

▶ 10. groupBy{} — Nhóm sách theo thể loại
   [Lập trình] — 3 cuốn
     • Kotlin in Action
     • Android Dev Guide
     • Clean Architecture
   [Manga] — 1 cuốn
     • Doraemon Vol.1
```

### `Chuong4Example.kt`
```
╔══════════════════════════════════════════════════════╗
║  CHƯƠNG 4 — TẢI VÀ XỬ LÝ DỮ LIỆU SÁCH BẤT ĐỒNG BỘ ║
╚══════════════════════════════════════════════════════╝

▶ 1. Khởi động Coroutine — trạng thái: LOADING
  [Repository] Đang gọi API...
  [Repository] Nhận được phản hồi từ server!

▶ 2. Sealed Class + when — xử lý từng trạng thái
────────────────────────────────────────────────────
  Trạng thái: SUCCESS — 3 cuốn sách

▶ 3. Null Safety — hiển thị thông tin từng sách
────────────────────────────────────────────────────
  • Kotlin in Action
    Tác giả (uppercase) : JETBRAINS
    Tác giả hiển thị    : JetBrains
    Giá                 : 299,000 VNĐ
    Mô tả               : Không rõ
  • Android Dev Guide
    Tác giả (uppercase) : null
    Tác giả hiển thị    : Tác giả không rõ
    Giá                 : 350,000 VNĐ
    Mô tả               : Sách hướng dẫn Android chính thức
  • Clean Architecture
    Tác giả (uppercase) : ROBERT C.
    Tác giả hiển thị    : Robert C.
    Giá                 : 320,000 VNĐ
    Mô tả               : Kiến trúc phần mềm sạch

▶ 4. Extension Functions trên Collections
────────────────────────────────────────────────────
  Sách dưới 300,000 VNĐ:
    → Kotlin in Action — 299,000 VNĐ

▶ 5. Higher-Order Function — truyền lambda làm tham số
────────────────────────────────────────────────────
  Sách có mô tả: 2/3 cuốn
    → Android Dev Guide
    → Clean Architecture

  Kết hợp filter + sortedBy + map:
    → Android Dev Guide: 350,000 VNĐ
    → Clean Architecture: 320,000 VNĐ

╔══════════════════════════════╗
║   Chương trình kết thúc.     ║
╚══════════════════════════════╝
```

