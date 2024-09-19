package com.ptk.pnclovecounter.ui.screen.on_boarding

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ptk.pnclovecounter.ui.ui_resource.composable.CustomAnimatedVisibility
import com.ptk.pnclovecounter.ui.ui_resource.composable.CustomDatePicker
import com.ptk.pnclovecounter.ui.ui_resource.theme.KavoonFontFamily
import com.ptk.pnclovecounter.ui.ui_state.OnBoardingUIStates
import com.ptk.pnclovecounter.viewmodel.OnBoardingViewModel
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Composable
fun OnboardingAnniversaryScreen(onBoardingViewModel: OnBoardingViewModel = hiltViewModel()) {

    val onBoardingUIStates by onBoardingViewModel.uiStates.collectAsState()

    OnboardingAnniversaryScreenContent(onBoardingUIStates, onBoardingViewModel::changeAnniDate)

    DisposableEffect(Unit) {
        onBoardingViewModel.toggleIsShowAnniversaryDate(true)
        onDispose {
            onBoardingViewModel.toggleIsShowAnniversaryDate(false)
        }
    }
}

@Composable
fun OnboardingAnniversaryScreenContent(
    onBoardingUIStates: OnBoardingUIStates,
    changeAnniDate: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = modifier.height(32.sdp))
            Text(
                text = "Our anniversary date",
                color = Color.White,
                fontSize = 23.ssp,
                fontFamily = KavoonFontFamily,
                lineHeight = 30.ssp,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = modifier.height(128.sdp))

            CustomAnimatedVisibility(isVisible = onBoardingUIStates.isShowAnniDate) {
                Row(modifier = modifier.fillMaxWidth()) {
                    CustomDatePicker(
                        onBoardingUIStates.anniversaryDate,
                        modifier = modifier.weight(1F)
                    ) {
                        changeAnniDate.invoke(it)
                    }
                }
            }


        }
    }
}