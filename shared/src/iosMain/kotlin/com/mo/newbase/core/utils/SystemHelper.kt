package com.mo.newbase.core.utils

import platform.Foundation.NSLocale
import platform.Foundation.countryCode
import platform.Foundation.currentLocale
import platform.Foundation.languageCode


actual val currentLang:String?
    get() = NSLocale.currentLocale.languageCode

actual val currentCountry:String?
    get() = NSLocale.currentLocale.countryCode