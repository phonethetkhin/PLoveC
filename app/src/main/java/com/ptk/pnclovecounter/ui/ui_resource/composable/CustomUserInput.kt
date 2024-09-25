@file:OptIn(ExperimentalMaterial3Api::class)

package com.ptk.pnclovecounter.ui.ui_resource.composable

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.ptk.pnclovecounter.util.Constants
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp


@Composable
fun RowScope.CustomUserInput(
    label: String,
    value: String,
    isError: Boolean = false,
    errorMessage: String = "",
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
        isError = isError,
        supportingText = { if (isError) Text(errorMessage) else Text("") },
        textStyle = TextStyle(fontFamily = Constants.lemon, fontSize = 16.ssp),
        trailingIcon = { if (isError) Icon(Icons.Filled.Info, "ErrorIcon", tint = Color.Red) },
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            errorTextColor = Color.Black,
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