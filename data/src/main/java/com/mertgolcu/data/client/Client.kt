package com.mertgolcu.data.client

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse

/**
 * Created by Mert Gölcü on 31.07.2023
 */


suspend inline fun <reified T> HttpClient.requestAndCatch(block: HttpClient.() -> HttpResponse): NetworkResult<T> {
    return runCatching {
        val response = block().body<T>()
        NetworkResult.Success(response)
    }.getOrElse {
        NetworkResult.Error(Error(it))
    }
}

suspend fun <T> NetworkResult<T>.force():T{
    return when (val response = this) {
        is NetworkResult.Success<T> -> response.body
        is NetworkResult.Error<T> -> throw response.error
    }
}