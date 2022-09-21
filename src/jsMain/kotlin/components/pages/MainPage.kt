package components.pages

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.DirType
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Text
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
            src = "./img/favicon.ico",
            attrs = {
                style {
                    display(DisplayStyle.Block)
                    margin(MarginStyle.AUTO)
                }
            }
        )
        Div { Text("Welcome to kota-shiokara's portfolio") }
    }
}