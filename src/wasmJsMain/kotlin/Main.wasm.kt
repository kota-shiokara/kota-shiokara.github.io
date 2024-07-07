import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import kotlinx.browser.document

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    document.getElementById("loading")?.remove()
    CanvasBasedWindow(
        title = "kota-shiokara's portfolio",
        canvasElementId = "ComposeTarget"
    ) {
        App()
    }
}