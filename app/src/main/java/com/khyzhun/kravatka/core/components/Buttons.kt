package com.khyzhun.kravatka.core.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    isEnabled: Boolean = true,
    roundDp: Dp = 8.dp,
    onClick: () -> Unit
) {
    Box(modifier = modifier) {
        Button(
            shape = RoundedCornerShape(roundDp),
            onClick = onClick,
            enabled = isEnabled,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    text: String,
    isEnabled: Boolean = true,
    onClick: () -> Unit
) {
    Box(modifier = modifier) {
        OutlinedButton(
            border = BorderStroke(2.dp, Color.Blue),
            shape = RoundedCornerShape(8.dp),
            onClick = onClick,
            enabled = isEnabled,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
fun FloatingButton(
    modifier: Modifier = Modifier,
    icon: @Composable () -> Unit,
    elevation: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    onClick: () -> Unit
) {
    Box(modifier = modifier) {
        FloatingActionButton(
            onClick = onClick,
            elevation = elevation
        ) {
            icon.invoke()
        }
    }
}

@Composable
fun RoundedButton(
    modifier: Modifier = Modifier,
    icon: @Composable () -> Unit,
    isEnabled: Boolean = true,
    roundDp: Dp = 16.dp,
    elevation: ButtonElevation = ButtonDefaults.buttonElevation(),
    onClick: () -> Unit
) {
    Box(modifier = modifier) {
        Button(
            shape = RoundedCornerShape(roundDp),
            enabled = isEnabled,
            elevation = elevation,
            contentPadding = PaddingValues(4.dp),
            onClick = onClick,
            modifier = modifier.size(48.dp)
        ) {
            icon.invoke()
        }
    }
}

@Composable
fun SmallButton(
    modifier: Modifier = Modifier,
    text: String,
    isEnabled: Boolean,
    onClick: () -> Unit
) {
    Box(modifier = modifier) {
        Button(
            shape = RoundedCornerShape(16.dp),
            enabled = isEnabled,
            contentPadding = PaddingValues(2.dp),
            onClick = onClick,
            modifier = modifier.height(28.dp)
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.titleSmall
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ButtonsPreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        PrimaryButton(
            modifier = Modifier,
            text = "Primary button enabled",
            isEnabled = true,
            onClick = {}
        )
        PrimaryButton(
            modifier = Modifier,
            text = "Primary button disabled",
            isEnabled = false,
            onClick = {}
        )

        SecondaryButton(
            modifier = Modifier,
            text = "Secondary button enabled",
            isEnabled = true,
            onClick = {}
        )
        SecondaryButton(
            modifier = Modifier,
            text = "Secondary button disabled",
            isEnabled = false,
            onClick = {}
        )

        FloatingButton(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "add button"
                )
            },
            modifier = Modifier,
            onClick = {}
        )

        RoundedButton(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = "notifications"
                )
            },
            isEnabled = true,
            onClick = {}
        )
        
        SmallButton(
            text = "Small button enabled",
            isEnabled = true,
            onClick = {}
        )

        SmallButton(
            text = "Small button disabled",
            isEnabled = false,
            onClick = {}
        )

    }
}