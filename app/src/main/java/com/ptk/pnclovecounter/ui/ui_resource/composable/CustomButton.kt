package com.ptk.pnclovecounter.ui.ui_resource.composable

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import com.ptk.pnclovecounter.ui.ui_resource.theme.LemonFontFamily
import com.ptk.pnclovecounter.ui.ui_resource.theme.Purple40
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Composable
fun CustomButton(label: String, onClick: () -> Unit) {

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Purple40
        ),
        border = ButtonDefaults.outlinedButtonBorder.copy(
            brush = SolidColor(Color.White)
        ),
        shape = RoundedCornerShape(16.sdp)
    ) {
        Text(label, fontFamily = LemonFontFamily, fontSize = 16.ssp, color = Color.Black)
    }

}
