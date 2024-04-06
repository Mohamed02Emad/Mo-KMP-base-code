package com.mo.newbase.core.local.database

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.mo.newbase.MainTable
import com.mo.newbase.MyDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow

class Database(databaseDriverFactory: DatabaseDriverFactory) {

    private val database = MyDataBase(databaseDriverFactory.createDriver())

    fun getAll(): Flow<List<MainTable>> =
        database.myDatabaseQueries.selectAll()
            .asFlow()
            .mapToList(Dispatchers.IO)

            //todo add more

}