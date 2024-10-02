package com.ptk.pnclovecounter.viewmodel

import com.ptk.pnclovecounter.db.dao.PersonDao
import com.ptk.pnclovecounter.db.entity.PersonEntity
import javax.inject.Inject

class InsertPersonUseCase @Inject constructor(
    private val personDao: PersonDao,
) {
    suspend operator fun invoke(personEntity1: PersonEntity, personEntity2: PersonEntity) {
        // Logic to complete onboarding, e.g., inserting persons into the database
        personDao.insertPerson(personEntity1)
        personDao.insertPerson(personEntity2)
    }
}
