package com.khyzhun.kravatka.pages.success

import android.annotation.SuppressLint
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
fun SuccessScreen(
    viewModel: SuccessViewModel,
    onConfirmationClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBarApp(
                title = "Success",
                isEnableBackIcon = false
            )
        },
        content = {
            SuccessScreenContent(
                modifier = Modifier.padding(it),
                onConfirmationClick = onConfirmationClick
            )
        }
    )
}

@Composable
fun SuccessScreenContent(
    modifier: Modifier,
    onConfirmationClick: () -> Unit
) {
    Column(modifier = modifier) {
        Text(text = "This is success screen", fontSize = 22.sp, color = Color.Red)
        Text(
            text = "To main screen",
            modifier = Modifier.clickable { onConfirmationClick.invoke() }
        )
    }
}