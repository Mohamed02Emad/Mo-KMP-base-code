package com.mo.newbase.core.utils

import com.mo.newbase.di.baseModule.baseModule
import com.mo.newbase.di.platformModule.platformModule
import com.mo.newbase.di.settingsModule.settingsModule
import com.mo.newbase.di.setupModules.onBoardingModule
import com.mo.newbase.di.viewModelsModule.viewModelsModule
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration

fun initKoin(nativeModule: Module? = null, appDeclaration: KoinAppDeclaration = {}) {
    startKoin {
        appDeclaration()
        val modulesList : ArrayList<Module> = ArrayList()
        nativeModule?.let {
            modulesList.add(it)
        }
        modulesList.add(baseModule)
        modulesList.add(platformModule)
        modulesList.add(settingsModule)
        modulesList.add(viewModelsModule)
        modulesList.add(onBoardingModule)
        modules(modulesList)
    }
}