package com.splanes.toolkit.compose.ui.theme.utils.accessors

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.splanes.toolkit.compose.ui.theme.UiTheme
import com.splanes.toolkit.compose.ui.theme.feature.colors.ThemeColorScheme

val Colors
    @Composable
    get() = UiTheme.ThemeColors

@Composable
fun color(resolver: ThemeColorScheme.() -> Color): Color =
    Colors.resolver()

@Composable
fun color(alpha: Double? = null, resolver: ThemeColorScheme.() -> Color): Color =
    Colors.resolver()