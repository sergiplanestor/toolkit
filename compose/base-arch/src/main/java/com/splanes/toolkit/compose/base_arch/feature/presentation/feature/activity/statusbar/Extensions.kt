package com.splanes.toolkit.compose.base_arch.feature.presentation.feature.activity.statusbar

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import com.google.accompanist.systemuicontroller.SystemUiController

fun SystemUiController.bind(model: StatusBarUiModel) = with(model) {
    setStatusBarColor(color, useDarkIcons, transformation)
}

fun SystemUiController.setStatusBarColor(
    color: Color,
    useDarkIcons: Boolean = color.luminance() > 0.5f,
    transformation: ((Color) -> Color)?
) {
    if (transformation != null) {
        setStatusBarColor(color, useDarkIcons, transformation)
    } else {
        setStatusBarColor(color, useDarkIcons)
    }
}