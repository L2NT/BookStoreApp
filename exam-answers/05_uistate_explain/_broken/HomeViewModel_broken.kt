package com.example.bookstore.viewmodel

// ══════════════════════════════════════════════════════════════════
// ĐÂY LÀ CODE BỊ LỖI — DÙNG LÀM INPUT CHO ĐỀ THI
// KHÔNG copy file này vào project!
// ══════════════════════════════════════════════════════════════════
//
// VẤN ĐỀ: 3 biến StateFlow rời rạc → trạng thái mâu thuẫn
// VD: isLoading=true ĐỒNG THỜI errorMsg!=null → UI không biết hiển thị gì
//     Quên reset isLoading=false → UI stuck loading mãi mãi
//
// CÁCH FIX: sealed class UiState<out T> (xem UiState.kt + CategoryViewModel.kt)
// ══════════════════════════════════════════════════════════════════

/*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookstore.data.model.Book
import com.example.bookstore.data.repo.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

// ❌ HomeViewModel BỊ LỖI — 3 biến rời rạc
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: BookRepository
) : ViewModel() {

    // ❌ 3 biến StateFlow độc lập — dễ mâu thuẫn nhau
    val isLoading = MutableStateFlow(false)
    val books     = MutableStateFlow<List<Book>>(emptyList())
    val errorMsg  = MutableStateFlow<String?>(null)

    fun loadBooks(query: String) {
        isLoading.value = true              // ← set loading
        books.value     = emptyList()
        errorMsg.value  = null

        viewModelScope.launch {
            try {
                val result = repository.getBooks(query)
                books.value = result
                // ❌ QUÊN: isLoading.value = false → UI bị stuck loading mãi
            } catch (e: Exception) {
                errorMsg.value = e.message
                // ❌ isLoading vẫn = true → loading spinner + error message cùng hiện
            }
        }
    }
}

// ❌ HomeScreen BỊ LỖI — phải collect 3 state riêng
@Composable
fun HomeScreenBroken(viewModel: HomeViewModel = hiltViewModel()) {
    val isLoading by viewModel.isLoading.collectAsState()
    val books     by viewModel.books.collectAsState()
    val errorMsg  by viewModel.errorMsg.collectAsState()

    // ❌ Dễ có trạng thái mâu thuẫn: isLoading=true VÀ errorMsg!=null cùng lúc
    when {
        isLoading        -> CircularProgressIndicator()
        errorMsg != null -> Text(errorMsg!!)
        else             -> LazyColumn { items(books) { BookCard(it) } }
    }
}
*/

// ══════════════════════════════════════════════════════════════════
// CODE ĐÚNG — Xem trong project:
//
// sealed class UiState<out T> {           // ui/state/UiState.kt
//     data object Loading : UiState<Nothing>()
//     data class Success<T>(val data: T) : UiState<T>()
//     data class Error(val message: String) : UiState<Nothing>()
// }
//
// // CategoryViewModel.kt — ViewModel đúng
// private val _uiState = MutableStateFlow<UiState<List<Book>>>(UiState.Loading)
// val uiState: StateFlow<UiState<List<Book>>> = _uiState.asStateFlow()
//
// viewModelScope.launch {
//     _uiState.value = UiState.Loading
//     repository.getBooksResult(query)
//         .onSuccess { _uiState.value = UiState.Success(it) }
//         .onFailure { _uiState.value = UiState.Error(it.message ?: "Lỗi") }
// }
//
// // Trong Composable — exhaustive when
// when (val state = uiState) {
//     is UiState.Loading      -> CircularProgressIndicator()
//     is UiState.Success      -> LazyColumn { items(state.data) { BookCard(it) } }
//     is UiState.Error        -> Text(state.message)
// }
// ══════════════════════════════════════════════════════════════════

