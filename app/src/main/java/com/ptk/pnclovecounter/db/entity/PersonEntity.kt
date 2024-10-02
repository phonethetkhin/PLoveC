package com.ptk.pnclovecounter.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_person")
data class PersonEntity(
    @ColumnInfo(name = "person_id")
    @PrimaryKey(autoGenerate = false) val personId: Int = 0,

    @ColumnInfo(name = "nick_name") val nickName: String? = null,

    @ColumnInfo(name = "age") val age: Int? = null,

    @ColumnInfo(name = "gender") val gender: Int = 0,

    @ColumnInfo(name = "birthday") val birthday: String? = null,

    @ColumnInfo(name = "zodiac_sign") val zodiacSign: String? = null,

    @ColumnInfo(name = "profile_picture") val profilePicture: String? = null,
)

