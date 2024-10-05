package com.ptk.pnclovecounter.ui.ui_resource.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.ptk.pnclovecounter.ui.ui_resource.theme.LemonFontFamily
import com.ptk.pnclovecounter.ui.ui_resource.theme.Purple
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Composable
fun ZodiacCard(zodiacName: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(32.sdp),  // Apply rounded corners
        colors = CardDefaults.cardColors(containerColor = Purple) // Set background color here
    ) {

        Text(
            zodiacName,
            color = Color.White,
            fontSize = 10.ssp,
            fontFamily = LemonFontFamily,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(horizontal = 8.sdp, vertical = 4.sdp)
        )
    }
}