package com.example.bookstore.utils

// ══════════════════════════════════════════════════════════════════
// ĐÂY LÀ CODE BỊ LỖI — DÙNG LÀM INPUT CHO ĐỀ THI
// KHÔNG copy file này vào project!
// ══════════════════════════════════════════════════════════════════
//
// VẤN ĐỀ 1: displayPrice() là private trong CategoryDetailScreen.kt
//            → CartScreen không dùng được → hiển thị "171đ" hoặc "0đ"
//
// VẤN ĐỀ 2: addBook(book, quantity) truyền giá thô chưa normalize
//            → giỏ hàng lưu price = 1.71 (USD) hoặc 0.0
//
// CÁCH FIX:
//   1. Chuyển displayPrice() vào Extensions.kt (public)
//   2. Gọi addBook(book.copy(price = book.displayPrice()), quantity)
//
// CODE ĐÚNG: Xem utils/Extensions.kt trong project
// ══════════════════════════════════════════════════════════════════

import com.example.bookstore.data.model.Book
import java.text.NumberFormat
import java.util.Locale
import kotlin.math.absoluteValue

// ✅ toVnd() và orDefault() đều đúng — không có vấn đề
fun Double.toVnd(): String {
    val fmt = NumberFormat.getNumberInstance(Locale.forLanguageTag("vi-VN"))
    fmt.maximumFractionDigits = 0
    return "${fmt.format(this.toLong())}đ"
}

fun String?.orDefault(default: String = "Chưa có thông tin"): String =
    this?.ifBlank { default } ?: default

// ❌ BUG 1: displayPrice() không có ở đây
// (nó bị khai báo là `private fun Book.displayPrice()` bên trong CategoryDetailScreen.kt)
// → CartScreen import Extensions.kt nhưng không thấy displayPrice()
// → CartScreen hiển thị cartItem.price.toVnd() = "171đ" (giá USD thô) hoặc "0đ"

// ❌ BUG 2: Trong CategoryDetailScreen.kt
// onAddToCart = { book ->
//     cartViewModel.addBook(book, 1)   ← truyền book.price thô (1.71 hoặc 0.0)
// }
// → Giỏ hàng lưu giá sai

// ══════════════════════════════════════════════════════════════════
// CODE ĐÚNG (đã có trong project Extensions.kt):
//
// fun Book.displayPrice(): Double =             ← public, không có từ khóa private
//     if (price >= 1_000.0) price
//     else 50_000.0 + (id.hashCode().absoluteValue % 20) * 10_000.0
//
// Và trong CategoryDetailScreen.kt:
// cartViewModel.addBook(book.copy(price = book.displayPrice()), quantity)
//                           ↑ normalize giá trước khi lưu vào giỏ
// ══════════════════════════════════════════════════════════════════

