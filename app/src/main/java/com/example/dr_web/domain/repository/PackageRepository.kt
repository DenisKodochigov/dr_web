package com.example.dr_web.domain.repository

import com.example.dr_web.domain.entity.Package
import kotlinx.coroutines.flow.Flow

interface PackageRepository {
    fun getPackages(): Flow<List<Package>>
    fun getPackage(packageName: String): Flow<Package>
    fun startPackage(packageName: String)
}