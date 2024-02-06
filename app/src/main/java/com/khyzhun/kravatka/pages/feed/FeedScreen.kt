package com.khyzhun.kravatka.pages.feed

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.khyzhun.kravatka.core.components.TopBarApp
import com.khyzhun.kravatka.core.theme.md_theme_light_primaryContainer


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedScreen(
    viewModel: FeedViewModel,
    onNavigateToNotifications: () -> Unit,
    onNavigateToProduct: (Long) -> Unit,
    onNavigateToSearch: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBarApp(
                title = "Feed",
            )
        },
        content = {
            FeedScreenContent(
                modifier = Modifier.padding(it),
                onNavigateToNotifications = onNavigateToNotifications,
                onNavigateToSearch = onNavigateToSearch,
                onNavigateToProduct = onNavigateToProduct
            )
        }
    )
}

@Composable
private fun FeedScreenContent(
    modifier: Modifier,
    onNavigateToNotifications: () -> Unit,
    onNavigateToProduct: (Long) -> Unit,
    onNavigateToSearch: () -> Unit
) {
    Column(modifier = modifier) {
        Text(text = "This is feed screen", fontSize = 22.sp, color = Color.Red)

        Text(
            text = "To notifications",
            modifier = Modifier.clickable { onNavigateToNotifications.invoke() }
        )
        Text(
            text = "To product",
            modifier = Modifier.clickable { onNavigateToProduct.invoke(-1) }
        )
        Text(
            text = "To search",
            modifier = Modifier.clickable { onNavigateToSearch.invoke() }
        )
    }
}