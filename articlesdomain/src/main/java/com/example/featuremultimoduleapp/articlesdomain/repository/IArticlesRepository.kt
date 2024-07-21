package com.example.featuremultimoduleapp.articlesdomain.repository

import com.example.featuremultimoduleapp.articlesdomain.model.Article
import com.example.featuremultimoduleapp.common.utils.Resource

interface IArticlesRepository {

    suspend fun getArticles(): Resource<List<Article>?>

    suspend fun getArticleDetail(articleId: Int)
}