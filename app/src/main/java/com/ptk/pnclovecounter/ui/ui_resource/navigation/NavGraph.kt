package com.ptk.pnclovecounter.ui.ui_resource.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ptk.pnclovecounter.ui.screen.HomeScreen


@Composable
fun NavGraph(
    scaffoldPaddingValue: Float,
    navController: NavHostController,
) {
    NavHost(
        modifier = Modifier.padding(bottom = scaffoldPaddingValue.dp),
        navController = navController,
        startDestination = Routes.HomeScreen.route
    ) {

        composable(route = Routes.HomeScreen.route) {
            HomeScreen(navController)
        }



    }
}