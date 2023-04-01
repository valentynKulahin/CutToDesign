package com.example.cuttodesign.ui.screens.home

import com.example.domain.models.BrandsDomainModel
import com.example.domain.models.ItemsDomainModel
import com.example.domain.models.UserDomainModel

data class HomeScreenContract(
    val token: String = "",
    val userDomainModel: UserDomainModel = UserDomainModel(),
    val itemsDomainModel: ItemsDomainModel = ItemsDomainModel(),
    val brandsDomainModel: BrandsDomainModel = BrandsDomainModel()
)