package com.example.dr_web.presentation.ui.screens.package_list

import com.example.dr_web.presentation.ui.screens.package_list.model.PackagesItemModel

data class PackagesState (
    val headerText: String = "",
    val items: List<PackagesItemModel> = listOf(),
)
