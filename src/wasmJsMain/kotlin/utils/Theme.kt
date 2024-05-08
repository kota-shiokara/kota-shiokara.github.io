package utils

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val primaryColor = Color(0xFFF5B1AA)

// jetsnackより引用
// ref: https://github.com/JetBrains/compose-multiplatform/blob/master/examples/jetsnack/common/src/commonMain/kotlin/com/example/jetsnack/ui/theme/Theme.kt
@Composable
fun ShiokaraTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
//    val colors = if (darkTheme) DarkColorPalette else LightColorPalette

// TODO: implement setSystemBarsColor for android!
//    val sysUiController = rememberSystemUiController()
//    SideEffect {
//        sysUiController.setSystemBarsColor(
//            color = colors.uiBackground.copy(alpha = AlphaNearOpaque)
//        )
//    }

    MaterialTheme(
//        colors = colors,
        typography = Typography,
//        shapes = Shapes,
        content = content
    )
}