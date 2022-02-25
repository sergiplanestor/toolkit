package com.splanes.toolkit.compose.ui.components.feature.navhost.graph.transition.preview

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.splanes.toolkit.compose.ui.components.feature.navhost.component.AnimatedNavHost
import com.splanes.toolkit.compose.ui.components.feature.navhost.graph.NavGraphDestination
import com.splanes.toolkit.compose.ui.components.feature.navhost.graph.plusAssign
import com.splanes.toolkit.compose.ui.components.feature.navhost.graph.transition.NavGraphTransition
import com.splanes.toolkit.compose.ui.theme.UiTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
@Preview(
    name = "Transition PushUp",
    device = Devices.NEXUS_6,
    showSystemUi = true,
    showBackground = true
)
internal fun TransitionPushUpPreview() {
    UiTheme.AppTheme {
        val controller = rememberAnimatedNavController()
        Column(Modifier.fillMaxSize()) {
            AnimatedNavHost(
                modifier = Modifier.fillMaxSize(),
                navController = controller,
                startDestinationRoute = "1",
                startDestinationTransition = NavGraphTransition.PushUp(),
                builder = {
                    this += NavGraphDestination(
                        route = "1",
                        transitions = NavGraphTransition.PushUp(),
                        builder = {
                            TransitionPreviewPlaceHolder(
                                name = "Route 1",
                                background = MaterialTheme.colorScheme.primaryContainer,
                                button = "Go to route 2",
                                onClick = { controller.navigate(route = "2") }
                            )
                        }
                    )
                    this += NavGraphDestination(
                        route = "2",
                        builder = {
                            TransitionPreviewPlaceHolder(
                                name = "Route 2",
                                background = MaterialTheme.colorScheme.tertiaryContainer,
                                button = "Pop to route 1",
                                onClick = { controller.popBackStack() }
                            )
                        }
                    )
                }
            )
        }
    }
}