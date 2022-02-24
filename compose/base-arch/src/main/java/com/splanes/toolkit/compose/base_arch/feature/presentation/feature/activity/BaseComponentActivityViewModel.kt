package com.splanes.toolkit.compose.base_arch.feature.presentation.feature.activity

import com.splanes.toolkit.compose.base_arch.feature.presentation.feature.component.viewmodel.ComponentViewModel

abstract class BaseComponentActivityViewModel : ComponentViewModel<ActivityUiModel, ActivityUiEvent, ActivityUiSideEffect>() {

    override fun onUiEventHandled(uiEvent: ActivityUiEvent) {
        TODO("Not yet implemented")
    }


}