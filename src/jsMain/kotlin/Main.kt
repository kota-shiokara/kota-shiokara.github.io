import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import components.parts.LinkIconRow
import org.jetbrains.skiko.wasm.onWasmReady
import utils.BrowserViewportWindow

fun main() {
    onWasmReady {
        BrowserViewportWindow("kota-shiokara's Portfolio") {
            Surface {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color(0xFFF5B1AA)),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Image")
                    Text("Welcome to kota-shiokara's portfolio")
                    LinkIconRow()
                }
            }
        }
    }
}
