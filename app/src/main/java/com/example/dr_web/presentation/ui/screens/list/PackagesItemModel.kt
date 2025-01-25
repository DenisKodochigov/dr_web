package com.example.dr_web.presentation.ui.screens.list

import android.graphics.drawable.Drawable

data class PackagesItemModel(
    val hash: String,
    val icon: Drawable?,
    val name: String,
    val packageName: String,
)
