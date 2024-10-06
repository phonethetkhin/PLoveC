@file:OptIn(ExperimentalPermissionsApi::class, ExperimentalPermissionsApi::class)

package com.ptk.pnclovecounter.ui.ui_resource.composable

import android.content.Intent
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.result.ActivityResult
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState
import com.ptk.pnclovecounter.R
import com.ptk.pnclovecounter.ui.ui_resource.theme.DarkPink
import com.ptk.pnclovecounter.ui.ui_state.HomeUIStates
import com.ptk.pnclovecounter.viewmodel.HomeViewModel
import ir.kaaveh.sdpcompose.sdp

@Composable
fun LoveProfileSection(
    homeViewModel: HomeViewModel,
    requestPermissionLauncher: ManagedActivityResultLauncher<String, Boolean>,
    permissionsState: MultiplePermissionsState,
    galleryLauncher: ManagedActivityResultLauncher<Intent, ActivityResult>,
    homeUIStates: HomeUIStates,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 16.sdp, horizontal = 8.sdp)
    ) {
        ProfileCard(
            homeViewModel = homeViewModel,
            personId = 1,
            requestPermissionLauncher = requestPermissionLauncher,
            permissionsState = permissionsState,
            galleryLauncher = galleryLauncher,
            gender = "Male",
            profilePhoto = homeUIStates.person1?.profilePicture ?: "",
            nickName = homeUIStates.person1?.nickName ?: "Default",
            zodiacName = homeUIStates.person1?.zodiacSign ?: "Aries",
            age = homeUIStates.person1?.age ?: 1
        )
        Icon(
            painter = painterResource(id = R.drawable.baseline_favorite_24),
            contentDescription = "love icon",
            tint = DarkPink,
            modifier = modifier
                .align(Alignment.CenterVertically)
                .padding(bottom = 50.sdp)
        )
        ProfileCard(
            homeViewModel = homeViewModel,
            personId = 2,
            requestPermissionLauncher = requestPermissionLauncher,
            permissionsState = permissionsState,
            galleryLauncher = galleryLauncher,
            gender = "Female",
            profilePhoto = homeUIStates.person2?.profilePicture ?: "",
            nickName = homeUIStates.person2?.nickName ?: "Default",
            zodiacName = homeUIStates.person2?.zodiacSign ?: "Aries",
            age = homeUIStates.person2?.age ?: 1
        )
    }
}