package com.example.featuremultimoduleapp.logindomain.repository

interface ILoginRepository {

    suspend fun login(userName: String, password: String)
}