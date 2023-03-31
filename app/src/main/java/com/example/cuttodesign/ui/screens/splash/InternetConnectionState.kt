package com.example.cuttodesign.ui.screens.splash

sealed class InternetConnectionState {
    object Available : InternetConnectionState()
    object Unavailable : InternetConnectionState()
}
