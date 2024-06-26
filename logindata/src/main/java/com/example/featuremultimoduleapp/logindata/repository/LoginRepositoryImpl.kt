package com.example.featuremultimoduleapp.logindata.repository

import com.example.featuremultimoduleapp.logindata.datasource.ILoginApi
import com.example.featuremultimoduleapp.logindomain.repository.ILoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(private val loginApi: ILoginApi) : ILoginRepository {

    override suspend fun login(userName: String, password: String) {
        loginApi.login()
    }
}