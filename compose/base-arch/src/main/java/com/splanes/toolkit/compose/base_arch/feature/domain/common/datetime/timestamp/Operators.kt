package com.splanes.toolkit.compose.base_arch.feature.domain.common.datetime.timestamp

operator fun Timestamp.plus(other: Timestamp): Timestamp =
    Timestamp(millis = millis + other.millis)

operator fun Timestamp.minus(other: Timestamp): Timestamp =
    Timestamp(millis = millis - other.millis)

operator fun Timestamp.rangeTo(other: Timestamp): ClosedRange<Timestamp> =
    object : ClosedRange<Timestamp> {
        override val endInclusive: Timestamp = maxOf(this@rangeTo, other)
        override val start: Timestamp = minOf(this@rangeTo, other)
    }
