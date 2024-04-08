package com.mo.newbase.features.more.settings.domain.useCases

import com.mo.newbase.features.more.settings.domain.models.Languages
import com.mo.newbase.features.more.settings.domain.repositories.SettingsRepository
import org.koin.core.component.KoinComponent

class ChangeLanguageUseCase(private val repository: SettingsRepository) : KoinComponent {
    suspend operator fun invoke(body: ChangeLanguageBody) {
        repository.changeLanguage(body)
    }
}

data class ChangeLanguageBody(val language: Languages)
