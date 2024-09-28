package com.ptk.pnclovecounter.ui.screen.on_boarding

import androidx.compose.animation.core.EaseOutCirc
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.ptk.pnclovecounter.ui.ui_resource.composable.CustomButton
import com.ptk.pnclovecounter.ui.ui_resource.composable.CustomUserInput
import com.ptk.pnclovecounter.ui.ui_resource.theme.KavoonFontFamily
import com.ptk.pnclovecounter.ui.ui_state.OnBoardingUIStates
import com.ptk.pnclovecounter.viewmodel.OnBoardingViewModel
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Composable
fun OnboardingNicknameScreen(
    modifier: Modifier = Modifier,
    onBoardingViewModel: OnBoardingViewModel = hiltViewModel(),
) {

    val onBoardingUIStates by onBoardingViewModel.uiStates.collectAsState()
    OnboardingNicknameScreenContent(
        onBoardingViewModel::toggleNickName,
        onBoardingViewModel::toggleIsShowNNQuestion,
        onBoardingViewModel::toggleIsShowResult,
        onBoardingViewModel::setResult,
        onBoardingUIStates,
    )

    DisposableEffect(Unit) {
        onBoardingViewModel.toggleIsShowNNQuestion(true)
        onBoardingViewModel.toggleNickName(true, "Athet")
        onBoardingViewModel.toggleNickName(false, "Athel")
        onDispose {
            onBoardingViewModel.toggleIsShowNNQuestion(false)
            onBoardingViewModel.toggleIsShowResult(false)
            onBoardingViewModel.setResult("")
        }
    }
}

@Composable
fun OnboardingNicknameScreenContent(
    toggleNickName: (Boolean, String) -> Unit,
    toggleIsShowNNQuestion: (Boolean) -> Unit,
    toggleIsShowResult: (Boolean) -> Unit,
    setResult: (String) -> Unit,
    onBoardingUIStates: OnBoardingUIStates,
    modifier: Modifier = Modifier
) {
    val animatedSize by animateDpAsState(
        targetValue = if (onBoardingUIStates.isShowNNQuestion || onBoardingUIStates.isShowResult) 32.sdp else 8.sdp, // Adjust the size as needed
        animationSpec = tween(
            durationMillis = 2000, // Adjust the duration as needed
            easing = EaseOutCirc // You can choose different easing functions
        ), label = ""
    )

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
                text = "You like these nicknames?",
                color = Color.White,
                fontSize = 23.ssp,
                fontFamily = KavoonFontFamily,
                lineHeight = 30.ssp,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = modifier.height(64.sdp))

            CustomAnimatedVisibility(isVisible = onBoardingUIStates.isShowNNQuestion) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.sdp),
                    modifier = Modifier.padding(8.sdp)
                ) {
                    CustomButton("Yes") {
                        toggleIsShowNNQuestion.invoke(false)
                        setResult.invoke("Okay, let's continue with these nicknames.")
                        toggleIsShowResult.invoke(true)

                    }
                    CustomButton("No") {
                        toggleIsShowNNQuestion.invoke(false)
                        setResult.invoke("No problem, you can change whatever you want, my love.")
                        toggleIsShowResult.invoke(true)
                        toggleNickName.invoke(true, "")
                        toggleNickName.invoke(false, "")
                    }
                }
            }

            Spacer(modifier = modifier.height(animatedSize))

            CustomAnimatedVisibility(isVisible = onBoardingUIStates.isShowResult) {
                CustomButton(onBoardingUIStates.result) {
                }
            }

            Spacer(modifier = modifier.height(64.sdp))

            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = modifier
                    .fillMaxWidth()
            ) {

                CustomUserInput(
                    label = "Nickname",
                    value = onBoardingUIStates.firstNickName,
                    onValChange = {
                        toggleNickName.invoke(true, it)
                    },
                    isError = onBoardingUIStates.isFNickNameEmpty,
                    errorMessage = "Nickname cannot be empty",
                )
                Spacer(modifier = modifier.width(16.sdp))
                CustomUserInput(
                    label = "Nickname",
                    value = onBoardingUIStates.secondNickName,
                    onValChange = { toggleNickName.invoke(false, it) },
                    isError = onBoardingUIStates.isSNickNameEmpty,
                    errorMessage = "Nickname cannot be empty",
                )
            }

        }
    }
}
