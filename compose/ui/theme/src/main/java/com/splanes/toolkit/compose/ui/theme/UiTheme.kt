package com.splanes.toolkit.compose.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import com.splanes.toolkit.compose.ui.theme.default.AppThemeDefault
import com.splanes.toolkit.compose.ui.theme.feature.colors.ThemeColorScheme
import com.splanes.toolkit.compose.ui.theme.feature.colors.material.toMaterial
import com.splanes.toolkit.compose.ui.theme.feature.colors.material.toMaterial3
import com.splanes.toolkit.compose.ui.theme.feature.paddings.ThemePaddingScheme
import com.splanes.toolkit.compose.ui.theme.feature.shapes.ThemeShapeScheme
import com.splanes.toolkit.compose.ui.theme.feature.shapes.material.toMaterial
import com.splanes.toolkit.compose.ui.theme.feature.typographies.ThemeTypographyScheme
import com.splanes.toolkit.compose.ui.theme.feature.typographies.material.toMaterial
import com.splanes.toolkit.compose.ui.theme.feature.typographies.material.toMaterial3
import com.splanes.toolkit.compose.ui.theme.utils.material.ThemeMaterial
import com.splanes.toolkit.compose.ui.theme.utils.material.ThemeMaterial3
import timber.log.Timber

object UiTheme {

    init {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private val LocalThemeContract by lazy {
        staticCompositionLocalOf {
            Timber.d("No UiThemeContract provided. Instead, as a fallback `UiThemeContractDefault` will be used.")
            AppThemeDefault
        }
    }

    private val LocalIsMaterial3 by lazy {
        staticCompositionLocalOf {
            Timber.d("No default Material design version specified. Instead, as a fallback Material 3 will be used.")
            true
        }
    }

    fun applyContract(contract: UiThemeContract = AppThemeDefault, isMaterial3: Boolean = true) {
        LocalThemeContract.provides(contract)
        LocalIsMaterial3.provides(isMaterial3)
    }

    @Composable
    fun AppTheme(content: @Composable () -> Unit) {
        with(LocalThemeContract.current) {
            if (LocalIsMaterial3.current) {
                ThemeMaterial3(
                    colorScheme = colorScheme.toMaterial3(),
                    typography = typographyScheme.toMaterial3(),
                    content = content
                )
            } else {
                ThemeMaterial(
                    colors = colorScheme.toMaterial(),
                    typography = typographyScheme.toMaterial(),
                    shapes = shapeScheme.toMaterial(),
                    content = content
                )
            }
        }
    }

    val ThemeColors: ThemeColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalThemeContract.current.colorScheme

    val ThemeTypographies: ThemeTypographyScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalThemeContract.current.typographyScheme

    val ThemePaddings: ThemePaddingScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalThemeContract.current.paddingScheme

    val ThemeShapes: ThemeShapeScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalThemeContract.current.shapeScheme
}