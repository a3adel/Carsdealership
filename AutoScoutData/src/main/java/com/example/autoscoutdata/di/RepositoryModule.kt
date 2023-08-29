package com.example.autoscoutdata.di

import com.example.autoscoutdata.dataSources.MemoryDataSource
import com.example.autoscoutdata.dataSources.NetworkDataSource
import com.example.autoscoutdata.repos.CarsRepImp
import com.example.autoscoutdomain.repos.CarsRepo
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideCarsRepo(
        networkDataSource: NetworkDataSource,
        memoryDataSource: MemoryDataSource
    ): CarsRepo {
        return CarsRepImp(networkDataSource,memoryDataSource)
    }
}