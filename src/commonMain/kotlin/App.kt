import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import component.TopPageFooter
import section.AboutMeSection
import section.BlogSection
import section.TopSection
import section.WorkSection
import theme.ShiokaraTheme
import theme.primaryColor

@Composable
fun App() {
    ShiokaraTheme {
        BoxWithConstraints {
            val height = maxHeight
            val sectionSpan = 32.dp

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
            ) {
                item {
                    TopSection(height = height)
                }

                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    AboutMeSection()
                }

                item {
                    Spacer(modifier = Modifier.height(sectionSpan))
                    WorkSection()
                }

                item {
                    Spacer(modifier = Modifier.height(sectionSpan))
                    BlogSection()
                }

                item {
                    TopPageFooter()
                }
            }
        }
    }
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
