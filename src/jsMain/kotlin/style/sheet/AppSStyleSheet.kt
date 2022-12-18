package style.sheet

import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.css.vw
import org.jetbrains.compose.web.css.width


object AppStyleSheet : StyleSheet() {
    val pageStyle by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        property("box-sizing", "border-box")

        // background
        backgroundColor(Color("#F5B1AA"))
//        backgroundImage(cssUrl("./img/Kota_Background.png"))
//        backgroundPosition(CSSProperty.CENTER)
//        backgroundSize("cover")

        height(100.vh)
        width(100.vw)
    }

    val centerStyle by style {
        display(DisplayStyle.Block)
        margin(MarginStyle.AUTO)
    }
}