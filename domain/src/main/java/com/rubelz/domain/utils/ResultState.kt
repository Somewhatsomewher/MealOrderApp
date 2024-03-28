package com.rubelz.domain.utils

sealed class ResultState<out R> {
    data class Success<out T>(val data: T) : ResultState<T>()
    data class Loading<out T>(val loading: Boolean) : ResultState<T>()
    data class Error<out T>(val message: String,val code:Int) : ResultState<T>()
}