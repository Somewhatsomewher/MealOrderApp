package com.rubelz.mealorderapp.di

import com.rubelz.domain.repository.MealRepository
import com.rubelz.domain.usecases.FilterProductsByCategoryUseCase
import com.rubelz.domain.usecases.GetCategoriesUseCase
import com.rubelz.domain.usecases.GetProductsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @Provides
    fun provideFilterProductsByCategory(mealRepository: MealRepository): FilterProductsByCategoryUseCase{
        return FilterProductsByCategoryUseCase(mealRepository)
    }

    @Provides
    fun provideGetMealCategories(mealRepository: MealRepository): GetCategoriesUseCase {
        return GetCategoriesUseCase(mealRepository)
    }

    @Provides
    fun provideGetProducts(mealRepository: MealRepository): GetProductsUseCase {
        return GetProductsUseCase(mealRepository)
    }
}