package com.example.dr_web.presentation.comon.state

import com.example.dr_web.domain.entity.Result

abstract class CommonConverter<T: Any, R: Any> {
    fun convert(result: Result<T>): ScreenState<R> {
        return when (result) {
            is Result.Error -> { ScreenState.Error(result.exception.localizedMessage.orEmpty()) }
            is Result.Success -> { ScreenState.Success(convertSuccess(result.data)) }
        }
    }
    abstract fun convertSuccess(data: T): R
}