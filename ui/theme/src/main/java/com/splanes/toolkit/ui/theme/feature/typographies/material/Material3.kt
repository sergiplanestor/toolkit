package com.splanes.toolkit.ui.theme.feature.typographies.material

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.splanes.toolkit.ui.theme.feature.typographies.ThemeTypographies
import com.splanes.toolkit.ui.theme.feature.typographies.ThemeTypographyScheme

typealias ThemeTypographiesMaterial3 = Typography

fun ThemeTypographyScheme.toMaterial3(): ThemeTypographiesMaterial3 =
    typographies.toMaterial3()

fun ThemeTypographies.toMaterial3(): ThemeTypographiesMaterial3 =
    ThemeTypographiesMaterial3(
        displayLarge = display.sizes.large,
        displayMedium = display.sizes.medium,
        displaySmall = display.sizes.small,
        headlineLarge = headline.sizes.large,
        headlineMedium = headline.sizes.medium,
        headlineSmall = headline.sizes.small,
        titleLarge = title.sizes.large,
        titleMedium = title.sizes.medium,
        titleSmall = title.sizes.small,
        bodyLarge = body.sizes.large,
        bodyMedium = body.sizes.medium,
        bodySmall = body.sizes.small,
        labelLarge = label.sizes.large,
        labelMedium = label.sizes.medium,
        labelSmall = label.sizes.small,
    )

object Material3Typeface {
    val BrandMedium = FontFamily.SansSerif
    val BrandRegular = FontFamily.SansSerif
    val PlainMedium = FontFamily.SansSerif
    val PlainRegular = FontFamily.SansSerif
    val WeightBold = FontWeight.Bold
    val WeightMedium = FontWeight.Medium
    val WeightRegular = FontWeight.Normal
}

object Material3TypeScale {
    val BodyLargeFont = Material3Typeface.PlainRegular
    val BodyLargeLineHeight = 24.0.sp
    val BodyLargeSize = 16.sp
    val BodyLargeTracking = 0.5.sp
    val BodyLargeWeight = Material3Typeface.WeightRegular
    val BodyMediumFont = Material3Typeface.PlainRegular
    val BodyMediumLineHeight = 20.0.sp
    val BodyMediumSize = 14.sp
    val BodyMediumTracking = 0.2.sp
    val BodyMediumWeight = Material3Typeface.WeightRegular
    val BodySmallFont = Material3Typeface.PlainRegular
    val BodySmallLineHeight = 16.0.sp
    val BodySmallSize = 12.sp
    val BodySmallTracking = 0.4.sp
    val BodySmallWeight = Material3Typeface.WeightRegular
    val DisplayLargeFont = Material3Typeface.BrandRegular
    val DisplayLargeLineHeight = 64.0.sp
    val DisplayLargeSize = 57.sp
    val DisplayLargeTracking = -0.2.sp
    val DisplayLargeWeight = Material3Typeface.WeightRegular
    val DisplayMediumFont = Material3Typeface.BrandRegular
    val DisplayMediumLineHeight = 52.0.sp
    val DisplayMediumSize = 45.sp
    val DisplayMediumTracking = 0.0.sp
    val DisplayMediumWeight = Material3Typeface.WeightRegular
    val DisplaySmallFont = Material3Typeface.BrandRegular
    val DisplaySmallLineHeight = 44.0.sp
    val DisplaySmallSize = 36.sp
    val DisplaySmallTracking = 0.0.sp
    val DisplaySmallWeight = Material3Typeface.WeightRegular
    val HeadlineLargeFont = Material3Typeface.BrandRegular
    val HeadlineLargeLineHeight = 40.0.sp
    val HeadlineLargeSize = 32.sp
    val HeadlineLargeTracking = 0.0.sp
    val HeadlineLargeWeight = Material3Typeface.WeightRegular
    val HeadlineMediumFont = Material3Typeface.BrandRegular
    val HeadlineMediumLineHeight = 36.0.sp
    val HeadlineMediumSize = 28.sp
    val HeadlineMediumTracking = 0.0.sp
    val HeadlineMediumWeight = Material3Typeface.WeightRegular
    val HeadlineSmallFont = Material3Typeface.BrandRegular
    val HeadlineSmallLineHeight = 32.0.sp
    val HeadlineSmallSize = 24.sp
    val HeadlineSmallTracking = 0.0.sp
    val HeadlineSmallWeight = Material3Typeface.WeightRegular
    val LabelLargeFont = Material3Typeface.PlainMedium
    val LabelLargeLineHeight = 20.0.sp
    val LabelLargeSize = 14.sp
    val LabelLargeTracking = 0.1.sp
    val LabelLargeWeight = Material3Typeface.WeightMedium
    val LabelMediumFont = Material3Typeface.PlainMedium
    val LabelMediumLineHeight = 16.0.sp
    val LabelMediumSize = 12.sp
    val LabelMediumTracking = 0.5.sp
    val LabelMediumWeight = Material3Typeface.WeightMedium
    val LabelSmallFont = Material3Typeface.PlainMedium
    val LabelSmallLineHeight = 16.0.sp
    val LabelSmallSize = 11.sp
    val LabelSmallTracking = 0.5.sp
    val LabelSmallWeight = Material3Typeface.WeightMedium
    val TitleLargeFont = Material3Typeface.BrandRegular
    val TitleLargeLineHeight = 28.0.sp
    val TitleLargeSize = 22.sp
    val TitleLargeTracking = 0.0.sp
    val TitleLargeWeight = Material3Typeface.WeightRegular
    val TitleMediumFont = Material3Typeface.PlainMedium
    val TitleMediumLineHeight = 24.0.sp
    val TitleMediumSize = 16.sp
    val TitleMediumTracking = 0.2.sp
    val TitleMediumWeight = Material3Typeface.WeightMedium
    val TitleSmallFont = Material3Typeface.PlainMedium
    val TitleSmallLineHeight = 20.0.sp
    val TitleSmallSize = 14.sp
    val TitleSmallTracking = 0.1.sp
    val TitleSmallWeight = Material3Typeface.WeightMedium
}

val DisplayLarge: TextStyle by lazy {
    TextStyle(
        fontFamily = Material3TypeScale.DisplayLargeFont,
        fontWeight = Material3TypeScale.DisplayLargeWeight,
        fontSize = Material3TypeScale.DisplayLargeSize,
        lineHeight = Material3TypeScale.DisplayLargeLineHeight,
        letterSpacing = Material3TypeScale.DisplayLargeTracking,
    )
}

val DisplayMedium: TextStyle by lazy {
    TextStyle(
        fontFamily = Material3TypeScale.DisplayMediumFont,
        fontWeight = Material3TypeScale.DisplayMediumWeight,
        fontSize = Material3TypeScale.DisplayMediumSize,
        lineHeight = Material3TypeScale.DisplayMediumLineHeight,
        letterSpacing = Material3TypeScale.DisplayMediumTracking,
    )
}
val DisplaySmall: TextStyle by lazy {
    TextStyle(
        fontFamily = Material3TypeScale.DisplaySmallFont,
        fontWeight = Material3TypeScale.DisplaySmallWeight,
        fontSize = Material3TypeScale.DisplaySmallSize,
        lineHeight = Material3TypeScale.DisplaySmallLineHeight,
        letterSpacing = Material3TypeScale.DisplaySmallTracking,
    )
}

val HeadlineLarge: TextStyle by lazy {
    TextStyle(
        fontFamily = Material3TypeScale.HeadlineLargeFont,
        fontWeight = Material3TypeScale.HeadlineLargeWeight,
        fontSize = Material3TypeScale.HeadlineLargeSize,
        lineHeight = Material3TypeScale.HeadlineLargeLineHeight,
        letterSpacing = Material3TypeScale.HeadlineLargeTracking,
    )
}
val HeadlineMedium: TextStyle by lazy {
    TextStyle(
        fontFamily = Material3TypeScale.HeadlineMediumFont,
        fontWeight = Material3TypeScale.HeadlineMediumWeight,
        fontSize = Material3TypeScale.HeadlineMediumSize,
        lineHeight = Material3TypeScale.HeadlineMediumLineHeight,
        letterSpacing = Material3TypeScale.HeadlineMediumTracking,
    )
}
val HeadlineSmall: TextStyle by lazy {
    TextStyle(
        fontFamily = Material3TypeScale.HeadlineSmallFont,
        fontWeight = Material3TypeScale.HeadlineSmallWeight,
        fontSize = Material3TypeScale.HeadlineSmallSize,
        lineHeight = Material3TypeScale.HeadlineSmallLineHeight,
        letterSpacing = Material3TypeScale.HeadlineSmallTracking,
    )
}

val TitleLarge: TextStyle by lazy {
    TextStyle(
        fontFamily = Material3TypeScale.TitleLargeFont,
        fontWeight = Material3TypeScale.TitleLargeWeight,
        fontSize = Material3TypeScale.TitleLargeSize,
        lineHeight = Material3TypeScale.TitleLargeLineHeight,
        letterSpacing = Material3TypeScale.TitleLargeTracking,
    )
}
val TitleMedium: TextStyle by lazy {
    TextStyle(
        fontFamily = Material3TypeScale.TitleMediumFont,
        fontWeight = Material3TypeScale.TitleMediumWeight,
        fontSize = Material3TypeScale.TitleMediumSize,
        lineHeight = Material3TypeScale.TitleMediumLineHeight,
        letterSpacing = Material3TypeScale.TitleMediumTracking,
    )
}
val TitleSmall: TextStyle by lazy {
    TextStyle(
        fontFamily = Material3TypeScale.TitleSmallFont,
        fontWeight = Material3TypeScale.TitleSmallWeight,
        fontSize = Material3TypeScale.TitleSmallSize,
        lineHeight = Material3TypeScale.TitleSmallLineHeight,
        letterSpacing = Material3TypeScale.TitleSmallTracking,
    )
}

val BodyLarge: TextStyle by lazy {
    TextStyle(
        fontFamily = Material3TypeScale.BodyLargeFont,
        fontWeight = Material3TypeScale.BodyLargeWeight,
        fontSize = Material3TypeScale.BodyLargeSize,
        lineHeight = Material3TypeScale.BodyLargeLineHeight,
        letterSpacing = Material3TypeScale.BodyLargeTracking,
    )
}
val BodyMedium: TextStyle by lazy {
    TextStyle(
        fontFamily = Material3TypeScale.BodyMediumFont,
        fontWeight = Material3TypeScale.BodyMediumWeight,
        fontSize = Material3TypeScale.BodyMediumSize,
        lineHeight = Material3TypeScale.BodyMediumLineHeight,
        letterSpacing = Material3TypeScale.BodyMediumTracking,
    )
}
val BodySmall: TextStyle by lazy {
    TextStyle(
        fontFamily = Material3TypeScale.BodySmallFont,
        fontWeight = Material3TypeScale.BodySmallWeight,
        fontSize = Material3TypeScale.BodySmallSize,
        lineHeight = Material3TypeScale.BodySmallLineHeight,
        letterSpacing = Material3TypeScale.BodySmallTracking,
    )
}

val LabelLarge: TextStyle by lazy {
    TextStyle(
        fontFamily = Material3TypeScale.LabelLargeFont,
        fontWeight = Material3TypeScale.LabelLargeWeight,
        fontSize = Material3TypeScale.LabelLargeSize,
        lineHeight = Material3TypeScale.LabelLargeLineHeight,
        letterSpacing = Material3TypeScale.LabelLargeTracking,
    )
}
val LabelMedium: TextStyle by lazy {
    TextStyle(
        fontFamily = Material3TypeScale.LabelMediumFont,
        fontWeight = Material3TypeScale.LabelMediumWeight,
        fontSize = Material3TypeScale.LabelMediumSize,
        lineHeight = Material3TypeScale.LabelMediumLineHeight,
        letterSpacing = Material3TypeScale.LabelMediumTracking,
    )
}
val LabelSmall: TextStyle by lazy {
    TextStyle(
        fontFamily = Material3TypeScale.LabelSmallFont,
        fontWeight = Material3TypeScale.LabelSmallWeight,
        fontSize = Material3TypeScale.LabelSmallSize,
        lineHeight = Material3TypeScale.LabelSmallLineHeight,
        letterSpacing = Material3TypeScale.LabelSmallTracking,
    )
}