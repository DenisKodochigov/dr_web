package com.example.dr_web.framework.services.source

import com.example.dr_web.data.entity.PackageImpl
import com.example.dr_web.data.source.PackageSource
import com.example.dr_web.domain.entity.Package
import com.example.dr_web.framework.services.PackageService
import com.example.dr_web.framework.services.entity.PackageSourceConverter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PackageSourceImpl @Inject constructor(
    private val packageService: PackageService,
    private val convertor: PackageSourceConverter
): PackageSource{
    override fun getPackages(): Flow<List<PackageImpl>> {
        return flow {  emit ( packageService.getPackages().map { convertor.convert(it) }) }
    }

    override fun getPackage(packageName: String): Flow<Package> {
        return flow {  emit (convertor.convertWithCRC(packageService.getPackage(packageName)))}}

    override fun startPackage(packageName: String) {
        packageService.startPackage(packageName)
    }
}