package com.khyzhun.kravatka.pages.feed

import com.khyzhun.kravatka.core.base.common.events.UiEvent

sealed class FeedUiEvent : UiEvent {

    data object LoadScreenData : FeedUiEvent()

    data class OnProductClick(val productId: Long) : FeedUiEvent()

    data class OnFavouriteClick(val productId: Long) : FeedUiEvent()

}