package com.ptk.pnclovecounter.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import com.ptk.pnclovecounter.repository.HomeRepository
import com.ptk.pnclovecounter.ui.ui_state.DrawerUIStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DrawerViewModel @Inject constructor(
    private val context: Application,
) : ViewModel() {

    val _uiStates = MutableStateFlow(DrawerUIStates())
    val uiStates = _uiStates.asStateFlow()


    fun toggleDrawerState() {
        _uiStates.update { it.copy(isDrawerOpen = !_uiStates.value.isDrawerOpen) }
    }

}
