package com.ptk.pnclovecounter.di

import android.content.Context
import androidx.room.Room
import com.ptk.pnclovecounter.db.ChoDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomDatabaseModule {

    @Singleton
    @Provides
    fun providesChoDB(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        ChoDB::class.java,
        "cho.db"
    ).build()

    @Singleton
    @Provides
    fun providesPersonDao(db: ChoDB) = db.personDao()

}