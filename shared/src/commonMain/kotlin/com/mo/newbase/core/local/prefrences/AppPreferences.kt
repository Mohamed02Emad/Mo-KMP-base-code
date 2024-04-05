package com.mo.newbase.core.local.prefrences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first
import org.koin.core.component.KoinComponent


class AppPreferences(
    private val dataStore: DataStore<Preferences>,
) : KoinComponent {

    companion object {
        const val ON_BOARDING = "onBoarding"
        const val DARK_MODE = "darkMode"
        const val LANGUAGE = "language"
        const val TOKEN = "token"
        const val FCM_TOKEN = "fcm_token"
        const val USER = "user"
        const val LOGIN = "login"
        const val GUEST = "guest"
    }

    suspend fun clear() {
        val passedOnBoarding = getBoolean(ON_BOARDING) ?: false
        val darkMode = getBoolean(DARK_MODE) ?: false
        val languageString = getString(LANGUAGE) ?: "system"
        val fcmToken = getString(FCM_TOKEN)

        dataStore.edit {
            it.clear()
        }
        setBoolean(ON_BOARDING, passedOnBoarding)
        setBoolean(DARK_MODE, darkMode)
        setString(LANGUAGE, languageString)
        fcmToken?.let {
            setString(FCM_TOKEN, it)
        }
    }

    suspend fun setBoolean(key: String, value: Boolean) {
        dataStore.edit {
            it[booleanPreferencesKey(key)] = value
        }
    }

    suspend fun setInt(key: String, value: Int) {
        dataStore.edit {
            it[intPreferencesKey(key)] = value
        }
    }

    suspend fun setString(key: String, value: String) {
        dataStore.edit {
            it[stringPreferencesKey(key)] = value
        }
    }

    suspend fun getBoolean(key: String): Boolean? {
        return dataStore.data.first().toPreferences()[booleanPreferencesKey(key)]
    }

    suspend fun getString(key: String): String? {
        return dataStore.data.first().toPreferences()[stringPreferencesKey(key)]

    }

    suspend fun getInt(key: String): Int? {
        return dataStore.data.first().toPreferences()[intPreferencesKey(key)]
    }

}