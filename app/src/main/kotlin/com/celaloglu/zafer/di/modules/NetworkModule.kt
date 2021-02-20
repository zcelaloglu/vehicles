package com.celaloglu.zafer.di.modules

import com.celaloglu.zafer.api.ApiService
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    single { provideService(get()) }

    single {
        provideRetrofit(
            get(),
            provideBaseUrl()
        )
    }

    single { provideOkHttpClient() }

}

fun provideOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient.Builder()
        .connectTimeout(20L, TimeUnit.SECONDS)
        .readTimeout(20L, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor).build()
}

fun provideRetrofit(okHttpClient: OkHttpClient, url: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(okHttpClient)
    .build()
}

fun provideRetrofitForTest(okHttpClient: OkHttpClient, url: HttpUrl): Retrofit {
    return Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(okHttpClient)
        .build()
}


fun provideService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

fun provideBaseUrl(): String = "http://private-fe87c-simpleclassifieds.apiary-mock.com/"