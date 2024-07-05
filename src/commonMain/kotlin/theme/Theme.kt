package theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

val LightColorSchema = lightColorScheme(
    primary = primaryColor
)

val DarkColorSchema = darkColorScheme(
    primary = primaryColor
)

@Composable
fun ShiokaraTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val schema = if (darkTheme) DarkColorSchema else LightColorSchema

    MaterialTheme(
        colorScheme = schema,
        typography = rememberTypography(),
//        shapes = Shapes,
        content = content
    )
}