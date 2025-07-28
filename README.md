[![Awesome](https://awesome.re/badge.svg)](https://awesome.re) 
[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Made With Love](https://img.shields.io/badge/Made%20With-Love-orange.svg)](https://github.com/chetanraj/awesome-github-badges)
[![official project](http://jb.gg/badges/official.svg)](https://github.com/JetBrains#jetbrains-on-github)
[![Java CI with Gradle](https://github.com/Hesamedin/multiplatform-logger/actions/workflows/gradle.yml/badge.svg?branch=main)](https://github.com/Hesamedin/multiplatform-logger/actions/workflows/gradle.yml)
![GitHub Release](https://img.shields.io/github/v/release/hesamedin/multiplatform-logger)


# Logger Multiplatform library

## What is it?

This repository facilitates logging and storing the generated log file on Firebase. We use [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html) library that is deployable to [Maven Central](https://central.sonatype.com/).

The library has the following functions. Also, it has a test for each platform just to be sure that tests run.
1. log(message: String) - logs the message to the console.
2. logToFile(message: String) - logs the message to a file.
3. uploadLogToFirebase() - uploads the log file to Firebase.

This repository's forked from the [Kotlin Multiplatform Library Template](https://github.com/Kotlin/multiplatform-library-template).

## Supported Platforms
The repository supports the following platforms:
|  | Platforms |
| ------ | ------ |
| Android | **Yes** |
| iOS | **Yes** |
| Java | No |
| Linux | No |
| Windows | No |

## How to use it?

### Dependencies
ou can download the library from Maven Central repository at https://central.sonatype.com/search?q=io.github.hesamedin.
Make sure to get the right build for your platform.

### Configuration
To use this library, you need to initialize it with platform-specific configurations, particularly for setting up the log file directory.

#### Android Configuration
The library requires the Android `Context` to determine a suitable directory (e.g., cache directory) for storing log files. You should initialize the library, typically in your `Application` class or using a dependency injection framework, by providing a path provider function.
```kotlin
    class MyApplication : Application() {
        override fun onCreate() {
            super.onCreate()

            // Simply call the initializer
            AndroidLoggerInitializer.init(this)

            // Now you can use the logger
            MultiplatformLogger.log("MyApplication: Logger has been initialized.")
        }
    }
```

#### iOS Configuration
Update the AppDelegate to initialize the logger with a directory path for storing log files. This is typically done in the `application:didFinishLaunchingWithOptions:` method.
```swift
import UIKit

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        // Simply call the initializer
        MPLoggerIOSInitializer.init()

        // Now you can use the logger
        MultiplatformLogger.log("MyApplication: Logger has been initialized.")
    }
}
```

## How to contribute?
TBD
