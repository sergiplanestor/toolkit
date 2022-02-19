package com.splanes.toolkit.compose.base_arch.feature.presentation.feature.activity.base

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.runtime.*
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.splanes.toolkit.compose.base_arch.logger.logStyle
import timber.log.Timber

internal typealias ComposableMethod = @Composable () -> Unit

internal fun composableMethod(content: ComposableMethod = @Composable { }): ComposableMethod =
    @Composable { content() }

internal fun composableMethodOrEmpty(
    condition: Boolean = true,
    block: () -> ComposableMethod?
): ComposableMethod =
    (if (condition) block() else null) ?: composableMethod()

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ComposeActivity.ActivityComponentWrapper() {
    with(activityConfig) {
        Scaffold(
            topBar = onCreateTopBar(),
            bottomBar = onCreateBottomBar(),
            snackbarHost = { if (isSnackBarHost) SnackbarHost(remember { snackBarHostState }) },
            containerColor = containerColor(),
            contentColor = contentColor(),
        ) {
            ActivityComponent()
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ComposeActivity.NavHost() {
    var isLogged: Boolean by remember { mutableStateOf(false) }
    val controller = rememberAnimatedNavController()
    AnimatedNavHost(
        navController = controller,
        startDestination = navGraphStartDestination(),
        builder = {
            onCreateNavGraph(controller)
            if (!isLogged) {
                Timber.d(message = logStyle { "Nav graph created." })
                isLogged = true
            }
        }
    )
}