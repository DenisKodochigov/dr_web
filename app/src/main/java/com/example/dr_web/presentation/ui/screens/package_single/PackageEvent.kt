package com.example.dr_web.presentation.ui.screens.package_single

import com.example.dr_web.presentation.common.state.Event

sealed class PackageEvent: Event{
    data object BackClick : PackageEvent()
    data class GetPackage(val packageName: String) : PackageEvent()
    data class RunPackage(val packageName: String) : PackageEvent()
}