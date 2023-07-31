package com.mertgolcu.data.datasource.remote.impl

import com.mertgolcu.data.client.NetworkResult
import com.mertgolcu.data.client.requestAndCatch
import com.mertgolcu.data.datasource.remote.ExampleDataSource
import com.mertgolcu.data.model.ExampleResponseModel
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import javax.inject.Inject

/**
 * Created by Mert Gölcü on 31.07.2023
 */

class ExampleDataSourceImpl @Inject constructor(
    private val client: HttpClient
) : ExampleDataSource {
    override suspend fun getExample(): NetworkResult<ExampleResponseModel> {
        return client.requestAndCatch {
            get(GET_EXAMPLE_ENDPOINT)
        }
    }

    companion object {
        const val GET_EXAMPLE_ENDPOINT = "https://example.com"
    }

}