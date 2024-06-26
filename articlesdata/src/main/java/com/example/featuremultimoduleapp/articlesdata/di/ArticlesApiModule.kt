package com.example.featuremultimoduleapp.articlesdata.di

import com.example.featuremultimoduleapp.articlesdata.datasource.IArticlesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ArticlesApiModule {

    @Singleton
    @Provides
    fun providesArticlesApi(retrofit: Retrofit): IArticlesApi {
        return retrofit.create(IArticlesApi::class.java)
    }
}