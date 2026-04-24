# BÀI TẬP KIỂM TRA THỰC HÀNH
**Dành cho:** Nhóm 35 — Kotlin Jetpack Compose  
**Tham chiếu:** Chương 12 — Mục 12.1.1: Tích hợp đánh giá nâng cao  
**Loại:** 🟦 Pattern B — Mở rộng UI (tạo Composable con tái sử dụng)

---

## 1. ĐỀ BÀI

**Mục tiêu:** Kiểm tra kỹ năng tạo Composable nhận dữ liệu số và render UI động. Bài tập này tạo component `StarRating` hiển thị sao đánh giá với icon Material Icons.

**Yêu cầu:** Hiện tại `BookCard` hiển thị sao bằng Text ký tự "★"/"☆". Tách thành Composable `StarRating(rating: Double, maxStars: Int = 5)` tái sử dụng được, dùng `Icon` Material với màu đúng chuẩn.

---

## 2. DỮ LIỆU ĐẦU VÀO (INPUT) — Code hiện tại trong BookCard

```kotlin
// BookCard.kt — sao render bằng Text thủ công, không tái sử dụng
Row(verticalAlignment = Alignment.CenterVertically) {
    repeat(5) { i ->
        Text(
            text     = if (i < rating) "★" else "☆",   // ← Ký tự text, không phải Icon
            color    = if (i < rating) AppColors.StarYellow else Color.LightGray,
            fontSize = 12.sp
        )
    }
    Spacer(Modifier.width(3.dp))
    Text(text = "($reviewCount)", color = Color.Gray, fontSize = 10.sp)
}
// ← Không tái sử dụng được, không hỗ trợ half-star, không nhận Double rating
```

**Data mẫu thầy có thể cung cấp:**
```json
{
  "bookId": "abc123",
  "averageRating": 4.3,
  "reviewCount": 128
}
```

---

## 3. YÊU CẦU KẾT QUẢ (OUTPUT)

**a.** Tạo `StarRating(rating: Double, maxStars: Int = 5, starSize: Dp = 16.dp)`:
- Dùng `Icons.Default.Star` (đầy) và `Icons.Outlined.Star` (rỗng) từ Material Icons
- Tô màu `AppColors.StarYellow` cho sao đầy, `Color.LightGray` cho sao rỗng
- Hỗ trợ half-star: `rating = 3.5` → 3 sao đầy + 1 sao nửa (dùng `Icons.AutoMirrored` hoặc clip)

**b.** Tích hợp vào `BookCard.kt`: thay `repeat(5) { Text("★") }` bằng `StarRating(rating = rating.toDouble())`

**c.** **Demo:** Mở trang chủ → thấy sao icon Material đẹp hơn ký tự text, màu vàng rõ ràng.

**d.** **Giải thích:** Lợi ích của component tái sử dụng vs. inline code (DRY principle).

---

## 4. GỢI Ý GIẢI THÍCH CHO THẦY

**Tại sao dùng Icon thay Text:**
- `Icons.Default.Star` = vector drawable chuẩn Material, scale mượt hơn ký tự Unicode
- Có thể tùy chỉnh `size`, `tint`, `modifier` dễ dàng
- `Icons.Outlined.Star` cho sao rỗng — nhất quán với Design System

**DRY (Don't Repeat Yourself):**
```kotlin
// Trước: Copy paste ở BookCard, BookDetailScreen, ReviewItem...
repeat(5) { i -> Text(if (i < rating) "★" else "☆", ...) }

// Sau: 1 Composable dùng ở mọi nơi
StarRating(rating = 4.3)  // ← đơn giản, nhất quán
```

---

## 📦 HƯỚNG DẪN KÉO THẢ

**Kéo thư mục `app/` vào thư mục `BookStore/` — chọn Replace khi được hỏi.**

| File | Loại | Giải quyết yêu cầu |
|------|------|-------------------|
| `ui/components/StarRating.kt` | ✅ DROP-IN (file mới) | Yêu cầu **(a)** — Composable sao đánh giá |
| `ui/components/BookCard.kt` | 🔄 REPLACE (tuỳ chọn) | Yêu cầu **(b)** — dùng StarRating thay inline |

> ✅ **Chỉ cần DROP-IN `StarRating.kt`** nếu thầy chỉ yêu cầu tạo component.  
> 🔄 REPLACE `BookCard.kt` nếu thầy yêu cầu tích hợp và demo luôn.

---

## 📁 Nội dung folder này

```
16_rating_bar/
├── NOTES.md
└── app/src/main/java/com/example/bookstore/
    └── ui/components/
        └── StarRating.kt    ← DROP-IN (Composable sao đánh giá tái sử dụng)
```

