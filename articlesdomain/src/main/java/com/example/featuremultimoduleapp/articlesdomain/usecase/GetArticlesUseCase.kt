package com.example.featuremultimoduleapp.articlesdomain.usecase

import android.util.Log
import com.example.featuremultimoduleapp.articlesdomain.model.Article
import com.example.featuremultimoduleapp.articlesdomain.repository.IArticlesRepository
import com.example.featuremultimoduleapp.common.utils.Resource
import javax.inject.Inject

class GetArticlesUseCase @Inject constructor(
    private val articlesRepository: IArticlesRepository
) {

    suspend operator fun invoke(): Resource<List<Article>?> {
        return articlesRepository.getArticles()
    }
}