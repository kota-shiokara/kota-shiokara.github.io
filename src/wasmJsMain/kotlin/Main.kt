import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.CanvasBasedWindow
import component.AvatarImage
import component.KotaBackground
import component.LinkIconRow
import component.TopPageFooter
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.configureWebResources
import org.jetbrains.compose.resources.urlResource
import utils.TabletPortraitWidth
import utils.Texts

@OptIn(ExperimentalComposeUiApi::class, ExperimentalResourceApi::class)
fun main() {
    configureWebResources {
        setResourceFactory { urlResource("./$it") }
    }

    CanvasBasedWindow(
        title = "${Texts.AppName}",
        canvasElementId = "ComposeTarget"
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                TopPageFooter()
            }
        ) {
            KotaBackground()

            BoxWithConstraints(
                modifier = Modifier.fillMaxSize()
            ) {
                val maxWidth = maxWidth

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val interactionSource = remember { MutableInteractionSource() }
                    val isHovered by interactionSource.collectIsHoveredAsState()
                    var isExpanded by remember { mutableStateOf(false) }

                    AvatarImage(
                        imageUrl = "https://avatars.githubusercontent.com/u/50353938?s=96&v=4",
                        contentDescription = "kota-shiokara",
                        modifier = Modifier
                            .size(150.dp)
                            .clip(CircleShape)
                            .hoverable(interactionSource = interactionSource)
                            .clickable {
                                isExpanded = !isExpanded
                            },
                        colorFilter = if (isHovered) {
                            ColorFilter.tint(
                                color = Color.White.copy(alpha = 0.2f),
                                blendMode = BlendMode.Plus
                            )
                        } else {
                            null
                        }
                    )

                    Spacer(modifier = Modifier.size(16.dp))

                    if (isExpanded) {
                        Spacer(modifier = Modifier.size(16.dp))

                        Text(
                            text = "${Texts.AboutMe}",
                            color = Color.White,
                            style = MaterialTheme.typography.body2
                        )
                    } else {
                        WelcomeBoard(maxWidth)
                    }
                }
            }
        }
    }
}


@Composable
fun WelcomeBoard(
    maxWidth: Dp,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "${Texts.WelcomeToPortfolio}",
            color = Color.White,
            style = if (maxWidth > TabletPortraitWidth) {
                MaterialTheme.typography.h3.copy(fontWeight = FontWeight.Bold)
            } else {
                MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold)
            }
        )

        Spacer(modifier = Modifier.size(16.dp))

        LinkIconRow()
    }
}