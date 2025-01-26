package com.example.dr_web.data.repository

import com.example.dr_web.data.source.PackageSource
import com.example.dr_web.domain.entity.Package
import com.example.dr_web.domain.repository.PackageRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PackageRepositoryImpl @Inject constructor(private val packageSource: PackageSource): PackageRepository {
    override fun getPackages(): Flow<List<Package>> {
        return packageSource.getPackages()
    }

    override fun getPackage(packageName: String): Flow<Package> {
        return packageSource.getPackage(packageName)
    }

    override fun startPackage(packageName: String) {
        packageSource.startPackage(packageName)
    }
}