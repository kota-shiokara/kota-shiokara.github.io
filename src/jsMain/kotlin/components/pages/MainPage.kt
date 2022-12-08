package components.pages

import androidx.compose.runtime.Composable
import components.parts.LinkIconRow
import components.parts.VerticalSpacer
import org.jetbrains.compose.web.attributes.DirType
import org.jetbrains.compose.web.attributes.alt
import org.jetbrains.compose.web.attributes.src
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.dom.Img
import org.w3c.dom.HTMLImageElement
import style.sheet.AppStyleSheet
import style.sheet.MarginStyle
import style.sheet.margin

@Composable
fun MainPage() {
    Div(
        attrs = {
            classes(AppStyleSheet.centerStyle)
        }
    ) {
        Img(
            src = "https://avatars.githubusercontent.com/u/50353938?s=96&v=4",
            attrs = {
                classes(AppStyleSheet.centerStyle)
                style {
                    borderRadius(50.percent)
                }
                attr("onerror", "this.src='./img/favicon.ico'")
            }
        )
        VerticalSpacer()
        Div(
            attrs = {
                style {
                    color(Color.white)
                    display(DisplayStyle.Block)
                }
            }
        ) { Text("Welcome to kota-shiokara's portfolio") }
        VerticalSpacer(20)
        LinkIconRow()
    }
}