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
import jp.ikanoshiokara.kota_shiokara.github.io.generated.resources.Res
import jp.ikanoshiokara.kota_shiokara.github.io.generated.resources.instagram_logo
import jp.ikanoshiokara.kota_shiokara.github.io.generated.resources.qiita
import jp.ikanoshiokara.kota_shiokara.github.io.generated.resources.x_logo
import jp.ikanoshiokara.kota_shiokara.github.io.generated.resources.zenn_logo
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import utils.openWindow

private val defaultLinkIconList: List<LinkIconData> = listOf(
    LinkIconData.RemoteLinkIconData(
        link = "https://github.com/kota-shiokara",
        path = "https://github.githubassets.com/favicons/favicon-dark.png",
    ),
    LinkIconData.LocalLinkIconData(
        link = "https://twitter.com/shiokara_create",
        path = Res.drawable.x_logo,
        backgroundColor = Color.Black
    ),
    LinkIconData.LocalLinkIconData(
        link = "https://www.instagram.com/kota_bellflower",
        path = Res.drawable.instagram_logo
    ),
    LinkIconData.LocalLinkIconData(
        link = "https://qiita.com/kotambourine",
        path = Res.drawable.qiita
    ),
    LinkIconData.LocalLinkIconData(
        link = "https://zenn.dev/kota_shiokara",
        path = Res.drawable.zenn_logo
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
            when (data) {
                is LinkIconData.RemoteLinkIconData -> {
                    RemoteLinkIcon(
                        modifier = Modifier.size(50.dp),
                        imageUrl = data.path,
                        link = data.link,
                        backgroundColor = data.backgroundColor
                    )
                }
                is LinkIconData.LocalLinkIconData -> {
                    LocalLinkIcon(
                        modifier = Modifier.size(50.dp),
                        res = data.path,
                        link = data.link,
                        backgroundColor = data.backgroundColor
                    )
                }
            }
        }
    }
}

@Composable
fun RemoteLinkIcon(
    modifier: Modifier = Modifier,
    imageUrl: String,
    link: String,
    backgroundColor: Color? = null
) {
    val iconModifier = modifier
        .clickable {
            openWindow(link)
        }
        .background(
            color = backgroundColor ?: Color.Transparent,
            shape = RoundedCornerShape(4.dp)
        )
        .padding(8.dp)

    AsyncImage(
        imageUrl = imageUrl,
        contentDescription = link,
        modifier = iconModifier
    )
}

@Composable
fun LocalLinkIcon(
    modifier: Modifier = Modifier,
    res: DrawableResource,
    link: String,
    backgroundColor: Color? = null
) {
    val iconModifier = modifier
        .clickable {
            openWindow(link)
        }
        .background(
            color = backgroundColor ?: Color.Transparent,
            shape = RoundedCornerShape(4.dp)
        )
        .padding(8.dp)

    Image(
        painterResource(res),
        contentDescription = link,
        modifier = iconModifier
    )
}

sealed interface LinkIconData {
    val link: String
    val backgroundColor: Color?

    data class RemoteLinkIconData(
        override val link: String,
        val path: String,
        override val backgroundColor: Color? = null
    ): LinkIconData

    data class LocalLinkIconData(
        override val link: String,
        val path: DrawableResource,
        override val backgroundColor: Color? = null
    ): LinkIconData
}