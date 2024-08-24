package com.ptk.pnclovecounter.ui.ui_resource.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.ptk.pnclovecounter.R
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Composable
fun ProfileCard(modifier: Modifier = Modifier) {
    Column {
        Image(
            painter = painterResource(id = R.drawable.boyavatar),
            contentDescription = "profile photo",
            modifier = modifier
                .clip(CircleShape)
                .size(120.sdp)
        )
        Spacer(modifier = modifier.height(4.sdp))
        Text(
            text = "Phone",
            color = Color.White,
            fontSize = 23.ssp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = modifier.height(4.sdp))

        Row {
            AgeCard()
            Spacer(modifier = modifier.width(4.sdp))
            ZodiacCard()
        }
    }
}