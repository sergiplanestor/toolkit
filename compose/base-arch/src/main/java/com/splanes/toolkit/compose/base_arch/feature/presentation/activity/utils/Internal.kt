package com.splanes.toolkit.compose.base_arch.feature.presentation.activity.utils

import com.splanes.toolkit.compose.base_arch.feature.presentation.activity.viewmodel.BaseComponentActivityViewModel
import com.splanes.toolkit.compose.base_arch.logger.logAndError

internal fun <T : BaseComponentActivityViewModel> activityViewModelAccessError(): T =
    logAndError("Attempt to access `activityViewModel` but it was not overridden on your impl.")