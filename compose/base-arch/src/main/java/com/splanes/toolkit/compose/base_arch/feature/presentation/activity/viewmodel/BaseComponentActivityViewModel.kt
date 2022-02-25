package com.splanes.toolkit.compose.base_arch.feature.presentation.activity.viewmodel

import androidx.compose.ui.graphics.Color
import com.splanes.toolkit.compose.base_arch.feature.presentation.activity.contract.ActivityUiEvent
import com.splanes.toolkit.compose.base_arch.feature.presentation.activity.contract.ActivityUiModel
import com.splanes.toolkit.compose.base_arch.feature.presentation.activity.contract.ActivityUiSideEffect
import com.splanes.toolkit.compose.base_arch.feature.presentation.component.viewmodel.ComponentViewModel
import com.splanes.toolkit.compose.ui.components.feature.dialog.model.DialogUiModel
import com.splanes.toolkit.compose.ui.components.feature.loader.model.LoaderUiModel
import com.splanes.toolkit.compose.ui.components.feature.scaffold.model.ScaffoldColors
import com.splanes.toolkit.compose.ui.components.feature.statusbar.model.StatusBarColors
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseComponentActivityViewModel :
    ComponentViewModel<ActivityUiModel, ActivityUiEvent, ActivityUiSideEffect>() {

    private val _dialogUiModelState: MutableStateFlow<DialogUiModel?> = MutableStateFlow(null)
    private val _snackBarUiModelState: MutableStateFlow<Any?> = MutableStateFlow(null)
    private val _loaderUiModelState: MutableStateFlow<LoaderUiModel?> = MutableStateFlow(null)

    val dialogUiModelState: StateFlow<DialogUiModel?> = _dialogUiModelState.asStateFlow()
    val snackBarUiModelState: StateFlow<Any?> =_snackBarUiModelState.asStateFlow()
    val loaderUiModelState: StateFlow<LoaderUiModel?> = _loaderUiModelState.asStateFlow()

    override fun onUiEventHandled(uiEvent: ActivityUiEvent) {
        when (uiEvent) {
            is ActivityUiEvent.ShowDialog -> onUiSideEffect {
                ActivityUiSideEffect.ShowDialog(
                    uiEvent.dialogUiModel
                )
            }
            is ActivityUiEvent.ShowSnackBar -> onUiSideEffect {
                ActivityUiSideEffect.ShowSnackBar(
                    uiEvent.snackBarUiModel
                )
            }
            is ActivityUiEvent.ShowLoader -> onUiSideEffect {
                ActivityUiSideEffect.ShowLoader(
                    uiEvent.loaderUiModel
                )
            }
            else -> onCustomUiEventHandled(uiEvent)
        }
    }

    protected open fun onCustomUiEventHandled(uiEvent: ActivityUiEvent) {
        // Nothing to do here
    }

    fun onDialogStateChanged(uiModel: DialogUiModel?) {
        _dialogUiModelState.value = uiModel
    }

    fun onSnackBarStateChanged(uiModel: Any?) {
        _snackBarUiModelState.value = uiModel
    }

    fun onLoaderStateChanged(uiModel: LoaderUiModel?) {
        _loaderUiModelState.value = uiModel
    }

    fun updateStatusBarColors(color: Color) {
        updateStatusBarColors(StatusBarColors(color))
    }

    fun updateStatusBarColors(colors: StatusBarColors) {
        updateUiModel { from -> from.copy(statusBarColors = colors) }
    }

    fun updateScaffoldColors(colors: ScaffoldColors) {
        updateUiModel { from -> from.copy(scaffoldColors = colors) }
    }
}