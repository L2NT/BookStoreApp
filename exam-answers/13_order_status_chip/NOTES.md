# BÀI TẬP KIỂM TRA THỰC HÀNH
**Dành cho:** Nhóm 35 — Kotlin Jetpack Compose  
**Tham chiếu:** Chương 12 — Mục 12.1.2: Quản lý đơn hàng (cập nhật trạng thái)  
**Loại:** 🟦 Pattern B — Mở rộng UI (tạo Composable con mới)

---

## 1. ĐỀ BÀI

**Mục tiêu:** Kiểm tra kỹ năng tạo Composable con tái sử dụng với conditional rendering/styling. Bài tập này tương tự bài `UVIndexIndicator` — thay vì chỉ số UV thì dùng trạng thái đơn hàng.

**Yêu cầu:** Ứng dụng hiện hiển thị trạng thái đơn hàng dưới dạng text màu inline trong `OrderHistoryScreen`. Hãy tách logic này thành một Composable độc lập tên `OrderStatusChip` để có thể tái sử dụng.

---

## 2. DỮ LIỆU ĐẦU VÀO (INPUT) — Hiện trạng

```kotlin
// OrderHistoryScreen.kt — trạng thái được render inline, không tái sử dụng được
private data class StatusInfo(val label: String, val color: Color, val icon: ImageVector)

private fun getStatusInfo(status: String): StatusInfo = when (status.uppercase()) {
    "PENDING"                  -> StatusInfo("Chờ xác nhận",   Color(0xFFFF9800), Icons.Outlined.HourglassEmpty)
    "PROCESSING", "CONFIRMED"  -> StatusInfo("Đang xử lý",     Color(0xFF2196F3), Icons.Outlined.Inventory2)
    "SHIPPED", "SHIPPING"      -> StatusInfo("Đang giao hàng", Color(0xFF9C27B0), Icons.Outlined.LocalShipping)
    "DELIVERED"                -> StatusInfo("Đã giao hàng",   Color(0xFF4CAF50), Icons.Outlined.CheckCircle)
    "CANCELLED"                -> StatusInfo("Đã hủy",         Color(0xFFF44336), Icons.Outlined.Cancel)
    else                       -> StatusInfo(status,            Color.Gray,        Icons.Outlined.HourglassEmpty)
}
// ← private/internal → không dùng được ở màn hình khác
// ← không phải @Composable → không hưởng lợi từ recomposition
```

**Data mẫu thầy có thể cung cấp:**
```json
{ "orderId": 101, "status": "SHIPPED", "totalAmount": 250000 }
```

---

## 3. YÊU CẦU KẾT QUẢ (OUTPUT)

**a.** Tạo `OrderStatusChip(status: String)` trong `ui/components/`:
- Dùng `when(status.uppercase())` → `(label, color, icon)` tương ứng
- Render `Surface` chip với `color.copy(alpha = 0.12f)` làm nền + `BorderStroke(1.dp, color)` viền
- 5 trạng thái: PENDING (cam), PROCESSING (xanh dương), SHIPPED (tím), DELIVERED (xanh lá), CANCELLED (đỏ)

**b.** Tích hợp vào `OrderHistoryScreen`: thay thế chỗ render trạng thái inline bằng `OrderStatusChip(order.status)`

**c.** **Demo:** Vào màn hình Lịch sử đơn hàng → thấy chip màu sắc rõ ràng theo từng trạng thái

**d.** **Giải thích:** Tại sao tách thành Composable tái sử dụng tốt hơn inline code? (Single Responsibility, reusability)

---

## 4. TRƯỜNG HỢP INPUT / OUTPUT

| Input `status` | Label hiển thị | Màu | Icon |
|---|---|---|---|
| `"PENDING"` | Chờ xác nhận | 🟠 Cam `#FF9800` | HourglassEmpty |
| `"pending"` | Chờ xác nhận | 🟠 Cam `#FF9800` | HourglassEmpty *(uppercase() xử lý)*|
| `"PROCESSING"` | Đang xử lý | 🔵 Xanh dương `#2196F3` | Inventory2 |
| `"CONFIRMED"` | Đang xử lý | 🔵 Xanh dương `#2196F3` | Inventory2 *(alias)*|
| `"SHIPPED"` | Đang giao hàng | 🟣 Tím `#9C27B0` | LocalShipping |
| `"SHIPPING"` | Đang giao hàng | 🟣 Tím `#9C27B0` | LocalShipping *(alias)*|
| `"DELIVERED"` | Đã giao hàng | 🟢 Xanh lá `#4CAF50` | CheckCircle |
| `"CANCELLED"` | Đã hủy | 🔴 Đỏ `#F44336` | Cancel |
| `"UNKNOWN_XYZ"` *(status lạ)* | `"UNKNOWN_XYZ"` *(nguyên văn)* | ⚪ Xám | HourglassEmpty |

### Các variant thầy có thể yêu cầu thêm:

**Thêm trạng thái REFUNDED:**
```kotlin
"REFUNDED" -> Triple("Đã hoàn tiền", Color(0xFF009688), Icons.Outlined.Refresh)
```

**Thêm trạng thái RETURN_REQUESTED:**
```kotlin
"RETURN_REQUESTED" -> Triple("Yêu cầu trả hàng", Color(0xFF795548), Icons.Outlined.Undo)
```

**Chip nhỏ hơn — thêm param `compact`:**
```kotlin
@Composable
fun OrderStatusChip(status: String, compact: Boolean = false) {
    val fontSize = if (compact) 10.sp else 12.sp
    val iconSize = if (compact) 10.dp else 14.dp
    // ... dùng fontSize, iconSize trong render
}
// Gọi: OrderStatusChip(order.status, compact = true) → chip nhỏ hơn cho danh sách
```

---

## 5. GỢI Ý GIẢI THÍCH CHO THẦY

**Tại sao tách thành Composable?**
- **Tái sử dụng**: `OrderStatusChip` có thể dùng trong `OrderHistoryScreen`, `CheckoutScreen`, dashboard, notification — không copy-paste code
- **Single Responsibility**: logic màu/label gom vào 1 chỗ — thay đổi 1 lần, áp dụng khắp nơi
- **Testable**: Composable nhận param đơn giản → dễ preview/test từng trạng thái

**So sánh với UVIndexIndicator (nhóm Weather):**
```
UVIndexIndicator(uvi: Double)     →  when(uvi) → color (Xanh/Vàng/Cam/Đỏ/Tím)
OrderStatusChip(status: String)   →  when(status) → color (Cam/Xanh/Tím/Xanh lá/Đỏ)
```
Cùng pattern: **1 input → conditional color/label → Chip UI**

**Kỹ thuật "tinted chip" Material3:**
```kotlin
Surface(
    shape  = RoundedCornerShape(16.dp),
    color  = color.copy(alpha = 0.12f),   // Nền mờ cùng màu
    border = BorderStroke(1.dp, color)    // Viền rõ cùng màu
) { ... }
// Không dùng FilterChip API để tránh phức tạp — Surface đơn giản hơn, dễ kiểm soát
```

---

## 📦 HƯỚNG DẪN KÉO THẢ

**Kéo thư mục `app/` vào thư mục `BookStore/` — chọn Replace khi được hỏi.**

| File | Loại | Giải quyết yêu cầu |
|------|------|-------------------|
| `ui/components/OrderStatusChip.kt` | ✅ DROP-IN (file mới) | Yêu cầu **(a)** — Composable chip |
| `ui/screens/OrderHistoryScreen.kt` | 🔄 REPLACE | Yêu cầu **(b)** — dùng OrderStatusChip |

> ✅ **Chỉ DROP-IN `OrderStatusChip.kt` là đủ để demo** nếu thầy không yêu cầu refactor `OrderHistoryScreen`.  
> ⚠️ Sau khi kéo thả → Build → Rebuild Project → Run.

---

## 📁 Nội dung folder này

```
13_order_status_chip/
├── NOTES.md
└── app/src/main/java/com/example/bookstore/
    └── ui/components/
        └── OrderStatusChip.kt     ← DROP-IN (Composable chip tái sử dụng)
```
