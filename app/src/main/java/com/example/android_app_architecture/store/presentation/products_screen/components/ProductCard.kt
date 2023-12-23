package com.example.android_app_architecture.store.presentation.products_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.android_app_architecture.R
import com.example.android_app_architecture.store.domain.model.Product
import com.example.android_app_architecture.store.domain.model.Rating

@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    product: Product
) {
    Card(
        modifier = modifier.padding(top = 10.dp, start = 4.dp, end = 4.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            ProductImage(product)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = product.title, style = MaterialTheme.typography.titleMedium)
        }
    }
}

@Composable
private fun ProductImage(product: Product) {
    AsyncImage(
        model = product.image,
        contentDescription = "Product Type Description",
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        contentScale = ContentScale.FillBounds
    )
}

@Preview
@Composable
fun ProductCardPreview() {
    ProductCard(
        product = Product(
            id = 1,
            title = "Product Test",
            price = 120.0,
            description = "description Test",
            category = "",
            image = R.drawable.ic_launcher_background.toString(),
            rating = Rating(rate = 90.0, count = 2)
        )
    )
}