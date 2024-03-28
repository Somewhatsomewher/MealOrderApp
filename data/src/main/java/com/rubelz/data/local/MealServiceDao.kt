package com.rubelz.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rubelz.data.local.models.MealCategoryModel
import com.rubelz.data.local.models.ProductModel
import com.rubelz.data.remote.models.ProductDto
import com.rubelz.domain.entities.Product

@Dao
interface MealServiceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMealCategories(categories: List<MealCategoryModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProducts(products: List<ProductModel>)

    @Query("SELECT * FROM meal_category")
    suspend fun getMealCategories(): List<MealCategoryModel>

    @Query("SELECT * FROM product")
    suspend fun getProducts(): List<ProductModel>

    @Query("SELECT * FROM product where strCategory=:category")
    suspend fun filterProductsByCategory(category: String): List<ProductModel>
}