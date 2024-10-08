package com.ptk.pnclovecounter.ui.screen.love_date_section

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.ptk.pnclovecounter.ui.ui_resource.composable.GifImage
import com.ptk.pnclovecounter.ui.ui_resource.theme.LemonFontFamily
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Composable
fun LoveDayScreen(inLoveDays: Long, modifier: Modifier = Modifier) {
    LoveDayScreenContent(inLoveDays)
}

@Composable
fun LoveDayScreenContent(inLoveDays: Long, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = modifier.height(32.sdp))
        Box(
            modifier = modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center

        ) {

            GifImage(
                modifier = modifier

            )
            Text(
                text = "In love",
                color = Color.Black,
                fontSize = 30.ssp,
                fontWeight = FontWeight.Bold,
                fontFamily = LemonFontFamily,
                textAlign = TextAlign.Center,
                modifier = modifier.padding(bottom = 130.sdp)
            )
            Text(
                text = "$inLoveDays\n\ndays",
                color = Color.Black,
                fontSize = 30.ssp,
                fontWeight = FontWeight.Bold,
                fontFamily = LemonFontFamily,
                textAlign = TextAlign.Center,
                modifier = modifier.padding(top = 60.sdp)
            )


        }
    }
}