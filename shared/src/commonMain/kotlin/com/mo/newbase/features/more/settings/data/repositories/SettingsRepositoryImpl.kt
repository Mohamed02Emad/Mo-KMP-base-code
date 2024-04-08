package com.mo.newbase.features.more.settings.data.repositories

import com.mo.newbase.features.more.settings.data.dataSource.SettingsDataSource
import com.mo.newbase.features.more.settings.domain.repositories.SettingsRepository
import com.mo.newbase.features.more.settings.domain.useCases.ChangeLanguageBody
import org.koin.core.component.KoinComponent

class SettingsRepositoryImpl(val dataSource: SettingsDataSource) : SettingsRepository,
    KoinComponent {
    override suspend fun changeDarkMode(isEnabled: Boolean) {
        dataSource.changeDarkMode(isEnabled)
    }

    override suspend fun getDarkMode(): Boolean {
        return dataSource.getDarkMode()

    }

    override suspend fun changeLanguage(languageString: ChangeLanguageBody) {
        dataSource.changeLanguage(languageString)
    }

    override suspend fun getLanguage(): String {
       return dataSource.getLanguage()
    }


}