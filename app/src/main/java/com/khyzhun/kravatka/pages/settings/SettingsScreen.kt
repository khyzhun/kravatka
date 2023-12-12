package com.khyzhun.kravatka.pages.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.khyzhun.kravatka.core.components.TopBarApp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBarApp(
                title = "Settings",
                onBackClick = { onBackClick.invoke() }
            )
        },
        content = {
            SettingsScreenContent(Modifier.padding(it))
        }
    )
}

@Composable
private fun SettingsScreenContent(
    modifier: Modifier
) {
    Column(modifier = modifier) {
        Text(text = "Settings", fontSize = 22.sp, color = Color.Red)
    }
}

@Preview
@Composable
private fun SettingsScreenPreview() {
    val viewModel = hiltViewModel<SettingsViewModel>()
    SettingsScreen(
        viewModel,
        onBackClick = {}
    )
}