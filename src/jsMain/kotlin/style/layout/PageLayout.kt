package style.layout

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Div
import style.sheet.AppStyleSheet

@Composable
fun PageLayout(content: @Composable () -> Unit) {
    Div(attrs = {
        classes(AppStyleSheet.pageStyle)
    }) {
        content()
    }
}