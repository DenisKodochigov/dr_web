package com.example.dr_web.presentation.comon.state

sealed class DataLoader<out T: Any> {
    data object Loading: DataLoader<Nothing>()
    data class Error(val errorMessage: String) : DataLoader<Nothing>()
    data class Success<T: Any>(val dataState: T) : DataLoader<T>()
}