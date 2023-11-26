package component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.browser.window
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import utils.Log

private val defaultLinkIconList = listOf(
    LinkIconData(
        link = "https://github.com/kota-shiokara",
        path = "https://github.githubassets.com/favicons/favicon-dark.png"
    ),
    LinkIconData(
        link = "https://twitter.com/shiokara_create",
        path = "img/twitter.svg"
    ),
    LinkIconData(
        link = "https://www.instagram.com/kota_bellflower",
        path = "img/instagram.svg"
    ),
    LinkIconData(
        link = "https://qiita.com/kotambourine",
        path = "img/qiita.png"
    ),
    LinkIconData(
        link = "https://zenn.dev/kota_shiokara",
        path = "img/zenn.svg"
    )
)

@OptIn(ExperimentalResourceApi::class)
@Composable
fun LinkIconRow(
    dataList: List<LinkIconData> = defaultLinkIconList,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        dataList.map { data ->

            if (data.path.startsWith("https")) {
                LinkIcon(
                    data.path
                ) {
                    window.open(
                        data.link
                    )
                }
            } else {
                Image(
                    painterResource(data.path),
                    contentDescription = "",
                    modifier = Modifier.size(50.dp).clickable {
                        window.open(
                            data.link
                        )
                    }
                )
            }

            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}
@Composable
fun LinkIcon(
    imageUrl: String,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    AsyncImage(
        imageUrl = imageUrl,
        contentDescription = "",
        modifier = modifier
            .size(50.dp)
            .clickable {
                if (onClick != null) {
                    onClick()
                }
            }
    )
}

data class LinkIconData(
    val link: String,
    val path: String
)
