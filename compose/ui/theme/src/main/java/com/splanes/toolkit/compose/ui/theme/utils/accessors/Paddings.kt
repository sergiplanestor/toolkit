package com.splanes.toolkit.compose.ui.theme.utils.accessors

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.splanes.toolkit.compose.ui.theme.UiTheme.ThemePaddings
import com.splanes.toolkit.compose.ui.theme.utils.size.UiSize

val Paddings
    @Composable
    get() = ThemePaddings

val ComponentPaddings
    @Composable
    get() = Paddings.component

val ViewportPaddings
    @Composable
    get() = Paddings.viewport

@Composable
fun dp(isComponent: Boolean = true, resolver: UiSize.Extended<Dp>.() -> Dp): Dp =
    (if (isComponent) ComponentPaddings else ViewportPaddings).resolver()