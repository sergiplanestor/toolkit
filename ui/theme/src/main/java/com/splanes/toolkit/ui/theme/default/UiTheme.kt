package com.splanes.toolkit.ui.theme.default

import com.splanes.toolkit.ui.theme.UiThemeContract
import com.splanes.toolkit.ui.theme.default.colors.ThemeColorDarkSchemeDefault
import com.splanes.toolkit.ui.theme.default.colors.ThemeColorLightSchemeDefault
import com.splanes.toolkit.ui.theme.default.paddings.ThemePaddingSchemeDefault
import com.splanes.toolkit.ui.theme.default.shapes.ThemeShapeSchemeDefault
import com.splanes.toolkit.ui.theme.default.typographies.ThemeTypographySchemeDefault
import com.splanes.toolkit.ui.theme.feature.colors.ThemeColorScheme
import com.splanes.toolkit.ui.theme.feature.paddings.ThemePaddingScheme
import com.splanes.toolkit.ui.theme.feature.shapes.ThemeShapeScheme
import com.splanes.toolkit.ui.theme.feature.typographies.ThemeTypographyScheme

val AppThemeDefault: UiThemeContract by lazy { UiThemeContractDefault() }

data class UiThemeContractDefault(
    override val colorSchemeLight: ThemeColorScheme = ThemeColorLightSchemeDefault,
    override val colorSchemeDark: ThemeColorScheme = ThemeColorDarkSchemeDefault,
    override val typographyScheme: ThemeTypographyScheme = ThemeTypographySchemeDefault,
    override val paddingScheme: ThemePaddingScheme = ThemePaddingSchemeDefault,
    override val shapeScheme: ThemeShapeScheme = ThemeShapeSchemeDefault
) : UiThemeContract