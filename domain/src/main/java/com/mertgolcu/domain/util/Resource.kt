package com.mertgolcu.domain.util

/**
 * Created by Mert Gölcü on 31.07.2023
 */

sealed class Resource<T> {
    data class Success<T>(val body: T) : Resource<T>()
    data class Error<T>(val error: kotlin.Error) : Resource<T>()
}