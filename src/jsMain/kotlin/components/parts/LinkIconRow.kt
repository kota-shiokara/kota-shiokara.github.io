package components.parts

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img

val defaultLinkIconList = listOf(
    LinkIconData(
        href = "https://github.com/kota-shiokara",
        src = "https://github.githubassets.com/favicons/favicon-dark.svg"
    ),
    LinkIconData(
        href = "https://qiita.com/kotambourine",
        src = "./img/qiita.png"
    ),
    LinkIconData(
        href = "https://zenn.dev/kota_shiokara",
        src = "./img/zenn.svg"
    )
)

@Composable
fun LinkIconRow(dataList: List<LinkIconData> = defaultLinkIconList) {
    if (dataList.isEmpty()) return

    Div(
        attrs = {
            style {
                display(DisplayStyle.Flex)
            }
        }
    ) {
        LinkIcon(
            href = dataList[0].href,
            src = dataList[0].src
        )
        if (dataList.size >= 2) {
            (1 until dataList.size)
                .map { dataList[it] }
                .forEach { data ->
                    HorizontalSpacer()
                    LinkIcon(data)
                }
        }
    }
}

@Composable
fun LinkIcon(href: String, src: String) {
    A(
        href = href
    ) {
        Img(
            src = src,
            attrs = {
                style {
                    /* 丸めるとロゴのガイドライン違反になる気がする...！！ */
                    /* borderRadius(50.percent) */
                    width(32.px)
                    height(32.px)
                }
            }
        )
    }
}

@Composable
fun LinkIcon(data: LinkIconData) {
    LinkIcon(data.href, data.src)
}

data class LinkIconData(
    val href: String,
    val src: String
)