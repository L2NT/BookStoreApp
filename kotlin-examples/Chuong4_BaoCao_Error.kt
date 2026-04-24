// =====================================================================
// CHƯƠNG 4 — TRẠNG THÁI ERROR
// Dán vào https://play.kotlinlang.org → nhấn ▶ Run
// ẢNH 4.2.4 (ERROR): chụp output này
// =====================================================================

import kotlinx.coroutines.*

data class Book(
    val id: String,
    val title: String,
    val author: String?,
    val price: Double,
    val description: String?
)

sealed class UiState<out T> {
    object Loading : UiState<Nothing>()
    data class Success<T>(val data: T) : UiState<T>()
    data class Error(val message: String) : UiState<Nothing>()
}

fun Double.toFormattedPrice(): String = "%,.0f VNĐ".format(this)
fun String?.orDefault(default: String = "Không rõ"): String = this ?: default

// Repository mô phỏng lỗi mạng
class BookRepository {
    suspend fun fetchBooks(): List<Book> {
        delay(500L)
        // Giả lập mất kết nối mạng
        throw Exception("Lỗi kết nối mạng. Vui lòng thử lại.")
    }
}

fun main() = runBlocking {
    val repository = BookRepository()
    var state: UiState<List<Book>> = UiState.Loading

    println("Trang thai: LOADING")
    println("Dang tai du lieu...")
    println()

    val job = launch {
        state = try {
            val books = repository.fetchBooks()
            UiState.Success(books)
        } catch (e: Exception) {
            UiState.Error(e.message ?: "Loi khong xac dinh")
        }
    }
    job.join()

    when (val s = state) {
        is UiState.Loading -> println("Van dang tai...")
        is UiState.Success -> println("Tai thanh cong ${s.data.size} cuon sach")
        is UiState.Error   -> {
            println("Trang thai: ERROR")
            println("Loi: ${s.message}")
            println()
            println("Giao dien hien thi thong bao loi cho nguoi dung.")
        }
    }
}
