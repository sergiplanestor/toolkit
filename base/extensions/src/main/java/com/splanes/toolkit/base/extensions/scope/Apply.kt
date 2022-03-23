package com.splanes.toolkit.base.extensions.scope

fun <T> T.applyIf(cond: Boolean, default: T = this, block: T.() -> T): T =
    if (cond) block() else default