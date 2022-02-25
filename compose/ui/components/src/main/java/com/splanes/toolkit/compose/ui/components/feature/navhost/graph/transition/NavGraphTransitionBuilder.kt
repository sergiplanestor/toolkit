package com.splanes.toolkit.compose.ui.components.feature.navhost.graph.transition

import androidx.compose.animation.ExperimentalAnimationApi

@OptIn(ExperimentalAnimationApi::class)
sealed class NavGraphTransitionBuilder {
    data class Enter(val builder: NavGraphEnterTransitionBuilder) : NavGraphTransitionBuilder()
    data class Exit(val builder: NavGraphExitTransitionBuilder) : NavGraphTransitionBuilder()
}


