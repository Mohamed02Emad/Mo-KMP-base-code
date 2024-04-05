package com.mo.newbase.core.utils

import com.mo.newbase.di.platformModule.platformModule
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
        modulesList.add(platformModule)
        modules(modulesList)
    }
}