package com.mo.newbase.core.remote

import io.ktor.http.content.PartData

/**
 *@author Mohamed Emad
 * request bodies that has multipart inside should implement this interface
 */

interface MultipartData {
    fun toFormData(): List<PartData>
}

