package com.mo.newbase

import com.mo.newbase.core.base.BaseViewModel
import org.koin.core.component.KoinComponent

class SharedViewModel : BaseViewModel(), KoinComponent {

//    private val getGuestLogInUseCase: GetGuestLogInUseCase by inject()
//    private val getUserLoggedInUseCase: GetUserLoggedInUseCase by inject()
//    private val logOutUseCase: LogoutUseCase by inject()
//    private val getOnBoardingFinishedUseCase: GetOnBoardingFinishedUseCase by inject()
//    private val globalStates: GlobalStates by inject()
//
//    private var _startDestination = MutableStateFlow<Pair<String, String>?>(null)
//    val startDestination: StateFlow<Pair<String, String>?> = _startDestination
//
//    private var _logoutState = MutableStateFlow<RequestState<BaseResponse>?>(null)
//    val logoutState: StateFlow<RequestState<BaseResponse>?> = _logoutState
//
//    private var _isGuest = MutableStateFlow(false)
//    val isGuest: StateFlow<Boolean> = _isGuest


//    init {
//        runBlocking {
//            _isGuest.value = getGuestLogInUseCase()
//        }
//    }

//    fun getIsGuest(): Boolean {
//        return isGuest.value
//    }

//    suspend fun getStartDestination() {
//        val isLoggedIn = getUserLoggedInUseCase()
//        val isOnBoardingFinished = getOnBoardingFinishedUseCase()
//        if (isOnBoardingFinished.not()) {
//            _startDestination.value = AuthGraph.AUTH_ON_BOARDING_ROUTE.name to "auth"
//        } else if (isLoggedIn.not() && isGuest.value.not()) {
//            _startDestination.value = AuthGraph.AUTH_LOGIN_ROUTE.name to "auth"
//        } else {
//            _startDestination.value = MainGraph.MAIN_HOME_SCREEN_ROUTE.name to "home"
//        }
//    }
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