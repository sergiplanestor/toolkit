package com.splanes.toolkit.compose.ui.theme.utils.material

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.splanes.toolkit.compose.ui.theme.feature.colors.material.ThemeColorsMaterial
import com.splanes.toolkit.compose.ui.theme.feature.colors.material.ThemeColorsMaterial3
import com.splanes.toolkit.compose.ui.theme.feature.shapes.material.ThemeShapesMaterial
import com.splanes.toolkit.compose.ui.theme.feature.typographies.material.ThemeTypographiesMaterial
import com.splanes.toolkit.compose.ui.theme.feature.typographies.material.ThemeTypographiesMaterial3
import androidx.compose.material3.MaterialTheme as MaterialTheme3

@Composable
fun ThemeMaterial(
    colors: ThemeColorsMaterial = MaterialTheme.colors,
    typography: ThemeTypographiesMaterial = MaterialTheme.typography,
    shapes: ThemeShapesMaterial = MaterialTheme.shapes,
    content: @Composable () -> Unit
) =
    MaterialTheme(colors, typography, shapes, content)

@Composable
fun ThemeMaterial3(
    colorScheme: ThemeColorsMaterial3 = MaterialTheme3.colorScheme,
    typography: ThemeTypographiesMaterial3 = MaterialTheme3.typography,
    content: @Composable () -> Unit
) =
    MaterialTheme3(colorScheme, typography, content)