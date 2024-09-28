package com.ptk.pnclovecounter.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.ptk.pnclovecounter.ui.ui_resource.navigation.Routes
import com.ptk.pnclovecounter.ui.ui_state.OnBoardingUIStates
import com.ptk.pnclovecounter.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
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
            if (isFirstNickName) it.copy(firstNickName = nickName, isFNickNameEmpty = false)
            else it.copy(secondNickName = nickName, isSNickNameEmpty = false)
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
        _uiStates.update { it.copy(anniversaryDate = anniDate, isAnniWrong = false) }
    }

    fun changeDob(isFirstDOB: Boolean, dob: String) {
        _uiStates.update {
            if (isFirstDOB) it.copy(firstDOB = dob, isFDOBWrong = false)
            else it.copy(secondDOB = dob, isSDOBWrong = false)
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

    fun goNextPage(navController: NavController) {
        viewModelScope.launch {
            val pagerState = _uiStates.value.pagerState

            when (pagerState.currentPage) {
                0 -> {
                    if (_uiStates.value.firstNickName.isEmpty() || _uiStates.value.secondNickName.isEmpty()) {
                        _uiStates.update {
                            it.copy(
                                isFNickNameEmpty = _uiStates.value.firstNickName.isEmpty(),
                                isSNickNameEmpty = _uiStates.value.secondNickName.isEmpty(),
                            )
                        }
                        Toast.makeText(context, "Nicknames cannot be empty", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        pagerState.scrollToPage(pagerState.currentPage + 1)
                    }
                }

                1 -> {
                    if (_uiStates.value.firstDOB.isEmpty() || _uiStates.value.secondDOB.isEmpty()) {
                        Toast.makeText(
                            context,
                            "Dates of birth cannot be empty",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    } else if (_uiStates.value.firstDOB != "29/6/1997" || _uiStates.value.secondDOB != "15/4/1996") {
                        Toast.makeText(context, "Wrong Dates of Birth", Toast.LENGTH_SHORT)
                            .show()
                        _uiStates.update {
                            it.copy(
                                isFDOBWrong = _uiStates.value.firstDOB != "29/6/1997",
                                isSDOBWrong = _uiStates.value.secondDOB != "15/4/1996"
                            )
                        }
                    } else {
                        pagerState.scrollToPage(pagerState.currentPage + 1)
                    }
                }

                2 -> {
                    if (_uiStates.value.anniversaryDate.isEmpty()) {
                        Toast.makeText(
                            context,
                            "Anniversary date cannot be empty",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    } else if (_uiStates.value.anniversaryDate != "6/5/2024") {
                        Toast.makeText(context, "Wrong Anniversary", Toast.LENGTH_SHORT)
                            .show()
                        _uiStates.update { it.copy(isAnniWrong = _uiStates.value.anniversaryDate != "6/5/2024") }
                    } else {
                        navController.navigate(Routes.HomeScreen.route) {
                            popUpTo(Routes.OnboardingEnquiryScreen.route) { inclusive = true }
                        }
                    }
                }
            }
        }
    }


}
