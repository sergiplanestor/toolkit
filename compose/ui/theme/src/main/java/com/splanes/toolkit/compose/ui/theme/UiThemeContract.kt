package com.splanes.toolkit.compose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.splanes.toolkit.compose.ui.theme.feature.colors.ThemeColorScheme
import com.splanes.toolkit.compose.ui.theme.feature.paddings.ThemePaddingScheme
import com.splanes.toolkit.compose.ui.theme.feature.shapes.ThemeShapeScheme
import com.splanes.toolkit.compose.ui.theme.feature.typographies.ThemeTypographyScheme

interface UiThemeContract {

    val colorSchemeLight: ThemeColorScheme

    val colorSchemeDark: ThemeColorScheme

    val typographyScheme: ThemeTypographyScheme

    val paddingScheme: ThemePaddingScheme

    val shapeScheme: ThemeShapeScheme

    companion object {
        fun build(
            colorSchemeLight: ThemeColorScheme,
            colorSchemeDark: ThemeColorScheme,
            typographyScheme: ThemeTypographyScheme,
            paddingScheme: ThemePaddingScheme,
            shapeScheme: ThemeShapeScheme
        ): UiThemeContract =
            object : UiThemeContract {
                override val colorSchemeLight: ThemeColorScheme = colorSchemeLight
                override val colorSchemeDark: ThemeColorScheme = colorSchemeDark
                override val typographyScheme: ThemeTypographyScheme = typographyScheme
                override val paddingScheme: ThemePaddingScheme = paddingScheme
                override val shapeScheme: ThemeShapeScheme = shapeScheme
            }
    }
}

inline val UiThemeContract.colorScheme: ThemeColorScheme
    @ReadOnlyComposable
    @Composable
    get() = if (isSystemInDarkTheme()) colorSchemeDark else colorSchemeLight