package com.splanes.toolkit.compose.ui.components.common.utils.color

import androidx.annotation.FloatRange
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver

fun Color.composite(other: Color, @FloatRange(from = 0.0, to = 1.0) alpha: Double): Color =
    composite(other, alpha.toFloat())

fun Color.composite(other: Color, @FloatRange(from = 0.0, to = 1.0) alpha: Float): Color =
    alpha(alpha).compositeOver(other)