package com.ptk.pnclovecounter.ui.ui_resource.navigation

sealed class Routes(val route: String) {
    data object HomeScreen : Routes("/home_screen")
}