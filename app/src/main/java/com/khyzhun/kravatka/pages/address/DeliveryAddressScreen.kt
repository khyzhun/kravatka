package com.khyzhun.kravatka.pages.address

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
fun DeliveryAddressScreen(
    viewModel: DeliveryAddressViewModel,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBarApp(
                title = "Delivery Address",
                onBackClick = { onBackClick.invoke() }
            )
        },
        content = {
            DeliveryAddressScreenContent(
                Modifier.padding(it)
            )
        }
    )
}

@Composable
private fun DeliveryAddressScreenContent(
    modifier: Modifier
) {
    Column(modifier = modifier) {
        Text(text = "Delivery Address", fontSize = 22.sp, color = Color.Red)
    }
}