package com.splanes.toolkit.compose.base_arch.feature.domain.common.datetime.timerange

import com.splanes.toolkit.compose.base_arch.feature.domain.common.datetime.timestamp.Timestamp
import com.splanes.toolkit.compose.base_arch.feature.domain.common.datetime.timestamp.now
import com.splanes.toolkit.compose.base_arch.feature.domain.common.datetime.timestamp.timestamp

fun timeout(millisToTimeout: Long) : TimeRange =
    TimeRange(from = now(), to = timestamp(millisToTimeout))

fun TimeRange.deadline(): Long =
    to.millis

fun TimeRange.isBelow(other: Timestamp = now()): Boolean =
    other < this

fun TimeRange.isOver(other: Timestamp = now()): Boolean =
    other > this

operator fun TimeRange.compareTo(other: Timestamp): Int =
    when {
        other > to -> 1
        other in from..to -> 0
        else -> -1
    }

operator fun Timestamp.compareTo(other: TimeRange): Int =
    when {
        this > other.to -> 1
        this in other.from..other.to -> 0
        else -> -1
    }
