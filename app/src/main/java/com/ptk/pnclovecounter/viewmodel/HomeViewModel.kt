package com.ptk.pnclovecounter.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import com.ptk.pnclovecounter.db.dao.PersonDao
import com.ptk.pnclovecounter.db.entity.PersonEntity
import com.ptk.pnclovecounter.ui.ui_state.HomeUIStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val context: Application,
    private val personDao: PersonDao,
) : ViewModel() {

    private val _uiStates = MutableStateFlow(HomeUIStates())
    val uiStates = _uiStates.asStateFlow()


    //=======================================db function=========================================//

    suspend fun insertPerson(personEntity: PersonEntity) {
        personDao.insertPerson(personEntity)
    }



}
