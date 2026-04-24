// File: Chuong3_BaoCao.kt
// Dán vào https://play.kotlinlang.org → nhấn ▶ Run
// Code này khớp CHÍNH XÁC với mục 2.3 trong báo cáo

// ── Định nghĩa Data Class Book ───────────────────────────────────────
data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val category: String,
    var price: Double,
    var stock: Int
)

// ── Hàm lọc và xử lý danh sách ───────────────────────────────────────
fun locSachTheoTheLoai(danhSach: List<Book>, theLoai: String): List<Book> {
    return danhSach.filter { it.category == theLoai }
}

fun tinhTongGiaTri(danhSach: List<Book>): Double {
    return danhSach.sumOf { it.price * it.stock }
}

// ── Hàm main – Thực thi và hiển thị kết quả ──────────────────────────
fun main() {
    val bookList = listOf(
        Book(1, "Kotlin in Action",   "JetBrains", "Lập trình", 299000.0, 15),
        Book(2, "Android Dev Guide",  "Google",    "Lập trình", 350000.0, 8),
        Book(3, "Doraemon Vol.1",     "Fujiko",    "Manga",      89000.0, 30),
        Book(4, "Clean Architecture", "Robert",    "Lập trình", 320000.0, 5)
    )

    val sachLapTrinh = locSachTheoTheLoai(bookList, "Lập trình")
    println("=== Sách lập trình ===")
    sachLapTrinh.forEach { println(" ${it.title} – ${it.price}đ") }

    val tongGiaTri = tinhTongGiaTri(bookList)
    println("Tổng giá trị kho sách: ${tongGiaTri}đ")
}

