package com.rubelz.domain.usecases

import com.rubelz.domain.entities.Product
import com.rubelz.domain.repository.MealRepository

class FilterProductsByCategoryUseCase(private val repository: MealRepository) {
    suspend fun execute(category: String):List<Product>? {
        return repository.filterProductsByCategory(category = category)

    }
}