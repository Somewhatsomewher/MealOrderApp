package com.rubelz.domain.usecases

import com.rubelz.domain.entities.Category
import com.rubelz.domain.repository.MealRepository

class GetCategoriesUseCase (private val repository: MealRepository) {
    suspend fun execute(): List<Category> {
        return repository.getMealCategories()
    }
}