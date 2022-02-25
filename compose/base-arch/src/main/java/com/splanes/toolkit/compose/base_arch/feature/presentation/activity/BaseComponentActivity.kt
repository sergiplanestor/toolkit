package com.splanes.toolkit.compose.base_arch.feature.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.annotation.CallSuper
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.splanes.toolkit.compose.base_arch.feature.presentation.activity.contract.ActivityUiSideEffect
import com.splanes.toolkit.compose.base_arch.feature.presentation.activity.logger.LifecycleLogger
import com.splanes.toolkit.compose.base_arch.feature.presentation.activity.logger.plantLifecycleObserver
import com.splanes.toolkit.compose.base_arch.feature.presentation.activity.utils.*
import com.splanes.toolkit.compose.base_arch.feature.presentation.activity.viewmodel.BaseComponentActivityViewModel
import com.splanes.toolkit.compose.base_arch.feature.presentation.component.contract.utils.UiSideEffect
import com.splanes.toolkit.compose.ui.components.feature.dialog.component.DialogComponent
import com.splanes.toolkit.compose.ui.components.feature.statusbar.model.StatusBarColors
import com.splanes.toolkit.compose.ui.theme.utils.accessors.Colors
import kotlinx.coroutines.flow.Flow

abstract class BaseComponentActivity<VM : BaseComponentActivityViewModel> : ComponentActivity() {

    private val lifecycleLogger: LifecycleLogger = plantLifecycleObserver()
    private var isComponentDataLoaded: Boolean = false

    open val activityViewModel: VM @Composable get() = activityViewModelAccessError()

    open val initialStatusBarColor @Composable get() = StatusBarColors(Colors.primary)

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

    @Composable
    abstract fun ActivityContentComponent(activityViewModel: VM)

    protected open fun onCreateActivityComponent() {
        setAppThemeContent {
            with(activityViewModel) {
                updateStatusBarColors(initialStatusBarColor)

                val dialogUiModel by dialogState()
                val snackBarUiModel by snackBarState()
                val loaderUiModel by loaderState()

                dialogUiModel?.let { DialogComponent(it) }
                // SnackBarComponent(dialogUiModel)
                // LoaderComponent(dialogUiModel)

                ActivitySideEffectsHandler(flow = uiSideEffect)
                ActivityContentComponent(activityViewModel = this)
            }
        }
        lifecycleLogger.onActivityComponentCreated()
    }

    @CallSuper
    protected open fun onLoadComponentData(): Boolean {
        lifecycleLogger.onLoadComponentData()
        return false
    }

    @CallSuper
    protected open fun onSaveChanges() {
        lifecycleLogger.onSaveChanges()
    }

    @Composable
    protected open fun ActivitySideEffectsHandler(flow: Flow<ActivityUiSideEffect>) {
        UiSideEffect(flow = flow, consumer = ::handleSideEffect)
    }
}