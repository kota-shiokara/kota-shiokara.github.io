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
                MaterialTheme.typography.headlineMedium
            }
            else -> {
                MaterialTheme.typography.displaySmall
            }
        }.copy(
            fontWeight = FontWeight.Bold
        )

        @Composable
        fun contentLargeStyle(
            windowWidthSizeClass: WindowWidthSizeClass,
        ): TextStyle = when(windowWidthSizeClass) {
            WindowWidthSizeClass.Compact -> {
                MaterialTheme.typography.headlineSmall
            }
            else -> {
                MaterialTheme.typography.headlineMedium
            }
        }

        @Composable
        fun contentLargeBoldStyle(
            windowWidthSizeClass: WindowWidthSizeClass,
        ): TextStyle = contentLargeStyle(windowWidthSizeClass)
            .copy(
                fontWeight = FontWeight.Bold
            )

        @Composable
        fun contentStyle(
            windowWidthSizeClass: WindowWidthSizeClass,
        ): TextStyle = when(windowWidthSizeClass) {
            WindowWidthSizeClass.Compact -> {
                MaterialTheme.typography.titleMedium
            }
            else -> {
                MaterialTheme.typography.headlineSmall
            }
        }

        @Composable
        fun contentBoldStyle(
            windowWidthSizeClass: WindowWidthSizeClass,
        ): TextStyle = contentStyle(windowWidthSizeClass)
            .copy(
                fontWeight = FontWeight.Bold
            )
    }
}