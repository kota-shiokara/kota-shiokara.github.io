package utils

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.toComposeImageBitmap
import kotlinx.browser.window
import kotlinx.coroutines.await
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.orEmpty
import org.jetbrains.compose.resources.rememberImageBitmap
import org.jetbrains.compose.resources.resource
import org.jetbrains.skia.Image
import org.khronos.webgl.ArrayBuffer
import org.khronos.webgl.Int8Array
import org.w3c.fetch.Response

@OptIn(ExperimentalResourceApi::class)
@Composable
fun painterResource(res: String): Painter {
    Log.d("painterResource", res)
    return when {
        res.isURLPath() -> {
            val bytes: ByteArray? by produceByteArray(res)
            val localBytes: ByteArray? = bytes

            remember(localBytes) {
                if (localBytes == null) {
                    return@remember ColorPainter(color = Color.Transparent)
                }

                val skiaImage: Image = Image.makeFromEncoded(bytes = localBytes)
                val imageBitmap: ImageBitmap = skiaImage.toComposeImageBitmap()

                BitmapPainter(image = imageBitmap)
            }
        }
        res.isSvgPath() -> {
            ColorPainter(color = Color.White)
        }
        res.isPngPath() -> {
            val rib = resource(res).rememberImageBitmap()
            BitmapPainter(rib.orEmpty())
        }
        else -> {
            ColorPainter(color = Color.White)
        }
    }
}

private fun String.isURLPath(): Boolean {
    return this.startsWith("https://")
}

private fun String.isSvgPath(): Boolean {
    return this.endsWith(".svg")
}

private fun String.isPngPath(): Boolean {
    return this.endsWith(".png")
}

@Composable
private fun produceByteArray(res: String): State<ByteArray?> {
    return produceState<ByteArray?>(null, res) {
        val response: Response = window.fetch(res).await()

        if (response.ok.not()) {
            Log.d(res = "can't load data from $res")
            return@produceState
        }

        val buffer: ArrayBuffer = response.arrayBuffer().await()

        value = Int8Array(buffer) as ByteArray?
    }
}
