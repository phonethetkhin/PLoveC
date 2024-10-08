package com.ptk.pnclovecounter.ui.ui_state

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.foundation.pager.PagerState
import com.ptk.pnclovecounter.db.entity.PersonEntity
import java.time.LocalDate
import java.time.Period


data class HomeUIStates(

    val person1: PersonEntity? = null,
    val person2: PersonEntity? = null,

    val period: Period? = null,
    val days: Long = 0,
    val startDate: LocalDate? = null,
    val endDate: LocalDate? = null,

    val pagerState: PagerState = PagerState { 2 },

    val personId: Int = 1,

    val galleryLauncher: ActivityResultLauncher<Intent>? = null,

    val isLoading: Boolean = false,
    val person1NickName: String = "",
    val person2NickName: String = "",
    val isShowEditNickNameDialog: Boolean = false,
)