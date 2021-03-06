package com.splanes.toolkit.compose.ui.components.feature.navhost.graph.transition

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavBackStackEntry

@OptIn(ExperimentalAnimationApi::class)
typealias NavGraphEnterTransitionBuilder = (AnimatedContentScope<NavBackStackEntry>.() -> EnterTransition)

@OptIn(ExperimentalAnimationApi::class)
typealias NavGraphExitTransitionBuilder = (AnimatedContentScope<NavBackStackEntry>.() -> ExitTransition)
