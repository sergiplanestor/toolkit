package com.splanes.toolkit.compose.ui.theme.utils.accessors

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.splanes.toolkit.compose.ui.theme.UiTheme
import com.splanes.toolkit.compose.ui.theme.utils.size.UiSize

val Shapes
    @Composable
    get() = UiTheme.ThemeShapes.general

@Composable
fun shape(size: Int): Shape = RoundedCornerShape(size.dp)

@Composable
fun shape(resolver: UiSize<RoundedCornerShape>.() -> Shape): Shape = Shapes.resolver()