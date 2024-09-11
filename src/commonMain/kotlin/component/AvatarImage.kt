package component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter

@Composable
fun AvatarImage(
    imageUrl: String,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    colorFilter: ColorFilter? = null,
) {
    AsyncImage(
        imageUrl = imageUrl,
        contentDescription = contentDescription,
        modifier = modifier,
        colorFilter = colorFilter
    )
}
