package com.mertgolcu.data.mapper

import com.mertgolcu.data.model.ExampleResponseModel
import com.mertgolcu.domain.model.Example

/**
 * Created by Mert Gölcü on 31.07.2023
 */

fun ExampleResponseModel.toDomainModel()=Example(
    id = id,
    name = name,
    surname = surname,
    age = age
)