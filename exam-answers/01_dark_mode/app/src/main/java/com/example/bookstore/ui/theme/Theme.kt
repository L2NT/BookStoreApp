package com.example.bookstore.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * ==========================================
 * THEMING — PDF §4.1.3 Các khái niệm cơ bản Jetpack Compose
 * ==========================================
 *
 * BookStoreTheme nhận isDarkTheme param để switch giữa light/dark.
 * MaterialTheme cung cấp colorScheme và typography nhất quán cho toàn app.
 * Tất cả component Material 3 tự động dùng màu từ colorScheme — không cần
 * sửa từng màn hình khi đổi theme.
 */

private val LightColorScheme = lightColorScheme(
    primary         = Color(0xFF3E5EA5),  // AppColors.PrimaryBlue
    onPrimary       = Color.White,
    secondary       = Color(0xFF6E8CE3),
    onSecondary     = Color.White,
    background      = Color(0xFFF5F5F5),
    onBackground    = Color(0xFF000000),
    surface         = Color.White,
    onSurface       = Color(0xFF000000),
    error           = Color(0xFFF73A33),
    onError         = Color.White,
)

private val DarkColorScheme = darkColorScheme(
    primary         = Color(0xFF7B9FD4),  // Phiên bản sáng hơn của PrimaryBlue
    onPrimary       = Color(0xFF000000),
    secondary       = Color(0xFF6E8CE3),
    onSecondary     = Color.White,
    background      = Color(0xFF121212),  // Nền đen chuẩn Material Dark
    onBackground    = Color(0xFFFFFFFF),
    surface         = Color(0xFF1E1E1E),  // Card, Bottom bar
    onSurface       = Color(0xFFFFFFFF),
    error           = Color(0xFFCF6679),
    onError         = Color.Black,
)

/**
 * @param isDarkTheme true → dùng DarkColorScheme, false → LightColorScheme
 */
@Composable
fun BookStoreTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (isDarkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography  = Typography(),
        content     = content
    )
}

