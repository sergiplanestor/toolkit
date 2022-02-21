package com.splanes.toolkit.compose.base_arch.feature.presentation.feature.activity.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.annotation.CallSuper
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.SystemUiController
import com.splanes.toolkit.compose.base_arch.feature.presentation.feature.activity.base.config.ComposeActivityConfig
import com.splanes.toolkit.compose.base_arch.feature.presentation.feature.activity.base.logger.LifecycleLogger
import com.splanes.toolkit.compose.base_arch.feature.presentation.feature.activity.base.logger.plantLifecycleObserver
import com.splanes.toolkit.compose.base_arch.feature.presentation.feature.activity.navgraph.transition.NavGraphTransition
import com.splanes.toolkit.compose.base_arch.feature.presentation.feature.activity.statusbar.DefaultStatusBarUiModel
import timber.log.Timber

abstract class ComposeActivity : ComponentActivity() {

    private val lifecycleLogger: LifecycleLogger = plantLifecycleObserver()
    private var isComponentDataLoaded: Boolean = false

    val systemUiControllerState = mutableStateOf<SystemUiController?>(null)
    val snackBarHostState by lazy { SnackbarHostState() }
    val statusBarState by lazy { mutableStateOf(activityConfig.statusBarUiModel) }

    open lateinit var activityConfig: ComposeActivityConfig

    @Composable
    abstract fun ActivityComponent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateActivityComponent()
    }

    override fun onResume() {
        super.onResume()
        if (!isComponentDataLoaded) {
            isComponentDataLoaded = onLoadComponentData()
        }
    }

    override fun onPause() {
        super.onPause()
        onSaveChanges()
    }

    protected open fun onCreateActivityComponent() {
        setAppThemeContent {
            activityConfig = ComposeActivityConfig(statusBarUiModel = DefaultStatusBarUiModel)
            StatusBarColor()
            ActivityComponentWrapper()
        }
        lifecycleLogger.onActivityComponentCreated()
    }

    open fun onCreateTopBar(): @Composable () -> Unit = {}
    open fun onCreateBottomBar(): @Composable () -> Unit = {}
    open fun navGraphStartDestination(): Pair<String, NavGraphTransition?> {
        val msg = "Attempt to create ComposeActivity.NavHost without override " +
                "`ComposeActivity.navGraphStartDestination` method."
        Timber.e(msg)
        error(msg)
    }

    open fun NavGraphBuilder.onCreateNavGraph(controller: NavHostController) {}

    @CallSuper
    protected open fun onLoadComponentData(): Boolean {
        lifecycleLogger.onLoadComponentData()
        return false
    }

    @CallSuper
    protected open fun onSaveChanges() {
        lifecycleLogger.onSaveChanges()
    }

    @CallSuper
    protected open fun onShowError() {
        lifecycleLogger.onShowError()
    }
}