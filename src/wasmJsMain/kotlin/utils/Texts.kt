package utils

import kotlinx.browser.window

enum class Texts(
    private val ja: String,
    private val en: String = ja
) {
    AppName(
        "kota-shiokara's portfolio"
    ),
    WelcomeToPortfolio(
        "Welcome to kota-shiokara's portfolio!"
    ),
    TopPageFooterText(
        "© 2023 kota-shiokara | All Rights Reserved",
    ),
    AboutMe(
        "About Me",
    );

    override fun toString(): String {
        return when (languageCode) {
            LanguageCode.JA -> ja
            else -> en
        }
    }

    // TODO: 動作確認できてない
    companion object {
        private val isJapanese = window.navigator.language == "ja"
        var languageCode: LanguageCode = if (isJapanese) LanguageCode.JA else LanguageCode.EN
    }
}

enum class LanguageCode {
    JA, EN;
}