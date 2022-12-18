package style.common

// css url() method https://developer.mozilla.org/ja/docs/Web/CSS/url
// example: backgroundImage(cssUrl("YOUR_IMAGE_PATH"))
fun cssUrl(value: String): String {
    return "url(\"$value\")"
}