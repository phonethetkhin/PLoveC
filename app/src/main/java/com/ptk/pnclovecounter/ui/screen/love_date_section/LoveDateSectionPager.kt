package com.ptk.pnclovecounter.ui.screen.love_date_section

import LoveClockScreen
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ptk.pnclovecounter.ui.ui_resource.composable.PagerIndicator
import ir.kaaveh.sdpcompose.sdp
import java.time.LocalDate
import java.time.Period


@Composable
fun ColumnScope.LoveDateSectionPager(
    startDate: LocalDate?,
    endDate: LocalDate?,
    totalDays: Long,
    period: Period?,
    pagerState: PagerState,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .weight(1F)
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
        ) { page ->
            when (page) {
                0 -> LoveDayScreen(inLoveDays = totalDays)
                1 -> LoveClockScreen(startDate = startDate, endDate = endDate, period = period)
            }
        }

        PagerIndicator(
            pageCount = 2,
            currentPage = pagerState.currentPage,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(start = 16.sdp, end = 16.sdp, top = 16.sdp, bottom = 18.sdp)
        )
    }


}
