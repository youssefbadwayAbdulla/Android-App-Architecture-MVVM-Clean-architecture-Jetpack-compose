package com.example.android_app_architecture.store.presentation.products_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.android_app_architecture.store.presentation.products_screen.components.ProductCard
import com.example.android_app_architecture.store.presentation.uitl.components.LoadingDialog
import com.example.android_app_architecture.store.presentation.uitl.components.MyTopAppBar

@Composable
internal fun ProductsScreen(
    viewModel: ProductViewModel = hiltViewModel()
) {
    val state by viewModel.productState.collectAsStateWithLifecycle()
    ProductContent(state = state)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductContent(
    state: ProductViewState
) {
    LoadingDialog(isLoading = state.isLoading)
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { MyTopAppBar(title = "Products") }
    ) {
        LazyVerticalStaggeredGrid(
            modifier = Modifier.padding(top = it.calculateTopPadding()),
            columns = StaggeredGridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(state.products) { products ->
                ProductCard(product = products)
            }
        }
    }
}