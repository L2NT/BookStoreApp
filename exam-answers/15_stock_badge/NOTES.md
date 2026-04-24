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
{
  "bookId": "abc123",
  "title": "Kotlin in Action",
  "quantity": 3
}
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

**b.** Tích hợp vào `BookDetailScreen`: thêm `StockBadge(quantity = book.quantity)` bên dưới giá sách.

**c.** **Demo:** Mở chi tiết sách → thấy badge màu xanh/cam/đỏ tùy theo số lượng tồn.

**d.** **Giải thích:** So sánh `StockBadge` với `UVIndexIndicator` — cùng pattern: 1 input số → `when` → `(label, color)` → chip UI.

---

## 4. GỢI Ý GIẢI THÍCH CHO THẦY

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

---

## 📦 HƯỚNG DẪN KÉO THẢ

**Kéo thư mục `app/` vào thư mục `BookStore/` — chọn Replace khi được hỏi.**

| File | Loại | Giải quyết yêu cầu |
|------|------|-------------------|
| `ui/components/StockBadge.kt` | ✅ DROP-IN (file mới) | Yêu cầu **(a)** — Composable tồn kho |

> ✅ **Chỉ cần DROP-IN `StockBadge.kt`** — thầy có thể test bằng cách gọi `StockBadge(quantity = 3)` trực tiếp.  
> 📝 Nếu thầy yêu cầu tích hợp vào BookDetailScreen → thêm thủ công vào file.

---

## 📁 Nội dung folder này

```
15_stock_badge/
├── NOTES.md
└── app/src/main/java/com/example/bookstore/
    └── ui/components/
        └── StockBadge.kt    ← DROP-IN (Composable badge tồn kho)
```

