package com.splanes.toolkit.compose.base_arch.feature.presentation.feature.activity.base

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.splanes.toolkit.compose.ui.theme.UiTheme.AppTheme


fun ComponentActivity.setAppThemeContent(content: @Composable () -> Unit) {
    setContent {
        AppTheme {
            content()
        }
    }
}
