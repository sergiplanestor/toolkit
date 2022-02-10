package com.splanes.core.theme.typography.default

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.splanes.core.R.font as CoreFonts

object DefaultFontFamily {
    val mangoSticky by lazy {
        FontFamily(
            Font(CoreFonts.mango_sticky, FontWeight.Light),
            Font(CoreFonts.mango_sticky, FontWeight.Normal),
            Font(CoreFonts.mango_sticky, FontWeight.Medium),
            Font(CoreFonts.mango_sticky, FontWeight.Bold)
        )
    }
    val bentonSansCondensed by lazy {
        FontFamily(
            Font(CoreFonts.benton_sans_condensed_regular, FontWeight.Light),
            Font(CoreFonts.benton_sans_condensed_regular, FontWeight.Normal),
            Font(CoreFonts.benton_sans_condensed_medium, FontWeight.Medium),
            Font(CoreFonts.benton_sans_condensed_bold, FontWeight.Bold)
        )
    }
    val apercuPro by lazy {
        FontFamily(
            Font(CoreFonts.apercu_pro_light, FontWeight.Light),
            Font(CoreFonts.apercu_pro_regular, FontWeight.Normal),
            Font(CoreFonts.apercu_pro_medium, FontWeight.Medium),
            Font(CoreFonts.apercu_pro_bold, FontWeight.Bold)
        )
    }
}