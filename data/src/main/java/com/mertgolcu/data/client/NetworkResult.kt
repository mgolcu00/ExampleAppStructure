package com.mertgolcu.data.client

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Created by Mert Gölcü on 31.07.2023
 */

sealed class NetworkResult<T> {
    data class Success<T>(val body: T) : NetworkResult<T>()
    data class Error<T>(val error: kotlin.Error) : NetworkResult<T>()
}

fun <T> NetworkResult<T>.asFlow(): Flow<T> = flow {
    val data = (this@asFlow as NetworkResult.Success).body
    emit(data)
}