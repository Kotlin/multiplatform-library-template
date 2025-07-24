package io.github.hesamedin.logger.manager

import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
fun getCurrentInstant(): Instant = Clock.System.now()

internal class LogFileManager {

    companion object {
        /**
         * Name of the log file
         */
        private const val LOG_FILE_NAME = "log_file.log"

        /**
         * Maximum size of the log file in bytes.
         */
        private const val MAX_LOG_FILE_LENGTH_BYTES = 10_240_200

    }

    private var mFile: File? = null
}