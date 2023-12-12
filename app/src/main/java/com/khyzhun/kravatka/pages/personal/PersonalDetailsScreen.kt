package com.khyzhun.kravatka.pages.personal

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
fun PersonalDetailsScreen(
    viewModel: PersonalDetailsViewModel,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBarApp(
                title = "Personal Details",
                onBackClick = { onBackClick.invoke() }
            )
        },
        content = {
            PersonalDetailsScreenContent(
                Modifier.padding(it)
            )
        }
    )
}

@Composable
private fun PersonalDetailsScreenContent(
    modifier: Modifier
) {
    Column(modifier = modifier) {
        Text(text = "Personal Details", fontSize = 22.sp, color = Color.Red)
    }
}