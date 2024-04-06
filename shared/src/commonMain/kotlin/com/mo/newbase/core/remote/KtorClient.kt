package com.mo.newbase.core.remote

import com.mo.newbase.core.SharedStates
import com.mo.newbase.core.base.BaseResponse
import com.mo.newbase.core.base.RequestState
import com.mo.newbase.core.local.prefrences.AppPreferences
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.util.InternalAPI
import org.koin.core.component.KoinComponent

@InternalAPI
class KtorClient(
    val httpClient: HttpClient,
    val globalStates: SharedStates,
    val preferences: AppPreferences,
) : KoinComponent {
    suspend inline fun get(url: String, token: String? = null): HttpResponse {
        return httpClient.get("$BaseUrl$url") {
            headers {
                append(HttpHeaders.Accept, ContentType.Application.Json.toString())
                token?.let {
                    append(HttpHeaders.Authorization, "Bearer $it")
                }
            }
        }
    }

    suspend inline fun post(
        url: String,
        token: String? = null,
        body: Any? = null,
    ): HttpResponse {
        return httpClient.post("$BaseUrl$url") {
            headers {
                token?.let {
                    append(HttpHeaders.Authorization, "Bearer $it")
                }
            }
            contentType(ContentType.Application.Json)
            body?.let {
                setBody(body)
            }
        }
    }


    suspend inline fun postMultipart(
        url: String,
        token: String? = null,
        body: Any?,
    ): HttpResponse {
        throw Exception()
    }


    suspend inline fun put(
        url: String,
        token: String? = null,
        body: Any? = null,
    ): HttpResponse {
        return httpClient.put("$BaseUrl$url") {
            headers {
                append(HttpHeaders.Accept, ContentType.Application.Json.toString())
                token?.let {
                    append(HttpHeaders.Authorization, "Bearer $it")
                }
            }
            body?.let {
                contentType(ContentType.Application.Json)
                setBody(body)
            }
        }
    }

    suspend inline fun putMultipart(
        url: String,
        token: String? = null,
        body: Any?,
    ): HttpResponse {
        throw Exception()
    }


    suspend inline fun delete(url: String, token: String? = null): HttpResponse {
        return httpClient.delete("$BaseUrl$url") {
            headers {
                append(HttpHeaders.Accept, ContentType.Application.Json.toString())
                token?.let {
                    append(HttpHeaders.Authorization, "Bearer $it")
                }
            }
        }
    }

    suspend inline fun <reified Response : BaseResponse> handleRequestState(
        response: HttpResponse,
    ): RequestState<Response> {
        return when (response.status.value) {
            200 -> RequestState.Success(data = response.body<Response>(), statusCode = 200)
            401 -> {
                preferences.clear()
                globalStates.get().getStartDestination()
                RequestState.NotAuthorized(
                    message = response.body<Response>().message.toString(),
                    statusCode = response.status.value,
                    errors = response.body<Response>().errors
                )
            }

            else -> RequestState.Error(
                message = response.body<Response>().message.toString(),
                statusCode = response.status.value,
                errors = response.body<Response>().errors
            )
        }
    }


}