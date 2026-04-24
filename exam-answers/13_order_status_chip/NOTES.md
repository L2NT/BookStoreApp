# 13 — ORDER STATUS CHIP
**Tham chiếu:** Chương 12 — Mục 12.1.2  
**Loại:** Pure Composable — when → (label, color, icon) → Surface chip

---

## ĐỀ GỐC

### Input — Code hiện tại (inline, không tái sử dụng):
```kotlin
// OrderHistoryScreen.kt — logic màu nằm cứng trong private function
private fun getStatusInfo(status: String): StatusInfo = when (status.uppercase()) {
    "PENDING"    -> StatusInfo("Chờ xác nhận",   Color(0xFFFF9800), Icons.Outlined.HourglassEmpty)
    "PROCESSING" -> StatusInfo("Đang xử lý",     Color(0xFF2196F3), Icons.Outlined.Inventory2)
    "SHIPPED"    -> StatusInfo("Đang giao hàng", Color(0xFF9C27B0), Icons.Outlined.LocalShipping)
    "DELIVERED"  -> StatusInfo("Đã giao hàng",   Color(0xFF4CAF50), Icons.Outlined.CheckCircle)
    "CANCELLED"  -> StatusInfo("Đã hủy",         Color(0xFFF44336), Icons.Outlined.Cancel)
    else         -> StatusInfo(status,            Color.Gray,        Icons.Outlined.HourglassEmpty)
}

// Render trong OrderCard:
Row(verticalAlignment = Alignment.CenterVertically) {
    Icon(statusInfo.icon, tint = statusInfo.color, modifier = Modifier.size(14.dp))
    Spacer(Modifier.width(4.dp))
    Text(statusInfo.label, color = statusInfo.color, fontSize = 13.sp)
}
// ← private → chỉ dùng được trong file này, không tái sử dụng
// ← render thẳng, không có chip/border → trông kém hơn
```

### Output — Kết quả cần đạt:
- File `OrderStatusChip.kt` mới trong `ui/components/`
- Chip có **nền mờ + viền màu** tương ứng trạng thái
- Gọi đơn giản: `OrderStatusChip(order.status)` → tự hiện đúng màu + label + icon
- Dùng được ở bất kỳ màn hình nào (OrderHistoryScreen, CheckoutScreen, ...)

### File path các file thực hiện:
```
app/src/main/java/com/example/bookstore/
├── ui/components/OrderStatusChip.kt        ← TẠO MỚI
└── ui/screens/OrderHistoryScreen.kt        ← SỬA (dùng chip thay inline)
```

### Cần thêm/sửa gì ở từng file:

**OrderStatusChip.kt** ← TẠO MỚI — toàn bộ logic:
```kotlin
@Composable
fun OrderStatusChip(status: String) {
    val (label, color, icon) = when (status.uppercase()) {
        "PENDING"                 -> Triple("Chờ xác nhận",   Color(0xFFFF9800), Icons.Outlined.HourglassEmpty)
        "PROCESSING", "CONFIRMED" -> Triple("Đang xử lý",     Color(0xFF2196F3), Icons.Outlined.Inventory2)
        "SHIPPED", "SHIPPING"     -> Triple("Đang giao hàng", Color(0xFF9C27B0), Icons.Outlined.LocalShipping)
        "DELIVERED"               -> Triple("Đã giao hàng",   Color(0xFF4CAF50), Icons.Outlined.CheckCircle)
        "CANCELLED"               -> Triple("Đã hủy",         Color(0xFFF44336), Icons.Outlined.Cancel)
        else                      -> Triple(status,            Color.Gray,        Icons.Outlined.HourglassEmpty as ImageVector)
    }
    Surface(
        shape  = RoundedCornerShape(16.dp),
        color  = color.copy(alpha = 0.12f),   // nền mờ
        border = BorderStroke(1.dp, color)    // viền rõ
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)) {
            Icon(icon, tint = color, modifier = Modifier.size(14.dp))
            Spacer(Modifier.width(4.dp))
            Text(label, color = color, fontSize = 12.sp, fontWeight = FontWeight.Medium)
        }
    }
}
```

**OrderHistoryScreen.kt** ← SỬA phần header của OrderCard:
```kotlin
// TRƯỚC — 4 dòng code inline:
Row(verticalAlignment = Alignment.CenterVertically) {
    Icon(statusInfo.icon, tint = statusInfo.color, modifier = Modifier.size(14.dp))
    Spacer(Modifier.width(4.dp))
    Text(statusInfo.label, color = statusInfo.color, fontSize = 13.sp)
}

// SAU — 1 dòng duy nhất:
OrderStatusChip(status = order.status)
```

---

## ĐỀ BIẾN THỂ — Các dạng thầy có thể ra

---

### Đề 2: Thêm trạng thái mới "REFUNDED" (Đã hoàn tiền)

**Input:** `OrderStatusChip` không xử lý status "REFUNDED"  
**Output:** "REFUNDED" → chip màu teal `#009688`, icon `Refresh`, label "Đã hoàn tiền"

**Cách sửa OrderStatusChip — thêm 1 dòng vào when:**
```kotlin
"REFUNDED" -> Triple("Đã hoàn tiền", Color(0xFF009688), Icons.Outlined.Refresh)
```

---

### Đề 3: Thêm trạng thái "RETURN_REQUESTED" (Yêu cầu trả hàng)

**Input:** Không xử lý "RETURN_REQUESTED"  
**Output:** Chip màu nâu `#795548`, icon `Undo`, label "Yêu cầu trả hàng"

**Cách sửa:**
```kotlin
"RETURN_REQUESTED", "RETURNING" -> Triple("Yêu cầu trả hàng", Color(0xFF795548), Icons.Outlined.Undo)
```

---

### Đề 4: Chip nhỏ hơn (compact) cho màn hình danh sách dày đặc

**Input:** `OrderStatusChip` có kích thước cố định (padding 10dp, icon 14dp, text 12sp)  
**Output:** Có 2 kích thước: mặc định và compact (padding 6dp, icon 10dp, text 10sp)

**Cách sửa — thêm param `compact`:**
```kotlin
@Composable
fun OrderStatusChip(status: String, compact: Boolean = false) {
    // ... (label, color, icon như cũ)
    val hPadding = if (compact) 6.dp  else 10.dp
    val vPadding = if (compact) 2.dp  else 4.dp
    val iconSize = if (compact) 10.dp else 14.dp
    val fontSize = if (compact) 10.sp else 12.sp

    Surface(shape = RoundedCornerShape(if (compact) 8.dp else 16.dp), ...) {
        Row(modifier = Modifier.padding(horizontal = hPadding, vertical = vPadding)) {
            Icon(icon, modifier = Modifier.size(iconSize), ...)
            Text(label, fontSize = fontSize, ...)
        }
    }
}
// Gọi compact: OrderStatusChip(order.status, compact = true)
```

---

### Đề 5: Chip hiển thị trong CheckoutScreen sau khi đặt hàng thành công

**Input:** CheckoutScreen hiện thị "Đặt hàng thành công!" nhưng không có chip trạng thái  
**Output:** Sau khi đặt hàng → hiện `OrderStatusChip("PENDING")` (chip cam "Chờ xác nhận")

**Cách sửa CheckoutScreen — thêm chip vào phần success UI:**
```kotlin
// Phần success
Column(horizontalAlignment = Alignment.CenterHorizontally) {
    Icon(Icons.Default.CheckCircle, tint = Color(0xFF4CAF50), modifier = Modifier.size(64.dp))
    Text("Đặt hàng thành công!", fontWeight = FontWeight.Bold, fontSize = 18.sp)
    Spacer(Modifier.height(8.dp))
    OrderStatusChip(status = "PENDING")   // ← thêm dòng này
    Text("Đơn hàng đang chờ xác nhận", color = Color.Gray, fontSize = 13.sp)
}
```

---

### Đề 6: Không có icon, chỉ có màu và text (phiên bản đơn giản hơn)

**Input:** Thầy yêu cầu chip đơn giản, không cần icon  
**Output:** Chip chỉ có nền màu + text label, không có icon

**Cách sửa — bỏ icon ra khỏi Triple và Row:**
```kotlin
// Đổi Triple thành Pair:
val (label, color) = when (status.uppercase()) {
    "PENDING"    -> Pair("Chờ xác nhận",   Color(0xFFFF9800))
    "PROCESSING" -> Pair("Đang xử lý",     Color(0xFF2196F3))
    // ...
}

Surface(shape = RoundedCornerShape(16.dp), color = color.copy(alpha = 0.12f), border = BorderStroke(1.dp, color)) {
    Text(label, color = color, fontSize = 12.sp, fontWeight = FontWeight.Medium,
         modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp))
    // ← Không có Row, không có Icon
}
```

---

### Giải thích kỹ thuật cốt lõi

**Pattern "tinted chip" — tại sao dùng Surface thay FilterChip:**
```kotlin
// FilterChip — phức tạp hơn, có built-in selected state, leadingIcon API
FilterChip(selected = true, onClick = {}, label = { Text("Đang xử lý") })
// ← Khó customize màu chính xác

// Surface — đơn giản, kiểm soát hoàn toàn
Surface(color = color.copy(alpha = 0.12f), border = BorderStroke(1.dp, color)) { ... }
// ← Màu nền = màu status mờ đi 88%, viền = màu status 100%
// ← Clean, tái sử dụng, không phụ thuộc built-in state
```

**Tại sao `status.uppercase()` quan trọng:**
```kotlin
// Backend trả về không nhất quán:
"pending" → uppercase() → "PENDING" ✓
"Shipped" → uppercase() → "SHIPPED" ✓
"CANCELLED" → uppercase() → "CANCELLED" ✓
// Không có uppercase() → khi backend trả "pending" sẽ vào else → chip xám, sai!
```
