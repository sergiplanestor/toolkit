package com.splanes.toolkit.compose.base_arch.feature.presentation.feature.activity.navgraph

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import com.splanes.toolkit.compose.base_arch.feature.presentation.feature.activity.navgraph.destination.NavGraphDestination
import com.splanes.toolkit.compose.base_arch.feature.presentation.feature.activity.navgraph.transition.*

@Composable
@OptIn(ExperimentalAnimationApi::class)
fun AnimatedNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestinationRoute: String,
    startDestinationTransition: NavGraphTransition? = null,
    contentAlignment: Alignment = Alignment.Center,
    builder: NavGraphBuilder.() -> Unit
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = NavGraphDestination(
            route = startDestinationRoute,
            transitions = startDestinationTransition,
            builder = {}
        ),
        modifier = modifier,
        contentAlignment = contentAlignment,
        builder = builder
    )
}

@Composable
@OptIn(ExperimentalAnimationApi::class)
fun AnimatedNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: NavGraphDestination,
    contentAlignment: Alignment = Alignment.Center,
    builder: NavGraphBuilder.() -> Unit
) {
    val enterTransitionDefault: NavGraphEnterTransitionBuilder =
        { fadeIn(animationSpec = tween(700)) }
    val exitTransitionDefault: NavGraphExitTransitionBuilder =
        { fadeOut(animationSpec = tween(700)) }
    with(startDestination) {
        com.google.accompanist.navigation.animation.AnimatedNavHost(
            navController = navController,
            modifier = modifier,
            contentAlignment = contentAlignment,
            startDestination = route,
            enterTransition = transitions.onEnter ?: enterTransitionDefault,
            exitTransition = transitions.onExit ?: exitTransitionDefault,
            popEnterTransition = transitions.onPopEnter ?: enterTransitionDefault,
            popExitTransition = transitions.onPopExit ?: exitTransitionDefault,
            builder = builder
        )
    }
}

@OptIn(ExperimentalAnimationApi::class)
operator fun NavGraphBuilder.plusAssign(destination: NavGraphDestination) {
    with(destination) {
        composable(
            route = route,
            arguments = args,
            deepLinks = deepLinks,
            enterTransition = transitions.onEnter,
            exitTransition = transitions.onExit,
            popEnterTransition = transitions.onPopEnter,
            popExitTransition = transitions.onPopExit,
            content = builder
        )
    }
}