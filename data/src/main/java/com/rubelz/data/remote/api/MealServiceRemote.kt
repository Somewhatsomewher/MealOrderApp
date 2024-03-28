package com.rubelz.data.remote.api

import com.rubelz.data.remote.models.CategoriesDto
import com.rubelz.data.remote.models.ProductsDto
import retrofit2.http.GET


interface MealServiceRemote {

    @GET("1/categories.php")
    suspend fun getMealCategories():CategoriesDto

    @GET("1/search.php?s")
    suspend fun getProducts(): ProductsDto
}