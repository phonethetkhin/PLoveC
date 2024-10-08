@file:OptIn(ExperimentalPermissionsApi::class)

package com.ptk.pnclovecounter.ui.screen

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.ptk.pnclovecounter.ui.screen.love_date_section.LoveDateSection
import com.ptk.pnclovecounter.ui.ui_resource.composable.EditNickNameDialog
import com.ptk.pnclovecounter.ui.ui_resource.composable.LoadingDialog
import com.ptk.pnclovecounter.ui.ui_resource.composable.LoveProfileSection
import com.ptk.pnclovecounter.ui.ui_state.HomeUIStates
import com.ptk.pnclovecounter.util.requestPermission
import com.ptk.pnclovecounter.viewmodel.HomeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val homeUIStates: HomeUIStates by homeViewModel.uiStates.collectAsState()
    val scope = rememberCoroutineScope()
    val galleryLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val selectedImageUri: Uri? = result.data?.data
                // Upload the selected image
                scope.launch {
                    selectedImageUri?.let {
                        homeViewModel.uploadImageToFirebase(uri = it)
                    }
                }
            }
        }
    val permissionStates =
        rememberMultiplePermissionsState(
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                listOf(Manifest.permission.READ_MEDIA_IMAGES) // For Android 13+
            } else {
                listOf(Manifest.permission.READ_EXTERNAL_STORAGE) // For Android 12 and below
            }
        )

    val requestPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            Log.e("testASDFPTK", "Permission Granted")
        } else {
            Log.e("testASDFPTK", "Permission Denied")
        }
    }

    LaunchedEffect(permissionStates) {
        if (!permissionStates.allPermissionsGranted) {
            requestPermissionLauncher.requestPermission()
        }
    }

    LaunchedEffect(Unit) {
        homeViewModel.getPersons()
        homeViewModel.getAnniDate()
    }

    HomeScreenContent(
        scope = scope,
        homeViewModel = homeViewModel,
        requestPermissionLauncher = requestPermissionLauncher,
        permissionsState = permissionStates,
        galleryLauncher = galleryLauncher,
        homeUIStates = homeUIStates
    )

}

@Composable
fun HomeScreenContent(
    scope: CoroutineScope,
    homeViewModel: HomeViewModel,
    requestPermissionLauncher: ManagedActivityResultLauncher<String, Boolean>,
    permissionsState: MultiplePermissionsState,
    galleryLauncher: ManagedActivityResultLauncher<Intent, ActivityResult>,
    modifier: Modifier = Modifier,
    homeUIStates: HomeUIStates,
) {
    LoadingDialog(showDialog = homeUIStates.isLoading)

    EditNickNameDialog(
        showDialog = homeUIStates.isShowEditNickNameDialog,
        textValue = if (homeUIStates.personId == 1) homeUIStates.person1NickName else homeUIStates.person2NickName,
        onDismiss = {
            homeViewModel.toggleIsShowEditNickNameDialog(false)
        },
        onValueChange = { homeViewModel.toggleNickName(it) },
        onConfirm = {
            scope.launch {
                homeViewModel.updateNickName()
                homeViewModel.toggleIsShowEditNickNameDialog(false)
            }
        }
    )

    Surface(color = MaterialTheme.colorScheme.onSurface, modifier = modifier.fillMaxSize()) {
        Column {
            LoveDateSection()
            LoveProfileSection(
                homeViewModel = homeViewModel,
                requestPermissionLauncher = requestPermissionLauncher,
                permissionsState = permissionsState,
                galleryLauncher = galleryLauncher,
                homeUIStates = homeUIStates
            )

        }
    }
}

