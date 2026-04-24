# BÀI TẬP KIỂM TRA THỰC HÀNH
**Dành cho:** Nhóm 35 — Kotlin Jetpack Compose  
**Tham chiếu:** Chương 12 — Mục 12.1.2: Quản lý sách (số lượng tồn kho)  
**Loại:** 🟦 Pattern B — Mở rộng UI (tạo Composable con với conditional styling)

---

## 1. ĐỀ BÀI

**Mục tiêu:** Kiểm tra kỹ năng tạo Composable với conditional rendering/styling. Bài tập này y hệt pattern `UVIndexIndicator` — thay vì chỉ số UV thì dùng số lượng tồn kho.

**Yêu cầu:** Tạo Composable `StockBadge(quantity: Int)` hiển thị trạng thái kho hàng với màu sắc cảnh báo. Tích hợp vào `BookDetailScreen`.

---

## 2. DỮ LIỆU ĐẦU VÀO (INPUT) — Thầy cung cấp data mẫu

```json
{ "bookId": "abc123", "title": "Kotlin in Action", "quantity": 3 }
```

```kotlin
// BookDetailScreen — hiện không hiển thị tồn kho
// ← Không có StockBadge, không có thông tin số lượng
```

---

## 3. YÊU CẦU KẾT QUẢ (OUTPUT)

**a.** Tạo `StockBadge(quantity: Int)` với 3 mức:
- `quantity <= 0` → **"Hết hàng"** — màu đỏ `Color(0xFFF44336)`
- `quantity in 1..5` → **"Sắp hết (x còn lại)"** — màu cam `Color(0xFFFF9800)`
- `quantity > 5` → **"Còn hàng"** — màu xanh lá `Color(0xFF4CAF50)`

**b.** Tích hợp vào `BookDetailScreen`: thêm `StockBadge(quantity = book.stockQuantity)` bên dưới ảnh bìa.

**c.** **Demo:** Mở chi tiết sách → thấy badge màu xanh/cam/đỏ tùy theo số lượng tồn.

**d.** **Giải thích:** So sánh `StockBadge` với `UVIndexIndicator` — cùng pattern: 1 input số → `when` → `(label, color)` → chip UI.

---

## 4. TRƯỜNG HỢP INPUT / OUTPUT

| `quantity` | Label hiển thị | Màu |
|---|---|---|
| `-5` *(âm — trường hợp lỗi DB)* | Hết hàng | 🔴 Đỏ `#F44336` |
| `0` | Hết hàng | 🔴 Đỏ `#F44336` |
| `1` | Sắp hết (1 còn lại) | 🟠 Cam `#FF9800` |
| `3` | Sắp hết (3 còn lại) | 🟠 Cam `#FF9800` |
| `5` | Sắp hết (5 còn lại) | 🟠 Cam `#FF9800` |
| `6` | Còn hàng | 🟢 Xanh lá `#4CAF50` |
| `100` | Còn hàng | 🟢 Xanh lá `#4CAF50` |

### Các variant thầy có thể yêu cầu:

**Ngưỡng cảnh báo khác (1–10 thay vì 1–5):**
```kotlin
val (label, color) = when {
    quantity <= 0  -> Pair("Hết hàng",                  Color(0xFFF44336))
    quantity <= 10 -> Pair("Sắp hết ($quantity còn lại)", Color(0xFFFF9800))  // ← đổi 5 → 10
    else           -> Pair("Còn hàng",                  Color(0xFF4CAF50))
}
```

**Thêm icon vào badge (giống OrderStatusChip):**
```kotlin
@Composable
fun StockBadge(quantity: Int) {
    val (label, color, icon) = when {
        quantity <= 0 -> Triple("Hết hàng",    Color(0xFFF44336), Icons.Outlined.RemoveShoppingCart)
        quantity <= 5 -> Triple("Sắp hết ($quantity còn lại)", Color(0xFFFF9800), Icons.Outlined.Warning)
        else          -> Triple("Còn hàng",    Color(0xFF4CAF50), Icons.Outlined.CheckCircle)
    }
    Surface(...) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, tint = color, modifier = Modifier.size(12.dp))
            Spacer(Modifier.width(4.dp))
            Text(label, color = color, ...)
        }
    }
}
```

**4 mức thay vì 3 mức:**
```kotlin
val (label, color) = when {
    quantity <= 0  -> Pair("Hết hàng",                  Color(0xFFF44336))   // Đỏ
    quantity <= 3  -> Pair("Còn rất ít ($quantity)",    Color(0xFFE91E63))   // Hồng — rất cấp bách
    quantity <= 10 -> Pair("Sắp hết ($quantity còn lại)", Color(0xFFFF9800)) // Cam
    else           -> Pair("Còn hàng",                  Color(0xFF4CAF50))   // Xanh
}
```

---

## 5. GỢI Ý GIẢI THÍCH CHO THẦY

**So sánh trực tiếp với UVIndexIndicator:**
```kotlin
// UVIndexIndicator.jsx (React - nhóm Weather)
const getUVInfo = (uvi) => {
    if (uvi <= 2) return { label: 'Thấp', color: 'green' }
    if (uvi <= 5) return { label: 'Trung bình', color: 'yellow' }
    ...
}

// StockBadge.kt (Kotlin - nhóm BookStore)
val (label, color) = when {
    quantity <= 0 -> Pair("Hết hàng",     Color(0xFFF44336))
    quantity <= 5 -> Pair("Sắp hết ($quantity còn lại)", Color(0xFFFF9800))
    else          -> Pair("Còn hàng",     Color(0xFF4CAF50))
}
```
**Cùng pattern: số → when/if → màu/label → render**

**Tại sao `when { condition }` thay vì `when(value)`:**
- `when(value)` chỉ check bằng nhau: `when(quantity) { 3 -> ... }`
- `when { condition }` check range và phức tạp hơn: `when { quantity <= 5 -> ... }` ✓
- Khi so sánh range (<=, >=, in ...) → luôn dùng `when { ... }` không có tham số

---

## 📦 HƯỚNG DẪN KÉO THẢ

**Kéo thư mục `app/` vào thư mục `BookStore/` — chọn Replace khi được hỏi.**

| File | Loại | Giải quyết yêu cầu |
|------|------|-------------------|
| `ui/components/StockBadge.kt` | ✅ DROP-IN (file mới) | Yêu cầu **(a)** — Composable tồn kho |

> ✅ **Chỉ cần DROP-IN `StockBadge.kt`** — thầy có thể test bằng cách gọi `StockBadge(quantity = 3)` trực tiếp.  
> 📝 Nếu thầy yêu cầu tích hợp vào BookDetailScreen → thêm `StockBadge(quantity = book.stockQuantity)` sau `BookImageHeader`.

---

## 📁 Nội dung folder này

```
15_stock_badge/
├── NOTES.md
└── app/src/main/java/com/example/bookstore/
    └── ui/components/
        └── StockBadge.kt    ← DROP-IN (Composable badge tồn kho)
```
