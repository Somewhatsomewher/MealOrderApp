package com.rubelz.mealorderapp.di

import com.rubelz.presentation.navigation.AppNavigation
import com.rubelz.presentation.navigation.AppNavigationImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
abstract class NavigationModule {
        @Binds
    abstract fun bindNavigator(impl: AppNavigationImpl): AppNavigation

}