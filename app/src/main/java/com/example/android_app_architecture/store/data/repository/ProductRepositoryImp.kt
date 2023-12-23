package com.example.android_app_architecture.store.data.repository

import android.os.Build
import androidx.annotation.RequiresExtension
import arrow.core.Either
import com.example.android_app_architecture.store.data.maper.toNetworkError
import com.example.android_app_architecture.store.data.remote.ProductApi
import com.example.android_app_architecture.store.domain.model.NetworkError
import com.example.android_app_architecture.store.domain.model.ProductList
import com.example.android_app_architecture.store.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImp @Inject constructor(private val productApi: ProductApi) :
    ProductRepository {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getProducts(): Either<NetworkError, ProductList> {
        return Either.catch {
            productApi.getProducts()
        }.mapLeft { it.toNetworkError() }
    }
}