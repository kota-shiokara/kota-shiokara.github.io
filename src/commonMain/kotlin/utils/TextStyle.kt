package utils

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle

class ShiokaraTextStyle {
    companion object {
        @Composable
        fun titleStyle(): TextStyle = MaterialTheme.typography.titleSmall
        @Composable
        fun sectionTitleStyle(): TextStyle = MaterialTheme.typography.titleSmall
        @Composable
        fun contentBigStyle(): TextStyle = MaterialTheme.typography.bodyLarge
        @Composable
        fun contentStyle(): TextStyle = MaterialTheme.typography.bodySmall
    }
}