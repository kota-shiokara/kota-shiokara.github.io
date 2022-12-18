package components.pages

import androidx.compose.runtime.Composable
import components.parts.LinkIconRow
import components.parts.VerticalSpacer
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.textAlign
import org.jetbrains.compose.web.dom.B
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Text
import style.common.CSSProperty
import style.sheet.AppStyleSheet

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
        H3(
            attrs = {
                style {
                    color(Color.white)
                    display(DisplayStyle.Block)
                    textAlign(CSSProperty.CENTER)
                }
            }
        ) {
            B {
                Text("Welcome to kota-shiokara's portfolio")
            }
        }
        VerticalSpacer(20)
        LinkIconRow()
    }
}