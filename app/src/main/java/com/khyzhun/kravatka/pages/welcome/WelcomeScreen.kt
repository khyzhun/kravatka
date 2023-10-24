package com.khyzhun.kravatka.pages.welcome

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.khyzhun.kravatka.ui.theme.PurpleGrey40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(
    viewModel: WelcomeViewModel,
    onNavigateToSignIn: () -> Unit,
    onNavigateToSignUp: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopBar()
        },
        content = {
            WelcomeScreenContent(
                modifier = Modifier.padding(it),
                onNavigateToSignIn = onNavigateToSignIn,
                onNavigateToSignUp = onNavigateToSignUp
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Welcome Screen",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(PurpleGrey40)
    )
}

@Composable
private fun WelcomeScreenContent(
    modifier: Modifier,
    onNavigateToSignIn: () -> Unit,
    onNavigateToSignUp: () -> Unit
) {
    Column(modifier = modifier) {
        Text(
            text = "Navigate to Sign In",
            modifier = Modifier.clickable {
                onNavigateToSignIn.invoke()
            }
        )
        Text(
            text = "Navigate to Sign Up",
            modifier = Modifier.clickable {
                onNavigateToSignUp.invoke()
            }
        )

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview(showBackground = true)
private fun WelcomeScreenContentPreview() {
    WelcomeScreenContent(
        modifier = Modifier,
        onNavigateToSignIn = { /*TODO*/ },
        onNavigateToSignUp = { /*TODO*/ }
    )


}



















