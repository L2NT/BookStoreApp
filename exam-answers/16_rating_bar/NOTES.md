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
{ "bookId": "abc123", "averageRating": 4.3, "reviewCount": 128 }
```

---

## 3. YÊU CẦU KẾT QUẢ (OUTPUT)

**a.** Tạo `StarRating(rating: Double, maxStars: Int = 5, starSize: Dp = 16.dp, showCount: Boolean = false, count: Int = 0)`:
- Dùng `Icons.Default.Star` (đầy) và `Icons.Outlined.StarOutline` (rỗng) từ Material Icons
- Tô màu `AppColors.StarYellow` cho sao đầy, `Color.LightGray` cho sao rỗng
- Hỗ trợ half-star: `rating = 3.5` → 3 sao đầy + 1 sao nửa (`Icons.Default.StarHalf`)

**b.** Tích hợp vào `BookCard.kt`: thay `repeat(5) { Text("★") }` bằng `StarRating(rating = rating.toDouble(), showCount = true, count = reviewCount)`

**c.** **Demo:** Mở trang chủ → thấy sao icon Material đẹp hơn ký tự text, màu vàng rõ ràng.

**d.** **Giải thích:** Lợi ích của component tái sử dụng vs. inline code (DRY principle).

---

## 4. TRƯỜNG HỢP INPUT / OUTPUT

| `rating` | `maxStars` | Icons hiển thị |
|---|---|---|
| `0.0` | 5 | ☆☆☆☆☆ (5 StarOutline xám) |
| `1.0` | 5 | ★☆☆☆☆ (1 Star vàng + 4 xám) |
| `3.0` | 5 | ★★★☆☆ (3 Star vàng + 2 xám) |
| `3.5` | 5 | ★★★⯨☆ (3 Star + 1 StarHalf vàng + 1 xám) |
| `4.3` | 5 | ★★★★⯨ (4 Star + 1 StarHalf vàng — 4.3 >= 3.5) |
| `5.0` | 5 | ★★★★★ (5 Star vàng) |
| `2.0` | 3 | ★★★ (3 Star vàng — maxStars=3) |
| `1.5` | 3 | ★⯨☆ (1 Star + 1 StarHalf + 1 xám) |

### Logic chọn icon cho mỗi sao (vị trí `i`, `starValue = i+1`):
```kotlin
val icon = when {
    rating >= starValue       -> Icons.Default.Star      // 4.3 >= 4 → sao đầy tại vị trí 4
    rating >= starValue - 0.5 -> Icons.Default.StarHalf  // 4.3 >= 4.5? Không → xét tiếp
                                                          // 4.3 >= 4.5 = false → StarOutline
    else                      -> Icons.Outlined.StarOutline
}
// Ví dụ rating=4.3, starValue=5: 4.3 >= 5? No. 4.3 >= 4.5? No → StarOutline
// Ví dụ rating=4.3, starValue=4: 4.3 >= 4? Yes → Star (đầy)
```

### Các variant thầy có thể yêu cầu:

**Kích thước sao lớn hơn (cho BookDetailScreen):**
```kotlin
StarRating(rating = 4.3, starSize = 20.dp, showCount = true, count = 256)
```

**Chỉ hiển thị sao không có số lượt:**
```kotlin
StarRating(rating = 3.5)  // showCount mặc định = false
```

**10 sao thay vì 5 sao:**
```kotlin
StarRating(rating = 7.5, maxStars = 10)
// → 7 Star + 1 StarHalf + 2 StarOutline
```

**Màu sao tùy chỉnh:**
```kotlin
@Composable
fun StarRating(
    rating: Double,
    maxStars: Int = 5,
    starSize: Dp = 16.dp,
    filledColor: Color = AppColors.StarYellow,   // Thêm param màu
    emptyColor: Color = Color.LightGray,
    showCount: Boolean = false,
    count: Int = 0
)
```

---

## 5. GỢI Ý GIẢI THÍCH CHO THẦY

**Tại sao dùng Icon thay Text:**
- `Icons.Default.Star` = vector drawable chuẩn Material, scale mượt hơn ký tự Unicode
- Có thể tùy chỉnh `size`, `tint`, `modifier` dễ dàng
- `Icons.Outlined.StarOutline` cho sao rỗng — nhất quán với Design System
- `Icons.Default.StarHalf` cho nửa sao — không thể làm được với ký tự "★"

**DRY (Don't Repeat Yourself):**
```kotlin
// Trước: Copy paste ở BookCard, BookDetailScreen, ReviewItem...
repeat(5) { i -> Text(if (i < rating) "★" else "☆", ...) }

// Sau: 1 Composable dùng ở mọi nơi
StarRating(rating = 4.3, showCount = true, count = 128)
StarRating(rating = 4.3, starSize = 20.dp)  // Dùng ở BookDetailScreen
StarRating(rating = review.rating.toDouble(), starSize = 14.dp)  // Dùng ở ReviewItem
```

**Half-star logic chi tiết:**
```kotlin
// Với rating = 3.5:
// i=0, starValue=1: 3.5 >= 1 → Star (đầy)
// i=1, starValue=2: 3.5 >= 2 → Star (đầy)
// i=2, starValue=3: 3.5 >= 3 → Star (đầy)
// i=3, starValue=4: 3.5 >= 4? No. 3.5 >= 3.5? Yes → StarHalf
// i=4, starValue=5: 3.5 >= 5? No. 3.5 >= 4.5? No → StarOutline
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
