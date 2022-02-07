package com.splanes.core.theme.color.default

import androidx.compose.ui.graphics.Color
import com.splanes.core.theme.color.scheme.ThemeColorScheme

inline val defaultLightColorPrimary: Color get() = Palette.Red.Tosca
inline val defaultLightColorOnPrimary: Color get() = Palette.Basic.WhiteSoapstone
inline val defaultLightColorPrimaryContainer: Color get() = Palette.Red.LightCoral
inline val defaultLightColorOnPrimaryContainer: Color get() = Palette.Gray.MineShaft
inline val defaultLightColorInversePrimary: Color get() = Palette.Red.Tosca

inline val defaultLightColorSecondary: Color get() = Palette.Red.CrownOfThrones
inline val defaultLightColorOnSecondary: Color get() = Palette.Basic.WhiteSoapstone
inline val defaultLightColorSecondaryContainer: Color get() = Palette.Red.ChestnutRose
inline val defaultLightColorOnSecondaryContainer: Color get() = Palette.Gray.Mercury

inline val defaultLightColorTertiary: Color get() = Palette.Orange.Koromiko
inline val defaultLightColorOnTertiary: Color get() = Palette.Gray.MineShaft
inline val defaultLightColorTertiaryContainer: Color get() = Palette.Orange.NavajoWhite
inline val defaultLightColorOnTertiaryContainer: Color get() = Palette.Gray.MineShaft

inline val defaultLightColorBackground: Color get() = Palette.Basic.WhiteSoapstone
inline val defaultLightColorOnBackground: Color get() = Palette.Gray.RaisinBlack

inline val defaultLightColorSurface: Color get() = Palette.Basic.WhiteSoapstone
inline val defaultLightColorOnSurface: Color get() = Palette.Gray.RaisinBlack
inline val defaultLightColorSurfaceVariant: Color get() = Palette.Orange.Champagne
inline val defaultLightColorOnSurfaceVariant: Color get() = Palette.Orange.CapePalliser
inline val defaultLightColorInverseSurface: Color get() = Palette.Gray.RaisinBlack
inline val defaultLightColorInverseOnSurface: Color get() = Palette.Basic.WhiteSoapstone

inline val defaultLightColorError: Color get() = Palette.Red.MexicanRed
inline val defaultLightColorOnError: Color get() = Palette.Basic.WhiteSoapstone
inline val defaultLightColorErrorContainer: Color get() = Palette.Red.CornflowerLilac
inline val defaultLightColorOnErrorContainer: Color get() = Palette.Red.DarkChocolate

inline val defaultLightColorWarning: Color get() = Palette.Orange.NavajoWhite
inline val defaultLightColorOnWarning: Color get() = Palette.Gray.RaisinBlack
inline val defaultLightColorWarningContainer: Color get() = Palette.Orange.CapePalliser
inline val defaultLightColorOnWarningContainer: Color get() = Palette.Gray.MineShaft

inline val defaultLightColorSuccess: Color get() = Palette.Green.Conifer
inline val defaultLightColorOnSuccess: Color get() = Palette.Gray.MineShaft
inline val defaultLightColorSuccessContainer: Color get() = Palette.Green.Coriander
inline val defaultLightColorOnSuccessContainer: Color get() = Palette.Gray.MineShaft

inline val defaultLightColorInfo: Color get() = Palette.Blue.Royal
inline val defaultLightColorOnInfo: Color get() = Palette.Gray.Mercury
inline val defaultLightColorInfoContainer: Color get() = Palette.Blue.VistaBlue
inline val defaultLightColorOnInfoContainer: Color get() = Palette.Gray.Mercury

inline val defaultLightColorOutline: Color get() = Palette.Gray.DimGray

inline val DefaultThemeColorSchemeLight: ThemeColorScheme get() =
    ThemeColorScheme(
        primary = defaultLightColorPrimary,
        onPrimary = defaultLightColorOnPrimary,
        primaryContainer = defaultLightColorPrimaryContainer,
        onPrimaryContainer = defaultLightColorOnPrimaryContainer,
        inversePrimary = defaultLightColorInversePrimary,
        secondary = defaultLightColorSecondary,
        onSecondary = defaultLightColorOnSecondary,
        secondaryContainer = defaultLightColorSecondaryContainer,
        onSecondaryContainer = defaultLightColorOnSecondaryContainer,
        tertiary = defaultLightColorTertiary,
        onTertiary = defaultLightColorOnTertiary,
        tertiaryContainer = defaultLightColorTertiaryContainer,
        onTertiaryContainer = defaultLightColorOnTertiaryContainer,
        background = defaultLightColorBackground,
        onBackground = defaultLightColorOnBackground,
        surface = defaultLightColorSurface,
        onSurface = defaultLightColorOnSurface,
        surfaceVariant = defaultLightColorSurfaceVariant,
        onSurfaceVariant = defaultLightColorOnSurfaceVariant,
        inverseSurface = defaultLightColorInverseSurface,
        inverseOnSurface = defaultLightColorInverseOnSurface,
        error = defaultLightColorError,
        onError = defaultLightColorOnError,
        errorContainer = defaultLightColorErrorContainer,
        onErrorContainer = defaultLightColorOnErrorContainer,
        success = defaultLightColorSuccess,
        onSuccess = defaultLightColorOnSuccess,
        successContainer = defaultLightColorSuccessContainer,
        onSuccessContainer = defaultLightColorOnSuccessContainer,
        warning = defaultLightColorWarning,
        onWarning = defaultLightColorOnWarning,
        warningContainer = defaultLightColorWarningContainer,
        onWarningContainer = defaultLightColorOnWarningContainer,
        info = defaultLightColorInfo,
        onInfo = defaultLightColorOnInfo,
        infoContainer = defaultLightColorInfoContainer,
        onInfoContainer = defaultLightColorOnInfoContainer,
        outline = defaultLightColorOutline
    )