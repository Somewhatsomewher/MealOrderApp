package com.rubelz.domain.repository
import com.rubelz.domain.entities.Category
import com.rubelz.domain.entities.Product

interface MealRepository {
    suspend fun getMealCategories(): List<Category>
    suspend fun getProducts(): List<Product>
    suspend fun filterProductsByCategory(category: String): List<Product>
}