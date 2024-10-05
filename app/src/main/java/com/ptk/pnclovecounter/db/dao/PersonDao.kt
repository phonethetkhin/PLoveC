package com.ptk.pnclovecounter.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ptk.pnclovecounter.db.entity.PersonEntity

@Dao
interface PersonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPerson(person: PersonEntity)

    @Query("SELECT * FROM tbl_person")
    suspend fun getAllPersons(): List<PersonEntity>

    @Query("SELECT * FROM tbl_person WHERE person_id=:id")
    suspend fun getPerson(id: Int): PersonEntity

}