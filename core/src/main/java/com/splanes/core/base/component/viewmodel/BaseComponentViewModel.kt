package com.splanes.core.base.component.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.splanes.core.base.component.contract.UiComponentContract
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlin.coroutines.CoroutineContext

abstract class BaseComponentViewModel<M : UiComponentContract.UiModel, E : UiComponentContract.Event, SE : UiComponentContract.SideEffect> :
    ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Job() + Dispatchers.Main

    protected val uiStateAtStart: UiComponentContract.State<M> by lazy { UiComponentContract.State.Uninitialized() }
    private val uiStateMutableState: MutableState<UiComponentContract.State<M>> = mutableStateOf(uiStateAtStart)
    private val uiEventMutableSharedFlow: MutableSharedFlow<E> = MutableSharedFlow()
    private val uiSideEffectChannel: Channel<SE> = Channel()

    val uiState: State<UiComponentContract.State<M>> get() = uiStateMutableState
    val uiSideEffect: Flow<SE> get() = uiSideEffectChannel.receiveAsFlow()


    init {
        onSubscribeUiEvents()
    }

    abstract fun onUiEventHandled(uiEvent: E)

    fun onUiEvent(uiEvent: E) {
        emit(uiEventMutableSharedFlow, uiEvent)
    }

    protected fun updateUiState(update: (fromUiState: UiComponentContract.State<M>) -> UiComponentContract.State<M>) {
        uiStateMutableState.value = update(uiState.value)
    }

    protected fun onUiSideEffect(builder: () -> SE) {
        send(uiSideEffectChannel, builder())
    }

    private fun onSubscribeUiEvents() {
        collect(uiEventMutableSharedFlow, ::onUiEventHandled)
    }
}