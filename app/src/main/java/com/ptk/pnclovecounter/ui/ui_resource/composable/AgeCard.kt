package com.ptk.pnclovecounter.ui.ui_resource.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.ptk.pnclovecounter.R
import com.ptk.pnclovecounter.ui.ui_resource.theme.LemonFontFamily
import com.ptk.pnclovecounter.ui.ui_resource.theme.Pink
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Composable
fun AgeCard(age: Int, gender: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(32.sdp),  // Apply rounded corners
        colors = CardDefaults.cardColors(containerColor = Pink) // Set background color here
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 8.sdp, vertical = 4.sdp)
        ) {
            Icon(
                painter = if (gender == "Male") {
                    painterResource(id = R.drawable.male_gender_symbol_variant_svgrepo_com)
                } else {
                    painterResource(id = R.drawable.female_sign_svgrepo_com)
                },
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(20.sdp)
            )
            Spacer(modifier = modifier.width(4.sdp))
            Text("$age", color = Color.White, fontSize = 16.ssp, fontFamily = LemonFontFamily, fontWeight = FontWeight.Bold)
        }
    }
}