package com.splanes.toolkit.compose.ui.components.feature.scaffold.utils

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.splanes.toolkit.compose.ui.components.feature.scaffold.model.ScaffoldColors

@Composable
fun scaffoldColors(
    container: Color = MaterialTheme.colorScheme.background,
    content: Color = contentColorFor(container)
): ScaffoldColors = ScaffoldColors(content = content, container = container)