package com.example.featuremultimoduleapp.articlesdomain.usecase

import android.util.Log
import com.example.featuremultimoduleapp.articlesdomain.repository.IArticlesRepository
import javax.inject.Inject

class GetArticlesUseCase @Inject constructor(
    private val articlesRepository: IArticlesRepository
) {

    suspend operator fun invoke() {
        Log.d("testingggg", "ArticlesRepository - ${articlesRepository.hashCode()}")
        articlesRepository.getArticles()
    }
}