package com.splanes.toolkit.compose.ui.components.feature.navhost.graph

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.splanes.toolkit.compose.ui.components.feature.navhost.graph.transition.onEnter
import com.splanes.toolkit.compose.ui.components.feature.navhost.graph.transition.onExit
import com.splanes.toolkit.compose.ui.components.feature.navhost.graph.transition.onPopEnter
import com.splanes.toolkit.compose.ui.components.feature.navhost.graph.transition.onPopExit

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