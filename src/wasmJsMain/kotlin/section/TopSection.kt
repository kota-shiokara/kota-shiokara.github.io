package section

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import component.AvatarImage
import component.LinkIconRow
import utils.Texts
import utils.WindowWidthSize
import utils.primaryColor

@Composable
fun TopSection(
    modifier: Modifier = Modifier,
    maxWidth: Dp = 0.dp,
    maxHeight: Dp = 0.dp
) {
    Column(
        modifier = modifier
            .size(maxWidth, maxHeight)
            .background(primaryColor)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            AvatarImage(
                imageUrl = "https://avatars.githubusercontent.com/u/50353938?s=96&v=4",
                contentDescription = "kota-shiokara",
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape),
            )

            Spacer(modifier = Modifier.size(16.dp))

            Text(
                text = "${Texts.WelcomeToPortfolioLabel}",
                color = Color.White,
                style = when (WindowWidthSize.fromDp(maxWidth)) {
                    WindowWidthSize.Compact -> MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold)
                    WindowWidthSize.Medium,
                    WindowWidthSize.Expanded -> {
                        MaterialTheme.typography.h3.copy(fontWeight = FontWeight.Bold)
                    }
                }
            )

            Spacer(modifier = Modifier.size(16.dp))

            LinkIconRow()
        }

        val infiniteTransition = rememberInfiniteTransition()
        val tint by infiniteTransition.animateColor(
            initialValue = Color.White,
            targetValue = Color.White.copy(alpha = 0f),
            animationSpec = infiniteRepeatable(
                animation = tween(800, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )
        Icon(
            Icons.Default.ArrowDropDown,
            contentDescription = null,
            modifier = Modifier.size(100.dp),
            tint = tint
        )
    }
}