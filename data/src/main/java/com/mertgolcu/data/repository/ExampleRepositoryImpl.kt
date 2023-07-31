package com.mertgolcu.data.repository

import com.mertgolcu.data.datasource.remote.ExampleDataSource
import com.mertgolcu.data.mapper.toDomainModel
import com.mertgolcu.domain.model.Example
import com.mertgolcu.domain.repository.ExampleRepository

/**
 * Created by Mert Gölcü on 31.07.2023
 */

class ExampleRepositoryImpl (val exampleDataSource: ExampleDataSource): ExampleRepository {
    override fun getExample(): Example {
        return exampleDataSource.getExample().toDomainModel()
    }
}