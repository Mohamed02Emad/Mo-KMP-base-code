package com.mo.newbase.core.base


sealed class RequestState<out Response > {
    data object Loading : RequestState<Nothing>()
    data class Error(val message: String, val statusCode : Int? = null , val errors: Errors? = null) : RequestState<Nothing>()
    data class NotAuthorized(val message: String, val statusCode : Int? = null , val errors: Errors? = null) : RequestState<Nothing>()
    data class Success<out Response>(val data: Response , val statusCode: Int) : RequestState<Response>()
}


