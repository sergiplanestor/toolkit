package com.splanes.toolkit.compose.base_arch.feature.presentation.activity.utils

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import com.splanes.toolkit.compose.base_arch.feature.presentation.activity.BaseComponentActivity
import com.splanes.toolkit.compose.base_arch.feature.presentation.activity.contract.ActivityUiSideEffect
import com.splanes.toolkit.compose.base_arch.feature.presentation.activity.viewmodel.BaseComponentActivityViewModel
import com.splanes.toolkit.compose.base_arch.feature.presentation.component.contract.UiSideEffect
import com.splanes.toolkit.compose.ui.components.feature.dialog.model.DialogUiModel
import com.splanes.toolkit.compose.ui.components.feature.loader.model.LoaderUiModel
import com.splanes.toolkit.compose.ui.theme.UiTheme.AppTheme


fun ComponentActivity.setAppThemeContent(content: @Composable () -> Unit) {
    setContent {
        AppTheme {
            content()
        }
    }
}

@Composable
fun <VM : BaseComponentActivityViewModel> BaseComponentActivity<VM>.dialogState(): State<DialogUiModel?> =
    activityViewModel.dialogUiModelState.collectAsState()

@Composable
fun <VM : BaseComponentActivityViewModel> BaseComponentActivity<VM>.snackBarState(): State<Any?> =
    activityViewModel.snackBarUiModelState.collectAsState()

@Composable
fun <VM : BaseComponentActivityViewModel> BaseComponentActivity<VM>.loaderState(): State<LoaderUiModel?> =
    activityViewModel.loaderUiModelState.collectAsState()

suspend fun <VM : BaseComponentActivityViewModel, E : UiSideEffect> BaseComponentActivity<VM>.handleSideEffect(
    effect: E
) {
    when (effect) {
        is ActivityUiSideEffect.ShowDialog -> {

        }
        is ActivityUiSideEffect.ShowSnackBar -> {

        }
        is ActivityUiSideEffect.ShowLoader -> {

        }
    }
}