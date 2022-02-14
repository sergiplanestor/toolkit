package com.splanes.toolkit.ui.theme.default.typographies

import androidx.compose.ui.text.font.FontWeight
import com.splanes.toolkit.ui.theme.feature.typographies.ThemeFonts
import com.splanes.toolkit.ui.theme.feature.typographies.ThemeTypographyScheme
import com.splanes.toolkit.ui.theme.feature.typographies.material.*
import com.splanes.toolkit.ui.theme.utils.size.UiSize

val ThemeTypographySchemeDefault: ThemeTypographyScheme by lazy {
    ThemeTypographyScheme.build(
        displaySize = UiSize.simple(
            large = DisplayLarge.copy(fontFamily = FontFamilyDefault.mangoSticky),
            medium = DisplayMedium.copy(fontFamily = FontFamilyDefault.mangoSticky),
            small = DisplaySmall.copy(
                fontFamily = FontFamilyDefault.apercuPro,
                fontWeight = FontWeight.Light
            ),
        ),
        headlineSize = UiSize.simple(
            large = HeadlineLarge.copy(
                fontFamily = FontFamilyDefault.apercuPro,
                fontWeight = FontWeight.Light
            ),
            medium = HeadlineMedium.copy(
                fontFamily = FontFamilyDefault.apercuPro,
                fontWeight = FontWeight.Medium
            ),
            small = HeadlineSmall.copy(
                fontFamily = FontFamilyDefault.apercuPro,
                fontWeight = FontWeight.Normal
            )
        ),
        titleSize = UiSize.simple(
            large = TitleLarge.copy(
                fontFamily = FontFamilyDefault.apercuPro,
                fontWeight = FontWeight.Normal
            ),
            medium = TitleMedium.copy(
                fontFamily = FontFamilyDefault.apercuPro,
                fontWeight = FontWeight.Normal
            ),
            small = TitleSmall.copy(
                fontFamily = FontFamilyDefault.bentonSansCondensed,
                fontWeight = FontWeight.Medium
            )
        ),
        bodySize = UiSize.simple(
            large = BodyLarge.copy(
                fontFamily = FontFamilyDefault.bentonSansCondensed,
                fontWeight = FontWeight.Normal
            ),
            medium = BodyMedium.copy(
                fontFamily = FontFamilyDefault.bentonSansCondensed,
                fontWeight = FontWeight.Normal
            ),
            small = BodySmall.copy(
                fontFamily = FontFamilyDefault.bentonSansCondensed,
                fontWeight = FontWeight.Normal
            )
        ),
        labelSize = UiSize.simple(
            large = LabelLarge.copy(
                fontFamily = FontFamilyDefault.apercuPro,
                fontWeight = FontWeight.Normal
            ),
            medium = LabelMedium.copy(
                fontFamily = FontFamilyDefault.apercuPro,
                fontWeight = FontWeight.Normal
            ),
            small = LabelSmall.copy(
                fontFamily = FontFamilyDefault.apercuPro,
                fontWeight = FontWeight.Normal
            )
        ),
        fonts = ThemeFonts(
            decor = FontFamilyDefault.mangoSticky,
            title = FontFamilyDefault.apercuPro,
            body = FontFamilyDefault.bentonSansCondensed
        )
    )
}

