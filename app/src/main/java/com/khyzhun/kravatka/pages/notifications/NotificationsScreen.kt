package com.khyzhun.kravatka.pages.notifications

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.khyzhun.kravatka.R
import com.khyzhun.kravatka.core.base.BaseContentLayout
import com.khyzhun.kravatka.core.components.TopBarApp
import com.khyzhun.kravatka.domain.models.Notification
import com.khyzhun.kravatka.utils.MockUtils

@Composable
fun NotificationsScreen(
    viewModel: NotificationsViewModel,
    onBackClick: () -> Unit,
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.handleUiEvent(
            NotificationsUiEvent.LoadScreenData
        )
    }
    BaseContentLayout(viewModel = viewModel) { uiState ->
        uiState?.let {
            NotificationsScreenContent(
                notifications = it.notifications,
                onBackClick = onBackClick,
                uiEvent = viewModel::handleUiEvent
            )
        }
    }
}

@Composable
private fun NotificationsScreenContent(
    notifications: List<Notification>,
    onBackClick: () -> Unit,
    uiEvent: (NotificationsUiEvent) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBarApp(
            title = stringResource(id = R.string.notifications),
            onBackClick = onBackClick,
            menuIcon = Icons.Default.Check,
            onMenuClick = {
                uiEvent(NotificationsUiEvent.OnMarkAllAsReadClick)
            }
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(
                top = 8.dp,
                bottom = 16.dp
            )
        ) {
            items(notifications) { notification ->
                NotificationCard(notification, uiEvent)
            }
        }
    }
}

@Composable
private fun NotificationCard(
    notification: Notification,
    uiEvent: (NotificationsUiEvent) -> Unit
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Box(contentAlignment = Alignment.TopEnd) {
            Row(
                modifier = Modifier
                    .animateContentSize()
                    .clickable {
                        uiEvent(NotificationsUiEvent.OnMarkAsReadClick(notification.id))
                    }
                    .padding(8.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(notification.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterVertically)
                )
                Column(
                    modifier = Modifier
                        .align(Alignment.Top)
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                ) {
                    Text(
                        text = notification.title,
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Black,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                    Text(
                        text = notification.description,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Black,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 3
                    )
                }
            }
            if (notification.isNew) {
                Canvas(
                    modifier = Modifier
                        .padding(8.dp)
                        .size(10.dp),
                    onDraw = {
                        drawCircle(color = Color.Gray)
                    }
                )
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun NotificationsScreenContentPreview() {
    NotificationsScreenContent(
        notifications = MockUtils.loadMockNotifications(),
        onBackClick = {},
        uiEvent = {},
    )
}