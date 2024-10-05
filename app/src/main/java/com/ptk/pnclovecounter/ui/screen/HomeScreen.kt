@file:OptIn(ExperimentalPermissionsApi::class)

package com.ptk.pnclovecounter.ui.screen

import android.Manifest
import android.net.Uri
import android.util.Log
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.ptk.pnclovecounter.ui.ui_resource.composable.LoveDateSection
import com.ptk.pnclovecounter.ui.ui_resource.composable.LoveProfileSection
import com.ptk.pnclovecounter.ui.ui_state.HomeUIStates
import com.ptk.pnclovecounter.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val galleryLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            Log.e("testASDFPTK", "PROFILECARD URI: $uri")
        }
    val permissionStates =
        rememberMultiplePermissionsState(listOf(Manifest.permission.READ_EXTERNAL_STORAGE))

    val requestPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            // Permission granted
        } else {
            // Handle permission denial
        }
    }

    LaunchedEffect(permissionStates) {
        if (!permissionStates.allPermissionsGranted) {
            requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
        }
    }

    LaunchedEffect(Unit) {
        homeViewModel.getPersons()
        homeViewModel.getAnniDate()
    }
    val homeUIStates: HomeUIStates by homeViewModel.uiStates.collectAsState()

    HomeScreenContent(
        permissionsState = permissionStates,
        galleryLauncher = galleryLauncher,
        homeUIStates = homeUIStates
    )

}

@Composable
fun HomeScreenContent(
    permissionsState: MultiplePermissionsState,
    galleryLauncher: ManagedActivityResultLauncher<String, Uri?>,
    modifier: Modifier = Modifier,
    homeUIStates: HomeUIStates,
) {
    Surface(color = MaterialTheme.colorScheme.onSurface, modifier = modifier.fillMaxSize()) {
        Column {
            LoveDateSection(homeUIStates.days)
            LoveProfileSection(
                permissionsState = permissionsState,
                galleryLauncher = galleryLauncher,
                homeUIStates = homeUIStates
            )

        }
    }
}

