package com.splanes.toolkit.compose.ui.theme.default.typographies

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.splanes.toolkit.compose.ui.theme.R.font as ToolkitUiThemeFonts

object FontFamilyDefault {

    val mangoSticky by lazy {
        FontFamily(
            Font(ToolkitUiThemeFonts.mango_sticky, FontWeight.Light),
            Font(ToolkitUiThemeFonts.mango_sticky, FontWeight.Normal),
            Font(ToolkitUiThemeFonts.mango_sticky, FontWeight.Medium),
            Font(ToolkitUiThemeFonts.mango_sticky, FontWeight.Bold)
        )
    }
    val bentonSansCondensed by lazy {
        FontFamily(
            Font(ToolkitUiThemeFonts.benton_sans_condensed_regular, FontWeight.Light),
            Font(ToolkitUiThemeFonts.benton_sans_condensed_regular, FontWeight.Normal),
            Font(ToolkitUiThemeFonts.benton_sans_condensed_medium, FontWeight.Medium),
            Font(ToolkitUiThemeFonts.benton_sans_condensed_bold, FontWeight.Bold)
        )
    }
    val apercuPro by lazy {
        FontFamily(
            Font(ToolkitUiThemeFonts.apercu_pro_light, FontWeight.Light),
            Font(ToolkitUiThemeFonts.apercu_pro_regular, FontWeight.Normal),
            Font(ToolkitUiThemeFonts.apercu_pro_medium, FontWeight.Medium),
            Font(ToolkitUiThemeFonts.apercu_pro_bold, FontWeight.Bold)
        )
    }
}