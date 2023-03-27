package com.example.data.repos

import com.example.domain.repos.AuthorizationRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthorizationRepositoryImpl @Inject constructor(
    val dataStoreRepositoryImpl: DataStoreRepositoryImpl
) : AuthorizationRepo {

    override suspend fun getRoute(): String {
        TODO("Not yet implemented")
    }

    override suspend fun getToken(): String {
        TODO("Not yet implemented")
    }


}