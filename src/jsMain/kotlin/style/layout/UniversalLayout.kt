package style.layout

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Div
import style.sheet.AppStyleSheet

@Composable
fun UniversalLayout(content: @Composable () -> Unit) {
    Div(attrs = {
        AppStyleSheet.universalStyle
    }) {
        content()
    }
}