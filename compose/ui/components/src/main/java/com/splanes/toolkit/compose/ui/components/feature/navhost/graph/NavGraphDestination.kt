package com.splanes.toolkit.compose.ui.components.feature.navhost.graph

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.*
import com.splanes.toolkit.compose.ui.components.feature.navhost.graph.transition.NavGraphTransition

@OptIn(ExperimentalAnimationApi::class)
class NavGraphDestination(
    val route: String,
    val args: List<NamedNavArgument>,
    val deepLinks: List<NavDeepLink>,
    val transitions: NavGraphTransition? = null,
    val builder: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit
) {

    constructor(
        route: String,
        arg: NamedNavArgument? = null,
        deepLink: NavDeepLink? = null,
        transitions: NavGraphTransition? = null,
        builder: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit
    ) : this(
        route = route,
        args = listOfNotNull(arg),
        deepLinks = listOfNotNull(deepLink),
        transitions = transitions,
        builder = builder
    )

    constructor(
        route: String,
        deepLink: NavDeepLink? = null,
        transitions: NavGraphTransition? = null,
        builder: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit,
        vararg args: Pair<String, NavArgumentBuilder.() -> Unit>
    ) : this(
        route = route,
        args = args.map { navArgument(it.first, it.second) },
        deepLinks = listOfNotNull(deepLink),
        transitions = transitions,
        builder = builder
    )
}