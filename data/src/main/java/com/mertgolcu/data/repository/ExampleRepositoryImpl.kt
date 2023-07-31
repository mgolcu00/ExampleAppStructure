package com.mertgolcu.data.repository

import com.mertgolcu.data.client.NetworkResult
import com.mertgolcu.data.client.asFlow
import com.mertgolcu.data.datasource.remote.ExampleDataSource
import com.mertgolcu.data.mapper.toDomainModel
import com.mertgolcu.domain.model.Example
import com.mertgolcu.domain.repository.ExampleRepository
import com.mertgolcu.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Created by Mert Gölcü on 31.07.2023
 */

class ExampleRepositoryImpl(private val exampleDataSource: ExampleDataSource) : ExampleRepository {
    override suspend fun getExample(): Resource<Example> =
        when (val response = exampleDataSource.getExample()) {
            is NetworkResult.Success -> {
                Resource.Success(response.body.toDomainModel())
            }

            is NetworkResult.Error -> {
                Resource.Error(response.error)
            }
        }

    override suspend fun getExampleFlow(): Flow<Example> {
        return exampleDataSource.getExample().asFlow().map { it.toDomainModel() }
    }
}