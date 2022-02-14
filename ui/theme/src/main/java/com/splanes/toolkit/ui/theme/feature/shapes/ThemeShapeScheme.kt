package com.splanes.toolkit.ui.theme.feature.shapes

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.Dp
import com.splanes.toolkit.ui.theme.utils.size.UiSize

interface ThemeShapeScheme {
    val general: UiSize<RoundedCornerShape>

    companion object {
        fun build(general: UiSize<RoundedCornerShape>): ThemeShapeScheme =
            object : ThemeShapeScheme {
                override val general: UiSize<RoundedCornerShape> = general
            }

        fun build(
            small: RoundedCornerShape,
            medium: RoundedCornerShape,
            large: RoundedCornerShape
        ): ThemeShapeScheme =
            build(UiSize.simple(small, medium, large))

        fun build(
            tiny: RoundedCornerShape,
            smallTiny: RoundedCornerShape,
            small: RoundedCornerShape,
            mediumSmall: RoundedCornerShape,
            medium: RoundedCornerShape,
            mediumLarge: RoundedCornerShape,
            large: RoundedCornerShape,
            largeHuge: RoundedCornerShape,
            huge: RoundedCornerShape,
            hugeExtra: RoundedCornerShape,
            extra: RoundedCornerShape
        ): ThemeShapeScheme =
            build(
                UiSize.extended(
                    tiny,
                    smallTiny,
                    small,
                    mediumSmall,
                    medium,
                    mediumLarge,
                    large,
                    largeHuge,
                    huge,
                    hugeExtra,
                    extra
                )
            )
    }
}