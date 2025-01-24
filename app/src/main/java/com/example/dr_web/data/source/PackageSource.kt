package com.example.dr_web.data.source

import com.example.dr_web.domain.entity.Package

interface PackageSource {

    fun getPackages(): List<Package>
    fun getPackage(id: Long): Package
}