package utils

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// jetsnackより引用
// ref: https://github.com/JetBrains/compose-multiplatform/blob/master/examples/jetsnack/common/src/commonMain/kotlin/com/example/jetsnack/ui/theme/Type.kt

var NotoSans: FontFamily? = null

val Typography by lazy {
    Typography(
        h1 = TextStyle(
            fontFamily = NotoSans,
            fontSize = 96.sp,
            fontWeight = FontWeight.Light,
            lineHeight = 117.sp,
            letterSpacing = (-1.5).sp,
        ),
        h2 = TextStyle(
            fontFamily = NotoSans,
            fontSize = 60.sp,
            fontWeight = FontWeight.Light,
            lineHeight = 73.sp,
            letterSpacing = (-0.5).sp
        ),
        h3 = TextStyle(
            fontFamily = NotoSans,
            fontSize = 48.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 59.sp
        ),
        h4 = TextStyle(
            fontFamily = NotoSans,
            fontSize = 30.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 37.sp
        ),
        h5 = TextStyle(
            fontFamily = NotoSans,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 29.sp
        ),
        h6 = TextStyle(
            fontFamily = NotoSans,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 24.sp
        ),
        subtitle1 = TextStyle(
            fontFamily = NotoSans,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 24.sp,
            letterSpacing = 0.15.sp
        ),
        subtitle2 = TextStyle(
            fontFamily = NotoSans,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 24.sp,
            letterSpacing = 0.1.sp
        ),
        body1 = TextStyle(
            fontFamily = NotoSans,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 28.sp,
            letterSpacing = 0.15.sp
        ),
        body2 = TextStyle(
            fontFamily = NotoSans,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 20.sp,
            letterSpacing = 0.25.sp
        ),
        button = TextStyle(
            fontFamily = NotoSans,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 16.sp,
            letterSpacing = 1.25.sp
        ),
        caption = TextStyle(
            fontFamily = NotoSans,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 16.sp,
            letterSpacing = 0.4.sp
        ),
        overline = TextStyle(
            fontFamily = NotoSans,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 16.sp,
            letterSpacing = 1.sp
        )
    )
}