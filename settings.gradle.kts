pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

rootProject.name = "jvm-library-template"
include(":fibonacci-core")
include(":fibonacci-advanced")
include(":fibonacci")
