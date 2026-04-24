package com.example.bookstore.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * StockBadge — Composable hiển thị trạng thái tồn kho với màu cảnh báo theo ngưỡng.
 *
 * Cơ chế hoạt động:
 * - Nhận quantity: Int → dùng when { ... } (range check) map sang (label, color).
 * - Ngưỡng: <= 0 (hết hàng/đỏ), 1–5 (sắp hết/cam), > 5 (còn hàng/xanh lá).
 * - Render Surface chip với màu nền alpha=0.12 + border — cùng style với OrderStatusChip.
 * - Pure Composable: stateless, không cần ViewModel.
 *
 * Pattern giống UVIndexIndicator (nhóm React/Weather):
 *   UVIndexIndicator(uvi: Double)  → when { uvi <= 2 → xanh, uvi <= 5 → vàng, ... }
 *   StockBadge(quantity: Int)      → when { qty <= 0 → đỏ,   qty <= 5 → cam,  ... }
 *
 * Tham chiếu báo cáo: Ch.12.1.2 — Quản lý sách:
 *   "Hỗ trợ upload ảnh bìa, nhập mô tả, giá, số lượng tồn kho."
 *
 * @param quantity Số lượng tồn kho hiện tại của sách.
 */
@Composable
fun StockBadge(quantity: Int) {
    // ── Map quantity → (label, color) theo ngưỡng ────────────────────────────
    // Dùng when { condition } (không phải when(value)) vì cần so sánh range
    val (label, color) = when {
        quantity <= 0 -> Pair(
            "Hết hàng",
            Color(0xFFF44336)   // Đỏ — hết hàng, người dùng không thể mua
        )
        quantity <= 5 -> Pair(
            "Sắp hết ($quantity còn lại)",
            Color(0xFFFF9800)   // Cam — cảnh báo sắp hết, tạo urgency cho người dùng
        )
        else -> Pair(
            "Còn hàng",
            Color(0xFF4CAF50)   // Xanh lá — đủ hàng, mua thoải mái
        )
    }

    // ── Render: Surface chip với tinted background + border ──────────────────
    // Cùng style với OrderStatusChip để đồng nhất visual language trong app
    Surface(
        shape  = RoundedCornerShape(4.dp),   // 4.dp (vuông hơn) phù hợp badge nhỏ, vs 16.dp (pill) của OrderStatusChip
        color  = color.copy(alpha = 0.12f),
        border = BorderStroke(1.dp, color)
    ) {
        Text(
            text       = label,
            color      = color,
            fontSize   = 12.sp,
            fontWeight = FontWeight.Medium,
            modifier   = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
        )
    }
}
