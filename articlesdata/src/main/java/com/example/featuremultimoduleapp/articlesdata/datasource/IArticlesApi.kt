package com.example.featuremultimoduleapp.articlesdata.datasource

import retrofit2.http.GET
import retrofit2.http.Path

interface IArticlesApi {

    // e.g - https://dev.to/api/articles
    @GET("articles")
    suspend fun getArticles()

    // e.g - https://dev.to/api/articles/1895988
    @GET("articles/{articleId}")
    suspend fun getArticleDetail(@Path("articleId") articleId: Int)
}