package com.mertgolcu.exampleappstructure.features.example

import com.mertgolcu.domain.usecase.ExampleUseCase

/**
 * Created by Mert Gölcü on 31.07.2023
 */

class ExampleViewModel(private val exampleUseCase: ExampleUseCase) {

    fun getExample() {
        exampleUseCase.invoke().let {

        }
    }
}