package com.ptk.pnclovecounter.ui.screen.on_boarding_enquiry

import android.util.Log
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
fun OnBoardingWelcomeScreen(
    modifier: Modifier = Modifier,
    onBoardingViewModel: OnBoardingViewModel = hiltViewModel(),
) {
    val onBoardingUIStates by onBoardingViewModel.uiStates.collectAsState()
    Log.e("testASDFPTK123","welcome screen")

    OnBoardingWelcomeScreenContent(onBoardingUIStates)

    DisposableEffect(Unit) {
        onBoardingViewModel.toggleIsShowWelcomeButton(true)
        onDispose {
            onBoardingViewModel.toggleIsShowWelcomeButton(false)
        }
    }

}

@Composable
fun OnBoardingWelcomeScreenContent(
    onBoardingUIStates: OnBoardingUIStates,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = modifier.height(32.sdp))
        Text(
            text = "Welcome CHO !!!",
            color = Color.White,
            fontSize = 23.ssp,
            fontFamily = KavoonFontFamily,
            lineHeight = 30.ssp,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = modifier.height(32.sdp))
        Text(
            text = "This app is intended exclusively for CHO",
            color = Color.White,
            fontSize = 23.ssp,
            fontFamily = KavoonFontFamily,
            lineHeight = 30.ssp,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = modifier.height(32.sdp))

        Text(
            text = "Are you Cho Cho Aung?",
            color = Color.White,
            fontSize = 23.ssp,
            fontFamily = KavoonFontFamily,
            lineHeight = 30.ssp,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = modifier.height(64.sdp))
        CustomAnimatedVisibility(isVisible = onBoardingUIStates.isShowWelcomeButton) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.sdp),
                modifier = Modifier.padding(8.sdp)
            ) {
                CustomButton("Yes") {
                    scope.launch {
                        onBoardingUIStates.pagerState.scrollToPage(onBoardingUIStates.pagerState.currentPage + 1)
                    }
                }
            }
        }
    }
}