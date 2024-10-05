package com.ptk.pnclovecounter.util

import android.Manifest
import android.os.Build
import androidx.activity.compose.ManagedActivityResultLauncher

fun ManagedActivityResultLauncher<String, Boolean>.requestPermission() {
    val permissionToRequest = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        Manifest.permission.READ_MEDIA_IMAGES
    } else {
        Manifest.permission.READ_EXTERNAL_STORAGE
    }

    this.launch(permissionToRequest)
}