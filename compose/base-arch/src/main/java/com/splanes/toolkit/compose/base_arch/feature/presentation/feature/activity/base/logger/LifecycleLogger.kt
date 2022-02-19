package com.splanes.toolkit.compose.base_arch.feature.presentation.feature.activity.base.logger

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.splanes.toolkit.compose.base_arch.logger.logStyle
import timber.log.Timber

interface LifecycleLogger : DefaultLifecycleObserver {

    var onResumeCount: Int
    var onPauseCount: Int
    var onLoadComponentDataCount: Int
    var onShowErrorCount: Int

    override fun onCreate(owner: LifecycleOwner) {
        Timber.d(logStyle { "Lifecycle: onCreate() called." })
    }

    override fun onStart(owner: LifecycleOwner) {
        Timber.d(logStyle { "Lifecycle: onStart()" })
    }

    override fun onResume(owner: LifecycleOwner) {
        onResumeCount++
        Timber.d(logStyle { "Lifecycle: onResume() called. Counter [%d]" }, onResumeCount)
    }

    override fun onPause(owner: LifecycleOwner) {
        onPauseCount++
        Timber.d(logStyle { "Lifecycle: onPause() called. Counter [%d]" }, onPauseCount)
    }

    override fun onStop(owner: LifecycleOwner) {
        Timber.d(logStyle { "Lifecycle: onStop() called." })
    }

    override fun onDestroy(owner: LifecycleOwner) {
        Timber.d(logStyle { "Lifecycle: onDestroy() called." })
        onResumeCount = 0
        onPauseCount = 0
        owner.lifecycle.removeObserver(this)
    }

    fun onLoadComponentData() {
        onLoadComponentDataCount++
        Timber.d(
            logStyle { "Lifecycle: onLoadComponentData() called. Counter [%d]" },
            onLoadComponentDataCount
        )
    }

    fun onSaveChanges() {
        Timber.d(logStyle { "Lifecycle: onSaveChanges() called." })
    }

    fun onActivityComponentCreated() {
        Timber.d(logStyle { "Lifecycle: ActivityComponent() called." })
    }

    fun onShowError(error: Throwable? = null) {
        onShowErrorCount++
        Timber.d(logStyle { "Lifecycle: onShowError() called. Counter [%d]" }, onShowErrorCount)
        Timber.e(error)
    }
}

fun buildLifecycleLogger(): LifecycleLogger =
    object : LifecycleLogger {
        override var onResumeCount: Int = 0
        override var onPauseCount: Int = 0
        override var onLoadComponentDataCount: Int = 0
        override var onShowErrorCount: Int = 0
    }

fun LifecycleOwner.plantLifecycleObserver(): LifecycleLogger =
    buildLifecycleLogger().also(lifecycle::addObserver)
