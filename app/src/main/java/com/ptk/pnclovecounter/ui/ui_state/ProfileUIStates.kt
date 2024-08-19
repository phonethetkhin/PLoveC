package com.ptk.pnclovecounter.ui.ui_state


data class ProfileUIStates(

    val userName: String = "",
    val themeId: Int = 1,

    val availableTextSize: List<String> = listOf("S", "M", "L"),
    val selectedTextSize: String = "M"




)