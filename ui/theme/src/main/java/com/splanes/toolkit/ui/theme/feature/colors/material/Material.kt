package com.splanes.toolkit.ui.theme.feature.colors.material

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import com.splanes.toolkit.ui.theme.feature.colors.ThemeColorScheme

typealias ThemeColorsMaterial = Colors

@Composable
fun ThemeColorScheme.toMaterial(): ThemeColorsMaterial =
    ThemeColorsMaterial(
        primary = primary,
        onPrimary = onPrimary,
        secondary = secondary,
        onSecondary = onSecondary,
        background = background,
        onBackground = onBackground,
        surface = surface,
        onSurface = onSurface,
        error = error,
        onError = onError,
        primaryVariant = primaryContainer,
        secondaryVariant = secondaryContainer,
        isLight = !isSystemInDarkTheme()
    )

fun ThemeColorScheme.toMaterial(isLightScheme: Boolean): ThemeColorsMaterial =
    ThemeColorsMaterial(
        primary = primary,
        onPrimary = onPrimary,
        secondary = secondary,
        onSecondary = onSecondary,
        background = background,
        onBackground = onBackground,
        surface = surface,
        onSurface = onSurface,
        error = error,
        onError = onError,
        primaryVariant = primaryContainer,
        secondaryVariant = secondaryContainer,
        isLight = isLightScheme
    )