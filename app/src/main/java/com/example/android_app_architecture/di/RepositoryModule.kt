package com.example.android_app_architecture.di

import com.example.android_app_architecture.store.data.repository.ProductRepositoryImp
import com.example.android_app_architecture.store.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
   abstract fun bindProductRepository(productRepositoryImp: ProductRepositoryImp): ProductRepository
}