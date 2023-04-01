package com.example.data.api.retrofit

import com.example.data.api.AuthorizationRetrofitRepo
import com.example.data.api.MainRetrofitRepo
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.net.ssl.SSLSocketFactory

object RetrofitHelper {

    private fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    private fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(provideLoggingInterceptor())
            .build()

    fun getInstanceFirst(base_url: String): AuthorizationRetrofitRepo {
        return Retrofit.Builder().baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkHttpClient())
            .build()
            .create(AuthorizationRetrofitRepo::class.java)
    }
    fun getInstanceAuth(base_url: String): AuthorizationRetrofitRepo {
        return Retrofit.Builder().baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkHttpClient())
            .build()
            .create(AuthorizationRetrofitRepo::class.java)
    }

    fun getInstanceMain(base_url: String): MainRetrofitRepo {
        return Retrofit.Builder().baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkHttpClient())
            .build()
            .create(MainRetrofitRepo::class.java)
    }

}