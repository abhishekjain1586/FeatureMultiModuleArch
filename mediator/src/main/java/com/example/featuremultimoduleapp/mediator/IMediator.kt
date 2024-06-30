package com.example.featuremultimoduleapp.mediator

import android.content.Context

interface IMediator {

    fun navigateToArticles(context: Context)

    fun navigateToLogin()
}