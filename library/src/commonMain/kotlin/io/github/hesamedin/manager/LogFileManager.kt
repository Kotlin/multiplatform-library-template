package io.github.hesamedin.manager

import okio.FileSystem
import okio.IOException
import okio.Path
import okio.SYSTEM
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
fun getCurrentInstant(): Instant = Clock.System.now()

internal class LogFileManager(
    private val logDirectoryPathProvider: () -> Path,
    val fileSystem: FileSystem = FileSystem.SYSTEM,
) {

    companion object {
        private const val LOG_FILE_NAME = "log_file.log"
        private const val LOG_FILE_BACKUP_NAME = "log_file_backup.log"

        /**
         * Maximum size of the log file in bytes.
         */
        private const val MAX_LOG_FILE_LENGTH_BYTES = 10_240_200

    }

    private var logFilePath: Path? = null
    private val logFileDirectory: Path by lazy { logDirectoryPathProvider() }

    init {
        initializeLogFile()
    }

    private fun initializeLogFile() {
        try {
            // Ensure the directory exists
            fileSystem.createDirectories(logFileDirectory)
            logFilePath = logFileDirectory / LOG_FILE_NAME // Okio's Path allows '/' for joining

            logFilePath?.let { path ->
                if (fileSystem.exists(path)) {
                    try {
                        val backupLogFilePath = logFileDirectory / LOG_FILE_BACKUP_NAME
                        fileSystem.copy(logFilePath!!, backupLogFilePath) // Backup the existing log file
                        uploadBackupLogFile(backupLogFilePath)
                        fileSystem.delete(logFilePath!!)
                        write("Previous log file backed up and deleted.")
                    } catch (e: IOException) {
                        // Failed to delete, maybe still log it or handle
                        write("Warning: Could not delete existing log file at $path: ${e.message}")
                    }
                }
            }
        } catch (e: IOException) { // Catch Okio's IOException specifically
            write("Error during log file manager initialization: ${e.message}")
        } catch (e: Exception) {
            write("Unexpected error during log file initialization: ${e.message}")
        }
    }

    fun write(message: String) {
        // This would be your actual KMP logging implementation (e.g., appending to the file)
        println("LogFileManager: $message")
    }

    private fun uploadBackupLogFile(path: Path) {
        // Implement the logic to upload the backup log file if needed
        // This could involve network operations, which are platform-specific
        // For now, we will just print a message
        println("Backup log file at $path, uploaded successfully.")
    }
}