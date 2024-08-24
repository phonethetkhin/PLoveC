@file:OptIn(ExperimentalMaterial3Api::class)

package com.ptk.pnclovecounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.ptk.pnclovecounter.ui.ui_resource.navigation.NavGraph
import com.ptk.pnclovecounter.ui.ui_resource.theme.MemoryCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MemoryCalculatorTheme {
                MainComposable()
            }
        }
    }
}

@Composable
fun MainComposable() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar(title = { Text("Phone Love Cho") }) }
    ) {
        NavGraph(
            it.calculateBottomPadding().value,
            navController,
        )
    }
}


