package com.example.dr_web.domain.repository

import kotlinx.coroutines.flow.Flow
import com.example.dr_web.domain.entity.Package

interface PackageRepository {
    fun getPackages(): Flow<List<Package>>
    fun getPackage(id: Long): Flow<Package>
}