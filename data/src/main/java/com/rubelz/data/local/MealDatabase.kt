package com.rubelz.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rubelz.data.local.models.MealCategoryModel
import com.rubelz.data.local.models.ProductModel

@Database(entities = [MealCategoryModel::class, ProductModel::class], version = 1)
abstract class MealDatabase: RoomDatabase(){
    abstract fun mealService(): MealServiceDao
}