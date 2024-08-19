package com.ptk.pnclovecounter.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.ptk.pnclovecounter.R
import com.ptk.pnclovecounter.ui.ui_resource.composable.ProfileCard
import ir.kaaveh.sdpcompose.sdp

@Composable
fun HomeScreen(navHostController: NavHostController, modifier: Modifier = Modifier) {

    HomeScreenContent()

}

@Composable
fun HomeScreenContent(modifier: Modifier = Modifier) {
    Surface(color = MaterialTheme.colorScheme.onSurface, modifier = modifier.fillMaxSize()) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.inlove),
                contentDescription = "inlove photo",
                contentScale = ContentScale.FillHeight,
                modifier = modifier
                    .fillMaxWidth()
                    .height(200.sdp)
            )
            ProfileCard()

        }
    }
}

