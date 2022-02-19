package com.splanes.toolkit.compose.base_arch.feature.presentation.feature.activity.statusbar

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance

data class StatusBarUiModel(
    val color: Color,
    val useDarkIcons: Boolean = color.luminance() > 0.6f,
    val transformation: ((Color) -> Color)? = null
)
