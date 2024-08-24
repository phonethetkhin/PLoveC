@file:OptIn(ExperimentalMaterial3Api::class)

package com.ptk.pnclovecounter.ui.ui_resource.composable

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ir.kaaveh.sdpcompose.sdp
import kotlinx.coroutines.launch

@Composable
fun CustomTopAppBar(drawerState: DrawerState, modifier: Modifier = Modifier) {
    val scope = rememberCoroutineScope()
    TopAppBar(
        title = { Text("") },
        navigationIcon = {
            IconButton(onClick = {
                scope.launch { if (drawerState.isOpen) drawerState.close() else drawerState.open() }
            })
            {
                Icon(
                    Icons.Filled.Menu,
                    contentDescription = "Menu",
                    tint = Color.White,
                    modifier = modifier.size(40.sdp)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFFA484FF)
        )
    )
}
