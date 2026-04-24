# 15 — STOCK BADGE (TỒN KHO)
**Tham chiếu:** Chương 12 — Mục 12.1.2  
**Loại:** Pure Composable — when { range } → (label, color) → Surface chip

---

## ĐỀ GỐC

### Input — Code hiện tại (không có thông tin tồn kho):
```kotlin
// BookDetailScreen.kt — sau ảnh bìa không có gì hiển thị tồn kho
LazyColumn {
    item { BookImageHeader(imageUrl = book.imageUrl) }
    item { BookBasicInfo(book = book) }   // ← lên thẳng thông tin sách, không có stock
    // ...
}
// Book model — không có field stockQuantity
data class Book(val id: String, val title: String, ..., val price: Double)
```

### Output — Kết quả cần đạt:
- Bên dưới ảnh bìa sách có **chip nhỏ** màu xanh/cam/đỏ
- Xanh lá: "Còn hàng" | Cam: "Sắp hết (x còn lại)" | Đỏ: "Hết hàng"
- Gọi đơn giản: `StockBadge(quantity = book.stockQuantity)`

### File path các file thực hiện:
```
app/src/main/java/com/example/bookstore/
├── data/model/Book.kt                      ← SỬA (thêm field stockQuantity)
├── ui/components/StockBadge.kt             ← TẠO MỚI
└── ui/screens/BookDetailScreen.kt          ← SỬA (thêm StockBadge vào LazyColumn)
```

### Cần thêm/sửa gì ở từng file:

**Book.kt** ← SỬA thêm field:
```kotlin
// TRƯỚC:
data class Book(val id: String, val title: String, val describe: String,
                val author: String, val imageUrl: String, val price: Double = 0.0)

// SAU — thêm stockQuantity với default:
data class Book(val id: String, val title: String, val describe: String,
                val author: String, val imageUrl: String, val price: Double = 0.0,
                val stockQuantity: Int = 10)   // ← mặc định 10 = Còn hàng
```

**StockBadge.kt** ← TẠO MỚI:
```kotlin
@Composable
fun StockBadge(quantity: Int) {
    val (label, color) = when {
        quantity <= 0 -> Pair("Hết hàng",                        Color(0xFFF44336))
        quantity <= 5 -> Pair("Sắp hết ($quantity còn lại)",     Color(0xFFFF9800))
        else          -> Pair("Còn hàng",                        Color(0xFF4CAF50))
    }
    // Dùng when { condition } không phải when(value) vì cần so sánh range
    Surface(
        shape  = RoundedCornerShape(4.dp),
        color  = color.copy(alpha = 0.12f),
        border = BorderStroke(1.dp, color)
    ) {
        Text(label, color = color, fontSize = 12.sp, fontWeight = FontWeight.Medium,
             modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp))
    }
}
```

**BookDetailScreen.kt** ← SỬA thêm item vào LazyColumn:
```kotlin
// Thêm giữa BookImageHeader và BookBasicInfo:
item { BookImageHeader(imageUrl = book.imageUrl) }
item {                                              // ← THÊM ĐOẠN NÀY
    Row(modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)) {
        StockBadge(quantity = book.stockQuantity)
    }
}
item { BookBasicInfo(book = book) }
```

---

## ĐỀ BIẾN THỂ — Các dạng thầy có thể ra

---

### Đề 2: Thêm icon vào badge (giống OrderStatusChip)

**Input:** StockBadge chỉ hiện text, không có icon  
**Output:** Có icon nhỏ trước text: ❌ Hết hàng | ⚠️ Sắp hết | ✅ Còn hàng

**Cách sửa StockBadge — đổi Pair thành Triple:**
```kotlin
val (label, color, icon) = when {
    quantity <= 0 -> Triple("Hết hàng",    Color(0xFFF44336), Icons.Outlined.RemoveShoppingCart)
    quantity <= 5 -> Triple("Sắp hết ($quantity còn lại)", Color(0xFFFF9800), Icons.Outlined.Warning)
    else          -> Triple("Còn hàng",    Color(0xFF4CAF50), Icons.Outlined.CheckCircle)
}
Surface(...) {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)) {
        Icon(icon, tint = color, modifier = Modifier.size(12.dp))
        Spacer(Modifier.width(4.dp))
        Text(label, color = color, ...)
    }
}
```

---

### Đề 3: Đổi ngưỡng cảnh báo từ 5 lên 10

**Input:** Sắp hết khi `quantity <= 5`  
**Output:** Sắp hết khi `quantity <= 10`

**Cách sửa StockBadge — đổi 1 số:**
```kotlin
quantity <= 10 -> Pair("Sắp hết ($quantity còn lại)", Color(0xFFFF9800))
//       ↑ đổi 5 thành 10
```

---

### Đề 4: 4 mức thay vì 3 mức

**Input:** 3 mức: Hết hàng / Sắp hết / Còn hàng  
**Output:** 4 mức: Hết hàng / Còn rất ít (1-3) / Sắp hết (4-10) / Còn hàng (>10)

**Cách sửa:**
```kotlin
val (label, color) = when {
    quantity <= 0  -> Pair("Hết hàng",                   Color(0xFFF44336))  // Đỏ
    quantity <= 3  -> Pair("Còn rất ít ($quantity)",     Color(0xFFE91E63))  // Hồng đậm
    quantity <= 10 -> Pair("Sắp hết ($quantity còn lại)", Color(0xFFFF9800)) // Cam
    else           -> Pair("Còn hàng",                   Color(0xFF4CAF50))  // Xanh
}
```

---

### Đề 5: Hiển thị số lượng cụ thể thay vì "Còn hàng"

**Input:** `quantity > 5` → chỉ hiện "Còn hàng" chung chung  
**Output:** `quantity > 5` → hiện "Còn 47 quyển" (số cụ thể)

**Cách sửa:**
```kotlin
else -> Pair(
    if (quantity > 100) "Còn hàng" else "Còn $quantity quyển",
    Color(0xFF4CAF50)
)
// quantity = 47  → "Còn 47 quyển"
// quantity = 150 → "Còn hàng" (không cần hiện số quá lớn)
```

---

### Đề 6: StockBadge trong BookCard (trang chủ), không chỉ BookDetailScreen

**Input:** StockBadge chỉ ở BookDetailScreen  
**Output:** Trang chủ và danh mục cũng thấy badge tồn kho trên mỗi card

**Cách sửa BookCard.kt — thêm StockBadge:**
```kotlin
// Trong phần giá sách, thêm badge:
Column {
    Text(price.toVnd(), color = AppColors.PriceColor, ...)
    Text(originalPrice.toVnd(), textDecoration = TextDecoration.LineThrough, ...)
    Spacer(Modifier.height(4.dp))
    StockBadge(quantity = book.stockQuantity)   // ← thêm dòng này
    Spacer(Modifier.height(6.dp))
    Button(onClick = onAddToCart, ...) { ... }
}
```

---

### Giải thích kỹ thuật cốt lõi

**`when { condition }` vs `when(value)` — khi nào dùng cái nào:**
```kotlin
// when(value) — chỉ check bằng nhau (equality)
when (quantity) {
    0    -> "Hết hàng"    // ← chỉ đúng khi quantity == 0 CHÍNH XÁC
    5    -> "Sắp hết"     // ← chỉ đúng khi quantity == 5 CHÍNH XÁC
}
// Không catch được quantity = 3, 4 → sai!

// when { condition } — check bất kỳ điều kiện boolean
when {
    quantity <= 0 -> "Hết hàng"    // ← đúng cho -5, -1, 0
    quantity <= 5 -> "Sắp hết"     // ← đúng cho 1, 2, 3, 4, 5
    else          -> "Còn hàng"    // ← đúng cho 6, 7, 100, ...
}
// ✓ Luôn dùng when { } khi cần so sánh range
```

**Giống pattern UVIndexIndicator (React/Weather):**
```
UV Index:       uvi → if uvi <= 2 → Low (green) | if uvi <= 5 → Moderate (yellow) | ...
Stock Badge: quantity → when qty <= 0 → Hết (đỏ)  | qty <= 5 → Sắp hết (cam)    | ...
Cùng pattern: số → ngưỡng → màu/label → render
```
