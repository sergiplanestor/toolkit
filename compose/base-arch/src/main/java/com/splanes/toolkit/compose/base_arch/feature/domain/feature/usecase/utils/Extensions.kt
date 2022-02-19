package com.splanes.toolkit.compose.base_arch.feature.domain.feature.usecase.utils

import com.splanes.toolkit.compose.base_arch.feature.domain.feature.usecase.UseCase
import com.splanes.toolkit.compose.base_arch.logger.logStyle
import timber.log.Timber

fun <T> UseCase.Result<T>.fold(onSuccess: (T) -> Unit = {}, onError: (Throwable?) -> Unit = {}) {
    when (this) {
        is UseCase.Error -> onError(cause)
        is UseCase.Success -> onSuccess(data)
    }
}

fun <T> UseCase.Result<T>.doOnSuccess(block: (T) -> Unit): UseCase.Result<T> =
    apply { fold(onSuccess = block) }

fun <T> UseCase.Result<T>.doOnError(block: (Throwable?) -> Unit): UseCase.Result<T> =
    apply { fold(onError = block) }

fun <T, R> UseCase.Result<T>.map(onSuccess: (T) -> R, onError: (Throwable?) -> R): R =
    when (this) {
        is UseCase.Error -> onError(cause)
        is UseCase.Success -> onSuccess(data)
    }

fun <T> UseCase.Request<T>.log(ucName: String? = null) {
    ucName?.let(Timber::tag)
    Timber.d(logStyle { this.toString() })
}

fun <T> UseCase.Result<T>.log(ucName: String? = null) {
    ucName?.let(Timber::tag)
    Timber.d(logStyle { this.toString() })
}