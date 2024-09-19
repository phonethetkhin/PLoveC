package com.ptk.pnclovecounter.ui.screen.on_boarding

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.ptk.pnclovecounter.ui.ui_resource.composable.CustomAnimatedVisibility
import com.ptk.pnclovecounter.ui.ui_resource.composable.CustomButton
import com.ptk.pnclovecounter.ui.ui_resource.composable.CustomUserInput
import com.ptk.pnclovecounter.ui.ui_resource.theme.KavoonFontFamily
import com.ptk.pnclovecounter.ui.ui_state.OnBoardingUIStates
import com.ptk.pnclovecounter.viewmodel.OnBoardingViewModel
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp
import kotlinx.coroutines.delay

@Composable
fun OnBoardingPasswordScreen(
    modifier: Modifier = Modifier,
    onBoardingViewModel: OnBoardingViewModel = hiltViewModel(),
) {
    val onBoardingUIStates by onBoardingViewModel.uiStates.collectAsState()

    OnBoardingPasswordScreenContent(onBoardingViewModel::toggleOurPassword, onBoardingUIStates)

    LaunchedEffect(Unit) {
        delay(2000L)
        onBoardingViewModel.toggleIsShowOurPassword(true)
    }
    DisposableEffect(Unit) {
        onDispose {
            onBoardingViewModel.toggleIsShowOurPassword(false)
        }
    }
}

@Composable
fun OnBoardingPasswordScreenContent(
    togglePassword: (String) -> Unit,
    onBoardingUIStates: OnBoardingUIStates,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        Spacer(modifier = modifier.height(64.sdp))
        Text(
            text = "To prove that you are Cho, please enter our password",
            color = Color.White,
            fontSize = 23.ssp,
            fontFamily = KavoonFontFamily,
            lineHeight = 30.ssp,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = modifier.height(32.sdp))

        Row(modifier = modifier.fillMaxWidth()) {
            CustomAnimatedVisibility(isVisible = onBoardingUIStates.isShowPassword) {
                CustomUserInput(
                    label = "Password",
                    value = onBoardingUIStates.ourPassword,
                    onValChange = {
                        togglePassword.invoke(it)
                    },
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(8.sdp)
                )
            }
        }

        CustomAnimatedVisibility(
            isVisible = onBoardingUIStates.isShowPassword,
            enterTransition = slideInVertically(
                initialOffsetY = { 1000 },
                animationSpec = tween(durationMillis = 2000)
            ),
            exitTransition = slideOutHorizontally(
                targetOffsetX = { -1000 },
                animationSpec = tween(durationMillis = 2000)
            )
        ) {
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.End)
                    .padding(8.sdp)
            ) {
                CustomButton("Done") {

                }
            }
        }
    }
}