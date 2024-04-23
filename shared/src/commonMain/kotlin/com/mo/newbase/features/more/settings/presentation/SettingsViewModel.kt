package com.mo.newbase.features.more.settings.presentation

import com.mo.newbase.core.base.BaseViewModel
import com.mo.newbase.features.more.settings.domain.models.Languages
import com.mo.newbase.features.more.settings.domain.useCases.ChangeDarkModeUseCase
import com.mo.newbase.features.more.settings.domain.useCases.ChangeLanguageBody
import com.mo.newbase.features.more.settings.domain.useCases.ChangeLanguageUseCase
import com.mo.newbase.features.more.settings.domain.useCases.GetDarkModeUseCase
import com.mo.newbase.features.more.settings.domain.useCases.GetLanguageUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.inject

class SettingsViewModel : BaseViewModel() {
    private val getDarkModeUseCase: GetDarkModeUseCase by inject()
    private val changeDarkModeUseCase: ChangeDarkModeUseCase by inject()
    private val changeLanguageUseCase: ChangeLanguageUseCase by inject()
    private val getLanguageUseCase: GetLanguageUseCase by inject()

    private var _darkMode = MutableStateFlow(false)
    val darkMode: StateFlow<Boolean> = _darkMode

    private var _language = MutableStateFlow(Languages.system)
    val language: StateFlow<Languages> = _language

    private suspend fun getDarkMode() {
        val darkMode = getDarkModeUseCase()
        _darkMode.value = darkMode
    }
    private suspend fun getLanguage() {
        val languageString = getLanguageUseCase()
        _language.value = Languages.valueOf(languageString)
    }

    fun setDarkMode(isEnabled: Boolean) {
        viewModelScope.launch {
            changeDarkModeUseCase(isEnabled)
            _darkMode.value = isEnabled
        }
    }

    fun setLanguage(language: Languages) {
        viewModelScope.launch {
            changeLanguageUseCase(ChangeLanguageBody(language))
            _language.value = language
        }
    }

    suspend fun initData() {
        getDarkMode()
        getLanguage()
    }


}