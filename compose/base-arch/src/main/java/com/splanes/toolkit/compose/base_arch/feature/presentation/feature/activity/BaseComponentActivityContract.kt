package com.splanes.toolkit.compose.base_arch.feature.presentation.feature.activity

import com.splanes.toolkit.compose.base_arch.feature.presentation.feature.component.contract.UiEvent
import com.splanes.toolkit.compose.base_arch.feature.presentation.feature.component.contract.UiModel
import com.splanes.toolkit.compose.base_arch.feature.presentation.feature.component.contract.UiSideEffect

open class ActivityUiModel(
    open val statusBarUiModel: StatusBarUiModel,
    open val scaffoldColors: ScaffoldColors
) : UiModel

interface ActivityUiEvent : UiEvent

interface ActivityUiSideEffect : UiSideEffect {
    open class ShowDialog(dialogUiModel: DialogUiModel) : ActivityUiSideEffect
    open class ShowLoader(loaderUiModel: LoaderUiModel) : ActivityUiSideEffect
}