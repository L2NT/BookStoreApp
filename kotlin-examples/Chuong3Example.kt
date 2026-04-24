/**
 * ============================================================
 * CHƯƠNG 3: NGÔN NGỮ LẬP TRÌNH KOTLIN
 * Ví dụ minh họa: Hệ thống quản lý danh mục sách
 * ============================================================
 *
 * Các khái niệm được minh họa:
 *   1. val / var — Khai báo biến
 *   2. String Templates — Cú pháp ${...}
 *   3. fun — Hàm thông thường và hàm biểu thức đơn
 *   4. Default & Named Parameters — Tham số mặc định có tên
 *   5. Data Class — data class tự sinh toString/equals/copy
 *   6. Companion Object — Truy cập không cần tạo instance
 *   7. when expression — Thay thế switch, trả về giá trị
 *   8. for + indices — Duyệt vòng lặp
 *   9. filter / forEach / sumOf — Collections API
 *  10. copy() — Sao chép Data Class với giá trị khác
 *
 * CÁCH CHẠY:
 *   Cách 1 (Online, không cần cài đặt):
 *     → Truy cập https://play.kotlinlang.org
 *     → Xóa code mặc định, paste toàn bộ file này, nhấn ▶ Run
 *
 *   Cách 2 (IntelliJ IDEA Community):
 *     → File → New Project → Kotlin → "New Project" (Gradle hoặc IntelliJ)
 *     → Tạo file Kotlin mới, paste code, nhấn Ctrl+Shift+F10
 * ============================================================
 */

// ============================================================
// 1. DATA CLASS — §1.3 Chương 3
//    Trình biên dịch tự động sinh: toString(), equals(),
//    hashCode(), copy() — không cần viết tay như Java.
// ============================================================
data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val category: String,
    var price: Double,
    var stock: Int
)

// ============================================================
// 2. HÀM THÔNG THƯỜNG — §1.2 Chương 3
//    Nhận List<Book> và String, dùng hàm bậc cao filter{}
// ============================================================
fun locSachTheoTheLoai(danhSach: List<Book>, theLoai: String): List<Book> {
    return danhSach.filter { it.category == theLoai }
}

// ============================================================
// 3. HÀM BIỂU THỨC ĐƠN (Single-expression Function) — §1.2
//    Thân hàm = một biểu thức → dùng dấu = thay cho { return }
// ============================================================
fun tinhTongGiaTri(danhSach: List<Book>): Double =
    danhSach.sumOf { it.price * it.stock }

// ============================================================
// 4. when EXPRESSION — §1.4 Chương 3
//    Mạnh hơn switch: kiểm tra giá trị, trả về kết quả
// ============================================================
fun xepLoaiSach(theLoai: String): String = when (theLoai) {
    "Lập trình"  -> "Sách chuyên ngành"
    "Manga"      -> "Truyện tranh & Manga"
    "Kinh doanh" -> "Sách kinh tế"
    "Văn học"    -> "Sách văn học"
    else         -> "Thể loại khác"
}

// ============================================================
// 5. HÀM VỚI THAM SỐ MẶC ĐỊNH — §1.2 Chương 3
//    maLoi = 400 là giá trị mặc định, có thể bỏ qua khi gọi
// ============================================================
fun taoThongBaoLoi(thongBao: String, maLoi: Int = 400): String {
    return "[Lỗi $maLoi] $thongBao"
}

// ============================================================
// 6. CLASS VỚI PHƯƠNG THỨC — §1.3 Chương 3
// ============================================================
class Book2(val title: String, val author: String, var price: Double) {
    fun displayInfo(): String = "$title - $author (${price}đ)"
}

// ============================================================
// 7. HÀM MAIN — Thực thi chương trình
// ============================================================
fun main() {
    println("╔══════════════════════════════════════════════════╗")
    println("║   CHƯƠNG 3 — HỆ THỐNG QUẢN LÝ DANH MỤC SÁCH   ║")
    println("╚══════════════════════════════════════════════════╝")
    println()

    // ---- 1. val / var & String Templates ----
    println("▶ 1. val / var và String Templates")
    val bookName = "Lập trình Kotlin"
    val price    = 200000.0
    println("   Sách: $bookName – Giá: ${price}đ")
    println()

    // ---- 2. Tham số mặc định ----
    println("▶ 2. Tham số mặc định (Default Parameters)")
    println("   " + taoThongBaoLoi("Không tìm thấy sách"))          // dùng mặc định 400
    println("   " + taoThongBaoLoi("Lỗi server", maLoi = 500))      // Named Parameter
    println()

    // ---- 3. Class thông thường ----
    println("▶ 3. Class và phương thức")
    val book2 = Book2("Kotlin Coroutines", "Roman Elizarov", 350000.0)
    println("   ${book2.displayInfo()}")
    println()

    // ---- 4. Data Class + Collections ----
    println("▶ 4. Data Class + Collections")
    val bookList = listOf(
        Book(1, "Kotlin in Action",   "JetBrains", "Lập trình", 299000.0, 15),
        Book(2, "Android Dev Guide",  "Google",    "Lập trình", 350000.0, 8),
        Book(3, "Doraemon Vol.1",     "Fujiko",    "Manga",      89000.0, 30),
        Book(4, "Clean Architecture", "Robert",    "Lập trình", 320000.0, 5)
    )
    // toString() tự động từ data class:
    println("   book[0].toString() = ${bookList[0]}")
    println()

    // ---- 5. filter + forEach ----
    println("▶ 5. filter{} + forEach{} — Lọc sách lập trình")
    val sachLapTrinh = locSachTheoTheLoai(bookList, "Lập trình")
    println("   === Sách lập trình ===")
    sachLapTrinh.forEach { println("   ${it.title} – ${it.price}đ") }
    println()

    // ---- 6. sumOf ----
    println("▶ 6. sumOf{} — Tổng giá trị kho")
    val tongGiaTri = tinhTongGiaTri(bookList)
    println("   Tổng giá trị kho sách: ${tongGiaTri}đ")
    println()

    // ---- 7. when expression ----
    println("▶ 7. when expression — Phân loại sách")
    bookList.forEach {
        println("   ${it.title} → ${xepLoaiSach(it.category)}")
    }
    println()

    // ---- 8. for + indices ----
    println("▶ 8. for + indices — Duyệt theo chỉ số")
    for (index in bookList.indices) {
        println("   [$index] ${bookList[index].title}")
    }
    println()

    // ---- 9. Data Class copy() ----
    println("▶ 9. Data Class copy() — Sao chép với giá khác")
    val bookGoc       = bookList[0]
    val bookKhuyenMai = bookGoc.copy(price = bookGoc.price * 0.9)
    println("   Giá gốc : ${bookGoc.title} – ${bookGoc.price}đ")
    println("   Giá KM  : ${bookKhuyenMai.title} – ${bookKhuyenMai.price}đ")
    println()

    // ---- 10. groupBy ----
    println("▶ 10. groupBy{} — Nhóm sách theo thể loại")
    val groupByCategory = bookList.groupBy { it.category }
    groupByCategory.forEach { (category, books) ->
        println("   [$category] — ${books.size} cuốn")
        books.forEach { println("     • ${it.title}") }
    }
}

