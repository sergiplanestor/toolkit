package com.splanes.toolkit.compose.ui.components.feature.dialog.component

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.splanes.toolkit.compose.ui.components.feature.dialog.model.DialogUiModel
import com.splanes.toolkit.compose.ui.components.R.drawable as Icons


@SuppressLint("ComposableNaming")
@Composable
fun DialogUiModel.doWhen(
    isDefault: @Composable DialogUiModel.Default.() -> Unit,
    isOther: @Composable DialogUiModel.Other.() -> Unit,
) {
    when(this) {
       is DialogUiModel.Default -> isDefault()
       is DialogUiModel.Other -> isOther()
    }
}

@Composable
fun DialogUiModel.iconOrDefault(): Painter? =
    if (icon == null) {
        when (this) {
            is DialogUiModel.Confirmation -> painterResource(id = Icons.ic_help)
            is DialogUiModel.Error -> painterResource(id = Icons.ic_error)
            is DialogUiModel.Info -> painterResource(id = Icons.ic_info)
            is DialogUiModel.Warning -> painterResource(id = Icons.ic_warning)
            is DialogUiModel.Other -> null
        }
    } else {
        null
    }