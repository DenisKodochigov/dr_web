package com.example.dr_web.presentation.ui.screens.single

import android.graphics.drawable.Drawable

data class PackageModel (
    val icon: Drawable?,
    val name: String,
    val packageName: String,
    val version: String,
    val crc: String
)