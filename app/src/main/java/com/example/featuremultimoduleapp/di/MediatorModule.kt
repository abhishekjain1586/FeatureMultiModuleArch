package com.example.featuremultimoduleapp.di

import com.example.featuremultimoduleapp.AppMediator
import com.example.featuremultimoduleapp.mediator.IMediator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MediatorModule {

    @Singleton
    @Binds
    abstract fun bindsAppMediator(appMediator: AppMediator): IMediator
}