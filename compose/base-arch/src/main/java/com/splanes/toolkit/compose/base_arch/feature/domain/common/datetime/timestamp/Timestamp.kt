package com.splanes.toolkit.compose.base_arch.feature.domain.common.datetime.timestamp

data class Timestamp(val millis: Long) : Comparable<Timestamp> {
    override fun compareTo(other: Timestamp): Int =
        compareBy<Timestamp> { it.millis }.compare(this, other)

    override fun toString(): String = format()
}
