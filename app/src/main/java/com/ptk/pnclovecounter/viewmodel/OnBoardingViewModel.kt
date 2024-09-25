package com.ptk.pnclovecounter.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.ptk.pnclovecounter.ui.ui_resource.navigation.Routes
import com.ptk.pnclovecounter.ui.ui_state.OnBoardingUIStates
import com.ptk.pnclovecounter.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val context: Application,
) : ViewModel() {

    private val _uiStates = MutableStateFlow(OnBoardingUIStates())
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
        _uiStates.update { it.copy(ourPassword = ourPassword, isPasswordError = false) }
    }

    fun toggleIsShowOurPassword(isShowPassword: Boolean) {
        _uiStates.update { it.copy(isShowPassword = isShowPassword) }
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

    fun navigateToOnBoarding(navController: NavController) {
        if (_uiStates.value.ourPassword.isEmpty()) {
            Toast.makeText(context, "Please enter password before proceed", Toast.LENGTH_SHORT)
                .show()
            _uiStates.update {
                it.copy(
                    isPasswordError = true,
                    pswErrorMessage = "Please enter password"
                )
            }
        } else if (_uiStates.value.ourPassword.lowercase(Locale.ROOT) != Constants.ourPassword) {
            Toast.makeText(context, "INCORRECT PASSWORD !!!!!!", Toast.LENGTH_SHORT)
                .show()
            _uiStates.update {
                it.copy(
                    isPasswordError = true,
                    pswErrorMessage = "INCORRECT PASSWORD !!!!!!"
                )
            }
        } else {
            navController.navigate(Routes.OnboardingScreen.route) {
                // Clear the back stack to prevent the user from navigating back to the splash screen
                popUpTo(Routes.OnboardingEnquiryScreen.route) { inclusive = true }
            }
        }
    }


}
