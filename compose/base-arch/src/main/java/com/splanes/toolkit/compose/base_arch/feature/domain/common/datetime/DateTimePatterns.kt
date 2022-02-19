package com.splanes.toolkit.compose.base_arch.feature.domain.common.datetime

object DateTimePatterns {
    val ISO8601: String by lazy { "yyyy-MM-dd'T'HH:mm:ss.SSS" }
    val DD_MM_YY_HYPHEN by lazy { "dd-MM-YY" }
    val DD_MM_YYYY_HYPHEN by lazy { "dd-MM-YYYY" }
    val DD_MM_YY_SLASH by lazy { "dd/MM/YY" }
    val DD_MM_YYYY_SLASH by lazy { "dd/MM/YYYY" }
}