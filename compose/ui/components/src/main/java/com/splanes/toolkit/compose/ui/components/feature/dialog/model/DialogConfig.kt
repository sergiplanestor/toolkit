package com.splanes.toolkit.compose.ui.components.feature.dialog.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.window.DialogProperties
import com.splanes.toolkit.compose.ui.components.common.utils.color.composite
import com.splanes.toolkit.compose.ui.theme.utils.accessors.Colors
import com.splanes.toolkit.compose.ui.theme.utils.accessors.ComponentPaddings
import com.splanes.toolkit.compose.ui.theme.utils.accessors.Shapes

class DialogConfig(
    val shape: Shape? = null,
    val elevation: Dp? = null,
    val containerColor: Color? = null,
    val iconColor: Color? = null,
    val titleColor: Color? = null,
    val bodyColor: Color? = null,
    val properties: DialogProperties = DialogProperties()
) {
    @Composable
    fun shape(): Shape = shape ?: Shapes.medium

    @Composable
    fun elevation(): Dp = elevation ?: ComponentPaddings.medium

    @Composable
    fun containerColor(): Color = containerColor ?: Colors.surface

    @Composable
    fun iconColor(category: DialogCategory): Color = iconColor ?: when (category) {
        DialogCategory.Default -> Colors.onSurface
        DialogCategory.Error -> Colors.error
        DialogCategory.Info -> Colors.info
        DialogCategory.Warning -> Colors.warning
    }.composite(Colors.surface, alpha = 0.75)

    @Composable
    fun titleColor(category: DialogCategory): Color = titleColor ?: when (category) {
        DialogCategory.Default -> Colors.onSurface
        DialogCategory.Error -> Colors.error
        DialogCategory.Info -> Colors.info
        DialogCategory.Warning -> Colors.warning
    }

    @Composable
    fun bodyColor(): Color = bodyColor ?: Colors.onSurface
}