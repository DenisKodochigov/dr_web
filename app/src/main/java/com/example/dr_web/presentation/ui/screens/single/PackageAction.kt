package com.example.dr_web.presentation.ui.screens.single

import com.example.dr_web.presentation.comon.state.UiAction
import java.util.UUID

sealed class PackageAction: UiAction {
    data class GetPackage(val packageName: String) : PackageAction()
    data class StartPackage(val packageName: String) : PackageAction()
    data class BackClick(val id: Long) : PackageAction()
}