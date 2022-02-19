package com.splanes.toolkit.compose.ui.theme.feature.typographies

import androidx.compose.ui.text.TextStyle
import com.splanes.toolkit.compose.ui.theme.utils.size.UiSize

data class ThemeTextStyle(
    val type: ThemeTextStyleType,
    val sizes: UiSize<TextStyle>
)
