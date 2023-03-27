package com.example.data.api

import androidx.datastore.dataStore
import com.example.data.repos.DataStoreRepositoryImpl
import com.example.domain.repos.DataStoreRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitHelper @Inject constructor(
    private val dataStoreRepositoryImpl: DataStoreRepositoryImpl
) {

    private fun provideLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(provideLoggingInterceptor())
            .build()

    private val scope = CoroutineScope(Dispatchers.IO)
    private var base_url: String = ""

    fun getInstance(): Retrofit {
        scope.launch { base_url = dataStoreRepositoryImpl.getRouteApi().toString() }
        return Retrofit.Builder().baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkHttpClient())
            .build()
    }

}