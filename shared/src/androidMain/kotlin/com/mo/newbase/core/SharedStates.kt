package com.mo.newbase.core

import com.mo.newbase.SharedViewModel
import org.koin.core.component.KoinComponent

actual class SharedStates : KoinComponent {
    private var sharedViewModel: SharedViewModel? = null
    actual fun get(): SharedViewModel {
        if (sharedViewModel == null) {
            sharedViewModel = SharedViewModel()
        }
        return sharedViewModel!!
    }

}