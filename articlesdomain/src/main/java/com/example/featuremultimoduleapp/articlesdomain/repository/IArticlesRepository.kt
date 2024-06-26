package com.example.featuremultimoduleapp.articlesdomain.repository

interface IArticlesRepository {

    suspend fun getArticles()

    suspend fun getArticleDetail(articleId: Int)
}