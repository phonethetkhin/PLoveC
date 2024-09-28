package com.ptk.pnclovecounter.ui.ui_resource.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.EaseInOutBack
import androidx.compose.animation.core.EaseOutBounce
import androidx.compose.animation.core.EaseOutCirc
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
            animationSpec = tween(durationMillis = 1000, easing = EaseOutCirc)
        ),
        exit = slideOutHorizontally(
            targetOffsetX = { 1000 },
            animationSpec = tween(durationMillis = 500)
        )
    ) {
        content.invoke()
    }

}

@Composable
fun CustomAnimatedVisibility(
    isVisible: Boolean,
    enterTransition: EnterTransition,
    exitTransition: ExitTransition,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    AnimatedVisibility(
        visible = isVisible,
        enter = enterTransition,
        exit = exitTransition
    ) {
        content.invoke()
    }

}
