package utils

import androidx.compose.ui.graphics.ImageBitmap

expect suspend fun fetchImageBitmap(url: String): ImageBitmap