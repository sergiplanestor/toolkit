package com.splanes.toolkit.compose.ui.theme.feature.shapes.material

import androidx.compose.material.Shapes
import com.splanes.toolkit.compose.ui.theme.feature.shapes.ThemeShapeScheme

typealias ThemeShapesMaterial = Shapes

fun ThemeShapeScheme.toMaterial(): ThemeShapesMaterial =
    ThemeShapesMaterial(
        small = general.small,
        medium = general.medium,
        large = general.large
    )