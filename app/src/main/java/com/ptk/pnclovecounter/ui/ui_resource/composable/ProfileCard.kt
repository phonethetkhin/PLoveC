@file:OptIn(ExperimentalPermissionsApi::class)

package com.ptk.pnclovecounter.ui.ui_resource.composable

import android.net.Uri
import android.util.Log
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState
import com.google.accompanist.permissions.PermissionState
import com.ptk.pnclovecounter.R
import com.ptk.pnclovecounter.ui.ui_resource.theme.KavoonFontFamily
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp


@Composable
fun RowScope.ProfileCard(
    permissionsState: MultiplePermissionsState,
    galleryLauncher: ManagedActivityResultLauncher<String, Uri?>,
    profilePhoto: String = "",
    nickName: String,
    zodiacName: String,
    gender: String,
    age: Int,
    modifier: Modifier = Modifier
) {


    Column(modifier = Modifier.weight(1F)) {
        Box(modifier = modifier.align(Alignment.CenterHorizontally)) {
            // Profile Picture
            Image(
                painter = if (gender == "Male") {
                    painterResource(id = R.drawable.boyavatar)
                } else {
                    painterResource(id = R.drawable.girl_icon)
                },
                contentDescription = "profile photo",
                modifier = modifier
                    .clip(CircleShape)
                    .size(110.sdp)

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
                        Log.e("testASDFPTK123", "Clicked")
                        openGallery(permissionsState = permissionsState, galleryLauncher)
                    }
            )
        }
        Spacer(modifier = modifier.height(4.sdp))
        Text(
            text = nickName,
            color = Color.White,
            fontSize = 23.ssp,
            fontFamily = KavoonFontFamily,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = modifier.align(Alignment.CenterHorizontally)
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
    permissionsState: MultiplePermissionsState,
    galleryLauncher: ManagedActivityResultLauncher<String, Uri?>
) {
    Log.e("testASDFPTK123", "Gallery Opened")
    Log.e("testASDFPTK123", "PermissionState ${permissionsState.allPermissionsGranted}")

    galleryLauncher.launch("image/*")

}
