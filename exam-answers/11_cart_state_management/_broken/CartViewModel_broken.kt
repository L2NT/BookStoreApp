package com.example.bookstore.viewmodel

// ══════════════════════════════════════════════════════════════════
// ĐÂY LÀ CODE BỊ LỖI — DÙNG LÀM INPUT CHO ĐỀ THI
// KHÔNG copy file này vào project!
// ══════════════════════════════════════════════════════════════════
//
// VẤN ĐỀ: CartViewModel được lấy riêng trong từng màn hình
// → hiltViewModel() tạo instance khác nhau per NavBackStackEntry
// → HomeScreen thêm sách vào instance #1
// → CartScreen đọc từ instance #2 → giỏ luôn rỗng!
//
// CÁCH FIX: Hoist CartViewModel tại MainScreen, truyền qua parameter
// CODE ĐÚNG: Xem MainScreen.kt — val cartViewModel: CartViewModel = hiltViewModel()
// ══════════════════════════════════════════════════════════════════

// Minh họa vấn đề — đây là pattern SAI:

// ❌ HomeScreen.kt — tự lấy CartViewModel
// @Composable
// fun HomeScreen() {
//     val cartViewModel: CartViewModel = hiltViewModel()  // Instance #1
//     Button(onClick = { cartViewModel.addBook(book, 1) }) {
//         Text("Thêm vào giỏ")
//     }
// }

// ❌ CartScreen.kt — tự lấy CartViewModel khác
// @Composable
// fun CartScreen() {
//     val cartViewModel: CartViewModel = hiltViewModel()  // Instance #2 — KHÁC #1!
//     val items = cartViewModel.cartItems  // → rỗng vì instance khác
//     LazyColumn {
//         items(items) { item -> CartItemRow(item) }  // → không có gì để show
//     }
// }

// ══════════════════════════════════════════════════════════════════
// CODE ĐÚNG — MainScreen.kt (Hoist pattern):
//
// @Composable
// fun MainScreen() {
//     // 1 instance duy nhất — tất cả màn hình dùng chung
//     val cartViewModel: CartViewModel = hiltViewModel()
//
//     NavHost(...) {
//         composable("home") {
//             HomeScreen(cartViewModel = cartViewModel)   // ← truyền xuống
//         }
//         composable("book_detail/{id}") {
//             BookDetailScreen(cartViewModel = cartViewModel)  // ← truyền xuống
//         }
//         composable("cart") {
//             CartScreen(cartViewModel = cartViewModel)    // ← truyền xuống
//         }
//     }
// }
//
// Kết quả: tất cả màn hình share cùng 1 CartViewModel → data đồng bộ
// ══════════════════════════════════════════════════════════════════

