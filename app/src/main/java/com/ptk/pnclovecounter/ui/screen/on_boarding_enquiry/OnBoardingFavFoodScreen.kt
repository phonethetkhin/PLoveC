package com.ptk.pnclovecounter.ui.screen.on_boarding_enquiry

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.ptk.pnclovecounter.ui.ui_resource.composable.CustomAnimatedVisibility
import com.ptk.pnclovecounter.ui.ui_resource.composable.CustomButton
import com.ptk.pnclovecounter.ui.ui_resource.theme.KavoonFontFamily
import com.ptk.pnclovecounter.ui.ui_state.OnBoardingUIStates
import com.ptk.pnclovecounter.viewmodel.OnBoardingViewModel
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp
import kotlinx.coroutines.launch

@Composable
fun OnBoardingFavFoodScreen(
    modifier: Modifier = Modifier,
    onBoardingViewModel: OnBoardingViewModel = hiltViewModel(),
) {
    val onBoardingUIStates by onBoardingViewModel.uiStates.collectAsState()

    OnBoardingFavFoodScreenContent(onBoardingUIStates)

    DisposableEffect(Unit) {
        onBoardingViewModel.toggleIsShowFavFood(true)
        onDispose {
            onBoardingViewModel.toggleIsShowFavFood(false)
        }
    }
}

@Composable
fun OnBoardingFavFoodScreenContent(
    onBoardingUIStates: OnBoardingUIStates,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = modifier.height(64.sdp))
        Text(
            text = "What's your favorite meat?",
            color = Color.White,
            fontSize = 23.ssp,
            fontFamily = KavoonFontFamily,
            lineHeight = 30.ssp,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = modifier.height(32.sdp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.sdp),
            modifier = Modifier.padding(8.sdp)
        ) {
            CustomAnimatedVisibility(isVisible = onBoardingUIStates.isShowFavFood) {
                CustomButton("Chicken") {
                    scope.launch {
                        onBoardingUIStates.pagerState.scrollToPage(onBoardingUIStates.pagerState.currentPage + 1)
                    }
                }
            }
            CustomAnimatedVisibility(
                isVisible = onBoardingUIStates.isShowFavFood,
                enterTransition = slideInVertically(
                    initialOffsetY = { 1000 },
                    animationSpec = tween(durationMillis = 2000)
                ),
                exitTransition = slideOutHorizontally(
                    targetOffsetX = { -1000 },
                    animationSpec = tween(durationMillis = 2000)
                )
            ) {
                CustomButton("Pork") {
                    scope.launch {
                        onBoardingUIStates.pagerState.scrollToPage(onBoardingUIStates.pagerState.currentPage + 1)
                    }
                }
            }
            CustomAnimatedVisibility(
                isVisible = onBoardingUIStates.isShowFavFood,
                enterTransition = slideInHorizontally(
                    initialOffsetX = { 1000 },
                    animationSpec = tween(durationMillis = 2000)
                ),
                exitTransition = slideOutHorizontally(
                    targetOffsetX = { -1000 },
                    animationSpec = tween(durationMillis = 1000)
                )

            ) {
                CustomButton("Fish") {
                    scope.launch {
                        onBoardingUIStates.pagerState.scrollToPage(onBoardingUIStates.pagerState.currentPage + 1)
                    }
                }
            }
        }
    }
}