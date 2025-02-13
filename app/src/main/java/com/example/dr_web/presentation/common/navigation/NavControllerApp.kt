package com.example.dr_web.presentation.common.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

fun NavHostController.navigateToScreen(route: String) = this.navigate(route) { launchSingleTop = true }
fun NavHostController.navigateToMain(id: Long) {
    this.navigateToScreen("${SecondDestination.route}/$id")
}
fun NavHostController.navigateToSecondScreenWithArg(argId: String) {
    this.navigateToScreen("${SecondDestination.route}/$argId")
}
@Composable
fun NavHostController.backScreenDestination(): ScreenDestination {
    return listScreens.find{
        it.routeWithArgs == this.currentBackStackEntryAsState().value?.destination?.route } ?: DEFAULT_SCREEN
}

