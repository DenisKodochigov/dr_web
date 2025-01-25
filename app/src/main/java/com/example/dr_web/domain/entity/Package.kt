package com.example.dr_web.domain.entity

import android.graphics.drawable.Drawable

interface Package {
    val hash: String
    val icon: Drawable?
    val name: String
    val packages: String
    val crc: String
    val version: String
}