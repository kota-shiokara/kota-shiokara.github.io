package section

import LocalDisplayHeight
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import component.AvatarImage
import component.LinkIconRow
import jp.ikanoshiokara.kota_shiokara.github.io.generated.resources.Res
import jp.ikanoshiokara.kota_shiokara.github.io.generated.resources.section_top_welcome
import org.jetbrains.compose.resources.stringResource

import utils.ShiokaraTextStyle

@Composable
fun TopSection(
    modifier: Modifier = Modifier
) {
    val height = LocalDisplayHeight.current

    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .background(MaterialTheme.colorScheme.primary)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
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
                text = stringResource(Res.string.section_top_welcome),
                color = Color.White,
                style = ShiokaraTextStyle.titleStyle()
            )

            Spacer(modifier = Modifier.size(16.dp))

            LinkIconRow()
        }

        DownNavigator()
    }
}

@Composable
fun DownNavigator(
    modifier: Modifier = Modifier
) {
    // icon size
    val iconSize = 150.dp

    // animation
    val infiniteTransition = rememberInfiniteTransition()
    val firstArrowTint by infiniteTransition.animateColor(
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
        modifier = modifier.size(iconSize),
        tint = firstArrowTint
    )
}
