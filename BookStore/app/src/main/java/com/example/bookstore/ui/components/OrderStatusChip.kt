package com.example.bookstore.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.HourglassEmpty
import androidx.compose.material.icons.outlined.Inventory2
import androidx.compose.material.icons.outlined.LocalShipping
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * OrderStatusChip — Composable tái sử dụng hiển thị trạng thái đơn hàng.
 *
 * Cơ chế hoạt động:
 * - Nhận một tham số status: String → dùng when(status.uppercase()) map sang (label, color, icon).
 * - Render Surface chip với màu nền alpha=0.12 (mờ) + border cùng màu — đây là
 *   pattern chuẩn Material3 cho "tinted chip" không cần dùng FilterChip API.
 * - Hoàn toàn stateless, không cần ViewModel — chỉ là pure Composable nhận data vào render ra UI.
 *
 * Pattern giống UVIndexIndicator (nhóm React/Weather):
 *   UVIndexIndicator(uvi: Double)   → when(uvi)    → backgroundColor (xanh/vàng/cam/đỏ/tím)
 *   OrderStatusChip(status: String) → when(status) → color + label + icon
 *
 * @param status Trạng thái đơn hàng dạng String từ backend (không phân biệt hoa thường).
 */
@Composable
fun OrderStatusChip(status: String) {
    // ── Map status → (label, color, icon) ────────────────────────────────────
    // uppercase() để chấp nhận cả "pending", "PENDING", "Pending" từ backend
    val (label, color, icon) = when (status.uppercase()) {
        "PENDING"                 -> Triple("Chờ xác nhận",   Color(0xFFFF9800), Icons.Outlined.HourglassEmpty)
        "PROCESSING", "CONFIRMED" -> Triple("Đang xử lý",     Color(0xFF2196F3), Icons.Outlined.Inventory2)
        "SHIPPED", "SHIPPING"     -> Triple("Đang giao hàng", Color(0xFF9C27B0), Icons.Outlined.LocalShipping)
        "DELIVERED"               -> Triple("Đã giao hàng",   Color(0xFF4CAF50), Icons.Outlined.CheckCircle)
        "CANCELLED"               -> Triple("Đã hủy",         Color(0xFFF44336), Icons.Outlined.Cancel)
        else                      -> Triple(status,            Color.Gray,        Icons.Outlined.HourglassEmpty as ImageVector)
    }

    // ── Render: Surface chip với tinted background + border ──────────────────
    // color.copy(alpha = 0.12f): nền mờ cùng màu với text — tạo hiệu ứng "tinted chip"
    // BorderStroke(1.dp, color): viền rõ cùng màu — giúp phân biệt khi nền app cũng trắng
    Surface(
        shape  = RoundedCornerShape(16.dp),
        color  = color.copy(alpha = 0.12f),
        border = BorderStroke(1.dp, color)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
        ) {
            Icon(
                imageVector        = icon,
                contentDescription = null,
                tint               = color,
                modifier           = Modifier.size(14.dp)
            )
            Spacer(Modifier.width(4.dp))
            Text(
                text       = label,
                color      = color,
                fontSize   = 12.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

