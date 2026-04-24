package com.example.bookstore.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

/**
 * ThemeViewModel — Quản lý trạng thái Dark Mode toàn ứng dụng.
 *
 * Được hoist tại MainActivity (by viewModels()) để sống suốt vòng đời app.
 * SettingsScreen lấy cùng instance qua hiltViewModel(activity).
 *
 * StateFlow<Boolean>: khi isDarkTheme thay đổi → tất cả Composable
 * đang collectAsState() tự recompose — reactive programming.
 */
@HiltViewModel
class ThemeViewModel @Inject constructor() : ViewModel() {

    private val _isDarkTheme = MutableStateFlow(false)
    val isDarkTheme: StateFlow<Boolean> = _isDarkTheme.asStateFlow()

    /** Bật/tắt Dark Mode */
    fun toggleTheme() {
        _isDarkTheme.value = !_isDarkTheme.value
    }
}

