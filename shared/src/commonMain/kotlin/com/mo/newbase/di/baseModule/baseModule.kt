package com.mo.newbase.di.baseModule

import co.touchlab.kermit.Logger.Companion.d
import com.mo.newbase.core.SharedStates
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.createdAtStart
import org.koin.core.module.dsl.withOptions
import org.koin.dsl.module

val baseModule = module {
    single {
        HttpClient {
            expectSuccess = false
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                    isLenient = true
                })
            }
            install(HttpTimeout) {
                requestTimeoutMillis = 13000
            }
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        d(
                            tag = "HTTP_CLIENT",
                            messageString = message
                        )
                    }
                }
                level = LogLevel.ALL
            }
        }
    } withOptions {
        createdAtStart()
    }

    single { SharedStates() } withOptions { createdAtStart() }

}