package com.khyzhun.kravatka.pages.profile

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
fun ProfileScreen(
    viewModel: ProfileViewModel,
    onNavigateToSettings: () -> Unit,
    onNavigateToPersonalDetails: () -> Unit,
    onNavigateToDeliveryAddress: () -> Unit,
    onNavigateToBillingDetails: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBarApp(
                title = "Profile",
            )
        },
        content = {
            ProfileScreenContent(
                modifier = Modifier.padding(it),
                onNavigateToSettings = onNavigateToSettings,
                onNavigateToPersonalDetails = onNavigateToPersonalDetails,
                onNavigateToDeliveryAddress = onNavigateToDeliveryAddress,
                onNavigateToBillingDetails = onNavigateToBillingDetails
            )
        }
    )
}

@Composable
private fun ProfileScreenContent(
    modifier: Modifier,
    onNavigateToSettings: () -> Unit,
    onNavigateToPersonalDetails: () -> Unit,
    onNavigateToDeliveryAddress: () -> Unit,
    onNavigateToBillingDetails: () -> Unit
) {
    Column(modifier = modifier) {
        Text(text = "This is profile screen", fontSize = 22.sp, color = Color.Red)
        Text(
            text = "To settings",
            modifier = Modifier.clickable { onNavigateToSettings.invoke() }
        )
        Text(
            text = "To personal details",
            modifier = Modifier.clickable { onNavigateToPersonalDetails.invoke() }
        )
        Text(
            text = "To delivery address",
            modifier = Modifier.clickable { onNavigateToDeliveryAddress.invoke() }
        )
        Text(
            text = "To billing details",
            modifier = Modifier.clickable { onNavigateToBillingDetails.invoke() }
        )
    }
}