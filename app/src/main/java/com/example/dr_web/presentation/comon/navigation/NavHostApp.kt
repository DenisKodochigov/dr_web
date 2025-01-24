package com.example.dr_web.presentation.comon.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun NavHostApp(navController: NavHostController, modifier: Modifier = Modifier, ){
    NavHost(navController = navController, startDestination = DEFAULT_SCREEN.route, modifier = modifier){
        list( navigateEvent = NavigateEventImpl(navController) )
        single( navigateEvent = NavigateEventImpl(navController))
    }
}
