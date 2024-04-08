package com.mo.newbase.features.more.settings.domain.repositories

import com.mo.newbase.features.more.settings.domain.useCases.ChangeLanguageBody

interface SettingsRepository {
    suspend fun changeDarkMode(isEnabled : Boolean)
    suspend fun changeLanguage(languageString: ChangeLanguageBody)
    suspend fun getLanguage():String
    suspend fun getDarkMode(): Boolean

}