# BÀI TẬP KIỂM TRA THỰC HÀNH
**Dành cho:** Nhóm 35 — Kotlin Jetpack Compose  
**Tham chiếu:** Chương 11 — Bug: Dialog "Lưu thành công" không hiển thị (ProfileScreen.kt)

---

## 1. ĐỀ BÀI

**Mục tiêu:** Kiểm tra kỹ năng phân tích vòng đời `LaunchedEffect` trong Jetpack Compose và fix bug state management.

**Yêu cầu:** Đoạn code `ProfileScreen.kt` dưới đây có bug logic khiến Dialog "Lưu thành công" không bao giờ hiển thị dù đã lưu thành công. Hãy xác định nguyên nhân và sửa lại.

---

## 2. DỮ LIỆU ĐẦU VÀO (INPUT) — Code bị lỗi

```kotlin
// ProfileScreen.kt — BỊ LỖI
var showDialog by remember { mutableStateOf(false) }

// Bug: LaunchedEffect(Unit) bên trong if → chạy 1 lần duy nhất khi
// block if được compose lần đầu, gọi reset ngay lập tức
if (viewModel.updateSuccess) {
    LaunchedEffect(Unit) {        // ← BUG: Unit không thay đổi → chỉ chạy 1 lần
        showDialog = true
        viewModel.updateSuccess = false  // ← reset ngay → Dialog tắt ngay lập tức
    }
}

if (showDialog) {
    AlertDialog(
        onDismissRequest = { showDialog = false },
        confirmButton = {
            TextButton(onClick = { showDialog = false }) { Text("OK") }
        },
        text = { Text("Lưu thành công!") }
    )
}
```

---

## 3. YÊU CẦU KẾT QUẢ (OUTPUT)

**a.** Giải thích: `LaunchedEffect(Unit)` chạy khi nào? Tại sao đặt bên trong `if` gây bug?

**b.** Sửa lại: xóa `LaunchedEffect` xấu, chỉ reset flag `updateSuccess` trong `confirmButton onClick`.

**c.** Demo: bấm "Lưu thay đổi" → Dialog "Thành công" xuất hiện → bấm OK → Dialog tắt và quay lại.

---

## 4. GỢI Ý GIẢI THÍCH CHO THẦY

**Nguyên nhân bug:**
- `LaunchedEffect(Unit)` với key `Unit` (không đổi) → chỉ chạy **1 lần duy nhất** khi block đó lần đầu được Compose
- Nhưng ngay lần đó, nó set `showDialog = true` rồi `updateSuccess = false` → recompose → `if (viewModel.updateSuccess)` là `false` → block bị xóa khỏi composition → Dialog chưa kịp hiện đã bị tắt

**Cách fix đúng:**
```kotlin
// Không dùng LaunchedEffect — updateSuccess trực tiếp điều khiển Dialog
if (viewModel.updateSuccess) {
    AlertDialog(
        onDismissRequest = { viewModel.updateSuccess = false },
        confirmButton = {
            TextButton(onClick = {
                viewModel.updateSuccess = false  // chỉ reset khi user bấm OK
                navController.popBackStack()
            }) { Text("OK") }
        },
        title = { Text("Thành công") },
        text  = { Text("Thông tin tài khoản đã được cập nhật.") }
    )
}
```

---

## 📦 HƯỚNG DẪN KÉO THẢ

> ✅ **Project hiện tại ĐÃ ĐƯỢC FIX** — ProfileScreen.kt đã đúng.  
> **Không cần kéo thả gì.**

**Chỉ cần mở file và giải thích với thầy:**

| File trong project | Điểm cần chỉ |
|--------------------|-------------|
| `ui/screens/ProfileScreen.kt` | Line 31-43: `if (viewModel.updateSuccess)` trực tiếp bọc `AlertDialog`, không có `LaunchedEffect` |

**Nếu thầy yêu cầu reproduce bug → fix:**  
Xem `_broken/ProfileScreen_broken.kt` — code có bug để làm INPUT.

---

## 📁 Nội dung folder này

```
04_profile_dialog_explain/
├── NOTES.md                       ← File này
└── _broken/
    └── ProfileScreen_broken.kt    ← Code CÓ BUG (INPUT cho đề)
```

