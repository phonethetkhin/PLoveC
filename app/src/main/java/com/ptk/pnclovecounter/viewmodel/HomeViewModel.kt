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

   /* suspend fun updateNickName(personId: Int, nickname: String) {
        personDao.updateNickName()
    }*/


    // firebase functions

    fun uploadImageToFirebase(uri: Uri) {
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
                }
            }
        }.addOnFailureListener {
            context.showToast("Upload profile photo failed, please try again later.")
        }
    }


}
