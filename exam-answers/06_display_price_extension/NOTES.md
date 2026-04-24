# BÀI TẬP KIỂM TRA THỰC HÀNH
**Dành cho:** Nhóm 35 — Kotlin Jetpack Compose  
**Tham chiếu:** Chương 11 — Bug: Giỏ hàng hiển thị "171đ" và "0đ" (CategoryDetailScreen + CartScreen)

---

## 1. ĐỀ BÀI

**Mục tiêu:** Kiểm tra kỹ năng viết và tái sử dụng Extension Function, xử lý Null Safety và thiết kế public API trong Kotlin.

**Yêu cầu:** Đoạn code dưới đây có 2 vấn đề: (1) `displayPrice()` là `private` nên `CartScreen` không dùng được; (2) sách được thêm vào giỏ với giá thô từ API (USD hoặc 0.0) thay vì giá VND đã normalize. Hãy fix lại.

---

## 2. DỮ LIỆU ĐẦU VÀO (INPUT) — Code bị lỗi

```kotlin
// CategoryDetailScreen.kt — displayPrice() là private, chỉ dùng được trong file này
private fun Book.displayPrice(): Double =
    if (price >= 1_000.0) price
    else 50_000.0 + (id.hashCode().absoluteValue % 20) * 10_000.0

// Thêm vào giỏ với GIÁ THÔ — chưa normalize
onAddToCart = { book ->
    cartViewModel.addBook(book, 1)  // ❌ book.price có thể là 1.71 (USD) hoặc 0.0
}

// CartScreen.kt — không gọi được displayPrice() vì nó private trong file khác
Text("${cartItem.price.toVnd()}")   // ❌ hiển thị "171đ" hoặc "0đ"
```

---

## 3. YÊU CẦU KẾT QUẢ (OUTPUT)

**a.** Chuyển `displayPrice()` từ `private` trong `CategoryDetailScreen.kt` sang `public` trong `Extensions.kt`.

**b.** Khi thêm vào giỏ: gọi `book.copy(price = book.displayPrice())` để normalize giá trước khi lưu.

**c.** `CartScreen` import và dùng `toVnd()` từ `Extensions.kt` — giá hiển thị đúng (vd: "120.000đ").

**d.** Demo: vào danh mục → thêm sách → vào giỏ hàng → giá hiển thị đúng, không còn "171đ" hay "0đ".

**e.** Giải thích: tại sao `private` Extension Function không thể tái sử dụng giữa các file?

---

## 4. GỢI Ý GIẢI THÍCH CHO THẦY

- **Extension Function scope**: `private fun Book.displayPrice()` chỉ visible trong file khai báo (file-level private). Để tái sử dụng, phải khai báo `public` (không cần từ khóa) trong 1 file utils.
- **Normalize giá**: `book.copy(price = book.displayPrice())` tạo bản sao với giá đã chuẩn hóa → Kotlin `data class` hỗ trợ `copy()` built-in.
- **Null Safety + Elvis**: `if (price >= 1_000.0) price else ...` — không cần null check vì `price: Double = 0.0` có default value.

---

## 📦 HƯỚNG DẪN KÉO THẢ

> ✅ **Project hiện tại ĐÃ ĐƯỢC FIX** — `displayPrice()` đã là `public` trong `Extensions.kt`.  
> **Không cần kéo thả gì.**

**Chỉ cần mở các file sau và giải thích với thầy:**

| File trong project | Điểm cần chỉ |
|--------------------|-------------|
| `utils/Extensions.kt` | Line 50-52: `fun Book.displayPrice(): Double` — public, ở utils |
| `ui/screens/CategoryDetailScreen.kt` | `addBook(book.copy(price = book.displayPrice()), ...)` |
| `ui/screens/CartScreen.kt` | `import com.example.bookstore.utils.toVnd` — dùng extension chung |

**File code lỗi tham chiếu:** `_broken/Extensions_broken.kt`

---

## 📁 Nội dung folder này

```
06_display_price_extension/
├── NOTES.md
└── _broken/
    └── Extensions_broken.kt    ← displayPrice() dạng private (INPUT cho đề)
```

