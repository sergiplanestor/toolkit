package com.splanes.toolkit.compose.ui.theme.feature.typographies.material

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.FontFamily
import com.splanes.toolkit.compose.ui.theme.feature.typographies.ThemeTypographies
import com.splanes.toolkit.compose.ui.theme.feature.typographies.ThemeTypographyScheme
import com.splanes.toolkit.compose.ui.theme.utils.size.fold

typealias ThemeTypographiesMaterial = Typography

fun ThemeTypographyScheme.toMaterial(): ThemeTypographiesMaterial =
    typographies.toMaterial(fonts.body)

fun ThemeTypographies.toMaterial(defaultFontFamily: FontFamily = FontFamily.Default): ThemeTypographiesMaterial =
    ThemeTypographiesMaterial(
        defaultFontFamily = defaultFontFamily,
        h1 = display.sizes.fold(
            onSimple = { this.large },
            onExtended = { this.extra }
        ),
        h2 = display.sizes.fold(
            onSimple = { this.large },
            onExtended = { this.huge }
        ),
        h3 = display.sizes.large,
        h4 = display.sizes.medium,
        h5 = display.sizes.small,
        h6 = display.sizes.fold(
            onSimple = { this.small },
            onExtended = { this.tiny }
        ),
        subtitle1 = title.sizes.medium,
        subtitle2 = title.sizes.small,
        body1 = body.sizes.medium,
        body2 = body.sizes.small,
        button = label.sizes.large,
        caption = label.sizes.small,
        overline = label.sizes.small,
    )