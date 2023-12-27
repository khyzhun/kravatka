package com.khyzhun.kravatka.pages.notifications

import com.khyzhun.kravatka.core.base.common.events.UiEvent

sealed class NotificationsUiEvent : UiEvent {

    data class OnMarkAsReadClick(val id: Long): NotificationsUiEvent()

    object OnMarkAllAsReadClick : NotificationsUiEvent()

    object LoadScreenData : NotificationsUiEvent()
}