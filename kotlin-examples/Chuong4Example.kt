/**
 * ============================================================
 * CHƯƠNG 4: KOTLIN NÂNG CAO VÀ LẬP TRÌNH HÀM
 * Ví dụ minh họa: Tải và xử lý dữ liệu sách bất đồng bộ
 * ============================================================
 *
 * Các khái niệm được minh họa:
 *   1. Null Safety       — Nullable (?), Safe Call (?.), Elvis (?:), !!
 *   2. Extension Function — Mở rộng lớp có sẵn mà không kế thừa
 *   3. Higher-Order Function & Lambda — Hàm nhận hàm khác làm tham số
 *   4. Sealed Class      — Lớp niêm phong, exhaustive khi dùng với when
 *   5. Coroutines        — suspend fun, runBlocking, launch, delay
 *
 * CÁCH CHẠY (Khuyến nghị):
 *   → Truy cập https://play.kotlinlang.org
 *   → Xóa code mặc định, paste toàn bộ file này, nhấn ▶ Run
 *   (Kotlin Playground đã tích hợp sẵn kotlinx.coroutines, không cần cài)
 *
 * CÁCH CHẠY (IntelliJ IDEA với Gradle):
 *   → Thêm vào build.gradle.kts:
 *       implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
 *   → Chạy bình thường qua Run
 * ============================================================
 */

import kotlinx.coroutines.*

// ============================================================
// 1. DATA CLASS với Nullable Fields — §1.1 Chương 4
//    Các field nullable mô phỏng dữ liệu thực tế từ API
//    (API có thể không trả về tác giả hoặc mô tả)
// ============================================================
data class Book(
    val id: String,
    val title: String,
    val author: String?,      // Nullable: API có thể không có tác giả
    val price: Double,
    val description: String?  // Nullable: API có thể không có mô tả
)

// ============================================================
// 2. SEALED CLASS — §1.4 Chương 4
//    Giới hạn tập hợp con: chỉ có Loading, Success, Error
//    Từ khóa 'out T' = Covariance: UiState<Book> ⊆ UiState<Any>
//    → Tái sử dụng cho mọi kiểu dữ liệu, không cần class riêng
// ============================================================
sealed class UiState<out T> {
    /** Trạng thái đang tải */
    data object Loading : UiState<Nothing>()

    /** Trạng thái tải thành công — mang theo dữ liệu */
    data class Success<T>(val data: T) : UiState<T>()

    /** Trạng thái lỗi — mang theo thông báo */
    data class Error(val message: String) : UiState<Nothing>()
}

// ============================================================
// 3. EXTENSION FUNCTIONS — §1.2 Chương 4
//    Thêm phương thức vào lớp có sẵn mà không cần kế thừa.
//    'this' tham chiếu đến đối tượng đang gọi hàm.
// ============================================================

/** Mở rộng Double: định dạng thành chuỗi tiền VNĐ */
fun Double.toFormattedPrice(): String = "%,.0f VNĐ".format(this)

/**
 * Mở rộng String? (nullable String):
 * Kết hợp Null Safety + Extension Function.
 * Elvis operator (?:) trả về giá trị mặc định khi chuỗi là null.
 */
fun String?.orDefault(default: String = "Không rõ"): String = this ?: default

/** Mở rộng List<Book>: lọc sách theo khoảng giá */
fun List<Book>.filterByPriceRange(min: Double, max: Double): List<Book> =
    this.filter { it.price in min..max }

// ============================================================
// 4. NULL SAFETY DEMO — §1.1 Chương 4
// ============================================================
fun hienThiThongTinSach(book: Book) {
    // Safe Call Operator (?.) — trả về null thay vì ném NPE
    val upperAuthor: String? = book.author?.uppercase()

    // Elvis Operator (?:) — giá trị mặc định khi null
    val displayAuthor: String = book.author ?: "Tác giả không rõ"

    // Extension Function orDefault() kết hợp Null Safety
    val displayDesc: String = book.description.orDefault("Chưa có mô tả")

    // Not-null assertion (!!) — chỉ dùng khi chắc chắn không null
    // val len = book.author!!.length  ← sẽ ném NPE nếu author là null

    println("  • ${book.title}")
    println("    Tác giả (uppercase) : $upperAuthor")
    println("    Tác giả hiển thị    : $displayAuthor")
    println("    Giá                 : ${book.price.toFormattedPrice()}")
    println("    Mô tả               : $displayDesc")
}

// ============================================================
// 5. HIGHER-ORDER FUNCTION — §1.3 Chương 4
//    Hàm nhận một hàm khác làm tham số (predicate: (Book) -> Boolean)
// ============================================================
fun apDungBoLoc(
    danhSach: List<Book>,
    boLoc: (Book) -> Boolean    // Tham số kiểu hàm — Higher-Order Function
): List<Book> {
    return danhSach.filter(boLoc)
}

// ============================================================
// 6. REPOSITORY VỚI SUSPEND FUNCTION — §1.5 Chương 4
//    suspend fun: có thể tạm dừng (không chặn thread), chỉ gọi
//    được từ coroutine hoặc suspend function khác
// ============================================================
class BookRepository {
    suspend fun fetchBooks(): List<Book> {
        println("  [Repository] Đang gọi API...")
        delay(1500L)   // Mô phỏng độ trễ mạng 1.5s — KHÔNG chặn thread
        println("  [Repository] Nhận được phản hồi từ server!")

        return listOf(
            Book("1", "Kotlin in Action",   "JetBrains", 299000.0, null),
            Book("2", "Android Dev Guide",  null,        350000.0, "Sách hướng dẫn Android chính thức"),
            Book("3", "Clean Architecture", "Robert C.", 320000.0, "Kiến trúc phần mềm sạch"),
        )
    }
}

// ============================================================
// 7. MAIN — runBlocking bọc toàn bộ coroutine
//    runBlocking: cầu nối từ thế giới đồng bộ sang coroutine
//    launch: tạo coroutine "fire and forget"
//    join(): chờ coroutine hoàn tất trước khi tiếp tục
// ============================================================
fun main() = runBlocking {
    println("╔══════════════════════════════════════════════════════╗")
    println("║  CHƯƠNG 4 — TẢI VÀ XỬ LÝ DỮ LIỆU SÁCH BẤT ĐỒNG BỘ ║")
    println("╚══════════════════════════════════════════════════════╝")
    println()

    val repository = BookRepository()
    var uiState: UiState<List<Book>> = UiState.Loading

    // ---- Coroutines: launch + delay ----
    println("▶ 1. Khởi động Coroutine — trạng thái: LOADING")
    val job = launch {                              // launch: tạo coroutine mới
        uiState = UiState.Loading
        try {
            val books = repository.fetchBooks()    // gọi suspend fun
            uiState = UiState.Success(books)
        } catch (e: Exception) {
            uiState = UiState.Error(e.message ?: "Lỗi không xác định")
        }
    }
    job.join()   // chờ coroutine hoàn tất
    println()

    // ---- Sealed Class + when (exhaustive) ----
    println("▶ 2. Sealed Class + when — xử lý từng trạng thái")
    println("─".repeat(52))
    when (val state = uiState) {
        is UiState.Loading -> println("  Vẫn đang tải...")
        is UiState.Success -> {
            println("  Trạng thái: SUCCESS — ${state.data.size} cuốn sách")
            println()

            // ---- Null Safety Demo ----
            println("▶ 3. Null Safety — hiển thị thông tin từng sách")
            println("─".repeat(52))
            state.data.forEach { hienThiThongTinSach(it) }
            println()

            // ---- Extension Function ----
            println("▶ 4. Extension Functions trên Collections")
            println("─".repeat(52))
            val sachDuoi300k = state.data.filterByPriceRange(0.0, 300_000.0)
            println("  Sách dưới 300,000 VNĐ:")
            sachDuoi300k.forEach {
                println("    → ${it.title} — ${it.price.toFormattedPrice()}")
            }
            println()

            // ---- Higher-Order Function ----
            println("▶ 5. Higher-Order Function — truyền lambda làm tham số")
            println("─".repeat(52))
            val sachCoMoTa = apDungBoLoc(state.data) { it.description != null }
            println("  Sách có mô tả: ${sachCoMoTa.size}/${state.data.size} cuốn")
            sachCoMoTa.forEach { println("    → ${it.title}") }

            // Cách kết hợp nhiều hàm xử lý tập hợp (chaining)
            println()
            println("  Kết hợp filter + sortedBy + map:")
            val sachTheoGia = state.data
                .filter { it.description != null }   // chỉ lấy sách có mô tả
                .sortedBy { it.price }               // sắp xếp tăng dần theo giá
                .map { "${it.title}: ${it.price.toFormattedPrice()}" }
            sachTheoGia.forEach { println("    → $it") }
        }
        is UiState.Error -> println("  Trạng thái: ERROR — ${state.message}")
    }

    println()
    println("╔══════════════════════════════╗")
    println("║   Chương trình kết thúc.     ║")
    println("╚══════════════════════════════╝")
}

