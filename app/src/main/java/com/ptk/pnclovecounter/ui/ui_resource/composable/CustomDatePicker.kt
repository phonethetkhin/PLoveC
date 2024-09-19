package com.ptk.pnclovecounter.ui.ui_resource.composable

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import com.ptk.pnclovecounter.util.Constants
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp
import java.util.Calendar


@Composable
fun RowScope.CustomDatePicker(
    selectedDob: String,
    modifier: Modifier = Modifier,
    changeDob: (String) -> Unit,
) {

    // Get current date
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    // Create a DatePickerDialog
    val datePickerDialog = DatePickerDialog(
        LocalContext.current,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            changeDob.invoke("$dayOfMonth/${month + 1}/$year")
        },
        year,
        month,
        day
    )

    TextField(
        value = selectedDob,
        modifier = modifier,
        onValueChange = {},
        label = { Text("Date of Birth") },
        shape = RoundedCornerShape(16.sdp),
        maxLines = 1,
        singleLine = true,
        readOnly = true,
        textStyle = TextStyle(fontFamily = Constants.lemon, fontSize = 12.ssp),
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
        ),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = "DateIcon",
                modifier = modifier.clickable {
                    datePickerDialog.show()
                })
        }
    )
}
