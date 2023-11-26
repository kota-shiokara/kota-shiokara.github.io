package component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AvatarImage(
    imageUrl: String,
    contentDescription: String?,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        imageUrl = imageUrl,
        contentDescription = contentDescription,
        modifier = modifier
    )
}
