package com.example.android_app_architecture.store.presentation.products_screen

import com.example.android_app_architecture.store.domain.model.ProductList

data class ProductViewState(
    val isLoading: Boolean = false,
    val products: ProductList = emptyList(),
    val error: String? = null

)
