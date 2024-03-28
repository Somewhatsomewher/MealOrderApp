package com.rubelz.data.local

import com.rubelz.data.local.models.MealCategoryModel
import com.rubelz.data.local.models.ProductModel
import com.rubelz.data.remote.models.CategoryDto
import com.rubelz.data.remote.models.ProductDto

fun MealCategoryModel.toCategoryDto(): CategoryDto {
    return CategoryDto(
        idCategory = this.idCategory,
        strCategory = this.strCategory
    )
}

fun ProductModel.toProductDto(): ProductDto {
    return ProductDto(
        idMeal,
        strMeal,
        strCategory,
        strMealThumb,
        strIngredient1,
        strIngredient2,
        strIngredient3,
        strIngredient4,
        strIngredient5,
        strIngredient6,
        strIngredient7,
        strIngredient8,
        strIngredient9,
        strIngredient10,
        strIngredient11,
        strIngredient12,
        strIngredient13,
        strIngredient14,
        strIngredient15,
        strIngredient16,
        strIngredient17,
        strIngredient18,
        strIngredient19,
        strIngredient20
    )
}

// Extension functions to map Retrofit models to Room models
fun CategoryDto.toMealCategoryModel(): MealCategoryModel {
    return MealCategoryModel(
        idCategory = this.idCategory,
        strCategory = this.strCategory
    )
}

fun ProductDto.toProductModel(): ProductModel {
    return ProductModel(
        idMeal,
        strMeal,
        strCategory,
        strMealThumb,
        strIngredient1,
        strIngredient2,
        strIngredient3,
        strIngredient4,
        strIngredient5,
        strIngredient6,
        strIngredient7,
        strIngredient8,
        strIngredient9,
        strIngredient10,
        strIngredient11,
        strIngredient12,
        strIngredient13,
        strIngredient14,
        strIngredient15,
        strIngredient16,
        strIngredient17,
        strIngredient18,
        strIngredient19,
        strIngredient20
    )
}