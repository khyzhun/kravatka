package com.khyzhun.kravatka.navigation

sealed class Routes(val route: String) {

    /**
     * Entry point
     */
    data object Splash : Routes("splash")

    /**
     * Welcome screen for new users
     */
    data object Welcome : Routes("welcome")

    /**
     * Authentication
     */
    data object SignIn : Routes("sign_in")
    data object SignUp : Routes("sign_up")

    /**
     * Main Screens: first page
     */
    data object Main : Routes ("main")

    /**
     * Main screen: first page
     */
    data object Feed : Routes("feed")
    data object Search : Routes("feed/search")
    data object Product : Routes("feed/{$PRODUCT_ID}") {
        fun getProductById(id: Long): String {
            return "feed/$id"
        }
    }

    /**
     * Main screen: second page
     */
    data object Favourites : Routes("favourites")

    /**
     * Main screen: third page
     */
    data object Cart : Routes("cart")

    /**
     * Main screen: fourth page
     */
    data object Profile : Routes("profile")
    data object Settings : Routes("profile/settings")
    data object Personal: Routes("profile/personal")
    data object Address: Routes("profile/address")
    data object Billing: Routes("profile/billing")

    /**
     * Nested Graphs
     */
    data object FeedGraph : Routes("feed_graph")
    data object FavouritesGraph : Routes("favourites_graph")
    data object CartGraph : Routes("cart_graph")
    data object ProfileGraph : Routes("profile_graph")

    /**
     * Independent single screens
     */
    data object Notifications : Routes("notifications")
    data object Confirmation : Routes("confirmation")
    data object Success : Routes("success")


    companion object {
        const val PRODUCT_ID = "product_id"
    }

}

























