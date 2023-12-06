package com.khyzhun.kravatka.pages

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.khyzhun.kravatka.navigation.RootAppNavigation
import com.khyzhun.kravatka.navigation.Routes
import com.khyzhun.kravatka.pages.sign_in.SignInScreen
import com.khyzhun.kravatka.pages.sign_in.SignInViewModel
import com.khyzhun.kravatka.pages.sing_up.SignUpScreen
import com.khyzhun.kravatka.pages.sing_up.SignUpViewModel
import com.khyzhun.kravatka.pages.splash.SplashScreen
import com.khyzhun.kravatka.pages.splash.SplashViewModel
import com.khyzhun.kravatka.pages.welcome.WelcomeScreen
import com.khyzhun.kravatka.pages.welcome.WelcomeViewModel
import com.khyzhun.kravatka.ui.theme.KravatkaTheme
import com.khyzhun.kravatka.utils.appToastShow
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KravatkaTheme {
                RootAppNavigation()
            }
        }
    }

}















