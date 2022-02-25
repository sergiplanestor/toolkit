package com.splanes.toolkit.compose.base_arch.feature.presentation.component.viewmodel.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.splanes.toolkit.compose.base_arch.feature.presentation.component.contract.UiEvent
import com.splanes.toolkit.compose.base_arch.feature.presentation.component.contract.UiModel
import com.splanes.toolkit.compose.base_arch.feature.presentation.component.contract.UiSideEffect
import com.splanes.toolkit.compose.base_arch.feature.presentation.component.contract.UiState
import com.splanes.toolkit.compose.base_arch.feature.presentation.component.viewmodel.ComponentViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

inline val ViewModel.scope: CoroutineScope get() = viewModelScope

fun ViewModel.launch(
    context: CoroutineContext = Dispatchers.Default,
    block: suspend CoroutineScope.() -> Unit
) {
    scope.launch(context = context, block = block)
}

fun <T> ViewModel.flowCollect(
    flow: Flow<T>,
    collectContext: CoroutineContext = Dispatchers.Default,
    onCollected: suspend (T) -> Unit
) {
    launch(collectContext) { flow.collect { onCollected(it) } }
}

suspend fun <T> ViewModel.ioContext(block: suspend CoroutineScope.() -> T): T =
    withContext(Dispatchers.IO, block)

suspend fun <T> ViewModel.mainContext(block: suspend CoroutineScope.() -> T): T =
    withContext(Dispatchers.Main, block)

suspend fun <T> ViewModel.defaultContext(block: suspend CoroutineScope.() -> T): T =
    withContext(Dispatchers.Default, block)

fun <M : UiModel, E : UiEvent, SE : UiSideEffect> ComponentViewModel<M, E, SE>.updateUiStateIf(
    condition: Boolean = uiState.value is UiState.Ready,
    update: (from: UiState<M>) -> UiState<M>
): UiState<M> =
    if (condition) {
        update(uiState.value)
    } else {
        uiState.value
    }
