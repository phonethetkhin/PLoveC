package com.ptk.pnclovecounter.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import com.ptk.pnclovecounter.ui.ui_state.OnBoardingUIStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val context: Application,
) : ViewModel() {

    val _uiStates = MutableStateFlow(OnBoardingUIStates())
    val uiStates = _uiStates.asStateFlow()


    fun toggleNickName(isFirstNickName: Boolean, nickName: String) {
        if (isFirstNickName)
            _uiStates.update { it.copy(firstNickName = nickName) }
        else
            _uiStates.update { it.copy(secondNickName = nickName) }

    }

}
