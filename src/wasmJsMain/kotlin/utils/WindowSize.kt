package utils

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val WindowWidthMedium = 600.dp
val WindowWidthExpanded = 840.dp

sealed class WindowWidthSize {
    data object Compact : WindowWidthSize()
    data object Medium : WindowWidthSize()
    data object Expanded : WindowWidthSize()

    companion object {
        fun fromDp(width: Dp): WindowWidthSize {
            return when {
                width <= WindowWidthMedium -> Compact
                width <= WindowWidthExpanded -> Medium
                else -> Expanded
            }
        }
    }
}