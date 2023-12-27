package com.khyzhun.kravatka.pages.notifications

import com.khyzhun.kravatka.core.base.common.state.UiState
import com.khyzhun.kravatka.domain.models.Notification

data class NotificationsUiState(
    val notifications: List<Notification> = emptyList()
): UiState