package com.example.featuremultimoduleapp

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import com.example.featuremultimoduleapp.loginui.ui.LoginActivity
import com.example.featuremultimoduleapp.mediator.IMediator
import javax.inject.Inject

class AppMediator @Inject constructor() : IMediator {

    override fun navigateToArticles(context: Context) {
        ContextCompat.startActivity(
            context,
            Intent(context, LoginActivity::class.java),
            null
        )
    }

    override fun navigateToLogin() {

    }
}