package com.khyzhun.kravatka.pages.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.khyzhun.kravatka.R
import com.khyzhun.kravatka.navigation.NestedAppNavigation
import com.khyzhun.kravatka.navigation.Routes

@Composable
fun MainScreen(
    onNavigateToProduct: (Long) -> Unit,
    onNavigateToNotifications: () -> Unit,
    onNavigateToConfirmation: () -> Unit,
    onChangeFavourite: (Long) -> Unit
) {
    val navController = rememberNavController()
    val navGraphs: List<Routes> = listOf(
        Routes.FeedGraph,
        Routes.FavouritesGraph,
        Routes.CartGraph,
        Routes.ProfileGraph,
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                navGraphs.forEach { graph ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                imageVector = when (graph) {
                                    Routes.FeedGraph -> Icons.Filled.Home
                                    Routes.FavouritesGraph -> Icons.Filled.Favorite
                                    Routes.CartGraph -> Icons.Filled.ShoppingCart
                                    Routes.ProfileGraph -> Icons.Filled.Person
                                    else -> Icons.Filled.Person // just for example.
                                },
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(
                                stringResource(id = when (graph) {
                                    Routes.FeedGraph -> R.string.label_feed
                                    Routes.FavouritesGraph -> R.string.label_favourites
                                    Routes.CartGraph -> R.string.label_cart
                                    Routes.ProfileGraph -> R.string.label_profile
                                    else -> -1 // just for example.
                                })
                            )
                        },
                        selected = currentDestination?.hierarchy
                            ?.any { it.route == graph.route } == true,
                        onClick = {
                            navController.navigate(graph.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) {
        NestedAppNavigation(
            navController = navController,
            onNavigateToProduct = onNavigateToProduct,
            onNavigateToNotifications = onNavigateToNotifications,
            onNavigateToConfirmation = onNavigateToConfirmation,
            onChangeFavourite = onChangeFavourite,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = it.calculateBottomPadding())
        )
    }
}

























