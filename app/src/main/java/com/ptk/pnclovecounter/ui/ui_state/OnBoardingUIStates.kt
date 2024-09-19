package com.ptk.pnclovecounter.ui.ui_state


data class OnBoardingUIStates(
    val firstNickName: String = "Athet",
    val secondNickName: String = "Athel",

    val anniversaryDate: String = "06/05/2024",

    val result: String = "",

    val firstDOB: String = "29/06/1997",
    val secondDOB: String = "15/04/1996",

    val isShowNNQuestion: Boolean = false,
    val isShowResult: Boolean = false,
    val isShowDobs: Boolean = false,
    val isShowAnniDate: Boolean = false,
)