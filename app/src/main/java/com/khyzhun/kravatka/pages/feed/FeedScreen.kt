package com.khyzhun.kravatka.pages.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.khyzhun.kravatka.core.base.BaseContentLayout
import com.khyzhun.kravatka.core.components.SearchCategories
import com.khyzhun.kravatka.core.components.TopBarAsText
import com.khyzhun.kravatka.domain.models.Product
import com.khyzhun.kravatka.utils.MockUtils


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedScreen(
    viewModel: FeedViewModel,
    onNavigateToNotifications: () -> Unit,
    onNavigateToProduct: (Long) -> Unit,
    onNavigateToSearch: () -> Unit
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.handleUiEvent(
            FeedUiEvent.LoadScreenData
        )
    }
    BaseContentLayout(
        viewModel = viewModel,
        onBackPressed = null
    ) { uiState ->
        uiState?.let {
            FeedScreenContent(
                products = it.products,
                searchCategories = it.searchCategories,
                onNavigateToNotifications = onNavigateToNotifications,
                onNavigateToProduct = onNavigateToProduct,
                onNavigateToSearch = onNavigateToSearch
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun FeedScreenContent(
    products: List<Product>,
    searchCategories: List<String>,
    onNavigateToNotifications: () -> Unit,
    onNavigateToProduct: (Long) -> Unit,
    onNavigateToSearch: () -> Unit
) {
    Column {
        TopBarAsText(title = "Feed")
        SearchCategories(
            tags = searchCategories,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            content = {
                items(products.size) { index ->
                    ProductItem(
                        product = products[index],
                        onNavigateToProduct = onNavigateToProduct
                    )
                }
            }
        )
    }
}

@Composable
private fun ProductItem(
    product: Product,
    onNavigateToProduct: (Long) -> Unit
) {
    val isFavourite by remember { mutableStateOf(product.isFavourite) }

    Column {
        Card(
            shape = MaterialTheme.shapes.medium,
            elevation = CardDefaults.cardElevation(2.dp),
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onNavigateToProduct.invoke(product.id) }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            ) {
                BackgroundImage(imageUrl = product.imageUrl)
                FavouriteButton(isFavourite)
            }
        }
        ProductItemTitle(title = product.title)
        ProductItemPrice(price = product.price)
    }
}

@Composable
private fun BackgroundImage(imageUrl: String) {
    Image(
        alignment = Alignment.Center,
        painter = rememberAsyncImagePainter(model = imageUrl),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .clip(RectangleShape)
    )
}

@Composable
private fun FavouriteButton(isFavourite: Boolean) {
    Box(
        contentAlignment = Alignment.TopEnd,
        modifier = Modifier.padding(8.dp).fillMaxWidth()
    ) {
        OutlinedIconToggleButton(
            checked = isFavourite,
            onCheckedChange = {}
        ) {
            Icon(
                modifier = Modifier.size(22.dp),
                imageVector = Icons.Default.Favorite,
                contentDescription = null
            )
        }
    }
}

@Composable
private fun ProductItemTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp)
    )
}

@Composable
private fun ProductItemPrice(price: Double) {
    Text(
        text = "\$$price", //TODO: format price
        style = MaterialTheme.typography.titleSmall,
        maxLines = 1,
        color = Color.Gray,
        fontSize = 12.sp,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 0.dp)
    )
}


@Preview(showSystemUi = true)
@Composable
private fun FeedScreenContentPreview() {
    FeedScreenContent(
        onNavigateToNotifications = {},
        onNavigateToProduct = {},
        onNavigateToSearch = {},
        products = MockUtils.loadMockProducts(),
        searchCategories = MockUtils.loadMockSearchCategories()
    )
}