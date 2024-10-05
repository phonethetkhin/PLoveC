package com.ptk.pnclovecounter.util

import android.content.Context
import android.net.Uri
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

fun copyImageToAppStorage(context: Context, imageUri: Uri, fileName: String): File? {
    try {
        val inputStream = context.contentResolver.openInputStream(imageUri) ?: return null
        val appStorageDir = context.filesDir // or getFilesDir() for internal storage
        val destinationFile = File(appStorageDir, fileName)

        val outputStream = FileOutputStream(destinationFile)
        inputStream.use { input ->
            outputStream.use { output ->
                input.copyTo(output)
            }
        }
        return destinationFile
    } catch (e: IOException) {
        e.printStackTrace()
        return null
    }
}
