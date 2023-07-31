package com.mertgolcu.domain.usecase

import com.mertgolcu.domain.model.Example
import com.mertgolcu.domain.repository.ExampleRepository

/**
 * Created by Mert Gölcü on 31.07.2023
 */

class ExampleUseCase(val repository: ExampleRepository) {
    fun invoke(): Example {
        return repository.getExample()
    }
}