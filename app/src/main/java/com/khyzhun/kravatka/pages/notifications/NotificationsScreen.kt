package com.khyzhun.kravatka.pages.notifications

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khyzhun.kravatka.R
import com.khyzhun.kravatka.core.components.TopBarApp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationsScreen(
    viewModel: NotificationsViewModel,
    onBackClick: () -> Unit
) {
    Scaffold(topBar = {
        TopBarApp(
            title = stringResource(id = R.string.notifications),
            onBackClick = onBackClick
        )
    }
    ) {
        NotificationScreenContent(
            modifier = Modifier.padding(it)
        )
    }
}

@Composable
private fun NotificationScreenContent(modifier: Modifier) {
    Column(modifier = modifier) {
        Text(text = "This is notification screen", fontSize = 22.sp, color = Color.Red)
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationsScreenPreview() {
    NotificationsScreen(
        viewModel = NotificationsViewModel()
    ) { TODO() }
}