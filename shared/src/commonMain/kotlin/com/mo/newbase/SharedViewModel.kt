package com.mo.newbase

import com.mo.newbase.core.base.BaseViewModel
import com.mo.newbase.core.navigation.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.koin.core.component.KoinComponent

class SharedViewModel : BaseViewModel(), KoinComponent {

//    private val getGuestLogInUseCase: GetGuestLogInUseCase by inject()
//    private val getUserLoggedInUseCase: GetUserLoggedInUseCase by inject()
//    private val logOutUseCase: LogoutUseCase by inject()
//    private val getOnBoardingFinishedUseCase: GetOnBoardingFinishedUseCase by inject()
//    private val globalStates: GlobalStates by inject()
//
    private var _startDestination = MutableStateFlow<Screen?>(null)
    val startDestination: StateFlow<Screen?> = _startDestination
//
//    private var _logoutState = MutableStateFlow<RequestState<BaseResponse>?>(null)
//    val logoutState: StateFlow<RequestState<BaseResponse>?> = _logoutState
//
    private var _isGuest = MutableStateFlow(false)
    val isGuest: StateFlow<Boolean> = _isGuest


//    init {
//        runBlocking {
//            _isGuest.value = getGuestLogInUseCase()
//        }
//    }

//    fun getIsGuest(): Boolean {
//        return isGuest.value
//    }

    suspend fun getStartDestination() {
//        val isLoggedIn = getUserLoggedInUseCase()
//        val isOnBoardingFinished = getOnBoardingFinishedUseCase()
        val isLoggedIn = false
        val isOnBoardingFinished = false
        if (isOnBoardingFinished.not()) {
            _startDestination.value = Screen.OnBoarding
        } else if (isLoggedIn.not() && isGuest.value.not()) {
            _startDestination.value = Screen.Login
        } else {
            _startDestination.value = Screen.Home
        }
    }
//
//    fun logOut() {
//        viewModelScope.launch {
//            _logoutState.value = RequestState.Loading
//            val responseState = logOutUseCase()
//            handleResponse(
//                responseState = responseState,
//                onSuccess = {
//                    getStartDestination()
//                    globalStates.get().showToast(it.message.toString())
//                },
//                onError = {
//                    globalStates.get().showToast(it)
//                }
//            )
//            _logoutState.value = responseState
//        }
//    }

}