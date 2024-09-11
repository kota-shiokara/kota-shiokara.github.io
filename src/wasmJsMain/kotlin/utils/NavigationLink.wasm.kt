package utils

import kotlinx.browser.window

actual fun openWindow(url: String, target: String) {
    window.open(url, target)
}

actual fun openWindow(url: String) {
    window.open(url)
}