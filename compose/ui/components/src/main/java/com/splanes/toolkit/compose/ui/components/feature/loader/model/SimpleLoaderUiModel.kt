package com.splanes.toolkit.compose.ui.components.feature.loader.model

// TODO -> Add fields like -> timeout, backgroundColor, loaderColor, ...
data class SimpleLoaderUiModel(
    override val isVisible: Boolean
) : LoaderUiModel
