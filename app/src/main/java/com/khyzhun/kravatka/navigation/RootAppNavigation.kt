package com.khyzhun.kravatka.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.khyzhun.kravatka.pages.splash.SplashScreen
import com.khyzhun.kravatka.pages.splash.SplashViewModel
import com.khyzhun.kravatka.pages.welcome.WelcomeScreen
import com.khyzhun.kravatka.pages.welcome.WelcomeViewModel

@Composable
fun RootAppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Routes.Splash.route,
) {
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
        composable(Routes.Feed.route) {
            // TBD.
        }

    }
}