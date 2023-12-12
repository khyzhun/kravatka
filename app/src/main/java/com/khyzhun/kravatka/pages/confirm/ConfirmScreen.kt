package com.khyzhun.kravatka.pages.confirm

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.khyzhun.kravatka.core.components.TopBarApp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfirmScreen(
    viewModel: ConfirmViewModel,
    onNavigateToSuccess: () -> Unit,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBarApp(
                title = "Confirm",
                onBackClick = { onBackClick.invoke() }
            )
        },
        content = {
            Content(
                modifier = Modifier.padding(it),
                onNavigateToSuccess = onNavigateToSuccess
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Text(text = "Confirm")
        },
        navigationIcon = {}
    )
}

@Composable
fun Content(
    modifier: Modifier,
    onNavigateToSuccess: () -> Unit
) {
    Column(modifier = modifier) {
        Text(text = "This is confirmation screen", fontSize = 22.sp, color = Color.Red)
        Text(
            text = "To success",
            modifier = Modifier.clickable { onNavigateToSuccess.invoke() }
        )
    }
}