package com.mo.newbase.di.platformModule

import com.mo.newbase.core.local.database.Database
import com.mo.newbase.core.local.database.DatabaseDriverFactory
import com.mo.newbase.core.local.prefrences.AppPreferences
import com.mo.newbase.core.local.prefrences.dataStoreFileName
import com.mo.newbase.core.local.prefrences.getDataStore
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.createdAtStart
import org.koin.core.module.dsl.withOptions
import org.koin.dsl.module

actual val platformModule = module {

    single {
        getDataStore {
            androidContext().filesDir?.resolve(dataStoreFileName)?.absolutePath
                ?: throw Exception("Couldn't get Android Datastore context.")
        }
    } withOptions {
        createdAtStart()
    }

    single { AppPreferences(get()) }

    single {
        Database(
            databaseDriverFactory = get()
        )
    }
    single {
        DatabaseDriverFactory(androidContext())
    }

}