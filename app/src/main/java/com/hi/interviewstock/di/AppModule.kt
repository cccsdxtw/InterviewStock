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
@InstallIn(SingletonComponent::class)  // 註冊於單例範圍
object AppModule {

    // 提供 Retrofit 實例
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return ApiRetrofitProvider.retrofit
    }

    // 提供 BwlbbuAllService 實例
    @Provides
    @Singleton
    fun provideBwlbbuAllService(retrofit: Retrofit): BwlbbuAllService {
        return retrofit.create(BwlbbuAllService::class.java)
    }

    // 提供 StockDayAllService 實例
    @Provides
    @Singleton
    fun provideStockDayAllService(retrofit: Retrofit): StockDayAllService {
        return retrofit.create(StockDayAllService::class.java)
    }

    // 提供 StockDayAvgAllService 實例
    @Provides
    @Singleton
    fun provideStockDayAvgAllService(retrofit: Retrofit): StockDayAvgAllService {
        return retrofit.create(StockDayAvgAllService::class.java)
    }

    // 提供 BwlbbuAllRepository 實例
    @Provides
    @Singleton
    fun provideBwlbbuAllRepository(service: BwlbbuAllService): BwlbbuAllRepository {
        return BwlbbuAllRepository(service)
    }

    // 提供 StockDayAllRepository 實例
    @Provides
    @Singleton
    fun provideStockDayAllRepository(service: StockDayAllService): StockDayAllRepository {
        return StockDayAllRepository(service)
    }

    // 提供 StockDayAvgAllRepository 實例
    @Provides
    @Singleton
    fun provideStockDayAvgAllRepository(service: StockDayAvgAllService): StockDayAvgAllRepository {
        return StockDayAvgAllRepository(service)
    }
}
