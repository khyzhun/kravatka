package com.khyzhun.kravatka.pages.notifications

import androidx.lifecycle.ViewModel

class NotificationsViewModel : ViewModel() {

    val listMessages = listOf(
        NotificationView(
            "You got discount for this week",
            "We have a good news. You got discount for this week for -10%",
            isNew = false
        ),
        NotificationView(
            "You got discount for this week",
            "We have a good news. You got discount for this week for -10%",
            isNew = true
        ),

        NotificationView(
            "You got discount for this week",
            "We have a good news. You got discount for this week for -10%",
            isNew = false
        )
    )

}

