package com.ptk.pnclovecounter.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import com.ptk.pnclovecounter.repository.HomeRepository
import com.ptk.pnclovecounter.ui.ui_state.ProfileUIStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository,
    private val context: Application,
    ) : ViewModel() {

    val _uiStates = MutableStateFlow(ProfileUIStates())
    val uiStates = _uiStates.asStateFlow()


    //=======================================db function=========================================//

//    suspend fun insertAllSources(sources: List<SourceEntity>) = repository.insertAllSourcesDB(sources)

}
