import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocal
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import component.TopPageFooter
import section.AboutMeSection
import section.TopSection
import theme.ShiokaraTheme
import theme.primaryColor

@Composable
fun App() {
    ShiokaraTheme {
        BoxWithConstraints {
            val width = maxWidth
            val height = maxHeight

            CompositionLocalProvider(
                LocalDisplayWidth provides width,
                LocalDisplayHeight provides height
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    item {
                        TopSection()
                    }

                    item {
                        Spacer(modifier = Modifier.size(16.dp))

                        AboutMeSection()
                    }

                    item {
                        TopPageFooter()
                    }
                }
            }
        }
    }
}

val LocalDisplayWidth = staticCompositionLocalOf<Dp> {
    error("No Display Width")
}

val LocalDisplayHeight = staticCompositionLocalOf<Dp> {
    error("No Display Height")
}

@Composable
fun LoadingCircle() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(primaryColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Loading...",
            color = Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))
        CircularProgressIndicator(
            color = Color.White,
            strokeWidth = 8.dp,
            strokeCap = StrokeCap.Round
        )
    }
}
