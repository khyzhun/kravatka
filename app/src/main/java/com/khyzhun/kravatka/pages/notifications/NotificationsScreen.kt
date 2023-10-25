package com.khyzhun.kravatka.pages.notifications

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow.Companion.Ellipsis
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khyzhun.kravatka.R
import com.khyzhun.kravatka.core.components.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationsScreen() {
    Scaffold(topBar = {
        TopBar(
            title = stringResource(id = R.string.notifications),
            onBackClick = { }
        )
    }
    ) {
        NotificationsScreenContent(modifier = Modifier.padding(it))
    }
}

@Composable
fun NotificationsScreenContent(modifier: Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        NotificationsItem(
            title = "You got discount for this week",
            message = "We have a good news. You got discount for this week for -10%"
        )
        Divider(
            thickness = 1.dp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        NotificationsItem(title = "title", message = "message message message message", isNew = true)
    }
}

@Composable
fun NotificationsItem(
    modifier: Modifier = Modifier,
    title: String,
    message: String,
    isNew: Boolean = false
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(
                color = if (isNew) Color(0xFFF3F3F3) else Color(0xFFFFFFFF)
            )
            .padding(8.dp)


//            .border(1.dp, Color.Black)

    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.End
        ) {
            if(isNew) {
                Icon(
                    Icons.Filled.Notifications,
                    contentDescription = "Check mark"
                )
            }

        }

        Row {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = modifier
                    .clip(CircleShape),
            )
            Column(modifier = modifier.padding(start = 8.dp)) {
                Text(
                    text = title,
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = Ellipsis
                )
                Text(
                    text = message,
                    fontSize = 12.sp,
                    color = Color(0xFFB0B0B0),
                    maxLines = 2,
                    overflow = Ellipsis,
                    modifier = modifier.padding(top = 8.dp)
                )

            }
        }

    }
}
