package com.splanes.toolkit.compose.ui.theme.utils.resources

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


operator fun Dp.minus(other: Int): Dp = value.minus(other).dp

operator fun Dp.minus(other: Double): Dp = value.minus(other.toFloat()).dp

operator fun Dp.plus(other: Int): Dp = value.plus(other).dp

operator fun Dp.plus(other: Double): Dp = value.plus(other.toFloat()).dp