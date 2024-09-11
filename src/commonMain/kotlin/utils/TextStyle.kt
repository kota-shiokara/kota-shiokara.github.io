package utils

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

class ShiokaraTextStyle {
    companion object {
        @Composable
        fun titleStyle(
            windowWidthSizeClass: WindowWidthSizeClass,
        ): TextStyle = when(windowWidthSizeClass) {
            WindowWidthSizeClass.Compact -> {
                MaterialTheme.typography.titleMedium
            }
            WindowWidthSizeClass.Medium -> {
                MaterialTheme.typography.headlineLarge
            }
            else -> {
                MaterialTheme.typography.displayMedium
            }
        }.copy(
            fontWeight = FontWeight.Bold
        )

        @Composable
        fun sectionTitleStyle(
            windowWidthSizeClass: WindowWidthSizeClass,
        ): TextStyle = when(windowWidthSizeClass) {
            WindowWidthSizeClass.Compact -> {
                MaterialTheme.typography.headlineSmall
            }
            else -> {
                MaterialTheme.typography.headlineLarge
            }
        }

        @Composable
        fun contentBigStyle(): TextStyle = MaterialTheme.typography.bodyLarge
        @Composable
        fun contentStyle(): TextStyle = MaterialTheme.typography.bodySmall
    }
}