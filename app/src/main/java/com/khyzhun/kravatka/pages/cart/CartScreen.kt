package com.khyzhun.kravatka.pages.cart

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.khyzhun.kravatka.core.components.TopBarApp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
    viewModel: CartViewModel,
    onNavigateToConfirm: () -> Unit,
    onNavigateToProduct: (Long) -> Unit,
) {
    Scaffold(
        topBar = {
            TopBarApp(
                title = "Cart",
                isEnableBackIcon = false
            )
        },
        content = {
            CartScreenContent(
                modifier = Modifier.padding(it),
                onNavigateToConfirm = onNavigateToConfirm,
                onNavigateToProduct = onNavigateToProduct,
            )
        }
    )
}

@Composable
private fun CartScreenContent(
    modifier: Modifier,
    onNavigateToConfirm: () -> Unit,
    onNavigateToProduct: (Long) -> Unit,
) {
    Column(modifier = modifier) {
        Text(text = "This is cart screen", fontSize = 22.sp, color = Color.Red)

        Text(
            text = "To confirm",
            modifier = Modifier.clickable { onNavigateToConfirm.invoke() }
        )
        Text(
            text = "To product",
            modifier = Modifier.clickable { onNavigateToProduct.invoke(-1) }
        )
    }
}