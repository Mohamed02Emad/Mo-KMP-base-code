package com.mo.newbase.features.onBoarding.data.dataSource

import com.mo.newbase.core.local.prefrences.AppPreferences

interface OnBoardingDataSource {
    suspend fun setIsOnBoardingFinished(
        isOnBoardingFinished: Boolean,
    )
    suspend fun getIsOnBoardingFinished(): Boolean?
}

class OnBoardingDataSourceImpl(private val dataStore: AppPreferences) : OnBoardingDataSource {
    override suspend fun setIsOnBoardingFinished(
        isOnBoardingFinished: Boolean,
    ) {
        dataStore.setBoolean(AppPreferences.ON_BOARDING, isOnBoardingFinished)
    }

    override suspend fun getIsOnBoardingFinished(): Boolean {
        return dataStore.getBoolean(AppPreferences.ON_BOARDING) ?: false
    }

}