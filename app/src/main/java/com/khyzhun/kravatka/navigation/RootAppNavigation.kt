package com.khyzhun.kravatka.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.khyzhun.kravatka.pages.cart.CartScreen
import com.khyzhun.kravatka.pages.cart.CartViewModel
import com.khyzhun.kravatka.pages.confirm.ConfirmScreen
import com.khyzhun.kravatka.pages.confirm.ConfirmViewModel
import com.khyzhun.kravatka.pages.main.MainScreen
import com.khyzhun.kravatka.pages.notifications.NotificationsScreen
import com.khyzhun.kravatka.pages.notifications.NotificationsViewModel
import com.khyzhun.kravatka.pages.product.ProductScreen
import com.khyzhun.kravatka.pages.product.ProductViewModel
import com.khyzhun.kravatka.pages.signin.SignInScreen
import com.khyzhun.kravatka.pages.signin.SignInViewModel
import com.khyzhun.kravatka.pages.singup.SignUpScreen
import com.khyzhun.kravatka.pages.singup.SignUpViewModel
import com.khyzhun.kravatka.pages.splash.SplashScreen
import com.khyzhun.kravatka.pages.splash.SplashViewModel
import com.khyzhun.kravatka.pages.success.SuccessScreen
import com.khyzhun.kravatka.pages.success.SuccessViewModel
import com.khyzhun.kravatka.pages.welcome.WelcomeScreen
import com.khyzhun.kravatka.pages.welcome.WelcomeViewModel

@Composable
fun RootAppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Routes.Main.route
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
        route = null
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
                    navController.navigate(route = Routes.SignIn.route) {
                        popUpTo(0)
                    }
                },
                onNavigateToSignUp = {
                    navController.navigate(route = Routes.SignUp.route) {
                        popUpTo(0)
                    }
                }
            )
        }

        composable(Routes.SignIn.route) {
            val viewModel = hiltViewModel<SignInViewModel>()
            SignInScreen(
                viewModel = viewModel,
                onBackClick = {
                    navController.navigate(route = Routes.Welcome.route) {
                        popUpTo(0)
                    }
                },
                onForgotPasswordClick = {
                    //TODO: TBD.
                },
                onLoginClick = {
                    navController.navigate(route = Routes.Main.route) {
                        popUpTo(0)
                    }
                },
                onLoginGoogleClick = {
                    //TODO: TBD.
                },
                onRegisterClick = {
                    navController.navigate(route = Routes.SignUp.route) {
                        popUpTo(0)
                    }
                },
            )
        }

        composable(Routes.SignUp.route) {
            val viewModel = hiltViewModel<SignUpViewModel>()
            SignUpScreen(
                viewModel = viewModel,
                onBackClick = {
                    navController.navigate(route = Routes.Welcome.route) {
                        popUpTo(0)
                    }
                },
                onNextClick = {
                    navController.navigate(route = Routes.Main.route) {
                        popUpTo(0)
                    }
                },
                onTermsClick = {
                    //TODO: TBD.
                },
                onPrivacyClick = {
                    //TODO: TBD.
                },
            )
        }

        composable(Routes.Main.route) {
            MainScreen(
                onNavigateToProduct = {
                    navController.navigate(route = Routes.Product.getProductById(it))
                },
                onNavigateToNotifications = {
                    navController.navigate(route = Routes.Notifications.route)
                },
                onNavigateToConfirmation = {
                    navController.navigate(route = Routes.Confirmation.route)
                },
                onChangeFavourite = {

                }
            )
        }

        composable(Routes.Product.route) {
            val viewModel = hiltViewModel<ProductViewModel>()
            val id = it.arguments?.getString(Routes.PRODUCT_ID)?.toLong() ?: -1L
            ProductScreen(
                viewModel = viewModel,
                id = id,
                onBackClick = {
                    navController.popBackStack()
                },
                onBuyNowClick = {
                    navController.navigate(Routes.Cart.route)
                }
            )
        }

        composable(Routes.Cart.route) {
            val viewModel = hiltViewModel<CartViewModel>()
            CartScreen(
                viewModel = viewModel,
                onNavigateToConfirm = { /*TODO*/ },
                onNavigateToProduct = { }
            )
        }

        composable(Routes.Confirmation.route) {
            val viewModel = hiltViewModel<ConfirmViewModel>()
            ConfirmScreen(
                viewModel = viewModel,
                onNavigateToSuccess = {
                    navController.navigate(Routes.Success.route)
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(Routes.Success.route) {
            val viewModel = hiltViewModel<SuccessViewModel>()
            SuccessScreen(
                viewModel = viewModel,
                onConfirmationClick = {
                    navController.navigate(Routes.Main.route)
                }
            )
        }

        composable(Routes.Notifications.route) {
            val viewModel = hiltViewModel<NotificationsViewModel>()
            NotificationsScreen(
                viewModel = viewModel,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}












