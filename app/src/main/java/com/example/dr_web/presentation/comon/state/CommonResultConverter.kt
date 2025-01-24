package com.example.dr_web.presentation.comon.state

import com.example.dr_web.domain.entity.Result

abstract class CommonResultConverter<T : Any, R : Any> {
    fun convert(result: Result<T>): DataLoader<R> {
        return when (result) {
            is Result.Error -> { DataLoader.Error(result.exception.localizedMessage.orEmpty()) }
            is Result.Success -> { DataLoader.Success(convertSuccess(result.data)) }
        }
    }
    abstract fun convertSuccess(data: T): R
}