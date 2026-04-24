# BÀI TẬP KIỂM TRA THỰC HÀNH
**Dành cho:** Nhóm 35 — Kotlin Jetpack Compose  
**Tham chiếu:** Chương 11 — Khó khăn 1: Tích hợp Google Books API và xử lý JSON phức tạp

---

## 1. ĐỀ BÀI

**Mục tiêu:** Kiểm tra kỹ năng xây dựng DTO trung gian, dùng `@SerializedName`, viết Extension Function `toDomain()`, và áp dụng Null Safety với Elvis operator khi xử lý JSON lồng nhau từ API thực tế.

**Yêu cầu:** Google Books API trả về JSON có cấu trúc lồng nhiều tầng, nhiều trường optional. Đoạn code dưới đây bị lỗi khi parse vì thiếu DTO trung gian và không xử lý null. Hãy fix lại.

---

## 2. DỮ LIỆU ĐẦU VÀO (INPUT) — Code bị lỗi

```kotlin
// BỊ LỖI: parse thẳng JSON phức tạp không qua DTO
data class Book(
    val id: String,
    val title: String,       // ❌ Google Books trả về volumeInfo.title (lồng nhau)
    val author: String,      // ❌ volumeInfo.authors là List<String>, có thể null
    val imageUrl: String,    // ❌ volumeInfo.imageLinks.thumbnail, có thể null
    val describe: String,    // ❌ volumeInfo.description, có thể null, có thể có HTML tags
    val price: Double = 0.0  // ❌ saleInfo.retailPrice.amount, double lồng nhau, có thể null
)

// Repository bị lỗi — không có toDomain()
fun parseBook(item: Any): Book {
    return Book(
        id = item.id,                          // ❌ NullPointerException nếu id null
        title = item.volumeInfo.title,         // ❌ volumeInfo có thể null → crash
        author = item.volumeInfo.authors[0],   // ❌ List có thể rỗng → IndexOutOfBounds
        imageUrl = item.volumeInfo.imageLinks.thumbnail, // ❌ lồng null → crash
        describe = item.volumeInfo.description, // ❌ có HTML tags: "<b>nội dung</b>"
        price = item.saleInfo.retailPrice.amount // ❌ retailPrice có thể null → crash
    )
}
```

**JSON thực tế từ Google Books API:**
```json
{
  "id": "abc123",
  "volumeInfo": {
    "title": "Kotlin in Action",
    "authors": ["Dmitry Jemerov"],
    "description": "<b>Sách hay</b> về Kotlin...",
    "imageLinks": {
      "thumbnail": "http://books.google.com/..."
    }
  },
  "saleInfo": {
    "saleability": "FOR_SALE",
    "retailPrice": { "amount": 150000.0, "currencyCode": "VND" }
  }
}
```

---

## 3. YÊU CẦU KẾT QUẢ (OUTPUT)

**a.** Xây dựng DTO trung gian: `GoogleBookResponse`, `BookItem`, `VolumeInfo`, `SaleInfo`, `Price` — ánh xạ đúng cấu trúc JSON lồng nhau.

**b.** Viết Extension Function `BookItem.toDomain(): Book` — chuyển đổi DTO → domain model. Dùng Elvis operator `(?:)` cho mọi trường có thể null.

**c.** Xử lý các edge case: `authors` rỗng, `description` có HTML tags, `thumbnail` dùng `http` thay vì `https`.

**d.** Demo: tìm kiếm sách → hiển thị đúng tên/tác giả/ảnh bìa, không crash.

**e.** Giải thích: tại sao cần DTO trung gian thay vì map thẳng `Book` từ JSON?

---

## 4. GỢI Ý GIẢI THÍCH CHO THẦY

**Tại sao cần DTO trung gian:**
- JSON có cấu trúc lồng nhau (`volumeInfo.title`) nhưng `Book` domain model cần flat (`title`)
- DTO tách biệt "cấu trúc API" và "cấu trúc business logic" → khi API thay đổi, chỉ sửa DTO, không ảnh hưởng domain model

**Elvis operator chain:**
```kotlin
val author = volumeInfo?.authors?.firstOrNull() ?: "Khuyết danh"
//                    ↑ null safe  ↑ null safe    ↑ default nếu cả chuỗi null
```

**Xóa HTML tags bằng Regex:**
```kotlin
description?.replace(Regex("<.*?>"), "") ?: "Đang cập nhật..."
//           ↑ remove <b>, <br>, etc.     ↑ Elvis nếu description null
```

**HTTP → HTTPS:**
```kotlin
thumbnailUrl?.replace("http:", "https:")
// Google Books API trả về http → Android 9+ chặn cleartext → phải đổi sang https
```

---

## 📦 HƯỚNG DẪN KÉO THẢ

> ✅ **Project hiện tại ĐÃ ĐƯỢC FIX** — `GoogleBookDto.kt` + `BookRepository.toDomainModel()` đã đúng.  
> **Không cần kéo thả gì.**

**Chỉ cần mở các file sau và giải thích với thầy:**

| File trong project | Điểm cần chỉ |
|--------------------|-------------|
| `data/dto/GoogleBookDto.kt` | `GoogleBookResponse`, `VolumeInfo`, `SaleInfo`, `Price` — DTO lồng nhau |
| `data/repo/BookRepository.kt` | `fun BookItem.toDomainModel()` — Elvis `?:`, safe call `?.`, Regex xóa HTML |

**File code lỗi tham chiếu:** `_broken/BookRepository_broken.kt`

---

## 📁 Nội dung folder này

```
10_google_books_dto/
├── NOTES.md
└── _broken/
    └── BookRepository_broken.kt    ← Code parse thẳng không qua DTO (INPUT)
```

