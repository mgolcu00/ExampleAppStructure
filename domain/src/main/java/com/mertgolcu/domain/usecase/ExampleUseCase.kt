package com.mertgolcu.domain.usecase

import com.mertgolcu.domain.model.Example
import com.mertgolcu.domain.repository.ExampleRepository
import com.mertgolcu.domain.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach

/**
 * Created by Mert Gölcü on 31.07.2023
 */

class ExampleUseCase(val repository: ExampleRepository) {
    suspend fun invoke(): Resource<Example> {
        return repository.getExample()
    }

    suspend fun execute() = repository.getExampleFlow()
}