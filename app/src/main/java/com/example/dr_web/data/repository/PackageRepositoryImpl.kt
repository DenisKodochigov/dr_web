package com.example.dr_web.data.repository

import com.example.dr_web.domain.entity.Package
import com.example.dr_web.domain.repository.PackageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PackageRepositoryImpl @Inject constructor(): PackageRepository {
    override fun getPackages(): Flow<List<Package>> {
       return flow { emit(listOf(
           Package(1, "pac 1", "par 2", "par 3", "par 4", "par 5"),
           Package(2, "pac 1", "par 2", "par 3", "par 4", "par 5"),
           Package(3, "pac 1", "par 2", "par 3", "par 4", "par 5"),
           Package(4, "pac 1", "par 2", "par 3", "par 4", "par 5"),
           Package(5, "pac 1", "par 2", "par 3", "par 4", "par 5")
       )) }
    }

    override fun getPackage(id: Long): Flow<Package> {
        return flow { emit(Package(0,"","", "","","")) }
    }
}