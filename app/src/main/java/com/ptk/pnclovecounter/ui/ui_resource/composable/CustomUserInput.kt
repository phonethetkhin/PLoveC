@file:OptIn(ExperimentalMaterial3Api::class)

package com.ptk.pnclovecounter.ui.ui_resource.composable

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.ptk.pnclovecounter.util.Constants
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp


@Composable
fun RowScope.CustomUserInput(
    label: String,
    value: String,
    onValChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {


    TextField(
        value = value,
        onValueChange = { onValChange.invoke(it) },
        label = { Text(label) },
        modifier = modifier.weight(1F),
        shape = RoundedCornerShape(16.sdp),
        maxLines = 1,
        singleLine = true,

        textStyle = TextStyle(fontFamily = Constants.lemon, fontSize = 16.ssp),
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            cursorColor = Color.Black,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedLabelColor = Color.Gray,
            unfocusedLabelColor = Color.Gray,
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White
        )
    )
}