package com.example.featuremultimoduleapp.articlesdomain.usecase

import com.example.featuremultimoduleapp.articlesdomain.repository.IArticlesRepository
import javax.inject.Inject

class GetArticleDetailUseCase @Inject constructor(
    private val articlesRepository: IArticlesRepository
) {

    suspend operator fun invoke(articleId: Int) {
        articlesRepository.getArticleDetail(articleId)
    }
}