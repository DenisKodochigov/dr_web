package com.example.dr_web.presentation.ui.screens.list

import com.example.dr_web.presentation.comon.state.UiAction

sealed class PackagesAction: UiAction {
    data object GetPackages : PackagesAction()
    data class BackClick(val id: Long) : PackagesAction()
    data class PackageClick(val id: String) : PackagesAction()
}