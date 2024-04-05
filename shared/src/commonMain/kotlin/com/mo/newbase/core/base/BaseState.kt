package com.mo.newbase.core.base


sealed class BaseState<out Data> {
    data class Initial<out Data>(val data: Data) : BaseState<Data>()
    object Loading : BaseState<Nothing>()
    data class Error(val message: String) : BaseState<Nothing>()
    data class Success<out Data>(val data: Data) : BaseState<Data>()
}


