package com.example.android_app_architecture.store.domain.repository

import arrow.core.Either
import com.example.android_app_architecture.store.domain.model.NetworkError
import com.example.android_app_architecture.store.domain.model.ProductList

interface ProductRepository {
    suspend fun getProducts():Either<NetworkError,ProductList>
}