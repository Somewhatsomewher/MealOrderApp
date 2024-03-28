package com.rubelz.data.remote.models

import com.google.gson.annotations.SerializedName
import com.rubelz.data.utils.mappers.toDomain
import com.rubelz.domain.entities.Category

data class CategoryDto(
    @SerializedName("idCategory") val idCategory: String,
    @SerializedName("strCategory") val strCategory: String,
)

data class CategoriesDto(
    @SerializedName("categories") val categories: List<CategoryDto>
) {
    fun toDomain(): List<Category> {
        val mCategories = arrayListOf<Category>()
        for(i in categories){
            mCategories.add(i.toDomain())
        }
        return mCategories
    }

}