package com.example.featuremultimoduleapp.articlesui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.featuremultimoduleapp.articlesdomain.model.Article
import com.example.featuremultimoduleapp.articlesdomain.usecase.GetArticlesUseCase
import com.example.featuremultimoduleapp.common.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(
    private val articlesUseCase: GetArticlesUseCase
) : ViewModel() {

    private val errorHandler = CoroutineExceptionHandler { _, throwable ->
        Log.d("testingggg", "hello --- ${throwable.message} // ${throwable.cause} // ${throwable.localizedMessage}")
    }

    private val _articles: MutableStateFlow<UiState> = MutableStateFlow(UiState.Loading)
    val articles: StateFlow<UiState> = _articles.asStateFlow()

    init {
        fetchArticles()
    }

    private fun fetchArticles() {
        val job = viewModelScope.launch(errorHandler) {
            val resource = articlesUseCase.invoke()
            when (resource) {
                is Resource.Success -> {
                    populateUI(resource.data)
                }

                is Resource.Failure -> {

                }
            }
        }
    }

    private fun populateUI(articles: List<Article>?) {
        if (!articles.isNullOrEmpty()) {
            _articles.value = UiState.ArticlesLoaded(articles = articles)
        } else {

        }
        _articles.value = articles?.let {
            if (it.isNotEmpty()) {
                UiState.ArticlesLoaded(articles = articles)
            } else {
                UiState.EmptyArticles(message = "")
            }
        } ?: kotlin.run {
            UiState.Error
        }
    }

    sealed class UiState {
        object Loading : UiState()
        data class ArticlesLoaded(
            val articles: List<Article>
        ) : UiState()
        data class EmptyArticles(val message: String) : UiState()
        object Error : UiState()
    }
}