import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.CanvasBasedWindow
import component.TopPageFooter
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.configureWebResources
import org.jetbrains.compose.resources.urlResource
import section.AboutMeSection
import section.TopSection
import utils.ImageLoader
import utils.NotoSans
import utils.Resource
import utils.ShiokaraTheme
import utils.primaryColor
import utils.toByteArray

val LocalWindowWidth = compositionLocalOf<Dp> { error("No WindowWidth provided") }
val LocalWindowHeight = compositionLocalOf<Dp> { error("No WindowHeight provided") }

@OptIn(ExperimentalComposeUiApi::class, ExperimentalResourceApi::class)
fun main() {
    configureWebResources {
        setResourceFactory { urlResource("./$it") }
    }

    CanvasBasedWindow(
        title = Resource.Strings.APP_NAME,
        canvasElementId = "ComposeTarget"
    ) {
        var loading: Boolean by remember { mutableStateOf(true) }

        if (loading) {
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
        } else {
            ShiokaraTheme {
                App()
            }
        }


        LaunchedEffect(Unit) {
            loadNotoSansFont()
            loading = false
        }
    }
}

@Composable
fun App() {
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        var windowWidth by remember { mutableStateOf(maxWidth) }
        var windowHeight by remember { mutableStateOf(maxHeight) }

        LaunchedEffect(maxWidth) {
            windowWidth = maxWidth
        }

        LaunchedEffect(maxHeight) {
            windowHeight = maxHeight
        }

        CompositionLocalProvider(
            LocalWindowWidth provides windowWidth,
            LocalWindowHeight provides windowHeight
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

// jetsnackより引用
// ref: https://github.com/JetBrains/compose-multiplatform/blob/master/examples/jetsnack/common/src/commonMain/kotlin/com/example/jetsnack/ui/theme/Type.kt
private suspend fun loadNotoSansFont() {
    val medium = loadResource("NotoSansJP-Medium.ttf")
    val regular = loadResource("NotoSansJP-Regular.ttf")
    val black = loadResource("NotoSansJP-Black.ttf")
    val bold = loadResource("NotoSansJP-Bold.ttf")
    val extraBold = loadResource("NotoSansJP-ExtraBold.ttf")
    val extraLight = loadResource("NotoSansJP-ExtraLight.ttf")
    val light = loadResource("NotoSansJP-Light.ttf")
    val semiBold = loadResource("NotoSansJP-SemiBold.ttf")
    val thin = loadResource("NotoSansJP-Thin.ttf")

    NotoSans = FontFamily(
        Font(identity = "NotoSansJPMedium", data = medium, weight = FontWeight.Medium),
        Font(identity = "NotoSansJPRegular", data = regular, weight = FontWeight.Normal),
        Font(identity = "NotoSansJPBlack", data = black, weight = FontWeight.Black),
        Font(identity = "NotoSansJPBold", data = bold, weight = FontWeight.Bold),
        Font(identity = "NotoSansJPExtraBold", data = extraBold, weight = FontWeight.ExtraBold),
        Font(identity = "NotoSansJPExtraLight", data = extraLight, weight = FontWeight.ExtraLight),
        Font(identity = "NotoSansJPLight", data = light, weight = FontWeight.Light),
        Font(identity = "NotoSansJPSemiBold", data = semiBold, weight = FontWeight.SemiBold),
        Font(identity = "NotoSansJPThin", data = thin, weight = FontWeight.Thin)
    )
}

internal suspend fun loadResource(path: String): ByteArray {
    return ImageLoader.loadImage(path).toByteArray()
}