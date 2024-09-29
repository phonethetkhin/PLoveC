package com.ptk.pnclovecounter.ui.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ptk.pnclovecounter.R
import com.ptk.pnclovecounter.ui.ui_resource.navigation.Routes
import com.ptk.pnclovecounter.ui.ui_resource.theme.KavoonFontFamily
import com.ptk.pnclovecounter.ui.ui_resource.theme.Purple40
import com.ptk.pnclovecounter.viewmodel.OnBoardingViewModel
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navHostController: NavHostController,
    onBoardingViewModel: OnBoardingViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    LaunchedEffect(Unit) {
        // Wait for 3 seconds
        val isFirstLaunch = onBoardingViewModel.isFirstLaunch()
        delay(3000)
        // Navigate to the onboarding screen
        if (isFirstLaunch) {
            navHostController.navigate(Routes.OnboardingEnquiryScreen.route) {
                // Clear the back stack to prevent the user from navigating back to the splash screen
                popUpTo(Routes.SplashScreen.route) { inclusive = true }
            }
        } else {
            navHostController.navigate(Routes.HomeScreen.route) {
                // Clear the back stack to prevent the user from navigating back to the splash screen
                popUpTo(Routes.SplashScreen.route) { inclusive = true }
            }
        }
    }

    SplashScreenContent()

}

@Composable
fun SplashScreenContent(modifier: Modifier = Modifier) {
    Surface(color = Purple40, modifier = modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 16.sdp)
        ) {
            Text(
                text = "Counting Memories in the Best Way",
                color = Color.White,
                fontSize = 23.ssp,
                fontFamily = KavoonFontFamily,
                lineHeight = 30.ssp,
                textAlign = TextAlign.Center,
            )

            Spacer(modifier = modifier.height(64.sdp))
            Image(
                painter = painterResource(id = R.drawable.chologo),
                contentDescription = "logo",
                modifier = modifier
                    .clip(CircleShape)
                    .size(200.sdp)
            )
            Spacer(modifier = modifier.height(64.sdp))


        }
    }
}

