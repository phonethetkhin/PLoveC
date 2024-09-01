package com.ptk.pnclovecounter.ui.screen.on_boarding

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.ptk.pnclovecounter.ui.ui_resource.composable.OnboardingPager

@Composable
fun OnboardingScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        OnboardingPager(navController)
    }
}