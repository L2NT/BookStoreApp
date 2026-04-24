package com.example.bookstore.ui.screens

import androidx.activity.ComponentActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.PersonOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.bookstore.ui.theme.AppColors
import com.example.bookstore.viewmodel.ThemeViewModel

private val PrimaryBlueSettings = AppColors.PrimaryBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController) {
    // Lấy ThemeViewModel từ Activity scope (cùng instance với MainActivity)
    // Nhờ đó toggle ở đây sẽ ảnh hưởng trực tiếp đến BookStoreTheme bên trên
    val activity = LocalContext.current as ComponentActivity
    val themeViewModel: ThemeViewModel = hiltViewModel(activity)
    val isDarkTheme by themeViewModel.isDarkTheme.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cài đặt", color = Color.White, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Quay lại",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = PrimaryBlueSettings)
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Card(
                shape     = RoundedCornerShape(12.dp),
                colors    = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(2.dp),
                modifier  = Modifier.fillMaxWidth()
            ) {
                Column {
                    // ── Dark Mode Switch ──────────────────────────────────
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Outlined.DarkMode,
                            contentDescription = "Chế độ tối",
                            tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                            modifier = Modifier.size(22.dp)
                        )
                        Spacer(Modifier.width(12.dp))
                        Text(
                            text     = "Chế độ tối",
                            modifier = Modifier.weight(1f),
                            fontSize = 14.sp,
                            color    = MaterialTheme.colorScheme.onSurface
                        )
                        // Switch kết nối với ThemeViewModel
                        Switch(
                            checked         = isDarkTheme,
                            onCheckedChange = { themeViewModel.toggleTheme() },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor  = AppColors.PrimaryBlue,
                                checkedTrackColor  = AppColors.PrimaryBlue.copy(alpha = 0.4f)
                            )
                        )
                    }

                    HorizontalDivider(
                        color    = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )

                    SettingsItem(
                        icon    = Icons.Outlined.Lock,
                        label   = "Đổi mật khẩu",
                        onClick = { navController.navigate("change_password") }
                    )
                    HorizontalDivider(
                        color    = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    SettingsItem(
                        icon    = Icons.Outlined.PersonOff,
                        label   = "Yêu cầu xóa tài khoản",
                        onClick = { /* TODO: navigate to delete account request screen */ }
                    )
                }
            }
        }
    }
}

@Composable
private fun SettingsItem(icon: ImageVector, label: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            icon,
            contentDescription = label,
            tint     = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
            modifier = Modifier.size(22.dp)
        )
        Spacer(Modifier.width(12.dp))
        Text(
            label,
            modifier = Modifier.weight(1f),
            fontSize = 14.sp,
            color    = MaterialTheme.colorScheme.onSurface
        )
        Icon(
            Icons.Default.ChevronRight,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f)
        )
    }
}

