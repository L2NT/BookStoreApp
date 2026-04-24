package com.example.bookstore.viewmodel

import androidx.lifecycle.ViewModel
import com.example.bookstore.data.model.Book
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

/**
 * WishlistViewModel — Quản lý danh sách sách yêu thích.
 *
 * Được hoist tại MainScreen (như CartViewModel) để chia sẻ state
 * giữa BookDetailScreen và WishlistScreen.
 *
 * StateFlow<List<Book>>: reactive — khi wishlist thay đổi, tất cả
 * Composable đang collectAsState() tự recompose.
 */
@HiltViewModel
class WishlistViewModel @Inject constructor() : ViewModel() {

    private val _wishlist = MutableStateFlow<List<Book>>(emptyList())
    val wishlist: StateFlow<List<Book>> = _wishlist.asStateFlow()

    /**
     * Thêm sách vào wishlist nếu chưa có, xóa nếu đã có.
     * Dùng functional style: filter() xóa, + thêm — không mutate list trực tiếp.
     */
    fun toggle(book: Book) {
        val current = _wishlist.value
        _wishlist.value = if (current.any { it.id == book.id }) {
            current.filter { it.id != book.id }   // Xóa khỏi wishlist
        } else {
            current + book                          // Thêm vào wishlist
        }
    }

    /** Kiểm tra sách đã trong wishlist chưa — dùng để hiển thị icon ❤️ đúng */
    fun isWishlisted(bookId: String): Boolean =
        _wishlist.value.any { it.id == bookId }

    /** Xóa một sách theo id */
    fun remove(bookId: String) {
        _wishlist.value = _wishlist.value.filter { it.id != bookId }
    }
}

