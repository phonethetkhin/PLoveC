package com.ptk.pnclovecounter.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.ptk.pnclovecounter.ui.ui_resource.composable.LoveDateSection
import com.ptk.pnclovecounter.ui.ui_resource.composable.LoveProfileSection

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    HomeScreenContent()

}

@Composable
fun HomeScreenContent(modifier: Modifier = Modifier) {
    Surface(color = MaterialTheme.colorScheme.onSurface, modifier = modifier.fillMaxSize()) {
        Column {
            LoveDateSection()
            LoveProfileSection()

        }
    }
}

