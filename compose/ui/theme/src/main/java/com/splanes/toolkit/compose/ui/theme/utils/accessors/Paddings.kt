package com.splanes.toolkit.compose.ui.theme.utils.accessors

import androidx.compose.runtime.Composable
import com.splanes.toolkit.compose.ui.theme.UiTheme.ThemePaddings

val Paddings
    @Composable
    get() = ThemePaddings

val ComponentPaddings
    @Composable
    get() = Paddings.component

val ViewportPaddings
    @Composable
    get() = Paddings.viewport