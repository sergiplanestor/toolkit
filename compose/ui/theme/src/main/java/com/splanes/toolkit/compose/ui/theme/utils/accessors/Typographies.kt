package com.splanes.toolkit.compose.ui.theme.utils.accessors

import androidx.compose.runtime.Composable
import com.splanes.toolkit.compose.ui.theme.UiTheme
import com.splanes.toolkit.compose.ui.theme.feature.typographies.ThemeTypographies

val Typographies
    @Composable
    get() = UiTheme.ThemeTypographies.typographies

val ThemeTypographies.Display
    @Composable
    get() = display.sizes

val ThemeTypographies.Headline
    @Composable
    get() = headline.sizes

val ThemeTypographies.Title
    @Composable
    get() = title.sizes

val ThemeTypographies.Body
    @Composable
    get() = body.sizes

val ThemeTypographies.Label
    @Composable
    get() = label.sizes

val Fonts
    @Composable
    get() = UiTheme.ThemeTypographies.fonts
