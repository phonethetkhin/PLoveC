package com.ptk.pnclovecounter.ui.screen.love_date_section

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ptk.pnclovecounter.viewmodel.HomeViewModel

@Composable
fun ColumnScope.LoveDateSection(
    homeViewModel: HomeViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val homeUIStates by homeViewModel.uiStates.collectAsState()

    LoveDateSectionPager(
        totalDays = homeUIStates.days,
        startDate = homeUIStates.startDate,
        endDate = homeUIStates.endDate,
        period = homeUIStates.period,
        pagerState = homeUIStates.pagerState
    )

}