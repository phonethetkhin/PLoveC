package com.ptk.pnclovecounter.ui.ui_resource.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.ptk.pnclovecounter.R
import com.ptk.pnclovecounter.ui.ui_resource.theme.DarkPink
import com.ptk.pnclovecounter.ui.ui_resource.theme.Pink
import ir.kaaveh.sdpcompose.sdp

@Composable
fun LoveProfileSection(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 16.sdp, horizontal = 8.sdp)
    ) {
        ProfileCard()
        Icon(
            painter = painterResource(id = R.drawable.baseline_favorite_24),
            contentDescription = "love icon",
            tint = DarkPink,
            modifier = modifier.align(Alignment.CenterVertically).padding(bottom = 50.sdp)
        )
        ProfileCard()
    }
}