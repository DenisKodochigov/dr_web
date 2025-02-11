package com.example.dr_web.presentation.ui.screens.package_single.model

import android.graphics.drawable.Drawable

data class PackageModel (
    val icon: Drawable?,
    val name: String,
    val packageName: String,
    val version: String,
    val crc: String
)