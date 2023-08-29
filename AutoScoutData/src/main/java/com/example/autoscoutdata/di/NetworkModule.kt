package com.example.autoscoutdata.di

import android.content.Context
import com.example.autoscoutdata.BuildConfig
import com.example.autoscoutdata.apiServices.CarsApiService
import com.example.autoscoutdata.utils.ConnectivityService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun provideCarApiService(retrofit: Retrofit): CarsApiService {
        return retrofit.create(CarsApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideConnectivityService(@ApplicationContext context: Context): ConnectivityService {
        return ConnectivityService(context)
    }
}
