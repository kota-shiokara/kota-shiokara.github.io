package components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import org.jetbrains.compose.web.dom.*
import react.RBuilder
import org.w3c.dom.HTMLElement
import react.dom.render
import react.dom.unmountComponentAtNode

@Composable
fun ElementScope<HTMLElement>.ReactComponent(
    key: Any?,
    content: RBuilder.() -> Unit
) {
    DisposableEffect(key) {
        render(scopeElement) {
            content()
        }
        onDispose {  }
    }

    DisposableEffect(Unit) {
        onDispose {
            unmountComponentAtNode(scopeElement)
        }
    }
}