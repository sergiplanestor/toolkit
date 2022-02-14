package com.splanes.toolkit.ui.theme.feature.typographies

import androidx.compose.ui.text.TextStyle
import com.splanes.toolkit.ui.theme.utils.size.UiSize

interface ThemeTypographyScheme {
    val typographies: ThemeTypographies
    val fonts: ThemeFonts

    companion object {
        fun build(
            displaySize: UiSize<TextStyle>,
            headlineSize: UiSize<TextStyle>,
            titleSize: UiSize<TextStyle>,
            bodySize: UiSize<TextStyle>,
            labelSize: UiSize<TextStyle>,
            fonts: ThemeFonts
        ): ThemeTypographyScheme =
            object : ThemeTypographyScheme {
                override val typographies: ThemeTypographies by lazy {
                    ThemeTypographies(displaySize, headlineSize, titleSize, bodySize, labelSize)
                }
                override val fonts: ThemeFonts by lazy { fonts }
            }
    }
}
