package com.khyzhun.kravatka.navigation

sealed class Routes(val route: String) {

    /**
     * Entry point
     */
    object Splash : Routes("splash")

    /**
     * Welcome screen for new users
     */
    object Welcome : Routes("welcome")

    /**
     * Authentication
     */
    object SignIn : Routes("sign_in")
    object SignUp : Routes("sign_up")

    /**
     * Main Screens: first page
     */
    object Main : Routes ("main")
    object Feed : Routes("main/feed")
    object Favourites : Routes("main/favourites")
    object Cart : Routes("main/cart")
    object Profile : Routes("main/profile")


}