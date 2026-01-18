package com.luckin.clone.data.repository

import com.luckin.clone.data.model.Banner
import com.luckin.clone.data.model.Category
import com.luckin.clone.data.model.Product
import dev.gitlive.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FirebaseProductRepository(
    private val firestore: FirebaseFirestore
) : ProductRepository {
    
    override val products: Flow<List<Product>> = firestore.collection("products")
        .snapshots
        .map { snapshot ->
            snapshot.documents.map { it.data() }
        }

    override val banners: Flow<List<Banner>> = firestore.collection("banners")
        .snapshots
        .map { snapshot ->
            snapshot.documents.map { it.data() }
        }

    override val categories: Flow<List<Category>> = firestore.collection("categories")
        .snapshots
        .map { snapshot ->
            snapshot.documents.map { it.data() }
        }

    override suspend fun getProduct(id: String): Product? {
        return try {
            firestore.collection("products").document(id).get().data()
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun seedData() {
        try {
            val batch = firestore.batch()

            com.luckin.clone.data.MockData.featuredProducts.forEach { product ->
                batch.set(firestore.collection("products").document(product.id), product)
            }

            com.luckin.clone.data.MockData.categories.forEach { category ->
                batch.set(firestore.collection("categories").document(category.id), category)
            }

            com.luckin.clone.data.MockData.banners.forEach { banner ->
                batch.set(firestore.collection("banners").document(banner.id), banner)
            }

            batch.commit()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
