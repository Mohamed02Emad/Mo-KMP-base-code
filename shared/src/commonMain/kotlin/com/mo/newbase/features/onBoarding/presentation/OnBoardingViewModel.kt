package com.mo.newbase.features.onBoarding.presentation

import com.mo.newbase.core.base.BaseViewModel
import com.mo.newbase.features.onBoarding.domain.useCases.SetOnBoardingFinishedUseCase
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class OnBoardingViewModel : BaseViewModel(), KoinComponent {
    private val setOnBoardingFinishedUseCase: SetOnBoardingFinishedUseCase by inject()
//    private val saveFcmTokenUseCase: SaveFcmTokenUseCase by inject()
//
//    private val _onBoardings: MutableStateFlow<List<OnBoardingModel>> =
//        MutableStateFlow(getOnBoardings())
//
//    val onBoardings: StateFlow<List<OnBoardingModel>> = _onBoardings.asStateFlow()

    //    fun setDeviceToken(deviceToken : String?){
//        viewModelScope.launch {
//            saveFcmTokenUseCase(deviceToken)
//        }
//    }
    fun setOnBoardingFinished() {
        viewModelScope.launch {
            setOnBoardingFinishedUseCase(true)
        }
    }
}