package com.splanes.toolkit.compose.base_arch.feature.presentation.feature.activity.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.splanes.toolkit.compose.base_arch.feature.presentation.feature.activity.statusbar.StatusBarUiModel
import com.splanes.toolkit.compose.base_arch.feature.presentation.feature.activity.statusbar.bind


fun <T> ComposeActivity.updateState(value: T) {
    when (value) {
        is SystemUiController -> { systemUiControllerState.value = value }
        is StatusBarUiModel -> { statusBarState.value = value }
    }
}

@Composable
fun ComposeActivity.StatusBarColor() {
    val uiMode by remember { statusBarState }
    var systemUiController by remember { systemUiControllerState }
    uiMode?.let {
        if (systemUiController == null) {
            systemUiController = rememberSystemUiController()
        }
        systemUiController?.bind(it)
    }
}
