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
        _uiStates.update {
            if (isFirstNickName) it.copy(firstNickName = nickName)
            else it.copy(secondNickName = nickName)
        }
    }

    fun toggleIsShowWelcomeButton(isShowWelcomeButton: Boolean) {
        _uiStates.update { it.copy(isShowWelcomeButton = isShowWelcomeButton) }
    }

    fun toggleIsShowFavFood(isShowFavFood: Boolean) {
        _uiStates.update { it.copy(isShowFavFood = isShowFavFood) }
    }

    fun toggleOurPassword(ourPassword: String) {
        _uiStates.update { it.copy(ourPassword = ourPassword) }
    }
    fun toggleIsShowOurPassword(isShowOurPassword: Boolean) {
        _uiStates.update { it.copy(isShowPassword = isShowOurPassword) }
    }

    fun toggleIsShowNNQuestion(isShowNNQuestion: Boolean) {
        _uiStates.update { it.copy(isShowNNQuestion = isShowNNQuestion) }
    }

    fun toggleIsShowDobs(isShowDobs: Boolean) {
        _uiStates.update { it.copy(isShowDobs = isShowDobs) }
    }


    fun toggleIsShowAnniversaryDate(isShowAnniDate: Boolean) {
        _uiStates.update { it.copy(isShowAnniDate = isShowAnniDate) }
    }


    fun toggleIsShowResult(isShowResult: Boolean) {
        Log.e("testASDFPTK123", "Result : $isShowResult")
        _uiStates.update { it.copy(isShowResult = isShowResult) }
    }

    fun setResult(result: String) {
        _uiStates.update { it.copy(result = result) }
    }

    fun changeAnniDate(anniDate: String) {
        _uiStates.update { it.copy(anniversaryDate = anniDate) }
    }

    fun changeDob(isFirstDOB: Boolean, dob: String) {
        _uiStates.update {
            if (isFirstDOB) it.copy(firstDOB = dob)
            else it.copy(secondDOB = dob)
        }
    }


}
