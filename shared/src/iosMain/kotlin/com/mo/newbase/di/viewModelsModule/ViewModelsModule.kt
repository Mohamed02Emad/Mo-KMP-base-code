package com.mo.newbase.di.viewModelsModule

import com.mo.newbase.SharedViewModel
import com.mo.newbase.features.more.settings.presentation.SettingsViewModel
import com.mo.newbase.features.onBoarding.presentation.OnBoardingViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.module.Module
import org.koin.dsl.module

actual val viewModelsModule: Module = module {

    single {
        OnBoardingViewModel()
    }
    single {
        SharedViewModel()
    }
    single {
        SettingsViewModel()
    }
}

object KoinHelper : KoinComponent {
    fun getOnBoardingViewModel() = get<OnBoardingViewModel>()
    fun getSharedViewModel() = get<SharedViewModel>()
    fun getSettingsViewModel() = get<SettingsViewModel>()
}

