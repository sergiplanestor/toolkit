package com.splanes.toolkit.compose.ui.theme.utils.size


fun <T> uiSizeExtendedOf(
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
    extra: T = huge,
): UiSize.Extended<T> =
    object : UiSize.Extended<T> {
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

fun <T> uiSizeSimpleOf(
    small: T,
    medium: T,
    large: T
): UiSize.Simple<T> =
    object : UiSize.Simple<T> {
        override val small: T = small
        override val medium: T = medium
        override val large: T = large
    }

fun <T> UiSize<T>.isSimple(): Boolean = this is UiSize.Simple

fun <T> UiSize<T>.isExtended(): Boolean = !isSimple()

fun <T, R> UiSize<T>.fold(onSimple: UiSize.Simple<T>.() -> R, onExtended: UiSize.Extended<T>.() -> R): R =
    when(this) {
        is UiSize.Extended -> onExtended()
        is UiSize.Simple -> onSimple()
    }