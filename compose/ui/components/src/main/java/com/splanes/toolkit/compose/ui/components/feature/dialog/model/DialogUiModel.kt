package com.splanes.toolkit.compose.ui.components.feature.dialog.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

sealed interface DialogUiModel {

    val dialogCategory: DialogCategory
    val config: DialogConfig get() = DialogConfig()
    val icon: ImageVector? get() = null
    val useDefaultIcon: Boolean get() = true
    val title: String? get() = null
    val body: String? get() = null
    val positiveButtonText: String
    val negativeButtonText: String? get() = null
    val isVisible: Boolean get() = false

    sealed class Default(
        override val dialogCategory: DialogCategory,
        override val config: DialogConfig,
        override val icon: ImageVector,
        override val useDefaultIcon: Boolean,
        override val title: String,
        override val body: String,
        override val positiveButtonText: String,
        override val negativeButtonText: String,
        override val isVisible: Boolean,
    ) : DialogUiModel

    abstract class Error(
        override val config: DialogConfig,
        override val icon: ImageVector,
        override val useDefaultIcon: Boolean,
        override val title: String,
        override val body: String,
        override val positiveButtonText: String,
        override val negativeButtonText: String,
        override val isVisible: Boolean
    ) : Default(
        DialogCategory.Error,
        config,
        icon,
        useDefaultIcon,
        title,
        body,
        positiveButtonText,
        negativeButtonText,
        isVisible
    )

    abstract class Info(
        override val config: DialogConfig,
        override val icon: ImageVector,
        override val useDefaultIcon: Boolean,
        override val title: String,
        override val body: String,
        override val positiveButtonText: String,
        override val negativeButtonText: String,
        override val isVisible: Boolean
    ) : Default(
        DialogCategory.Info,
        config,
        icon,
        useDefaultIcon,
        title,
        body,
        positiveButtonText,
        negativeButtonText,
        isVisible
    )

    abstract class Warning(
        override val config: DialogConfig,
        override val icon: ImageVector,
        override val useDefaultIcon: Boolean,
        override val title: String,
        override val body: String,
        override val positiveButtonText: String,
        override val negativeButtonText: String,
        override val isVisible: Boolean
    ) : Default(
        DialogCategory.Warning,
        config,
        icon,
        useDefaultIcon,
        title,
        body,
        positiveButtonText,
        negativeButtonText,
        isVisible
    )

    abstract class Confirmation(
        override val config: DialogConfig,
        override val icon: ImageVector,
        override val useDefaultIcon: Boolean,
        override val title: String,
        override val body: String,
        override val positiveButtonText: String,
        override val negativeButtonText: String,
        override val isVisible: Boolean
    ) : Default(
        DialogCategory.Default,
        config,
        icon,
        useDefaultIcon,
        title,
        body,
        positiveButtonText,
        negativeButtonText,
        isVisible
    )

    abstract class Other : DialogUiModel {
        override val dialogCategory: DialogCategory get() = DialogCategory.Default
        abstract val titleBuilder: @Composable (String?) -> Unit
        abstract val bodyBuilder: @Composable (String?) -> Unit
        abstract val iconBuilder: @Composable (Painter?) -> Unit
        abstract val buttonNegativeBuilder: @Composable (String?) -> Unit
        abstract val buttonPositiveBuilder: @Composable (String) -> Unit
    }
}