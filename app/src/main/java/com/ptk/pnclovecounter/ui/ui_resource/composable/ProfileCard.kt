@file:OptIn(ExperimentalPermissionsApi::class)

package com.ptk.pnclovecounter.ui.ui_resource.composable

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.result.ActivityResult
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState
import com.ptk.pnclovecounter.R
import com.ptk.pnclovecounter.ui.ui_resource.theme.KavoonFontFamily
import com.ptk.pnclovecounter.util.requestPermission
import com.ptk.pnclovecounter.viewmodel.HomeViewModel
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp


@Composable
fun RowScope.ProfileCard(
    homeViewModel: HomeViewModel,
    personId: Int,
    requestPermissionLauncher: ManagedActivityResultLauncher<String, Boolean>,
    permissionsState: MultiplePermissionsState,
    galleryLauncher: ManagedActivityResultLauncher<Intent, ActivityResult>,
    profilePhoto: String = "",
    nickName: String,
    zodiacName: String,
    gender: String,
    age: Int,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Column(modifier = Modifier.weight(1F)) {
        Box(modifier = modifier.align(Alignment.CenterHorizontally)) {
            // Profile Picture
            Image(
                painter = if (profilePhoto.isNotEmpty()) {
                    rememberAsyncImagePainter(
                        model = profilePhoto,
                        placeholder = painterResource(id = R.drawable.placeholder)
                    ) // Load from Firebase URL
                } else {
                    if (gender == "Male") {
                        painterResource(id = R.drawable.boyavatar)
                    } else {
                        painterResource(id = R.drawable.girl_icon)
                    }
                },
                contentScale = ContentScale.Crop, // This will crop the image to fit in the circle
                contentDescription = "profile photo",
                modifier = modifier
                    .size(100.sdp) // Set size first
                    .clip(CircleShape) // Then clip to circle
                    .border(
                        2.dp,
                        Color.White,
                        CircleShape
                    ) // Optional: Add a border for better visibility
            )

            // Camera Icon positioned at the top right
            Image(
                painter = painterResource(id = R.drawable.baseline_camera_alt_24), // Replace with your camera icon resource
                contentDescription = "Camera Icon",
                modifier = Modifier
                    .size(24.sdp) // Size of the camera icon
                    .background(color = Color.White, shape = CircleShape)
                    .padding(4.sdp) // Padding to create a little space inside the circular background
                    .align(Alignment.TopEnd) // Align the icon to the top end of the box
                    .clickable {
                        openGallery(
                            homeViewModel = homeViewModel,
                            personId = personId,
                            context = context,
                            requestPermissionLauncher = requestPermissionLauncher,
                            permissionsStates = permissionsState,
                            galleryLauncher = galleryLauncher
                        )
                    }
            )
        }
        Spacer(modifier = modifier.height(4.sdp))
        Text(
            text = nickName,
            color = Color.White,
            fontSize = 20.ssp,
            fontFamily = KavoonFontFamily,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .clickable {
                    homeViewModel.setPersonId(personId)
                    homeViewModel.toggleIsShowEditNickNameDialog(true)
                }
        )
        Spacer(modifier = modifier.height(4.sdp))

        Row(modifier = modifier.align(Alignment.CenterHorizontally)) {
            AgeCard(age = age, gender = gender)
            Spacer(modifier = modifier.width(4.sdp))
            ZodiacCard(zodiacName = zodiacName)
        }
    }
}

private fun openGallery(
    homeViewModel: HomeViewModel,
    personId: Int,
    context: Context,
    requestPermissionLauncher: ManagedActivityResultLauncher<String, Boolean>,
    permissionsStates: MultiplePermissionsState,
    galleryLauncher: ManagedActivityResultLauncher<Intent, ActivityResult>
) {
    // Check if permissions are granted
    if (permissionsStates.allPermissionsGranted) {
        // Permissions are granted, open the gallery
        val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
            type = "image/*"
            putExtra(Intent.EXTRA_ALLOW_MULTIPLE, false) // Optional: Allow multiple image selection
        }
        homeViewModel.setPersonId(personId)
        galleryLauncher.launch(Intent.createChooser(intent, "Select Picture"))
    } else {
        // Request permissions
        if (permissionsStates.shouldShowRationale) {
            // Show rationale if necessary
            showPermissionRationale(context, requestPermissionLauncher)
        } else {
            // Check if "Don't ask again" was selected
            val permission = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                Manifest.permission.READ_MEDIA_IMAGES
            } else {
                Manifest.permission.READ_EXTERNAL_STORAGE
            }
            if (!ActivityCompat.shouldShowRequestPermissionRationale(
                    context as Activity,
                    permission
                )
            ) {
                // Show a dialog to open app settings if "Don't ask again" is selected
                showAppSettingsDialog(context)
            } else {
                // Request permission
                requestPermissionLauncher.launch(permission)
            }
        }
    }
}


// Function to show app settings dialog
private fun showAppSettingsDialog(context: Context) {
    AlertDialog.Builder(context)
        .setTitle("Permission Required")
        .setMessage("Permission is required to access the gallery. Please enable it in the app settings.")
        .setPositiveButton("Go to Settings") { _, _ ->
            val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                data = Uri.fromParts("package", context.packageName, null)
            }
            context.startActivity(intent)
        }
        .setNegativeButton("Cancel", null)
        .show()
}

// Function to show rationale dialog
private fun showPermissionRationale(
    context: Context,
    requestPermissionLauncher: ManagedActivityResultLauncher<String, Boolean>
) {
    AlertDialog.Builder(context)
        .setTitle("Permission Required")
        .setMessage("We need permission to access your gallery to select a profile photo.")
        .setPositiveButton("Allow") { _, _ ->
            requestPermissionLauncher.requestPermission()
        }
        .setNegativeButton("Cancel", null)
        .show()
}
