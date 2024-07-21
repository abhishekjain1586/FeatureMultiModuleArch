package com.example.featuremultimoduleapp.common.exception

open class ErrorResponse(val errorMessage: String) : Exception(errorMessage)

class ServerException : ErrorResponse("")

class CustomException(val errorMsg: String, val errorCode: Int) : ErrorResponse(errorMsg)

class CustomException1(val errorMsg: String) : ErrorResponse(errorMsg)
