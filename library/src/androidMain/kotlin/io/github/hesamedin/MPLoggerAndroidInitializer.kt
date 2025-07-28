package io.github.hesamedin

import android.content.Context
import okio.Path.Companion.toOkioPath

/**
 * This object is used to initialize the MPLogger library for Android.
 * It provides the necessary context to set up the logging system.
 *
 * Usage: In your Application class (or wherever you initialize your library)
 * call the `LibraryAndroidInitializer.init()` method with the application context.
 * ```
 * import android.app.Application
 *
 * class MyApplication : Application() {
 *     override fun onCreate() {
 *         super.onCreate()
 *         LibraryAndroidInitializer.init(this) // Pass the application context
 *     }
 * }
 * ```
 */
object MPLoggerAndroidInitializer {

    fun init(context: Context) {
        val androidCachePathProvider = {
            context.cacheDir.toOkioPath()
        }

        // Initialize your common KMP library module
        MPLogger.initialize(
            platform = "Android",
            platformLogDirectoryPathProvider = androidCachePathProvider
        )
    }
}
