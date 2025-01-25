package com.example.dr_web.data.entity

import android.graphics.drawable.Drawable
import com.example.dr_web.domain.entity.Package

data class PackageImpl(
    override val hash: String,
    override val icon: Drawable?,
    override val name: String,
    override val packages: String,
    override val crc: String,
    override val version: String
): Package
