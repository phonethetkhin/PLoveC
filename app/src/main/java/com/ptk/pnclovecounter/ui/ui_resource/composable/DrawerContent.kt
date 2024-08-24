package com.ptk.pnclovecounter.ui.ui_resource.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.ptk.pnclovecounter.R
import com.ptk.pnclovecounter.ui.ui_resource.theme.Purple40
import ir.kaaveh.sdpcompose.sdp

@Composable
fun DrawerContent(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(250.sdp)
            .background(Purple40)
            .padding(16.sdp)
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            tint = Color.White,
            contentDescription = "Back Arrow",
            modifier = modifier.size(30.sdp)

        )
        Spacer(modifier = modifier.height(16.sdp))
        DrawerItem(icon = R.drawable.baseline_home_24, text = "Home")
        DrawerItem(icon = R.drawable.baseline_edit_square_24, text = "Edit Profiles")
        DrawerItem(icon = R.drawable.baseline_image_24, text = "Edit Profiles")
        DrawerItem(icon = R.drawable.baseline_settings_24, text = "Setting")
    }
}