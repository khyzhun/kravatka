package com.khyzhun.kravatka.pages.billing

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
import com.khyzhun.kravatka.pages.address.DeliveryAddressViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BillingDetailsScreen(
    viewModel: BillingDetailsViewModel,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBarApp(
                title = "Billing Details",
                onBackClick = { onBackClick.invoke() }
            )
        },
        content = {
            BillingDetailsScreenContent(
                Modifier.padding(it)
            )
        }
    )
}

@Composable
private fun BillingDetailsScreenContent(
    modifier: Modifier
) {
    Column(modifier = modifier) {
        Text(text = "Billing Details", fontSize = 22.sp, color = Color.Red)
    }
}