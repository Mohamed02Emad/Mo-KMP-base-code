package com.mo.newbase.features.onBoarding.domain.useCases

import com.mo.newbase.features.onBoarding.domain.repositories.OnBoardingRespository
import org.koin.core.component.KoinComponent

class GetOnBoardingFinishedUseCase(private val repository: OnBoardingRespository) : KoinComponent {
    suspend operator fun invoke(): Boolean {
        return repository.getIsOnBoardingFinished()
    }

}