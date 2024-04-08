package com.mo.newbase.features.more.settings.domain.useCases

import com.mo.newbase.features.more.settings.domain.repositories.SettingsRepository
import org.koin.core.component.KoinComponent

class ChangeDarkModeUseCase(private val repository: SettingsRepository) : KoinComponent {
    suspend operator fun invoke(isEnabled : Boolean) {
        repository.changeDarkMode(isEnabled)
    }
}

