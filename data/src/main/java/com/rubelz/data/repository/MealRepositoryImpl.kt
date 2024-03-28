package com.rubelz.data.repository

import android.util.Log
import com.rubelz.data.local.MealServiceDao
import com.rubelz.data.local.models.MealCategoryModel
import com.rubelz.data.local.models.ProductModel
import com.rubelz.data.local.toMealCategoryModel
import com.rubelz.data.local.toProductDto
import com.rubelz.data.local.toProductModel
import com.rubelz.data.remote.api.MealServiceRemote
import com.rubelz.data.remote.models.CategoriesDto
import com.rubelz.data.remote.models.ProductDto
import com.rubelz.data.remote.models.ProductsDto
import com.rubelz.data.utils.mappers.toDomain
import com.rubelz.domain.entities.Category
import com.rubelz.domain.entities.Product
import com.rubelz.domain.repository.MealRepository
import dagger.Provides
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(
    private val mealServiceRemote: MealServiceRemote,
    private val mealServiceDao: MealServiceDao,
) : MealRepository {
// Можно еще разделить на другие репозитории для local и remote, но на тестовом задании это тратит время

    override suspend fun getMealCategories(): List<Category> {
        var response = CategoriesDto(emptyList())
        try {
            response = mealServiceRemote.getMealCategories()
            val mealsModel = arrayListOf<MealCategoryModel>()
            for (i in response.categories) {
                mealsModel.add(i.toMealCategoryModel())
            }
            mealServiceDao.saveMealCategories(mealsModel)

        } catch (e: IOException) {
            // TODO: retreive from database
        }

        return response.toDomain()
    }

    override suspend fun getProducts(): List<Product> {
        val response = mealServiceRemote.getProducts().toDomain()
        return response
    }

    override suspend fun filterProductsByCategory(category: String): List<Product> {
        return try {
            val productModels = if (category.isNullOrBlank()) mealServiceDao.getProducts()
            else mealServiceDao.filterProductsByCategory(category)

            val products = productModels.map { it.toProductDto().toDomain() }
            products
        } catch (e: IOException) {
            throw Exception(e.message)
        }

    }
}