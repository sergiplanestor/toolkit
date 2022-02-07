package com.splanes.core.theme.typography.scheme

import com.splanes.core.theme.typography.model.ThemeTextStyle

data class ThemeTypographyScheme(
    val display: ThemeTextStyle,
    val headline: ThemeTextStyle,
    val title: ThemeTextStyle,
    val body: ThemeTextStyle,
    val label: ThemeTextStyle
)