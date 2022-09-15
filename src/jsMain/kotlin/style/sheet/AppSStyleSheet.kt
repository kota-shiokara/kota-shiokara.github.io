package style.sheet

import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.margin
import org.jetbrains.compose.web.css.px

object AppStyleSheet : StyleSheet() {
    val universalStyle by style {
        this.universal.style {
            margin(0.px)
        }
    }
}