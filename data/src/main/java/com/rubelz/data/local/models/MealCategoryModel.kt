package com.rubelz.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meal_category")
data class MealCategoryModel(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "idCategory")
    val idCategory: String,

    @ColumnInfo(name = "strCategory")
    val strCategory: String
)
