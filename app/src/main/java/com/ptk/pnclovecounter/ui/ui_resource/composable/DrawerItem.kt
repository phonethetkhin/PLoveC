package com.ptk.pnclovecounter.ui.ui_resource.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.ptk.pnclovecounter.R
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Composable
fun DrawerItem(icon: Int, text: String, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 16.sdp)
    ) {

        Icon(
            painter = painterResource(id = icon),
            contentDescription = "Home Icon",
            tint = Color.White,
            modifier = modifier.size(30.sdp)
        )
        Spacer(modifier = modifier.width(16.sdp))
        Text(
            text = text,
            color = Color.White,
            fontSize = 20.ssp, fontWeight = FontWeight.Bold
        )

    }
}