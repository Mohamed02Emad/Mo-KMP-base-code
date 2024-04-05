package com.mo.newbase.core.base

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.koin.core.component.KoinComponent

open class BaseViewModel : ViewModel(), KoinComponent {

    private var _showToastState = MutableStateFlow<String?>(null)
    val showToastState: StateFlow<String?> = _showToastState

    suspend fun <Response> handleResponse(
        responseState: RequestState<Response>,
        onError: suspend (String) -> Unit = {},
        onSpecificErrors: suspend (Errors) -> Unit = {},
        onNotAuthorized: (suspend (String) -> Unit)? = null,
        onSuccess: suspend (Response) -> Unit = {},
    ){
        if (responseState is RequestState.Success) {
            onSuccess(responseState.data)
        }else if (responseState is RequestState.Error){
            if (responseState.statusCode == 401) {
                if (onNotAuthorized == null) {
                    onError(responseState.message)
                } else {
                    onNotAuthorized(responseState.message)
                }
            }else{
                onError(responseState.message)
            }
            responseState.errors?.let{
                onSpecificErrors(it)
            }
        }

    }

    fun showToast(message: String){
        _showToastState.value= message
    }

    fun resetToast() {
        _showToastState.value = null
    }

}