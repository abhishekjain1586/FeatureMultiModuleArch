package com.example.featuremultimoduleapp.common.utils

import com.example.featuremultimoduleapp.common.exception.ErrorResponse

sealed class Resource<T> {
    data class Success<T>(val data: T?) : Resource<T>()
    data class Failure<T>(val errorResponse: ErrorResponse) : Resource<T>()
    //data class Error<T>(val errMessage: String?) : Resource<T>()
}