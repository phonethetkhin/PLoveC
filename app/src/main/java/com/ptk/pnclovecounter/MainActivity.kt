package com.ptk.pnclovecounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ptk.pnclovecounter.ui.ui_resource.composable.CustomTopAppBar
import com.ptk.pnclovecounter.ui.ui_resource.composable.DrawerContent
import com.ptk.pnclovecounter.ui.ui_resource.navigation.NavGraph
import com.ptk.pnclovecounter.ui.ui_resource.navigation.Routes
import com.ptk.pnclovecounter.ui.ui_resource.theme.MemoryCalculatorTheme
import com.ptk.pnclovecounter.ui.ui_resource.theme.Purple40
import com.ptk.pnclovecounter.ui.ui_resource.theme.Purple80
import com.ptk.pnclovecounter.viewmodel.DrawerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
fun MainComposable(
    drawerViewModel: DrawerViewModel = hiltViewModel(),
) {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    ModalNavigationDrawer(
        gesturesEnabled = true,
        drawerContent = {
            DrawerContent()
        },
        drawerState = drawerState,
        content = {
            MainContent(drawerState, navController)
        }
    )

}

@Composable
fun MainContent(
    drawerState: DrawerState,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            if (currentRoute != Routes.SplashScreen.route) {
                CustomTopAppBar(drawerState, modifier)
            }
        }
    ) {
        NavGraph(
            it.calculateBottomPadding().value,
            navController,
        )
    }
}


