package com.khyzhun.kravatka.pages.notifications

import com.khyzhun.kravatka.core.base.common.events.UiEvent

sealed class NotificationsUiEvent : UiEvent {

    data object LoadScreenData : NotificationsUiEvent()

    data class OnMarkAsReadClick(val id: Long): NotificationsUiEvent()

    data object OnMarkAllAsReadClick : NotificationsUiEvent()
}