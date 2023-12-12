package com.khyzhun.kravatka.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.khyzhun.kravatka.pages.address.DeliveryAddressScreen
import com.khyzhun.kravatka.pages.address.DeliveryAddressViewModel
import com.khyzhun.kravatka.pages.billing.BillingDetailsScreen
import com.khyzhun.kravatka.pages.billing.BillingDetailsViewModel
import com.khyzhun.kravatka.pages.cart.CartScreen
import com.khyzhun.kravatka.pages.cart.CartViewModel
import com.khyzhun.kravatka.pages.favourites.FavouritesScreen
import com.khyzhun.kravatka.pages.favourites.FavouritesViewModel
import com.khyzhun.kravatka.pages.feed.FeedScreen
import com.khyzhun.kravatka.pages.feed.FeedViewModel
import com.khyzhun.kravatka.pages.personal.PersonalDetailsScreen
import com.khyzhun.kravatka.pages.personal.PersonalDetailsViewModel
import com.khyzhun.kravatka.pages.profile.ProfileScreen
import com.khyzhun.kravatka.pages.profile.ProfileViewModel
import com.khyzhun.kravatka.pages.search.SearchScreen
import com.khyzhun.kravatka.pages.search.SearchViewModel
import com.khyzhun.kravatka.pages.settings.SettingsScreen
import com.khyzhun.kravatka.pages.settings.SettingsViewModel

@Composable
fun NestedAppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = Routes.FeedGraph.route,
    onNavigateToProduct: (Long) -> Unit,
    onNavigateToNotifications: () -> Unit,
    onNavigateToConfirmation: () -> Unit,
    onChangeFavourite: (Long) -> Unit
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {

        feedGraph(
            navController = navController,
            onNavigateToProduct = onNavigateToProduct,
            onNavigateToNotifications = onNavigateToNotifications
        )

        favouritesGraph(
            navController = navController,
            onNavigateToProduct = onNavigateToProduct,
            onChangeFavourite = onChangeFavourite
        )

        cartGraph(
            navController = navController,
            onNavigateToProduct = onNavigateToProduct,
            onNavigateToConfirm = onNavigateToConfirmation
        )

        profileGraph(
            navController = navController,
        )


    }
}

fun NavGraphBuilder.feedGraph(
    navController: NavHostController,
    onNavigateToNotifications: () -> Unit,
    onNavigateToProduct: (Long) -> Unit
) {
    navigation(startDestination = Routes.Feed.route, route = Routes.FeedGraph.route) {

        composable(Routes.Feed.route) {
            val viewModel = hiltViewModel<FeedViewModel>()
            FeedScreen(
                viewModel = viewModel,
                onNavigateToNotifications = onNavigateToNotifications,
                onNavigateToProduct = onNavigateToProduct,
                onNavigateToSearch = { navController.navigate(Routes.Search.route) }
            )
        }

        composable(Routes.Search.route) {
            val viewModel = hiltViewModel<SearchViewModel>()
            SearchScreen(
                viewModel = viewModel,
                onNavigateToProduct = onNavigateToProduct,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}

fun NavGraphBuilder.favouritesGraph(
    navController: NavHostController,
    onNavigateToProduct: (Long) -> Unit,
    onChangeFavourite: (Long) -> Unit
) {
    navigation(startDestination = Routes.Favourites.route, route = Routes.FavouritesGraph.route) {

        composable(Routes.Favourites.route) {
            val viewModel = hiltViewModel<FavouritesViewModel>()
            FavouritesScreen(
                viewModel = viewModel,
                onNavigateToProduct = onNavigateToProduct
            )
        }
    }
}

fun NavGraphBuilder.cartGraph(
    navController: NavHostController,
    onNavigateToProduct: (Long) -> Unit,
    onNavigateToConfirm: () -> Unit
) {
    navigation(startDestination = Routes.Cart.route, route = Routes.CartGraph.route) {

        composable(Routes.Cart.route) {
            val viewModel = hiltViewModel<CartViewModel>()
            CartScreen(
                viewModel = viewModel,
                onNavigateToProduct = onNavigateToProduct,
                onNavigateToConfirm = onNavigateToConfirm,
            )
        }
    }
}

fun NavGraphBuilder.profileGraph(
    navController: NavHostController
) {
    navigation(startDestination = Routes.Profile.route, route = Routes.ProfileGraph.route) {

        composable(Routes.Profile.route) {
            val viewModel = hiltViewModel<ProfileViewModel>()
            ProfileScreen(
                viewModel = viewModel,
                onNavigateToSettings = {
                    navController.navigate(Routes.Settings.route)
                },
                onNavigateToPersonalDetails = {
                    navController.navigate(Routes.Personal.route)
                },
                onNavigateToDeliveryAddress = {
                    navController.navigate(Routes.Address.route)
                },
                onNavigateToBillingDetails = {
                    navController.navigate(Routes.Billing.route)
                }
            )
        }

        composable(Routes.Settings.route) {
            val viewModel = hiltViewModel<SettingsViewModel>()
            SettingsScreen(
                viewModel = viewModel,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(Routes.Personal.route) {
            val viewModel = hiltViewModel<PersonalDetailsViewModel>()
            PersonalDetailsScreen(
                viewModel = viewModel,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(Routes.Address.route) {
            val viewModel = hiltViewModel<DeliveryAddressViewModel>()
            DeliveryAddressScreen(
                viewModel = viewModel,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(Routes.Billing.route) {
            val viewModel = hiltViewModel<BillingDetailsViewModel>()
            BillingDetailsScreen(
                viewModel = viewModel,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}