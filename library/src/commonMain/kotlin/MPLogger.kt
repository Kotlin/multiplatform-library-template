package io.github.hesamedin.logger

expect val firstElement: Int
expect val secondElement: Int

class MPLogger: IMPLoggerRepository {

    companion object {
        private const val TAG = "MPLogger"

        fun log(message: String) {
            println("$TAG: $message")
        }

        fun logError(message: String, e: Throwable? = null) {
            println("$TAG ERROR: $message")
            e?.printStackTrace()
        }

        fun logDebug(message: String) {
            println("$TAG DEBUG: $message")
        }
    }
}
