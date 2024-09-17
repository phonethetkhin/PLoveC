@file:OptIn(ExperimentalPagerApi::class)

package com.ptk.pnclovecounter.ui.ui_resource.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.ptk.pnclovecounter.ui.screen.on_boarding.OnboardingAnniversaryScreen
import com.ptk.pnclovecounter.ui.screen.on_boarding.OnboardingDOBScreen
import com.ptk.pnclovecounter.ui.screen.on_boarding.OnboardingNicknameScreen
import com.ptk.pnclovecounter.ui.ui_resource.navigation.Routes
import com.ptk.pnclovecounter.ui.ui_resource.theme.Pink
import ir.kaaveh.sdpcompose.sdp
import kotlinx.coroutines.launch

@Composable
fun OnboardingPager(navController: NavController) {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            count = 3,
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            when (page) {
                0 -> OnboardingNicknameScreen()
                1 -> OnboardingDOBScreen()
                2 -> OnboardingAnniversaryScreen()
            }
        }

        PagerIndicator(
            pageCount = 3,
            currentPage = pagerState.currentPage,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(start = 16.sdp, end = 16.sdp, top = 16.sdp, bottom = 18.sdp)
        )

        // Back Button
        if (pagerState.currentPage > 0) {
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Pink),
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage - 1)
                    }
                },
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Back")
            }
        }

        // Next Button
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Pink),
            onClick = {
                coroutineScope.launch {
                    if (pagerState.currentPage < pagerState.pageCount - 1) {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    } else {
                        // Navigate to another screen, e.g., the main screen, after the onboarding is complete
                        navController.navigate(Routes.HomeScreen.route) {
                            popUpTo(Routes.OnboardingScreen.route) { inclusive = true }
                        }
                    }
                }
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Text(text = if (pagerState.currentPage < pagerState.pageCount - 1) "Next" else "Finish")
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                imageVector = if (pagerState.currentPage < pagerState.pageCount - 1) Icons.AutoMirrored.Filled.ArrowForward else Icons.Filled.CheckCircle,
                contentDescription = "Next/Finish"
            )
        }

    }


}
