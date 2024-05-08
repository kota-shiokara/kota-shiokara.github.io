package section

import LocalWindowHeight
import LocalWindowWidth
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
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import component.AvatarImage
import component.LinkIconRow
import utils.Resource
import utils.ShiokaraTextStyle
import utils.Texts
import utils.primaryColor

@Composable
fun TopSection(
    modifier: Modifier = Modifier
) {
    val windowWidth = LocalWindowWidth.current
    val windowHeight = LocalWindowHeight.current

    Column(
        modifier = modifier
            .size(windowWidth, windowHeight)
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
                imageUrl = Resource.Strings.AVATAR_IMAGE_URL,
                contentDescription = "kota-shiokara",
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape),
            )

            Spacer(modifier = Modifier.size(16.dp))

            Text(
                text = "${Texts.WelcomeToPortfolioLabel}",
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
