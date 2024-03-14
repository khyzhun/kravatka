package com.khyzhun.kravatka.pages.feed

import com.khyzhun.kravatka.core.base.BaseViewModel
import com.khyzhun.kravatka.core.base.common.events.Callback
import com.khyzhun.kravatka.core.base.common.events.Dialog
import com.khyzhun.kravatka.core.base.common.events.Progress
import com.khyzhun.kravatka.core.base.common.events.UiEvent
import com.khyzhun.kravatka.utils.MockUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor() : BaseViewModel<FeedUiState, Progress, Dialog, Callback>() {

    override fun handleUiEvent(uiEvent: UiEvent) {
        when (uiEvent) {
            is FeedUiEvent.LoadScreenData -> {
                loadScreenData()
            }
            is FeedUiEvent.OnFavouriteClick -> {
                onFavoriteClick(uiEvent.productId)
            }

            is FeedUiEvent.OnProductClick -> { /* no-op */ }
        }
    }

    private fun loadScreenData() {
        launch {
            val products = async { MockUtils.loadMockProducts() }
            val searchCategories = async { MockUtils.loadMockSearchCategories() }
            val response = products.await() to searchCategories.await()

            updateState { currentState ->
                currentState.value = FeedUiState(
                    products = response.first,
                    searchCategories = response.second
                )
            }
        }
    }

    private fun onFavoriteClick(productId: Long) {
        TODO("Not yet implemented")
    }


}