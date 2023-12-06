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

    /**
     * Main screen: first page
     */
    object Feed : Routes("feed")
    object Search : Routes("feed/search")
    object Product : Routes("feed/{$PRODUCT_ID}") {
        fun getProductById(id: String): String {
            return "feed/$id"
        }
    }

    /**
     * Main screen: second page
     */
    object Favourites : Routes("favourites")

    /**
     * Main screen: third page
     */
    object Cart : Routes("cart")
    object Promo: Routes("card/promo")

    /**
     * Main screen: fourth page
     */
    object Profile : Routes("profile")
    object Settings : Routes("profile/settings")
    object Personal: Routes("profile/personal")
    object Address: Routes("profile/address")
    object Billing: Routes("profile/billing")

    /**
     * Nested Graphs
     */
    object FeedGraph : Routes("feed_graph")
    object FavouritesGraph : Routes("favourites_graph")
    object CartGraph : Routes("cart_graph")
    object ProfileGraph : Routes("profile_graph")

    /**
     * Independent single screens
     */
    object Notifications : Routes("notifications")
    object Confirmation : Routes("confirmation")
    object Success : Routes("success")


    companion object {
        const val PRODUCT_ID = "product_id"
    }

}

























