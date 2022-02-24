package com.splanes.toolkit.compose.base_arch.feature.presentation.feature.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.annotation.CallSuper
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.splanes.toolkit.compose.base_arch.feature.presentation.feature.activity.base.StatusBarColor
import com.splanes.toolkit.compose.base_arch.feature.presentation.feature.activity.base.config.ComposeActivityConfig
import com.splanes.toolkit.compose.base_arch.feature.presentation.feature.activity.base.logger.LifecycleLogger
import com.splanes.toolkit.compose.base_arch.feature.presentation.feature.activity.base.logger.plantLifecycleObserver
import com.splanes.toolkit.compose.base_arch.feature.presentation.feature.activity.base.setAppThemeContent
import com.splanes.toolkit.compose.base_arch.feature.presentation.feature.activity.navgraph.transition.NavGraphTransition
import com.splanes.toolkit.compose.base_arch.logger.logStyle
import timber.log.Timber

abstract class BaseComponentActivity<VM : BaseComponentActivityViewModel> : ComponentActivity() {

    private val lifecycleLogger: LifecycleLogger = plantLifecycleObserver()
    private var isComponentDataLoaded: Boolean = false

    open val activityViewModel: VM
        @Composable
        get() {
            logStyle {
                "Attempt to access `activityViewModel` but it was not overridden on your " +
                        "BaseComponentActivity impl."
            }.run {
                Timber.e(message = this)
                error(this)
            }
        }

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
            StatusBarColor()
        }
        lifecycleLogger.onActivityComponentCreated()
    }

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