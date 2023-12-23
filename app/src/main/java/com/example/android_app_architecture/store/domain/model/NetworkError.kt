package com.example.android_app_architecture.store.domain.model

import java.lang.Error

data class NetworkError(
    val error: ApiError,
    val throwable: Throwable?=null
)

enum class ApiError(val message:String){
    NetworkError("Network Error"),
    UnknownResponse("Unknown Response"),
    UnknownError("UnknownError"),

}
