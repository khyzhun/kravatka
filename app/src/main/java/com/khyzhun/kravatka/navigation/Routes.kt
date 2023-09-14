package com.khyzhun.kravatka.navigation

sealed class Routes(val route: String) {
    object Splash : Routes("splash")
    object Welcome : Routes("welcome")
    object SignIn : Routes("sign_in")
    object SignUp : Routes("sign_up")
    object Main : Routes("main")
}