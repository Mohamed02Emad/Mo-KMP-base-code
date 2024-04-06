package com.mo.newbase.core

import com.mo.newbase.SharedViewModel
import org.koin.core.component.KoinComponent

expect class SharedStates() : KoinComponent {
    fun get(): SharedViewModel

}