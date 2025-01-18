package com.hi.interviewstock.di

import com.hi.interviewstock.data.remote.BWIBBUALLRetrofitInstance
import com.hi.interviewstock.data.remote.BWIBBUALLService
import com.hi.interviewstock.data.repository.BWIBBUALLRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return BWIBBUALLRetrofitInstance.retrofit
    }

    @Provides
    @Singleton
    fun provideBWIBBUALLService(retrofit: Retrofit): BWIBBUALLService {
        return retrofit.create(BWIBBUALLService::class.java)
    }

    @Provides
    @Singleton
    fun provideBWIBBUALLRepository(service: BWIBBUALLService): BWIBBUALLRepository {
        return BWIBBUALLRepository(service)
    }
}
