package com.ptk.pnclovecounter.ui.ui_resource.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ptk.pnclovecounter.ui.screen.HomeScreen
import com.ptk.pnclovecounter.ui.screen.SplashScreen
import com.ptk.pnclovecounter.ui.screen.on_boarding.OnboardingScreen
import com.ptk.pnclovecounter.ui.screen.on_boarding_enquiry.OnboardingEnquiryScreen


@Composable
fun NavGraph(
    scaffoldPaddingValue: Float,
    navController: NavHostController,
) {
    NavHost(
        modifier = Modifier.padding(bottom = scaffoldPaddingValue.dp),
        navController = navController,
        startDestination = Routes.SplashScreen.route
    ) {
        composable(route = Routes.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(route = Routes.OnboardingEnquiryScreen.route) {
            OnboardingEnquiryScreen(navController)
        }

        composable(route = Routes.OnboardingScreen.route) {
            OnboardingScreen(navController)
        }

        composable(route = Routes.HomeScreen.route) {
            HomeScreen(navController)
        }


    }
}