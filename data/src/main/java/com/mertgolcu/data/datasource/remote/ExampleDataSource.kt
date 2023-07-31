package com.mertgolcu.data.datasource.remote

import com.mertgolcu.data.client.NetworkResult
import com.mertgolcu.data.model.ExampleResponseModel

/**
 * Created by Mert Gölcü on 31.07.2023
 */

interface ExampleDataSource {
    suspend fun getExample(): NetworkResult<ExampleResponseModel>
}