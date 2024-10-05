package com.ptk.pnclovecounter.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import com.ptk.pnclovecounter.db.dao.PersonDao
import com.ptk.pnclovecounter.ui.ui_state.HomeUIStates
import com.ptk.pnclovecounter.util.PreferencesManager
import com.ptk.pnclovecounter.util.getAnniDate
import com.ptk.pnclovecounter.util.getAnniDateDayOnly
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val context: Application,
    private val personDao: PersonDao,
    private val preferencesManager: PreferencesManager,
) : ViewModel() {

    private val _uiStates = MutableStateFlow(HomeUIStates())
    val uiStates = _uiStates.asStateFlow()


    //=======================================db function=========================================//

    suspend fun getPersons() {
        _uiStates.update { it.copy(person1 = personDao.getPerson(1)) }
        _uiStates.update { it.copy(person2 = personDao.getPerson(2)) }
    }

    suspend fun getAnniDate() {
        val anniDate = preferencesManager.anniDateFlow.first()
        val period = getAnniDate(anniDate)
        val days = getAnniDateDayOnly(anniDate)

        _uiStates.update { it.copy(days = days, period = period) }
    }


}
