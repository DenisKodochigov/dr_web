package com.example.dr_web.presentation.common.state

sealed class ScreenState<out T: Any> {
    data object Loading: ScreenState<Nothing>()
    data class Error(val errorMessage: String) : ScreenState<Nothing>()
    data class Success<T: Any>(val dataState: T) : ScreenState<T>()
}
