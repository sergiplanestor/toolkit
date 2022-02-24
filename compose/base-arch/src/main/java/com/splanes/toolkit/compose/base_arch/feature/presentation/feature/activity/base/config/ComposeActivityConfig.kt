package com.splanes.toolkit.compose.base_arch.feature.presentation.feature.activity.base.config

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.splanes.toolkit.compose.base_arch.feature.presentation.feature.activity.statusbar.StatusBarUiModel

data class ComposeActivityConfig(
    val statusBarUiModel: StatusBarUiModel? = null,
    val containerColor: @Composable () -> Color = { MaterialTheme.colorScheme.background },
    val contentColor: @Composable () -> Color = { contentColorFor(containerColor()) },
)
