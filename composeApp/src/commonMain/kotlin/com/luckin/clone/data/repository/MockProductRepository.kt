package com.luckin.clone.data.repository

import com.luckin.clone.data.MockData
import com.luckin.clone.data.model.Banner
import com.luckin.clone.data.model.Category
import com.luckin.clone.data.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class MockProductRepository : ProductRepository {
    override val products: Flow<List<Product>> = flowOf(MockData.featuredProducts)
    override val banners: Flow<List<Banner>> = flowOf(MockData.banners)
    override val categories: Flow<List<Category>> = flowOf(MockData.categories)

    override suspend fun getProduct(id: String): Product? {
        return MockData.featuredProducts.find { it.id == id }
    }

    override suspend fun seedData() {
        // No-op for mock repository
    }
}
