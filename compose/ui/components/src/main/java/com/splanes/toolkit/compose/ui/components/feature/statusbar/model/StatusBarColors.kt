package com.splanes.toolkit.compose.ui.components.feature.statusbar.model

import androidx.compose.ui.graphics.Color
import com.splanes.toolkit.compose.ui.components.common.utils.color.isLighterColor

data class StatusBarColors(
    val container: Color,
    val isDarkIconsEnabled: Boolean = container.isLighterColor(),
    val transformation: ((Color) -> Color)? = null
)