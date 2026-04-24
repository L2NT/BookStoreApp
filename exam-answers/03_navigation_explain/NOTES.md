# BÀI TẬP KIỂM TRA THỰC HÀNH
**Dành cho:** Nhóm 35 — Kotlin Jetpack Compose  
**Tham chiếu:** Chương 11 — Bug: Navigation stuck khi tap BottomNavigation (AppBottomNavigation.kt)

---

## 1. ĐỀ BÀI

**Mục tiêu:** Kiểm tra kỹ năng phân tích bug Navigation và refactor từ Flat NavHost sang Nested Navigation Graphs.

**Yêu cầu:** Đoạn code `MainScreen.kt` dưới đây dùng Flat NavHost gây ra bug: khi đang ở màn hình `book_detail` hoặc `cart`, tap sang tab Category/Home bị stuck (không chuyển được). Hãy xác định nguyên nhân và refactor sang Nested Navigation Graphs.

---

## 2. DỮ LIỆU ĐẦU VÀO (INPUT) — Flat NavHost bị lỗi

```kotlin
// MainScreen.kt — FLAT NavHost (BỊ LỖI)
NavHost(navController, startDestination = "home") {
    composable("home")          { HomeScreen(...) }
    composable("search_screen") { SearchScreen(...) }
    composable("book_detail/{bookId}") { BookDetailScreen(...) }
    composable("cart")          { CartScreen(...) }
    composable("category")      { CategoryScreen(...) }
    composable("checkout")      { CheckoutScreen(...) }
    composable("account")       { AccountScreen(...) }
    // tất cả nằm flat — saveState/restoreState conflict với non-tab routes
}

// AppBottomNavigation.kt — check route thủ công, sai
selected = currentRoute == item.route
// → Không highlight khi ở category_detail, profile, settings...

// BottomNavItem.kt — không có graphRoute
sealed class BottomNavItem(val route: String, ...)
// → Không phân biệt được route màn hình vs route graph
```

---

## 3. YÊU CẦU KẾT QUẢ (OUTPUT)

**a.** Giải thích: tại sao Flat NavHost gây stuck khi switch tab?

**b.** Thêm `graphRoute` vào `BottomNavItem` — phân biệt route màn hình với route graph.

**c.** Refactor `MainScreen.kt` thành 4 sub-graph: `home_graph`, `category_graph`, `cart_graph`, `account_graph`.

**d.** Sửa `AppBottomNavigation.kt`: dùng `NavDestination.hierarchy` thay vì so sánh route trực tiếp.

**e.** Demo: Search → BookDetail → Cart → tap Category → ✅ không bị stuck.

---

## 4. GỢI Ý GIẢI THÍCH CHO THẦY

**Tại sao Flat bị stuck:**
- `saveState/restoreState` lưu/restore back stack dựa theo destination ID
- Khi back stack có route không thuộc tab nào (`book_detail`, `search_screen`), `popUpTo(findStartDestination().id)` bị conflict → không clear được đúng back stack → stuck

**Nested Graphs giải quyết:**
- Mỗi tab là một sub-graph độc lập → `saveState` lưu đúng per-graph
- `hierarchy` tự detect tab active dựa vào graph chứa màn hình hiện tại → không cần check thủ công

---

## 📦 HƯỚNG DẪN KÉO THẢ

> ✅ **Project hiện tại ĐÃ ĐƯỢC FIX** — Nested Graphs đã được implement.  
> Không cần kéo thả gì thêm.

**Chỉ cần mở các file sau và giải thích với thầy:**

| File trong project | Nội dung cần chỉ |
|--------------------|-----------------|
| `ui/screens/MainScreen.kt` | Chỉ vào `navigation(route = "home_graph") { ... }` — 4 sub-graph |
| `ui/components/AppBottomNavigation.kt` | Chỉ vào `currentDestination?.hierarchy?.any { it.route == item.graphRoute }` |
| `ui/components/BottomNavItem.kt` | Chỉ vào `val graphRoute: String` property |

**Nếu thầy yêu cầu demo từ flat (bị lỗi) → fix sang nested:**  
Xem folder `_broken/MainScreen_flat_example.kt` để lấy code bị lỗi làm INPUT.

---

## 📁 Nội dung folder này

```
03_navigation_explain/
├── NOTES.md                          ← File này (đề + hướng dẫn)
├── _broken/
│   └── MainScreen_flat_example.kt   ← Code flat NavHost BỊ LỖI (INPUT cho đề)
└── _backup/
    ├── MainScreen.kt                 ← Code Nested Graphs ĐÚNG (backup từ project)
    ├── AppBottomNavigation.kt        ← Code hierarchy ĐÚNG (backup)
    └── BottomNavItem.kt              ← Code có graphRoute ĐÚNG (backup)
```

