# Chương 6 — Cập nhật & Bổ sung

> File này chứa toàn bộ nội dung cần tích hợp vào BaoCao.md cho Chương 6.
> - **6.1.5** — Bổ sung các mục d, e, f, g (thêm vào cuối phần 6.1.5.c hiện có)
> - **6.2** — Đổi tên mục + Thêm 6.2.2 và 6.2.3 (sau ví dụ Counter hiện có)
> - **6.3** — Thay toàn bộ nội dung cũ bằng phần này

---

## BỔ SUNG VÀO CUỐI 6.1.5 (sau mục c — Nested Navigation Graphs)

##### d. Hàm `navigation()` — Khai báo sub-graph

Để tạo một Nested Navigation Graph thực sự, dùng hàm `navigation()` bên trong `NavHost`. Mỗi sub-graph có `route` riêng (graph route) và `startDestination` riêng:

```kotlin
NavHost(navController = navController, startDestination = "home_graph") {
    navigation(
        startDestination = "home",       // Màn hình đầu tiên khi vào graph
        route            = "home_graph"  // Route định danh cho toàn bộ graph
    ) {
        composable("home") { HomeScreen() }
        composable("book_detail/{bookId}") { BookDetailScreen() }
    }
    navigation(startDestination = "cart", route = "cart_graph") {
        composable("cart") { CartScreen() }
        composable("checkout") { CheckoutScreen() }
    }
}
```

##### e. Quản lý back stack khi chuyển tab — `popUpTo`, `saveState`, `restoreState`

Khi người dùng bấm vào tab khác trên BottomNavigation, cần cấu hình để tránh back stack tích lũy vô hạn và giữ trạng thái từng tab:

- **`popUpTo(...)`**: Xóa các destination ra khỏi back stack đến một điểm nhất định.
- **`saveState = true`**: Lưu lại state của tab vừa rời khỏi (vị trí cuộn, dữ liệu đã nhập).
- **`launchSingleTop = true`**: Không tạo thêm instance mới nếu destination đích đã ở top của stack.
- **`restoreState = true`**: Khôi phục state đã lưu khi quay lại tab đó.

```kotlin
navController.navigate("cart_graph") {
    popUpTo(navController.graph.findStartDestination().id) { saveState = true }
    launchSingleTop = true
    restoreState    = true
}
```

##### f. `NavDestination.hierarchy` — Highlight tab tự động

`hierarchy` là một `Sequence<NavDestination>` chứa destination hiện tại và tất cả các graph cha của nó theo thứ tự từ trong ra ngoài. Ví dụ, khi đang ở màn hình `checkout` (nằm trong `cart_graph`):

```
hierarchy = [checkout, cart_graph, NavGraph(root)]
```

Nhờ đó, có thể tự động highlight đúng tab mà không cần kiểm tra route thủ công:

```kotlin
selected = currentDestination?.hierarchy?.any { it.route == "cart_graph" } == true
// → true khi đang ở checkout, cart, hoặc bất kỳ màn hình nào trong cart_graph
```

##### g. Deep Link — `navDeepLink {}`

Deep Link cho phép ứng dụng bên ngoài mở trực tiếp một destination cụ thể thông qua URI scheme. Trong Navigation Compose, khai báo bằng `navDeepLink { uriPattern = "..." }` bên trong `composable()`:

```kotlin
composable(
    route     = "result?success={success}",
    deepLinks = listOf(navDeepLink { uriPattern = "myapp://result?success={success}" })
) { ... }
```

---

## THAY THẾ HEADER 6.2 VÀ THÊM VÍ DỤ

> Đổi header "6.2. Ví dụ và giải thích (Bổ sung thêm ví dụ sau)" thành "6.2. Ví dụ và giải thích"
> Thêm nhãn "6.2.1" cho Counter hiện có, sau đó thêm 6.2.2 và 6.2.3 bên dưới.

### 6.2. Ví dụ và giải thích

#### 6.2.1. Bộ đếm đơn giản (Counter)

> _(Giữ nguyên nội dung Counter đã có trong BaoCao.md — chỉ thêm nhãn 6.2.1)_

#### 6.2.2. Điều hướng giữa 2 màn hình với tham số

**Mục tiêu:** Minh họa cách thiết lập `NavController` + `NavHost`, điều hướng giữa các composable và truyền tham số qua route.

```kotlin
@Composable
fun SimpleNavApp() {
    val navController = rememberNavController()

    NavHost(
        navController    = navController,
        startDestination = "book_list"
    ) {
        // Màn hình danh sách sách
        composable("book_list") {
            BookListScreen(
                onBookClick = { bookId ->
                    navController.navigate("book_detail/$bookId") // Truyền tham số qua route
                }
            )
        }

        // Màn hình chi tiết — nhận tham số bookId từ route
        composable(
            route     = "book_detail/{bookId}",
            arguments = listOf(navArgument("bookId") { type = NavType.StringType })
        ) { backStackEntry ->
            val bookId = backStackEntry.arguments?.getString("bookId") ?: ""
            BookDetailScreen(
                bookId      = bookId,
                onBackClick = { navController.popBackStack() } // Quay lại màn hình trước
            )
        }
    }
}
```

- `rememberNavController()`: Tạo và ghi nhớ `NavController` qua các lần recompose.
- `NavHost(startDestination = "book_list")`: Khai báo màn hình đầu tiên khi mở app.
- `navController.navigate("book_detail/$bookId")`: Điều hướng đến destination mới, đẩy vào back stack.
- `navArgument("bookId") { type = NavType.StringType }`: Khai báo tham số kiểu `String` cho route.
- `backStackEntry.arguments?.getString("bookId")`: Đọc tham số từ route trong lambda của `composable()`.
- `navController.popBackStack()`: Quay lại destination trước đó trong back stack.

_Hình 6.X. Luồng điều hướng từ BookListScreen sang BookDetailScreen khi bấm vào sách_

#### 6.2.3. BottomNavigation 2 tab với Nested Graph và giữ trạng thái

**Mục tiêu:** Minh họa cách dùng `navigation()` tạo 2 sub-graph, highlight tab bằng `hierarchy`, và giữ trạng thái tab khi switch bằng `saveState`/`restoreState`.

```kotlin
@Composable
fun TwoTabApp() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            NavigationBar {
                // Tab Trang chủ
                NavigationBarItem(
                    // hierarchy: tự động highlight tab kể cả khi đang ở màn hình con (book_detail)
                    selected = currentDestination
                        ?.hierarchy?.any { it.route == "home_graph" } == true,
                    onClick = {
                        navController.navigate("home_graph") {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true  // Lưu state tab vừa rời
                            }
                            launchSingleTop = true
                            restoreState    = true  // Khôi phục state khi quay lại
                        }
                    },
                    icon  = { Icon(Icons.Outlined.Home, "Trang chủ") },
                    label = { Text("Trang chủ") }
                )
                // Tab Giỏ hàng (tương tự)
                NavigationBarItem(
                    selected = currentDestination
                        ?.hierarchy?.any { it.route == "cart_graph" } == true,
                    onClick = {
                        navController.navigate("cart_graph") {
                            popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                            launchSingleTop = true
                            restoreState    = true
                        }
                    },
                    icon  = { Icon(Icons.Outlined.ShoppingCart, "Giỏ hàng") },
                    label = { Text("Giỏ hàng") }
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController    = navController,
            startDestination = "home_graph",
            modifier         = Modifier.padding(innerPadding)
        ) {
            // HOME GRAPH — sub-graph riêng của tab Trang chủ
            navigation(startDestination = "home", route = "home_graph") {
                composable("home") { HomeScreen(navController) }
                composable("book_detail/{bookId}") { BookDetailScreen() }
            }

            // CART GRAPH — sub-graph riêng của tab Giỏ hàng
            navigation(startDestination = "cart", route = "cart_graph") {
                composable("cart") { CartScreen() }
                composable("checkout") { CheckoutScreen() }
            }
        }
    }
}
```

- `navigation(startDestination = "home", route = "home_graph")`: Tạo sub-graph — mỗi tab có back stack riêng, tránh xung đột khi switch tab.
- `hierarchy?.any { it.route == "home_graph" }`: Trả về `true` cho **tất cả** màn hình trong graph đó (`home` và `book_detail`), không cần kiểm tra từng route thủ công.
- `saveState = true` + `restoreState = true`: Khi quay lại tab, người dùng tiếp tục đúng nơi đã rời — vị trí cuộn, dữ liệu nhập được giữ nguyên.

_Hình 6.X. Tab "Trang chủ" vẫn sáng khi đang ở BookDetailScreen (trái); tab "Giỏ hàng" sáng khi ở CheckoutScreen (phải)_

---

## THAY THẾ TOÀN BỘ NỘI DUNG 6.3

> Xóa toàn bộ nội dung 6.3 cũ trong BaoCao.md (từ "Trong MainScreen.kt, toàn bộ điều hướng..." đến hết "restoreState = true" trước CHƯƠNG 7) và thay bằng nội dung bên dưới.

### 6.3. Đồ án — Điều hướng với Jetpack Compose Navigation trong ứng dụng bán sách

#### 6.3.0. Tổng quan cấu trúc điều hướng

Trong `MainScreen.kt`, toàn bộ điều hướng được đặt trong một `NavHost` duy nhất. Tuy nhiên, khác với cách tổ chức phẳng (flat), đồ án sử dụng **Nested Navigation Graphs thực sự** thông qua hàm `navigation()` — mỗi tab là một sub-graph riêng biệt với route và startDestination độc lập. Bốn tab chính (Trang chủ, Danh mục, Giỏ hàng, Tài khoản) là các **navigation graph** cấp một, không phải destination đơn lẻ.

```
MainScreen (NavHost)
├── home_graph  (Trang chủ)
│   ├── home  ← startDestination
│   ├── search_screen
│   ├── search_results/{query}
│   └── book_detail/{bookId}
├── category_graph  (Danh mục)
│   ├── category  ← startDestination
│   └── category_detail/{index}
├── cart_graph  (Giỏ hàng)
│   ├── cart  ← startDestination
│   └── checkout
├── account_graph  (Tài khoản)
│   ├── account  ← startDestination
│   ├── profile
│   ├── settings
│   ├── change_password
│   ├── order_history
│   ├── order_history?success={success}   ← deep link MoMo
│   └── contact
└── [Shared — ngoài mọi graph]
    ├── login/{returnRoute}
    └── register
```

_Hình 6.X. Sơ đồ kiến trúc Nested Navigation Graphs trong đồ án_

---

#### 6.3.1. Hiển thị BottomNavigation có điều kiện

Thanh điều hướng dưới cùng chỉ hiển thị trên các màn hình chính và màn hình `category_detail` (để tiện chuyển tab). Các màn hình con (chi tiết sách, thanh toán, profile, …) sẽ ẩn bottom bar để tối ưu không gian.

```kotlin
val navBackStackEntry by navController.currentBackStackEntryAsState()
val currentRoute = navBackStackEntry?.destination?.route

val showBottomBar = currentRoute in setOf("home", "category", "cart", "account") ||
    currentRoute?.startsWith("category_detail/") == true

Scaffold(
    bottomBar = { if (showBottomBar) AppBottomNavigation(navController) }
) { innerPadding ->
    NavHost(..., modifier = Modifier.padding(innerPadding)) { ... }
}
```

_Hình 6.X. Bottom Navigation ẩn khi vào màn hình chi tiết sách (trái) và hiện khi ở trang chủ (phải)_

---

#### 6.3.2. Cấu hình `popUpTo` và `launchSingleTop` cho BottomNavigation

Khi chuyển giữa các tab, cần tránh tạo nhiều instance trùng lặp và giữ trạng thái từng tab. Cấu hình sau trong `AppBottomNavigation.kt` đảm bảo mỗi tab chỉ có một instance, lưu và khôi phục trạng thái:

```kotlin
navController.navigate(item.graphRoute) {
    // Xóa back stack về start destination để tránh stack quá sâu khi switch tab
    popUpTo(navController.graph.findStartDestination().id) {
        saveState = true   // Lưu state của tab vừa rời khỏi
    }
    launchSingleTop = true  // Không tạo duplicate nếu đã ở tab đó
    restoreState    = true  // Khôi phục state khi quay lại tab này
}
```

**Giải thích từng tham số:**

- `popUpTo(navController.graph.findStartDestination().id)`: pop về tận start destination của toàn bộ NavHost (`home_graph`) — ngăn back stack tích lũy vô hạn khi người dùng chuyển tab nhiều lần.
- `saveState = true`: lưu lại toàn bộ state (vị trí cuộn, dữ liệu đã nhập) của tab trước đó để khôi phục sau.
- `launchSingleTop = true`: nếu destination đích đã là top của back stack, không tạo thêm instance mới.
- `restoreState = true`: khi quay lại tab đã từng mở, khôi phục lại state đã lưu — người dùng tiếp tục đúng nơi họ đã rời.

---

#### 6.3.3. Nested Navigation Graphs thực sự trong đồ án

Điểm cốt lõi của cấu trúc điều hướng trong đồ án là sử dụng hàm `navigation()` để tạo các **sub-graph** thực sự — mỗi tab là một graph độc lập, không phải destination đơn lẻ.

```kotlin
NavHost(
    navController    = navController,
    startDestination = BottomNavItem.Home.graphRoute,  // "home_graph"
    ...
) {
    // HOME GRAPH — Trang chủ, Tìm kiếm, Chi tiết sách
    navigation(
        startDestination = BottomNavItem.Home.route,       // "home"
        route            = BottomNavItem.Home.graphRoute   // "home_graph"
    ) {
        composable("home") { HomeScreen(...) }
        composable("search_screen") { SearchScreen(...) }
        composable("search_results/{query}") { ... }
        composable("book_detail/{bookId}") { ... }
    }

    // CATEGORY GRAPH — Danh mục, Chi tiết danh mục
    navigation(
        startDestination = BottomNavItem.Category.route,       // "category"
        route            = BottomNavItem.Category.graphRoute   // "category_graph"
    ) {
        composable("category") { CategoryScreen(...) }
        composable(
            route     = "category_detail/{index}",
            arguments = listOf(navArgument("index") { type = NavType.IntType })
        ) { CategoryDetailScreen(...) }
    }

    // CART GRAPH — Giỏ hàng, Thanh toán
    navigation(
        startDestination = BottomNavItem.Cart.route,       // "cart"
        route            = BottomNavItem.Cart.graphRoute   // "cart_graph"
    ) {
        composable("cart") { CartScreen(...) }
        composable("checkout") { CheckoutScreen(...) }
    }

    // ACCOUNT GRAPH — Tài khoản và các màn hình con
    navigation(
        startDestination = BottomNavItem.Account.route,       // "account"
        route            = BottomNavItem.Account.graphRoute   // "account_graph"
    ) {
        composable("account") { AccountScreen(...) }
        composable("profile") { ProfileScreen(...) }
        composable("settings") { SettingsScreen(...) }
        composable("change_password") { ChangePasswordScreen(...) }
        composable("order_history") { OrderHistoryScreen(...) }
        composable(
            route     = "order_history?success={success}",
            deepLinks = listOf(navDeepLink {
                uriPattern = "bookstore://payment/result?success={success}&orderId={orderId}"
            })
        ) { OrderHistoryScreen(...) }
        composable("contact") { ContactScreen(...) }
    }

    // SHARED SCREENS — Ngoài mọi graph (auth flow)
    composable("login/{returnRoute}") { LoginScreen(...) }
    composable("register") { RegisterScreen(...) }
}
```

**Lý do dùng Nested Graphs thay vì flat NavHost:**

| Vấn đề với flat NavHost | Giải pháp của Nested Graphs |
|---|---|
| Tab switching xóa toàn bộ back stack | Mỗi graph có back stack riêng, tránh xung đột |
| Không tự động highlight tab khi ở màn hình con | `hierarchy` API tự động detect graph hiện tại |
| Login/register cần nằm riêng không thuộc tab nào | Khai báo ngoài tất cả `navigation()` block |
| `book_detail` cần accessible từ nhiều tab | Đặt trong `home_graph`, navigate từ category dùng `navigateAsTab` |

**Trường hợp đặc biệt — `book_detail` chỉ nằm trong `home_graph`:** Khi người dùng đang ở tab Danh mục và bấm vào một cuốn sách, `CategoryDetailScreen` gọi `navController.navigate("book_detail/$bookId")` — route này nằm trong `home_graph`, nên Compose điều hướng vào `home_graph` và tab Trang chủ sẽ sáng lên. Đây là hành vi chấp nhận được vì người dùng đang xem chi tiết một cuốn sách — sau đó nhấn Back sẽ trở về đúng `CategoryDetailScreen`.

---

#### 6.3.4. Cơ chế highlight tab với `NavDestination.hierarchy`

Một trong những lợi ích lớn nhất của Nested Navigation Graphs là khả năng **tự động highlight đúng tab** khi người dùng đang ở bất kỳ màn hình nào trong graph đó — kể cả màn hình con sâu nhất.

```kotlin
// Trong AppBottomNavigation.kt
val navBackStackEntry by navController.currentBackStackEntryAsState()
val currentDestination = navBackStackEntry?.destination

items.forEach { item ->
    NavigationBarItem(
        selected = currentDestination
            ?.hierarchy                              // Duyệt cây cha của destination hiện tại
            ?.any { it.route == item.graphRoute }   // Kiểm tra xem có nằm trong graph này không
            == true,
        onClick = { ... }
    )
}
```

**Giải thích `NavDestination.hierarchy`:**

`hierarchy` là một `Sequence<NavDestination>` chứa destination hiện tại và **tất cả các graph cha** của nó theo thứ tự từ trong ra ngoài. Ví dụ, khi người dùng đang ở màn hình `category_detail/2`:

```
hierarchy = [category_detail/2, category_graph, NavGraph(root)]
```

Khi kiểm tra `hierarchy.any { it.route == "category_graph" }` → `true` → tab Danh mục sáng lên tự động.

**So sánh với cách kiểm tra thủ công (không dùng Nested Graphs):**

```kotlin
// Cách cũ — dễ bỏ sót, phải cập nhật thủ công mỗi khi thêm màn hình
val selectedTab = when {
    currentRoute == "category"               -> BottomNavItem.Category
    currentRoute?.startsWith("category_detail/") == true -> BottomNavItem.Category
    currentRoute == "profile"                -> BottomNavItem.Account
    currentRoute == "settings"               -> BottomNavItem.Account
    // ... phải liệt kê tất cả
    else -> BottomNavItem.Home
}

// Cách mới với hierarchy — tự động, không cần cập nhật khi thêm màn hình mới
selected = currentDestination?.hierarchy?.any { it.route == item.graphRoute } == true
```

_Hình 6.X. Tab "Danh mục" vẫn sáng (highlighted) khi người dùng đang ở màn hình CategoryDetail_

---

#### 6.3.5. `BottomNavItem` Sealed Class — Phân biệt `route` và `graphRoute`

Để quản lý rõ ràng sự phân biệt giữa **destination route** (route của màn hình chính) và **graph route** (route của cả graph), đồ án định nghĩa `BottomNavItem` là một Sealed Class:

```kotlin
sealed class BottomNavItem(
    val route: String,       // Route của màn hình startDestination
    val graphRoute: String,  // Route của navigation graph (dùng để switch tab)
    val title: String,
    val icon: ImageVector
) {
    object Home     : BottomNavItem("home",     "home_graph",     "Trang chủ", Icons.Outlined.Home)
    object Category : BottomNavItem("category", "category_graph", "Danh mục",  Icons.Outlined.GridView)
    object Cart     : BottomNavItem("cart",     "cart_graph",     "Giỏ hàng",  Icons.Outlined.ShoppingCart)
    object Account  : BottomNavItem("account",  "account_graph",  "Tài khoản", Icons.Outlined.Person)
}
```

**Tại sao cần tách `route` và `graphRoute`?**

Với Nested Navigation Graphs, có hai loại route khác nhau cần phân biệt rõ:

| | `route` | `graphRoute` |
|---|---|---|
| **Là gì** | Route của màn hình `home`, `category`, ... | Route của graph `home_graph`, `category_graph`, ... |
| **Dùng để** | Khai báo `startDestination` của graph | Navigate khi switch tab; kiểm tra `hierarchy` |
| **Ví dụ navigate** | `navController.navigate("home")` — vào thẳng màn hình | `navController.navigate("home_graph")` — vào graph, tự đến startDestination |
| **Khi nào dùng `route`** | Khai báo `composable("home") { ... }` trong NavHost | — |
| **Khi nào dùng `graphRoute`** | — | `AppBottomNavigation` onClick; `hierarchy` check |

**Ứng dụng trong `navigateAsTab` bên trong `BookDetailScreen`:**

Khi người dùng đang ở `BookDetailScreen` (nằm trong `home_graph`) và muốn chuyển sang tab khác bằng các nút điều hướng trên app bar, hàm nội bộ `navigateAsTab` được dùng để switch tab đúng chuẩn:

```kotlin
// Định nghĩa bên trong composable "book_detail/{bookId}"
fun navigateAsTab(graphRoute: String) {
    navController.navigate(graphRoute) {
        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
        launchSingleTop = true
        restoreState    = true
    }
}

BookDetailScreen(
    onHomeClick     = { navigateAsTab(BottomNavItem.Home.graphRoute) },
    onCartClick     = { navigateAsTab(BottomNavItem.Cart.graphRoute) },
    onCategoryClick = { navigateAsTab(BottomNavItem.Category.graphRoute) },
    onAccountClick  = { navigateAsTab(BottomNavItem.Account.graphRoute) },
    ...
)
```

Cách tiếp cận này đảm bảo hành vi chuyển tab từ `BookDetailScreen` hoàn toàn nhất quán với hành vi chuyển tab từ bottom navigation bar.

---

#### 6.3.6. Deep Link tích hợp thanh toán MoMo

Một use case nâng cao của Navigation trong đồ án là xử lý kết quả thanh toán MoMo thông qua **deep link**. Sau khi người dùng hoàn tất (hoặc hủy) thanh toán trên app MoMo, ứng dụng được gọi lại qua URI scheme:

```kotlin
composable(
    route     = "order_history?success={success}",
    arguments = listOf(
        navArgument("success") { type = NavType.BoolType; defaultValue = false }
    ),
    deepLinks = listOf(
        navDeepLink {
            uriPattern = "bookstore://payment/result?success={success}&orderId={orderId}"
        }
    )
) { backStackEntry ->
    val success = backStackEntry.arguments?.getBoolean("success") ?: false
    // success=true → mở tab "Đang xử lý" (index 2)
    // success=false → mở tab "Chờ xác nhận" (index 1)
    OrderHistoryScreen(navController = navController, initialTab = if (success) 2 else 1)
}
```

**Luồng hoạt động:**

1. Người dùng bấm "Thanh toán MoMo" → ứng dụng mở app MoMo qua `payUrl`/`deeplink`.
2. Người dùng hoàn tất hoặc hủy thanh toán trên MoMo.
3. MoMo gọi lại `bookstore://payment/result?success=true&orderId=123`.
4. Android router map URI này đến destination `order_history?success={success}` trong `account_graph`.
5. `OrderHistoryScreen` nhận `initialTab = 2` (Đang xử lý) nếu thành công, hoặc `initialTab = 1` (Chờ xác nhận) nếu hủy.

_Hình 6.X. Luồng deep link từ MoMo trở về màn hình đơn hàng_

---

#### 6.3.7. Kết quả đạt được

Việc áp dụng Nested Navigation Graphs kết hợp các tính năng của Jetpack Compose Navigation mang lại những kết quả cụ thể trong đồ án:

| Kỹ thuật | Vấn đề giải quyết | Kết quả thực tế |
|---|---|---|
| **Nested Graphs (`navigation()`)** | Quản lý back stack độc lập cho từng tab | Mỗi tab có luồng điều hướng riêng, không xung đột |
| **`NavDestination.hierarchy`** | Highlight đúng tab khi ở màn hình con | Tab tự sáng chính xác, không cần check route thủ công |
| **`popUpTo` + `saveState` / `restoreState`** | Mất state khi switch tab | Người dùng quay lại tab đúng vị trí đã rời |
| **`BottomNavItem` Sealed Class** | Nhầm lẫn giữa destination route và graph route | Phân biệt rõ `route` / `graphRoute` trong toàn bộ codebase |
| **Deep Link** | Không có cách nhận kết quả từ app ngoài | MoMo callback được map trực tiếp đến đúng màn hình và tab |
| **Shared screens ngoài graph** | Login/Register không thuộc tab nào | Khai báo ngoài tất cả `navigation()` block, accessible từ bất kỳ đâu |

