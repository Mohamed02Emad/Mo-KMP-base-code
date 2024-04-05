package com.mo.newbase.features.onBoarding.data.repository

import com.mo.newbase.features.onBoarding.data.dataSource.OnBoardingDataSource
import com.mo.newbase.features.onBoarding.domain.repositories.OnBoardingRespository
import org.koin.core.component.KoinComponent


class OnBoardingRepositoryImpl(private val dataSource: OnBoardingDataSource) :
    OnBoardingRespository, KoinComponent {

    override suspend fun setIsOnBoardingFinished(isOnBoardingFinished: Boolean) {
        dataSource.setIsOnBoardingFinished(isOnBoardingFinished)
    }

    override suspend fun getIsOnBoardingFinished(): Boolean {
        return dataSource.getIsOnBoardingFinished() ?: false
    }
}