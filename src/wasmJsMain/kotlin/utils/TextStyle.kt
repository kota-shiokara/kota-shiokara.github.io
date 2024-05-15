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
                WindowWidthSize.Compact -> MaterialTheme.typography.h6
                WindowWidthSize.Medium,
                WindowWidthSize.Expanded -> {
                    MaterialTheme.typography.h3
                }
            }
        }

        @Composable
        fun sectionTitleStyle(): TextStyle {
            val windowWidth = LocalWindowWidth.current

            return when (WindowWidthSize.fromDp(windowWidth)) {
                WindowWidthSize.Compact -> MaterialTheme.typography.h6
                WindowWidthSize.Medium,
                WindowWidthSize.Expanded -> {
                    MaterialTheme.typography.h3
                }
            }
        }

        @Composable
        fun contentBigStyle(): TextStyle {
            val windowWidth = LocalWindowWidth.current

            return when (WindowWidthSize.fromDp(windowWidth)) {
                WindowWidthSize.Compact -> MaterialTheme.typography.h6
                WindowWidthSize.Medium,
                WindowWidthSize.Expanded -> {
                    MaterialTheme.typography.h4
                }
            }
        }

        @Composable
        fun contentStyle(): TextStyle {
            val windowWidth = LocalWindowWidth.current

            return when (WindowWidthSize.fromDp(windowWidth)) {
                WindowWidthSize.Compact -> MaterialTheme.typography.subtitle1
                WindowWidthSize.Medium,
                WindowWidthSize.Expanded -> {
                    MaterialTheme.typography.h6
                }
            }
        }
    }
}