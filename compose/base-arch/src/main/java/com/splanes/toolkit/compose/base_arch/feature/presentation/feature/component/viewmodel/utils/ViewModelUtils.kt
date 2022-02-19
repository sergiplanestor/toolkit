package com.splanes.toolkit.compose.base_arch.feature.presentation.feature.component.viewmodel.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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