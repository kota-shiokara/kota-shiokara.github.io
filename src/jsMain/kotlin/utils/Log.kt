package utils

class Log(
    val tag: String = "NO TAG",
) {

    companion object {
        fun d(tag: String = "", res: String) {
            log(tag, res)
        }

        private fun log(tag: String, res: String) {
            println("$tag: $res")
        }
    }
}