package com.example.domain.repos

interface AuthorizationRepo {

    suspend fun getRoute(): String

    suspend fun getToken(): String

}