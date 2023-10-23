package com.khyzhun.kravatka.pages

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.khyzhun.kravatka.navigation.Routes
import com.khyzhun.kravatka.pages.sign_in.SignInScreen
import com.khyzhun.kravatka.pages.sign_in.SignInViewModel
import com.khyzhun.kravatka.pages.splash.SplashScreen
import com.khyzhun.kravatka.pages.splash.SplashViewModel
import com.khyzhun.kravatka.pages.welcome.WelcomeScreen
import com.khyzhun.kravatka.pages.welcome.WelcomeViewModel
import com.khyzhun.kravatka.ui.theme.KravatkaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KravatkaTheme {
                RootAppNavigation()
            }
        }
    }

    @Composable
    fun RootAppNavigation(
        modifier: Modifier = Modifier,
        navController: NavHostController = rememberNavController(),
        startDestination: String = Routes.Splash.route,
    ) {
        val ctx = LocalContext.current

        NavHost(
            modifier = modifier,
            navController = navController,
            startDestination = startDestination,
        ) {
            composable(Routes.Splash.route) {
                val viewModel = hiltViewModel<SplashViewModel>()
                SplashScreen(
                    viewModel = viewModel,
                    onNavigationNext = {
                        navController.navigate(route = Routes.Welcome.route) {
                            popUpTo(0)
                        }
                    }
                )
            }
            composable(Routes.Welcome.route) {
                val viewModel = hiltViewModel<WelcomeViewModel>()
                WelcomeScreen(
                    viewModel = viewModel,
                    onNavigateToSignIn = {
                        navController.navigate(route = Routes.SignIn.route)
                    },
                    onNavigateToSignUp = {
                        navController.navigate(route = Routes.SignUp.route)
                    },
                )
            }
            composable(Routes.SignIn.route) {
                val viewModel = hiltViewModel<SignInViewModel>()
                SignInScreen(
                    viewModel = viewModel,
                    onBackClick = { navController.popBackStack() },
                    onForgotPasswordClick = { showToast("onForgotPasswordClick", ctx) },
                    onLoginClick = { showToast("onLoginClick", ctx) },
                    onLoginGoogleClick = { showToast("onLoginGoogleClick", ctx) },
                    onRegisterClick = { showToast("onRegisterClick", ctx) },
                )
            }
            composable(Routes.SignUp.route) {
                // TBD.
            }
            composable(Routes.Main.route) {
                // TBD.
            }

        }

    }

    private fun showToast(text: String, context: Context) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

}















