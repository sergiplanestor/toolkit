package com.splanes.toolkit.compose.ui.components.common.utils.color

import androidx.annotation.FloatRange
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import com.splanes.toolkit.compose.ui.theme.feature.colors.ThemeColorScheme
import com.splanes.toolkit.compose.ui.theme.utils.accessors.Colors

fun Color.composite(other: Color, @FloatRange(from = 0.0, to = 1.0) alpha: Double = 1.0): Color =
    alpha(alpha).compositeOver(other)

@Composable
fun Color.join(
    alphaBefore: Double? = null,
    alphaAfter: Double? = null,
    alphaOther: Double? = null,
    other: ThemeColorScheme.() -> Color
): Color =
    (alphaBefore?.let { alpha(it) } ?: this)
        .compositeOver(other(Colors).let { alphaOther?.run(it::alpha) ?: it })
        .let { alphaAfter?.run(it::alpha) ?: it }