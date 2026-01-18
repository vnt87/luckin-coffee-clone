package com.luckin.clone.data.repository

import com.luckin.clone.data.model.Banner
import com.luckin.clone.data.model.Category
import com.luckin.clone.data.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    val products: Flow<List<Product>>
    val banners: Flow<List<Banner>>
    val categories: Flow<List<Category>>
    
    suspend fun getProduct(id: String): Product?
    suspend fun seedData()
}
