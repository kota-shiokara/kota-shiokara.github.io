package utils

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

    companion object {
        var languageCode: LanguageCode = if (isJapanese) LanguageCode.JA else LanguageCode.EN
    }
}

expect val isJapanese: Boolean

enum class LanguageCode {
    JA, EN;
}