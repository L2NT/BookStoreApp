// =====================================================================
// CHƯƠNG 3 — VÍ DỤ: HỆ THỐNG QUẢN LÝ DANH MỤC SÁCH
// Dán vào https://play.kotlinlang.org rồi nhấn ▶ Run
// Chụp ảnh CODE  → dùng cho Hình 2.X mục 2.2 (Cấu trúc file)
// Chụp ảnh OUTPUT → dùng cho Hình 2.X mục 2.4 (Kết quả minh họa)
// =====================================================================

// ── 1. Định nghĩa Data Class ─────────────────────────────────────────
data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val category: String,
    var price: Double,
    var stock: Int
)

// ── 2. Hàm nghiệp vụ ─────────────────────────────────────────────────
fun locSachTheoTheLoai(danhSach: List<Book>, theLoai: String): List<Book> {
    return danhSach.filter { it.category == theLoai }
}

fun tinhTongGiaTri(danhSach: List<Book>): Double {
    return danhSach.sumOf { it.price * it.stock }
}

fun xepLoaiSach(theLoai: String): String = when (theLoai) {
    "Kỹ thuật", "Lập trình" -> "Sách chuyên ngành"
    "Văn học"               -> "Sách văn học"
    else                    -> "Thể loại khác"
}

// ── 3. Hàm main – thực thi ───────────────────────────────────────────
fun main() {
    val bookList = listOf(
        Book(1, "Kotlin in Action",   "JetBrains", "Lập trình", 299000.0, 15),
        Book(2, "Android Dev Guide",  "Google",    "Lập trình", 350000.0, 8),
        Book(3, "Doraemon Vol.1",     "Fujiko",    "Manga",      89000.0, 30),
        Book(4, "Clean Architecture", "Robert",    "Lập trình", 320000.0, 5)
    )

    // Lọc sách theo thể loại
    val sachLapTrinh = locSachTheoTheLoai(bookList, "Lập trình")
    println("=== Sách lập trình ===")
    sachLapTrinh.forEach { println("  ${it.title} – ${it.price}đ") }

    println()

    // Tính tổng giá trị kho
    val tongGiaTri = tinhTongGiaTri(bookList)
    println("Tổng giá trị kho sách: ${tongGiaTri}đ")

    println()

    // Phân loại bằng when expression
    println("=== Phân loại sách ===")
    bookList.forEach { println("  ${it.title} → ${xepLoaiSach(it.category)}") }

    println()

    // Duyệt theo chỉ số
    println("=== Danh sách theo chỉ số ===")
    for (index in bookList.indices) {
        println("  [$index] ${bookList[index].title}")
    }

    println()

    // Data Class copy()
    val bookGoc       = bookList[0]
    val bookKhuyenMai = bookGoc.copy(price = bookGoc.price * 0.9)
    println("Giá gốc : ${bookGoc.title} – ${bookGoc.price}đ")
    println("Giá KM  : ${bookKhuyenMai.title} – ${bookKhuyenMai.price}đ")
}

