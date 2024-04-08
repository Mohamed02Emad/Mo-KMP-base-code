package com.mo.newbase.features.more.settings.data.dataSource

import com.mo.newbase.features.more.settings.domain.useCases.ChangeLanguageBody
import com.mo.newbase.core.local.prefrences.AppPreferences
import org.koin.core.component.KoinComponent

interface SettingsDataSource {
    suspend fun changeDarkMode(isEnabled: Boolean)
    suspend fun changeLanguage(languageString: ChangeLanguageBody)
    suspend fun getDarkMode(): Boolean
    suspend fun getLanguage(): String
}

class SettingsDataSourceImpl(val local: AppPreferences) : SettingsDataSource, KoinComponent {
    override suspend fun changeDarkMode(isEnabled: Boolean) {
        local.setBoolean(AppPreferences.DARK_MODE, isEnabled)
    }

    override suspend fun getDarkMode(): Boolean {
        return local.getBoolean(AppPreferences.DARK_MODE) ?: false
    }

    override suspend fun getLanguage(): String {
        return local.getString(AppPreferences.LANGUAGE) ?: "system"
    }

    override suspend fun changeLanguage(languageString: ChangeLanguageBody) {
        local.setString(AppPreferences.LANGUAGE, languageString.language.name)
    }

}