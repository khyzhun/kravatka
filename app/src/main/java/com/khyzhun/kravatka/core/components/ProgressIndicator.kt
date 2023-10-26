package com.khyzhun.kravatka.core.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ProgressIndicator(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(36.dp)
            .width(36.dp)
    ) {
        CircularProgressIndicator(color = Color.Black)
    }
}