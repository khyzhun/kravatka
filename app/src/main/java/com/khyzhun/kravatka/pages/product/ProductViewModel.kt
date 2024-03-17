package com.khyzhun.kravatka.pages.product

import android.telecom.Call
import androidx.lifecycle.ViewModel
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
class ProductViewModel @Inject constructor() : BaseViewModel<ProductUiState, Progress, Dialog, Callback>() {

    override fun handleUiEvent(uiEvent: UiEvent) {
        when (uiEvent) {
            is ProductUiEvent.LoadData -> {
                loadData(uiEvent.id)
            }
            is ProductUiEvent.AddToCartOnClick -> {
                // TBD
            }
            is ProductUiEvent.UpdateFavouriteOnClick -> {
                updateFavouriteState()
            }
        }
    }

    private fun updateFavouriteState() {
        updateState { mutableState ->
            mutableState.value?.let { state ->
                val product = state.product.copy(isFavourite = !state.product.isFavourite)
                mutableState.value = state.copy(product = product)
            }
        }
    }

    private fun loadData(id: Long) {
        launch {
            val product = async { MockUtils.loadMockProductDetails(id) }
            val isProductInCart = async { MockUtils.isProductInCart(id) }
            val response = product.await() to isProductInCart.await()

            updateState { currentState ->
                currentState.value = ProductUiState(
                    product = response.first,
                    isAddedToCart = response.second
                )
            }
        }
    }

}
