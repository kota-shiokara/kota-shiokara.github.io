package component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.browser.window
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

private val defaultLinkIconList = listOf(
    LinkIconData(
        link = "https://github.com/kota-shiokara",
        path = "https://github.githubassets.com/favicons/favicon-dark.png",
    ),
    LinkIconData(
        link = "https://twitter.com/shiokara_create",
        path = "img/x_logo.png",
        backgroundColor = Color.Black
    ),
    LinkIconData(
        link = "https://www.instagram.com/kota_bellflower",
        path = "img/instagram_logo.png"
    ),
    LinkIconData(
        link = "https://qiita.com/kotambourine",
        path = "img/qiita.png"
    ),
    LinkIconData(
        link = "https://zenn.dev/kota_shiokara",
        path = "img/zenn_logo.png"
    )
)

@Composable
fun LinkIconRow(
    dataList: List<LinkIconData> = defaultLinkIconList,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        dataList.map { data ->
            LinkIcon(
                modifier = Modifier.size(50.dp),
                imageUrl = data.path,
                link = data.link,
                backgroundColor = data.backgroundColor
            )
        }
    }
}
@OptIn(ExperimentalResourceApi::class)
@Composable
fun LinkIcon(
    modifier: Modifier = Modifier,
    imageUrl: String,
    link: String,
    backgroundColor: Color? = null
) {
    val iconModifier = modifier
        .clickable {
            window.open(
                link
            )
        }
        .background(
            color = backgroundColor ?: Color.Transparent,
            shape = RoundedCornerShape(4.dp)
        )
        .padding(8.dp)

    if (imageUrl.startsWith("https")) {
        AsyncImage(
            imageUrl = imageUrl,
            contentDescription = link,
            modifier = iconModifier
        )
    } else {
        Image(
            painterResource(imageUrl),
            contentDescription = link,
            modifier = iconModifier
        )
    }
}

data class LinkIconData(
    val link: String,
    val path: String,
    val backgroundColor: Color? = null
)
