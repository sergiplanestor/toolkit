package com.splanes.toolkit.compose.base_arch.feature.presentation.feature.component.contract

sealed interface ComponentContract

interface UiEvent : ComponentContract

interface UiModel : ComponentContract

interface UiSideEffect : ComponentContract

sealed class UiState<out T : UiModel> : ComponentContract {

    val isInitialized: Boolean get() = this !is Uninitialized
    val isReady: Boolean get() = this is Ready
    val isError: Boolean get() = this is Error
    val isLoading: Boolean get() = this is Loading
    val isNotLoadingNorUninitialized: Boolean get() = isInitialized && !isLoading

    class Uninitialized<out T : UiModel> : UiState<T>()

    data class Ready<out T : UiModel>(val data: T) : UiState<T>()

    data class Loading<out T : UiModel>(
        val startedOn: Long,
        val timeout: Long? = null
    ) : UiState<T>()

    data class Error<out T : UiModel>(val cause: Throwable? = null) : UiState<T>()
}