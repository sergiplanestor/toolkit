package com.splanes.toolkit.ui.theme.feature.colors

import androidx.compose.ui.graphics.Color

interface ThemeColorScheme {
    val primary: Color
    val onPrimary: Color
    val primaryContainer: Color
    val onPrimaryContainer: Color
    val inversePrimary: Color
    val secondary: Color
    val onSecondary: Color
    val secondaryContainer: Color
    val onSecondaryContainer: Color
    val tertiary: Color
    val onTertiary: Color
    val tertiaryContainer: Color
    val onTertiaryContainer: Color
    val background: Color
    val onBackground: Color
    val surface: Color
    val onSurface: Color
    val surfaceVariant: Color
    val onSurfaceVariant: Color
    val inverseSurface: Color
    val inverseOnSurface: Color
    val error: Color
    val onError: Color
    val errorContainer: Color
    val onErrorContainer: Color
    val success: Color
    val onSuccess: Color
    val successContainer: Color
    val onSuccessContainer: Color
    val warning: Color
    val onWarning: Color
    val warningContainer: Color
    val onWarningContainer: Color
    val info: Color
    val onInfo: Color
    val infoContainer: Color
    val onInfoContainer: Color
    val outline: Color

    companion object {
        fun build(
            primary: Color,
            onPrimary: Color,
            primaryContainer: Color,
            onPrimaryContainer: Color,
            inversePrimary: Color,
            secondary: Color,
            onSecondary: Color,
            secondaryContainer: Color,
            onSecondaryContainer: Color,
            tertiary: Color,
            onTertiary: Color,
            tertiaryContainer: Color,
            onTertiaryContainer: Color,
            background: Color,
            onBackground: Color,
            surface: Color,
            onSurface: Color,
            surfaceVariant: Color,
            onSurfaceVariant: Color,
            inverseSurface: Color,
            inverseOnSurface: Color,
            error: Color,
            onError: Color,
            errorContainer: Color,
            onErrorContainer: Color,
            success: Color,
            onSuccess: Color,
            successContainer: Color,
            onSuccessContainer: Color,
            warning: Color,
            onWarning: Color,
            warningContainer: Color,
            onWarningContainer: Color,
            info: Color,
            onInfo: Color,
            infoContainer: Color,
            onInfoContainer: Color,
            outline: Color
        ) : ThemeColorScheme =
            object : ThemeColorScheme {
                override val primary: Color = primary
                override val onPrimary: Color = onPrimary
                override val primaryContainer: Color = primaryContainer
                override val onPrimaryContainer: Color = onPrimaryContainer
                override val inversePrimary: Color = inversePrimary
                override val secondary: Color = secondary
                override val onSecondary: Color = onSecondary
                override val secondaryContainer: Color = secondaryContainer
                override val onSecondaryContainer: Color = onSecondaryContainer
                override val tertiary: Color = tertiary
                override val onTertiary: Color = onTertiary
                override val tertiaryContainer: Color = tertiaryContainer
                override val onTertiaryContainer: Color = onTertiaryContainer
                override val background: Color = background
                override val onBackground: Color = onBackground
                override val surface: Color = surface
                override val onSurface: Color = onSurface
                override val surfaceVariant: Color = surfaceVariant
                override val onSurfaceVariant: Color = onSurfaceVariant
                override val inverseSurface: Color = inverseSurface
                override val inverseOnSurface: Color = inverseOnSurface
                override val error: Color = error
                override val onError: Color = onError
                override val errorContainer: Color = errorContainer
                override val onErrorContainer: Color = onErrorContainer
                override val success: Color = success
                override val onSuccess: Color = onSuccess
                override val successContainer: Color = successContainer
                override val onSuccessContainer: Color = onSuccessContainer
                override val warning: Color = warning
                override val onWarning: Color = onWarning
                override val warningContainer: Color = warningContainer
                override val onWarningContainer: Color = onWarningContainer
                override val info: Color = info
                override val onInfo: Color = onInfo
                override val infoContainer: Color = infoContainer
                override val onInfoContainer: Color = onInfoContainer
                override val outline: Color = outline
            }
    }
}
