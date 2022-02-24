package com.splanes.toolkit.compose.ui.components.feature.statusbar.utils

import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.SystemUiController
import com.splanes.toolkit.compose.ui.components.common.utils.color.isLighterColor
import com.splanes.toolkit.compose.ui.components.feature.statusbar.model.StatusBarColors

fun SystemUiController.statusBarColors(
    color: Color,
    isDarkIconsEnabled: Boolean = color.isLighterColor(),
    transformation: ((Color) -> Color)?
) {
    if (transformation != null) {
        setStatusBarColor(color, isDarkIconsEnabled, transformation)
    } else {
        setStatusBarColor(color, isDarkIconsEnabled)
    }
}

fun SystemUiController.statusBarColors(colors: StatusBarColors) {
    statusBarColors(colors.container, colors.isDarkIconsEnabled, colors.transformation)
}