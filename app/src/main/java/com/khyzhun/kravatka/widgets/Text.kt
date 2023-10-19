package com.khyzhun.kravatka.widgets

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import java.util.Locale


@Composable
fun ClickableTextSecondary(text: String, onClick: () -> Unit) {
    ClickableText(
        style = TextStyle(color = Color(0xFFB8B8B8)),
        text = AnnotatedString(text.lowercase(Locale.ROOT)),
        onClick = { onClick() },
        modifier = Modifier.padding(0.dp, 10.dp)
    )
}
