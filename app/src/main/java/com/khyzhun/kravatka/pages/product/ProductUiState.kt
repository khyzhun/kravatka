package com.khyzhun.kravatka.pages.product

import com.khyzhun.kravatka.core.base.common.state.UiState
import com.khyzhun.kravatka.domain.models.ProductDetails

data class ProductUiState(
    val product: ProductDetails,
    val isAddedToCart: Boolean
) : UiState