
import components.pages.MainPage
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.renderComposable
import style.layout.PageLayout
import style.sheet.AppStyleSheet

fun main() {
    renderComposable(rootElementId = "root") {
        Style(AppStyleSheet)
        PageLayout {
            MainPage()
        }
    }
}

