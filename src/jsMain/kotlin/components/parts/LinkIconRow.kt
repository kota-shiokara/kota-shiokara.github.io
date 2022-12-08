package components.parts

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img

@Composable
fun LinkIconRow() {
    Div(
        attrs = {
            style {
                display(DisplayStyle.Flex)
            }
        }
    ) {
        LinkIcon(
            href = "https://github.com/kota-shiokara",
            src = "https://github.githubassets.com/favicons/favicon-dark.svg"
        )
        HorizontalSpacer()
        LinkIcon(
            href = "https://github.com/kota-shiokara",
            src = "https://github.githubassets.com/favicons/favicon-dark.svg"
        )
    }
}

@Composable
fun LinkIconRow(dataList: List<LinkIconData>) {
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
                    borderRadius(50.percent)
                }
            }
        )
    }
}

@Composable
fun LinkIcon(data: LinkIconData) {
    A(
        href = data.href
    ) {
        Img(
            src = data.src,
            attrs = {
                style {
                    borderRadius(50.percent)
                }
            }
        )
    }
}

data class LinkIconData(
    val href: String,
    val src: String
)