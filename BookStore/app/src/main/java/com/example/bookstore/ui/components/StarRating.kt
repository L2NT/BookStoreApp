package com.example.bookstore.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarHalf
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookstore.ui.theme.AppColors

/**
 * StarRating — Composable tái sử dụng hiển thị đánh giá sao.
 *
 * Cơ chế hoạt động:
 * - Nhận rating: Double → với mỗi vị trí sao i (0 đến maxStars-1), so sánh
 *   rating vs (i+1) và (i+0.5) để quyết định icon: Star (đầy) / StarHalf (nửa) / StarOutline (rỗng).
 * - Hỗ trợ half-star: rating = 3.5 → 3 sao Star + 1 sao StarHalf + 1 sao StarOutline.
 * - Dùng Icon Material vector thay vì Text "★"/"☆" trong BookCard cũ —
 *   vector scale mượt hơn ký tự Unicode, có thể customise size/tint/modifier dễ dàng.
 * - Pure Composable: stateless, không cần ViewModel.
 *
 * @param rating    Điểm đánh giá trung bình (0.0 – maxStars). Hỗ trợ thập phân (4.3, 3.5...).
 * @param maxStars  Số sao tối đa (mặc định 5).
 * @param starSize  Kích thước mỗi icon sao (mặc định 16.dp).
 * @param showCount Có hiển thị số lượt đánh giá hay không.
 * @param count     Số lượt đánh giá — chỉ hiển thị khi showCount = true và count > 0.
 */
@Composable
fun StarRating(
    rating   : Double,
    maxStars : Int     = 5,
    starSize : Dp      = 16.dp,
    showCount: Boolean = false,
    count    : Int     = 0
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        // ── Render từng sao ──────────────────────────────────────────────────
        repeat(maxStars) { i ->
            val starValue = i + 1
            // rating >= starValue      → sao đầy  (Star filled)
            // rating >= starValue-0.5  → nửa sao  (StarHalf)
            // else                     → sao rỗng (StarOutline)
            val icon = when {
                rating >= starValue       -> Icons.Default.Star
                rating >= starValue - 0.5 -> Icons.Default.StarHalf
                else                      -> Icons.Outlined.StarOutline
            }
            val tint = if (rating >= starValue - 0.5) AppColors.StarYellow else Color.LightGray

            Icon(
                imageVector        = icon,
                contentDescription = null,
                tint               = tint,
                modifier           = Modifier.size(starSize)
            )
        }

        // ── Số lượt đánh giá (tuỳ chọn) ─────────────────────────────────────
        if (showCount && count > 0) {
            Spacer(Modifier.width(3.dp))
            Text(text = "($count)", color = Color.Gray, fontSize = 10.sp)
        }
    }
}

