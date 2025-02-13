package com.example.dr_web.presentation.common.navigation

interface NavigateEvent {
    fun goToScreenPackage(id: String)
    fun backStack()
}