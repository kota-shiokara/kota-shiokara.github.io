import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.CompositionLocal
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.CanvasBasedWindow
import component.TopPageFooter
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.configureWebResources
import org.jetbrains.compose.resources.urlResource
import section.AboutMeSection
import section.TopSection
import utils.Texts

@OptIn(ExperimentalComposeUiApi::class, ExperimentalResourceApi::class)
fun main() {
    configureWebResources {
        setResourceFactory { urlResource("./$it") }
    }

    CanvasBasedWindow(
        title = "${Texts.AppName}",
        canvasElementId = "ComposeTarget"
    ) {
        BoxWithConstraints(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
            ) {
                item {
                    TopSection(
                        maxWidth = maxWidth,
                        maxHeight = maxHeight
                    )
                }

                item {
                    Spacer(modifier = Modifier.size(16.dp))

                    AboutMeSection(
                        maxWidth = maxWidth
                    )
                }

                item {
                    TopPageFooter()
                }
            }
        }
    }
}
