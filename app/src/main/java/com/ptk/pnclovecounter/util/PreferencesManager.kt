package com.ptk.pnclovecounter.util

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton


object PreferencesKeys {
    val IS_FIRST_LAUNCH_KEY = booleanPreferencesKey("is_first_launch")
    val ANNI_DATE = stringPreferencesKey("anni_date")
}

@Singleton
class PreferencesManager @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {

    val isFirstLaunchFlow: Flow<Boolean> = dataStore.data
        .map { preferences ->
            preferences[PreferencesKeys.IS_FIRST_LAUNCH_KEY] ?: true
        }

    suspend fun setFirstLaunch(isFirstLaunch: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.IS_FIRST_LAUNCH_KEY] = isFirstLaunch
        }
    }

    val anniDateFlow: Flow<String> = dataStore.data
        .map { preferences ->
            preferences[PreferencesKeys.ANNI_DATE] ?: "6/5/2024"
        }

    suspend fun setAnniDate(anniDate: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.ANNI_DATE] = anniDate
        }
    }
}
