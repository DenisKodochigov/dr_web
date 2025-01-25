package com.example.dr_web.framework.services.entity

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import com.example.dr_web.data.entity.PackageImpl
import java.io.File
import javax.inject.Inject


class PackageSourceConverter @Inject constructor(
    private val packageManager: PackageManager,
    private val checkSum: CheckSum,) {
    fun convert(info: PackageInfo): PackageImpl {
//        val nn = info.applicationInfo!!.loadLabel(packageManager)
//        val name = info.applicationInfo?.name?.replace("${info.packageName}.", "") ?: info.packageName
        return PackageImpl(
            hash = info.hashCode().toString(),
            name = info.applicationInfo!!.loadLabel(packageManager).toString(),
            icon = info.applicationInfo?.loadIcon(packageManager),
            packages = info.packageName,
            crc = "",
            version = info.versionName ?: " no version",)
    }

    fun convertWithCRC(info: PackageInfo): PackageImpl {
//        val name = info.applicationInfo?.name?.replace("${info.packageName}.", "") ?: info.packageName
        return PackageImpl(
            hash = info.hashCode().toString(),
            name = info.applicationInfo!!.loadLabel(packageManager).toString(),
            icon = info.applicationInfo?.loadIcon(packageManager),
            packages = info.packageName,
            crc = info.applicationInfo?.let { checkSum.getCheckSum(File(it.sourceDir)) } ?: "",
            version = info.versionName ?: " no version",)
    }
}