package com.example.featuremultimoduleapp.articlesdata.datasource

import com.example.featuremultimoduleapp.articlesdata.model.ArticleResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IArticlesApi {

    // e.g - https://dev.to/api/articles
    @GET("articles")
    suspend fun getArticles(): Response<List<ArticleResponse>>

    // e.g - https://dev.to/api/articles/1895988
    @GET("articles/{articleId}")
    suspend fun getArticleDetail(@Path("articleId") articleId: Int)
}