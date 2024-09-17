package com.ptk.pnclovecounter.ui.ui_resource.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CustomAnimatedVisibility(
    isVisible: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    AnimatedVisibility(
        visible = isVisible,
        enter = slideInHorizontally(
            initialOffsetX = { -1000 },
            animationSpec = tween(durationMillis = 2000)
        ),
        exit = slideOutHorizontally(
            targetOffsetX = { 1000 },
            animationSpec = tween(durationMillis = 1000)
        )
    ) {
        content.invoke()
    }

}
