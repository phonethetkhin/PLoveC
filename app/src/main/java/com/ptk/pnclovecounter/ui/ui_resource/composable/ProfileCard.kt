package com.ptk.pnclovecounter.ui.ui_resource.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.ptk.pnclovecounter.R
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Composable
fun ProfileCard(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(start = 16.sdp, top = 16.sdp)) {
        Image(
            painter = painterResource(id = R.drawable.boyavatar),
            contentDescription = "profile photo"
        )
        Text(
            text = "Phone",
            color = Color.White,
            fontSize = 30.ssp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Row(modifier = modifier.fillMaxWidth()) {
            AgeCard()
            Spacer(modifier = modifier.width(4.sdp))
            ZodiacCard()
        }
    }
}