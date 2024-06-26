package com.example.featuremultimoduleapp.loginui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.featuremultimoduleapp.logindomain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    fun onLogin(userName: String, password: String) {
        viewModelScope.launch {
            loginUseCase.invoke(userName = userName, password = password)
        }
    }
}