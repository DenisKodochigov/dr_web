package com.example.dr_web.framework.services.entity

import java.io.File
import java.security.MessageDigest
import javax.inject.Inject

class CheckSum @Inject constructor() {
    fun getCheckSum(file: File): String = file.CheckSum("MD5")
}

@OptIn(ExperimentalStdlibApi::class)
fun File.CheckSum(type: String): String{
    val md = MessageDigest.getInstance(type)
    val digest = md.digest(this.readBytes())
    return digest.toHexString()
}