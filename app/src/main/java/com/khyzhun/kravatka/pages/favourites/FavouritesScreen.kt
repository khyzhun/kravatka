package com.khyzhun.kravatka.pages.favourites

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.khyzhun.kravatka.core.theme.md_theme_light_primaryContainer


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouritesScreen(
    viewModel: FavouritesViewModel,
    onNavigateToProduct: (Long) -> Unit,
) {
    Scaffold(
        topBar = { TopBar() },
        content = {
            Content(
                modifier = Modifier.padding(it),
                onNavigateToProduct = onNavigateToProduct
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Text(
                "Favourites",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(md_theme_light_primaryContainer)
    )
}

@Composable
fun Content(
    modifier: Modifier,
    onNavigateToProduct: (Long) -> Unit,
) {
    Column(modifier = modifier) {
        Text(
            text = "This is favourites screen",
            fontSize = 22.sp,
            color = Color.Red
        )
        Text(
            text = "To product",
            modifier = Modifier.clickable { onNavigateToProduct.invoke(-1) }
        )
    }
}