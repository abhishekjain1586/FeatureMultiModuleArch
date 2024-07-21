package com.example.featuremultimoduleapp.common.extensions

import com.example.featuremultimoduleapp.common.exception.ErrorResponse
import com.example.featuremultimoduleapp.common.exception.ServerException
import com.example.featuremultimoduleapp.common.utils.Resource
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import retrofit2.Response

fun <T, R> Response<T>.toResource(transform: (T?) -> R): Resource<R> {
    if (isSuccessful) {
        return Resource.Success(transform(body()))
    }

    if (errorBody() != null) {
        try {
            Json.parseToJsonElement(errorBody()!!.string())
            return Resource.Failure(ErrorResponse(errorBody()!!.string()))
        } catch (ex: SerializationException) {
            throw ServerException()
        }
    }

    throw ServerException()
}
