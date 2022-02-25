package com.splanes.toolkit.compose.ui.components.feature.navhost.graph.transition.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.splanes.toolkit.compose.ui.theme.UiTheme

@Composable
internal fun TransitionPreviewPlaceHolder(
    name: String,
    background: Color,
    button: String,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(text = name, style = UiTheme.ThemeTypographies.typographies.display.sizes.small)
        Spacer(modifier = Modifier.weight(1f))
        OutlinedButton(onClick = onClick) { Text(text = button) }
        Spacer(modifier = Modifier.weight(1f))
    }
}