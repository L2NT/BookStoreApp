package com.example.bookstore.data.repo

// ══════════════════════════════════════════════════════════════════
// ĐÂY LÀ CODE BỊ LỖI — DÙNG LÀM INPUT CHO ĐỀ THI
// KHÔNG copy file này vào project!
// ══════════════════════════════════════════════════════════════════
//
// VẤN ĐỀ: Parse thẳng JSON lồng nhau mà không dùng DTO trung gian
// → NullPointerException vì volumeInfo, authors, imageLinks có thể null
// → IndexOutOfBoundsException vì authors có thể rỗng
// → Crash hoặc hiển thị sai HTML tags
//
// CÁCH FIX:
// 1. Xây dựng DTO: GoogleBookResponse, BookItem, VolumeInfo, SaleInfo, Price
// 2. Viết Extension Function BookItem.toDomainModel() với Elvis operator
// ══════════════════════════════════════════════════════════════════

// ❌ Giả sử parse thẳng — BỊ LỖI
//
// Hàm parse sách bị lỗi (minh họa — không compile được trong project thực):
//
// private fun parseBookDirectly(item: BookItem): Book {
//     return Book(
//         id       = item.id,
//         title    = item.volumeInfo.title,              // ❌ volumeInfo có thể null → NPE
//         author   = item.volumeInfo.authors[0],         // ❌ authors rỗng → IndexOutOfBounds
//         imageUrl = item.volumeInfo.imageLinks.thumbnail, // ❌ imageLinks null → NPE
//         describe = item.volumeInfo.description,        // ❌ có HTML <b>...</b> tags
//         price    = item.saleInfo.retailPrice.amount    // ❌ retailPrice null → NPE
//     )
// }

// ══════════════════════════════════════════════════════════════════
// CODE ĐÚNG — Xem BookRepository.kt trong project:
//
// private fun BookItem.toDomainModel(): Book {
//     val bookPrice = this.saleInfo?.retailPrice?.amount  // safe call chain
//         ?: this.saleInfo?.listPrice?.amount             // fallback
//         ?: 0.0                                          // Elvis default
//
//     return Book(
//         id = this.id,
//         title = this.volumeInfo?.title ?: "Chưa rõ tên sách",
//         author = this.volumeInfo?.authors?.firstOrNull() ?: "Khuyết danh",
//         imageUrl = this.volumeInfo?.imageLinks?.thumbnailUrl
//             ?.replace("http:", "https:") ?: "",          // HTTP→HTTPS + null safe
//         describe = this.volumeInfo?.description
//             ?.replace(Regex("<.*?>"), "") ?: "Đang cập nhật...",  // xóa HTML tags
//         price = bookPrice
//     )
// }
//
// Và DTO trung gian trong GoogleBookDto.kt:
// data class GoogleBookResponse(val items: List<BookItem>? = emptyList())
// data class BookItem(val id: String, val volumeInfo: VolumeInfo?, val saleInfo: SaleInfo?)
// data class VolumeInfo(val title: String?, val authors: List<String>?, ...)
// data class SaleInfo(val retailPrice: Price?, val listPrice: Price?, ...)
// data class Price(val amount: Double?, val currencyCode: String?)
// ══════════════════════════════════════════════════════════════════

