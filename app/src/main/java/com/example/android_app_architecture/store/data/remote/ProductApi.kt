package com.example.android_app_architecture.store.data.remote

import com.example.android_app_architecture.store.domain.model.ProductList
import retrofit2.http.GET

interface ProductApi {
    @GET("products")
    suspend fun getProducts(): ProductList
}