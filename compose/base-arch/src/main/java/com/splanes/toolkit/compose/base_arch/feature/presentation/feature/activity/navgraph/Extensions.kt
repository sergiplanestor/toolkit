package com.splanes.toolkit.compose.base_arch.feature.presentation.feature.activity.navgraph

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.*
import com.google.accompanist.navigation.animation.composable

class NavGraphDestination(
    val route: String,
    val args: List<NamedNavArgument>,
    val deepLinks: List<NavDeepLink>,
    val builder: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit
) {

    constructor(
        route: String,
        arg: NamedNavArgument? = null,
        deepLink: NavDeepLink? = null,
        builder: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit
    ) : this(
        route = route,
        args = listOfNotNull(arg),
        deepLinks = listOfNotNull(deepLink),
        builder = builder
    )

    constructor(
        route: String,
        deepLink: NavDeepLink? = null,
        builder: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit,
        vararg args: Pair<String, NavArgumentBuilder.() -> Unit>
    ) : this(
        route = route,
        args = args.map { navArgument(it.first, it.second) },
        deepLinks = listOfNotNull(deepLink),
        builder = builder
    )
}


@OptIn(ExperimentalAnimationApi::class)
operator fun NavGraphBuilder.plusAssign(destination: NavGraphDestination) {
    with(destination) {
        composable(
            route = route,
            arguments = args,
            deepLinks = deepLinks,
            enterTransition = { TODO() },
            exitTransition = { TODO() },
            popEnterTransition = { TODO() },
            popExitTransition = { TODO() },
            content = builder
        )
    }
}