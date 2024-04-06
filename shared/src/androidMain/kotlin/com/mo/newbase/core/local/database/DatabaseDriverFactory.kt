package com.mo.newbase.core.local.database

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.mo.newbase.MyDataBase

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = MyDataBase.Schema,
            context = context,
            name = "MyDataBase.db"
        )
    }
}