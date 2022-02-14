package com.splanes.toolkit.ui.theme.default.shapes

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp
import com.splanes.toolkit.ui.theme.feature.shapes.ThemeShapeScheme

val ThemeShapeSchemeDefault: ThemeShapeScheme by lazy {
    ThemeShapeScheme.build(
        small = RoundedCornerShape(size = 6.dp),
        medium = RoundedCornerShape(size = 10.dp),
        large = RoundedCornerShape(size = 14.dp)
    )
}