package com.example.data.datastore

import androidx.datastore.preferences.core.stringPreferencesKey

object PreferencesKeys {

    val firstRoutApi = stringPreferencesKey("first_route")
    val appName = stringPreferencesKey("app_name")
    val routeApi = stringPreferencesKey("main_route")
    val app_version = stringPreferencesKey("version")
    val token = stringPreferencesKey("token")

}