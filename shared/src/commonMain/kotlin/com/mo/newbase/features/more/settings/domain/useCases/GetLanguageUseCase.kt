package com.mo.newbase.features.more.settings.domain.useCases

import com.mo.newbase.features.more.settings.domain.repositories.SettingsRepository
import org.koin.core.component.KoinComponent

class GetLanguageUseCase(private val repository: SettingsRepository) : KoinComponent {
    suspend operator fun invoke(): String {
        return repository.getLanguage()
    }
}

