package com.mo.newbase.core.base

import kotlinx.serialization.Serializable

@Serializable
data class Errors(
    val email : List<String>? = null,
    val password : List<String>? = null,
    val code : List<String>? = null,
    val message : List<String>? = null,
)
