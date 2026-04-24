# 16 — STAR RATING (ĐÁNH GIÁ SAO)
**Tham chiếu:** Chương 12 — Mục 12.1.1  
**Loại:** Pure Composable — Double → repeat(maxStars) → Icon (Star/StarHalf/StarOutline)

---

## ĐỀ GỐC

### Input — Code hiện tại (dùng ký tự Text, không tái sử dụng):
```kotlin
// BookCard.kt — sao render bằng ký tự Unicode "★"/"☆"
Row(verticalAlignment = Alignment.CenterVertically) {
    repeat(5) { i ->
        Text(
            text     = if (i < rating) "★" else "☆",
            color    = if (i < rating) AppColors.StarYellow else Color.LightGray,
            fontSize = 12.sp
        )
    }
    Spacer(Modifier.width(3.dp))
    Text(text = "($reviewCount)", color = Color.Gray, fontSize = 10.sp)
}
// Vấn đề:
// ← rating là Int → chỉ hiện 3 hoặc 4 sao, không hiện 3.5
// ← ký tự "★" scale kém, không tùy chỉnh được size/tint
// ← copy-paste ở nhiều chỗ, không tái sử dụng
```

### Output — Kết quả cần đạt:
- File `StarRating.kt` mới trong `ui/components/`
- Hỗ trợ **half-star**: rating `3.5` → ★★★⯨☆ (3 đầy + 1 nửa + 1 rỗng)
- BookCard dùng `StarRating(rating = rating.toDouble(), showCount = true, count = reviewCount)`
- Sao dùng `Icon` Material vector (sắc nét hơn, scale tốt hơn ký tự Unicode)

### File path các file thực hiện:
```
app/src/main/java/com/example/bookstore/
├── ui/components/StarRating.kt             ← TẠO MỚI
└── ui/components/BookCard.kt              ← SỬA (thay inline bằng StarRating)
```

### Cần thêm/sửa gì ở từng file:

**StarRating.kt** ← TẠO MỚI — logic half-star:
```kotlin
@Composable
fun StarRating(
    rating   : Double,
    maxStars : Int     = 5,
    starSize : Dp      = 16.dp,
    showCount: Boolean = false,
    count    : Int     = 0
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        repeat(maxStars) { i ->
            val starValue = i + 1   // vị trí 0 → starValue 1, vị trí 4 → starValue 5

            // Logic chọn icon:
            // rating >= starValue     → sao ĐẦY  (ví dụ: rating=4.3, starValue=4  → 4.3>=4 ✓)
            // rating >= starValue-0.5 → nửa sao  (ví dụ: rating=4.3, starValue=5  → 4.3>=4.5 ✗ → StarOutline)
            //                                     (ví dụ: rating=3.5, starValue=4  → 3.5>=3.5 ✓ → StarHalf)
            // else                   → sao RỖNG
            val icon = when {
                rating >= starValue       -> Icons.Default.Star
                rating >= starValue - 0.5 -> Icons.Default.StarHalf
                else                      -> Icons.Outlined.StarOutline
            }
            val tint = if (rating >= starValue - 0.5) AppColors.StarYellow else Color.LightGray

            Icon(icon, contentDescription = null, tint = tint, modifier = Modifier.size(starSize))
        }
        if (showCount && count > 0) {
            Spacer(Modifier.width(3.dp))
            Text("($count)", color = Color.Gray, fontSize = 10.sp)
        }
    }
}
```

**BookCard.kt** ← SỬA thay inline bằng component:
```kotlin
// TRƯỚC — 9 dòng:
Row(verticalAlignment = Alignment.CenterVertically) {
    repeat(5) { i ->
        Text(text = if (i < rating) "★" else "☆",
             color = if (i < rating) AppColors.StarYellow else Color.LightGray,
             fontSize = 12.sp)
    }
    Spacer(Modifier.width(3.dp))
    Text(text = "($reviewCount)", color = Color.Gray, fontSize = 10.sp)
}

// SAU — 4 dòng:
StarRating(
    rating    = rating.toDouble(),
    showCount = true,
    count     = reviewCount
)
```

---

## ĐỀ BIẾN THỂ — Các dạng thầy có thể ra

---

### Đề 2: Dùng StarRating ở BookDetailScreen (sao to hơn)

**Input:** BookDetailScreen không có component hiển thị sao đánh giá tổng hợp  
**Output:** Trong `BookBasicInfo` hoặc trước phần review có hiện sao với size lớn hơn

**Cách sửa BookBasicInfo.kt hoặc BookDetailScreen — chỉ thêm 1 dòng:**
```kotlin
// Trong BookBasicInfo, sau phần giá:
StarRating(
    rating    = book.rating ?: 4.0,    // dùng rating từ API hoặc default
    starSize  = 20.dp,                  // ← to hơn BookCard (16.dp)
    showCount = true,
    count     = book.reviewCount ?: 0
)
```

---

### Đề 3: Sao có thể click được — người dùng tự đánh giá

**Input:** StarRating chỉ hiển thị rating, không tương tác được  
**Output:** Người dùng click vào sao 4 → rating đổi thành 4.0 (cho form đánh giá)

**Cách sửa — thêm param `onRatingChange`:**
```kotlin
@Composable
fun StarRating(
    rating: Double,
    maxStars: Int = 5,
    starSize: Dp = 16.dp,
    onRatingChange: ((Double) -> Unit)? = null,   // ← null = chỉ đọc, không click
    showCount: Boolean = false,
    count: Int = 0
) {
    Row {
        repeat(maxStars) { i ->
            val starValue = (i + 1).toDouble()
            // ...icon logic như cũ...
            Icon(
                icon, tint = tint,
                modifier = Modifier
                    .size(starSize)
                    .then(
                        if (onRatingChange != null)
                            Modifier.clickable { onRatingChange(starValue) }
                        else Modifier
                    )
            )
        }
    }
}

// Dùng trong ReviewScreen (form đánh giá):
var myRating by remember { mutableStateOf(0.0) }
StarRating(
    rating         = myRating,
    starSize       = 32.dp,
    onRatingChange = { myRating = it }   // click vào sao 3 → myRating = 3.0
)
```

---

### Đề 4: Thay đổi số sao tối đa — 10 sao thay vì 5 sao

**Input:** `maxStars = 5` mặc định  
**Output:** Hệ thống đánh giá 10 sao (rating 7.5/10)

**Cách sử dụng — không cần sửa StarRating:**
```kotlin
// Chỉ truyền maxStars = 10 khi gọi:
StarRating(rating = 7.5, maxStars = 10, starSize = 14.dp)
// → 7 sao đầy + 1 nửa sao + 2 sao rỗng
```

---

### Đề 5: Màu sao tùy chỉnh (không phải vàng)

**Input:** Sao luôn màu vàng `AppColors.StarYellow`  
**Output:** Cho phép truyền màu vào, ví dụ sao màu xanh cho "Độ tin cậy"

**Cách sửa — thêm param màu:**
```kotlin
@Composable
fun StarRating(
    rating      : Double,
    maxStars    : Int     = 5,
    starSize    : Dp      = 16.dp,
    filledColor : Color   = AppColors.StarYellow,   // ← thêm
    emptyColor  : Color   = Color.LightGray,        // ← thêm
    showCount   : Boolean = false,
    count       : Int     = 0
) {
    val tint = if (rating >= starValue - 0.5) filledColor else emptyColor
    //                                        ↑ dùng filledColor thay vì hardcode
}

// Gọi với màu tùy chỉnh:
StarRating(rating = 4.0, filledColor = Color(0xFF2196F3))  // sao xanh dương
StarRating(rating = 5.0, filledColor = Color(0xFF9C27B0))  // sao tím
```

---

### Đề 6: Hiển thị điểm số bên cạnh (vd: "4.3 ★★★★☆")

**Input:** StarRating chỉ hiện sao và số lượt đánh giá `(128)`  
**Output:** Thêm điểm số trước dãy sao: `4.3 ★★★★☆ (128)`

**Cách sửa — thêm phần điểm số vào Row:**
```kotlin
Row(verticalAlignment = Alignment.CenterVertically) {
    // Thêm điểm số trước sao:
    Text(
        text  = String.format("%.1f", rating),   // "4.3"
        color = AppColors.StarYellow,
        fontWeight = FontWeight.Bold,
        fontSize = starSize.value.sp * 0.9f
    )
    Spacer(Modifier.width(3.dp))
    // ... phần sao như cũ ...
    repeat(maxStars) { i -> Icon(...) }
    // ... phần count như cũ ...
}
```

---

### Giải thích kỹ thuật cốt lõi

**Logic half-star từng bước — với rating = 3.5:**
```
i=0, starValue=1: 3.5 >= 1 ?  YES → Icons.Default.Star     (sao đầy, vàng)
i=1, starValue=2: 3.5 >= 2 ?  YES → Icons.Default.Star     (sao đầy, vàng)
i=2, starValue=3: 3.5 >= 3 ?  YES → Icons.Default.Star     (sao đầy, vàng)
i=3, starValue=4: 3.5 >= 4 ?  NO
                  3.5 >= 3.5? YES → Icons.Default.StarHalf  (nửa sao, vàng)
i=4, starValue=5: 3.5 >= 5 ?  NO
                  3.5 >= 4.5? NO  → Icons.Outlined.StarOutline (sao rỗng, xám)
Kết quả: ★★★⯨☆
```

**Tại sao Icon thay vì Text "★":**
```
Text("★") — ký tự Unicode font
  ← Phụ thuộc font thiết bị (có thể khác nhau trên các máy)
  ← Không thể đổi size đơn lẻ từng sao
  ← Không hỗ trợ half-star (không có ký tự "⯨" chuẩn)

Icon(Icons.Default.Star) — vector drawable
  ← Scale mượt ở mọi kích thước (12.dp đến 40.dp đều đẹp)
  ← Màu sắc qua tint, độc lập từng icon
  ← StarHalf sẵn có trong Material Icons
```
