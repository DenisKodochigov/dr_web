package com.example.dr_web.presentation.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.navigation.compose.rememberNavController
import com.example.dr_web.presentation.comon.navigation.NavHostApp
import com.example.dr_web.presentation.ui.theme.Dr_webTheme

@SuppressLint("RestrictedApi")
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun StartApp() {

    Dr_webTheme {
        val navController = rememberNavController()
//        val currentScreen = navController.backScreenDestination()

        Scaffold(
            modifier = Modifier.semantics { testTagsAsResourceId = true },
//            topBar = {
//                CollapsingToolbar(
//                    text = stringResource(currentScreen.nameScreen),
//                    moreHoriz = { println(navController.currentBackStack.value.toString())}  ,
//                    backScreen = { navController.popBackStack()})
//            },
//            bottomBar = {
//                BottomBarApp(
//                    currentScreen = currentScreen,
//                    onTabSelection = { newScreen -> navController.navigateToScreen(newScreen.route) })
//            },
            floatingActionButtonPosition = FabPosition.End,
            content = { innerPadding ->
                NavHostApp(navController = navController, modifier = Modifier.padding(innerPadding))
            }
        )
    }
}