package com.example.dr_web.presentation.ui.screens.package_single

import com.example.dr_web.presentation.comon.navigation.NavigateEventImpl

data class PackageAction(
    val getPackage: (String)-> Unit,
    val backScreen: ()-> Unit,
    val packageRun:(String)->Unit,
    val initNavigate:(NavigateEventImpl)->Unit,
)
