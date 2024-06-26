package com.example.featuremultimoduleapp.logindata.di

import com.example.featuremultimoduleapp.logindata.repository.LoginRepositoryImpl
import com.example.featuremultimoduleapp.logindomain.repository.ILoginRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class LoginModule {

    @Binds
    abstract fun bindsLoginRepository(loginRepositoryImpl: LoginRepositoryImpl): ILoginRepository
}