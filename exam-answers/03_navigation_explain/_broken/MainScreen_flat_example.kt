package com.example.bookstore.ui.screens

// ══════════════════════════════════════════════════════════════════
// ĐÂY LÀ CODE BỊ LỖI — DÙNG LÀM INPUT CHO ĐỀ THI
// KHÔNG copy file này vào project!
// ══════════════════════════════════════════════════════════════════
//
// VẤN ĐỀ: Flat NavHost — tất cả route nằm cùng cấp
// BUG: Search → BookDetail → Cart → tap Category → BỊ STUCK trên Cart
// NGUYÊN NHÂN: saveState/restoreState conflict với non-tab routes
//
// CÁCH FIX: Dùng Nested Navigation Graphs (xem MainScreen.kt trong project)
//

/*
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bookstore.ui.components.AppBottomNavigation
import com.example.bookstore.ui.components.BottomNavItem
import com.example.bookstore.viewmodel.AccountViewModel
import com.example.bookstore.viewmodel.CartViewModel

@Composable
fun MainScreen() {
    val navController    = rememberNavController()
    val cartViewModel    : CartViewModel    = hiltViewModel()
    val accountViewModel : AccountViewModel = hiltViewModel()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        contentWindowInsets = WindowInsets(0),
        bottomBar = {
            AppBottomNavigation(navController = navController)
        }
    ) { innerPadding ->

        // ❌ FLAT NavHost — TẤT CẢ route cùng cấp — GÂY BUG STUCK
        NavHost(
            navController    = navController,
            startDestination = "home",
            modifier         = Modifier.padding(bottom = innerPadding.calculateBottomPadding())
        ) {
            // Tab screens
            composable("home")     { HomeScreen(cartViewModel = cartViewModel, ...) }
            composable("category") { CategoryScreen(navController = navController) }
            composable("cart")     { CartScreen(cartViewModel = cartViewModel, navController = navController) }
            composable("account")  { AccountScreen(navController = navController, viewModel = accountViewModel) }

            // Non-tab screens — ĐÂY LÀ NGUỒN GÂY BUG
            // Khi back stack là [home, search_screen, book_detail, cart]
            // và user tap tab Category → popUpTo(findStartDestination()) không clear đúng
            // vì back stack lẫn lộn tab routes và non-tab routes
            composable("search_screen") { SearchScreen(...) }
            composable("book_detail/{bookId}") { BookDetailScreen(...) }
            composable("checkout")  { CheckoutScreen(...) }
            composable("profile")   { ProfileScreen(...) }
            composable("settings")  { SettingsScreen(...) }
            // v.v...
        }
    }
}
*/

// ══════════════════════════════════════════════════════════════════
// CODE ĐÚNG — Xem MainScreen.kt trong project (Nested Graphs)
// navigation(route = "home_graph") { ... }
// navigation(route = "category_graph") { ... }
// navigation(route = "cart_graph") { ... }
// navigation(route = "account_graph") { ... }
// ══════════════════════════════════════════════════════════════════

