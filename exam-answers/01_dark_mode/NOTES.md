# BÀI TẬP KIỂM TRA THỰC HÀNH
**Dành cho:** Nhóm 35 — Kotlin Jetpack Compose  
**Tham chiếu:** Chương 12 — Mục 12.1.3: Hỗ trợ chế độ tối (Dark Mode)

---

## 1. ĐỀ BÀI

**Mục tiêu:** Kiểm tra kỹ năng áp dụng MaterialTheme động và quản lý trạng thái UI toàn cục với ViewModel + StateFlow trong Jetpack Compose.

**Yêu cầu:** Ứng dụng BookStore hiện chỉ hỗ trợ Light Theme cố định. Dựa trên hướng phát triển đã đề xuất trong báo cáo (Mục 12.1.3), hãy implement tính năng Dark Mode cho phép người dùng chuyển đổi giao diện sáng/tối ngay trong màn hình Cài đặt.

---

## 2. DỮ LIỆU ĐẦU VÀO (INPUT) — Code hiện tại bị thiếu

```kotlin
// Theme.kt — lightColorScheme cứng, không có tham số isDarkTheme
@Composable
fun BookStoreTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = BookStoreColorScheme, // ← chỉ có light, không thay đổi được
        content = content
    )
}

// MainActivity.kt — không có ThemeViewModel, theme cố định
setContent {
    BookStoreTheme {   // ← không nhận isDarkTheme
        MainScreen()
    }
}

// SettingsScreen.kt — không có Switch Dark Mode
// (chỉ có 2 item: Đổi mật khẩu, Yêu cầu xóa tài khoản)
```

---

## 3. YÊU CẦU KẾT QUẢ (OUTPUT)

**a.** Tạo `ThemeViewModel`: dùng `StateFlow<Boolean>` lưu trạng thái `isDarkTheme`, hàm `toggleTheme()`.

**b.** Sửa `Theme.kt`: nhận param `isDarkTheme: Boolean`, dùng `darkColorScheme` hoặc `lightColorScheme` tương ứng.

**c.** Sửa `MainActivity.kt`: inject `ThemeViewModel` bằng `by viewModels()`, collect `isDarkTheme`, truyền vào `BookStoreTheme`.

**d.** Sửa `SettingsScreen.kt`: thêm Switch "Chế độ tối", connect với `ThemeViewModel` (lấy instance Activity-scope).

**e.** **Demo:** bật Switch → toàn bộ app chuyển dark ngay lập tức, tắt Switch → về light.

**f.** **Giải thích:** Tại sao `ThemeViewModel` phải được hoist ở `MainActivity` thay vì trong `SettingsScreen`? Tại sao dùng `StateFlow` thay vì biến `Boolean` thông thường?

---

## 4. GỢI Ý GIẢI THÍCH CHO THẦY

- **ViewModel hoist tại Activity** vì theme bọc toàn bộ app — nếu chỉ lưu trong SettingsScreen ViewModel thì khi back khỏi Settings, state mất.
- **StateFlow** → khi `isDarkTheme` thay đổi, tất cả Composable đang `collect` tự recompose ngay — đây là reactive programming.
- **darkColorScheme / lightColorScheme** là Material 3 API — tất cả component tự động dùng đúng màu theo scheme, không cần sửa từng màn hình.

---

## 📦 HƯỚNG DẪN KÉO THẢ

**Kéo thư mục `app/` vào thư mục `BookStore/` — chọn Replace khi được hỏi.**

| File | Loại | Giải quyết yêu cầu |
|------|------|-------------------|
| `viewmodel/ThemeViewModel.kt` | ✅ DROP-IN (file mới) | Yêu cầu **(a)** — StateFlow + toggleTheme |
| `ui/theme/Theme.kt` | 🔄 REPLACE | Yêu cầu **(b)** — isDarkTheme param + darkColorScheme |
| `MainActivity.kt` | 🔄 REPLACE | Yêu cầu **(c)** — inject ThemeViewModel, collect state |
| `ui/screens/SettingsScreen.kt` | 🔄 REPLACE | Yêu cầu **(d)** — Switch Dark Mode UI |

> ⚠️ **Không cần kéo thả nếu thầy chỉ hỏi giải thích lý thuyết.**  
> ⚠️ Sau khi kéo thả → nhấn **Build → Rebuild Project** → Run app.

