package com.mo.newbase.di.settingsModule

import com.mo.newbase.features.more.settings.data.dataSource.SettingsDataSource
import com.mo.newbase.features.more.settings.data.dataSource.SettingsDataSourceImpl
import com.mo.newbase.features.more.settings.data.repositories.SettingsRepositoryImpl
import com.mo.newbase.features.more.settings.domain.repositories.SettingsRepository
import com.mo.newbase.features.more.settings.domain.useCases.ChangeDarkModeUseCase
import com.mo.newbase.features.more.settings.domain.useCases.ChangeLanguageUseCase
import com.mo.newbase.features.more.settings.domain.useCases.GetDarkModeUseCase
import com.mo.newbase.features.more.settings.domain.useCases.GetLanguageUseCase
import org.koin.dsl.module

val settingsModule = module {
    /** data source **/
    single<SettingsDataSource> { SettingsDataSourceImpl(get()) }
    /** repositories **/
    single<SettingsRepository> { SettingsRepositoryImpl(get()) }
    /** use cases **/
    single { ChangeDarkModeUseCase(get()) }
    single { GetDarkModeUseCase(get()) }
    single { ChangeLanguageUseCase(get()) }
    single { GetLanguageUseCase(get()) }
}