package com.mo.newbase.features.onBoarding.domain.repositories

interface OnBoardingRespository{
    suspend fun setIsOnBoardingFinished(isOnBoardingFinished: Boolean)
    suspend fun getIsOnBoardingFinished():Boolean
}