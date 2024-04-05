package com.mo.newbase.features.onBoarding.domain.useCases

import com.mo.newbase.features.onBoarding.domain.repositories.OnBoardingRespository
import org.koin.core.component.KoinComponent

class SetOnBoardingFinishedUseCase(private val repository: OnBoardingRespository): KoinComponent {
    suspend operator fun invoke(isOnBoardingFinished: Boolean) {
        return repository.setIsOnBoardingFinished(isOnBoardingFinished)
    }

}