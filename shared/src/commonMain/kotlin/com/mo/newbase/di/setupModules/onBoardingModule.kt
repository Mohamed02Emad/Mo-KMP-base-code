package com.mo.newbase.di.setupModules

import com.mo.newbase.features.onBoarding.data.dataSource.OnBoardingDataSource
import com.mo.newbase.features.onBoarding.data.dataSource.OnBoardingDataSourceImpl
import com.mo.newbase.features.onBoarding.data.repository.OnBoardingRepositoryImpl
import com.mo.newbase.features.onBoarding.domain.repositories.OnBoardingRespository
import com.mo.newbase.features.onBoarding.domain.useCases.GetOnBoardingFinishedUseCase
import com.mo.newbase.features.onBoarding.domain.useCases.SetOnBoardingFinishedUseCase
import org.koin.dsl.module

val onBoardingModule = module {
    /**Data Sources**/
    single<OnBoardingDataSource> { OnBoardingDataSourceImpl(get()) }
    /**Repositories**/
    single<OnBoardingRespository> { OnBoardingRepositoryImpl(get()) }
    /**Use Case**/
    single { GetOnBoardingFinishedUseCase(get()) }
    single { SetOnBoardingFinishedUseCase(get()) }

}