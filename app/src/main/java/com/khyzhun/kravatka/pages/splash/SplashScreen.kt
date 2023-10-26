package com.khyzhun.kravatka.pages.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.khyzhun.kravatka.R
import com.khyzhun.kravatka.core.components.ProgressIndicator
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SplashScreen(
    viewModel: SplashViewModel,
    onNavigationNext: () -> Unit
) {
    Scaffold(
        content = {
            SplashScreenContent(
                modifier = Modifier.padding(it),
                onNavigationNext = onNavigationNext
            )
        }
    )
}

@Composable
private fun SplashScreenContent(
    modifier: Modifier,
    onNavigationNext: () -> Unit
) {
    Column(
        modifier = modifier
            .padding(top = 100.dp)
            .fillMaxSize(),
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.splash_logo),
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                ProgressIndicator(modifier = Modifier.padding(top = 32.dp))
            }
        }
    }
    LaunchedEffect(Unit) {
        delay(2000)
        onNavigationNext()
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    SplashScreenContent(Modifier) {}
}














