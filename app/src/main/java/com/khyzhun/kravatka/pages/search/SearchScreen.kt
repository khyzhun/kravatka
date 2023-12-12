package com.khyzhun.kravatka.pages.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khyzhun.kravatka.core.components.TopBarApp
import com.khyzhun.kravatka.core.theme.md_theme_light_primaryContainer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    viewModel: SearchViewModel,
    onNavigateToProduct: (Long) -> Unit,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBarApp(
                title = "Search",
                onBackClick = { onBackClick.invoke() }
            )
        },
        content = {
            SearchScreenContent(
                modifier = Modifier.padding(it),
                onNavigateToProduct = onNavigateToProduct
            )
        }
    )
}

@Composable
private fun SearchScreenContent(
    modifier: Modifier,
    onNavigateToProduct: (Long) -> Unit
) {
    Column(modifier = modifier) {
        Text(text = "This is search screen", fontSize = 22.sp, color = Color.Red)
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "To product",
            modifier = Modifier.clickable { onNavigateToProduct.invoke(-1) }
        )
    }
}