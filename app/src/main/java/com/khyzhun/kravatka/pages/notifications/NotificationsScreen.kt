package com.khyzhun.kravatka.pages.notifications

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khyzhun.kravatka.R
import com.khyzhun.kravatka.core.components.TopBarApp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationsScreen(onBackClick: () -> Unit) {
    Scaffold(topBar = {
        TopBarApp(
            title = stringResource(id = R.string.notifications),
            onBackClick = onBackClick
        )
    }
    ) {
        NotificationsScreenContent(modifier = Modifier.padding(it))
    }
}

@Composable
fun NotificationsScreenContent(modifier: Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp)
    ) {
        itemsIndexed(listMessages) { index, item ->
            NotificationsItem(
                title = item.title,
                message = item.message,
                isNew = item.isNew
            )
            if (index < listMessages.lastIndex) ItemDivider()
        }
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
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.End
        ) {
            if (isNew) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_fiber_manual_record_24),
                    contentDescription = stringResource(id = R.string.new_notifications),
                    Modifier.size(16.dp)
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

@Composable
private fun ItemDivider() {
    Divider(
        thickness = 1.dp,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun NotificationsScreenPreview() {
    NotificationsScreen { TODO() }
}


data class MockMessage(
    val title: String,
    val message: String,
    val isNew: Boolean
)

val listMessages = listOf(
    MockMessage(
        "You got discount for this week",
        "We have a good news. You got discount for this week for -10%",
        isNew = false
    ),
    MockMessage(
        "You got discount for this week",
        "We have a good news. You got discount for this week for -10%",
        isNew = true
    ),

    MockMessage(
        "You got discount for this week",
        "We have a good news. You got discount for this week for -10%",
        isNew = false
    )
)