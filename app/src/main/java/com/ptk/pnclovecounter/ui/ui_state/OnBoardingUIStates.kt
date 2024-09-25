package com.ptk.pnclovecounter.ui.ui_state

import androidx.compose.foundation.pager.PagerState


data class OnBoardingUIStates(
    val pagerState: PagerState = PagerState { 3 },

    val firstNickName: String = "Athet",
    val secondNickName: String = "Athel",
    val ourPassword: String = "",

    val anniversaryDate: String = "06/05/2024",

    val result: String = "",

    val firstDOB: String = "29/06/1997",
    val secondDOB: String = "15/04/1996",

    val isShowWelcomeButton: Boolean = false,
    val isShowFavFood: Boolean = false,
    val isShowPassword: Boolean = false,
    val isShowNNQuestion: Boolean = false,
    val isShowResult: Boolean = false,
    val isShowDobs: Boolean = false,
    val isShowAnniDate: Boolean = false,

    val isPasswordError: Boolean = false,
    val pswErrorMessage: String = "",
)