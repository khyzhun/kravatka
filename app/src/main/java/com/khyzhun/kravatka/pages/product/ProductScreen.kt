package com.khyzhun.kravatka.pages.product

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.khyzhun.kravatka.R
import com.khyzhun.kravatka.core.components.TopBarApp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductScreen(
    viewModel: ProductViewModel,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBarApp(
                title = "Product",
                onBackClick = onBackClick
            )
        },
        content = {
            ProductScreenContent(
                modifier = Modifier.padding(it)
            )
        }
    )
}

@Composable
private fun ProductScreenContent(
    modifier: Modifier
) {
    Column(modifier = modifier) {
        Text(text = "This is product screen", fontSize = 22.sp, color = Color.Red)
    }
}