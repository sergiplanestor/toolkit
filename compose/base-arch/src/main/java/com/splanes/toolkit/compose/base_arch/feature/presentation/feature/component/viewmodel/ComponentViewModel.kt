package com.splanes.toolkit.compose.base_arch.feature.presentation.feature.component.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.splanes.toolkit.compose.base_arch.feature.domain.feature.usecase.UseCase
import com.splanes.toolkit.compose.base_arch.feature.presentation.feature.component.contract.UiEvent
import com.splanes.toolkit.compose.base_arch.feature.presentation.feature.component.contract.UiModel
import com.splanes.toolkit.compose.base_arch.feature.presentation.feature.component.contract.UiSideEffect
import com.splanes.toolkit.compose.base_arch.feature.presentation.feature.component.contract.UiState
import com.splanes.toolkit.compose.base_arch.feature.presentation.feature.component.contract.utils.uiStateUninitialized
import com.splanes.toolkit.compose.base_arch.feature.presentation.feature.component.viewmodel.utils.flowCollect
import com.splanes.toolkit.compose.base_arch.feature.presentation.feature.component.viewmodel.utils.ioContext
import com.splanes.toolkit.compose.base_arch.feature.presentation.feature.component.viewmodel.utils.launch
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlin.coroutines.CoroutineContext

abstract class ComponentViewModel<Model : UiModel, Event : UiEvent, SideEffect : UiSideEffect> :
    ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Job() + Dispatchers.Default

    protected val uiStateAtStart: UiState<Model> by lazy { uiStateUninitialized() }

    private val uiStateMutableState: MutableState<UiState<Model>> = mutableStateOf(uiStateAtStart)
    private val uiEventMutableSharedFlow: MutableSharedFlow<Event> = MutableSharedFlow()
    private val uiSideEffectChannel: Channel<SideEffect> = Channel()

    val uiState: State<UiState<Model>> get() = uiStateMutableState
    val uiSideEffect: Flow<SideEffect> get() = uiSideEffectChannel.receiveAsFlow()

    init { onSubscribeUiEvents() }

    abstract fun onUiEventHandled(uiEvent: Event)

    fun onUiEvent(uiEvent: Event) {
        launch { uiEventMutableSharedFlow.emit(uiEvent) }
    }

    protected open fun updateUiState(update: (from: UiState<Model>) -> UiState<Model>) {
        uiStateMutableState.value = update(uiState.value)
    }

    protected open fun onUiSideEffect(builder: () -> SideEffect) {
        launch { uiSideEffectChannel.send(builder()) }
    }

    protected open fun <Params, Data, Result> UseCase<Params, Data>.launch(
        req: UseCase.Request<Params>,
        mapper: UseCase.Result<Data>.() -> Result
    ) {
        launch {
            val result = ioContext { invoke(req) }
            mapper.invoke(result)
        }
    }

    private fun onSubscribeUiEvents() {
        flowCollect(uiEventMutableSharedFlow, onCollected = ::onUiEventHandled)
    }
}