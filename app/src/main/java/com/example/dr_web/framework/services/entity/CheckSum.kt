package com.example.dr_web.framework.services.entity

import java.io.File
import java.security.DigestException
import java.security.MessageDigest
import javax.inject.Inject

class CheckSum @Inject constructor() {
    private val type: String = "MD5"
    private val bufferSize = 1024 * 1024
    fun getCheckSum(file: File): String {
        val digest = MessageDigest.getInstance(type)
        try {
            file.inputStream().buffered(bufferSize).use { it.iterator().forEach(digest::update) }
        } catch ( e: Exception) {
            throw DigestException("Couldn't make digest of partial content");
        }
        val result = digest.digest().joinToString("") { "%02x".format(it) }
        return result
    }
}