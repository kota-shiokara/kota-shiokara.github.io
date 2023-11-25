package component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.browser.window

private val defaultLinkIconList = listOf(
    LinkIconData(
        link = "https://github.com/kota-shiokara",
        path = "https://github.githubassets.com/favicons/favicon-dark.svg"
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

@Composable
fun LinkIconRow(dataList: List<LinkIconData> = defaultLinkIconList) {
    Row {
        dataList.map { data ->
            LinkIcon(
                data
            ) {
                window.open(
                    data.link
                )
            }
            Divider(modifier = Modifier.width(8.dp))
        }
    }
}
@Composable
fun LinkIcon(
    linkIconData: LinkIconData,
    enabled: Boolean = false,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .size(48.dp)
            .background(Color.Black)
            .clickable {
                if (enabled) onClick()
            }
    )
}

data class LinkIconData(
    val link: String,
    val path: String
)
