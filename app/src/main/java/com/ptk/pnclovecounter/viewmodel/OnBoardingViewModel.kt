package com.ptk.pnclovecounter.viewmodel

import android.app.Application
import android.util.Log
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

    fun toggleIsShowNNQuestion(isShowNNQuestion: Boolean) {
        _uiStates.update { it.copy(isShowNNQuestion = isShowNNQuestion) }
    }

    fun toggleIsShowResult(isShowResult: Boolean) {
        Log.e("testASDFPTK123", "Result : $isShowResult")
        _uiStates.update { it.copy(isShowResult = isShowResult) }
    }

    fun setResult(result: String) {
        _uiStates.update { it.copy(result = result) }
    }


}
