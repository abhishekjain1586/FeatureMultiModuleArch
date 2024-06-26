package com.example.featuremultimoduleapp.logindomain.usecase

import com.example.featuremultimoduleapp.logindomain.repository.ILoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val loginRepository: ILoginRepository) {

    suspend operator fun invoke(userName: String, password: String) {
        loginRepository.login(userName = userName, password = password)
    }
}