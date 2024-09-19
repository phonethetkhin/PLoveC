package com.ptk.pnclovecounter.ui.screen.on_boarding

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ptk.pnclovecounter.ui.ui_resource.composable.OnboardingPager
import com.ptk.pnclovecounter.viewmodel.OnBoardingViewModel

@Composable
fun OnboardingScreen(
    navController: NavController,
    onBoardingViewModel: OnBoardingViewModel = hiltViewModel(),
) {
    val onBoardingUIStates by onBoardingViewModel.uiStates.collectAsState()
    Box(modifier = Modifier.fillMaxSize()) {
        OnboardingPager(onBoardingUIStates.pagerState, navController)
    }
}