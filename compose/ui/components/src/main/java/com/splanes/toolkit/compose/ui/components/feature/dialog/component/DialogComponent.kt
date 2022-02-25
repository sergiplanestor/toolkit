package com.splanes.toolkit.compose.ui.components.feature.dialog.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults.textButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.splanes.toolkit.compose.ui.components.common.utils.color.alpha
import com.splanes.toolkit.compose.ui.components.feature.dialog.model.DialogUiModel
import com.splanes.toolkit.compose.ui.theme.utils.accessors.*

@Composable
fun DialogComponent(
    model: DialogUiModel,
    onPositiveClick: () -> Unit = {},
    onNegativeClick: () -> Unit = {},
) {
    var isDialogVisible by remember { mutableStateOf(model.isVisible) }
    with(model) {
        if (isDialogVisible) {
            AlertDialog(
                icon = { DialogIcon() },
                title = { DialogTitle() },
                text = { DialogBody() },
                shape = config.shape(),
                containerColor = config.containerColor(),
                iconContentColor = config.iconColor(dialogCategory),
                titleContentColor = config.titleColor(dialogCategory),
                textContentColor = config.bodyColor(),
                tonalElevation = config.elevation(),
                properties = config.properties,
                confirmButton = {
                    DialogPositiveButton {
                        isDialogVisible = false
                        onPositiveClick()
                    }
                },
                dismissButton = {
                    DialogNegativeButton {
                        isDialogVisible = false
                        onNegativeClick()
                    }
                },
                onDismissRequest = { isDialogVisible = false }
            )
        }
    }
}

@Composable
fun DialogUiModel.DialogIcon() {
    val painter = iconOrDefault()
    doWhen(
        isDefault = {
            if (painter != null) {
                Icon(
                    modifier = Modifier
                        .size(size = 45.dp)
                        .padding(horizontal = ComponentPaddings.mediumSmall),
                    painter = painter,
                    contentDescription = null
                )
            }
        },
        isOther = { iconBuilder(painter) }
    )
}

@Composable
fun DialogUiModel.DialogTitle() {
    doWhen(
        isDefault = {
            title.takeIf { it.isNotBlank() }?.let { text ->
                Text(
                    modifier = Modifier.padding(horizontal = ComponentPaddings.medium),
                    text = text,
                    style = Typographies.Headline.medium
                )
            }
        },
        isOther = { titleBuilder(title) }
    )
}

@Composable
fun DialogUiModel.DialogBody() {
    doWhen(
        isDefault = {
            body.takeIf { it.isNotBlank() }?.let { text ->
                Text(
                    modifier = Modifier.padding(horizontal = ComponentPaddings.mediumSmall),
                    text = text,
                    style = Typographies.Title.small
                )
            }
        },
        isOther = { bodyBuilder(body) }
    )
}

@Composable
fun DialogUiModel.DialogPositiveButton(onPositiveClick: () -> Unit) {
    doWhen(
        isDefault = {
            positiveButtonText.takeIf { it.isNotBlank() }?.let { text ->
                TextButton(onClick = onPositiveClick) {
                    Text(
                        text = text,
                        style = Typographies.Body.large
                    )
                }
            }
        },
        isOther = { buttonPositiveBuilder(positiveButtonText) }
    )
}

@Composable
fun DialogUiModel.DialogNegativeButton(onNegativeClick: () -> Unit) {
    doWhen(
        isDefault = {
            negativeButtonText.takeIf { it.isNotBlank() }?.let { text ->
                TextButton(
                    onClick = onNegativeClick,
                    colors = textButtonColors(contentColor = Colors.onSurface.alpha(.85))
                ) {
                    Text(
                        text = text,
                        style = Typographies.Body.large
                    )
                }
            }
        },
        isOther = { buttonNegativeBuilder(negativeButtonText) }
    )
}