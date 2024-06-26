package com.example.featuremultimoduleapp.logindata.di

import com.example.featuremultimoduleapp.logindata.datasource.ILoginApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LoginApiModule {

    @Singleton
    @Provides
    fun providesLoginApi(retrofit: Retrofit): ILoginApi {
        return retrofit.create(ILoginApi::class.java)
    }
}