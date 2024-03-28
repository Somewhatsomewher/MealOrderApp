package com.rubelz.presentation.viewmodels.MenuViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rubelz.domain.entities.Category
import com.rubelz.domain.entities.Product
import com.rubelz.domain.usecases.FilterProductsByCategoryUseCase
import com.rubelz.domain.usecases.GetCategoriesUseCase
import com.rubelz.domain.usecases.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val filterProduct: FilterProductsByCategoryUseCase,
    private val getCategoryUseCase: GetCategoriesUseCase,
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {

    val categories = MutableLiveData<List<Category>>()
    val products = MutableLiveData<List<Product>>()

    fun getCategories() {
        viewModelScope.launch {
            val mCategories = getCategoryUseCase.execute()
                categories.postValue(mCategories)
        }
    }

    fun getProducts() {
        viewModelScope.launch {
            try {
                val mProducts = getProductsUseCase.execute()

                    products.postValue(mProducts)
            } catch (e: IOException) {
                Log.d("MyTag", e.message.toString() + " " + getProductsUseCase.execute().toString())
            }
        }
    }

    fun getProducts(category: String) {
        viewModelScope.launch {
            try {
                products.postValue(filterProduct.execute(category))
            } catch (e: IOException) {
                Log.d("MyTag", e.message.toString() + " " + getProductsUseCase.execute().toString())
            }
        }
    }
}