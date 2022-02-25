package com.splanes.toolkit.compose.ui.components.feature.navhost.graph.transition

import androidx.compose.animation.*
import androidx.compose.animation.core.tween

@OptIn(ExperimentalAnimationApi::class)
fun navGraphTransitionMap(
    enter: NavGraphTransitionBuilder.Enter? = null,
    exit: NavGraphTransitionBuilder.Exit? = null,
    popEnter: NavGraphTransitionBuilder.Enter? = null,
    popExit: NavGraphTransitionBuilder.Exit? = null,
): Map<NavGraphTransitionType, NavGraphTransitionBuilder?> = buildMap {
    this[NavGraphTransitionType.Enter] = enter
    this[NavGraphTransitionType.Exit] = exit
    this[NavGraphTransitionType.PopEnter] = popEnter
    this[NavGraphTransitionType.PopExit] = popExit
}

@OptIn(ExperimentalAnimationApi::class)
fun navGraphTransitionMap(
    enter: NavGraphEnterTransitionBuilder? = null,
    exit: NavGraphExitTransitionBuilder? = null,
    popEnter: NavGraphEnterTransitionBuilder? = null,
    popExit: NavGraphExitTransitionBuilder? = null,
): Map<NavGraphTransitionType, NavGraphTransitionBuilder?> = navGraphTransitionMap(
    enter = enter?.let { NavGraphTransitionBuilder.Enter(it) },
    exit = exit?.let { NavGraphTransitionBuilder.Exit(it) },
    popEnter = popEnter?.let { NavGraphTransitionBuilder.Enter(it) },
    popExit = popExit?.let { NavGraphTransitionBuilder.Exit(it) }
)

@OptIn(ExperimentalAnimationApi::class)
inline val NavGraphTransition?.onEnter: NavGraphEnterTransitionBuilder?
    get() = (this?.map?.get(NavGraphTransitionType.Enter) as? NavGraphTransitionBuilder.Enter)?.builder

@OptIn(ExperimentalAnimationApi::class)
inline val NavGraphTransition?.onPopEnter: NavGraphEnterTransitionBuilder?
    get() = (this?.map?.get(NavGraphTransitionType.PopEnter) as? NavGraphTransitionBuilder.Enter)?.builder

@OptIn(ExperimentalAnimationApi::class)
inline val NavGraphTransition?.onExit: NavGraphExitTransitionBuilder?
    get() = (this?.map?.get(NavGraphTransitionType.Exit) as? NavGraphTransitionBuilder.Exit)?.builder

@OptIn(ExperimentalAnimationApi::class)
inline val NavGraphTransition?.onPopExit: NavGraphExitTransitionBuilder?
    get() = (this?.map?.get(NavGraphTransitionType.PopExit) as? NavGraphTransitionBuilder.Exit)?.builder

fun slideInHorizontally(
    duration: Int,
    initialOffsetX: (fullWidth: Int) -> Int = { -it / 2 },
): EnterTransition =
    slideInHorizontally(
        animationSpec = tween(durationMillis = duration),
        initialOffsetX = initialOffsetX
    )

fun slideOutHorizontally(
    duration: Int,
    targetOffsetX: (fullWidth: Int) -> Int = { -it / 2 },
): ExitTransition =
    slideOutHorizontally(
        animationSpec = tween(durationMillis = duration),
        targetOffsetX = targetOffsetX
    )

fun slideInVertically(
    duration: Int,
    initialOffsetY: (fullHeight: Int) -> Int = { -it / 2 },
): EnterTransition =
    slideInVertically(
        animationSpec = tween(durationMillis = duration),
        initialOffsetY = initialOffsetY
    )

fun slideOutVertically(
    duration: Int,
    targetOffsetY: (fullHeight: Int) -> Int = { -it / 2 },
): ExitTransition =
    slideOutVertically(
        animationSpec = tween(durationMillis = duration),
        targetOffsetY = targetOffsetY
    )

fun fadeIn(
    duration: Int,
    initialAlpha: Float = 0f
): EnterTransition =
    fadeIn(animationSpec = tween(durationMillis = duration), initialAlpha = initialAlpha)

fun fadeOut(
    duration: Int,
    targetAlpha: Float = 0f,
): ExitTransition =
    fadeOut(animationSpec = tween(durationMillis = duration), targetAlpha = targetAlpha)