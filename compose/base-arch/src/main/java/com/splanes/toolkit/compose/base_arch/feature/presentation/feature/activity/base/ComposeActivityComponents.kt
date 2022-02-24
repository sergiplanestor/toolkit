package com.splanes.toolkit.compose.base_arch.feature.presentation.feature.activity.base

/*
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BaseComponentActivity.NavHost() {
    var isLogged: Boolean by remember { mutableStateOf(false) }
    val controller = rememberAnimatedNavController()
    val (route, transitions) = navGraphStartDestination()
    AnimatedNavHost(
        navController = controller,
        startDestinationRoute = route,
        startDestinationTransition = transitions,
        builder = {
            onCreateNavGraph(controller)
            if (!isLogged) {
                Timber.d(message = logStyle { "Nav graph created." })
                isLogged = true
            }
        }
    )
}*/
