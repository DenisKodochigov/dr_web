package com.example.dr_web.domain.entity

sealed class UseCaseException(cause: Throwable) : Throwable(cause) {
    class ApplicationException(cause: Throwable) : UseCaseException(cause)
    class UnknownException(cause: Throwable) : UseCaseException(cause)

    companion object {
        fun createFromThrowable(throwable: Throwable): UseCaseException {
            return if (throwable is UseCaseException) throwable else UnknownException(throwable)
        }
    }
}