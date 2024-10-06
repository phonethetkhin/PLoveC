package com.ptk.pnclovecounter.ui.ui_resource.composable

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.ptk.pnclovecounter.R

@Composable
fun LoadingDialog(showDialog: Boolean) {
    if (showDialog) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))
        val progress by animateLottieCompositionAsState(
            composition, iterations = LottieConstants.IterateForever
        )
        AlertDialog(
            onDismissRequest = {},
            icon = {
                LottieAnimation(
                    composition = composition,
                    progress = { progress }
                )
            },
            title = { Text(text = "Uploading....") },
            confirmButton = {}
        )
    }
}
