package com.ptk.pnclovecounter.ui.ui_state

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import com.ptk.pnclovecounter.db.entity.PersonEntity
import java.time.Period


data class HomeUIStates(

    val person1: PersonEntity? = null,
    val person2: PersonEntity? = null,

    val period: Period? = null,
    val days: Long = 0,

    val personId: Int = 1,

    val galleryLauncher: ActivityResultLauncher<Intent>? = null,

    )