# 01 — DARK MODE
**Tham chiếu:** Chương 12 — Mục 12.1.3  
**Loại:** ViewModel + StateFlow + MaterialTheme động

---

## ĐỀ GỐC

### Input — Code hiện tại (bị thiếu):
```kotlin
// ui/theme/Theme.kt
@Composable
fun BookStoreTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(...),   // ← cứng, không đổi được
        content = content
    )
}

// MainActivity.kt
setContent {
    BookStoreTheme {          // ← không nhận isDarkTheme
        MainScreen()
    }
}

// SettingsScreen.kt — chỉ có 2 item, KHÔNG có Switch Dark Mode
```

### Output — Kết quả cần đạt:
- `SettingsScreen` có dòng **"Chế độ tối"** kèm `Switch`
- Bật Switch → **toàn app tối ngay lập tức** (nền đen, chữ trắng)
- Tắt Switch → về sáng
- Chuyển màn hình khác rồi quay lại Settings → Switch vẫn đúng trạng thái

### File path các file thực hiện:
```
app/src/main/java/com/example/bookstore/
├── MainActivity.kt                        ← SỬA
├── viewmodel/ThemeViewModel.kt            ← TẠO MỚI
├── ui/theme/Theme.kt                      ← SỬA
└── ui/screens/SettingsScreen.kt           ← SỬA
```

### Cần thêm/sửa gì ở từng file:

**ThemeViewModel.kt** ← TẠO MỚI:
```kotlin
@HiltViewModel
class ThemeViewModel @Inject constructor() : ViewModel() {
    private val _isDarkTheme = MutableStateFlow(false)
    val isDarkTheme: StateFlow<Boolean> = _isDarkTheme.asStateFlow()

    fun toggleTheme() {
        _isDarkTheme.value = !_isDarkTheme.value
    }
}
```

**Theme.kt** ← thêm param `isDarkTheme`:
```kotlin
// TRƯỚC:
fun BookStoreTheme(content: @Composable () -> Unit)

// SAU:
fun BookStoreTheme(isDarkTheme: Boolean = false, content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = if (isDarkTheme) darkColorScheme() else lightColorScheme(),
        content = content
    )
}
```

**MainActivity.kt** ← inject ViewModel + collect:
```kotlin
// Thêm:
private val themeViewModel: ThemeViewModel by viewModels()

// Trong onCreate → setContent:
val isDarkTheme by themeViewModel.isDarkTheme.collectAsState()
setContent {
    BookStoreTheme(isDarkTheme = isDarkTheme) {
        MainScreen()
    }
}
```

**SettingsScreen.kt** ← thêm Switch row:
```kotlin
// Thêm param:
fun SettingsScreen(navController: NavController, themeViewModel: ThemeViewModel = ...)

// Thêm vào danh sách item:
val isDarkTheme by themeViewModel.isDarkTheme.collectAsStateWithLifecycle()

Row(...) {
    Text("Chế độ tối")
    Switch(checked = isDarkTheme, onCheckedChange = { themeViewModel.toggleTheme() })
}
```

---

## ĐỀ BIẾN THỂ — Các dạng thầy có thể ra

---

### Đề 2: Thêm icon mặt trời/mặt trăng vào Switch

**Input:** Switch chỉ có text "Chế độ tối", không có icon

**Output:** Row hiển thị icon 🌙 khi dark / ☀️ khi light, kèm Switch bên phải

**Cách sửa SettingsScreen:**
```kotlin
val icon = if (isDarkTheme) Icons.Default.DarkMode else Icons.Default.LightMode
val label = if (isDarkTheme) "Chế độ tối" else "Chế độ sáng"

Row(modifier = Modifier.fillMaxWidth().padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
    Icon(icon, contentDescription = null, tint = if (isDarkTheme) Color(0xFFFFD700) else Color(0xFFFFA000))
    Spacer(Modifier.width(12.dp))
    Text(label, modifier = Modifier.weight(1f), fontSize = 14.sp)
    Switch(checked = isDarkTheme, onCheckedChange = { themeViewModel.toggleTheme() })
}
```

---

### Đề 3: 3 lựa chọn thay vì 1 Switch (Light / Dark / Theo hệ thống)

**Input:** Switch chỉ có 2 trạng thái on/off

**Output:** 3 nút radio: ☀ Sáng | 🌙 Tối | 📱 Theo hệ thống

**Cách sửa ThemeViewModel:**
```kotlin
enum class ThemeMode { LIGHT, DARK, SYSTEM }

private val _themeMode = MutableStateFlow(ThemeMode.SYSTEM)
val themeMode: StateFlow<ThemeMode> = _themeMode.asStateFlow()

fun setTheme(mode: ThemeMode) { _themeMode.value = mode }
```

**Cách sửa Theme.kt:**
```kotlin
fun BookStoreTheme(themeMode: ThemeMode, content: @Composable () -> Unit) {
    val systemIsDark = isSystemInDarkTheme()
    val isDark = when (themeMode) {
        ThemeMode.LIGHT  -> false
        ThemeMode.DARK   -> true
        ThemeMode.SYSTEM -> systemIsDark
    }
    MaterialTheme(colorScheme = if (isDark) darkColorScheme() else lightColorScheme(), content = content)
}
```

**Cách sửa SettingsScreen:**
```kotlin
val themeMode by themeViewModel.themeMode.collectAsStateWithLifecycle()

listOf(ThemeMode.LIGHT to "Sáng", ThemeMode.DARK to "Tối", ThemeMode.SYSTEM to "Theo hệ thống")
    .forEach { (mode, label) ->
        Row(modifier = Modifier.clickable { themeViewModel.setTheme(mode) }.padding(16.dp)) {
            RadioButton(selected = themeMode == mode, onClick = { themeViewModel.setTheme(mode) })
            Text(label)
        }
    }
```

---

### Đề 4: Lưu setting vào SharedPreferences (giữ sau khi tắt app)

**Input:** ThemeViewModel chỉ dùng StateFlow trong RAM — tắt app là mất

**Output:** Bật dark mode → tắt app → mở lại → vẫn dark

**Cách sửa ThemeViewModel:**
```kotlin
@HiltViewModel
class ThemeViewModel @Inject constructor(
    @ApplicationContext private val context: Context
) : ViewModel() {
    private val prefs = context.getSharedPreferences("settings", Context.MODE_PRIVATE)

    private val _isDarkTheme = MutableStateFlow(prefs.getBoolean("dark_mode", false))
    val isDarkTheme: StateFlow<Boolean> = _isDarkTheme.asStateFlow()

    fun toggleTheme() {
        val newValue = !_isDarkTheme.value
        _isDarkTheme.value = newValue
        prefs.edit().putBoolean("dark_mode", newValue).apply()  // ← lưu vào disk
    }
}
```

---

### Đề 5: Dark mode chỉ áp dụng cho HomeScreen, không áp dụng toàn app

**Input:** isDarkTheme bọc cả app trong `BookStoreTheme`

**Output:** Chỉ HomeScreen đổi màu nền, các màn hình khác vẫn sáng

**Cách sửa:** Không truyền isDarkTheme vào `BookStoreTheme`, thay vào đó truyền vào HomeScreen:
```kotlin
// HomeScreen nhận isDarkTheme và tự đổi nền
@Composable
fun HomeScreen(..., isDarkTheme: Boolean) {
    val bgColor = if (isDarkTheme) Color(0xFF121212) else Color.White
    Column(modifier = Modifier.background(bgColor)) { ... }
}
```
> ⚠️ Đây là anti-pattern — chỉ làm nếu thầy yêu cầu cụ thể. Cách đúng là dùng MaterialTheme toàn app.

---

### Giải thích kỹ thuật cốt lõi

**Tại sao ThemeViewModel phải ở Activity scope, không phải NavGraph scope:**
```
Activity (sống cả phiên app)
└── setContent { BookStoreTheme(isDarkTheme) { NavHost { ... } } }
                ↑ Theme bọc NGOÀI NavHost → phải biết isDarkTheme TRƯỚC khi vào NavHost

NavGraph scope (chết khi navigate away)
└── SettingsScreen → WishlistScreen → ... → có thể bị hủy
```
→ Nếu ThemeViewModel sống trong NavGraph → bị hủy khi navigate → theme reset.

**StateFlow vs mutableStateOf trong Activity:**
```kotlin
// mutableStateOf — chỉ hoạt động trong @Composable
var isDark by mutableStateOf(false)  // ← KHÔNG dùng trong Activity class

// StateFlow — hoạt động cả trong Activity và ViewModel
val isDark: StateFlow<Boolean>       // ← đúng cách
```
