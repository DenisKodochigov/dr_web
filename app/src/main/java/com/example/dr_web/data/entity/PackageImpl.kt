package com.example.dr_web.data.entity

import com.example.dr_web.domain.entity.Package

data class PackageImpl(
    override val id: Long,
    override val name: String,
    override val par1: String,
    override val par2: String,
    override val par3: String,
    override val par4: String
): Package
