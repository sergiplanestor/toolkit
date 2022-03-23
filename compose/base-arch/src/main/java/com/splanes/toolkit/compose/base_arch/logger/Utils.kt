package com.splanes.toolkit.compose.base_arch.logger

import timber.log.Timber

fun d(msg: String) {
    Timber.d(logStyle { msg })
}

fun e(msg: String) {
    Timber.e(logStyle { msg })
}

fun e(t: Throwable) {
    Timber.e(t)
}

fun <T> logAndError(message: String): T {
    with(logStyle { message }) {
        Timber.e(this)
        error(this)
    }
}

fun <T> Throwable.logAndThrow(): T {
    Timber.e(this, logStyle { message ?: "Throwable thrown with empty message" })
    throw this
}