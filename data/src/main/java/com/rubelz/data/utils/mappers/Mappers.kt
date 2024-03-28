package com.rubelz.data.utils.mappers

import com.rubelz.data.remote.models.CategoryDto
import com.rubelz.data.remote.models.ProductDto
import com.rubelz.data.remote.models.ProductsDto
import com.rubelz.domain.entities.Category
import com.rubelz.domain.entities.Product

fun CategoryDto.toDomain(): Category {
    return Category(idCategory, strCategory)//, strCategoryThumb, strCategoryDescription)
}

fun Category.toDto(): CategoryDto {
    return CategoryDto(id, name)//, thumbnailUrl, description)
}

fun ProductDto.toDomain(): Product {
    return Product(
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
    )//, strCategoryThumb, strCategoryDescription)
}

fun Product.toDto(): ProductDto {
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
    )//, thumbnailUrl, description)
}