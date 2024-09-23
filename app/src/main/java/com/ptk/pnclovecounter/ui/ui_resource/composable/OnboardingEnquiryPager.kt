package com.ptk.pnclovecounter.ui.ui_resource.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.ptk.pnclovecounter.ui.screen.on_boarding_enquiry.OnBoardingFavFoodScreen
import com.ptk.pnclovecounter.ui.screen.on_boarding_enquiry.OnBoardingPasswordScreen
import com.ptk.pnclovecounter.ui.screen.on_boarding_enquiry.OnBoardingWelcomeScreen
import ir.kaaveh.sdpcompose.sdp


@Composable
fun OnboardingEnquiryPager(pagerState: PagerState, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        HorizontalPager(
            state = pagerState,
            userScrollEnabled = false,
            modifier = Modifier
                .fillMaxSize()
        ) { page ->
            when (page) {
                0 -> OnBoardingWelcomeScreen()
                1 -> OnBoardingFavFoodScreen()
                2 -> OnBoardingPasswordScreen(navController)
            }
        }

        PagerIndicator(
            pageCount = 3,
            currentPage = pagerState.currentPage,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(start = 16.sdp, end = 16.sdp, top = 16.sdp, bottom = 18.sdp)
        )
    }
}
