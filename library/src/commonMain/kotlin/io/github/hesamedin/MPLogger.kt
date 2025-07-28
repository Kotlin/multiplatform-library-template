package io.github.hesamedin

import io.github.hesamedin.manager.LogFileManager
import okio.Path

object MPLogger: IMPLogger {

    private const val TAG = "MPLogger"

    private var isInitialized = false
    private lateinit var logFileManagerInstance: LogFileManager

    // This is what the Android/iOS specific code will call
    override fun initialize(
        platform: String,
        platformLogDirectoryPathProvider: () -> Path
    ) {
        if (isInitialized) return

        logFileManagerInstance = LogFileManager(
            logDirectoryPathProvider = platformLogDirectoryPathProvider
        )
        isInitialized = true
        log("$TAG initialized in $platform platform.")
    }

    override fun log(message: String) {
        require(isInitialized) { "MPLogger must be initialized before logging." }
        logFileManagerInstance.write(message)
    }
}
