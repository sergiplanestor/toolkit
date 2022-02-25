package com.splanes.toolkit.compose.base_arch.feature.presentation.component.contract.utils

import com.splanes.toolkit.compose.base_arch.feature.presentation.component.contract.UiModel
import com.splanes.toolkit.compose.base_arch.feature.presentation.component.contract.UiState

inline fun <T : UiModel> UiState<T>.flatMap(
    crossinline onError: (Throwable?) -> Throwable? = { it },
    crossinline onLoading: (UiState.Loading<T>) -> UiState<T> = { it },
    crossinline onUninitialized: () -> UiState<T> = { UiState.Uninitialized() },
    crossinline onReady: (T) -> T = { it },
): UiState<T> = when (this) {
    is UiState.Error -> copy(cause = onError(cause))
    is UiState.Loading -> onLoading(this)
    is UiState.Ready -> copy(data = onReady(data))
    is UiState.Uninitialized -> onUninitialized()
}