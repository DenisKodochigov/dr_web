package com.example.dr_web.presentation.comon.navigation

import androidx.navigation.NavHostController

class NavigateEventImpl (private val navController: NavHostController): NavigateEvent {
    override fun goToScreenPackage(id: String) { navController.navigateToSecondScreenWithArg(id) }
    override fun backStack() { navController.popBackStack() }
}