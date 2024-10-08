package com.ptk.pnclovecounter.ui.ui_resource.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import ir.kaaveh.sdpcompose.ssp
import kotlinx.coroutines.delay
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Composable
fun RealTimeClock() {
    var currentTime by remember { mutableStateOf(LocalTime.now()) }
    val timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss")

    LaunchedEffect(Unit) {
        while (true) {
            currentTime = LocalTime.now()
            delay(1000L)  // Delay for 1 second
        }
    }

    Text(
        text = currentTime.format(timeFormatter),
        fontSize = 36.ssp
    )
}