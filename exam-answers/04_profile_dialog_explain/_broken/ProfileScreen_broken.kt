package com.example.bookstore.ui.screens

// ══════════════════════════════════════════════════════════════════
// ĐÂY LÀ CODE BỊ LỖI — DÙNG LÀM INPUT CHO ĐỀ THI
// KHÔNG copy file này vào project!
// ══════════════════════════════════════════════════════════════════
//
// BUG: Dialog "Lưu thành công" không hiển thị dù đã lưu thành công
// NGUYÊN NHÂN: LaunchedEffect(Unit) bên trong if(updateSuccess) reset flag ngay lập tức
//
// CÁCH FIX: Xóa LaunchedEffect, để updateSuccess trực tiếp điều khiển Dialog
//           Chỉ reset flag trong confirmButton onClick
//
// CODE ĐÚNG: Xem ProfileScreen.kt trong project (line 31-43)
// ══════════════════════════════════════════════════════════════════

/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController, viewModel: AccountViewModel = hiltViewModel()) {

    // ❌ BUG: LaunchedEffect(Unit) bên trong if → reset flag ngay khi compose lần đầu
    var showDialog by remember { mutableStateOf(false) }

    if (viewModel.updateSuccess) {
        LaunchedEffect(Unit) {            // ← key=Unit không đổi → chỉ chạy 1 lần
            showDialog = true             // set true...
            viewModel.updateSuccess = false  // nhưng reset ngay → Dialog chưa hiện đã tắt
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(onClick = { showDialog = false }) { Text("OK") }
            },
            title = { Text("Thành công") },
            text  = { Text("Thông tin đã được cập nhật.") }
        )
    }

    // ... phần còn lại của ProfileScreen
    Scaffold(...) { ... }
}
*/

// ══════════════════════════════════════════════════════════════════
// CODE ĐÚNG (đã có trong project):
//
// if (viewModel.updateSuccess) {          // trực tiếp dùng updateSuccess làm điều kiện
//     AlertDialog(
//         onDismissRequest = { viewModel.updateSuccess = false },
//         confirmButton = {
//             TextButton(onClick = {
//                 viewModel.updateSuccess = false   // chỉ reset khi user bấm OK
//                 navController.popBackStack()
//             }) { Text("OK") }
//         },
//         title = { Text("Thành công") },
//         text  = { Text("Thông tin tài khoản đã được cập nhật.") }
//     )
// }
// ══════════════════════════════════════════════════════════════════

