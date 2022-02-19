package com.splanes.toolkit.compose.ui.theme.utils.size

sealed interface UiSize<out T> {

    val small: T
    val medium: T
    val large: T

    interface Simple<out T> : UiSize<T>

    interface Extended<out T> : UiSize<T> {
        val tiny: T

        val smallTiny: T get() = tiny

        val mediumSmall: T get() = small

        val mediumLarge: T get() = medium

        val largeHuge: T get() = large

        val huge: T

        val hugeExtra: T get() = huge

        val extra: T get() = huge
    }

    companion object {

        fun <T> simple(small: T, medium: T, large: T): Simple<T> =
            object : Simple<T> {
                override val small: T = small
                override val medium: T = medium
                override val large: T = large
            }

        fun <T> extended(
            tiny: T,
            smallTiny: T = tiny,
            small: T,
            mediumSmall: T = small,
            medium: T,
            mediumLarge: T = medium,
            large: T,
            largeHuge: T = large,
            huge: T,
            hugeExtra: T = huge,
            extra: T = huge
        ): Extended<T> =
            object : Extended<T> {
                override val tiny: T = tiny
                override val smallTiny: T = smallTiny
                override val small: T = small
                override val mediumSmall: T = mediumSmall
                override val medium: T = medium
                override val mediumLarge: T = mediumLarge
                override val large: T = large
                override val largeHuge: T = largeHuge
                override val huge: T = huge
                override val hugeExtra: T = hugeExtra
                override val extra: T = extra
            }
    }
}