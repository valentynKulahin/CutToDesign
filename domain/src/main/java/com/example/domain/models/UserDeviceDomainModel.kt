package com.example.domain.models

data class UserDeviceDomainModel(
    val userAuthDomainModel: AuthDomainModel,
    val deviceDomainModel: DeviceDomainModel
)
