package com.ptk.pnclovecounter.di

import android.content.Context
import androidx.room.Room
import com.ptk.pnclovecounter.db.PNCDB
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
    fun providesCDGNewsDB(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        PNCDB::class.java,
        "cdg_news.db"
    ).build()

    @Singleton
    @Provides
    fun providesPersonDao(db: PNCDB) = db.getPersonDao()

}