package com.mo.newbase.di.viewModelsModule

import com.mo.newbase.SharedViewModel
import com.mo.newbase.features.more.settings.presentation.SettingsViewModel
import com.mo.newbase.features.onBoarding.presentation.OnBoardingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module


actual val viewModelsModule: Module = module {

    viewModel {
        OnBoardingViewModel()
    }
    viewModel {
        SharedViewModel()
    }
    viewModel {
        SettingsViewModel()
    }
}
