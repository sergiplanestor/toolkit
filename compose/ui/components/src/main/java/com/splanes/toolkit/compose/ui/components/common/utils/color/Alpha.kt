package com.splanes.toolkit.compose.ui.components.common.utils.color

import androidx.annotation.FloatRange
import androidx.compose.ui.graphics.Color

fun Color.alpha(@FloatRange(from = 0.0, to = 1.0) alpha: Double): Color =
    copy(alpha = alpha.toFloat())