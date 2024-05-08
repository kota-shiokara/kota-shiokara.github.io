package utils

import LocalWindowWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

class ShiokaraTextStyle {
    companion object {
        @Composable
        fun titleStyle(): TextStyle {
            val windowWidth = LocalWindowWidth.current

            return when (WindowWidthSize.fromDp(windowWidth)) {
                WindowWidthSize.Compact -> MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold)
                WindowWidthSize.Medium,
                WindowWidthSize.Expanded -> {
                    MaterialTheme.typography.h3.copy(fontWeight = FontWeight.Bold)
                }
            }
        }

        @Composable
        fun sectionTitleStyle(): TextStyle {
            val windowWidth = LocalWindowWidth.current

            return when (WindowWidthSize.fromDp(windowWidth)) {
                WindowWidthSize.Compact -> MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold)
                WindowWidthSize.Medium,
                WindowWidthSize.Expanded -> {
                    MaterialTheme.typography.h3.copy(fontWeight = FontWeight.Bold)
                }
            }
        }

        @Composable
        fun contentStyle(): TextStyle {
            val windowWidth = LocalWindowWidth.current

            return when (WindowWidthSize.fromDp(windowWidth)) {
                WindowWidthSize.Compact -> MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Bold)
                WindowWidthSize.Medium,
                WindowWidthSize.Expanded -> {
                    MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}