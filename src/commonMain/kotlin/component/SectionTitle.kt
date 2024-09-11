package component

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import theme.ShiokaraTheme
import utils.ShiokaraTextStyle

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun SectionTitle(
    icon: @Composable () -> Unit = {
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Default",
            tint = MaterialTheme.colorScheme.primary
        )
    },
    title: String,
    modifier: Modifier = Modifier
) {
    val windowSizeClass = calculateWindowSizeClass()

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        verticalAlignment = Alignment.CenterVertically
    ) {
        icon()
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = title,
            color = Color.Black,
            style = ShiokaraTextStyle.sectionTitleStyle(windowSizeClass.widthSizeClass)
        )
    }
}

@Preview
@Composable
private fun SectionTitlePreview() {
    ShiokaraTheme {
        SectionTitle(
            title = ""
        )
    }
}
