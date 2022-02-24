package com.splanes.toolkit.compose.ui.components.feature.dialog.model

import androidx.compose.ui.graphics.vector.ImageVector

sealed interface DialogUiModel {
    val icon: ImageVector? get() = null
    val title: String? get() = null
    val positiveButtonText: String
    val isVisible: Boolean get() = false
    val isCancellable: Boolean get() = true

    interface Error : DialogUiModel
    interface Info: DialogUiModel
    interface Confirmation: DialogUiModel
    interface Binary: DialogUiModel
    interface Tertiary: DialogUiModel
    interface Custom: DialogUiModel
}