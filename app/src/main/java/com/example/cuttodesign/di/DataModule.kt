package com.example.cuttodesign.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.example.data.api.AuthorizationRetrofitRepo
import com.example.data.api.MainRetrofitRepo
import com.example.data.repos.AuthorizationRepoImpl
import com.example.data.repos.DataStoreRepositoryImpl
import com.example.data.repos.MainRepoImpl
import com.example.data.repos.api.*
import com.example.domain.repos.AuthorizationRepo
import com.example.domain.repos.DataStoreRepo
import com.example.domain.repos.MainRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun providesDataStoreRepo(
        dataStore: DataStore<Preferences>
    ): DataStoreRepo {
        return DataStoreRepositoryImpl(
            dataStore = dataStore
        )
    }

    @Provides
    @Singleton
    fun providesAuthorizationRetrofitRepo(
        dataStoreRepo: DataStoreRepo
    ): AuthorizationRetrofitRepo {
        return AuthorizationRetrofitRepoImpl(
            dataStoreRepo = dataStoreRepo
        )
    }

    @Provides
    @Singleton
    fun providesMainRetrofitRepo(
        dataStoreRepo: DataStoreRepo
    ): MainRetrofitRepo {
        return MainRetrofitRepoImpl(
            dataStoreRepo = dataStoreRepo
        )
    }

    @Provides
    @Singleton
    fun providesAuthorizationRepo(
        authorizationRetrofitRepo: AuthorizationRetrofitRepo
    ): AuthorizationRepo {
        return AuthorizationRepoImpl(
            authorizationRetrofitRepo = authorizationRetrofitRepo
        )
    }

    @Provides
    @Singleton
    fun providesMainRepo(
        mainRetrofitRepo: MainRetrofitRepo
    ): MainRepo {
        return MainRepoImpl(
            mainRetrofitRepo = mainRetrofitRepo
        )
    }

}