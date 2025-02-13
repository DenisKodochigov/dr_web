package com.example.dr_web.presentation.ui.screens.package_list

import com.example.dr_web.presentation.common.state.Event

sealed class PackagesEvent: Event{
    data object GetPackages : PackagesEvent()
    data object BackClick : PackagesEvent()
    data class PackageClick(val id: String) : PackagesEvent()
}