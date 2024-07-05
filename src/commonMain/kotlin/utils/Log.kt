package utils

abstract class Log {
    abstract fun d(tag: String = defaultTag(), res: Any)
    abstract fun i(tag: String = defaultTag(), res: Any)
    abstract fun w(tag: String = defaultTag(), res: Any)

    abstract fun e(tag: String = defaultTag(), error: Throwable)

    var tag: String? = null

    companion object LogImpl : Log() {
        private const val DEFAULT_TAG: String = "NO TAG"

        fun tag(tag: String): Log {
            this.tag = tag
            return this
        }

        private fun defaultTag(): String {
            return this.tag ?: DEFAULT_TAG
        }

        override fun d(tag: String, res: Any) {
            log(Level.DEBUG, tag, res)
        }

        override fun i(tag: String, res: Any) {
            log(Level.INFO, tag, res)
        }

        override fun w(tag: String, res: Any) {
            log(Level.WARN, tag, res)
        }

        override fun e(tag: String, error: Throwable) {
            log(Level.ERROR, tag, error)
        }

        private fun log(
            level: String,
            tag: String,
            res: Any
        ) {
            println("$level $tag: $res")
        }
    }

    class Level {
        companion object {
            const val DEBUG: String = "[Debug]"
            const val INFO: String = "[Info]"
            const val WARN: String = "[Warn]"
            const val ERROR: String = "[Error]"
        }
    }
}