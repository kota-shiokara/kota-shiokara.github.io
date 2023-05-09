package components.parts

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.browser.window
import utils.painterResource

private val defaultLinkIconList = listOf(
    LinkIconData(
        link = "https://github.com/kota-shiokara",
        path = "https://github.githubassets.com/favicons/favicon-dark.svg"
    ),
    LinkIconData(
        link = "https://twitter.com/shiokara_create",
        path = "./img/twitter.svg"
    ),
    LinkIconData(
        link = "https://www.instagram.com/kota_bellflower",
        path = "./img/instagram.svg"
    ),
    LinkIconData(
        link = "https://qiita.com/kotambourine",
        path = "./img/qiita.png"
    ),
    LinkIconData(
        link = "https://zenn.dev/kota_shiokara",
        path = "./img/zenn.svg"
    )
)

@Composable
fun LinkIconRow(dataList: List<LinkIconData> = defaultLinkIconList) {
    Row {
        val first = dataList.first()
        LinkIcon(first)

        (1 until dataList.size).map { index ->
            Divider(modifier = Modifier.width(8.dp))
            val data = dataList[index]
            LinkIcon(data)
        }
    }
}
@Composable
fun LinkIcon(linkIconData: LinkIconData) {
    Image(
        painter = painterResource(linkIconData.path),
        contentDescription = null,
        modifier = Modifier.size(48.dp).clickable {
            window.open(
                linkIconData.link
            )
        }
    )
}

data class LinkIconData(
    val link: String,
    val path: String
)