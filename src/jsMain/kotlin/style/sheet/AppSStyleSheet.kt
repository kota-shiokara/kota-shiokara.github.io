package style.sheet

import org.jetbrains.compose.web.css.*

object AppStyleSheet : StyleSheet() {
    val pageStyle by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        property("box-sizing", "border-box")
        height(100.vh)
        width(100.vw)
    }

    val centerStyle by style {
        display(DisplayStyle.Block)
        margin(MarginStyle.AUTO)
    }
}