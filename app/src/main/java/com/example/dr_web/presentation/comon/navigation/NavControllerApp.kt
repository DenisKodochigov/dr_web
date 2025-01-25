package com.example.dr_web.presentation.comon.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import java.util.UUID

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

