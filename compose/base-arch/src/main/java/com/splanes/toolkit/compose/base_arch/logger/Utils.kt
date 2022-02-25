package com.splanes.toolkit.compose.base_arch.logger

import com.splanes.toolkit.compose.base_arch.BuildConfig
import timber.log.Timber

fun d(msg: String) {
    if (BuildConfig.DEBUG) {
        Timber.d(logStyle { msg })
    }
}

fun e(msg: String) {
    if (BuildConfig.DEBUG) {
        Timber.e(logStyle { msg })
    }
}

fun e(t: Throwable) {
    if (BuildConfig.DEBUG) {
        Timber.e(t)
    }
}

fun <T> logAndError(message: String): T {
    with(logStyle { message }) {
        if (BuildConfig.DEBUG) {
            Timber.e(this)
        }
        error(this)
    }
}

fun <T> Throwable.logAndThrow(): T {
    if (BuildConfig.DEBUG) {
        Timber.e(this, logStyle { message ?: "Throwable thrown with empty message" })
    }
    throw this
}