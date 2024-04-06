package com.mo.newbase.di.baseModule

import com.mo.newbase.core.SharedStates
import org.koin.core.module.dsl.createdAtStart
import org.koin.core.module.dsl.withOptions
import org.koin.dsl.module

val baseModule = module {
//    single {
//        HttpClient {
//            expectSuccess = false
//            install(ContentNegotiation) {
//                json(Json {
//                    ignoreUnknownKeys = true
//                    prettyPrint = true
//                    isLenient = true
//                })
//            }
//            install(HttpTimeout) {
//                requestTimeoutMillis = 13000
//            }
//            install(Logging) {
//                logger = object : Logger {
//                    override fun log(message: String) {
//                        co.touchlab.kermit.Logger.d(
//                            tag = "HTTP_CLIENT",
//                            messageString = message
//                        )
//                    }
//                }
//                level = LogLevel.ALL
//            }
//        }
//    } withOptions {
//        createdAtStart()
//    }

    single { SharedStates() } withOptions { createdAtStart() }

}