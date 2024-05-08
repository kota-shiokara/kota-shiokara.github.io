import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.CanvasBasedWindow
import component.TopPageFooter
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.configureWebResources
import org.jetbrains.compose.resources.urlResource
import section.AboutMeSection
import utils.Resource
import utils.Texts

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
//                        TopSection()
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
