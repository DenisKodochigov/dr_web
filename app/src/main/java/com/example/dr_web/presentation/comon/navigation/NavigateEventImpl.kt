package com.example.dr_web.presentation.comon.navigation

import androidx.navigation.NavHostController

class NavigateEventImpl (private val navController: NavHostController): NavigateEvent {
    override fun goToScreenPackage(id: Long) { navController.navigateToMain(id) }
    override fun backStack() { navController.popBackStack() }
}