package com.ptk.pnclovecounter.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "tbl_person")
data class PersonEntity(
    @ColumnInfo(name = "person_id")
    @PrimaryKey(autoGenerate = true) val personId: Int = 0,

    @ColumnInfo(name = "nick_name") @SerialName("nickName") val nickName: String? = null,

    @ColumnInfo(name = "age") @SerialName("age") val age: Int? = null,

    @ColumnInfo(name = "zodiac_sign") @SerialName("zodiacSign") val zodiacSign: String? = null,
)

