package com.splanes.toolkit.compose.ui.theme.utils.accessors

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import com.splanes.toolkit.compose.ui.theme.UiTheme
import com.splanes.toolkit.compose.ui.theme.feature.typographies.ThemeFonts
import com.splanes.toolkit.compose.ui.theme.feature.typographies.ThemeTypographies
import com.splanes.toolkit.compose.ui.theme.utils.size.UiSize

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

@Composable
fun display(resolver: UiSize<TextStyle>.() -> TextStyle): TextStyle =
    Typographies.Display.resolver()

@Composable
fun headline(resolver: UiSize<TextStyle>.() -> TextStyle): TextStyle =
    Typographies.Headline.resolver()

@Composable
fun title(resolver: UiSize<TextStyle>.() -> TextStyle): TextStyle =
    Typographies.Title.resolver()

@Composable
fun body(resolver: UiSize<TextStyle>.() -> TextStyle): TextStyle =
    Typographies.Body.resolver()

@Composable
fun label(resolver: UiSize<TextStyle>.() -> TextStyle): TextStyle =
    Typographies.Label.resolver()

@Composable
fun font(resolver: ThemeFonts.() -> FontFamily): FontFamily =
    Fonts.resolver()
