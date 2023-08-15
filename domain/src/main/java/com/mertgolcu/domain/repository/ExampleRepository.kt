package com.mertgolcu.domain.repository

import com.mertgolcu.domain.model.Example
import com.mertgolcu.domain.util.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by Mert Gölcü on 31.07.2023
 */

interface ExampleRepository {
    suspend fun getExample(): Resource<Example>
    suspend fun getExampleFlow(): Flow<Example>
}