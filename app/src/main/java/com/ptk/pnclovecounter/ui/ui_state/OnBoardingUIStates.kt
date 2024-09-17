package com.ptk.pnclovecounter.ui.ui_state


data class OnBoardingUIStates(
    val firstNickName: String = "Athet",
    val secondNickName: String = "Athel",
    val firstDOB: String = "",
    val secondDOB: String = "",
    val anniversaryDate: String = "",

    val isShowNNQuestion: Boolean = false,
    val isShowResult : Boolean = false,

    val result : String = "",
)