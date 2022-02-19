package com.splanes.toolkit.compose.base_arch.logger

const val ARROW_IN = "<<<---"
const val ARROW_OUT = "--->>>"

fun logStyle(builder: () -> String): String = buildString {
    appendLine(ARROW_IN)
    appendLine(value = builder())
    append(ARROW_OUT)
}