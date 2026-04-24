package com.example.bookstore.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.bookstore.data.model.Book
import com.example.bookstore.ui.theme.AppColors
import com.example.bookstore.utils.displayPrice
import com.example.bookstore.utils.toVnd
import com.example.bookstore.viewmodel.WishlistViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WishlistScreen(
    navController: NavController,
    wishlistViewModel: WishlistViewModel
) {
    val wishlist by wishlistViewModel.wishlist.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Sách yêu thích", color = Color.White, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Quay lại",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = AppColors.PrimaryBlue)
            )
        },
        containerColor = Color(0xFFF5F5F5)
    ) { padding ->
        if (wishlist.isEmpty()) {
            // Trạng thái rỗng
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("❤️", fontSize = 48.sp)
                    Spacer(Modifier.height(12.dp))
                    Text(
                        "Chưa có sách yêu thích",
                        color    = Color.Gray,
                        fontSize = 16.sp
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "Bấm ❤️ trên trang chi tiết sách để thêm vào đây",
                        color    = Color.Gray,
                        fontSize = 13.sp
                    )
                }
            }
        } else {
            LazyColumn(
                modifier            = Modifier.padding(padding),
                contentPadding      = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(wishlist, key = { it.id }) { book ->
                    WishlistItem(
                        book     = book,
                        onRemove = { wishlistViewModel.remove(book.id) }
                    )
                }
            }
        }
    }
}

@Composable
private fun WishlistItem(book: Book, onRemove: () -> Unit) {
    Card(
        shape     = RoundedCornerShape(10.dp),
        colors    = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(2.dp),
        modifier  = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier          = Modifier.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model             = book.imageUrl,
                contentDescription = book.title,
                contentScale      = ContentScale.Crop,
                modifier          = Modifier
                    .size(64.dp, 80.dp)
                    .clip(RoundedCornerShape(6.dp))
            )
            Spacer(Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    book.title,
                    fontWeight  = FontWeight.Bold,
                    fontSize    = 14.sp,
                    maxLines    = 2,
                    overflow    = TextOverflow.Ellipsis
                )
                Spacer(Modifier.height(4.dp))
                Text(book.author, color = Color.Gray, fontSize = 12.sp, maxLines = 1)
                Spacer(Modifier.height(6.dp))
                Text(
                    book.displayPrice().toVnd(),
                    color      = AppColors.PriceColor,
                    fontWeight = FontWeight.Bold,
                    fontSize   = 14.sp
                )
            }
            IconButton(onClick = onRemove) {
                Icon(
                    Icons.Default.Delete,
                    contentDescription = "Xóa khỏi yêu thích",
                    tint = Color.Gray
                )
            }
        }
    }
}

