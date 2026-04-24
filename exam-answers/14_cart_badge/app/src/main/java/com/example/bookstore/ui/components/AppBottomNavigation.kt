package com.example.bookstore.ui.components

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState

/**
 * Bottom Navigation Bar với Nested Navigation Graphs.
 *
 * Cơ chế hoạt động:
 * - Mỗi tab là một navigation graph riêng (home_graph, category_graph, cart_graph, account_graph).
 * - selected: dùng NavDestination.hierarchy để check xem destination hiện tại
 *   có nằm trong graph của tab đó không — tự động highlight đúng tab kể cả
 *   khi đang ở màn hình con (category_detail, profile, settings...).
 * - onClick: navigate đến graphRoute với saveState + restoreState — mỗi tab
 *   giữ nguyên vị trí và trạng thái khi switch qua lại.
 *
 * [THÊM MỚI — Ch.11 KK3 Cart Badge]
 * - cartCount: số lượng item trong giỏ hàng, lấy từ cartViewModel.cartItems.size ở MainScreen.
 * - Tự động recompose vì CartViewModel dùng mutableStateListOf (Compose State) — không cần
 *   collect() hay observe() thủ công.
 * - BadgedBox của Material3 hiển thị vòng tròn đỏ góc trên phải icon khi cartCount > 0.
 *
 * @param navController NavController của MainScreen
 * @param cartCount     Số lượng item trong giỏ (mặc định 0 = không hiện badge)
 */
@Composable
fun AppBottomNavigation(
    navController: NavController,
    cartCount: Int = 0          // ← THÊM MỚI: số lượng sản phẩm trong giỏ
) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Category,
        BottomNavItem.Cart,
        BottomNavItem.Account
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor   = MaterialTheme.colorScheme.onSurface
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    // Badge chỉ hiển thị trên tab Cart khi có item trong giỏ
                    if (item == BottomNavItem.Cart && cartCount > 0) {
                        BadgedBox(
                            badge = {
                                Badge {
                                    Text(
                                        // Hiển thị "99+" nếu quá nhiều
                                        text = if (cartCount > 99) "99+" else cartCount.toString()
                                    )
                                }
                            }
                        ) {
                            Icon(imageVector = item.icon, contentDescription = item.title)
                        }
                    } else {
                        Icon(imageVector = item.icon, contentDescription = item.title)
                    }
                },
                label    = { Text(text = item.title) },
                // hierarchy: tự động highlight tab khi ở BẤT KỲ màn hình nào trong graph đó.
                // Không cần xử lý thủ công từng route (startsWith("category_detail/"), v.v.)
                selected = currentDestination?.hierarchy?.any { it.route == item.graphRoute } == true,
                onClick  = {
                    navController.navigate(item.graphRoute) {
                        // Xóa back stack về start destination để tránh stack quá sâu khi switch tab
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true   // Lưu state của tab vừa rời khỏi
                        }
                        launchSingleTop = true  // Không tạo duplicate nếu đã ở tab đó
                        restoreState    = true  // Khôi phục state khi quay lại tab này
                    }
                }
            )
        }
    }
}

