package com.khyzhun.kravatka.pages.product

import com.khyzhun.kravatka.core.base.common.events.UiEvent

sealed class ProductUiEvent : UiEvent {
    data class LoadData(val id: Long) : ProductUiEvent()
    data object AddToCartOnClick : ProductUiEvent()
    data object UpdateFavouriteOnClick : ProductUiEvent()
}