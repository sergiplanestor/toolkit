package com.splanes.toolkit.compose.ui.theme.utils.resources

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

@Composable
inline fun <reified T> resource(id: () -> Int, vararg args: Any): T {
    val result: Any = when (T::class) {
        String::class -> stringResource(id = id(), args)
        Painter::class -> painterResource(id = id())
        else -> throw IllegalArgumentException("Illegal type. Allowed res types are [String, Painter].")
    }
    return result as T
}