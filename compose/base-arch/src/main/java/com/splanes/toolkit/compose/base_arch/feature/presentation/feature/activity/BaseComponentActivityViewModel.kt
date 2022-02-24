package com.splanes.toolkit.compose.base_arch.feature.presentation.feature.activity

import androidx.compose.ui.graphics.Color
import com.splanes.toolkit.compose.base_arch.feature.presentation.feature.component.viewmodel.ComponentViewModel
import com.splanes.toolkit.compose.ui.components.feature.scaffold.model.ScaffoldColors
import com.splanes.toolkit.compose.ui.components.feature.statusbar.model.StatusBarColors

abstract class BaseComponentActivityViewModel :
    ComponentViewModel<ActivityUiModel, ActivityUiEvent, ActivityUiSideEffect>() {

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

    fun updateStatusBarColors(color: Color) {
        updateUiModel { from -> from.copy(statusBarColors = StatusBarColors(color)) }
    }

    fun updateScaffoldColors(colors: ScaffoldColors) {
        updateUiModel { from -> from.copy(scaffoldColors = colors) }
    }
}