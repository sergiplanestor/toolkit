package com.splanes.toolkit.compose.ui.theme.feature.typographies

import androidx.compose.ui.text.TextStyle
import com.splanes.toolkit.compose.ui.theme.utils.size.UiSize

class ThemeTypographies(
    displaySize: UiSize<TextStyle>,
    headlineSize: UiSize<TextStyle>,
    titleSize: UiSize<TextStyle>,
    bodySize: UiSize<TextStyle>,
    labelSize: UiSize<TextStyle>
) {
    val display: ThemeTextStyle = ThemeTextStyle(ThemeTextStyleType.Display, displaySize)
    val headline: ThemeTextStyle = ThemeTextStyle(ThemeTextStyleType.Headline, headlineSize)
    val title: ThemeTextStyle = ThemeTextStyle(ThemeTextStyleType.Title, titleSize)
    val body: ThemeTextStyle = ThemeTextStyle(ThemeTextStyleType.Body, bodySize)
    val label: ThemeTextStyle = ThemeTextStyle(ThemeTextStyleType.Label, labelSize)
}
