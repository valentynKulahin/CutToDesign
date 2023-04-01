package com.example.data

import android.content.ClipData
import com.example.data.models.*
import com.example.domain.models.*

fun ItemDataModel.mapToDomain(): ItemDomainModel {
    return ItemDomainModel(itemId, itemName, itemImage)
}

fun ItemsDataModel.mapToDomain(): ItemsDomainModel {
    return ItemsDomainModel(itemList = items.mapToDomain())
}

fun BrandDataModel.mapToDomain(): BrandDomainModel {
    return BrandDomainModel(brandId, brandName, brandImage)
}

fun BrandsDataModel.mapToDomain(): BrandsDomainModel {
    return BrandsDomainModel(brandsList = brandsList.map { it.mapToDomain() })
}

fun UserDataModel.mapToDomain(): UserDomainModel {
    return UserDomainModel(
        userId,
        firstname,
        lastname,
        pmFirstname,
        pmLastname,
        pmTelephone,
        tsFirstname,
        tsLastname,
        tsTelephone,
        balance
    )
}