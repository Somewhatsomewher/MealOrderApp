package com.rubelz.mealorderapp.di

import android.content.Context
import androidx.room.Room
import com.rubelz.data.local.MealDatabase
import com.rubelz.data.local.MealServiceDao
import com.rubelz.data.remote.api.MealServiceRemote
import com.rubelz.data.repository.MealRepositoryImpl
import com.rubelz.data.utils.Consts
import com.rubelz.domain.repository.MealRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideMealDatabase(
        @ApplicationContext appContext: Context,
    ) = Room.databaseBuilder(appContext, MealDatabase::class.java, "meal_db").build()

    @Singleton
    @Provides
    fun provideMealService(db: MealDatabase) = db.mealService()

    @Singleton
    @Provides
    fun provideMealRepository(mealServiceRemote: MealServiceRemote, mealServiceDao: MealServiceDao ): MealRepository {
        return MealRepositoryImpl(mealServiceRemote, mealServiceDao)
    }

    @Singleton
    @Provides
    fun provideRetrofitBuilder() = Retrofit.Builder()
        .baseUrl(Consts.BASE_API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    @Singleton
    @Provides
    fun provideRetrofitService(retrofit: Retrofit) = retrofit.create(MealServiceRemote::class.java)


}
