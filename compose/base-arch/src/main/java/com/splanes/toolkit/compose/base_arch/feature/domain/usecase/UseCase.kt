package com.splanes.toolkit.compose.base_arch.feature.domain.usecase

import com.splanes.toolkit.compose.base_arch.feature.domain.common.datetime.timerange.TimeRange
import com.splanes.toolkit.compose.base_arch.feature.domain.common.datetime.timerange.deadline
import com.splanes.toolkit.compose.base_arch.feature.domain.common.datetime.timerange.timeout
import com.splanes.toolkit.compose.base_arch.feature.domain.common.datetime.timestamp.Timestamp
import com.splanes.toolkit.compose.base_arch.feature.domain.common.datetime.timestamp.minus
import com.splanes.toolkit.compose.base_arch.feature.domain.common.datetime.timestamp.now
import com.splanes.toolkit.compose.base_arch.feature.domain.usecase.utils.log
import kotlinx.coroutines.withTimeout

interface UseCase<Params, Data> {

    suspend operator fun invoke(request: Request<Params>): Result<Data> {
        val result: Result<Data> = with(request) {
            log(this::class.simpleName)
            try {
                val data = withTimeout(timeMillis = timeout.deadline()) {
                    execute(id, params)
                }
                val timestamp = now()
                Success(
                    fromRequestId = id,
                    timestamp = timestamp,
                    elapsed = TimeRange(from = timestamp, to = timestamp),
                    data = data
                )
            } catch (throwable: Throwable) {
                val timestamp = now()
                Error(
                    fromRequestId = id,
                    timestamp = timestamp,
                    elapsed = TimeRange(from = timestamp, to = timestamp),
                    cause = throwable
                )
            }
        }
        return result.also { it.log(this::class.simpleName) }
    }

    suspend fun execute(id: String, params: Params): Data

    data class Request<out T>(
        val id: String,
        val params: T,
        val timestamp: Timestamp = now(),
        val timeout: TimeRange = timeout(20L),
    ) {
        override fun toString() = buildString {
            appendLine("[UseCase.Request]")
            appendLine("[RequestId: `$id`]")
            appendLine("[Timestamp: `$timestamp`]")
            appendLine("[Timeout: from(`${timeout.from}`) - to(`${timeout.to}`) -> `${(timeout.to - timeout.from)}`]")
            appendLine("[Params: type(`${params?.let { it::class.simpleName }}`) -> value(`${params.toString()}`)]")
            appendLine("[xxxxxxxxxxxxxxxxxxxxxx]")
        }
    }

    sealed class Result<out T>(
        open val fromRequestId: String,
        open val timestamp: Timestamp = now(),
        open val elapsed: TimeRange,
    )

    data class Success<out T>(
        override val fromRequestId: String,
        override val timestamp: Timestamp = now(),
        override val elapsed: TimeRange,
        val data: T,
    ) : Result<T>(fromRequestId, timestamp, elapsed) {
        override fun toString() = buildString {
            appendLine("[UseCase.Result.Success]")
            appendLine("[RequestId: `$fromRequestId`]")
            appendLine("[Timestamp: `$timestamp`]")
            appendLine("[Elapsed: from(`${elapsed.from}`) - to(`${elapsed.to}`) -> `${(elapsed.to - elapsed.from)}`]")
            appendLine("[Data: type(`${data?.let { it::class.simpleName }}`) -> value(`${data.toString()}`)]")
            appendLine("[xxxxxxxxxxxxxxxxxxxxxx]")
        }
    }

    data class Error<out T>(
        override val fromRequestId: String,
        override val timestamp: Timestamp = now(),
        override val elapsed: TimeRange,
        val cause: Throwable? = null,
    ) : Result<T>(fromRequestId, timestamp, elapsed) {
        override fun toString() = buildString {
            appendLine("[UseCase.Result.Error]")
            appendLine("[RequestId: `$fromRequestId`]")
            appendLine("[Timestamp: `$timestamp`]")
            appendLine("[Elapsed: from(`${elapsed.from}`) - to(`${elapsed.to}`) -> `${(elapsed.to - elapsed.from)}`]")
            appendLine("[Cause: `${cause.toString()}`]")
            appendLine("[xxxxxxxxxxxxxxxxxxxxxx]")
        }
    }
}