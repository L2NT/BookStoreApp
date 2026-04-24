# BÀI TẬP KIỂM TRA THỰC HÀNH
**Dành cho:** Nhóm 35 — Kotlin Jetpack Compose  
**Tham chiếu:** Chương 11 — Bug: Crash `NullPointerException` khi mở "Đơn hàng của tôi"

---

## 1. ĐỀ BÀI

**Mục tiêu:** Kiểm tra kỹ năng phân tích crash NullPointerException do mismatch tên field JSON↔DTO, và áp dụng Null Safety của Kotlin để phòng thủ.

**Yêu cầu:** App crash với `NullPointerException` ngay khi mở màn hình "Đơn hàng của tôi". Phân tích nguyên nhân và fix cả frontend lẫn backend.

---

## 2. DỮ LIỆU ĐẦU VÀO (INPUT) — Code bị lỗi

```kotlin
// Frontend: OrderResponse.kt — BỊ LỖI
data class OrderResponse(
    val id: Long,
    val totalPrice: Double,
    val createdAt: String = "",
    val status: String = "",
    val items: List<OrderItemResponse>   // ❌ KHÔNG có default value = emptyList()
)

// OrderHistoryScreen.kt — dùng items để tính tổng
val totalQty = order.items.sumOf { it.quantity }  // ❌ NullPointerException nếu items = null

// Backend (Java): Order.java — BỊ LỖI
@OneToMany(mappedBy = "order")
private List<OrderItem> orderItems;   // ❌ field tên là "orderItems"
// Gson serialize → JSON: { "orderItems": [...] }
// → Frontend expect "items" nhưng JSON có "orderItems" → Gson map items = null
```

**Stack trace lỗi:**
```
FATAL EXCEPTION: main
java.lang.NullPointerException: items must not be null
    at OrderHistoryScreen.kt:123 — sumOf { it.quantity }
```

---

## 3. YÊU CẦU KẾT QUẢ (OUTPUT)

**a.** Giải thích chuỗi lỗi: `orderItems` ≠ `items` → Gson map null → NullPointerException.

**b.** Fix frontend `OrderResponse.kt`: thêm `= emptyList()` làm default value cho `items`.

**c.** Fix backend `Order.java`: thêm `@JsonProperty("items")` trên field `orderItems`.

**d.** Giải thích: tại sao Kotlin `List<T>` (không phải `List<T>?`) vẫn có thể là `null` khi nhận từ Java/JSON?

---

## 4. GỢI Ý GIẢI THÍCH CHO THẦY

**Chuỗi lỗi đầy đủ:**
```
Backend Java: field tên "orderItems"
  → Jackson serialize → JSON: { "id": 1, "orderItems": [...] }
    → Gson frontend tìm key "items" → không có → null (Java null, không phải Kotlin null)
      → OrderResponse.items = null (vượt qua type system!)
        → sumOf { it.quantity } → NullPointerException
```

**Tại sao Kotlin null safety không ngăn được:**
- Gson tạo object qua reflection, bỏ qua Kotlin type system
- `List<OrderItemResponse>` (non-nullable) nhưng Gson có thể set về `null` qua Java interop
- → Cần `= emptyList()` làm "phao cứu sinh" phòng khi Gson không map được

**Fix tối thiểu (chỉ cần 1 dòng):**
```kotlin
val items: List<OrderItemResponse> = emptyList()  // thêm default value
```

---

## 📦 HƯỚNG DẪN KÉO THẢ

> ✅ **Project hiện tại ĐÃ ĐƯỢC FIX** — `OrderResponse.kt` đã có `= emptyList()`.  
> **Không cần kéo thả gì.**

**Chỉ cần mở file và giải thích với thầy:**

| File trong project | Điểm cần chỉ |
|--------------------|-------------|
| `data/dto/response/OrderResponse.kt` | Line 9: `val items: List<OrderItemResponse> = emptyList()` |

**File code lỗi tham chiếu:** `_broken/OrderResponse_broken.kt`

---

## 📁 Nội dung folder này

```
08_nullpointer_orderhistory/
├── NOTES.md
└── _broken/
    └── OrderResponse_broken.kt    ← DTO không có default value (INPUT cho đề)
```

