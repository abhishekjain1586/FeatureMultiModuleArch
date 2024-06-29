package com.example.featuremultimoduleapp

import android.util.Log
import com.example.featuremultimoduleapp.mediator.IMediator
import javax.inject.Inject

class AppMediator @Inject constructor() : IMediator {

    override fun navigateToArticles() {
        Log.d("testingggg", "Launching Articles")
    }

    override fun navigateToLogin() {

    }
}