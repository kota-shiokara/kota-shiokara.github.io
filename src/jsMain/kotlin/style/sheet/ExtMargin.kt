package style.sheet

import org.jetbrains.compose.web.css.StylePropertyEnum
import org.jetbrains.compose.web.css.StyleScope
import org.jetbrains.compose.web.css.name
import org.jetbrains.compose.web.css.value

/*
* These are extension functions that can use the String.
* Because "auto" is not found in CSSNumeric.
*
* If you see this code and find "auto", please tell me in the issue!
* @auther kota-ikanoshiokara
*/

// https://developer.mozilla.org/en-US/docs/Web/CSS/margin
fun StyleScope.margin(vararg value: String) {
    // margin hasn't Typed OM yet
    property("margin", value.joinToString(" "))
}

fun StyleScope.margin(value: MarginStyle) {
    property("margin", value.value)
}

// https://developer.mozilla.org/en-US/docs/Web/CSS/margin-bottom
fun StyleScope.marginBottom(value: String) {
    property("margin-bottom", value)
}

// https://developer.mozilla.org/en-US/docs/Web/CSS/margin-left
fun StyleScope.marginLeft(value: String){
    property("margin-left", value)
}

// https://developer.mozilla.org/en-US/docs/Web/CSS/margin-right
fun StyleScope.marginRight(value: String) {
    property("margin-right", value)
}

// https://developer.mozilla.org/en-US/docs/Web/CSS/margin-top
fun StyleScope.marginTop(value: String) {
    property("margin-top", value)
}

interface MarginStyle: StylePropertyEnum {
    companion object {
        inline val AUTO get() = MarginStyle("auto")
    }
}
fun MarginStyle(value: String) =  value.unsafeCast<MarginStyle>()