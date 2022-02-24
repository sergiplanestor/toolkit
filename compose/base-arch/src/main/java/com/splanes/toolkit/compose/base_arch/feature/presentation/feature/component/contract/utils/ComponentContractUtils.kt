package com.splanes.toolkit.compose.base_arch.feature.presentation.feature.component.contract.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.splanes.toolkit.compose.base_arch.feature.presentation.feature.component.contract.UiEvent
import com.splanes.toolkit.compose.base_arch.feature.presentation.feature.component.contract.UiModel
import com.splanes.toolkit.compose.base_arch.feature.presentation.feature.component.contract.UiSideEffect
import com.splanes.toolkit.compose.base_arch.feature.presentation.feature.component.contract.UiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

fun <T: UiModel> uiStateUninitialized() : UiState.Uninitialized<T> = UiState.Uninitialized()

object EmptyUiEvent: UiEvent

object EmptyUiSideEffect: UiSideEffect

val uiSideEffectKeyDefault: String by lazy { "LaunchedSideEffect.DefaultKey" }

@Composable
fun UiSideEffect(
    key: String = uiSideEffectKeyDefault,
    consumer: suspend CoroutineScope.() -> Unit
) {
    LaunchedEffect(key, consumer)
}

@Composable
fun <T> UiSideEffect(
    flow: Flow<T>,
    key: String = uiSideEffectKeyDefault,
    consumer: T.() -> Unit
) {
    UiSideEffect(key) { flow.onEach { effect -> consumer.invoke(effect) }.collect() }
}