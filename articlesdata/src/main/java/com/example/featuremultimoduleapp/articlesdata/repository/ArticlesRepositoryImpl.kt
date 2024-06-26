package com.example.featuremultimoduleapp.articlesdata.repository

import com.example.featuremultimoduleapp.articlesdata.datasource.IArticlesApi
import com.example.featuremultimoduleapp.articlesdomain.repository.IArticlesRepository
import javax.inject.Inject

class ArticlesRepositoryImpl @Inject constructor(
    private val articlesApi: IArticlesApi
) : IArticlesRepository {

    override suspend fun getArticles() {
        articlesApi.getArticles()
    }

    override suspend fun getArticleDetail(articleId: Int) {
        articlesApi.getArticleDetail(articleId = articleId)
    }
}