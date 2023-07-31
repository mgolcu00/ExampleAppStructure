package com.mertgolcu.domain.repository

import com.mertgolcu.domain.model.Example

/**
 * Created by Mert Gölcü on 31.07.2023
 */

interface ExampleRepository {
    fun getExample(): Example
}