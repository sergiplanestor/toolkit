package com.splanes.toolkit.compose.base_arch.feature.presentation.activity.contract

import com.splanes.toolkit.compose.base_arch.feature.presentation.component.contract.UiEvent
import com.splanes.toolkit.compose.base_arch.feature.presentation.component.contract.UiModel
import com.splanes.toolkit.compose.base_arch.feature.presentation.component.contract.UiSideEffect
import com.splanes.toolkit.compose.ui.components.feature.dialog.model.DialogUiModel
import com.splanes.toolkit.compose.ui.components.feature.loader.model.LoaderUiModel
import com.splanes.toolkit.compose.ui.components.feature.scaffold.model.ScaffoldColors
import com.splanes.toolkit.compose.ui.components.feature.statusbar.model.StatusBarColors

open class ActivityUiModel(
    open val statusBarColors: StatusBarColors,
    open val scaffoldColors: ScaffoldColors
) : UiModel {

    fun copy(
        statusBarColors: StatusBarColors = this.statusBarColors,
        scaffoldColors: ScaffoldColors = this.scaffoldColors
    ): ActivityUiModel =
        ActivityUiModel(
            statusBarColors = statusBarColors,
            scaffoldColors = scaffoldColors
        )
}

interface ActivityUiEvent : UiEvent {
    open class ShowDialog(open val dialogUiModel: DialogUiModel) : ActivityUiEvent
    open class ShowSnackBar(open val snackBarUiModel: Any /* TODO */) : ActivityUiEvent
    open class ShowLoader(open val loaderUiModel: LoaderUiModel) : ActivityUiEvent
}

interface ActivityUiSideEffect : UiSideEffect {
    open class ShowDialog(open val dialogUiModel: DialogUiModel) : ActivityUiSideEffect
    open class ShowSnackBar(open val snackBarUiModel: Any /* TODO */) : ActivityUiSideEffect
    open class ShowLoader(open val loaderUiModel: LoaderUiModel) : ActivityUiSideEffect
}