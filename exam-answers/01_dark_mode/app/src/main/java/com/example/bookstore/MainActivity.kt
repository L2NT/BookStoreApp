package com.example.bookstore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.runtime.getValue
import com.example.bookstore.ui.screens.MainScreen
import com.example.bookstore.ui.theme.BookStoreTheme
import com.example.bookstore.viewmodel.ThemeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    // ThemeViewModel hoist tại Activity level:
    // - Sống suốt vòng đời Activity (không bị mất khi navigate giữa các màn hình)
    // - SettingsScreen lấy cùng instance qua hiltViewModel(activity)
    private val themeViewModel: ThemeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Collect StateFlow → Composable recompose khi isDarkTheme thay đổi
            val isDarkTheme by themeViewModel.isDarkTheme.collectAsStateWithLifecycle()

            // BookStoreTheme cung cấp MaterialTheme (colorScheme, typography)
            // cho toàn bộ app — PDF §4.1.3 Theming trong Jetpack Compose
            BookStoreTheme(isDarkTheme = isDarkTheme) {
                MainScreen()
            }
        }
    }
}

