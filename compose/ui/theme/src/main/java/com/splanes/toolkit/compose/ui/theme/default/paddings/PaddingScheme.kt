package com.splanes.toolkit.compose.ui.theme.default.paddings

import com.splanes.toolkit.compose.ui.theme.feature.paddings.PaddingsDefault
import com.splanes.toolkit.compose.ui.theme.feature.paddings.ThemePaddingScheme

val ThemePaddingSchemeDefault: ThemePaddingScheme by lazy {
    ThemePaddingScheme.build(
        viewportTiny = PaddingsDefault.viewportTiny,
        viewportSmallTiny = PaddingsDefault.viewportSmallTiny,
        viewportSmall = PaddingsDefault.viewportSmall,
        viewportMediumSmall = PaddingsDefault.viewportMediumSmall,
        viewportMedium = PaddingsDefault.viewportMedium,
        viewportMediumLarge = PaddingsDefault.viewportMediumLarge,
        viewportLarge = PaddingsDefault.viewportLarge,
        viewportLargeHuge = PaddingsDefault.viewportLargeHuge,
        viewportHuge = PaddingsDefault.viewportHuge,
        viewportHugeExtra = PaddingsDefault.viewportHugeExtra,
        viewportExtra = PaddingsDefault.viewportExtra,
        componentTiny = PaddingsDefault.componentTiny,
        componentSmallTiny = PaddingsDefault.componentSmallTiny,
        componentSmall = PaddingsDefault.componentSmall,
        componentMediumSmall = PaddingsDefault.componentMediumSmall,
        componentMedium = PaddingsDefault.componentMedium,
        componentMediumLarge = PaddingsDefault.componentMediumLarge,
        componentLarge = PaddingsDefault.componentLarge,
        componentLargeHuge = PaddingsDefault.componentLargeHuge,
        componentHuge = PaddingsDefault.componentHuge,
        componentHugeExtra = PaddingsDefault.componentHugeExtra,
        componentExtra = PaddingsDefault.componentExtra
    )
}