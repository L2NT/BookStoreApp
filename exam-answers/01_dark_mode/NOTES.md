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

## 4. TRƯỜNG HỢP INPUT / OUTPUT

### ThemeViewModel.toggleTheme():

| Trạng thái trước | Gọi | Kết quả | UI |
|---|---|---|---|
| `isDarkTheme = false` | `toggleTheme()` | `isDarkTheme = true` | Toàn app → Dark |
| `isDarkTheme = true` | `toggleTheme()` | `isDarkTheme = false` | Toàn app → Light |

### BookStoreTheme(isDarkTheme):

| `isDarkTheme` | colorScheme dùng | background | surface | onBackground |
|---|---|---|---|---|
| `false` | `lightColorScheme` | ⬜ Trắng / Sáng | ⬜ Trắng | ⬛ Đen |
| `true` | `darkColorScheme` | ⬛ Xám đậm | ⬛ Xám đậm | ⬜ Trắng |

### Switch trong SettingsScreen:

| Người dùng | Action | Switch state | Theme |
|---|---|---|---|
| Mở Settings lần đầu | *(hiển thị)* | OFF (false) | Light |
| Bật Switch | `toggleTheme()` | ON (true) | Dark ngay lập tức |
| Tắt Switch | `toggleTheme()` | OFF (false) | Light ngay lập tức |
| Back → mở lại Settings | *(recompose)* | ON/OFF theo ViewModel state | Giữ nguyên |

### Các variant thầy có thể yêu cầu:

**3 chế độ: Light / Dark / Theo hệ thống:**
```kotlin
// ThemeViewModel
enum class ThemeMode { LIGHT, DARK, SYSTEM }
private val _themeMode = MutableStateFlow(ThemeMode.SYSTEM)
val themeMode: StateFlow<ThemeMode> = _themeMode.asStateFlow()

fun setTheme(mode: ThemeMode) { _themeMode.value = mode }

// Theme.kt
@Composable
fun BookStoreTheme(themeMode: ThemeMode, content: @Composable () -> Unit) {
    val systemIsDark = isSystemInDarkTheme()
    val isDark = when (themeMode) {
        ThemeMode.LIGHT  -> false
        ThemeMode.DARK   -> true
        ThemeMode.SYSTEM -> systemIsDark   // Theo hệ thống
    }
    MaterialTheme(
        colorScheme = if (isDark) darkColorScheme() else lightColorScheme(),
        content = content
    )
}
```

**Lưu theme vào DataStore (persist sau khi tắt app):**
```kotlin
// ThemeViewModel — lưu vào SharedPreferences hoặc DataStore
@HiltViewModel
class ThemeViewModel @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : ViewModel() {
    val isDarkTheme = dataStore.data.map { prefs ->
        prefs[booleanPreferencesKey("dark_mode")] ?: false
    }.stateIn(viewModelScope, SharingStarted.Eagerly, false)

    fun toggleTheme() {
        viewModelScope.launch {
            dataStore.edit { prefs ->
                val current = prefs[booleanPreferencesKey("dark_mode")] ?: false
                prefs[booleanPreferencesKey("dark_mode")] = !current
            }
        }
    }
}
```

**Switch với icon mặt trời/mặt trăng:**
```kotlin
// SettingsScreen — Switch tùy chỉnh hơn
Row(modifier = Modifier.fillMaxWidth(), ...) {
    Icon(
        imageVector = if (isDarkTheme) Icons.Default.DarkMode else Icons.Default.LightMode,
        tint = if (isDarkTheme) Color(0xFFFFD700) else Color(0xFFFFA000)
    )
    Spacer(Modifier.width(12.dp))
    Text(if (isDarkTheme) "Chế độ tối" else "Chế độ sáng")
    Spacer(Modifier.weight(1f))
    Switch(
        checked = isDarkTheme,
        onCheckedChange = { themeViewModel.toggleTheme() }
    )
}
```

---

## 5. GỢI Ý GIẢI THÍCH CHO THẦY

**Tại sao ThemeViewModel phải hoist ở Activity:**
- Theme bọe toàn bộ `setContent { BookStoreTheme { ... } }` — nó phải được cấp trên tất cả Composable
- Nếu chỉ lưu trong SettingsScreen ViewModel (NavBackStackEntry scope) → khi back khỏi Settings, ViewModel bị hủy → theme reset về mặc định
- `by viewModels()` trong Activity → ViewModel sống cùng Activity → persist suốt phiên dùng app

**StateFlow vs Boolean thường:**
```kotlin
// Boolean thường — không reactive
var isDark = false
// ← Khi thay đổi, Compose KHÔNG biết để recompose → UI không cập nhật

// StateFlow — reactive
val _isDark = MutableStateFlow(false)
// ← Khi emit value mới, tất cả collector tự recompose ngay lập tức
```

**Collect ở Activity — cách đặc biệt:**
```kotlin
// MainActivity — dùng lifecycleScope + repeatOnLifecycle (KHÔNG dùng collectAsState)
lifecycleScope.launch {
    repeatOnLifecycle(Lifecycle.State.STARTED) {
        themeViewModel.isDarkTheme.collect { isDark ->
            // recompose setContent với isDark mới
        }
    }
}
// Hoặc đơn giản hơn với collectAsState trong setContent { ... }
val isDarkTheme by themeViewModel.isDarkTheme.collectAsState()
setContent {
    BookStoreTheme(isDarkTheme = isDarkTheme) {
        MainScreen()
    }
}
```

**darkColorScheme / lightColorScheme — Material3:**
- Tất cả component Material3 (`Card`, `Button`, `TextField`, `NavigationBar`...) tự động dùng đúng màu theo scheme
- Không cần sửa từng màn hình — chỉ cần component dùng `MaterialTheme.colorScheme.*` thay vì hardcode màu

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

---

## 📁 Nội dung folder này

```
01_dark_mode/
├── NOTES.md
└── app/src/main/java/com/example/bookstore/
    ├── MainActivity.kt                  ← REPLACE
    ├── viewmodel/
    │   └── ThemeViewModel.kt            ← DROP-IN (file mới)
    ├── ui/theme/
    │   └── Theme.kt                     ← REPLACE
    └── ui/screens/
        └── SettingsScreen.kt            ← REPLACE
```
