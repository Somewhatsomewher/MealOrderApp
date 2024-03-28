package com.rubelz.data.remote.models

import com.google.gson.annotations.SerializedName
import com.rubelz.data.utils.mappers.toDomain
import com.rubelz.domain.entities.Product

data class ProductDto(
    @SerializedName("idMeal") val idMeal: String,
    @SerializedName("strMeal") val strMeal: String,
    @SerializedName("strCategory") val strCategory: String,
    @SerializedName("strMealThumb") val strMealThumb: String,
    @SerializedName("strIngredient1") val strIngredient1: String? = "",
    @SerializedName("strIngredient2") val strIngredient2: String? = "",
    @SerializedName("strIngredient3") val strIngredient3: String? = "",
    @SerializedName("strIngredient4") val strIngredient4: String? = "",
    @SerializedName("strIngredient5") val strIngredient5: String? = "",
    @SerializedName("strIngredient6") val strIngredient6: String? = "",
    @SerializedName("strIngredient7") val strIngredient7: String? = "",
    @SerializedName("strIngredient8") val strIngredient8: String? = "",
    @SerializedName("strIngredient9") val strIngredient9: String? = "",
    @SerializedName("strIngredient10") val strIngredient10: String? = "",
    @SerializedName("strIngredient11") val strIngredient11: String? = "",
    @SerializedName("strIngredient12") val strIngredient12: String? = "",
    @SerializedName("strIngredient13") val strIngredient13: String? = "",
    @SerializedName("strIngredient14") val strIngredient14: String? = "",
    @SerializedName("strIngredient15") val strIngredient15: String? = "",
    @SerializedName("strIngredient16") val strIngredient16: String? = "",
    @SerializedName("strIngredient17") val strIngredient17: String? = "",
    @SerializedName("strIngredient18") val strIngredient18: String? = "",
    @SerializedName("strIngredient19") val strIngredient19: String? = "",
    @SerializedName("strIngredient20") val strIngredient20: String? = ""
) {
    fun getIngredients(): List<String?> {
        return listOf(
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
}

data class ProductsDto(
    @SerializedName("meals") val products: List<ProductDto>
) {
    fun toDomain(): List<Product> {
        val mProducts = arrayListOf<Product>()
        for (i in products) {
            mProducts.add(i.toDomain())
        }
        return mProducts
    }
}