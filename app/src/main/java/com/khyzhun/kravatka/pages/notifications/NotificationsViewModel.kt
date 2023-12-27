package com.khyzhun.kravatka.pages.notifications

import com.khyzhun.kravatka.core.base.BaseViewModel
import com.khyzhun.kravatka.core.base.common.events.Callback
import com.khyzhun.kravatka.core.base.common.events.Dialog
import com.khyzhun.kravatka.core.base.common.events.Progress
import com.khyzhun.kravatka.core.base.common.events.UiEvent
import com.khyzhun.kravatka.utils.MockUtils

class NotificationsViewModel(
    //val interactor: NotificationsInteractor //TODO("finish up.")
) : BaseViewModel<NotificationsUiState, Progress, Dialog, Callback>() {

    override fun handleUiEvent(uiEvent: UiEvent) {
        when (uiEvent) {
            is NotificationsUiEvent.LoadScreenData -> {
                loadNotifications()
            }
            is NotificationsUiEvent.OnMarkAllAsReadClick -> {}
            is NotificationsUiEvent.OnMarkAsReadClick -> {}
        }
    }

    private fun loadNotifications() {
        val notifications = MockUtils.loadMockNotifications()
        updateState { currentState ->
            currentState.value = NotificationsUiState(notifications = notifications)
        }
    }

}

