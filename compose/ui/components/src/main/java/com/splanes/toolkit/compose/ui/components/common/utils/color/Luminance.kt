package com.splanes.toolkit.compose.ui.components.common.utils.color

import androidx.annotation.FloatRange
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance

val COLOR_LUMINANCE_LIGHT_MIN_FACTOR by lazy { 0.55f }
val COLOR_LUMINANCE_DARK_MAX_FACTOR by lazy { 1 - COLOR_LUMINANCE_LIGHT_MIN_FACTOR }

fun Color.isLuminanceOver(
    @FloatRange(from = 0.0, to = 1.0) factor: Float,
    isInclusive: Boolean = true
): Boolean =
    luminance().let { it > factor || (it == factor && isInclusive) }

fun Color.isLuminanceBelow(
    @FloatRange(from = 0.0, to = 1.0) factor: Float,
    isInclusive: Boolean = true
): Boolean =
    luminance().let { it < factor || (it == factor && isInclusive) }

fun Color.isLighterColor(
    @FloatRange(from = 0.0, to = 1.0) factor: Float = COLOR_LUMINANCE_LIGHT_MIN_FACTOR,
    isInclusive: Boolean = true
): Boolean = isLuminanceOver(factor, isInclusive)

fun Color.isDarkerColor(
    @FloatRange(from = 0.0, to = 1.0) factor: Float = COLOR_LUMINANCE_DARK_MAX_FACTOR,
    isInclusive: Boolean = true
): Boolean = isLuminanceBelow(factor, isInclusive)