package com.splanes.toolkit.compose.base_arch.feature.domain.common.datetime.timestamp

import com.splanes.toolkit.compose.base_arch.feature.domain.common.datetime.DateTimePatterns
import com.splanes.toolkit.compose.base_arch.feature.domain.common.datetime.currentMillis
import java.text.SimpleDateFormat
import java.util.*

fun timestamp(millis: Long): Timestamp = Timestamp(millis)

fun now(): Timestamp = timestamp(currentMillis())

fun Timestamp.format(
    pattern: String = DateTimePatterns.ISO8601,
    locale: Locale = Locale.getDefault()
): String =
    SimpleDateFormat(pattern, locale).format(millis)