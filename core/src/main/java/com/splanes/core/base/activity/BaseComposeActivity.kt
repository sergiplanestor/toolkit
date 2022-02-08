package com.splanes.core.base.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavArgumentBuilder
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController


abstract class BaseComposeActivity : ComponentActivity() {

    private var _navHostController: NavHostController? = null
    private var _systemUiController: SystemUiController? = null

    protected open val isNavHostActivity: Boolean = false

    protected val navHostController: NavHostController
        @Composable
        get() = _navHostController ?: rememberNavController().also { _navHostController = it }

    protected val systemUiController: SystemUiController
        @Composable
        get() = _systemUiController ?: rememberSystemUiController().also { _systemUiController = it }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScreenComponent()
        }
    }

    @Composable
    protected open fun ScreenComponent() {
        if (isNavHostActivity) {
            NavHost(
                navController = navHostController,
                startDestination = initialRoute().key,
                builder = { onCreateNavGraph() }
            )
        }
    }

    @Composable
    protected fun StatusBarColor(
        color: Color,
        isDarkIcons: Boolean = color.luminance() > 0.5f
    ) {
        systemUiController.setStatusBarColor(color, isDarkIcons)
    }

    abstract fun initialRoute(): NavRoute

    abstract fun NavGraphBuilder.onCreateNavGraph()

    protected fun NavGraphBuilder.destinationOf(
        route: NavRoute,
        args: List<NamedNavArgument>,
        deepLinks: List<NavDeepLink>,
        builder: @Composable NavBackStackEntry.() -> Unit
    ) {
        composable(route.key, args, deepLinks) { builder(it) }
    }

    protected fun NavGraphBuilder.destinationOf(
        route: NavRoute,
        arg: NamedNavArgument? = null,
        deepLink: NavDeepLink? = null,
        builder: @Composable NavBackStackEntry.() -> Unit
    ) {
        destinationOf(
            route,
            arg?.let { listOf(arg) }.orEmpty(),
            deepLink?.let { listOf(deepLink) }.orEmpty(),
            builder
        )
    }

    protected fun navArgsOf(vararg args: Pair<String, NavArgumentBuilder.() -> Unit>): List<NamedNavArgument> =
        args.map { navArgument(it.first, it.second) }

    protected fun navRoute(route: String): NavRoute =
        object : NavRoute {
            override val key: String get() = route
        }

    interface NavRoute {
        val key: String
    }
}