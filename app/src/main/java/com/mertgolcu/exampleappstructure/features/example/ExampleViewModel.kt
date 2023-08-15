package com.mertgolcu.exampleappstructure.features.example

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mertgolcu.domain.model.Example
import com.mertgolcu.domain.usecase.ExampleUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch

/**
 * Created by Mert Gölcü on 31.07.2023
 */

class ExampleViewModel(private val exampleUseCase: ExampleUseCase) : ViewModel() {

    private val _exampleSharedFlow = MutableSharedFlow<Example>()
    val exampleSharedFlow = _exampleSharedFlow.asSharedFlow().shareIn(
        viewModelScope,
        SharingStarted.Lazily, 1
    )

    private val _exampleState = mutableStateOf(ExampleState())
    val exampleState = _exampleState
    fun getExample() {
        viewModelScope.launch {
            exampleUseCase.execute()
                .onEach {
                    _exampleSharedFlow.emit(it)

                    _exampleState.value = _exampleState.value.copy(
                        isLoading = false,
                        exampleData = it
                    )
                }.catch {
                    handleError(it)
                }.launchIn(this)

        }
    }

    private fun handleError(it: Throwable) {
        _exampleState.value = _exampleState.value.copy(
            isLoading = false,
            error = it.localizedMessage ?: "Unknown error"
        )
    }
}

data class ExampleState(
    val exampleData: Example? = null,
    val isLoading: Boolean = false,
    val error: String = ""
)