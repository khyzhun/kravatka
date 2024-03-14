package com.khyzhun.kravatka.domain.models

data class Product(
    val id: Long = -1,
    val title: String = "",
    val price: Double = 0.0,
    val imageUrl: String = "",
    val isFavourite: Boolean = false,
)