package com.example.dr_web.presentation.comon.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessAlarms
import androidx.compose.material.icons.filled.Brightness5
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.dr_web.R

interface ScreenDestination {
    val route: String
    val routeWithArgs: String
    val nameScreen: Int
    val icon: ImageVector
    val iconText: Int
    val pictureDay: Int
    val pictureNight: Int
    val showFab: Boolean
    var textFABId: Int
    var onClickFAB: () -> Unit
}
/*** App app navigation destinations*/
object MainDestination : ScreenDestination {
    override val route = "packages"
    override val routeWithArgs = route
    override val nameScreen = R.string.list_application
    override val icon = Icons.Filled.AccessAlarms
    override val iconText = R.string.not_text
    override val pictureDay = 0
    override val pictureNight = 0
    override val showFab: Boolean = true
    override var textFABId: Int = R.string.not_text
    override var onClickFAB: () -> Unit = {}
}
object SecondDestination : ScreenDestination {
    override val route = "package"
    override val nameScreen = R.string.application_info
    override val icon = Icons.Filled.Brightness5
    override val iconText = R.string.not_text
    override val pictureDay = R.drawable.ic_launcher_background
    override val pictureNight = R.drawable.ic_launcher_background
    override val showFab: Boolean = false
    override var textFABId: Int = R.string.not_text
    override var onClickFAB: () -> Unit = {}

    const val ARG = "arg_application"
    override val routeWithArgs = "$route/{$ARG}"
    val arguments = listOf(navArgument(ARG) { type = NavType.LongType })
}
val navBottomScreens = listOf(MainDestination, SecondDestination)
val listScreens = listOf(MainDestination, SecondDestination)
val DEFAULT_SCREEN = MainDestination
const val DURATION_SCREEN = 800
const val DELAY_SCREEN = 200