package com.ptk.pnclovecounter.viewmodel

import android.app.Application
import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.ptk.pnclovecounter.db.dao.PersonDao
import com.ptk.pnclovecounter.ui.ui_state.HomeUIStates
import com.ptk.pnclovecounter.util.PreferencesManager
import com.ptk.pnclovecounter.util.getAnniDate
import com.ptk.pnclovecounter.util.getAnniDateDayOnly
import com.ptk.pnclovecounter.util.showToast
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val context: Application,
    private val personDao: PersonDao,
    private val preferencesManager: PreferencesManager,
) : ViewModel() {

    private val _uiStates = MutableStateFlow(HomeUIStates())
    val uiStates = _uiStates.asStateFlow()

    fun setPersonId(personId: Int) {
        _uiStates.update { it.copy(personId = personId) }
    }

    fun toggleIsShowEditNickNameDialog(isShowEditNickNameDialog: Boolean) {
        _uiStates.update {
            it.copy(
                isShowEditNickNameDialog = isShowEditNickNameDialog,
                person1NickName = _uiStates.value.person1!!.nickName,
                person2NickName = _uiStates.value.person2!!.nickName
            )
        }
    }

    fun toggleNickName(nickname: String) {
        _uiStates.update {
            if (_uiStates.value.personId == 1) {
                it.copy(person1NickName = nickname)
            } else {
                it.copy(person2NickName = nickname)
            }
        }
    }

    //=======================================db function=========================================//

    suspend fun getPersons() {
        _uiStates.update { it.copy(person1 = personDao.getPerson(1)) }
        _uiStates.update { it.copy(person2 = personDao.getPerson(2)) }
    }

    suspend fun getAnniDate() {
        val anniDateStr = preferencesManager.anniDateFlow.first()
        val period = getAnniDate(anniDateStr)
        val days = getAnniDateDayOnly(anniDateStr)

        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val anniDate = LocalDate.parse(anniDateStr, formatter)
        val currentDate = LocalDate.now()


        _uiStates.update {
            it.copy(
                days = days,
                period = period,
                startDate = anniDate,
                endDate = currentDate
            )
        }
    }

    suspend fun updateNickName() {
        val nickName =
            if (_uiStates.value.personId == 1) _uiStates.value.person1NickName else _uiStates.value.person2NickName
        val rowUpdated =
            personDao.updateNickName(personId = _uiStates.value.personId, nickName = nickName)
        if (rowUpdated > 0) {
            context.showToast("Nickname updated successfully")
            getPersons()
        }
    }


    // firebase functions

    fun uploadImageToFirebase(uri: Uri) {
        _uiStates.update { it.copy(isLoading = true) }
        val personId = _uiStates.value.personId
        Log.e("testASDFPTFK123", personId.toString())
        val storageReference: StorageReference = FirebaseStorage.getInstance().reference
        val imageRef = storageReference.child("profile_images/$personId.jpg")

        // Start uploading the image
        val uploadTask = imageRef.putFile(uri)

        // Listen to the upload process
        uploadTask.addOnSuccessListener {
            imageRef.downloadUrl.addOnSuccessListener { downloadUri ->
                context.showToast("Upload successfully")
                viewModelScope.launch {
                    val imageUrl = downloadUri.toString()
                    personDao.updateProfilePicture(personId = personId, profilePicture = imageUrl)

                    getPersons()
                    _uiStates.update { it.copy(isLoading = false) }

                }
            }
        }.addOnFailureListener {
            context.showToast("Upload profile photo failed, please try again later.")
        }
    }


}
