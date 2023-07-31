package com.mertgolcu.data.datasource.remote

import com.mertgolcu.data.model.ExampleResponseModel

/**
 * Created by Mert Gölcü on 31.07.2023
 */

class ExampleDataSource {
    fun getExample()=ExampleResponseModel(
        id = 1,
        name = "Mert",
        surname = "Gölcü",
        age = 23,
        version = 1,
        createdAt = "31.07.2023"
    )
}