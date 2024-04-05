package com.mo.newbase

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform