package com.ptk.pnclovecounter

import android.animation.ObjectAnimator
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.animation.AnticipateInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ptk.pnclovecounter.ui.ui_resource.composable.CustomTopAppBar
import com.ptk.pnclovecounter.ui.ui_resource.navigation.NavGraph
import com.ptk.pnclovecounter.ui.ui_resource.navigation.Routes
import com.ptk.pnclovecounter.ui.ui_resource.theme.MemoryCalculatorTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            installSplashScreen()
            splashScreen.setSplashScreenTheme(R.style.Theme_MySplashScreen)
            splashScreen.setOnExitAnimationListener { splashScreenView ->
                // Create your custom animation.
                val slideUp = ObjectAnimator.ofFloat(
                    splashScreenView,
                    View.TRANSLATION_Y,
                    0f,
                    -splashScreenView.height.toFloat()
                )
                slideUp.interpolator = AnticipateInterpolator()
                slideUp.duration = 1000L

                // Call SplashScreenView.remove at the end of your custom animation.
                slideUp.doOnEnd { splashScreenView.remove() }

                // Run your animation.
                slideUp.start()
            }
        }
        setContent {
            MemoryCalculatorTheme {
                MainComposable()
            }
        }
    }
}

@Composable
fun MainComposable(
) {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    /* ModalNavigationDrawer(
         gesturesEnabled = currentRoute != null && currentRoute != Routes.OnboardingEnquiryScreen.route,
         drawerContent = {
             DrawerContent()
         },
         drawerState = drawerState,
         content = {*/
    MainContent(drawerState, navController, currentRoute)


}

@Composable
fun MainContent(
    drawerState: DrawerState,
    navController: NavHostController,
    currentRoute: String?,
    modifier: Modifier = Modifier
) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
      /*  topBar = {
            if (currentRoute != Routes.SplashScreen.route && currentRoute != Routes.OnboardingEnquiryScreen.route && currentRoute != Routes.OnboardingScreen.route) {
                CustomTopAppBar(drawerState, modifier)
            }
        }*/
    ) {
        NavGraph(
            it.calculateBottomPadding().value,
            navController,
        )
    }
}


