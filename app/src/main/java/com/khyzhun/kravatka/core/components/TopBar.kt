package com.khyzhun.kravatka.core.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import com.khyzhun.kravatka.R
import com.khyzhun.kravatka.ui.theme.Gray100

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String,
    onBackClick: () -> Unit = { },
    isEnableBackIcon:Boolean = true
) {
    TopAppBar(
        title = {
            Text(
                text = title, maxLines = 1, overflow = TextOverflow.Ellipsis
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(Gray100),
        navigationIcon = {
            if(isEnableBackIcon){
                IconButton(onClick = onBackClick) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        stringResource(id = R.string.back_button)
                    )
                }
            }
        }
    )
}