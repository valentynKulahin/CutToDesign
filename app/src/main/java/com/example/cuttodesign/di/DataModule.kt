package com.example.cuttodesign.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.example.data.datastore.DataStorePref
import com.example.data.repos.AuthorizationRepositoryImpl
import com.example.data.repos.DataStoreRepositoryImpl
import com.example.domain.repos.AuthorizationRepo
import com.example.domain.repos.DataStoreRepo
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
    fun providesAuthorizationRepo(
        dataStoreRepositoryImpl: DataStoreRepositoryImpl
    ): AuthorizationRepo {
        return AuthorizationRepositoryImpl(
            dataStoreRepositoryImpl = dataStoreRepositoryImpl
        )
    }

    @Provides
    @Singleton
    fun providesDataStoreRepo(
        dataStore: DataStore<Preferences>
    ): DataStoreRepo {
        return DataStoreRepositoryImpl(
            dataStore = dataStore
        )
    }

//    @Provides
//    @Singleton
//    fun providesRetrofitHelper(
//        dataStore: DataStore<Preferences>
//    ): DataStorePref {
//        return DataStoreRepositoryImpl(
//            dataStore = dataStore
//        )
//    }

}