package com.splanes.core.theme.color.default

import androidx.compose.ui.graphics.Color
import com.splanes.core.theme.color.scheme.ThemeColorScheme

inline val defaultDarkColorPrimary: Color get() = Palette.Red.ChestnutRose
inline val defaultDarkColorOnPrimary: Color get() = Palette.Basic.WhiteSoapstone
inline val defaultDarkColorPrimaryContainer: Color get() = Palette.Red.LightCoral
inline val defaultDarkColorOnPrimaryContainer: Color get() = Palette.Gray.MineShaft
inline val defaultDarkColorInversePrimary: Color get() = Palette.Red.ChestnutRose

inline val defaultDarkColorSecondary: Color get() = Palette.Red.ChestnutRose
inline val defaultDarkColorOnSecondary: Color get() = Palette.Gray.Dove
inline val defaultDarkColorSecondaryContainer: Color get() = Palette.Red.CrownOfThrones
inline val defaultDarkColorOnSecondaryContainer: Color get() = Palette.Red.DelRio

inline val defaultDarkColorTertiary: Color get() = Palette.Orange.Rajah
inline val defaultDarkColorOnTertiary: Color get() = Palette.Gray.MineShaft
inline val defaultDarkColorTertiaryContainer: Color get() = Palette.Orange.DiSerria
inline val defaultDarkColorOnTertiaryContainer: Color get() = Palette.Gray.RaisinBlack

inline val defaultDarkColorBackground: Color get() = Palette.Gray.MineShaft
inline val defaultDarkColorOnBackground: Color get() = Palette.Gray.Mercury

inline val defaultDarkColorSurface: Color get() = Palette.Gray.Dove
inline val defaultDarkColorOnSurface: Color get() = Palette.Gray.Mercury
inline val defaultDarkColorSurfaceVariant: Color get() = Palette.Orange.CapePalliser
inline val defaultDarkColorOnSurfaceVariant: Color get() = Palette.Orange.Champagne
inline val defaultDarkColorInverseSurface: Color get() = Palette.Gray.Mercury
inline val defaultDarkColorInverseOnSurface: Color get() = Palette.Gray.Dove

inline val defaultDarkColorError: Color get() = Palette.Red.ChestnutRose
inline val defaultDarkColorOnError: Color get() = Palette.Gray.Mercury
inline val defaultDarkColorErrorContainer: Color get() = Palette.Red.CornflowerLilac
inline val defaultDarkColorOnErrorContainer: Color get() = Palette.Red.Ferra

inline val defaultDarkColorWarning: Color get() = Palette.Orange.Rajah
inline val defaultDarkColorOnWarning: Color get() = Palette.Gray.RaisinBlack
inline val defaultDarkColorWarningContainer: Color get() = Palette.Orange.NavajoWhite
inline val defaultDarkColorOnWarningContainer: Color get() = Palette.Gray.MineShaft

inline val defaultDarkColorSuccess: Color get() = Palette.Green.ChelseaCucumber
inline val defaultDarkColorOnSuccess: Color get() = Palette.Gray.MineShaft
inline val defaultDarkColorSuccessContainer: Color get() = Palette.Green.FernGreen
inline val defaultDarkColorOnSuccessContainer: Color get() = Palette.Gray.Mercury

inline val defaultDarkColorInfo: Color get() = Palette.Blue.VioletBlue
inline val defaultDarkColorOnInfo: Color get() = Palette.Gray.Mercury
inline val defaultDarkColorInfoContainer: Color get() = Palette.Blue.Rackley
inline val defaultDarkColorOnInfoContainer: Color get() = Palette.Gray.Mercury

inline val defaultDarkColorOutline: Color get() = Palette.Gray.Silver

inline val DefaultThemeColorSchemeDark: ThemeColorScheme get() =
    ThemeColorScheme(
        primary = defaultDarkColorPrimary,
        onPrimary = defaultDarkColorOnPrimary,
        primaryContainer = defaultDarkColorPrimaryContainer,
        onPrimaryContainer = defaultDarkColorOnPrimaryContainer,
        inversePrimary = defaultDarkColorInversePrimary,
        secondary = defaultDarkColorSecondary,
        onSecondary = defaultDarkColorOnSecondary,
        secondaryContainer = defaultDarkColorSecondaryContainer,
        onSecondaryContainer = defaultDarkColorOnSecondaryContainer,
        tertiary = defaultDarkColorTertiary,
        onTertiary = defaultDarkColorOnTertiary,
        tertiaryContainer = defaultDarkColorTertiaryContainer,
        onTertiaryContainer = defaultDarkColorOnTertiaryContainer,
        background = defaultDarkColorBackground,
        onBackground = defaultDarkColorOnBackground,
        surface = defaultDarkColorSurface,
        onSurface = defaultDarkColorOnSurface,
        surfaceVariant = defaultDarkColorSurfaceVariant,
        onSurfaceVariant = defaultDarkColorOnSurfaceVariant,
        inverseSurface = defaultDarkColorInverseSurface,
        inverseOnSurface = defaultDarkColorInverseOnSurface,
        error = defaultDarkColorError,
        onError = defaultDarkColorOnError,
        errorContainer = defaultDarkColorErrorContainer,
        onErrorContainer = defaultDarkColorOnErrorContainer,
        success = defaultDarkColorSuccess,
        onSuccess = defaultDarkColorOnSuccess,
        successContainer = defaultDarkColorSuccessContainer,
        onSuccessContainer = defaultDarkColorOnSuccessContainer,
        warning = defaultDarkColorWarning,
        onWarning = defaultDarkColorOnWarning,
        warningContainer = defaultDarkColorWarningContainer,
        onWarningContainer = defaultDarkColorOnWarningContainer,
        info = defaultDarkColorInfo,
        onInfo = defaultDarkColorOnInfo,
        infoContainer = defaultDarkColorInfoContainer,
        onInfoContainer = defaultDarkColorOnInfoContainer,
        outline = defaultDarkColorOutline
    )