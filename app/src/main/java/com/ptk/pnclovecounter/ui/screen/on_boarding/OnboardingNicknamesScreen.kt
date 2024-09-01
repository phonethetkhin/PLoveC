package com.ptk.pnclovecounter.ui.screen.on_boarding

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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ptk.pnclovecounter.ui.ui_resource.composable.CustomUserInput
import com.ptk.pnclovecounter.ui.ui_resource.theme.KavoonFontFamily
import com.ptk.pnclovecounter.ui.ui_resource.theme.Purple40
import com.ptk.pnclovecounter.ui.ui_state.OnBoardingUIStates
import com.ptk.pnclovecounter.viewmodel.OnBoardingViewModel
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Composable
fun OnboardingNicknameScreen(
    modifier: Modifier = Modifier,
    onBoardingViewModel: OnBoardingViewModel = hiltViewModel()
) {
    val onBoardingUIStates by onBoardingViewModel.uiStates.collectAsState()
    OnboardingNicknameScreenContent(onBoardingViewModel::toggleNickName, onBoardingUIStates)
}

@Composable
fun OnboardingNicknameScreenContent(
    toggleNickName: (Boolean, String) -> Unit,
    onBoardingUIStates: OnBoardingUIStates,
    modifier: Modifier = Modifier
) {
    Surface(color = Purple40) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Welcome CHO !!!",
                color = Color.White,
                fontSize = 23.ssp,
                fontFamily = KavoonFontFamily,
                lineHeight = 30.ssp,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = modifier.height(16.sdp))
            Text(
                text = "You like these nicknames?",
                color = Color.White,
                fontSize = 23.ssp,
                fontFamily = KavoonFontFamily,
                lineHeight = 30.ssp,
                textAlign = TextAlign.Center,
            )
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
                    })
                Spacer(modifier = modifier.width(16.sdp))
                CustomUserInput(
                    label = "Nickname",
                    value = onBoardingUIStates.secondNickName,
                    onValChange = { toggleNickName.invoke(false, it) })
            }

        }
    }
}