package com.example.dr_web.presentation.comon.navigation

interface NavigateEvent {
    fun goToScreenPackage(id: Long)
    fun backStack()
}