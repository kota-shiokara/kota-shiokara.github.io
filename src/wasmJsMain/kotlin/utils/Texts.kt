package utils

import kotlinx.browser.window

actual val isJapanese = window.navigator.language == "ja"