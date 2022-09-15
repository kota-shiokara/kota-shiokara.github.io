
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable
import style.layout.UniversalLayout
import style.sheet.AppStyleSheet

fun main() {
    renderComposable(rootElementId = "root") {
        Style(AppStyleSheet)
        UniversalLayout {
            Div({ style { padding(25.px) } }) {
                Text("Hello kota-shiokara's portfolio")
            }
            Div({ style { padding(25.px) } }) {
                Text("Coming soon...")
            }
        }
    }
}

