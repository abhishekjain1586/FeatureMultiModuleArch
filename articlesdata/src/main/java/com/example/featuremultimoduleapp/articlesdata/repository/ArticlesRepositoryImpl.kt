package com.example.featuremultimoduleapp.articlesdata.repository

import com.example.featuremultimoduleapp.articlesdata.datasource.IArticlesApi
import com.example.featuremultimoduleapp.articlesdata.mapper.ArticlesMapper
import com.example.featuremultimoduleapp.articlesdomain.model.Article
import com.example.featuremultimoduleapp.articlesdomain.repository.IArticlesRepository
import com.example.featuremultimoduleapp.common.extensions.toResource
import com.example.featuremultimoduleapp.common.utils.Resource
import javax.inject.Inject

class ArticlesRepositoryImpl @Inject constructor(
    private val articlesApi: IArticlesApi,
    private val articlesMapper: ArticlesMapper
) : IArticlesRepository {

    override suspend fun getArticles(): Resource<List<Article>?> {
        val response = articlesApi.getArticles()
        return response.toResource(articlesMapper::mapToDomainModel)
    }

    override suspend fun getArticleDetail(articleId: Int) {
        articlesApi.getArticleDetail(articleId = articleId)
    }
}