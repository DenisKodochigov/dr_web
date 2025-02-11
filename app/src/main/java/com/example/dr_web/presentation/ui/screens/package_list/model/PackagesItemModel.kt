package com.example.dr_web.presentation.ui.screens.package_list.model

import android.graphics.drawable.Drawable

data class PackagesItemModel(
    val hash: String,
    val icon: Drawable?,
    val name: String,
    val packageName: String,
)
