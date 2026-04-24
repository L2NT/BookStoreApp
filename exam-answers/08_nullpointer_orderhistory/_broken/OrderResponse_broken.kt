package com.example.bookstore.data.dto.response

// ══════════════════════════════════════════════════════════════════
// ĐÂY LÀ CODE BỊ LỖI — DÙNG LÀM INPUT CHO ĐỀ THI
// KHÔNG copy file này vào project!
// ══════════════════════════════════════════════════════════════════
//
// BUG: Crash NullPointerException khi mở "Đơn hàng của tôi"
//
// NGUYÊN NHÂN (chuỗi lỗi):
// 1. Backend Java field tên "orderItems" → Jackson JSON: { "orderItems": [...] }
// 2. Frontend DTO expect field "items" → Gson không tìm thấy → null (Java null)
// 3. OrderResponse.items = null (Gson bypass Kotlin type system qua reflection)
// 4. OrderHistoryScreen: order.items.sumOf { it.quantity } → NullPointerException
//
// Stack trace:
//   java.lang.NullPointerException: items must not be null
//       at OrderHistoryScreen.kt — sumOf { it.quantity }
//
// CÁCH FIX:
//   Frontend: thêm = emptyList() làm default value (Null Safety "phao cứu sinh")
//   Backend:  thêm @JsonProperty("items") trên field orderItems
// ══════════════════════════════════════════════════════════════════

// ❌ Code BỊ LỖI — không có default value
data class OrderResponse(
    val id: Long,
    val totalPrice: Double,
    val createdAt: String = "",
    val status: String = "",
    val receiverName: String = "",
    val items: List<OrderItemResponse>   // ❌ THIẾU = emptyList()
    // Gson map null → NullPointerException khi dùng .sumOf { }
)

// ══════════════════════════════════════════════════════════════════
// CODE ĐÚNG (đã có trong project):
//
// data class OrderResponse(
//     val id: Long,
//     val totalPrice: Double,
//     val createdAt: String = "",
//     val status: String = "",
//     val receiverName: String = "",
//     val items: List<OrderItemResponse> = emptyList()   ← thêm default
// )
//
// Backend Java cũng cần fix (Order.java):
// @JsonProperty("items")                ← thêm annotation
// @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
// private List<OrderItem> orderItems;
// ══════════════════════════════════════════════════════════════════

