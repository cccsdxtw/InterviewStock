package com.hi.interviewstock.di

import com.hi.interviewstock.data.remote.ApiRetrofitProvider
import com.hi.interviewstock.data.remote.BwlbbuAllService
import com.hi.interviewstock.data.remote.StockDayAllService
import com.hi.interviewstock.data.remote.StockDayAvgAllService
import com.hi.interviewstock.data.repository.BwlbbuAllRepository
import com.hi.interviewstock.data.repository.StockDayAllRepository
import com.hi.interviewstock.data.repository.StockDayAvgAllRepository
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
        return ApiRetrofitProvider.retrofit
    }

    // 註冊 BwlbbuAllService
    @Provides
    @Singleton
    fun provideBwlbbuAllService(retrofit: Retrofit): BwlbbuAllService {
        return retrofit.create(BwlbbuAllService::class.java)
    }

    // 註冊 StockDayAllService
    @Provides
    @Singleton
    fun provideStockDayAllService(retrofit: Retrofit): StockDayAllService {
        return retrofit.create(StockDayAllService::class.java)
    }

    // 註冊 StockDayAvgAllService
    @Provides
    @Singleton
    fun provideStockDayAvgAllService(retrofit: Retrofit): StockDayAvgAllService {
        return retrofit.create(StockDayAvgAllService::class.java)
    }

    // 註冊 BwlbbuAllRepository
    @Provides
    @Singleton
    fun provideBwlbbuAllRepository(service: BwlbbuAllService): BwlbbuAllRepository {
        return BwlbbuAllRepository(service)
    }

    // 註冊 StockDayAllRepository
    @Provides
    @Singleton
    fun provideStockDayAllRepository(service: StockDayAllService): StockDayAllRepository {
        return StockDayAllRepository(service)
    }

    // 註冊 StockDayAvgAllRepository
    @Provides
    @Singleton
    fun provideStockDayAvgAllRepository(service: StockDayAvgAllService):  StockDayAvgAllRepository {
        return StockDayAvgAllRepository(service)
    }
}
