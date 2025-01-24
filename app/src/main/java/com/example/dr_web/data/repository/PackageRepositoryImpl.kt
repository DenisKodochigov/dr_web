package com.example.dr_web.data.repository

import com.example.dr_web.data.entity.PackageImpl
import com.example.dr_web.domain.entity.Package
import com.example.dr_web.domain.repository.PackageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PackageRepositoryImpl @Inject constructor(): PackageRepository {
    override fun getPackages(): Flow<List<Package>> {
       return flow { emit(listOf(
           PackageImpl(1, "pac 1", "par 2", "par 3", "par 4", "par 5"),
           PackageImpl(2, "pac 1", "par 2", "par 3", "par 4", "par 5"),
           PackageImpl(3, "pac 1", "par 2", "par 3", "par 4", "par 5"),
           PackageImpl(4, "pac 1", "par 2", "par 3", "par 4", "par 5"),
           PackageImpl(5, "pac 1", "par 2", "par 3", "par 4", "par 5")
       )) }
    }

    override fun getPackage(id: Long): Flow<Package> {
        return flow { emit(PackageImpl(0,"","", "","","")) }
    }
}