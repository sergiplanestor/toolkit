package com.splanes.core.theme.contract.default

import com.splanes.core.theme.color.default.DefaultThemeColorSchemeDark
import com.splanes.core.theme.color.default.DefaultThemeColorSchemeLight
import com.splanes.core.theme.contract.ThemeContract
import com.splanes.core.theme.distance.default.DefaultThemeDistanceScheme
import com.splanes.core.theme.shape.default.DefaultThemeShapeScheme
import com.splanes.core.theme.typography.default.DefaultThemeTypographyScheme

inline val DefaultTheme: ThemeContract get() =
    ThemeContract.create(
        lightColorScheme = DefaultThemeColorSchemeLight,
        darkColorScheme = DefaultThemeColorSchemeDark,
        shapeScheme = DefaultThemeShapeScheme,
        typographyScheme = DefaultThemeTypographyScheme,
        distanceScheme = DefaultThemeDistanceScheme,
    )