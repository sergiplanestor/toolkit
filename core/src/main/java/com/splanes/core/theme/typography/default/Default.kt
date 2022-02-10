package com.splanes.core.theme.typography.default

import androidx.compose.ui.text.font.FontWeight
import com.splanes.core.theme.typography.material.*
import com.splanes.core.theme.typography.model.ThemeTextStyle
import com.splanes.core.theme.typography.scheme.ThemeTypographyScheme

val DefaultThemeTypographyScheme: ThemeTypographyScheme by lazy {
    ThemeTypographyScheme(
        display = ThemeTextStyle(
            L = DisplayLarge.copy(fontFamily = DefaultFontFamily.mangoSticky),
            M = DisplayMedium.copy(fontFamily = DefaultFontFamily.mangoSticky),
            S = DisplaySmall.copy(fontFamily = DefaultFontFamily.apercuPro, fontWeight = FontWeight.Light)
        ),
        headline = ThemeTextStyle(
            L = HeadlineLarge.copy(fontFamily = DefaultFontFamily.apercuPro, fontWeight = FontWeight.Light),
            M = HeadlineMedium.copy(fontFamily = DefaultFontFamily.apercuPro, fontWeight = FontWeight.Medium),
            S = HeadlineSmall.copy(fontFamily = DefaultFontFamily.apercuPro, fontWeight = FontWeight.Normal)
        ),
        title = ThemeTextStyle(
            L = TitleLarge.copy(fontFamily = DefaultFontFamily.apercuPro, fontWeight = FontWeight.Normal),
            M = TitleMedium.copy(fontFamily = DefaultFontFamily.apercuPro, fontWeight = FontWeight.Normal),
            S = TitleSmall.copy(fontFamily = DefaultFontFamily.bentonSansCondensed, fontWeight = FontWeight.Medium)
        ),
        body = ThemeTextStyle(
            L = BodyLarge.copy(fontFamily = DefaultFontFamily.bentonSansCondensed, fontWeight = FontWeight.Normal),
            M = BodyMedium.copy(fontFamily = DefaultFontFamily.bentonSansCondensed, fontWeight = FontWeight.Normal),
            S = BodySmall.copy(fontFamily = DefaultFontFamily.bentonSansCondensed, fontWeight = FontWeight.Normal)
        ),
        label = ThemeTextStyle(
            L = LabelLarge.copy(fontFamily = DefaultFontFamily.apercuPro, fontWeight = FontWeight.Normal),
            M = LabelMedium.copy(fontFamily = DefaultFontFamily.apercuPro, fontWeight = FontWeight.Normal),
            S = LabelSmall.copy(fontFamily = DefaultFontFamily.apercuPro, fontWeight = FontWeight.Normal)
        )
    )
}