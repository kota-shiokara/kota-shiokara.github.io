package utils

import kotlinx.browser.window

enum class Texts(
    private val ja: String,
    private val en: String = ja
) {
    WelcomeToPortfolioLabel(
        "Welcome to kota-shiokara's portfolio!"
    ),
    AboutMeSectionTitleLabel(
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