package com.splanes.toolkit.compose.base_arch.feature.presentation.feature.activity.navgraph.transition

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavBackStackEntry

@OptIn(ExperimentalAnimationApi::class)
typealias NavGraphEnterTransitionBuilder = (AnimatedContentScope<NavBackStackEntry>.() -> EnterTransition?)

@OptIn(ExperimentalAnimationApi::class)
typealias NavGraphExitTransitionBuilder = (AnimatedContentScope<NavBackStackEntry>.() -> ExitTransition?)
