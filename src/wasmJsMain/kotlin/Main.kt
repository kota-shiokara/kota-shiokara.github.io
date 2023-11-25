import androidx.compose.material.Text
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasBasedWindow(
        title = "kota-shiokara's portfolio",
        canvasElementId = "ComposeTarget"
    ) {
        Text("Hello, world!")
    }
}
