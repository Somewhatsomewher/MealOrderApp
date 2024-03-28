package com.rubelz.data.utils

import com.rubelz.data.remote.api.MealServiceRemote
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val mealServiceRemote: MealServiceRemote by lazy {
        Retrofit.Builder()
            .baseUrl(Consts.BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MealServiceRemote::class.java)
    }
}