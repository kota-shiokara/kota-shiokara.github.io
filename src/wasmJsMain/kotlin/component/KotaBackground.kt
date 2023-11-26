package component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import utils.primaryColor

@Composable
fun KotaBackground(
    modifier: Modifier = Modifier,
    enabled: Boolean = false
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(if (!enabled) primaryColor else Color.Transparent)
    ) {
        if (enabled) {
            AsyncImage(
                imageUrl = "img/Kota_Background.png",
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }
    }
}