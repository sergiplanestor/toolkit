package com.splanes.core.theme.typography.material

import com.splanes.core.theme.contract.ThemeContract
import com.splanes.core.theme.typography.model.ThemeTextStyle
import com.splanes.core.theme.typography.scheme.ThemeTypographyScheme

object MaterialTypographyScheme : ThemeContract.Typographies {

    override val scheme: ThemeTypographyScheme =
        ThemeTypographyScheme(
            display = ThemeTextStyle(
                L = DisplayLarge,
                M = DisplayMedium,
                S = DisplaySmall
            ),
            headline = ThemeTextStyle(
                L = HeadlineLarge,
                M = HeadlineMedium,
                S = HeadlineSmall
            ),
            title = ThemeTextStyle(
                L = TitleLarge,
                M = TitleMedium,
                S = TitleSmall
            ),
            body = ThemeTextStyle(
                L = BodyLarge,
                M = BodyMedium,
                S = BodySmall
            ),
            label = ThemeTextStyle(
                L = LabelLarge,
                M = LabelMedium,
                S = LabelSmall
            )
        )
}