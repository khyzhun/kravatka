package com.khyzhun.kravatka.pages.product

import android.content.ContentValues
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconToggleButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.khyzhun.kravatka.R
import com.khyzhun.kravatka.core.base.BaseContentLayout
import com.khyzhun.kravatka.core.components.PrimaryButton
import com.khyzhun.kravatka.core.components.RoundedButton
import com.khyzhun.kravatka.domain.models.ProductDetails
import com.khyzhun.kravatka.utils.MockUtils
import kotlinx.coroutines.CoroutineScope


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductScreen(
    viewModel: ProductViewModel,
    id: Long,
    onBackClick: () -> Unit,
    onBuyNowClick: () -> Unit
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.handleUiEvent(
            ProductUiEvent.LoadData(id)
        )
    }

    BaseContentLayout(
        viewModel = viewModel
    ) { uiState ->
        uiState?.let {
            ProductScreenContent(
                product = it.product,
                isAddedToCart = it.isAddedToCart,
                uiEvent = viewModel::handleUiEvent,
                onBuyNowClick = onBuyNowClick
            )
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
private fun ProductScreenContent(
    product: ProductDetails,
    isAddedToCart: Boolean,
    uiEvent: (ProductUiEvent) -> Unit,
    onBuyNowClick: () -> Unit
) {

    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState(
        BottomSheetState(
            initialValue = BottomSheetValue.Expanded
        )
    )

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetGesturesEnabled = false,
        sheetElevation = 8.dp,
        sheetShape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp),
        sheetBackgroundColor = MaterialTheme.colorScheme.surfaceContainer,
        sheetContent = {
            BottomSheetContent(
                scaffoldState = scaffoldState,
                scope = scope,
                product = product,
                uiEvent = uiEvent,
                isAddedToCart = isAddedToCart,
                onBuyNowClick = onBuyNowClick
            )
        }
    ) {
        // Other content
        HorizontalPagerWithIndicators(product.imageUrls)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun BottomSheetContent(
    scaffoldState: BottomSheetScaffoldState,
    scope: CoroutineScope,
    product: ProductDetails,
    uiEvent: (ProductUiEvent) -> Unit,
    isAddedToCart: Boolean,
    onBuyNowClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxHeight(0.5f)
            .fillMaxWidth()
            .padding(all = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            ProductTitle(title = product.title)
            Spacer(modifier = Modifier.width(8.dp))
            ProductPrice(price = product.price)
            FavouriteButton(product.isFavourite, uiEvent)
        }
        ProductCategory(category = product.category)
        Spacer(modifier = Modifier.height(8.dp))
        ProductDescription(description = product.description)
        Box(modifier = Modifier.fillMaxSize()) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            ) {
                RoundedButton(
                    icon = {
                       Icon(
                           imageVector = if (isAddedToCart) {
                               Icons.Outlined.CheckCircle
                           } else {
                               Icons.Filled.ShoppingCart
                           },
                           contentDescription = null
                       )
                    },
                    onClick = { uiEvent(ProductUiEvent.AddToCartOnClick) }
                )
                PrimaryButton(
                    text = stringResource(R.string.buy_now),
                    roundDp = 16.dp,
                    onClick = { onBuyNowClick.invoke() }
                )
            }
        }
    }
}

@Composable
private fun ProductDescription(description: String) {
    Text(
        text = description,
        style = MaterialTheme.typography.bodyMedium,
        maxLines = 10,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
private fun ProductCategory(category: String) {
    Text(
        text = category,
        style = MaterialTheme.typography.bodyMedium,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
private fun FavouriteButton(isFavourite: Boolean, uiEvent: (ProductUiEvent) -> Unit) {
    Box(
        contentAlignment = Alignment.TopEnd,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        OutlinedIconToggleButton(
            checked = isFavourite,
            onCheckedChange = { uiEvent(ProductUiEvent.UpdateFavouriteOnClick) },
            content = {
                Icon(
                    modifier = Modifier.size(22.dp),
                    imageVector = Icons.Default.Favorite,
                    contentDescription = null
                )
            }
        )
    }
}

@Composable
private fun ProductPrice(price: Double) {
    Text(
        text = "\$$price", // TODO: change format
        style = MaterialTheme.typography.headlineSmall,
        maxLines = 1,
        color = MaterialTheme.colorScheme.error,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
private fun ProductTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineMedium,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HorizontalPagerWithIndicators(imageUrls: List<String>) {
    val pageCount = imageUrls.size
    val pagerState = rememberPagerState { pageCount }

    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.5f)
    ) {
        Column(modifier = Modifier.align(Alignment.Center)) {
            HorizontalPager(
                state = pagerState,
                contentPadding = PaddingValues(horizontal = 20.dp),
                pageSpacing = 10.dp
            ) { page ->
                ProductPhoto(url = imageUrls[page])
            }
            DotIndicator(pageCount, pagerState)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun DotIndicator(pageCount: Int, pagerState: PagerState) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        repeat(pageCount) { iteration ->
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .clip(CircleShape)
                    .background(
                        color = if (pagerState.currentPage == iteration) {
                            Color.Gray
                        } else {
                            Color.Gray.copy(alpha = 0.5f)
                        }
                    )
                    .size(12.dp)
            )
        }
    }
}

@Composable
private fun ProductPhoto(url: String) {
    Image(
        alignment = Alignment.Center,
        painter = rememberAsyncImagePainter(model = url),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .clip(RoundedCornerShape(12.dp))
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ProductScreenContentPreview() {
    ProductScreenContent(
        product = MockUtils.loadMockProductsDetails().first(),
        isAddedToCart = false,
        uiEvent = {},
        onBuyNowClick = {}
    )
}























