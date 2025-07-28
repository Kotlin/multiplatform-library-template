package io.github.hesamedin

import okio.Path.Companion.toPath
import platform.Foundation.NSCachesDirectory
import platform.Foundation.NSSearchPathForDirectoriesInDomains
import platform.Foundation.NSUserDomainMask

/**
 * This object is used to initialize the MPLogger library for iOS.
 * It provides the necessary path to the cache directory for logging.
 *
 * Usage: In your AppDelegate or wherever you initialize your library,
 * call the `MPLoggerIOSInitializer.init()` method.
 * ```
 * import UIKit
 *
 * @UIApplicationMain
 * class AppDelegate: UIResponder, UIApplicationDelegate {
 *     func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
 *         MPLoggerIOSInitializer.init() // Initialize the logger
 *         return true
 *     }
 * }
 * ```
 */
object MPLoggerIOSInitializer {

    fun init() {
        val iosCachePathProvider = {
            val cacheDir = NSSearchPathForDirectoriesInDomains(
                directory = NSCachesDirectory,
                domainMask = NSUserDomainMask,
                expandTilde = true
            ).firstOrNull() as? String
                ?: error("Could not get cache directory path in iOS")
            cacheDir.toPath()
        }
        MPLogger.initialize(
            platform = "iOS",
            platformLogDirectoryPathProvider = iosCachePathProvider
        )
    }

}
