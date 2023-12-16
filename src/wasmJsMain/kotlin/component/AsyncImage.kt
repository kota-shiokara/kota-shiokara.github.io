package component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import utils.ImageLoader
import utils.Log

@Composable
fun AsyncImage(
    imageUrl: String,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
    colorFilter: ColorFilter? = null,
) {
    var bitmap: ImageBitmap? by remember { mutableStateOf(null) }

    if (bitmap != null) {
        Image(
            bitmap!!,
            contentDescription = contentDescription,
            modifier = modifier,
            contentScale = contentScale,
            colorFilter = colorFilter
        )
    }

    LaunchedEffect(imageUrl) {
        runCatching { ImageLoader.fetchImageBitmap(imageUrl) }
            .onSuccess {
                bitmap = it
            }
            .onFailure {
                Log.e(error = it)
                bitmap = null
            }
    }
}