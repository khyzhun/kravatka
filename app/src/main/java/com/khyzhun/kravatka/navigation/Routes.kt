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
     * Main scree Nested graph
     */

    object Feed : Routes("feed")
    object Favourites : Routes("favourites")
    object Cart : Routes("cart")
    object Profile : Routes("profile")

    /**
     * Profile graph
     */


}