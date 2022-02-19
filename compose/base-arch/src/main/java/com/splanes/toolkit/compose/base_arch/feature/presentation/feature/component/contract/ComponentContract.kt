package com.splanes.toolkit.compose.base_arch.feature.presentation.feature.component.contract

sealed interface ComponentContract

interface UiEvent : ComponentContract

interface UiModel : ComponentContract

sealed interface UiSideEffect : ComponentContract {
    interface UiEffect : UiSideEffect
    interface UiNavRequest : UiSideEffect
}

sealed class UiState<out T : UiModel> : ComponentContract {
    class Uninitialized<out T : UiModel> : UiState<T>()

    data class Ready<out T : UiModel>(val data: T) : UiState<T>()

    data class Loading<out T : UiModel>(
        val startedOn: Long,
        val timeout: Long? = null
    ) : UiState<T>()

    data class Error<out T : UiModel>(val cause: Throwable? = null) : UiState<T>()
}