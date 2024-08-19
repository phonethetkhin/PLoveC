package com.ptk.pnclovecounter.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ptk.pnclovecounter.db.dao.PersonDao
import com.ptk.pnclovecounter.db.entity.PersonEntity


@Database(
    entities = [
        PersonEntity::class,
    ], version = 1, exportSchema = false
)
abstract class PNCDB : RoomDatabase() {

    abstract fun getPersonDao(): PersonDao
}