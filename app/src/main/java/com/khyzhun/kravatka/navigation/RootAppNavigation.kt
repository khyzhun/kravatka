package com.khyzhun.kravatka.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.khyzhun.kravatka.pages.main.MainScreen
import com.khyzhun.kravatka.pages.sign_in.SignInScreen
import com.khyzhun.kravatka.pages.sign_in.SignInViewModel
import com.khyzhun.kravatka.pages.sing_up.SignUpScreen
import com.khyzhun.kravatka.pages.sing_up.SignUpViewModel
import com.khyzhun.kravatka.pages.splash.SplashScreen
import com.khyzhun.kravatka.pages.splash.SplashViewModel
import com.khyzhun.kravatka.pages.welcome.WelcomeScreen
import com.khyzhun.kravatka.pages.welcome.WelcomeViewModel
import com.khyzhun.kravatka.utils.appToastShow

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
                onForgotPasswordClick = { appToastShow("onForgotPasswordClick", ctx) },
                onLoginClick = { appToastShow("Success", ctx) },
                onLoginGoogleClick = { appToastShow("onLoginGoogleClick", ctx) },
                onRegisterClick = { navController.navigate(route = Routes.SignUp.route) },
            )
        }
        composable(Routes.SignUp.route) {
            val viewModel = hiltViewModel<SignUpViewModel>()
            SignUpScreen(
                viewModel = viewModel,
                onNextClick = { appToastShow("onNextClick", ctx) },
                onBackClick = { navController.popBackStack() },
                onTermsConditionsClick = { appToastShow("onTermsConditionsClick", ctx) },
                privacyPolicyOnClick = { appToastShow("privacyPolicyOnClick", ctx) }
            )
        }
        composable(Routes.Main.route) {
            MainScreen()
        }

    }
}

























