package com.example.dr_web.presentation.ui.screens.package_list

import com.example.dr_web.presentation.comon.navigation.NavigateEventImpl

data class PackagesAction(
    val getPackages: ()-> Unit,
    val backScreen: ()-> Unit,
    val packageClick:(String)->Unit,
    val initNavigate:(NavigateEventImpl)->Unit,
)
