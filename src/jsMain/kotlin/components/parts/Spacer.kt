package components.parts

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.margin
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div

@Composable
fun VerticalSpacer() {
    Div(
        attrs = {
            style {
                display(DisplayStyle.Block)
                margin(10.px, 0.px)
            }
        }
    )
}

@Composable
fun VerticalSpacer(value: Int) {
    Div(
        attrs = {
            style {
                display(DisplayStyle.Block)
                margin(value.px, 0.px)
            }
        }
    )
}

@Composable
fun HorizontalSpacer() {
    Div(
        attrs = {
            style {
                display(DisplayStyle.Block)
                margin(0.px, 10.px)
            }
        }
    )
}

@Composable
fun HorizontalSpacer(value: Int) {
    Div(
        attrs = {
            style {
                display(DisplayStyle.Block)
                margin(0.px, value.px)
            }
        }
    )
}