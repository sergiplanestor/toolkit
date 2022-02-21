package com.splanes.toolkit.compose.base_arch.feature.presentation.feature.activity.navgraph.transition

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi

@OptIn(ExperimentalAnimationApi::class)
sealed class NavGraphTransition(open val map: Map<NavGraphTransitionType, NavGraphTransitionBuilder?>) {

    data class Lateral(val duration: Int = DURATION_MEDIUM) : NavGraphTransition(
        navGraphTransitionMap(
            enter = { slideInHorizontally(duration = duration) { fullWidth -> fullWidth } },
            exit = { slideOutHorizontally(duration = duration) { fullWidth -> -fullWidth } },
            popEnter = { slideInHorizontally(duration = duration) { fullWidth -> -fullWidth } },
            popExit = { slideOutHorizontally(duration = duration) { fullWidth -> fullWidth } }
        )
    )

    data class Fade(val duration: Int = DURATION_MEDIUM) : NavGraphTransition(
        navGraphTransitionMap(
            enter = { fadeIn(duration = duration) },
            exit = { ExitTransition.None },
            popEnter = { EnterTransition.None },
            popExit = { fadeOut(duration = duration) }
        )
    )

    data class Modal(val duration: Int = DURATION_MEDIUM) : NavGraphTransition(
        navGraphTransitionMap(
            enter = { slideInVertically(duration = duration) { fullHeight -> fullHeight } },
            exit = { fadeOut(duration = duration) },
            popEnter = { fadeIn(duration = duration) },
            popExit = { slideOutVertically(duration = duration) { fullHeight -> fullHeight } }
        )
    )

    data class PushUp(val duration: Int = DURATION_MEDIUM) : NavGraphTransition(
        navGraphTransitionMap(
            enter = { slideInVertically(duration = duration) { fullHeight -> fullHeight } },
            exit = {slideOutVertically(duration = duration) { fullHeight -> fullHeight } },
            popEnter = { slideInVertically(duration = duration) { fullHeight -> fullHeight } },
            popExit = { slideOutVertically(duration = duration) { fullHeight -> fullHeight } }
        )
    )

    companion object {
        const val NO_OFFSET = 0

        const val DURATION_SHORT = 150
        const val DURATION_MEDIUM = 300
        const val DURATION_LARGE = 500
    }
}