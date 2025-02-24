package com.example.dr_web.framework.services

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import javax.inject.Inject

class PackageService @Inject constructor(private val packageManager: PackageManager,
                                         private val context: Context) {

    @SuppressLint("QueryPermissionsNeeded")
    fun getPackages(): MutableList<PackageInfo> =
        packageManager.getInstalledPackages(PackageManager.GET_META_DATA)

    fun getPackage(packageName: String): PackageInfo =
        packageManager.getPackageInfo(packageName, 0)

    fun startPackage(packageName: String)
    {
        val intent = packageManager.getLaunchIntentForPackage(packageName)
        intent?.let { context.startActivity(intent) }
    }
}