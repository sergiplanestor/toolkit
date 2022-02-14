package com.splanes.toolkit.ui.theme.feature.paddings

import androidx.compose.ui.unit.Dp
import com.splanes.toolkit.ui.theme.utils.size.UiSize

interface ThemePaddingScheme {
    val viewport: UiSize.Extended<Dp>
    val component: UiSize.Extended<Dp>

    companion object {

        fun build(
            viewport: UiSize.Extended<Dp>,
            component: UiSize.Extended<Dp>
        ): ThemePaddingScheme = object : ThemePaddingScheme {
            override val viewport: UiSize.Extended<Dp> =
                UiSize.extended(
                    tiny = viewport.tiny,
                    smallTiny = viewport.smallTiny,
                    small = viewport.small,
                    mediumSmall = viewport.mediumSmall,
                    medium = viewport.medium,
                    mediumLarge =viewport.mediumLarge,
                    large = viewport.large,
                    largeHuge = viewport.largeHuge,
                    huge =viewport.huge,
                    hugeExtra = viewport.hugeExtra,
                    extra = viewport.extra
                )
            override val component: UiSize.Extended<Dp> =
                UiSize.extended(
                    tiny = component.tiny,
                    smallTiny = component.smallTiny,
                    small = component.small,
                    mediumSmall = component.mediumSmall,
                    medium = component.medium,
                    mediumLarge = component.mediumLarge,
                    large = component.large,
                    largeHuge = component.largeHuge,
                    huge = component.huge,
                    hugeExtra = component.hugeExtra,
                    extra = component.extra
                )
        }

        fun build(
            componentTiny: Dp,
            componentSmallTiny: Dp,
            componentSmall: Dp,
            componentMediumSmall: Dp,
            componentMedium: Dp,
            componentMediumLarge: Dp,
            componentLarge: Dp,
            componentLargeHuge: Dp,
            componentHuge: Dp,
            componentHugeExtra: Dp,
            componentExtra: Dp,
            viewportTiny: Dp,
            viewportSmallTiny: Dp,
            viewportSmall: Dp,
            viewportMediumSmall: Dp,
            viewportMedium: Dp,
            viewportMediumLarge: Dp,
            viewportLarge: Dp,
            viewportLargeHuge: Dp,
            viewportHuge: Dp,
            viewportHugeExtra: Dp,
            viewportExtra: Dp
        ): ThemePaddingScheme =
            build(
                viewport = UiSize.extended(
                    tiny = viewportTiny,
                    smallTiny = viewportSmallTiny,
                    small = viewportSmall,
                    mediumSmall = viewportMediumSmall,
                    medium = viewportMedium,
                    mediumLarge = viewportMediumLarge,
                    large = viewportLarge,
                    largeHuge = viewportLargeHuge,
                    huge = viewportHuge,
                    hugeExtra = viewportHugeExtra,
                    extra = viewportExtra
                ),
                component = UiSize.extended(
                    tiny = componentTiny,
                    smallTiny = componentSmallTiny,
                    small = componentSmall,
                    mediumSmall = componentMediumSmall,
                    medium = componentMedium,
                    mediumLarge = componentMediumLarge,
                    large = componentLarge,
                    largeHuge = componentLargeHuge,
                    huge = componentHuge,
                    hugeExtra = componentHugeExtra,
                    extra = componentExtra
                )
            )
    }
}