package section

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import component.VerticalDivider
import utils.Texts
import utils.WindowWidthMedium
import utils.WindowWidthSize
import utils.primaryColor

@Composable
fun AboutMeSection(
    modifier: Modifier = Modifier,
    maxWidth: Dp = WindowWidthMedium
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        SectionTitle(
            title = "${Texts.AboutMe}",
            maxWidth = maxWidth
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column {
            Row {

            }
        }
    }
}

@Composable
fun SectionTitle(
    title: String,
    modifier: Modifier = Modifier,
    maxWidth: Dp = WindowWidthMedium
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ) {
        Spacer(modifier = Modifier.width(32.dp))
        VerticalDivider(
            color = primaryColor,
            thickness = 8.dp
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = title,
            color = Color.Black,
            style = when (WindowWidthSize.fromDp(maxWidth)) {
                WindowWidthSize.Compact -> MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold)
                WindowWidthSize.Medium,
                WindowWidthSize.Expanded -> {
                    MaterialTheme.typography.h3.copy(fontWeight = FontWeight.Bold)
                }
            }
        )
    }
}