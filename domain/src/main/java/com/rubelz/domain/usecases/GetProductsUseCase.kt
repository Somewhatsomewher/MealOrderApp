package com.rubelz.domain.usecases

import com.rubelz.domain.entities.Product
import com.rubelz.domain.repository.MealRepository

class GetProductsUseCase (private val repository: MealRepository) {
    suspend fun execute(): List<Product> {
        return repository.getProducts()
    }
}