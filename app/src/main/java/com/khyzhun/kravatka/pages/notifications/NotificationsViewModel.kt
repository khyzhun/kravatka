package com.khyzhun.kravatka.pages.notifications

import com.khyzhun.kravatka.core.base.BaseViewModel
import com.khyzhun.kravatka.core.base.common.events.Callback
import com.khyzhun.kravatka.core.base.common.events.Dialog
import com.khyzhun.kravatka.core.base.common.events.Progress
import com.khyzhun.kravatka.core.base.common.events.UiEvent
import com.khyzhun.kravatka.utils.MockUtils

class NotificationsViewModel(
    //val interactor: NotificationsInteractor TBD.
) : BaseViewModel<NotificationsUiState, Progress, Dialog, Callback>() {

    override fun handleUiEvent(uiEvent: UiEvent) {
        when (uiEvent) {
            is NotificationsUiEvent.LoadScreenData -> {
                loadNotifications()
            }
            is NotificationsUiEvent.OnMarkAsReadClick -> {
                markAsRead(uiEvent.id)
            }
            is NotificationsUiEvent.OnMarkAllAsReadClick -> {
                markAllAsRead()
            }
        }
    }

    private fun loadNotifications() {
        val notifications = MockUtils.loadMockNotifications()
        updateState { currentState ->
            currentState.value = NotificationsUiState(notifications = notifications)
        }
    }

    private fun markAsRead(id: Long) {
        updateState { mutableState ->
            mutableState.value?.let { state ->
                val notifications = state.notifications.toMutableList()
                notifications.mapIndexed { index, notification ->
                    if (notification.id == id) {
                        notifications[index] = notification.copy(isNew = false)
                    }
                }
                mutableState.value = state.copy(notifications = notifications)
            }
        }
    }

    private fun markAllAsRead() {
        updateState { mutableState ->
            mutableState.value?.let { state ->
                val notifications = state.notifications.toMutableList()
                notifications.mapIndexed { index, notification ->
                    notifications[index] = notification.copy(isNew = false)
                }
                mutableState.value = state.copy(notifications = notifications)
            }
        }
    }


}

