package com.example.dr_web.data.source

import com.example.dr_web.domain.entity.Package
import kotlinx.coroutines.flow.Flow

interface PackageSource {
    fun getPackages(): Flow<List<Package>>
    fun getPackage(packageName: String): Flow<Package>
}