package com.khyzhun.kravatka.pages.feed

import com.khyzhun.kravatka.core.base.common.events.UiEvent
import com.khyzhun.kravatka.core.base.common.state.UiState
import com.khyzhun.kravatka.domain.models.Product

data class FeedUiState(
    val products: List<Product> = emptyList(),
    val searchCategories: List<String> = emptyList(),
) : UiState