package com.example.android_app_architecture.store.presentation.products_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_app_architecture.store.domain.repository.ProductRepository
import com.example.android_app_architecture.store.presentation.uitl.sentEvent
import com.example.android_app_architecture.uitl.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val productRepository: ProductRepository) :
    ViewModel() {
    private val _productState = MutableStateFlow(ProductViewState())
    val productState = _productState.asStateFlow()

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            _productState.update { it.copy(isLoading = true) }
            productRepository.getProducts()
                .onRight { products ->
                    _productState.update { it.copy(products = products) }
                }
                .onLeft { error ->
                    _productState.update { it.copy(error = error.error.message) }
                    sentEvent(Event.Toast(error.error.message))
                }
            _productState.update { it.copy(isLoading = false) }
        }
    }
}