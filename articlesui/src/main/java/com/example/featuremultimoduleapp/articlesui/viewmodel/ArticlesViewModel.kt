package com.example.featuremultimoduleapp.articlesui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.featuremultimoduleapp.articlesdomain.usecase.GetArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(
    private val articlesUseCase: GetArticlesUseCase
) : ViewModel() {

    init {

    }

    fun getArticles() {
        viewModelScope.launch {
            articlesUseCase.invoke()
        }
    }
}