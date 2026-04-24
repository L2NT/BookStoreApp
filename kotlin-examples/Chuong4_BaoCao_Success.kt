// =====================================================================
// CHƯƠNG 4 — VÍ DỤ: TẢI VÀ XỬ LÝ DỮ LIỆU SÁCH BẤT ĐỒNG BỘ
// Dán vào https://play.kotlinlang.org → nhấn ▶ Run
//
// ẢNH 4.2.2: chụp TOÀN BỘ code này (cấu trúc phân lớp)
// ẢNH 4.2.4 (SUCCESS): chụp output sau khi Run
// =====================================================================

import kotlinx.coroutines.*

// ── Tầng Model ────────────────────────────────────────────────────────
data class Book(
    val id: String,
    val title: String,
    val author: String?,       // Nullable — tác giả có thể null
    val price: Double,
    val description: String?   // Nullable — mô tả có thể null
)

// ── Tầng State (Sealed Class) ─────────────────────────────────────────
sealed class UiState<out T> {
    object Loading : UiState<Nothing>()
    data class Success<T>(val data: T) : UiState<T>()
    data class Error(val message: String) : UiState<Nothing>()
}

// ── Tầng Utils (Extension Functions) ─────────────────────────────────
fun Double.toFormattedPrice(): String {
    return "%,.0f VNĐ".format(this)
}

fun String?.orDefault(default: String = "Không rõ"): String {
    return this ?: default
}

// ── Tầng Repository (Coroutines) ──────────────────────────────────────
class BookRepository {
    suspend fun fetchBooks(): List<Book> {
        delay(1500L) // Mô phỏng độ trễ mạng
        return listOf(
            Book("1", "Kotlin in Action",  "JetBrains", 299000.0, null),
            Book("2", "Android Dev Guide", null,        350000.0, "Sách chính thức"),
        )
    }
}

// ── Main ──────────────────────────────────────────────────────────────
fun main() = runBlocking {
    val repository = BookRepository()
    var state: UiState<List<Book>> = UiState.Loading

    // Trạng thái Loading
    println("Trang thai: LOADING")
    println("Dang tai du lieu...")
    println()

    // Gọi API bất đồng bộ
    val job = launch {
        state = try {
            val books = repository.fetchBooks()
            UiState.Success(books)
        } catch (e: Exception) {
            UiState.Error(e.message ?: "Loi khong xac dinh")
        }
    }
    job.join()

    // Xử lý kết quả với when (Sealed Class — exhaustive)
    when (val s = state) {
        is UiState.Loading -> println("Van dang tai...")
        is UiState.Success -> {
            println("Trang thai: SUCCESS")
            println("Tai thanh cong ${s.data.size} cuon sach")
            println()
            s.data.forEach { book ->
                println("  Sach    : ${book.title}")
                println("  Tac gia : ${book.author.orDefault()}")
                println("  Gia     : ${book.price.toFormattedPrice()}")
                println("  Mo ta   : ${book.description.orDefault("Chua co mo ta")}")
                println()
            }
        }
        is UiState.Error -> {
            println("Trang thai: ERROR")
            println("Loi: ${s.message}")
        }
    }
}

