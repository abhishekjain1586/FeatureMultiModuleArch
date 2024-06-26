package com.example.featuremultimoduleapp.articlesdata.di

import com.example.featuremultimoduleapp.articlesdata.repository.ArticlesRepositoryImpl
import com.example.featuremultimoduleapp.articlesdomain.repository.IArticlesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ArticlesModule {

    @Binds
    abstract fun bindsArticlesRepository(
        repositoryImpl: ArticlesRepositoryImpl
    ): IArticlesRepository
}