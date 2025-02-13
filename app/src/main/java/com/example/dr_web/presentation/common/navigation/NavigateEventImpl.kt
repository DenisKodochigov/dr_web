package com.example.dr_web.presentation.common.navigation

import androidx.navigation.NavHostController

class NavigateEventImpl (private val navController: NavHostController): NavigateEvent {
    override fun goToScreenPackage(id: String) { navController.navigateToSecondScreenWithArg(id) }
    override fun backStack() { navController.popBackStack() }
}