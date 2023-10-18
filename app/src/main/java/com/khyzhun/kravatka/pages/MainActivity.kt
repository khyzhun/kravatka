package com.khyzhun.kravatka.pages

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.khyzhun.kravatka.navigation.RootAppNavigation
import com.khyzhun.kravatka.ui.theme.KravatkaTheme
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