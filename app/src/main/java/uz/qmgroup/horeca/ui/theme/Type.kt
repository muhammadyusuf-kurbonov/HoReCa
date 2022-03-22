package uz.qmgroup.horeca.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import uz.qmgroup.horeca.R

val fontBw = FontFamily(
    Font(R.font.bw_mitga_regular, FontWeight.Normal),
    Font(R.font.bw_mitga_bold, FontWeight.Bold),
    Font(R.font.bw_mitga_black, FontWeight.Black)
)

// Set of Material typography styles to start with
val Typography = Typography(
    defaultFontFamily = fontBw,
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)